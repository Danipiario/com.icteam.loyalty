package com.icteam.loyalty.common.internal.provider;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.icteam.loyalty.common.annotations.Where;
import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorLoginDTO;
import com.icteam.loyalty.common.dto.OperatorSearchDTO;
import com.icteam.loyalty.common.interfaces.IEnum;
import com.icteam.loyalty.common.interfaces.IGroup;
import com.icteam.loyalty.common.internal.Messages;
import com.icteam.loyalty.common.model.Operator;
import com.icteam.loyalty.common.service.AuthService;
import com.icteam.loyalty.common.service.CryptService;
import com.icteam.loyalty.common.service.DTOService;
import com.icteam.loyalty.common.service.EnumService;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.ComparableExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.RelationalPathBase;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.SQLQueryFactory;

@Component
public class AuthProvider implements AuthService {

	@Reference
	private CryptService cryptService;

	@Reference
	private DTOService dtoService;

	@Reference
	private EnumService enumService;

	@Reference
	private DataSource dataSource;

	@Reference
	private Configuration configuration;

	private SQLQuery<Tuple> from;

	@Override
	public OperatorDTO login(OperatorLoginDTO operatorLoginDTO) {
		final SQLQueryFactory queryFactory = new SQLQueryFactory(configuration, dataSource);

		final Operator o = new Operator("o");

		from = queryFactory.select(o.all()).from(o);

		buildWheres(operatorLoginDTO, o);

		final Tuple tuple = from.fetchOne();

		assert tuple != null : Messages.get().operator_not_found;

		final OperatorDTO operatorDTO = extractOperatorDTO(o, tuple);

		return operatorDTO;
	}

	private OperatorDTO extractOperatorDTO(final Operator o, final Tuple tuple) {
		final OperatorDTO operatorDTO = dtoService.newDTO(OperatorDTO.class);
		operatorDTO.setChangePassword(BooleanUtils.toBooleanObject(tuple.get(o.changePassword)));
		operatorDTO.setLogin(tuple.get(o.login));
		operatorDTO.setName(tuple.get(o.name));
		operatorDTO.setSurname(tuple.get(o.surname));

		final String[] groups = StringUtils.split(StringUtils.defaultString(tuple.get(o.groups)), ",");
		operatorDTO.setGroups(
				Stream.of(groups).map(group -> enumService.value(IGroup.class, group)).collect(Collectors.toList()));

		return operatorDTO;
	}

	@Override
	public List<OperatorDTO> search(OperatorSearchDTO operatorSearchDTO) {
		final SQLQueryFactory queryFactory = new SQLQueryFactory(configuration, dataSource);

		final Operator o = new Operator("o");
		from = queryFactory.select(o.all()).from(o);

		buildWheres(operatorSearchDTO, o);

		List<OperatorDTO> operatorDTOs = new ArrayList<>();

		try {
			final List<Tuple> tuples = from.fetch();

			operatorDTOs = tuples.stream().map(tuple -> extractOperatorDTO(o, tuple)).collect(Collectors.toList());
		} catch (final IllegalArgumentException e) {
			e.printStackTrace();
		}

		return operatorDTOs;
	}

	private <M extends RelationalPathBase<M>> void buildWheres(IDTO dto, final M model) {
		final Map<String, Where> wheres = Stream.of(dto.getClass().getDeclaredFields())
				.filter(f -> f.isAnnotationPresent(Where.class))
				.collect(Collectors.toMap(Field::getName, f -> f.getAnnotation(Where.class)));
		model.getColumns().stream().filter(p -> wheres.containsKey(p.getMetadata().getName())).forEach(path -> {
			final String name = path.getMetadata().getName();
			try {
				where(path, wheres.get(name), PropertyUtils.getProperty(dto, name));
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				e.printStackTrace();
			}
		});
	}

	private <T> void where(Path<?> expression, Where where, T right) {
		if (right != null) {
			T _right = right;

			if (where.crypt()) {
				_right = (T) cryptService.encrypt((String) _right);
			}

			switch (where.value()) {
			case EQUAL:
				if (_right instanceof IEnum) {
					from.where(((SimpleExpression<T>) expression).eq((T) ((IEnum)_right).name()));
				} else {
					from.where(((SimpleExpression<T>) expression).eq(_right));
				}
				break;
			case GREATER_EQUAL:
				from.where(((ComparableExpression<Comparable<T>>) expression).goe((Comparable<T>) _right));
				break;
			case LIKE_IGNORE_CASE:
				from.where(((StringExpression) expression).likeIgnoreCase((String) _right));
			default:
				break;
			}
		}
	}

}

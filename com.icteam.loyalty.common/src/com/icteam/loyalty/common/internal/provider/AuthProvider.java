package com.icteam.loyalty.common.internal.provider;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorLoginDTO;
import com.icteam.loyalty.common.dto.OperatorSearchDTO;
import com.icteam.loyalty.common.enums.EStatus;
import com.icteam.loyalty.common.interfaces.IGroup;
import com.icteam.loyalty.common.internal.Messages;
import com.icteam.loyalty.common.model.Operator;
import com.icteam.loyalty.common.service.AuthService;
import com.icteam.loyalty.common.service.CryptService;
import com.icteam.loyalty.common.service.DTOService;
import com.icteam.loyalty.common.service.EnumService;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.sql.Configuration;
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

		final String encryptPassword = cryptService.encrypt(operatorLoginDTO.password);

		final Operator o = new Operator("o");
		final Tuple tuple = queryFactory.select(o.all()).from(o).where(o.login.eq(operatorLoginDTO.login))
				.where(o.password.eq(encryptPassword)).where(o.status.eq(EStatus.ATTIVO.name())).fetchOne();

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
		final List<Tuple> tuples = where(o.login, operatorSearchDTO.getLogin()).fetch();

		List<OperatorDTO> operatorDTOs = tuples.stream().map(tuple -> extractOperatorDTO(o, tuple))
				.collect(Collectors.toList());

		return operatorDTOs;
	}

	private <T> SQLQuery<Tuple> where(SimpleExpression<T> expression, T right) {
		if (right != null) {
			return from.where(expression.eq(right));
		}

		return from;
	}

}

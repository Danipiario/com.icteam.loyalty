package com.icteam.loyalty.common.provider.internal;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.icteam.loyalty.common.annotations.Where;
import com.icteam.loyalty.common.dto.AbstractModelDTO;
import com.icteam.loyalty.common.dto.IModelDTO;
import com.icteam.loyalty.common.interfaces.IEnum;
import com.icteam.loyalty.common.interfaces.ISearchDTO;
import com.icteam.loyalty.common.service.CryptService;
import com.icteam.loyalty.common.service.DTOService;
import com.icteam.loyalty.common.service.DbService;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.ComparableExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.util.ReflectionUtils;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.RelationalPathBase;
import com.querydsl.sql.SQLQuery;
import com.querydsl.sql.SQLQueryFactory;

@Component
public class DbProvider implements DbService {

	private final Logger logger = Log.getLogger(AbstractModelDTO.class);

	@Reference
	private CryptService cryptService;

	@Reference
	private DTOService dtoService;

	@Reference
	private DataSource dataSource;

	@Reference
	private Configuration configuration;

	private SQLQueryFactory queryFactory;

	@Activate
	public void activate() {
		queryFactory = new SQLQueryFactory(configuration, dataSource);
	}

	@Override
	public <M extends RelationalPathBase<M>, S extends ISearchDTO, MD extends IModelDTO<M>> List<MD> search(S searchDTO,
			Class<MD> modelDTOClass) {
		final Optional<M> modelOpt = getNewModelInstance(modelDTOClass);

		if (modelOpt.isPresent()) {
			final M model = modelOpt.get();

			final SQLQuery<Tuple> from = queryFactory.select(model.all()).from(model);

			buildWheres(from, searchDTO, model);

			final List<Tuple> tuples = from.fetch();

			return tuples.stream().map(tuple -> {
				MD modelDto = dtoService.newDTO(modelDTOClass, false);

				modelDto.fill(tuple, model);
				modelDto.enableTrackChanges();

				return modelDto;
			}).collect(Collectors.toList());
		}

		return new ArrayList<>();
	}

	@Override
	public <M extends RelationalPathBase<M>, S extends ISearchDTO, MD extends IModelDTO<M>> Optional<MD> searchOne(
			S searchDTO, Class<MD> modelDTOClass) {
		MD modelDto = null;

		final Optional<M> modelOpt = getNewModelInstance(modelDTOClass);

		if (modelOpt.isPresent()) {
			final M model = modelOpt.get();

			final SQLQuery<Tuple> from = queryFactory.select(model.all()).from(model);

			buildWheres(from, searchDTO, model);

			final Tuple tuple = from.fetchOne();

			if (tuple != null) {
				modelDto = dtoService.newDTO(modelDTOClass, false);
				modelDto.fill(tuple, model);
				modelDto.enableTrackChanges();
			}
		}

		return Optional.ofNullable(modelDto);
	}

	@Override
	public <M extends RelationalPathBase<M>, S extends ISearchDTO, MD extends IModelDTO<M>> long count(S searchDTO,
			Class<MD> modelDTOClass) {
		final Optional<M> modelOpt = getNewModelInstance(modelDTOClass);

		if (modelOpt.isPresent()) {
			final M model = modelOpt.get();

			final SQLQuery<Tuple> from = queryFactory.select(model.all()).from(model);

			buildWheres(from, searchDTO, model);

			return from.fetchCount();
		}

		return 0l;
	}

	protected <M extends RelationalPathBase<M>, MD extends IModelDTO<M>> Optional<M> getNewModelInstance(
			Class<MD> modelDTOClass) {
		Optional<M> newModelInstance = Optional.empty();

		try {
			newModelInstance = modelDTOClass.newInstance().newModelInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			logger.warn("error creating model instance for class #" + modelDTOClass.getName(), e);
		}

		return newModelInstance;
	}

	private <M extends RelationalPathBase<M>, S extends ISearchDTO> void buildWheres(SQLQuery<Tuple> from, S searchDTO,
			final M model) {
		final Map<String, Where> wheres = ReflectionUtils.getFields(searchDTO.getClass()).stream()
				.filter(f -> f.isAnnotationPresent(Where.class))
				.collect(Collectors.toMap(Field::getName, f -> f.getAnnotation(Where.class)));
		model.getColumns().stream().filter(p -> wheres.containsKey(p.getMetadata().getName())).forEach(path -> {
			final String name = path.getMetadata().getName();
			try {
				where(from, path, wheres.get(name), PropertyUtils.getProperty(searchDTO, name));
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				e.printStackTrace();
			}
		});
	}

	private <T> void where(SQLQuery<Tuple> from, Path<?> expression, Where where, T right) {
		if (right != null) {
			T _right = right;

			if (where.crypt()) {
				_right = (T) cryptService.encrypt((String) _right);
			}

			switch (where.value()) {
			case EQUAL:
				if (_right instanceof IEnum) {
					from.where(((SimpleExpression<T>) expression).eq((T) ((IEnum) _right).name()));
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

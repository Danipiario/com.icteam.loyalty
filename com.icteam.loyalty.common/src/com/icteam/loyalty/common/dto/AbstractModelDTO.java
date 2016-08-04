package com.icteam.loyalty.common.dto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Id;

import org.apache.commons.beanutils.PropertyUtils;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

import com.querydsl.core.util.ReflectionUtils;
import com.querydsl.sql.RelationalPathBase;

public abstract class AbstractModelDTO<M extends RelationalPathBase<M>> extends AbstractDTO implements IModelDTO<M> {

	private static final long serialVersionUID = -5518989305089483914L;

	private final Logger logger = Log.getLogger(AbstractModelDTO.class);

	@Override
	public String getEditorInstanceID() {
		return getEditorID() + "." + getValueID();
	}

	@Override
	public String getEditorID() {
		return getClass().getName();
	}

	@Override
	public String getValueID() {
		final Optional<Field> id = ReflectionUtils.getFields(getClass()).stream()
				.filter(field -> field.getAnnotation(Id.class) != null).findFirst();

		String valueID = "noIdDefined";
		if (id.isPresent()) {
			try {
				valueID = Objects.toString(PropertyUtils.getProperty(this, id.get().getName()));
			} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException
					| NoSuchMethodException e) {
				e.printStackTrace();
				valueID = "getIdError";
			}
		}

		return valueID;
	}

	@Override
	public Optional<Class<M>> getModelClass() {
		try {
			return Optional
					.of((Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		} catch (final Exception e) {
			logger.warn("error get modelClass, probably you need to override getModelClass method", e);
		}

		return Optional.empty();
	}

	@Override
	public final Optional<M> newModelInstance() {
		Optional<Class<M>> modelClass = null;
		try {
			modelClass = getModelClass();

			if (modelClass.isPresent()) {
				return Optional.of(
						modelClass.get().getConstructor(String.class).newInstance(modelClass.get().getSimpleName()));
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			logger.warn("error creating instance for modelClass #" + modelClass, e);
		}

		return Optional.empty();
	}

}
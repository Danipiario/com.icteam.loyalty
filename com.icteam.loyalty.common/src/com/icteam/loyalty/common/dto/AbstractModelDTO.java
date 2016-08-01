package com.icteam.loyalty.common.dto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.Id;

import org.apache.commons.beanutils.PropertyUtils;

import com.querydsl.core.util.ReflectionUtils;
import com.querydsl.sql.RelationalPathBase;

public abstract class AbstractModelDTO<M extends RelationalPathBase<M>> extends AbstractDTO<M> implements IModelDTO<M> {

	private static final long serialVersionUID = -5518989305089483914L;

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

}
package com.icteam.loyalty.common.ui.interfaces;

import java.beans.PropertyChangeListener;
import java.lang.reflect.Field;
import java.util.Map;

import org.eclipse.core.databinding.conversion.IConverter;

import com.icteam.loyalty.common.annotations.Validated;
import com.icteam.loyalty.common.dto.IDTO;

public interface IDTOProperty<M extends IDTO, S extends Object> {

	boolean isPassword();

	boolean isRequired();

	boolean isEnabled();

	boolean isDirty();

	Validated getValidated();

	M getModel();

	String getProperty();

	void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);

	void removePropertyChangeListener(PropertyChangeListener listener);

	void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);

	void addPropertyChangeListener(PropertyChangeListener listener);

	void setPropertyValue(S propertyValue);

	S getPropertyValue();

	IConverter getTargetConverter();

	IConverter getModelConverter();

	Map<Integer, PropertyChangeListener> getPropertyChangeListeners();

	void initialize();

	Class<S> getNestedPropertyClass();

	Class<?> getNestedModelClass();

	String getNestedProperty();

	Field getFieldProperty();

}

package com.icteam.loyalty.ui.interfaces;

import java.beans.PropertyChangeListener;
import java.lang.reflect.Field;
import java.util.Map;

import org.eclipse.core.databinding.conversion.IConverter;

import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.model.interfaces.Validated;

public interface IModelProperty<M extends IModel, S extends Object> {

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

    Class< ? > getNestedModelClass();

    String getNestedProperty();

    Field getFieldProperty();

}

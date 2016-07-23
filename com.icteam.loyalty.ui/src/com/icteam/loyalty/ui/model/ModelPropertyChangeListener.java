package com.icteam.loyalty.ui.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.ref.WeakReference;

import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.ui.interfaces.IModelProperty;

public class ModelPropertyChangeListener<M extends IModel, S extends Object> implements PropertyChangeListener {

    private final WeakReference<IModelProperty<M, S>> modelProperty;

    public ModelPropertyChangeListener(IModelProperty<M, S> modelProperty) {
        this.modelProperty = new WeakReference<>(modelProperty);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        modelProperty.get().initialize();
    }

    public static <M extends IModel, S extends Object> void addListener(IModelProperty<M, S> modelProperty, Object bean, String property, int level) {
        if (bean instanceof IDtoModel) {
            PropertyChangeListener listener = modelProperty.getPropertyChangeListeners().get(level);
            ((IDtoModel) bean).removePropertyChangeListener(property, listener);

            listener = new ModelPropertyChangeListener<>(modelProperty);

            ((IDtoModel) bean).addPropertyChangeListener(property, listener);
            modelProperty.getPropertyChangeListeners().put(level, listener);
        }
    }
}
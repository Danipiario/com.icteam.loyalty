package com.icteam.loyalty.common.ui.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.ref.WeakReference;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.ui.interfaces.IDTOProperty;

public class ModelPropertyChangeListener<M extends IDTO, S extends Object> implements PropertyChangeListener {

	private final WeakReference<IDTOProperty<M, S>> modelProperty;

	public ModelPropertyChangeListener(IDTOProperty<M, S> modelProperty) {
		this.modelProperty = new WeakReference<>(modelProperty);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		modelProperty.get().initialize();
	}

	public static <M extends IDTO, S extends Object> void addListener(IDTOProperty<M, S> modelProperty, Object bean,
			String property, int level) {
		if (bean instanceof IDTO) {
			PropertyChangeListener listener = modelProperty.getPropertyChangeListeners().get(level);
			((IDTO) bean).removePropertyChangeListener(property, listener);

			listener = new ModelPropertyChangeListener<>(modelProperty);

			((IDTO) bean).addPropertyChangeListener(property, listener);
			modelProperty.getPropertyChangeListeners().put(level, listener);
		}
	}
}
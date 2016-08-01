package com.icteam.loyalty.common.dto;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Objects;
import java.util.Optional;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

import com.querydsl.sql.RelationalPathBase;

public abstract class AbstractDTO<M extends RelationalPathBase<M>> implements IDTO<M> {

	private static final long serialVersionUID = 3428162022541395275L;

	private final Logger logger = Log.getLogger(AbstractDTO.class);

	private final PropertyChangeSupport changeSupport;
	private boolean _new = true;
	private boolean dirty = false;
	private boolean editable = true;

	private transient final PropertyChangeListener dirtyListener = evt -> {
		_new = false;
		if (!evt.getPropertyName().equals("dirty") && !evt.getPropertyName().equals("editable")) {
			setDirty(true);
		}
	};

	public AbstractDTO() {
		changeSupport = new PropertyChangeSupport(this);
	}

	@Override
	public void enableTrackChanges() {
		changeSupport.removePropertyChangeListener(dirtyListener);
		changeSupport.addPropertyChangeListener(dirtyListener);
	}

	protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		if (!Objects.equals(oldValue, newValue)) {
			changeSupport.firePropertyChange(propertyName, oldValue, newValue);
		}
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(propertyName, listener);
	}

	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(propertyName, listener);
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

	protected Optional<Class<M>> getModelClass() {
		try {
			return Optional
					.of((Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		} catch (Exception e) {
			logger.warn("error get modelClass, probably you need to override getModelClass method", e);
		}

		return Optional.empty();
	}

	@Override
	public boolean is_new() {
		return _new;
	}

	@Override
	public boolean isDirty() {
		return dirty && editable;
	}

	public void setDirty(boolean dirty) {
		if (editable || !dirty) {
			firePropertyChange("dirty", this.dirty, this.dirty = dirty);
		}
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		firePropertyChange("editable", this.editable, this.editable = editable);
	}
}

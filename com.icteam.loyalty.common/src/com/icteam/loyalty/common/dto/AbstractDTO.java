package com.icteam.loyalty.common.dto;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

public abstract class AbstractDTO implements IDTO {

	private static final long serialVersionUID = 3428162022541395275L;

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

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(listener);
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(listener);
	}

	@Override
	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		changeSupport.addPropertyChangeListener(propertyName, listener);
	}

	@Override
	public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		changeSupport.removePropertyChangeListener(propertyName, listener);
	}

	@Override
	public boolean is_new() {
		return _new;
	}

	@Override
	public boolean isDirty() {
		return dirty && editable;
	}

	@Override
	public void setDirty(boolean dirty) {
		if (editable || !dirty) {
			firePropertyChange("dirty", this.dirty, this.dirty = dirty);
		}
	}

	@Override
	public boolean isEditable() {
		return editable;
	}

	@Override
	public void setEditable(boolean editable) {
		firePropertyChange("editable", this.editable, this.editable = editable);
	}

	@Override
	public <C extends IDTO> void copyTo(C dest) {
		try {
			PropertyUtils.copyProperties(dest, this);
			dest.setDirty(this.isDirty());
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getLabel() {
		return "";
	}

	@Override
	public String getPermissionObject() {
		return getObjectClassName().toLowerCase();
	}

	protected String getObjectClassName() {
		return StringUtils.removeEnd(getClass().getSimpleName(), "DTO");
	}
}

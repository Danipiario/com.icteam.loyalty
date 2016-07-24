package com.icteam.loyalty.common.dto;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

public abstract class AbstractDTO implements IDTO {

	private final PropertyChangeSupport changeSupport;
	private boolean _new = true;
	private boolean dirty = false;
	private boolean editable = true;

	public AbstractDTO() {
		changeSupport = new PropertyChangeSupport(this);
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
	public void enableTrackChanges() {
		changeSupport.addPropertyChangeListener(evt -> {
			_new = false;
			if (!evt.getPropertyName().equals("dirty") && !evt.getPropertyName().equals("editable")) {
				setDirty(true);
			}
		});
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

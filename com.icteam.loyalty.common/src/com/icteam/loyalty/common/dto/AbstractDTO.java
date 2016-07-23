package com.icteam.loyalty.common.dto;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

public abstract class AbstractDTO implements IDTO {

	private final PropertyChangeSupport changeSupport;
	private boolean _new = true;
	private boolean dirty = false;
	private final boolean editable = true;

	public AbstractDTO() {
		changeSupport = new PropertyChangeSupport(this);
	}

	protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		if (!Objects.equals(oldValue, newValue)) {
			changeSupport.firePropertyChange(propertyName, oldValue, newValue);
		}
	}

	@Override
	public void enableTrackChanges() {
		changeSupport.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				_new = false;
				if (!evt.getPropertyName().equals("dirty") && !evt.getPropertyName().equals("editable")) {
					setDirty(true);
				}
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

}

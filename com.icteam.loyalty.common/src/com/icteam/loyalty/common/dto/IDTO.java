package com.icteam.loyalty.common.dto;

import java.beans.PropertyChangeListener;
import java.io.Serializable;

public interface IDTO extends Serializable {

	boolean is_new();

	boolean isDirty();

	void setDirty(boolean dirty);

	void enableTrackChanges();

	boolean isEditable();

	void setEditable(boolean editable);

	String getPermissionObject();

	String getLabel();

	<C extends IDTO> void copyTo(C dest);

	void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);

	void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);

	void removePropertyChangeListener(PropertyChangeListener listener);

	void addPropertyChangeListener(PropertyChangeListener listener);

}
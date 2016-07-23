package com.icteam.loyalty.common.dto;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public interface IDTO {

	boolean isDirty();

	boolean is_new();

	void enableTrackChanges();

}
package com.icteam.loyalty.common.dto;

public abstract class AbstractSearchDTO implements IDTO {

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean is_new() {
		return false;
	}

	@Override
	public void enableTrackChanges() {
	}

}
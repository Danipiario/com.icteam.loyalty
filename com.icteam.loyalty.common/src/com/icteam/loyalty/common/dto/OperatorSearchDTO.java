package com.icteam.loyalty.common.dto;

public class OperatorSearchDTO implements IDTO {

	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isDirty() {
		return false;
	}

	public boolean is_new() {
		return false;
	}

	public void enableTrackChanges() {
	}

}

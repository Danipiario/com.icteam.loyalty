package com.icteam.loyalty.common.dto;

import java.security.Principal;
import java.util.List;

import com.icteam.loyalty.common.interfaces.IGroup;

public class OperatorDTO extends AbstractDTO implements Principal {

	private String login;

	private String name;

	private String surname;

	private Boolean changePassword;

	private List<IGroup> groups;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		firePropertyChange("login", this.login, this.login = login);
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		firePropertyChange("name", this.name, this.name = name);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		firePropertyChange("surname", this.surname, this.surname = surname);
	}

	public Boolean getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(Boolean changePassword) {
		firePropertyChange("changePassword", this.changePassword, this.changePassword = changePassword);
	}

	public List<IGroup> getGroups() {
		return groups;
	}

	public void setGroups(List<IGroup> groups) {
		this.groups = groups;
	}

}

package com.icteam.loyalty.common.dto;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.Id;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import com.icteam.loyalty.common.annotations.Password;
import com.icteam.loyalty.common.annotations.Property;
import com.icteam.loyalty.common.interfaces.IGroup;
import com.icteam.loyalty.common.interfaces.ILanguage;
import com.icteam.loyalty.common.interfaces.IStatus;
import com.icteam.loyalty.common.model.Operator;
import com.icteam.loyalty.common.service.EnumService;
import com.querydsl.core.Tuple;

@Component(service = { IDTO.class }, property = { "dtoClass=OperatorDTO" }, scope = ServiceScope.PROTOTYPE)
public class OperatorDTO extends AbstractModelDTO<Operator> implements Principal {

	private static final long serialVersionUID = -6963344306951789513L;

	@Reference
	EnumService enumService;

	@Id
	@Property(show = true, order = 1)
	private String login;

	@Property(show = true, order = 2)
	private String name;

	@Property(show = true, order = 3)
	private String surname;

	@Password
	@Property(show = false)
	private String password;

	@Property(show = true, order = 4)
	private Boolean changePassword;

	@Property(show = true, order = 5)
	private List<IGroup> groups;

	@Property(show = false)
	private IStatus status;

	@Property(show = false)
	private ILanguage language;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		firePropertyChange("login", this.login, this.login = login);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		firePropertyChange("password", this.password, this.password = password);
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

	public ILanguage getLanguage() {
		return language;
	}

	public void setLanguage(ILanguage language) {
		firePropertyChange("language", this.language, this.language = language);
	}

	public IStatus getStatus() {
		return status;
	}

	public void setStatus(IStatus status) {
		firePropertyChange("status", this.status, this.status = status);
	}

	@Override
	public void fill(Tuple tuple, Operator model) {
		setChangePassword(BooleanUtils.toBooleanObject(tuple.get(model.changePassword)));
		setLogin(tuple.get(model.login));
		setPassword(tuple.get(model.password));
		setName(tuple.get(model.name));
		setSurname(tuple.get(model.surname));
		setLanguage(enumService.value(ILanguage.class, tuple.get(model.language)));
		setStatus(enumService.value(IStatus.class, tuple.get(model.status)));

		final String[] groups = StringUtils.split(StringUtils.defaultString(tuple.get(model.groups)), ",");

		if (enumService != null) {
			setGroups(Stream.of(groups).map(group -> enumService.value(IGroup.class, group))
					.collect(Collectors.toList()));
		}
	}

}

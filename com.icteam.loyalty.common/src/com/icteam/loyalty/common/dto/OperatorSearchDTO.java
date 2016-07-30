package com.icteam.loyalty.common.dto;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.icteam.loyalty.common.annotations.Where;
import com.icteam.loyalty.common.enums.EWhereClause;
import com.icteam.loyalty.common.model.Operator;

@Component(service = { IDTO.class }, property = { "dtoClass=OperatorSearchDTO" }, scope = ServiceScope.PROTOTYPE)
public class OperatorSearchDTO extends AbstractDTO<Operator> {

	private static final long serialVersionUID = 2763790535162752634L;
	@Where(value = EWhereClause.LIKE_IGNORE_CASE)
	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		firePropertyChange("login", this.login, this.login = login);
	}
}

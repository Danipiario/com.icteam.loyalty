package com.icteam.loyalty.common.dto;

import com.icteam.loyalty.common.annotations.Where;
import com.icteam.loyalty.common.enums.EWhereClause;

public class OperatorSearchDTO extends AbstractDTO {

	@Where(value = EWhereClause.LIKE_IGNORE_CASE)
	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}

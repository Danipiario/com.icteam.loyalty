package com.icteam.loyalty.common.dto;

import com.icteam.loyalty.common.annotations.Where;
import com.icteam.loyalty.common.enums.EStatus;

public class OperatorLoginDTO extends AbstractDTO {

	@Where
	private String login;

	@Where(crypt = true)
	private String password;

	@Where
	private final EStatus status = EStatus.ATTIVO;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EStatus getStatus() {
		return status;
	}

}

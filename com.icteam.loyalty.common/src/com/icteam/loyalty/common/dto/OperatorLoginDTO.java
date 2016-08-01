package com.icteam.loyalty.common.dto;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.icteam.loyalty.common.annotations.Where;
import com.icteam.loyalty.common.enums.EStatus;
import com.icteam.loyalty.common.interfaces.IStatus;
import com.icteam.loyalty.common.model.Operator;

@Component(service = { IDTO.class }, property = { "dtoClass=OperatorLoginDTO" }, scope = ServiceScope.PROTOTYPE)
public class OperatorLoginDTO extends AbstractSearchDTO<Operator> {

	private static final long serialVersionUID = -6843859391959638215L;

	@Where
	private String login;

	@Where(crypt = true)
	private String password;

	@Where
	private final IStatus status = EStatus.ATTIVO;

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

	public IStatus getStatus() {
		return status;
	}

}

package com.icteam.loyalty.common.mock;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.dto.OperatorLoginDTO;
import com.icteam.loyalty.common.model.Operator;

@Component(service = { IDTO.class }, property = { Constants.SERVICE_RANKING + ":Integer=100",
		"dtoClass=OperatorLoginDTO" }, scope = ServiceScope.PROTOTYPE)
public class OperatorLoginDTOMock extends OperatorLoginDTO {

	private static final long serialVersionUID = 1251387801513444919L;

	public OperatorLoginDTOMock() {
		super();

	}

	@Override
	public void enableTrackChanges() {
		// prima della init così non marco l'oggetto come dirty
		setLogin("manager");

		super.enableTrackChanges();
	}

	@Override
	public void setLogin(String login) {
		if (StringUtils.isNotBlank(login)) {
			super.setLogin(login);
		}
	}

	@Override
	public boolean is_new() {
		return false;
	}

	@Override
	public Optional<Class<Operator>> getModelClass() {
		return Optional.of(Operator.class);
	}
}

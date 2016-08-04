package com.icteam.loyalty.common.provider.internal;

import java.security.AccessController;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.security.auth.Subject;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorLoginDTO;
import com.icteam.loyalty.common.dto.OperatorSearchDTO;
import com.icteam.loyalty.common.nls.Messages;
import com.icteam.loyalty.common.service.AuthService;
import com.icteam.loyalty.common.service.DTOService;
import com.icteam.loyalty.common.service.DbService;
import com.icteam.loyalty.common.util.Constants;

@Component
public class AuthProvider implements AuthService {

	@Reference
	private DbService dbService;

	@Reference
	private DTOService dtoService;

	@Override
	public OperatorDTO login(OperatorLoginDTO operatorLoginDTO) {
		Optional<OperatorDTO> operatorDTO = Optional.empty();

		if (!operatorLoginDTO.is_new()) {
			operatorDTO = dbService.searchOne(operatorLoginDTO, OperatorDTO.class);
		}

		return operatorDTO.orElseThrow(() -> new IllegalArgumentException(Messages.get().operatorNotFound));
	}

	@Override
	public List<OperatorDTO> search(OperatorSearchDTO operatorSearchDTO) {
		return dbService.search(operatorSearchDTO, OperatorDTO.class);
	}

	@Override
	public long count(OperatorSearchDTO operatorSearchDTO) {
		return dbService.count(operatorSearchDTO, OperatorDTO.class);
	}

	@Override
	public Optional<OperatorDTO> getPrincipal() {
		OperatorDTO principal = null;

		Subject subject = Subject.getSubject(AccessController.getContext());

		if (subject != null) {
			Set<OperatorDTO> operatorPrincipals = subject.getPrincipals(OperatorDTO.class);

			if (!operatorPrincipals.isEmpty()) {
				principal = operatorPrincipals.iterator().next();
			}
		} else {
			OperatorLoginDTO operatorLoginDTO = dtoService.newDTO(OperatorLoginDTO.class, true);
			operatorLoginDTO.setLogin(Constants.BACKGROUND_OPERATOR);

			principal = login(operatorLoginDTO);
		}

		return Optional.of(principal);
	}
}

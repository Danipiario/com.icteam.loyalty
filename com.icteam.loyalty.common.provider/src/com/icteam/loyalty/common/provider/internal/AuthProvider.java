package com.icteam.loyalty.common.provider.internal;

import java.util.List;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorLoginDTO;
import com.icteam.loyalty.common.dto.OperatorSearchDTO;
import com.icteam.loyalty.common.service.AuthService;
import com.icteam.loyalty.common.service.DbService;

@Component
public class AuthProvider implements AuthService {

	@Reference
	private DbService dbService;

	@Override
	public OperatorDTO login(OperatorLoginDTO operatorLoginDTO) {
		Optional<OperatorDTO> operatorDTO = Optional.empty();

		if (!operatorLoginDTO.is_new()) {
			operatorDTO = dbService.searchOne(operatorLoginDTO, OperatorDTO.class);
		}

		return operatorDTO.orElseThrow(() -> new IllegalArgumentException(Messages.get().operator_not_found));
	}

	@Override
	public List<OperatorDTO> search(OperatorSearchDTO operatorSearchDTO) {
		return dbService.search(operatorSearchDTO, OperatorDTO.class);
	}

	@Override
	public long count(OperatorSearchDTO operatorSearchDTO) {
		return dbService.count(operatorSearchDTO, OperatorDTO.class);
	}
}

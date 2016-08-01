package com.icteam.loyalty.common.service;

import java.util.List;
import java.util.Optional;

import org.osgi.annotation.versioning.ProviderType;

import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorLoginDTO;
import com.icteam.loyalty.common.dto.OperatorSearchDTO;

@ProviderType
public interface AuthService {

	OperatorDTO login(OperatorLoginDTO operatorLoginDTO);

	List<OperatorDTO> search(OperatorSearchDTO operatorSearchDTO);

	long count(OperatorSearchDTO operatorSearchDTO);

	Optional<OperatorDTO> getPrincipal();
}

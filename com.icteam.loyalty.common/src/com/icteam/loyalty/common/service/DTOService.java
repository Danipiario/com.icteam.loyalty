package com.icteam.loyalty.common.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.dto.DTO;

@ProviderType
public interface DTOService {

	<D extends DTO> D newDTO(Class<D> dtoClass);

	void addDTO(Class<? extends DTO> dtoClass, Class<? extends DTO> dtoExtendedClass);

	void removeDTO(Class<? extends DTO> dtoClass);

}

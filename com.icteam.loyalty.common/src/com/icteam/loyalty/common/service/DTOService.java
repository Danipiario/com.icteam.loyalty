package com.icteam.loyalty.common.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.dto.DTO;

@ProviderType
public interface DTOService {

    <D extends DTO, O extends Object> O toObject(D dto, Class<O> objectClass);

    <D extends DTO, O extends Object> D toDTO(O object, Class<D> dtoClass);

}

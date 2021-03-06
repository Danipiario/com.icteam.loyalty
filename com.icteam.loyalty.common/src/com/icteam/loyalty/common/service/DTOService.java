package com.icteam.loyalty.common.service;

import org.osgi.annotation.versioning.ProviderType;

import com.icteam.loyalty.common.dto.IDTO;

@ProviderType
public interface DTOService {

	<D extends IDTO> D newDTO(Class<D> dtoClass, boolean enableTrackChanges);
}

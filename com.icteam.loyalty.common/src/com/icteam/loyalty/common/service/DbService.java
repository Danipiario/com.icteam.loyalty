package com.icteam.loyalty.common.service;

import java.util.List;
import java.util.Optional;

import org.osgi.annotation.versioning.ProviderType;

import com.icteam.loyalty.common.dto.IModelDTO;
import com.icteam.loyalty.common.interfaces.ISearchDTO;
import com.querydsl.sql.RelationalPathBase;

@ProviderType
public interface DbService {

	<M extends RelationalPathBase<M>, S extends ISearchDTO, MD extends IModelDTO<M>> List<MD> search(S searchDTO,
			Class<MD> modelDTOClass);

	<M extends RelationalPathBase<M>, S extends ISearchDTO, MD extends IModelDTO<M>> Optional<MD> searchOne(S searchDTO,
			Class<MD> modelDTOClass);

	<M extends RelationalPathBase<M>, S extends ISearchDTO, MD extends IModelDTO<M>> long count(S searchDTO,
			Class<MD> modelDTOClass);

}

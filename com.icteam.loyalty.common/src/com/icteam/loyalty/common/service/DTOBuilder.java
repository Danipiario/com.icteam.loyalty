package com.icteam.loyalty.common.service;

import org.osgi.dto.DTO;

public interface DTOBuilder<D extends DTO, O extends Object> {

    public static final String PROPERTY_DTO_CLASS_NAME = "dtoClassName";
    public static final String PROPERTY_OBJECT_CLASS_NAME = "objectClassName";

    D buildDTO(O object);

    O buildObject(D dto);

}

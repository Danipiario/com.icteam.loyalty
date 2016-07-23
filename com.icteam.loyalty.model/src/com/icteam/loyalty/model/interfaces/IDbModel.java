package com.icteam.loyalty.model.interfaces;

import java.io.Serializable;

import org.kahvi.paketti.dtobuilder.DtoBuilder;

public interface IDbModel<D extends IDtoModel> extends Serializable {

    DtoBuilder<D> getDtoBuilder();

    D buildDto();

}

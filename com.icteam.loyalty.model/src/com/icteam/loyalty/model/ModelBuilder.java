package com.icteam.loyalty.model;

import java.util.List;

import com.icteam.loyalty.model.interfaces.IDbModel;
import com.icteam.loyalty.model.interfaces.IDtoModel;

public interface ModelBuilder<D extends IDtoModel> {

    D buildDto(IDbModel<D> dbModel);

    <T extends IDbModel<D>> T build(D dtoModel);

    <T extends IDbModel<D>> List<D> buildDtoList(List<T> dbModelList);

    D newDto();

    D initDto(D dto, Object... params);

}

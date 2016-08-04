package com.icteam.loyalty.common.ui.interfaces;

import com.icteam.loyalty.common.dto.IDTO;

public interface IDTOProvider<M extends IDTO, S extends Object, T extends IDTOProperty<M, S>> {

	T getModelProperty();

}

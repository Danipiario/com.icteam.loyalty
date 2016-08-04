package com.icteam.loyalty.common.ui.interfaces;

import com.icteam.loyalty.common.dto.IDTO;

public interface IDTOControl<M extends IDTO, S extends Object, T extends IDTOProperty<M, S>>
		extends IDTOProvider<M, S, T> {

	void setModelProperty(M model, String property);

}
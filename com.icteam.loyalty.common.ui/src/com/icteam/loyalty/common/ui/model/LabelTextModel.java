package com.icteam.loyalty.common.ui.model;

import com.icteam.loyalty.common.dto.IDTO;

public class LabelTextModel<M extends IDTO, S extends Object> extends LabelModel<M, S> {

	private static final long serialVersionUID = -389856560005584245L;

	public LabelTextModel(M model, String property) {
		super(model, property);
	}
}

package com.icteam.loyalty.common.ui.model;

import com.icteam.loyalty.common.dto.IDTO;

public class LabelCheckModel<M extends IDTO> extends LabelModel<M, Boolean> {

	private static final long serialVersionUID = -389856560005584245L;

	public LabelCheckModel(M model, String property) {
		super(model, property);
	}
}

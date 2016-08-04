package com.icteam.loyalty.common.ui.model;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.nls.NLS;

public class LabelModel<M extends IDTO, S extends Object> extends DTOProperty<M, S> {

	private static final long serialVersionUID = 6762910668714074083L;

	private String label;

	public LabelModel(M model, String property) {
		super(model, property);

		initLabel();
	}

	protected void initLabel() {
		setLabel(NLS.get(getNestedModelClass(), getNestedProperty())); // $NON-NLS-1$
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		changeSupport.firePropertyChange("label", this.label, this.label = label);
	}
}

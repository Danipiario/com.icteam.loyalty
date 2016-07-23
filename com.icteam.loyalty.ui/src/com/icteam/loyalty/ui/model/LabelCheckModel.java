package com.icteam.loyalty.ui.model;

import com.icteam.loyalty.model.interfaces.IModel;

public class LabelCheckModel<M extends IModel> extends LabelModel<M, Boolean> {

    private static final long serialVersionUID = -389856560005584245L;

    public LabelCheckModel(M model, String property) {
        super(model, property);
    }
}

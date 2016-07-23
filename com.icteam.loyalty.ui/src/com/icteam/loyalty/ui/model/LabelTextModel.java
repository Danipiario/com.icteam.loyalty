package com.icteam.loyalty.ui.model;

import com.icteam.loyalty.model.interfaces.IModel;

public class LabelTextModel<M extends IModel, S extends Object> extends LabelModel<M, S> {

    private static final long serialVersionUID = -389856560005584245L;

    public LabelTextModel(M model, String property) {
        super(model, property);
    }
}

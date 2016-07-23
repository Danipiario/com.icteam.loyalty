package com.icteam.loyalty.ui.model;

import java.util.Date;

import com.icteam.loyalty.model.interfaces.IModel;

public class LabelDateTimeModel<M extends IModel> extends LabelModel<M, Date> {

    private static final long serialVersionUID = -3988871089032662369L;

    public LabelDateTimeModel(M model, String property) {
        super(model, property);
    }

}

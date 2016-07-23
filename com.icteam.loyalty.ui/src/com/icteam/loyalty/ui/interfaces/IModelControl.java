package com.icteam.loyalty.ui.interfaces;

import com.icteam.loyalty.model.interfaces.IModel;

public interface IModelControl<M extends IModel, S extends Object, T extends IModelProperty<M, S>> extends IModelProvider<M, S, T> {

    void setModelProperty(M model, String property);

}
package com.icteam.loyalty.ui.interfaces;

import com.icteam.loyalty.model.interfaces.IModel;

public interface IModelProvider<M extends IModel, S extends Object, T extends IModelProperty<M, S>> {

    T getModelProperty();

}

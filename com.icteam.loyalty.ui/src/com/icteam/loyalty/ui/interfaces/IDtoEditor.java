package com.icteam.loyalty.ui.interfaces;

import com.icteam.loyalty.model.interfaces.IDtoModel;

public interface IDtoEditor<D extends IDtoModel> extends IBindedControl {

    D getDtoModel();

    IDtoEditorInput<D> getEditorInput();

    void save();
}

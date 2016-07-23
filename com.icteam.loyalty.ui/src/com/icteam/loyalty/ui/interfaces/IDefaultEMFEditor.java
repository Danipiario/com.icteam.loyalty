package com.icteam.loyalty.ui.interfaces;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.ui.model.DefaultEditorEMFModel;

public interface IDefaultEMFEditor<M extends DefaultEditorEMFModel< ? extends EMFModel>> extends IBindedControl {

    M getEditorInput();

    void save();
}

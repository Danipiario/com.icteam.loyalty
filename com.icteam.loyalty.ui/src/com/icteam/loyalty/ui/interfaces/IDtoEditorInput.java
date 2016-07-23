package com.icteam.loyalty.ui.interfaces;

import org.eclipse.ui.IEditorInput;

import com.icteam.loyalty.model.interfaces.IDtoModel;

public interface IDtoEditorInput<D extends IDtoModel> extends IEditorInput {

    D getDto();

    void setDto(D dto);
}

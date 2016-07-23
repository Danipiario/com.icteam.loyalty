package com.icteam.loyalty.ui.editor;

import com.icteam.loyalty.model.DtoListModel;
import com.icteam.loyalty.model.DtoModel;
import com.icteam.loyalty.ui.interfaces.IDtoEditorInput;
import com.icteam.loyalty.ui.model.DtoEditorInput;

public abstract class DefaultListEditor<D extends DtoModel, L extends DtoListModel<D>> extends DefaultEditor<L> {

    public DefaultListEditor() {
    }

    protected abstract L createDtoListModel();

    @Override
    protected IDtoEditorInput<L> createFooEditorInput() {
        L foo = createDtoListModel();
        foo.add((D) new DtoModel());

        return new DtoEditorInput<>(foo);
    }

    @Override
    protected L internalSave() {
        L dtoListModelSaved = createDtoListModel();

        for (D dto : getDtoModel().getList()) {
            if (dto.isDirty()) {
                dtoListModelSaved.add(internalSaveItem(dto));
            } else {
                dtoListModelSaved.add(dto);
            }
        }

        return dtoListModelSaved;
    }

    protected abstract D internalSaveItem(D dto);
}

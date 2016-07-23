package com.icteam.loyalty.ui.util;

import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.ui.interfaces.IDtoEditorInput;
import com.icteam.loyalty.ui.model.DtoEditorInput;

public class EditorUtils {

    /**
     * ritorna un DtoEditorInput utile per ricercare un editor
     * Non utilizzare nel normale flusso applicativo
     *
     * @param dto
     */
    public static <D extends IDtoModel> IDtoEditorInput<D> createEditorInputFrom(D dto) {
        return new DtoEditorInput<>(dto);
    }
}

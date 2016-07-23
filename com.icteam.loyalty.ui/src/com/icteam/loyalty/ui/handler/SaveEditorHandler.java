package com.icteam.loyalty.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.ui.interfaces.IDefaultEMFEditor;
import com.icteam.loyalty.ui.interfaces.IDtoEditor;

public class SaveEditorHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPart workbenchPart = HandlerUtil.getActivePart(event);

        if (workbenchPart instanceof IDtoEditor) {
            ((IDtoEditor< ? extends IDtoModel>) workbenchPart).save();
        } else if (workbenchPart instanceof IDefaultEMFEditor) {
            ((IDefaultEMFEditor< ? extends EMFModel>) workbenchPart).save();
        }

        return null;
    }
}

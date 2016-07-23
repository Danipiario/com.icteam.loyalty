package com.icteam.loyalty.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

public class CloseEditorHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPart workbenchPart = HandlerUtil.getActivePart(event);

        if (workbenchPart instanceof IEditorPart) {
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor((IEditorPart) workbenchPart, false);
        }

        return null;
    }
}

package com.icteam.loyalty.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.icteam.loyalty.ui.UI;

public class OpenViewHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        String viewId = event.getParameter(UI.OpenViewHandler_ID);

        try {
            PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(viewId);
        } catch (PartInitException e) {
            e.printStackTrace();
        }

        return null;
    }
}

package com.icteam.loyalty.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.icteam.loyalty.ui.interfaces.IVirtualEMFView;

public class ViewRefreshEMFHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPart workbenchPart = HandlerUtil.getActivePart(event);

        if (workbenchPart instanceof IVirtualEMFView) {
            IVirtualEMFView< ? > virtualView = (IVirtualEMFView< ? >) workbenchPart;

            virtualView.getVirtualViewEMFModel().reload(false);
        }

        return null;
    }
}

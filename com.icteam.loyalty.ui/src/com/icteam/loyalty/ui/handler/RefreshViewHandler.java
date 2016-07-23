package com.icteam.loyalty.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.icteam.loyalty.ui.interfaces.IVirtualView;

public class RefreshViewHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event)  {
        IWorkbenchPart workbenchPart = HandlerUtil.getActivePart(event);

        if (workbenchPart instanceof IVirtualView) {
            IVirtualView< ? , ? > virtualView = (IVirtualView< ? , ? >) workbenchPart;

            virtualView.reload(true);
        }

        return null;
    }
}

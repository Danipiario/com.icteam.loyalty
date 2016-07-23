package com.icteam.loyalty.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.icteam.loyalty.model.DtoModel;
import com.icteam.loyalty.model.template.AbstractTemplate;
import com.icteam.loyalty.ui.dialog.AdvancedSearchDialog;
import com.icteam.loyalty.ui.interfaces.IVirtualView;

public class AdvancedSearchDialogHandler<T extends AbstractTemplate< ? >, D extends DtoModel> extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event)  {
        IWorkbenchPart workbenchPart = HandlerUtil.getActivePart(event);

        if (workbenchPart instanceof IVirtualView) {
            IVirtualView<T, D> virtualView = (IVirtualView<T, D>) workbenchPart;

            new AdvancedSearchDialog<>(Display.getCurrent().getActiveShell(), virtualView).open();
        }

        return null;
    }
}

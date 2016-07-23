package com.icteam.loyalty.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.ui.dialog.ViewSelectColumnEMFDialog;
import com.icteam.loyalty.ui.interfaces.IVirtualEMFView;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;

public class ViewSelectColumnEMFHandler<V extends VirtualViewEMFModel< ? extends AbstractEMFTemplate< ? >, ? extends EMFModel>> extends
        AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        IWorkbenchPart workbenchPart = HandlerUtil.getActivePart(event);

        if (workbenchPart instanceof IVirtualEMFView) {
            IVirtualEMFView<V> virtualView = (IVirtualEMFView<V>) workbenchPart;

            new ViewSelectColumnEMFDialog<>(Display.getCurrent().getActiveShell(), virtualView.getVirtualViewEMFModel()).open();
        }

        return null;
    }
}

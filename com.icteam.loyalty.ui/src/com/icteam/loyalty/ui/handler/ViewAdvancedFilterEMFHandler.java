package com.icteam.loyalty.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.ui.dialog.AdvancedSearchEMFDialog;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;

public class ViewAdvancedFilterEMFHandler<T extends AbstractEMFTemplate< ? >, D extends EMFModel> extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        if (event.getTrigger() instanceof Event) {
            Event e = (Event) event.getTrigger();

            if (e.data instanceof Object[] && ((Object[]) e.data)[0] instanceof VirtualViewEMFModel) {
                VirtualViewEMFModel< ? , ? > virtualViewEMFModel = (VirtualViewEMFModel< ? , ? >) ((Object[]) e.data)[0];

                new AdvancedSearchEMFDialog<>(Display.getCurrent().getActiveShell(), virtualViewEMFModel).open();
            }
        }

        return null;
    }
}

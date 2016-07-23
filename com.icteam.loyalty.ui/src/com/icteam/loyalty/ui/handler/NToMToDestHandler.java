package com.icteam.loyalty.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.swt.widgets.Event;

import com.icteam.loyalty.ui.interfaces.NToMDirection;
import com.icteam.loyalty.ui.model.NToMEMFModel;

public class NToMToDestHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        if (event.getTrigger() instanceof Event) {
            Event e = (Event) event.getTrigger();

            if (e.data instanceof Object[] && ((Object[]) e.data)[0] instanceof NToMEMFModel) {
                NToMEMFModel ntomModel = (NToMEMFModel) ((Object[]) e.data)[0];

                ntomModel.move(NToMDirection.TO_DEST);
            }
        }

        return null;
    }
}

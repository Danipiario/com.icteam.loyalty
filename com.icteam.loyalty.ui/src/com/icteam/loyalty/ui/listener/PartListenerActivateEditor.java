package com.icteam.loyalty.ui.listener;

import java.lang.ref.WeakReference;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;

import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.ui.interfaces.IDtoEditor;
import com.icteam.loyalty.ui.interfaces.IVirtualView;

public class PartListenerActivateEditor<D extends IDtoModel> extends PartListener2Adapter {

    private final WeakReference<IVirtualView< ? , D>> virtualViewRef;

    public PartListenerActivateEditor(IVirtualView< ? , D> virtualView) {
        super();
        this.virtualViewRef = new WeakReference<IVirtualView< ? , D>>(virtualView);
    }

    @Override
    public void partActivated(IWorkbenchPartReference ref) {
        IWorkbenchPart part = ref.getPart(true);
        if (part instanceof IDtoEditor) {
            D dto = ((IDtoEditor<D>) part).getEditorInput().getDto();

            IVirtualView< ? , D> virtualView = virtualViewRef.get();

            if (virtualView != null) {
                virtualView.getColumnViewer().setSelection(new StructuredSelection(dto), true);
            }
        }
    }
}
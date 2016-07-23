package com.icteam.loyalty.ui.listener;

import java.lang.ref.WeakReference;

import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.ui.interfaces.IVirtualView;
import com.icteam.loyalty.ui.model.DtoEditorInput;

public class OpenEditorListener<D extends IDtoModel> implements IOpenListener {

    private final WeakReference<IVirtualView< ? , D>> virtualViewRef;
    private final String editorID;

    public OpenEditorListener(String editorID, IVirtualView< ? , D> virtualView) {
        this.editorID = editorID;
        this.virtualViewRef = new WeakReference<IVirtualView< ? , D>>(virtualView);
    }

    @Override
    public void open(OpenEvent event) {
        D dtoModel = (D) ((IStructuredSelection) event.getSelection()).getFirstElement();

        IVirtualView< ? , D> virtualView = virtualViewRef.get();

        if (virtualView != null && dtoModel != null && dtoModel.hasEditor()) {
            try {
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .openEditor(new DtoEditorInput<>(dtoModel, virtualView, editorID), editorID);
            } catch (PartInitException e) {
                e.printStackTrace();
            }
        }
    }
}
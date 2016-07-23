package com.icteam.loyalty.ui.listener;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.ui.util.EditorUtils;

public class SelectionChangeListener<D extends IDtoModel> implements ISelectionChangedListener {

    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        D dtoModel = (D) ((IStructuredSelection) event.getSelection()).getFirstElement();

        if (dtoModel != null) {
            IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                    .findEditor(EditorUtils.createEditorInputFrom(dtoModel));

            if (editorPart != null) {
                PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().bringToTop(editorPart);
            }
        }
    }
}
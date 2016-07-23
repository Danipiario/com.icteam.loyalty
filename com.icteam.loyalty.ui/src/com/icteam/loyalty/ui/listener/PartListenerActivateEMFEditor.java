package com.icteam.loyalty.ui.listener;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.ui.interfaces.IDefaultEMFEditor;
import com.icteam.loyalty.ui.model.DefaultEditorEMFModel;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;
import com.icteam.loyalty.ui.util.UIUtils;

public class PartListenerActivateEMFEditor extends PartListener2Adapter {

    public PartListenerActivateEMFEditor() {
        super();
    }

    @Override
    public void partActivated(IWorkbenchPartReference ref) {
        IWorkbenchPart part = ref.getPart(true);

        if (part instanceof IDefaultEMFEditor) {
            DefaultEditorEMFModel< ? > editorInput = ((IDefaultEMFEditor< ? extends DefaultEditorEMFModel< ? extends EMFModel>>) part).getEditorInput();

            EMFModel model = editorInput.getInternalModel(); // need internal to select

            VirtualViewEMFModel< ? , ? > virtualViewEMFModel = editorInput.getVirtualViewEMFModel();

            if (virtualViewEMFModel != null) {
                if (virtualViewEMFModel.getEditorModelEClass().isInstance(editorInput)) {
                    virtualViewEMFModel.eSet(UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST, ECollections.asEList(model));

                    IWorkbenchPage page = UIUtils.getActivePage();

                    if (page != null) {
                        IViewPart viewPart = page.findView(virtualViewEMFModel.getViewID());

                        if (viewPart != null) {
                            UIUtils.getActivePage().bringToTop(viewPart);
                        }
                    }
                }
            }
        }
    }
}
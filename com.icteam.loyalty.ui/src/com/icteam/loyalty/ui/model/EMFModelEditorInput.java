//package com.icteam.loyalty.ui.model;
//
//import java.lang.ref.WeakReference;
//
//import org.eclipse.core.expressions.EvaluationResult;
//import org.eclipse.core.expressions.IEvaluationContext;
//import org.eclipse.core.internal.expressions.ReferenceExpression;
//import org.eclipse.core.runtime.CoreException;
//import org.eclipse.jface.resource.ImageDescriptor;
//import org.eclipse.swt.widgets.Display;
//import org.eclipse.ui.IPersistableElement;
//import org.eclipse.ui.PlatformUI;
//import org.eclipse.ui.services.IEvaluationService;
//
//import com.icteam.loyalty.model.EMFModel;
//import com.icteam.loyalty.model.util.ModelUtil;
//import com.icteam.loyalty.ui.interfaces.IEMFModelEditorInput;
//
//public class EMFModelEditorInput<D extends EMFModel> implements IEMFModelEditorInput<D> {
//
//    private D model;
//    D internalModel;
//    private WeakReference<VirtualViewEMFModel< ? , D>> virtualViewEMFModelRef;
//    private final String editorID;
//    private boolean cloned = true;
//
//    public EMFModelEditorInput(D internalModel) {
//        this(internalModel, null);
//    }
//
//    public EMFModelEditorInput(D internalModel, VirtualViewEMFModel< ? , D> virtualViewModel, String editorID) {
//        this.internalModel = internalModel;
//
//        this.model = ModelUtil.copy(internalModel);
//        this.editorID = editorID;
//
//        this.virtualViewEMFModelRef = new WeakReference<VirtualViewEMFModel< ? , D>>(virtualViewModel);
//
//        updateEditableState();
//    }
//
//    public EMFModelEditorInput(D internalModel, String editorID) {
//        this.internalModel = internalModel;
//
//        this.model = internalModel;
//        this.editorID = editorID;
//
//        cloned = false;
//
//        updateEditableState();
//    }
//
//    private void updateEditableState() {
//        model.setEditable(false);
//
//        if (editorID != null) {
//            IEvaluationService es = (IEvaluationService) PlatformUI.getWorkbench().getService(IEvaluationService.class);
//            IEvaluationContext currentState = es.getCurrentState();
//
//            ReferenceExpression referenceExpression = new ReferenceExpression(editorID);
//            try {
//                EvaluationResult result = referenceExpression.evaluate(currentState);
//                model.setEditable(EvaluationResult.TRUE.equals(result));
//            } catch (CoreException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public D getEMFModel() {
//        return model;
//    }
//
//    @Override
//    public D getInternalModel() {
//        return internalModel;
//    }
//
//    @Override
//    public void setEMFModel(D model) {
////        if (this.dto != null && this.dto != dto) {
////            dto.copyTo(this.dto, true);
////        }
////
//        if (cloned) {
//            this.model.copyTo(internalModel, true);
//        } else {
//            this.internalModel = model;
//        }
//
//        final VirtualViewEMFModel< ? , D> virtualViewEMFModel = getVirtualViewEMFModel();
//
//        if (virtualViewEMFModel != null) {
//            if (!virtualViewEMFModel.getList().contains(internalModel)) {
//                virtualViewEMFModel.reload(false);
//
//                Display.getCurrent().timerExec(100, new Runnable() {
//                    @Override
//                    public void run() {
//                        for (D item : virtualViewEMFModel.getList()) {
//                            if (item.equals(internalModel)) {
//                                internalModel = item;
//                                break;
//                            }
//                        }
//                    }
//                });
//            }
//        }
//
//        updateEditableState();
//    }
//
//    // check null ref
//    @Override
//    public VirtualViewEMFModel< ? , D> getVirtualViewEMFModel() {
//        return virtualViewEMFModelRef != null ? virtualViewEMFModelRef.get() : null;
//    }
//
//    @Override
//    public Object getAdapter(Class adapter) {
//        return null;
//    }
//
//    @Override
//    public boolean exists() {
//        return false;
//    }
//
//    @Override
//    public ImageDescriptor getImageDescriptor() {
//        return null;
//    }
//
//    @Override
//    public String getName() {
//        return model.getClass().getName();
//    }
//
//    @Override
//    public IPersistableElement getPersistable() {
//        return null;
//    }
//
//    @Override
//    public String getToolTipText() {
//        return "";// dto.getTootlTipText();
//    }
//
//    @Override
//    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + (internalModel == null ? 0 : internalModel.hashCode());
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        EMFModelEditorInput<D> other = (EMFModelEditorInput<D>) obj;
//        if (internalModel == null) {
//            if (other.internalModel != null) {
//                return false;
//            }
//        } else if (!internalModel.equals(other.internalModel)) {
//            return false;
//        }
//        return true;
//    }
//
//}

/**
 */
package com.icteam.loyalty.ui.model.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.internal.expressions.ReferenceExpression;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.IEvaluationService;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.impl.EMFModelImpl;
import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.interfaces.UIInterfacesPackage;
import com.icteam.loyalty.ui.model.DefaultEditorEMFModel;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Default Editor EMF Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.DefaultEditorEMFModelImpl#getSaveAction <em>Save Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.DefaultEditorEMFModelImpl#getCancelAction <em>Cancel Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.DefaultEditorEMFModelImpl#getVirtualViewEMFModel <em>Virtual View EMF Model</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.DefaultEditorEMFModelImpl#getEditorID <em>Editor ID</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.DefaultEditorEMFModelImpl#getInternalModel <em>Internal Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DefaultEditorEMFModelImpl<D extends EMFModel> extends EMFModelImpl implements DefaultEditorEMFModel<D> {
    /**
     * The cached value of the '{@link #getVirtualViewEMFModel() <em>Virtual View EMF Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getVirtualViewEMFModel()
     * @generated
     * @ordered
     */
    protected VirtualViewEMFModel< ? , D> virtualViewEMFModel;

    /**
     * The default value of the '{@link #getEditorID() <em>Editor ID</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEditorID()
     * @generated
     * @ordered
     */
    protected static final String EDITOR_ID_EDEFAULT = null;

    protected D model;

    /**
     * The cached value of the '{@link #getInternalModel() <em>Internal Model</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInternalModel()
     * @generated
     * @ordered
     */
    protected D internalModel;

    private boolean cloned = true;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DefaultEditorEMFModelImpl() {
        super();
    }

    /**
     * utilizzato solo dalla factory per la ricerca di un editor
     */
    protected DefaultEditorEMFModelImpl(D model) {
        this.internalModel = model;
    }

    private void updateEditableState() {
        setEditable(false);
        model.setEditable(false);

        IEvaluationService es = (IEvaluationService) PlatformUI.getWorkbench().getService(IEvaluationService.class);
        IEvaluationContext currentState = es.getCurrentState();

        ReferenceExpression referenceExpression = new ReferenceExpression(getEditorID());
        try {
            EvaluationResult result = referenceExpression.evaluate(currentState);
            model.setEditable(EvaluationResult.TRUE.equals(result));
            setEditable(EvaluationResult.TRUE.equals(result));
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UIModelPackage.Literals.DEFAULT_EDITOR_EMF_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getSaveAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__EDITOR_SAVE.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getCancelAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__EDITOR_CANCEL.getName());
    }

    @Override
    public D getModel() {
        return model;
    }

    @Override
    public void setModel(D newModel) {
        if (cloned) {
            this.model.copyTo(internalModel, true);
        } else {
            this.internalModel = model;
        }

        final VirtualViewEMFModel< ? , D> virtualViewEMFModel = getVirtualViewEMFModel();

        if (virtualViewEMFModel != null) {
            if (!virtualViewEMFModel.getList().contains(internalModel)) {
                virtualViewEMFModel.reload(false);

                Display.getCurrent().timerExec(100, new Runnable() {
                    @Override
                    public void run() {
                        for (D item : virtualViewEMFModel.getList()) {
                            if (item.equals(internalModel)) {
                                internalModel = item;
                                break;
                            }
                        }
                    }
                });
            }
        }

        updateEditableState();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public D getInternalModel() {
        return internalModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public void init(D internalModel, VirtualViewEMFModel< ? , D> virtualViewModel) {
        this.internalModel = internalModel;

        this.model = ModelUtil.copy(internalModel);
        this.virtualViewEMFModel = virtualViewModel;

        updateEditableState();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public void init(D internalModel) {
        this.internalModel = internalModel;
        this.model = internalModel;

        cloned = false;

        updateEditableState();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public VirtualViewEMFModel< ? , D> getVirtualViewEMFModel() {
        return virtualViewEMFModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getEditorID() {
        // TODO: implement this method to return the 'Editor ID' attribute
        // Ensure that you remove @generated or mark it @generated NOT
        throw new UnsupportedOperationException();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL__SAVE_ACTION:
                return getSaveAction();
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL__CANCEL_ACTION:
                return getCancelAction();
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL__VIRTUAL_VIEW_EMF_MODEL:
                return getVirtualViewEMFModel();
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL__EDITOR_ID:
                return getEditorID();
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL__INTERNAL_MODEL:
                return getInternalModel();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL__SAVE_ACTION:
                return getSaveAction() != null;
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL__CANCEL_ACTION:
                return getCancelAction() != null;
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL__VIRTUAL_VIEW_EMF_MODEL:
                return virtualViewEMFModel != null;
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL__EDITOR_ID:
                return EDITOR_ID_EDEFAULT == null ? getEditorID() != null : !EDITOR_ID_EDEFAULT.equals(getEditorID());
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL__INTERNAL_MODEL:
                return internalModel != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object eInvoke(int operationID, EList< ? > arguments) throws InvocationTargetException {
        switch (operationID) {
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL___INIT__EMFMODEL_VIRTUALVIEWEMFMODEL:
                init((D) arguments.get(0), (VirtualViewEMFModel< ? , D>) arguments.get(1));
                return null;
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL___INIT__EMFMODEL:
                init((D) arguments.get(0));
                return null;
        }
        return super.eInvoke(operationID, arguments);
    }

    @Override
    public Object getAdapter(Class adapter) {
        return null;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public String getName() {
        return model.getClass().getName();
    }

    @Override
    public IPersistableElement getPersistable() {
        return null;
    }

    @Override
    public String getToolTipText() {
        return "";// dto.getTootlTipText();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (internalModel == null ? 0 : internalModel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DefaultEditorEMFModelImpl<D> other = (DefaultEditorEMFModelImpl<D>) obj;
        if (internalModel == null) {
            if (other.internalModel != null) {
                return false;
            }
        } else if (!internalModel.equals(other.internalModel)) {
            return false;
        }
        return true;
    }

//    @Override
//    protected String getObjectClassName() {
//        return StringUtils.remove(StringUtils.removeEnd(eClass().getName(), "Model"), "Editor");
//    }

} //DefaultEditorEMFModelImpl

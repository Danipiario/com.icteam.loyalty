/**
 */
package com.icteam.loyalty.model.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.ModelPackage;
import com.icteam.loyalty.model.interfaces.IEMFModel;
import com.icteam.loyalty.model.util.ModelUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EMF Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.impl.EMFModelImpl#isEditable <em>Editable</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.impl.EMFModelImpl#isDirty <em>Dirty</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EMFModelImpl extends MinimalEObjectImpl.Container implements EMFModel {
    /**
     * The default value of the '{@link #isEditable() <em>Editable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEditable()
     * @generated
     * @ordered
     */
    protected static final boolean EDITABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isEditable() <em>Editable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEditable()
     * @generated
     * @ordered
     */
    protected boolean editable = EDITABLE_EDEFAULT;

    /**
     * The default value of the '{@link #isDirty() <em>Dirty</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDirty()
     * @generated
     * @ordered
     */
    protected static final boolean DIRTY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDirty() <em>Dirty</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDirty()
     * @generated
     * @ordered
     */
    protected boolean dirty = DIRTY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected EMFModelImpl() {
        super();

        eAdapters().add(new EContentAdapter() {
            @Override
            public void notifyChanged(Notification notification) {
                if (!notification.isTouch()
                        && notification.getFeatureID(EClassifier.class) != ModelPackage.EMF_MODEL__DIRTY
                        && notification.getFeatureID(EClassifier.class) != ModelPackage.EMF_MODEL__EDITABLE) {
                    setDirty(true);
                }
            }
        });
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelPackage.Literals.EMF_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isEditable() {
        return editable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEditable(boolean newEditable) {
        boolean oldEditable = editable;
        editable = newEditable;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EMF_MODEL__EDITABLE, oldEditable, editable));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isDirty() {
        return dirty;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDirty(boolean newDirty) {
        boolean oldDirty = dirty;
        dirty = newDirty;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EMF_MODEL__DIRTY, oldDirty, dirty));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getModelName() {
        return (String) org.apache.commons.lang.ObjectUtils.defaultIfNull(ModelUtil.getID(this), "");
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean hasEditor() {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getPermissionObject() {
        return getObjectClassName().toLowerCase();
    }

    protected String getObjectClassName() {
        return StringUtils.removeEnd(eClass().getName(), "Model");
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public <C extends IEMFModel> void copyTo(final C destModel, final boolean deliver) {
        if (!deliver) {
            destModel.eSetDeliver(false);
        }

        for (EStructuralFeature feature : eClass().getEAllStructuralFeatures()) {
            if (feature.isChangeable()) {
                Boolean copy = (Boolean) ModelUtil.getAnnotation(feature, com.icteam.loyalty.model.interfaces.EAnnotation.COPY);

                if (copy) {
                    destModel.eSet(feature, eGet(feature));
                }
            }
        }

        destModel.setDirty(isDirty());

        if (!deliver) {
            destModel.eSetDeliver(true);
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean equals(final Object obj) {
        return ModelUtil.equals(this, obj);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelPackage.EMF_MODEL__EDITABLE:
                return isEditable();
            case ModelPackage.EMF_MODEL__DIRTY:
                return isDirty();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ModelPackage.EMF_MODEL__EDITABLE:
                setEditable((Boolean) newValue);
                return;
            case ModelPackage.EMF_MODEL__DIRTY:
                setDirty((Boolean) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ModelPackage.EMF_MODEL__EDITABLE:
                setEditable(EDITABLE_EDEFAULT);
                return;
            case ModelPackage.EMF_MODEL__DIRTY:
                setDirty(DIRTY_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ModelPackage.EMF_MODEL__EDITABLE:
                return editable != EDITABLE_EDEFAULT;
            case ModelPackage.EMF_MODEL__DIRTY:
                return dirty != DIRTY_EDEFAULT;
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
            case ModelPackage.EMF_MODEL___GET_MODEL_NAME:
                return getModelName();
            case ModelPackage.EMF_MODEL___HAS_EDITOR:
                return hasEditor();
            case ModelPackage.EMF_MODEL___GET_PERMISSION_OBJECT:
                return getPermissionObject();
            case ModelPackage.EMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN:
                copyTo((IEMFModel) arguments.get(0), (Boolean) arguments.get(1));
                return null;
            case ModelPackage.EMF_MODEL___EQUALS__OBJECT:
                return equals(arguments.get(0));
        }
        return super.eInvoke(operationID, arguments);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (editable: ");
        result.append(editable);
        result.append(", dirty: ");
        result.append(dirty);
        result.append(')');
        return result.toString();
    }

} //EMFModelImpl

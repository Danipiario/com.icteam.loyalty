/**
 */
package com.icteam.loyalty.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.ListEMFModel;
import com.icteam.loyalty.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List EMF Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.impl.ListEMFModelImpl#getList <em>List</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.impl.ListEMFModelImpl#getSelectedModel <em>Selected Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListEMFModelImpl<D extends EMFModel> extends EMFModelImpl implements ListEMFModel<D> {
    /**
     * The cached value of the '{@link #getList() <em>List</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getList()
     * @generated
     * @ordered
     */
    protected EList<D> list;

    /**
     * The cached value of the '{@link #getSelectedModel() <em>Selected Model</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelectedModel()
     * @generated
     * @ordered
     */
    protected D selectedModel;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ListEMFModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelPackage.Literals.LIST_EMF_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<D> getList() {
        if (list == null) {
            list = new EObjectResolvingEList<D>(EMFModel.class, this, ModelPackage.LIST_EMF_MODEL__LIST);
        }
        return list;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public D getSelectedModel() {
        return selectedModel;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setSelectedModel(D newSelectedModel) {
        D oldSelectedModel = selectedModel;
        selectedModel = newSelectedModel;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.LIST_EMF_MODEL__SELECTED_MODEL, oldSelectedModel, selectedModel));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelPackage.LIST_EMF_MODEL__LIST:
                return getList();
            case ModelPackage.LIST_EMF_MODEL__SELECTED_MODEL:
                return getSelectedModel();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ModelPackage.LIST_EMF_MODEL__LIST:
                getList().clear();
                getList().addAll((Collection< ? extends D>) newValue);
                return;
            case ModelPackage.LIST_EMF_MODEL__SELECTED_MODEL:
                setSelectedModel((D) newValue);
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
            case ModelPackage.LIST_EMF_MODEL__LIST:
                getList().clear();
                return;
            case ModelPackage.LIST_EMF_MODEL__SELECTED_MODEL:
                setSelectedModel((D) null);
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
            case ModelPackage.LIST_EMF_MODEL__LIST:
                return list != null && !list.isEmpty();
            case ModelPackage.LIST_EMF_MODEL__SELECTED_MODEL:
                return selectedModel != null;
        }
        return super.eIsSet(featureID);
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
        result.append(" (selectedModel: ");
        result.append(selectedModel);
        result.append(')');
        return result.toString();
    }

} //ListEMFModelImpl

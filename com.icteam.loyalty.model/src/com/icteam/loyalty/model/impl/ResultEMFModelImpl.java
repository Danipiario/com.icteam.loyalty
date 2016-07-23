/**
 */
package com.icteam.loyalty.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.icteam.loyalty.model.ModelPackage;
import com.icteam.loyalty.model.ResultEMFModel;
import com.icteam.loyalty.model.interfaces.StatusReason;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result EMF Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.impl.ResultEMFModelImpl#getException <em>Exception</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.impl.ResultEMFModelImpl#getStatusReason <em>Status Reason</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResultEMFModelImpl extends EMFModelImpl implements ResultEMFModel {
    /**
     * The default value of the '{@link #getException() <em>Exception</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getException()
     * @generated
     * @ordered
     */
    protected static final String EXCEPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getException() <em>Exception</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getException()
     * @generated
     * @ordered
     */
    protected String exception = EXCEPTION_EDEFAULT;

    /**
     * The cached value of the '{@link #getStatusReason() <em>Status Reason</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStatusReason()
     * @generated
     * @ordered
     */
    protected StatusReason statusReason;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ResultEMFModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelPackage.Literals.RESULT_EMF_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getException() {
        return exception;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setException(String newException) {
        String oldException = exception;
        exception = newException;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RESULT_EMF_MODEL__EXCEPTION, oldException, exception));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public StatusReason getStatusReason() {
        return statusReason;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setStatusReason(StatusReason newStatusReason) {
        StatusReason oldStatusReason = statusReason;
        statusReason = newStatusReason;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.RESULT_EMF_MODEL__STATUS_REASON, oldStatusReason, statusReason));
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
            case ModelPackage.RESULT_EMF_MODEL__EXCEPTION:
                return getException();
            case ModelPackage.RESULT_EMF_MODEL__STATUS_REASON:
                return getStatusReason();
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
            case ModelPackage.RESULT_EMF_MODEL__EXCEPTION:
                setException((String) newValue);
                return;
            case ModelPackage.RESULT_EMF_MODEL__STATUS_REASON:
                setStatusReason((StatusReason) newValue);
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
            case ModelPackage.RESULT_EMF_MODEL__EXCEPTION:
                setException(EXCEPTION_EDEFAULT);
                return;
            case ModelPackage.RESULT_EMF_MODEL__STATUS_REASON:
                setStatusReason((StatusReason) null);
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
            case ModelPackage.RESULT_EMF_MODEL__EXCEPTION:
                return EXCEPTION_EDEFAULT == null ? exception != null : !EXCEPTION_EDEFAULT.equals(exception);
            case ModelPackage.RESULT_EMF_MODEL__STATUS_REASON:
                return statusReason != null;
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
        result.append(" (exception: ");
        result.append(exception);
        result.append(')');
        return result.toString();
    }

} //ResultEMFModelImpl

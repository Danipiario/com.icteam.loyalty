/**
 */
package com.icteam.loyalty.model;

import com.icteam.loyalty.model.interfaces.StatusReason;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result EMF Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.ResultEMFModel#getException <em>Exception</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.ResultEMFModel#getStatusReason <em>Status Reason</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.ModelPackage#getResultEMFModel()
 * @model
 * @generated
 */
public interface ResultEMFModel extends EMFModel {
    /**
     * Returns the value of the '<em><b>Exception</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exception</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exception</em>' attribute.
     * @see #setException(String)
     * @see com.icteam.loyalty.model.ModelPackage#getResultEMFModel_Exception()
     * @model
     * @generated
     */
    String getException();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.ResultEMFModel#getException <em>Exception</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exception</em>' attribute.
     * @see #getException()
     * @generated
     */
    void setException(String value);

    /**
     * Returns the value of the '<em><b>Status Reason</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Status Reason</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Status Reason</em>' reference.
     * @see #setStatusReason(StatusReason)
     * @see com.icteam.loyalty.model.ModelPackage#getResultEMFModel_StatusReason()
     * @model resolveProxies="false"
     * @generated
     */
    StatusReason getStatusReason();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.ResultEMFModel#getStatusReason <em>Status Reason</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Status Reason</em>' reference.
     * @see #getStatusReason()
     * @generated
     */
    void setStatusReason(StatusReason value);

} // ResultEMFModel

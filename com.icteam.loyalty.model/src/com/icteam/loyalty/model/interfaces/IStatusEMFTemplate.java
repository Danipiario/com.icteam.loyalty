/**
 */
package com.icteam.loyalty.model.interfaces;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Status EMF Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IStatusEMFTemplate#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIStatusEMFTemplate()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IStatusEMFTemplate extends EObject {
    /**
     * Returns the value of the '<em><b>Status</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Status</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Status</em>' reference.
     * @see #setStatus(Status)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIStatusEMFTemplate_Status()
     * @model resolveProxies="false"
     * @generated
     */
    Status getStatus();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IStatusEMFTemplate#getStatus <em>Status</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Status</em>' reference.
     * @see #getStatus()
     * @generated
     */
    void setStatus(Status value);

} // IStatusEMFTemplate

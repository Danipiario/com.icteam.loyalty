/**
 */
package com.icteam.loyalty.model.interfaces;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IContained</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IContained#getMainEObject <em>Main EObject</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIContained()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IContained extends EObject {
    /**
     * Returns the value of the '<em><b>Main EObject</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Main EObject</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Main EObject</em>' reference.
     * @see #setMainEObject(EObject)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIContained_MainEObject()
     * @model resolveProxies="false"
     * @generated
     */
    EObject getMainEObject();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IContained#getMainEObject <em>Main EObject</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Main EObject</em>' reference.
     * @see #getMainEObject()
     * @generated
     */
    void setMainEObject(EObject value);

} // IContained

/**
 */
package com.icteam.loyalty.model.interfaces;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEMF Delegant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFDelegant#getDelegatedId <em>Delegated Id</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFDelegant()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IEMFDelegant extends EObject {
    /**
     * Returns the value of the '<em><b>Delegated Id</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Delegated Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Delegated Id</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFDelegant_DelegatedId()
     * @model default="false" transient="true" changeable="false"
     *        annotation="http://com.icteam.loyalty/property showAsColumn='false'"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    String getDelegatedId();

} // IEMFDelegant

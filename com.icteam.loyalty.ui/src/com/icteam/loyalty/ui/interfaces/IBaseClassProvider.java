/**
 */
package com.icteam.loyalty.ui.interfaces;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IBase Class Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.ui.interfaces.IBaseClassProvider#getBaseClass <em>Base Class</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.ui.interfaces.UIInterfacesPackage#getIBaseClassProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IBaseClassProvider extends EObject {
    /**
     * Returns the value of the '<em><b>Base Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Base Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Base Class</em>' attribute.
     * @see com.icteam.loyalty.ui.interfaces.UIInterfacesPackage#getIBaseClassProvider_BaseClass()
     * @model transient="true" changeable="false" volatile="true"
     * @generated
     */
    Class<EObject> getBaseClass();

} // IBaseClassProvider

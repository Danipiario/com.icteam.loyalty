/**
 */
package com.icteam.loyalty.model.interfaces;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IPerspective Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IPerspectiveProvider#getDefaultPerspective <em>Default Perspective</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIPerspectiveProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IPerspectiveProvider extends EObject {
    /**
     * Returns the value of the '<em><b>Default Perspective</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Perspective</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Perspective</em>' reference.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIPerspectiveProvider_DefaultPerspective()
     * @model resolveProxies="false" required="true" changeable="false" ordered="false"
     * @generated
     */
    Perspective getDefaultPerspective();

} // IPerspectiveProvider

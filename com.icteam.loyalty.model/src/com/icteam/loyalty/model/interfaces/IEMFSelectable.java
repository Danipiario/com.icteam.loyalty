/**
 */
package com.icteam.loyalty.model.interfaces;

import java.io.Serializable;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEMF Selectable</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFSelectable()
 * @model interface="true" abstract="true" SBounds="com.icteam.loyalty.model.interfaces.Serializable"
 * @generated
 */
public interface IEMFSelectable<S extends Serializable> extends EObject {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    S getKey();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    String getDescription();

} // IEMFSelectable

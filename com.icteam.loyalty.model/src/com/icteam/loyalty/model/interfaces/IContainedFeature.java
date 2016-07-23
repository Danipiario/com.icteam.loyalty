/**
 */
package com.icteam.loyalty.model.interfaces;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IContained Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IContainedFeature#getMainFeature <em>Main Feature</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIContainedFeature()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IContainedFeature extends IContained {
    /**
     * Returns the value of the '<em><b>Main Feature</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Main Feature</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Main Feature</em>' attribute.
     * @see #setMainFeature(EStructuralFeature)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIContainedFeature_MainFeature()
     * @model dataType="com.icteam.loyalty.model.interfaces.EStructuralFeature"
     * @generated
     */
    EStructuralFeature getMainFeature();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IContainedFeature#getMainFeature <em>Main Feature</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Main Feature</em>' attribute.
     * @see #getMainFeature()
     * @generated
     */
    void setMainFeature(EStructuralFeature value);

} // IContainedFeature

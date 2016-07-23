/**
 */
package com.icteam.loyalty.model.interfaces;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage
 * @generated
 */
public interface ModelInterfacesFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModelInterfacesFactory eINSTANCE = com.icteam.loyalty.model.interfaces.impl.ModelInterfacesFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Permission</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Permission</em>'.
     * @generated
     */
    Permission createPermission();

    /**
     * Returns a new object of class '<em>Status</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Status</em>'.
     * @generated
     */
    Status createStatus();

    /**
     * Returns a new object of class '<em>Status Reason</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Status Reason</em>'.
     * @generated
     */
    StatusReason createStatusReason();

    /**
     * Returns a new object of class '<em>Perspective</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Perspective</em>'.
     * @generated
     */
    Perspective createPerspective();

    /**
     * Returns a new object of class '<em>Language</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Language</em>'.
     * @generated
     */
    Language createLanguage();

    /**
     * Returns a new object of class '<em>Action</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Action</em>'.
     * @generated
     */
    Action createAction();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ModelInterfacesPackage getModelInterfacesPackage();

} //ModelInterfacesFactory

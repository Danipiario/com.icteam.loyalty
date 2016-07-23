/**
 */
package com.icteam.loyalty.ui.interfaces;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.ui.interfaces.UIInterfacesPackage
 * @generated
 */
public interface UIInterfacesFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    UIInterfacesFactory eINSTANCE = com.icteam.loyalty.ui.interfaces.impl.UIInterfacesFactoryImpl.init();

    /**
     * Returns a new object of class '<em>UI Action</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>UI Action</em>'.
     * @generated
     */
    UIAction createUIAction();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    UIInterfacesPackage getUIInterfacesPackage();

} //UIInterfacesFactory

/**
 */
package com.icteam.loyalty.model;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.model.ModelPackage
 * @generated
 */
public interface ModelFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModelFactory eINSTANCE = com.icteam.loyalty.model.impl.ModelFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Result EMF Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Result EMF Model</em>'.
     * @generated
     */
    ResultEMFModel createResultEMFModel();

    /**
     * Returns a new object of class '<em>List EMF Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>List EMF Model</em>'.
     * @generated
     */
    <D extends EMFModel> ListEMFModel<D> createListEMFModel();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ModelPackage getModelPackage();

} //ModelFactory

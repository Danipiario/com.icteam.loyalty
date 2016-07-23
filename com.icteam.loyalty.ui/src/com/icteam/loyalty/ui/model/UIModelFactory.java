/**
 */
package com.icteam.loyalty.ui.model;

import org.eclipse.emf.ecore.EFactory;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.ui.model.UIModelPackage
 * @generated
 */
public interface UIModelFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    UIModelFactory eINSTANCE = com.icteam.loyalty.ui.model.impl.UIModelFactoryImpl.init();

    /**
     * Returns a new object of class '<em>NTo MEMF Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>NTo MEMF Model</em>'.
     * @generated
     */
    NToMEMFModel createNToMEMFModel();

    /**
     * Returns a new object of class '<em>Default Editor EMF Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Default Editor EMF Model</em>'.
     * @generated
     */
    <D extends EMFModel> DefaultEditorEMFModel<D> createDefaultEditorEMFModel();

    <D extends EMFModel> DefaultEditorEMFModel<D> createDefaultEditorEMFModelForSearch(D model);

    /**
     * Returns a new object of class '<em>Virtual View EMF Model</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Virtual View EMF Model</em>'.
     * @generated
     */
    <T extends AbstractEMFTemplate< ? >, D extends EMFModel> VirtualViewEMFModel<T, D> createVirtualViewEMFModel();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    UIModelPackage getUIModelPackage();

} //UIModelFactory

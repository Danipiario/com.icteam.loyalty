/**
 */
package com.icteam.loyalty.model.template;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.model.template.ModelTemplatePackage
 * @generated
 */
public interface ModelTemplateFactory extends EFactory {
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModelTemplateFactory eINSTANCE = com.icteam.loyalty.model.template.impl.ModelTemplateFactoryImpl.init();

    /**
     * Returns a new object of class '<em>Dictionary EMF Template</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Dictionary EMF Template</em>'.
     * @generated
     */
    DictionaryEMFTemplate createDictionaryEMFTemplate();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ModelTemplatePackage getModelTemplatePackage();

} //ModelTemplateFactory

/**
 */
package com.icteam.loyalty.model.template.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import com.icteam.loyalty.model.template.DictionaryEMFTemplate;
import com.icteam.loyalty.model.template.ModelTemplateFactory;
import com.icteam.loyalty.model.template.ModelTemplatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelTemplateFactoryImpl extends EFactoryImpl implements ModelTemplateFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ModelTemplateFactory init() {
        try {
            ModelTemplateFactory theModelTemplateFactory = (ModelTemplateFactory)EPackage.Registry.INSTANCE.getEFactory(ModelTemplatePackage.eNS_URI);
            if (theModelTemplateFactory != null) {
                return theModelTemplateFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ModelTemplateFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelTemplateFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE: return createDictionaryEMFTemplate();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DictionaryEMFTemplate createDictionaryEMFTemplate() {
        DictionaryEMFTemplateImpl dictionaryEMFTemplate = new DictionaryEMFTemplateImpl();
        return dictionaryEMFTemplate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ModelTemplatePackage getModelTemplatePackage() {
        return (ModelTemplatePackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ModelTemplatePackage getPackage() {
        return ModelTemplatePackage.eINSTANCE;
    }

} //ModelTemplateFactoryImpl

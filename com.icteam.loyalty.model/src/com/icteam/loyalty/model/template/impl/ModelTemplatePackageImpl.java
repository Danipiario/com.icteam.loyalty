/**
 */
package com.icteam.loyalty.model.template.impl;

import com.icteam.loyalty.model.ModelPackage;
import com.icteam.loyalty.model.impl.ModelPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.model.template.DictionaryEMFTemplate;
import com.icteam.loyalty.model.template.ModelTemplateFactory;
import com.icteam.loyalty.model.template.ModelTemplatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelTemplatePackageImpl extends EPackageImpl implements ModelTemplatePackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractEMFTemplateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass dictionaryEMFTemplateEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see com.icteam.loyalty.model.template.ModelTemplatePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ModelTemplatePackageImpl() {
        super(eNS_URI, ModelTemplateFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link ModelTemplatePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ModelTemplatePackage init() {
        if (isInited) return (ModelTemplatePackage)EPackage.Registry.INSTANCE.getEPackage(ModelTemplatePackage.eNS_URI);

        // Obtain or create and register package
        ModelTemplatePackageImpl theModelTemplatePackage = (ModelTemplatePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelTemplatePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelTemplatePackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        ModelInterfacesPackageImpl theModelInterfacesPackage = (ModelInterfacesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelInterfacesPackage.eNS_URI) instanceof ModelInterfacesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelInterfacesPackage.eNS_URI) : ModelInterfacesPackage.eINSTANCE);
        ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);

        // Create package meta-data objects
        theModelTemplatePackage.createPackageContents();
        theModelInterfacesPackage.createPackageContents();
        theModelPackage.createPackageContents();

        // Initialize created meta-data
        theModelTemplatePackage.initializePackageContents();
        theModelInterfacesPackage.initializePackageContents();
        theModelPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theModelTemplatePackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ModelTemplatePackage.eNS_URI, theModelTemplatePackage);
        return theModelTemplatePackage;
    }

    @Override
    public void dispose() {
        EPackage.Registry.INSTANCE.remove(ModelTemplatePackage.eNS_URI);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAbstractEMFTemplate() {
        return abstractEMFTemplateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractEMFTemplate_EntityManager() {
        return (EAttribute)abstractEMFTemplateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractEMFTemplate_Wheres() {
        return (EAttribute)abstractEMFTemplateEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractEMFTemplate_Builder() {
        return (EAttribute)abstractEMFTemplateEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractEMFTemplate_Criteria() {
        return (EAttribute)abstractEMFTemplateEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractEMFTemplate_Root() {
        return (EAttribute)abstractEMFTemplateEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAbstractEMFTemplate_ExcludedFeatures() {
        return (EAttribute)abstractEMFTemplateEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getAbstractEMFTemplate__GetMetamodel() {
        return abstractEMFTemplateEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getAbstractEMFTemplate__BuildFetches() {
        return abstractEMFTemplateEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getAbstractEMFTemplate__CheckDynamicFilters__EList_EList() {
        return abstractEMFTemplateEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getAbstractEMFTemplate__BuildWheres() {
        return abstractEMFTemplateEClass.getEOperations().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDictionaryEMFTemplate() {
        return dictionaryEMFTemplateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDictionaryEMFTemplate_Key() {
        return (EAttribute)dictionaryEMFTemplateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDictionaryEMFTemplate_Language() {
        return (EReference)dictionaryEMFTemplateEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDictionaryEMFTemplate_Value() {
        return (EAttribute)dictionaryEMFTemplateEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ModelTemplateFactory getModelTemplateFactory() {
        return (ModelTemplateFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        abstractEMFTemplateEClass = createEClass(ABSTRACT_EMF_TEMPLATE);
        createEAttribute(abstractEMFTemplateEClass, ABSTRACT_EMF_TEMPLATE__ENTITY_MANAGER);
        createEAttribute(abstractEMFTemplateEClass, ABSTRACT_EMF_TEMPLATE__WHERES);
        createEAttribute(abstractEMFTemplateEClass, ABSTRACT_EMF_TEMPLATE__BUILDER);
        createEAttribute(abstractEMFTemplateEClass, ABSTRACT_EMF_TEMPLATE__CRITERIA);
        createEAttribute(abstractEMFTemplateEClass, ABSTRACT_EMF_TEMPLATE__ROOT);
        createEAttribute(abstractEMFTemplateEClass, ABSTRACT_EMF_TEMPLATE__EXCLUDED_FEATURES);
        createEOperation(abstractEMFTemplateEClass, ABSTRACT_EMF_TEMPLATE___GET_METAMODEL);
        createEOperation(abstractEMFTemplateEClass, ABSTRACT_EMF_TEMPLATE___BUILD_FETCHES);
        createEOperation(abstractEMFTemplateEClass, ABSTRACT_EMF_TEMPLATE___CHECK_DYNAMIC_FILTERS__ELIST_ELIST);
        createEOperation(abstractEMFTemplateEClass, ABSTRACT_EMF_TEMPLATE___BUILD_WHERES);

        dictionaryEMFTemplateEClass = createEClass(DICTIONARY_EMF_TEMPLATE);
        createEAttribute(dictionaryEMFTemplateEClass, DICTIONARY_EMF_TEMPLATE__KEY);
        createEAttribute(dictionaryEMFTemplateEClass, DICTIONARY_EMF_TEMPLATE__VALUE);
        createEReference(dictionaryEMFTemplateEClass, DICTIONARY_EMF_TEMPLATE__LANGUAGE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        ModelInterfacesPackage theModelInterfacesPackage = (ModelInterfacesPackage)EPackage.Registry.INSTANCE.getEPackage(ModelInterfacesPackage.eNS_URI);

        // Create type parameters
        ETypeParameter abstractEMFTemplateEClass_T = addETypeParameter(abstractEMFTemplateEClass, "T");

        // Set bounds for type parameters
        EGenericType g1 = createEGenericType(theModelInterfacesPackage.getSerializable());
        abstractEMFTemplateEClass_T.getEBounds().add(g1);

        // Add supertypes to classes
        g1 = createEGenericType(theModelInterfacesPackage.getIEMFTemplate());
        EGenericType g2 = createEGenericType(abstractEMFTemplateEClass_T);
        g1.getETypeArguments().add(g2);
        abstractEMFTemplateEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(theModelInterfacesPackage.getIEMFModel());
        abstractEMFTemplateEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getAbstractEMFTemplate());
        g2 = createEGenericType(theModelInterfacesPackage.getDistinctEMF());
        g1.getETypeArguments().add(g2);
        dictionaryEMFTemplateEClass.getEGenericSuperTypes().add(g1);

        // Initialize classes, features, and operations; add parameters
        initEClass(abstractEMFTemplateEClass, AbstractEMFTemplate.class, "AbstractEMFTemplate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAbstractEMFTemplate_EntityManager(), theModelInterfacesPackage.getEntityManager(), "entityManager", null, 0, 1, AbstractEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractEMFTemplate_Wheres(), theModelInterfacesPackage.getPredicate(), "wheres", null, 0, -1, AbstractEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractEMFTemplate_Builder(), theModelInterfacesPackage.getCriteriaBuilder(), "builder", null, 0, 1, AbstractEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(theModelInterfacesPackage.getCriteriaQuery());
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        initEAttribute(getAbstractEMFTemplate_Criteria(), g1, "criteria", null, 0, 1, AbstractEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(theModelInterfacesPackage.getFrom());
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(abstractEMFTemplateEClass_T);
        g1.getETypeArguments().add(g2);
        initEAttribute(getAbstractEMFTemplate_Root(), g1, "root", null, 0, 1, AbstractEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAbstractEMFTemplate_ExcludedFeatures(), theModelInterfacesPackage.getEStructuralFeature(), "excludedFeatures", null, 0, -1, AbstractEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        EOperation op = initEOperation(getAbstractEMFTemplate__GetMetamodel(), null, "getMetamodel", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(theModelInterfacesPackage.getManagedType());
        g2 = createEGenericType(abstractEMFTemplateEClass_T);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEOperation(getAbstractEMFTemplate__BuildFetches(), null, "buildFetches", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getAbstractEMFTemplate__CheckDynamicFilters__EList_EList(), null, "checkDynamicFilters", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theModelInterfacesPackage.getEStructuralFeature(), "dynamicFilterFeatures", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "dynamicFilters", 0, -1, IS_UNIQUE, IS_ORDERED);

        initEOperation(getAbstractEMFTemplate__BuildWheres(), null, "buildWheres", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(dictionaryEMFTemplateEClass, DictionaryEMFTemplate.class, "DictionaryEMFTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getDictionaryEMFTemplate_Key(), ecorePackage.getEString(), "key", null, 0, 1, DictionaryEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDictionaryEMFTemplate_Value(), ecorePackage.getEString(), "value", null, 0, 1, DictionaryEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDictionaryEMFTemplate_Language(), theModelInterfacesPackage.getLanguage(), null, "language", null, 0, 1, DictionaryEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.eclipse.org/emf/2002/GenModel
        createGenModelAnnotations();
        // http://com.icteam.loyalty/where
        createWhereAnnotations();
        // http://com.icteam.loyalty/property
        createPropertyAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createGenModelAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/GenModel";	
        addAnnotation
          (getAbstractEMFTemplate__GetMetamodel(), 
           source, 
           new String[] {
             "body", "return entityManager == null ? null : entityManager.getMetamodel().managedType(getDbModelClass());"
           });	
        addAnnotation
          (getAbstractEMFTemplate__BuildFetches(), 
           source, 
           new String[] {
             "body", "// nothing"
           });	
        addAnnotation
          (getAbstractEMFTemplate__CheckDynamicFilters__EList_EList(), 
           source, 
           new String[] {
             "body", "for (EStructuralFeature feature : dynamicFilterFeatures) {\r\n            if (ModelUtil.isI18NFeature(feature)) {\r\n                for (String dynamicFilter : dynamicFilters) {\r\n                    if (!ModelUtil.checkMinLengthI18N(dynamicFilter)) {\r\n                        throw new AppException(EStatusReason.MIN_CHARACTER_SEARCH_LENGTH, ModelProperties.getInstance().minSearchCharacterI18N());\r\n                    }\r\n                }\r\n            }\r\n        }"
           });
    }

    /**
     * Initializes the annotations for <b>http://com.icteam.loyalty/where</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createWhereAnnotations() {
        String source = "http://com.icteam.loyalty/where";	
        addAnnotation
          (getAbstractEMFTemplate_EntityManager(), 
           source, 
           new String[] {
             "clause", "NONE"
           });	
        addAnnotation
          (getAbstractEMFTemplate_Wheres(), 
           source, 
           new String[] {
             "clause", "NONE"
           });	
        addAnnotation
          (getAbstractEMFTemplate_Builder(), 
           source, 
           new String[] {
             "clause", "NONE"
           });	
        addAnnotation
          (getAbstractEMFTemplate_Criteria(), 
           source, 
           new String[] {
             "clause", "NONE"
           });	
        addAnnotation
          (getAbstractEMFTemplate_Root(), 
           source, 
           new String[] {
             "clause", "NONE"
           });	
        addAnnotation
          (getAbstractEMFTemplate_ExcludedFeatures(), 
           source, 
           new String[] {
             "clause", "NONE"
           });	
        addAnnotation
          (getDictionaryEMFTemplate_Value(), 
           source, 
           new String[] {
             "clause", "LIKE_IGNORE_CASE"
           });
    }

    /**
     * Initializes the annotations for <b>http://com.icteam.loyalty/property</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createPropertyAnnotations() {
        String source = "http://com.icteam.loyalty/property";	
        addAnnotation
          (getAbstractEMFTemplate_EntityManager(), 
           source, 
           new String[] {
             "copy", "false"
           });	
        addAnnotation
          (getAbstractEMFTemplate_Wheres(), 
           source, 
           new String[] {
             "copy", "false"
           });	
        addAnnotation
          (getAbstractEMFTemplate_Builder(), 
           source, 
           new String[] {
             "copy", "false"
           });	
        addAnnotation
          (getAbstractEMFTemplate_Criteria(), 
           source, 
           new String[] {
             "copy", "false"
           });	
        addAnnotation
          (getAbstractEMFTemplate_Root(), 
           source, 
           new String[] {
             "copy", "false"
           });	
        addAnnotation
          (getAbstractEMFTemplate_ExcludedFeatures(), 
           source, 
           new String[] {
             "copy", "false"
           });	
        addAnnotation
          (dictionaryEMFTemplateEClass, 
           source, 
           new String[] {
             "dbModel", "com.icteam.loyalty.model.DictionaryEMF"
           });
    }

} //ModelTemplatePackageImpl

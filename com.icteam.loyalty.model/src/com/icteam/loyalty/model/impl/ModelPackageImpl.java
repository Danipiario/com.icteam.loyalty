/**
 */
package com.icteam.loyalty.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.ListEMFModel;
import com.icteam.loyalty.model.ModelFactory;
import com.icteam.loyalty.model.ModelPackage;
import com.icteam.loyalty.model.ResultEMFModel;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl;
import com.icteam.loyalty.model.template.ModelTemplatePackage;
import com.icteam.loyalty.model.template.impl.ModelTemplatePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass emfModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass resultEMFModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass listEMFModelEClass = null;

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
     * @see com.icteam.loyalty.model.ModelPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ModelPackageImpl() {
        super(eNS_URI, ModelFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link ModelPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ModelPackage init() {
        if (isInited) {
            return (ModelPackage) EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
        }

        // Obtain or create and register package
        ModelPackageImpl theModelPackage = (ModelPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                : new ModelPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        ModelTemplatePackageImpl theModelTemplatePackage = (ModelTemplatePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ModelTemplatePackage.eNS_URI) instanceof ModelTemplatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelTemplatePackage.eNS_URI)
                        : ModelTemplatePackage.eINSTANCE);
        ModelInterfacesPackageImpl theModelInterfacesPackage = (ModelInterfacesPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ModelInterfacesPackage.eNS_URI) instanceof ModelInterfacesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelInterfacesPackage.eNS_URI)
                        : ModelInterfacesPackage.eINSTANCE);

        // Create package meta-data objects
        theModelPackage.createPackageContents();
        theModelTemplatePackage.createPackageContents();
        theModelInterfacesPackage.createPackageContents();

        // Initialize created meta-data
        theModelPackage.initializePackageContents();
        theModelTemplatePackage.initializePackageContents();
        theModelInterfacesPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theModelPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, theModelPackage);
        return theModelPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEMFModel() {
        return emfModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getEMFModel__GetModelName() {
        return emfModelEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getEMFModel__HasEditor() {
        return emfModelEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getEMFModel__GetPermissionObject() {
        return emfModelEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getResultEMFModel() {
        return resultEMFModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getResultEMFModel_Exception() {
        return (EAttribute) resultEMFModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getResultEMFModel_StatusReason() {
        return (EReference) resultEMFModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getListEMFModel() {
        return listEMFModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getListEMFModel_List() {
        return (EReference) listEMFModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getListEMFModel_SelectedModel() {
        return (EAttribute) listEMFModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ModelFactory getModelFactory() {
        return (ModelFactory) getEFactoryInstance();
    }

    @Override
    public void dispose() {
        EPackage.Registry.INSTANCE.remove(ModelPackage.eNS_URI);
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
        if (isCreated) {
            return;
        }
        isCreated = true;

        // Create classes and their features
        emfModelEClass = createEClass(EMF_MODEL);
        createEOperation(emfModelEClass, EMF_MODEL___GET_MODEL_NAME);
        createEOperation(emfModelEClass, EMF_MODEL___HAS_EDITOR);
        createEOperation(emfModelEClass, EMF_MODEL___GET_PERMISSION_OBJECT);

        resultEMFModelEClass = createEClass(RESULT_EMF_MODEL);
        createEAttribute(resultEMFModelEClass, RESULT_EMF_MODEL__EXCEPTION);
        createEReference(resultEMFModelEClass, RESULT_EMF_MODEL__STATUS_REASON);

        listEMFModelEClass = createEClass(LIST_EMF_MODEL);
        createEReference(listEMFModelEClass, LIST_EMF_MODEL__LIST);
        createEAttribute(listEMFModelEClass, LIST_EMF_MODEL__SELECTED_MODEL);
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
        if (isInitialized) {
            return;
        }
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        ModelInterfacesPackage theModelInterfacesPackage = (ModelInterfacesPackage) EPackage.Registry.INSTANCE.getEPackage(ModelInterfacesPackage.eNS_URI);

        // Create type parameters
        ETypeParameter listEMFModelEClass_D = addETypeParameter(listEMFModelEClass, "D");

        // Set bounds for type parameters
        EGenericType g1 = createEGenericType(this.getEMFModel());
        listEMFModelEClass_D.getEBounds().add(g1);

        // Add supertypes to classes
        emfModelEClass.getESuperTypes().add(theModelInterfacesPackage.getIEMFModel());
        resultEMFModelEClass.getESuperTypes().add(this.getEMFModel());
        listEMFModelEClass.getESuperTypes().add(this.getEMFModel());

        // Initialize classes, features, and operations; add parameters
        initEClass(emfModelEClass, EMFModel.class, "EMFModel", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEOperation(getEMFModel__GetModelName(), ecorePackage.getEString(), "getModelName", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEOperation(getEMFModel__HasEditor(), ecorePackage.getEBoolean(), "hasEditor", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEOperation(getEMFModel__GetPermissionObject(), ecorePackage.getEString(), "getPermissionObject", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(resultEMFModelEClass, ResultEMFModel.class, "ResultEMFModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getResultEMFModel_Exception(), ecorePackage.getEString(), "exception", null, 0, 1, ResultEMFModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getResultEMFModel_StatusReason(), theModelInterfacesPackage.getStatusReason(), null, "statusReason", null, 0, 1, ResultEMFModel.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(listEMFModelEClass, ListEMFModel.class, "ListEMFModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        g1 = createEGenericType(listEMFModelEClass_D);
        initEReference(getListEMFModel_List(), g1, null, "list", null, 0, -1, ListEMFModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(listEMFModelEClass_D);
        initEAttribute(getListEMFModel_SelectedModel(), g1, "selectedModel", null, 0, 1, ListEMFModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.eclipse.org/emf/2002/GenModel
        createGenModelAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createGenModelAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/GenModel";
        addAnnotation(getEMFModel__GetModelName(), source,
                new String[] { "body", "return (String) org.apache.commons.lang.ObjectUtils.defaultIfNull(ModelUtil.getID(this), \"\");" });
        addAnnotation(getEMFModel__HasEditor(), source, new String[] { "body", "return true;" });
        addAnnotation(getEMFModel__GetPermissionObject(), source, new String[] { "body", "return getObjectClassName().toLowerCase();" });
    }

} //ModelPackageImpl

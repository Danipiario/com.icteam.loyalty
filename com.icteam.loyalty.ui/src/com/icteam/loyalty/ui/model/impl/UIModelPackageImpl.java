/**
 */
package com.icteam.loyalty.ui.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecp.view.spi.model.VViewPackage;

import com.icteam.loyalty.model.ModelPackage;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.template.ModelTemplatePackage;
import com.icteam.loyalty.ui.interfaces.UIInterfacesPackage;
import com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl;
import com.icteam.loyalty.ui.model.DefaultEditorEMFModel;
import com.icteam.loyalty.ui.model.NToMEMFModel;
import com.icteam.loyalty.ui.model.UIModelFactory;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UIModelPackageImpl extends EPackageImpl implements UIModelPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass nToMEMFModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass defaultEditorEMFModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass virtualViewEMFModelEClass = null;

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
     * @see com.icteam.loyalty.ui.model.UIModelPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private UIModelPackageImpl() {
        super(eNS_URI, UIModelFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link UIModelPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static UIModelPackage init() {
        if (isInited) {
            return (UIModelPackage) EPackage.Registry.INSTANCE.getEPackage(UIModelPackage.eNS_URI);
        }

        // Obtain or create and register package
        UIModelPackageImpl theUIModelPackage = (UIModelPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UIModelPackageImpl ? EPackage.Registry.INSTANCE
                .get(eNS_URI) : new UIModelPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ModelTemplatePackage.eINSTANCE.eClass();
        ModelInterfacesPackage.eINSTANCE.eClass();
        ModelPackage.eINSTANCE.eClass();
        VViewPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        UIInterfacesPackageImpl theUIInterfacesPackage = (UIInterfacesPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UIInterfacesPackage.eNS_URI) instanceof UIInterfacesPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(UIInterfacesPackage.eNS_URI) : UIInterfacesPackage.eINSTANCE);

        // Create package meta-data objects
        theUIModelPackage.createPackageContents();
        theUIInterfacesPackage.createPackageContents();

        // Initialize created meta-data
        theUIModelPackage.initializePackageContents();
        theUIInterfacesPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theUIModelPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(UIModelPackage.eNS_URI, theUIModelPackage);
        return theUIModelPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getNToMEMFModel() {
        return nToMEMFModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getNToMEMFModel_AllToSrcAction() {
        return (EReference) nToMEMFModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getNToMEMFModel_ToSrcAction() {
        return (EReference) nToMEMFModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getNToMEMFModel_ToDestAction() {
        return (EReference) nToMEMFModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getNToMEMFModel_AllToDestAction() {
        return (EReference) nToMEMFModelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getNToMEMFModel_SrcList() {
        return (EReference) nToMEMFModelEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getNToMEMFModel_DestList() {
        return (EReference) nToMEMFModelEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getNToMEMFModel_SelectedDestList() {
        return (EReference) nToMEMFModelEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getNToMEMFModel_SelectedSrcList() {
        return (EReference) nToMEMFModelEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getNToMEMFModel__Move__NToMDirection() {
        return nToMEMFModelEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDefaultEditorEMFModel() {
        return defaultEditorEMFModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDefaultEditorEMFModel_SaveAction() {
        return (EReference) defaultEditorEMFModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDefaultEditorEMFModel_CancelAction() {
        return (EReference) defaultEditorEMFModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDefaultEditorEMFModel_InternalModel() {
        return (EReference) defaultEditorEMFModelEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDefaultEditorEMFModel__Init__EMFModel_VirtualViewEMFModel() {
        return defaultEditorEMFModelEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getDefaultEditorEMFModel__Init__EMFModel() {
        return defaultEditorEMFModelEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getDefaultEditorEMFModel_VirtualViewEMFModel() {
        return (EReference) defaultEditorEMFModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDefaultEditorEMFModel_EditorID() {
        return (EAttribute) defaultEditorEMFModelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getVirtualViewEMFModel() {
        return virtualViewEMFModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVirtualViewEMFModel_Template() {
        return (EReference) virtualViewEMFModelEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getVirtualViewEMFModel_Filter() {
        return (EAttribute) virtualViewEMFModelEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVirtualViewEMFModel_List() {
        return (EReference) virtualViewEMFModelEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getVirtualViewEMFModel_SearchProvider() {
        return (EAttribute) virtualViewEMFModelEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVirtualViewEMFModel_SelectedList() {
        return (EReference) virtualViewEMFModelEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVirtualViewEMFModel_OpenEditorAction() {
        return (EReference) virtualViewEMFModelEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVirtualViewEMFModel_FilterColumnsAction() {
        return (EReference) virtualViewEMFModelEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVirtualViewEMFModel_AdvancedFilterAction() {
        return (EReference) virtualViewEMFModelEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVirtualViewEMFModel_RefreshAction() {
        return (EReference) virtualViewEMFModelEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVirtualViewEMFModel_SelectColumnAction() {
        return (EReference) virtualViewEMFModelEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVirtualViewEMFModel_AddAction() {
        return (EReference) virtualViewEMFModelEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVirtualViewEMFModel_RemoveAction() {
        return (EReference) virtualViewEMFModelEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVirtualViewEMFModel_ColumnWidths() {
        return (EReference) virtualViewEMFModelEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getVirtualViewEMFModel_ItemCount() {
        return (EAttribute) virtualViewEMFModelEClass.getEStructuralFeatures().get(13);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getVirtualViewEMFModel_ViewID() {
        return (EAttribute) virtualViewEMFModelEClass.getEStructuralFeatures().get(14);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getVirtualViewEMFModel_ModelClass() {
        return (EAttribute) virtualViewEMFModelEClass.getEStructuralFeatures().get(15);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getVirtualViewEMFModel_TemplateClass() {
        return (EAttribute) virtualViewEMFModelEClass.getEStructuralFeatures().get(16);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getVirtualViewEMFModel_ColumnDomainModelReferences() {
        return (EAttribute) virtualViewEMFModelEClass.getEStructuralFeatures().get(17);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVirtualViewEMFModel_EditorModelEClass() {
        return (EReference) virtualViewEMFModelEClass.getEStructuralFeatures().get(18);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getVirtualViewEMFModel__BuildTemplate() {
        return virtualViewEMFModelEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getVirtualViewEMFModel__OpenEditor() {
        return virtualViewEMFModelEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getVirtualViewEMFModel__SetAdvancedSearchTemplate__AbstractEMFTemplate() {
        return virtualViewEMFModelEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getVirtualViewEMFModel__Reload__boolean() {
        return virtualViewEMFModelEClass.getEOperations().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getVirtualViewEMFModel__SetFilterFeatures__EList_boolean() {
        return virtualViewEMFModelEClass.getEOperations().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getVirtualViewEMFModel__CloseEditors() {
        return virtualViewEMFModelEClass.getEOperations().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getVirtualViewEMFModel__FindEditor__EMFModel() {
        return virtualViewEMFModelEClass.getEOperations().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public UIModelFactory getUIModelFactory() {
        return (UIModelFactory) getEFactoryInstance();
    }

    @Override
    public void dispose() {
        EPackage.Registry.INSTANCE.remove(UIModelPackage.eNS_URI);
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
        nToMEMFModelEClass = createEClass(NTO_MEMF_MODEL);
        createEReference(nToMEMFModelEClass, NTO_MEMF_MODEL__ALL_TO_SRC_ACTION);
        createEReference(nToMEMFModelEClass, NTO_MEMF_MODEL__TO_SRC_ACTION);
        createEReference(nToMEMFModelEClass, NTO_MEMF_MODEL__TO_DEST_ACTION);
        createEReference(nToMEMFModelEClass, NTO_MEMF_MODEL__ALL_TO_DEST_ACTION);
        createEReference(nToMEMFModelEClass, NTO_MEMF_MODEL__SRC_LIST);
        createEReference(nToMEMFModelEClass, NTO_MEMF_MODEL__DEST_LIST);
        createEReference(nToMEMFModelEClass, NTO_MEMF_MODEL__SELECTED_DEST_LIST);
        createEReference(nToMEMFModelEClass, NTO_MEMF_MODEL__SELECTED_SRC_LIST);
        createEOperation(nToMEMFModelEClass, NTO_MEMF_MODEL___MOVE__NTOMDIRECTION);

        defaultEditorEMFModelEClass = createEClass(DEFAULT_EDITOR_EMF_MODEL);
        createEReference(defaultEditorEMFModelEClass, DEFAULT_EDITOR_EMF_MODEL__SAVE_ACTION);
        createEReference(defaultEditorEMFModelEClass, DEFAULT_EDITOR_EMF_MODEL__CANCEL_ACTION);
        createEReference(defaultEditorEMFModelEClass, DEFAULT_EDITOR_EMF_MODEL__VIRTUAL_VIEW_EMF_MODEL);
        createEAttribute(defaultEditorEMFModelEClass, DEFAULT_EDITOR_EMF_MODEL__EDITOR_ID);
        createEReference(defaultEditorEMFModelEClass, DEFAULT_EDITOR_EMF_MODEL__INTERNAL_MODEL);
        createEOperation(defaultEditorEMFModelEClass, DEFAULT_EDITOR_EMF_MODEL___INIT__EMFMODEL_VIRTUALVIEWEMFMODEL);
        createEOperation(defaultEditorEMFModelEClass, DEFAULT_EDITOR_EMF_MODEL___INIT__EMFMODEL);

        virtualViewEMFModelEClass = createEClass(VIRTUAL_VIEW_EMF_MODEL);
        createEReference(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__TEMPLATE);
        createEAttribute(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__FILTER);
        createEReference(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__LIST);
        createEAttribute(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__SEARCH_PROVIDER);
        createEReference(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST);
        createEReference(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__OPEN_EDITOR_ACTION);
        createEReference(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__FILTER_COLUMNS_ACTION);
        createEReference(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__ADVANCED_FILTER_ACTION);
        createEReference(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__REFRESH_ACTION);
        createEReference(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__SELECT_COLUMN_ACTION);
        createEReference(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__ADD_ACTION);
        createEReference(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__REMOVE_ACTION);
        createEReference(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__COLUMN_WIDTHS);
        createEAttribute(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT);
        createEAttribute(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__VIEW_ID);
        createEAttribute(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__MODEL_CLASS);
        createEAttribute(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__TEMPLATE_CLASS);
        createEAttribute(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__COLUMN_DOMAIN_MODEL_REFERENCES);
        createEReference(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL__EDITOR_MODEL_ECLASS);
        createEOperation(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL___BUILD_TEMPLATE);
        createEOperation(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL___OPEN_EDITOR);
        createEOperation(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL___SET_ADVANCED_SEARCH_TEMPLATE__ABSTRACTEMFTEMPLATE);
        createEOperation(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL___RELOAD__BOOLEAN);
        createEOperation(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL___SET_FILTER_FEATURES__ELIST_BOOLEAN);
        createEOperation(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL___CLOSE_EDITORS);
        createEOperation(virtualViewEMFModelEClass, VIRTUAL_VIEW_EMF_MODEL___FIND_EDITOR__EMFMODEL);
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
        ModelPackage theModelPackage = (ModelPackage) EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);
        UIInterfacesPackage theUIInterfacesPackage = (UIInterfacesPackage) EPackage.Registry.INSTANCE.getEPackage(UIInterfacesPackage.eNS_URI);
        ModelInterfacesPackage theModelInterfacesPackage = (ModelInterfacesPackage) EPackage.Registry.INSTANCE.getEPackage(ModelInterfacesPackage.eNS_URI);
        ModelTemplatePackage theModelTemplatePackage = (ModelTemplatePackage) EPackage.Registry.INSTANCE.getEPackage(ModelTemplatePackage.eNS_URI);
        VViewPackage theViewPackage = (VViewPackage) EPackage.Registry.INSTANCE.getEPackage(VViewPackage.eNS_URI);
        EcorePackage theEcorePackage = (EcorePackage) EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

        // Create type parameters
        ETypeParameter defaultEditorEMFModelEClass_D = addETypeParameter(defaultEditorEMFModelEClass, "D");
        ETypeParameter virtualViewEMFModelEClass_T = addETypeParameter(virtualViewEMFModelEClass, "T");
        ETypeParameter virtualViewEMFModelEClass_D = addETypeParameter(virtualViewEMFModelEClass, "D");

        // Set bounds for type parameters
        EGenericType g1 = createEGenericType(theModelPackage.getEMFModel());
        defaultEditorEMFModelEClass_D.getEBounds().add(g1);
        g1 = createEGenericType(theModelTemplatePackage.getAbstractEMFTemplate());
        EGenericType g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        virtualViewEMFModelEClass_T.getEBounds().add(g1);
        g1 = createEGenericType(theModelPackage.getEMFModel());
        virtualViewEMFModelEClass_D.getEBounds().add(g1);

        // Add supertypes to classes
        nToMEMFModelEClass.getESuperTypes().add(theModelPackage.getEMFModel());
        nToMEMFModelEClass.getESuperTypes().add(theUIInterfacesPackage.getIBaseClassProvider());
        nToMEMFModelEClass.getESuperTypes().add(theModelInterfacesPackage.getIContainedFeature());
        defaultEditorEMFModelEClass.getESuperTypes().add(theModelPackage.getEMFModel());
        defaultEditorEMFModelEClass.getESuperTypes().add(theUIInterfacesPackage.getIEditorInput());
        virtualViewEMFModelEClass.getESuperTypes().add(theModelPackage.getEMFModel());
        virtualViewEMFModelEClass.getESuperTypes().add(theUIInterfacesPackage.getIBaseClassProvider());

        // Initialize classes, features, and operations; add parameters
        initEClass(nToMEMFModelEClass, NToMEMFModel.class, "NToMEMFModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getNToMEMFModel_AllToSrcAction(), theModelInterfacesPackage.getAction(), null, "allToSrcAction", null, 0, 1, NToMEMFModel.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNToMEMFModel_ToSrcAction(), theModelInterfacesPackage.getAction(), null, "toSrcAction", null, 0, 1, NToMEMFModel.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNToMEMFModel_ToDestAction(), theModelInterfacesPackage.getAction(), null, "toDestAction", null, 0, 1, NToMEMFModel.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNToMEMFModel_AllToDestAction(), theModelInterfacesPackage.getAction(), null, "allToDestAction", null, 0, 1, NToMEMFModel.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNToMEMFModel_SrcList(), ecorePackage.getEObject(), null, "srcList", null, 0, -1, NToMEMFModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNToMEMFModel_DestList(), ecorePackage.getEObject(), null, "destList", null, 0, -1, NToMEMFModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNToMEMFModel_SelectedDestList(), ecorePackage.getEObject(), null, "selectedDestList", null, 0, -1, NToMEMFModel.class, IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getNToMEMFModel_SelectedSrcList(), ecorePackage.getEObject(), null, "selectedSrcList", null, 0, -1, NToMEMFModel.class, IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        EOperation op = initEOperation(getNToMEMFModel__Move__NToMDirection(), null, "move", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theUIInterfacesPackage.getNToMDirection(), "direction", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(defaultEditorEMFModelEClass, DefaultEditorEMFModel.class, "DefaultEditorEMFModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getDefaultEditorEMFModel_SaveAction(), theModelInterfacesPackage.getAction(), null, "saveAction", null, 0, 1, DefaultEditorEMFModel.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getDefaultEditorEMFModel_CancelAction(), theModelInterfacesPackage.getAction(), null, "cancelAction", null, 0, 1, DefaultEditorEMFModel.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(this.getVirtualViewEMFModel());
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(defaultEditorEMFModelEClass_D);
        g1.getETypeArguments().add(g2);
        initEReference(getDefaultEditorEMFModel_VirtualViewEMFModel(), g1, null, "virtualViewEMFModel", null, 0, 1, DefaultEditorEMFModel.class, IS_TRANSIENT, !IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getDefaultEditorEMFModel_EditorID(), ecorePackage.getEString(), "editorID", null, 0, 1, DefaultEditorEMFModel.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(defaultEditorEMFModelEClass_D);
        initEReference(getDefaultEditorEMFModel_InternalModel(), g1, null, "internalModel", null, 0, 1, DefaultEditorEMFModel.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = initEOperation(getDefaultEditorEMFModel__Init__EMFModel_VirtualViewEMFModel(), null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(defaultEditorEMFModelEClass_D);
        addEParameter(op, g1, "internalModel", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(this.getVirtualViewEMFModel());
        g2 = createEGenericType();
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(defaultEditorEMFModelEClass_D);
        g1.getETypeArguments().add(g2);
        addEParameter(op, g1, "virtualViewModel", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getDefaultEditorEMFModel__Init__EMFModel(), null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(defaultEditorEMFModelEClass_D);
        addEParameter(op, g1, "internalModel", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(virtualViewEMFModelEClass, VirtualViewEMFModel.class, "VirtualViewEMFModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        g1 = createEGenericType(virtualViewEMFModelEClass_T);
        initEReference(getVirtualViewEMFModel_Template(), g1, null, "template", null, 0, 1, VirtualViewEMFModel.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getVirtualViewEMFModel_Filter(), ecorePackage.getEString(), "filter", null, 0, 1, VirtualViewEMFModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(virtualViewEMFModelEClass_D);
        initEReference(getVirtualViewEMFModel_List(), g1, null, "list", null, 0, -1, VirtualViewEMFModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getVirtualViewEMFModel_SearchProvider(), theModelInterfacesPackage.getISearchProvider(), "searchProvider", null, 0, 1, VirtualViewEMFModel.class,
                IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(virtualViewEMFModelEClass_D);
        initEReference(getVirtualViewEMFModel_SelectedList(), g1, null, "selectedList", null, 0, -1, VirtualViewEMFModel.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getVirtualViewEMFModel_OpenEditorAction(), theModelInterfacesPackage.getAction(), null, "openEditorAction", null, 0, 1, VirtualViewEMFModel.class,
                IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getVirtualViewEMFModel_FilterColumnsAction(), theModelInterfacesPackage.getAction(), null, "filterColumnsAction", null, 0, 1, VirtualViewEMFModel.class,
                IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getVirtualViewEMFModel_AdvancedFilterAction(), theModelInterfacesPackage.getAction(), null, "advancedFilterAction", null, 0, 1, VirtualViewEMFModel.class,
                IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getVirtualViewEMFModel_RefreshAction(), theModelInterfacesPackage.getAction(), null, "refreshAction", null, 0, 1, VirtualViewEMFModel.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getVirtualViewEMFModel_SelectColumnAction(), theModelInterfacesPackage.getAction(), null, "selectColumnAction", null, 0, 1, VirtualViewEMFModel.class,
                IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getVirtualViewEMFModel_AddAction(), theModelInterfacesPackage.getAction(), null, "addAction", null, 0, 1, VirtualViewEMFModel.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getVirtualViewEMFModel_RemoveAction(), theModelInterfacesPackage.getAction(), null, "removeAction", null, 0, 1, VirtualViewEMFModel.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getVirtualViewEMFModel_ColumnWidths(), theUIInterfacesPackage.getEStructuralFeatureToIntMap(), null, "columnWidths", null, 0, -1, VirtualViewEMFModel.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getVirtualViewEMFModel_ItemCount(), ecorePackage.getEInt(), "itemCount", "-1", 0, 1, VirtualViewEMFModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getVirtualViewEMFModel_ViewID(), ecorePackage.getEString(), "viewID", null, 0, 1, VirtualViewEMFModel.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE,
                !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(ecorePackage.getEJavaClass());
        g2 = createEGenericType(virtualViewEMFModelEClass_D);
        g1.getETypeArguments().add(g2);
        initEAttribute(getVirtualViewEMFModel_ModelClass(), g1, "modelClass", null, 0, 1, VirtualViewEMFModel.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(ecorePackage.getEJavaClass());
        g2 = createEGenericType(virtualViewEMFModelEClass_T);
        g1.getETypeArguments().add(g2);
        initEAttribute(getVirtualViewEMFModel_TemplateClass(), g1, "templateClass", null, 0, 1, VirtualViewEMFModel.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        g1 = createEGenericType(ecorePackage.getEMap());
        g2 = createEGenericType(theModelInterfacesPackage.getEStructuralFeature());
        g1.getETypeArguments().add(g2);
        g2 = createEGenericType(theViewPackage.getFeaturePathDomainModelReference());
        g1.getETypeArguments().add(g2);
        initEAttribute(getVirtualViewEMFModel_ColumnDomainModelReferences(), g1, "columnDomainModelReferences", null, 0, 1, VirtualViewEMFModel.class, IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getVirtualViewEMFModel_EditorModelEClass(), theEcorePackage.getEClass(), null, "editorModelEClass", null, 0, 1, VirtualViewEMFModel.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = initEOperation(getVirtualViewEMFModel__BuildTemplate(), null, "buildTemplate", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(virtualViewEMFModelEClass_T);
        initEOperation(op, g1);

        initEOperation(getVirtualViewEMFModel__OpenEditor(), null, "openEditor", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getVirtualViewEMFModel__SetAdvancedSearchTemplate__AbstractEMFTemplate(), null, "setAdvancedSearchTemplate", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(virtualViewEMFModelEClass_T);
        addEParameter(op, g1, "template", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getVirtualViewEMFModel__Reload__boolean(), ecorePackage.getEBoolean(), "reload", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEBoolean(), "closeEditors", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getVirtualViewEMFModel__SetFilterFeatures__EList_boolean(), null, "setFilterFeatures", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, theModelInterfacesPackage.getEStructuralFeature(), "filterFeatures", 0, -1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEBoolean(), "reload", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEOperation(getVirtualViewEMFModel__CloseEditors(), null, "closeEditors", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getVirtualViewEMFModel__FindEditor__EMFModel(), theUIInterfacesPackage.getIEditorPart(), "findEditor", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(virtualViewEMFModelEClass_D);
        addEParameter(op, g1, "model", 0, 1, IS_UNIQUE, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://com.icteam.loyalty/property
        createPropertyAnnotations();
        // http://com.icteam.loyalty/ui
        createUiAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://com.icteam.loyalty/property</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createPropertyAnnotations() {
        String source = "http://com.icteam.loyalty/property";
        addAnnotation(getNToMEMFModel_SrcList(), source, new String[] { "selectedFeature", "selectedSrcList", "defaultAction", "toDestAction" });
        addAnnotation(getNToMEMFModel_DestList(), source, new String[] { "selectedFeature", "selectedDestList", "defaultAction", "toSrcAction" });
        addAnnotation(getVirtualViewEMFModel_List(), source, new String[] { "selectedFeature", "selectedList", "defaultAction", "openEditorAction" });
    }

    /**
     * Initializes the annotations for <b>http://com.icteam.loyalty/ui</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createUiAnnotations() {
        String source = "http://com.icteam.loyalty/ui";
        addAnnotation(getVirtualViewEMFModel_Filter(), source, new String[] { "filter", "true" });
    }

} //UIModelPackageImpl

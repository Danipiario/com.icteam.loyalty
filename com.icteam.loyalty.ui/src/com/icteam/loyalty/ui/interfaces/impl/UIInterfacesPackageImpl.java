/**
 */
package com.icteam.loyalty.ui.interfaces.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecp.view.spi.model.VViewPackage;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;

import com.icteam.loyalty.api.interfaces.IConstants;
import com.icteam.loyalty.model.ModelPackage;
import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.template.ModelTemplatePackage;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.interfaces.IBaseClassProvider;
import com.icteam.loyalty.ui.interfaces.NToMDirection;
import com.icteam.loyalty.ui.interfaces.UIAction;
import com.icteam.loyalty.ui.interfaces.UIInterfacesFactory;
import com.icteam.loyalty.ui.interfaces.UIInterfacesPackage;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.model.impl.UIModelPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UIInterfacesPackageImpl extends EPackageImpl implements UIInterfacesPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iBaseClassProviderEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass uiActionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass eStructuralFeatureToIntMapEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iEditorInputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iEditorPartEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum nToMDirectionEEnum = null;

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
     * @see com.icteam.loyalty.ui.interfaces.UIInterfacesPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private UIInterfacesPackageImpl() {
        super(eNS_URI, UIInterfacesFactory.eINSTANCE);
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
     * <p>This method is used to initialize {@link UIInterfacesPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static UIInterfacesPackage init() {
        if (isInited) {
            return (UIInterfacesPackage) EPackage.Registry.INSTANCE.getEPackage(UIInterfacesPackage.eNS_URI);
        }

        // Obtain or create and register package
        UIInterfacesPackageImpl theUIInterfacesPackage = (UIInterfacesPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UIInterfacesPackageImpl ? EPackage.Registry.INSTANCE
                .get(eNS_URI) : new UIInterfacesPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ModelTemplatePackage.eINSTANCE.eClass();
        ModelInterfacesPackage.eINSTANCE.eClass();
        ModelPackage.eINSTANCE.eClass();
        VViewPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        UIModelPackageImpl theUIModelPackage = (UIModelPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(UIModelPackage.eNS_URI) instanceof UIModelPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(UIModelPackage.eNS_URI) : UIModelPackage.eINSTANCE);

        // Create package meta-data objects
        theUIInterfacesPackage.createPackageContents();
        theUIModelPackage.createPackageContents();

        // Initialize created meta-data
        theUIInterfacesPackage.initializePackageContents();
        theUIModelPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theUIInterfacesPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(UIInterfacesPackage.eNS_URI, theUIInterfacesPackage);
        return theUIInterfacesPackage;
    }

    @Override
    public void dispose() {
        EPackage.Registry.INSTANCE.remove(UIInterfacesPackage.eNS_URI);
    }

    @Override
    public void freeze() {
        super.freeze();

        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_EDITOR_SAVE().getName(), true, IConstants.EDIT, "save.gif"), Action.class);
        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_EDITOR_CANCEL().getName(), true, IConstants.VIEW, "cancel.gif"), Action.class);

        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_VIEW_OPEN_EDITOR().getName(), true, IConstants.VIEW, null), Action.class);
        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_VIEW_ADVANCED_FILTER().getName(), true, IConstants.VIEW, "advanced_search.gif"), Action.class);
        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_VIEW_FILTER_COLUMNS().getName(), true, IConstants.VIEW, "filter.gif"), Action.class);
        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_VIEW_REFRESH().getName(), true, IConstants.VIEW, "refresh.gif"), Action.class);
        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_VIEW_SELECT_COLUMN().getName(), true, IConstants.VIEW, "select_column.gif"), Action.class);
        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_VIEW_ADD().getName(), false, IConstants.ADD, "add.gif"), Action.class);
        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_VIEW_REMOVE().getName(), false, IConstants.REMOVE, "remove.gif"), Action.class);

        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_NTOM_TO_SRC().getName(), true, IConstants.EDIT, "to_src.gif"), Action.class);
        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_NTOM_ALL_TO_SRC().getName(), true, IConstants.EDIT, "all_to_src.gif"), Action.class);
        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_NTOM_TO_DEST().getName(), true, IConstants.EDIT, "to_dest.gif"), Action.class);
        ModelUtil.registerEnhancedEnum(new UIActionImpl(getUIAction_NTOM_ALL_TO_DEST().getName(), true, IConstants.EDIT, "all_to_dest.gif"), Action.class);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIBaseClassProvider() {
        return iBaseClassProviderEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIBaseClassProvider_BaseClass() {
        return (EAttribute) iBaseClassProviderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getUIAction() {
        return uiActionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_NTOM_ALL_TO_SRC() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_NTOM_TO_SRC() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_NTOM_ALL_TO_DEST() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_NTOM_TO_DEST() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_EDITOR_SAVE() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_EDITOR_CANCEL() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_VIEW_OPEN_EDITOR() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_VIEW_FILTER_COLUMNS() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_VIEW_ADVANCED_FILTER() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_VIEW_REFRESH() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_VIEW_SELECT_COLUMN() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_VIEW_ADD() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUIAction_VIEW_REMOVE() {
        return (EReference) uiActionEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEStructuralFeatureToIntMap() {
        return eStructuralFeatureToIntMapEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEStructuralFeatureToIntMap_Key() {
        return (EAttribute) eStructuralFeatureToIntMapEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEStructuralFeatureToIntMap_Value() {
        return (EAttribute) eStructuralFeatureToIntMapEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIEditorInput() {
        return iEditorInputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIEditorPart() {
        return iEditorPartEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getNToMDirection() {
        return nToMDirectionEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public UIInterfacesFactory getUIInterfacesFactory() {
        return (UIInterfacesFactory) getEFactoryInstance();
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
        iBaseClassProviderEClass = createEClass(IBASE_CLASS_PROVIDER);
        createEAttribute(iBaseClassProviderEClass, IBASE_CLASS_PROVIDER__BASE_CLASS);

        uiActionEClass = createEClass(UI_ACTION);
        createEReference(uiActionEClass, UI_ACTION__NTOM_ALL_TO_SRC);
        createEReference(uiActionEClass, UI_ACTION__NTOM_TO_SRC);
        createEReference(uiActionEClass, UI_ACTION__NTOM_ALL_TO_DEST);
        createEReference(uiActionEClass, UI_ACTION__NTOM_TO_DEST);
        createEReference(uiActionEClass, UI_ACTION__EDITOR_SAVE);
        createEReference(uiActionEClass, UI_ACTION__EDITOR_CANCEL);
        createEReference(uiActionEClass, UI_ACTION__VIEW_OPEN_EDITOR);
        createEReference(uiActionEClass, UI_ACTION__VIEW_FILTER_COLUMNS);
        createEReference(uiActionEClass, UI_ACTION__VIEW_ADVANCED_FILTER);
        createEReference(uiActionEClass, UI_ACTION__VIEW_REFRESH);
        createEReference(uiActionEClass, UI_ACTION__VIEW_SELECT_COLUMN);
        createEReference(uiActionEClass, UI_ACTION__VIEW_ADD);
        createEReference(uiActionEClass, UI_ACTION__VIEW_REMOVE);

        eStructuralFeatureToIntMapEClass = createEClass(ESTRUCTURAL_FEATURE_TO_INT_MAP);
        createEAttribute(eStructuralFeatureToIntMapEClass, ESTRUCTURAL_FEATURE_TO_INT_MAP__KEY);
        createEAttribute(eStructuralFeatureToIntMapEClass, ESTRUCTURAL_FEATURE_TO_INT_MAP__VALUE);

        iEditorInputEClass = createEClass(IEDITOR_INPUT);

        iEditorPartEClass = createEClass(IEDITOR_PART);

        // Create enums
        nToMDirectionEEnum = createEEnum(NTO_MDIRECTION);
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

        // Set bounds for type parameters

        // Add supertypes to classes
        uiActionEClass.getESuperTypes().add(theModelInterfacesPackage.getAction());

        // Initialize classes, features, and operations; add parameters
        initEClass(iBaseClassProviderEClass, IBaseClassProvider.class, "IBaseClassProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        EGenericType g1 = createEGenericType(ecorePackage.getEJavaClass());
        EGenericType g2 = createEGenericType(ecorePackage.getEObject());
        g1.getETypeArguments().add(g2);
        initEAttribute(getIBaseClassProvider_BaseClass(), g1, "baseClass", null, 0, 1, IBaseClassProvider.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(uiActionEClass, UIAction.class, "UIAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUIAction_NTOM_ALL_TO_SRC(), theModelInterfacesPackage.getAction(), null, "NTOM_ALL_TO_SRC", null, 0, 1, UIAction.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUIAction_NTOM_TO_SRC(), theModelInterfacesPackage.getAction(), null, "NTOM_TO_SRC", null, 0, 1, UIAction.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUIAction_NTOM_ALL_TO_DEST(), theModelInterfacesPackage.getAction(), null, "NTOM_ALL_TO_DEST", null, 0, 1, UIAction.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUIAction_NTOM_TO_DEST(), theModelInterfacesPackage.getAction(), null, "NTOM_TO_DEST", null, 0, 1, UIAction.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUIAction_EDITOR_SAVE(), theModelInterfacesPackage.getAction(), null, "EDITOR_SAVE", null, 0, 1, UIAction.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUIAction_EDITOR_CANCEL(), theModelInterfacesPackage.getAction(), null, "EDITOR_CANCEL", null, 0, 1, UIAction.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUIAction_VIEW_OPEN_EDITOR(), theModelInterfacesPackage.getAction(), null, "VIEW_OPEN_EDITOR", null, 0, 1, UIAction.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUIAction_VIEW_FILTER_COLUMNS(), theModelInterfacesPackage.getAction(), null, "VIEW_FILTER_COLUMNS", null, 0, 1, UIAction.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUIAction_VIEW_ADVANCED_FILTER(), theModelInterfacesPackage.getAction(), null, "VIEW_ADVANCED_FILTER", null, 0, 1, UIAction.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUIAction_VIEW_REFRESH(), theModelInterfacesPackage.getAction(), null, "VIEW_REFRESH", null, 0, 1, UIAction.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUIAction_VIEW_SELECT_COLUMN(), theModelInterfacesPackage.getAction(), null, "VIEW_SELECT_COLUMN", null, 0, 1, UIAction.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUIAction_VIEW_ADD(), theModelInterfacesPackage.getAction(), null, "VIEW_ADD", null, 0, 1, UIAction.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getUIAction_VIEW_REMOVE(), theModelInterfacesPackage.getAction(), null, "VIEW_REMOVE", null, 0, 1, UIAction.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(eStructuralFeatureToIntMapEClass, Map.Entry.class, "EStructuralFeatureToIntMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getEStructuralFeatureToIntMap_Key(), theModelInterfacesPackage.getEStructuralFeature(), "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getEStructuralFeatureToIntMap_Value(), ecorePackage.getEIntegerObject(), "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(iEditorInputEClass, IEditorInput.class, "IEditorInput", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        initEClass(iEditorPartEClass, IEditorPart.class, "IEditorPart", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        // Initialize enums and add enum literals
        initEEnum(nToMDirectionEEnum, NToMDirection.class, "NToMDirection");
        addEEnumLiteral(nToMDirectionEEnum, NToMDirection.ALL_TO_SRC);
        addEEnumLiteral(nToMDirectionEEnum, NToMDirection.TO_SRC);
        addEEnumLiteral(nToMDirectionEEnum, NToMDirection.ALL_TO_DEST);
        addEEnumLiteral(nToMDirectionEEnum, NToMDirection.TO_DEST);

        // Create resource
        createResource(eNS_URI);
    }

} //UIInterfacesPackageImpl

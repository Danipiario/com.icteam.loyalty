/**
 */
package com.icteam.loyalty.ui.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.icteam.loyalty.model.ModelPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.ui.model.UIModelFactory
 * @model kind="package"
 * @generated
 */
public interface UIModelPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "model";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://com.icteam.loyalty/ui/model";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "com.icteam.loyalty.ui.model";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    UIModelPackage eINSTANCE = com.icteam.loyalty.ui.model.impl.UIModelPackageImpl.init();

    /**
     * The meta object id for the '{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl <em>NTo MEMF Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl
     * @see com.icteam.loyalty.ui.model.impl.UIModelPackageImpl#getNToMEMFModel()
     * @generated
     */
    int NTO_MEMF_MODEL = 0;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__EDITABLE = ModelPackage.EMF_MODEL__EDITABLE;

    /**
     * The feature id for the '<em><b>Dirty</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__DIRTY = ModelPackage.EMF_MODEL__DIRTY;

    /**
     * The feature id for the '<em><b>Base Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__BASE_CLASS = ModelPackage.EMF_MODEL_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Main EObject</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__MAIN_EOBJECT = ModelPackage.EMF_MODEL_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Main Feature</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__MAIN_FEATURE = ModelPackage.EMF_MODEL_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>All To Src Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__ALL_TO_SRC_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>To Src Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__TO_SRC_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>To Dest Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__TO_DEST_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>All To Dest Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__ALL_TO_DEST_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Src List</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__SRC_LIST = ModelPackage.EMF_MODEL_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Dest List</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__DEST_LIST = ModelPackage.EMF_MODEL_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Selected Dest List</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__SELECTED_DEST_LIST = ModelPackage.EMF_MODEL_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Selected Src List</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL__SELECTED_SRC_LIST = ModelPackage.EMF_MODEL_FEATURE_COUNT + 10;

    /**
     * The number of structural features of the '<em>NTo MEMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL_FEATURE_COUNT = ModelPackage.EMF_MODEL_FEATURE_COUNT + 11;

    /**
     * The operation id for the '<em>Copy To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN = ModelPackage.EMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL___EQUALS__OBJECT = ModelPackage.EMF_MODEL___EQUALS__OBJECT;

    /**
     * The operation id for the '<em>Get Model Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL___GET_MODEL_NAME = ModelPackage.EMF_MODEL___GET_MODEL_NAME;

    /**
     * The operation id for the '<em>Has Editor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL___HAS_EDITOR = ModelPackage.EMF_MODEL___HAS_EDITOR;

    /**
     * The operation id for the '<em>Get Permission Object</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL___GET_PERMISSION_OBJECT = ModelPackage.EMF_MODEL___GET_PERMISSION_OBJECT;

    /**
     * The operation id for the '<em>Move</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL___MOVE__NTOMDIRECTION = ModelPackage.EMF_MODEL_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>NTo MEMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int NTO_MEMF_MODEL_OPERATION_COUNT = ModelPackage.EMF_MODEL_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.ui.model.impl.DefaultEditorEMFModelImpl <em>Default Editor EMF Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.ui.model.impl.DefaultEditorEMFModelImpl
     * @see com.icteam.loyalty.ui.model.impl.UIModelPackageImpl#getDefaultEditorEMFModel()
     * @generated
     */
    int DEFAULT_EDITOR_EMF_MODEL = 1;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL__EDITABLE = ModelPackage.EMF_MODEL__EDITABLE;

    /**
     * The feature id for the '<em><b>Dirty</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL__DIRTY = ModelPackage.EMF_MODEL__DIRTY;

    /**
     * The feature id for the '<em><b>Save Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL__SAVE_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Cancel Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL__CANCEL_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Virtual View EMF Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL__VIRTUAL_VIEW_EMF_MODEL = ModelPackage.EMF_MODEL_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Editor ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL__EDITOR_ID = ModelPackage.EMF_MODEL_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Internal Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL__INTERNAL_MODEL = ModelPackage.EMF_MODEL_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Default Editor EMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL_FEATURE_COUNT = ModelPackage.EMF_MODEL_FEATURE_COUNT + 5;

    /**
     * The operation id for the '<em>Copy To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN = ModelPackage.EMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL___EQUALS__OBJECT = ModelPackage.EMF_MODEL___EQUALS__OBJECT;

    /**
     * The operation id for the '<em>Get Model Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL___GET_MODEL_NAME = ModelPackage.EMF_MODEL___GET_MODEL_NAME;

    /**
     * The operation id for the '<em>Has Editor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL___HAS_EDITOR = ModelPackage.EMF_MODEL___HAS_EDITOR;

    /**
     * The operation id for the '<em>Get Permission Object</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL___GET_PERMISSION_OBJECT = ModelPackage.EMF_MODEL___GET_PERMISSION_OBJECT;

    /**
     * The operation id for the '<em>Init</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL___INIT__EMFMODEL_VIRTUALVIEWEMFMODEL = ModelPackage.EMF_MODEL_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Init</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL___INIT__EMFMODEL = ModelPackage.EMF_MODEL_OPERATION_COUNT + 1;

    /**
     * The number of operations of the '<em>Default Editor EMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DEFAULT_EDITOR_EMF_MODEL_OPERATION_COUNT = ModelPackage.EMF_MODEL_OPERATION_COUNT + 2;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl <em>Virtual View EMF Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl
     * @see com.icteam.loyalty.ui.model.impl.UIModelPackageImpl#getVirtualViewEMFModel()
     * @generated
     */
    int VIRTUAL_VIEW_EMF_MODEL = 2;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__EDITABLE = ModelPackage.EMF_MODEL__EDITABLE;

    /**
     * The feature id for the '<em><b>Dirty</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__DIRTY = ModelPackage.EMF_MODEL__DIRTY;

    /**
     * The feature id for the '<em><b>Base Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__BASE_CLASS = ModelPackage.EMF_MODEL_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Template</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__TEMPLATE = ModelPackage.EMF_MODEL_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__FILTER = ModelPackage.EMF_MODEL_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>List</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__LIST = ModelPackage.EMF_MODEL_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Search Provider</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__SEARCH_PROVIDER = ModelPackage.EMF_MODEL_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Selected List</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST = ModelPackage.EMF_MODEL_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Open Editor Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__OPEN_EDITOR_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Filter Columns Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__FILTER_COLUMNS_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Advanced Filter Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__ADVANCED_FILTER_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>Refresh Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__REFRESH_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Select Column Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__SELECT_COLUMN_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>Add Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__ADD_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>Remove Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__REMOVE_ACTION = ModelPackage.EMF_MODEL_FEATURE_COUNT + 12;

    /**
     * The feature id for the '<em><b>Column Widths</b></em>' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__COLUMN_WIDTHS = ModelPackage.EMF_MODEL_FEATURE_COUNT + 13;

    /**
     * The feature id for the '<em><b>Item Count</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT = ModelPackage.EMF_MODEL_FEATURE_COUNT + 14;

    /**
     * The feature id for the '<em><b>View ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__VIEW_ID = ModelPackage.EMF_MODEL_FEATURE_COUNT + 15;

    /**
     * The feature id for the '<em><b>Model Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__MODEL_CLASS = ModelPackage.EMF_MODEL_FEATURE_COUNT + 16;

    /**
     * The feature id for the '<em><b>Template Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__TEMPLATE_CLASS = ModelPackage.EMF_MODEL_FEATURE_COUNT + 17;

    /**
     * The feature id for the '<em><b>Column Domain Model References</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__COLUMN_DOMAIN_MODEL_REFERENCES = ModelPackage.EMF_MODEL_FEATURE_COUNT + 18;

    /**
     * The feature id for the '<em><b>Editor Model EClass</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL__EDITOR_MODEL_ECLASS = ModelPackage.EMF_MODEL_FEATURE_COUNT + 19;

    /**
     * The number of structural features of the '<em>Virtual View EMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL_FEATURE_COUNT = ModelPackage.EMF_MODEL_FEATURE_COUNT + 20;

    /**
     * The operation id for the '<em>Copy To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN = ModelPackage.EMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL___EQUALS__OBJECT = ModelPackage.EMF_MODEL___EQUALS__OBJECT;

    /**
     * The operation id for the '<em>Get Model Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL___GET_MODEL_NAME = ModelPackage.EMF_MODEL___GET_MODEL_NAME;

    /**
     * The operation id for the '<em>Has Editor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL___HAS_EDITOR = ModelPackage.EMF_MODEL___HAS_EDITOR;

    /**
     * The operation id for the '<em>Get Permission Object</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL___GET_PERMISSION_OBJECT = ModelPackage.EMF_MODEL___GET_PERMISSION_OBJECT;

    /**
     * The operation id for the '<em>Build Template</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL___BUILD_TEMPLATE = ModelPackage.EMF_MODEL_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Open Editor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL___OPEN_EDITOR = ModelPackage.EMF_MODEL_OPERATION_COUNT + 1;

    /**
     * The operation id for the '<em>Set Advanced Search Template</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL___SET_ADVANCED_SEARCH_TEMPLATE__ABSTRACTEMFTEMPLATE = ModelPackage.EMF_MODEL_OPERATION_COUNT + 2;

    /**
     * The operation id for the '<em>Reload</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL___RELOAD__BOOLEAN = ModelPackage.EMF_MODEL_OPERATION_COUNT + 3;

    /**
     * The operation id for the '<em>Set Filter Features</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL___SET_FILTER_FEATURES__ELIST_BOOLEAN = ModelPackage.EMF_MODEL_OPERATION_COUNT + 4;

    /**
     * The operation id for the '<em>Close Editors</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL___CLOSE_EDITORS = ModelPackage.EMF_MODEL_OPERATION_COUNT + 5;

    /**
     * The operation id for the '<em>Find Editor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL___FIND_EDITOR__EMFMODEL = ModelPackage.EMF_MODEL_OPERATION_COUNT + 6;

    /**
     * The number of operations of the '<em>Virtual View EMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int VIRTUAL_VIEW_EMF_MODEL_OPERATION_COUNT = ModelPackage.EMF_MODEL_OPERATION_COUNT + 7;

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.ui.model.NToMEMFModel <em>NTo MEMF Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>NTo MEMF Model</em>'.
     * @see com.icteam.loyalty.ui.model.NToMEMFModel
     * @generated
     */
    EClass getNToMEMFModel();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.NToMEMFModel#getAllToSrcAction <em>All To Src Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>All To Src Action</em>'.
     * @see com.icteam.loyalty.ui.model.NToMEMFModel#getAllToSrcAction()
     * @see #getNToMEMFModel()
     * @generated
     */
    EReference getNToMEMFModel_AllToSrcAction();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.NToMEMFModel#getToSrcAction <em>To Src Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>To Src Action</em>'.
     * @see com.icteam.loyalty.ui.model.NToMEMFModel#getToSrcAction()
     * @see #getNToMEMFModel()
     * @generated
     */
    EReference getNToMEMFModel_ToSrcAction();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.NToMEMFModel#getToDestAction <em>To Dest Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>To Dest Action</em>'.
     * @see com.icteam.loyalty.ui.model.NToMEMFModel#getToDestAction()
     * @see #getNToMEMFModel()
     * @generated
     */
    EReference getNToMEMFModel_ToDestAction();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.NToMEMFModel#getAllToDestAction <em>All To Dest Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>All To Dest Action</em>'.
     * @see com.icteam.loyalty.ui.model.NToMEMFModel#getAllToDestAction()
     * @see #getNToMEMFModel()
     * @generated
     */
    EReference getNToMEMFModel_AllToDestAction();

    /**
     * Returns the meta object for the reference list '{@link com.icteam.loyalty.ui.model.NToMEMFModel#getSrcList <em>Src List</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Src List</em>'.
     * @see com.icteam.loyalty.ui.model.NToMEMFModel#getSrcList()
     * @see #getNToMEMFModel()
     * @generated
     */
    EReference getNToMEMFModel_SrcList();

    /**
     * Returns the meta object for the reference list '{@link com.icteam.loyalty.ui.model.NToMEMFModel#getDestList <em>Dest List</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Dest List</em>'.
     * @see com.icteam.loyalty.ui.model.NToMEMFModel#getDestList()
     * @see #getNToMEMFModel()
     * @generated
     */
    EReference getNToMEMFModel_DestList();

    /**
     * Returns the meta object for the reference list '{@link com.icteam.loyalty.ui.model.NToMEMFModel#getSelectedDestList <em>Selected Dest List</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Selected Dest List</em>'.
     * @see com.icteam.loyalty.ui.model.NToMEMFModel#getSelectedDestList()
     * @see #getNToMEMFModel()
     * @generated
     */
    EReference getNToMEMFModel_SelectedDestList();

    /**
     * Returns the meta object for the reference list '{@link com.icteam.loyalty.ui.model.NToMEMFModel#getSelectedSrcList <em>Selected Src List</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Selected Src List</em>'.
     * @see com.icteam.loyalty.ui.model.NToMEMFModel#getSelectedSrcList()
     * @see #getNToMEMFModel()
     * @generated
     */
    EReference getNToMEMFModel_SelectedSrcList();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.ui.model.NToMEMFModel#move(com.icteam.loyalty.ui.interfaces.NToMDirection) <em>Move</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Move</em>' operation.
     * @see com.icteam.loyalty.ui.model.NToMEMFModel#move(com.icteam.loyalty.ui.interfaces.NToMDirection)
     * @generated
     */
    EOperation getNToMEMFModel__Move__NToMDirection();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel <em>Default Editor EMF Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Default Editor EMF Model</em>'.
     * @see com.icteam.loyalty.ui.model.DefaultEditorEMFModel
     * @generated
     */
    EClass getDefaultEditorEMFModel();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getSaveAction <em>Save Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Save Action</em>'.
     * @see com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getSaveAction()
     * @see #getDefaultEditorEMFModel()
     * @generated
     */
    EReference getDefaultEditorEMFModel_SaveAction();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getCancelAction <em>Cancel Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Cancel Action</em>'.
     * @see com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getCancelAction()
     * @see #getDefaultEditorEMFModel()
     * @generated
     */
    EReference getDefaultEditorEMFModel_CancelAction();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getInternalModel <em>Internal Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Internal Model</em>'.
     * @see com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getInternalModel()
     * @see #getDefaultEditorEMFModel()
     * @generated
     */
    EReference getDefaultEditorEMFModel_InternalModel();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel#init(com.icteam.loyalty.model.EMFModel, com.icteam.loyalty.ui.model.VirtualViewEMFModel) <em>Init</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Init</em>' operation.
     * @see com.icteam.loyalty.ui.model.DefaultEditorEMFModel#init(com.icteam.loyalty.model.EMFModel, com.icteam.loyalty.ui.model.VirtualViewEMFModel)
     * @generated
     */
    EOperation getDefaultEditorEMFModel__Init__EMFModel_VirtualViewEMFModel();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel#init(com.icteam.loyalty.model.EMFModel) <em>Init</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Init</em>' operation.
     * @see com.icteam.loyalty.ui.model.DefaultEditorEMFModel#init(com.icteam.loyalty.model.EMFModel)
     * @generated
     */
    EOperation getDefaultEditorEMFModel__Init__EMFModel();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getVirtualViewEMFModel <em>Virtual View EMF Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Virtual View EMF Model</em>'.
     * @see com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getVirtualViewEMFModel()
     * @see #getDefaultEditorEMFModel()
     * @generated
     */
    EReference getDefaultEditorEMFModel_VirtualViewEMFModel();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getEditorID <em>Editor ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Editor ID</em>'.
     * @see com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getEditorID()
     * @see #getDefaultEditorEMFModel()
     * @generated
     */
    EAttribute getDefaultEditorEMFModel_EditorID();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel <em>Virtual View EMF Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Virtual View EMF Model</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel
     * @generated
     */
    EClass getVirtualViewEMFModel();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getTemplate <em>Template</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Template</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getTemplate()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EReference getVirtualViewEMFModel_Template();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getFilter <em>Filter</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Filter</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getFilter()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EAttribute getVirtualViewEMFModel_Filter();

    /**
     * Returns the meta object for the reference list '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getList <em>List</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>List</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getList()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EReference getVirtualViewEMFModel_List();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getSearchProvider <em>Search Provider</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Search Provider</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getSearchProvider()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EAttribute getVirtualViewEMFModel_SearchProvider();

    /**
     * Returns the meta object for the reference list '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getSelectedList <em>Selected List</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Selected List</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getSelectedList()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EReference getVirtualViewEMFModel_SelectedList();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getOpenEditorAction <em>Open Editor Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Open Editor Action</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getOpenEditorAction()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EReference getVirtualViewEMFModel_OpenEditorAction();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getFilterColumnsAction <em>Filter Columns Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Filter Columns Action</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getFilterColumnsAction()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EReference getVirtualViewEMFModel_FilterColumnsAction();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getAdvancedFilterAction <em>Advanced Filter Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Advanced Filter Action</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getAdvancedFilterAction()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EReference getVirtualViewEMFModel_AdvancedFilterAction();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getRefreshAction <em>Refresh Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Refresh Action</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getRefreshAction()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EReference getVirtualViewEMFModel_RefreshAction();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getSelectColumnAction <em>Select Column Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Select Column Action</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getSelectColumnAction()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EReference getVirtualViewEMFModel_SelectColumnAction();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getAddAction <em>Add Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Add Action</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getAddAction()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EReference getVirtualViewEMFModel_AddAction();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getRemoveAction <em>Remove Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Remove Action</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getRemoveAction()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EReference getVirtualViewEMFModel_RemoveAction();

    /**
     * Returns the meta object for the map '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getColumnWidths <em>Column Widths</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the map '<em>Column Widths</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getColumnWidths()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EReference getVirtualViewEMFModel_ColumnWidths();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getItemCount <em>Item Count</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Item Count</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getItemCount()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EAttribute getVirtualViewEMFModel_ItemCount();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getViewID <em>View ID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>View ID</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getViewID()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EAttribute getVirtualViewEMFModel_ViewID();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getModelClass <em>Model Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Model Class</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getModelClass()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EAttribute getVirtualViewEMFModel_ModelClass();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getTemplateClass <em>Template Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Template Class</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getTemplateClass()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EAttribute getVirtualViewEMFModel_TemplateClass();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getColumnDomainModelReferences <em>Column Domain Model References</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Column Domain Model References</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getColumnDomainModelReferences()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EAttribute getVirtualViewEMFModel_ColumnDomainModelReferences();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#getEditorModelEClass <em>Editor Model EClass</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Editor Model EClass</em>'.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#getEditorModelEClass()
     * @see #getVirtualViewEMFModel()
     * @generated
     */
    EReference getVirtualViewEMFModel_EditorModelEClass();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#buildTemplate() <em>Build Template</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Build Template</em>' operation.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#buildTemplate()
     * @generated
     */
    EOperation getVirtualViewEMFModel__BuildTemplate();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#openEditor() <em>Open Editor</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Open Editor</em>' operation.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#openEditor()
     * @generated
     */
    EOperation getVirtualViewEMFModel__OpenEditor();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#setAdvancedSearchTemplate(com.icteam.loyalty.model.template.AbstractEMFTemplate) <em>Set Advanced Search Template</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Set Advanced Search Template</em>' operation.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#setAdvancedSearchTemplate(com.icteam.loyalty.model.template.AbstractEMFTemplate)
     * @generated
     */
    EOperation getVirtualViewEMFModel__SetAdvancedSearchTemplate__AbstractEMFTemplate();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#reload(boolean) <em>Reload</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Reload</em>' operation.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#reload(boolean)
     * @generated
     */
    EOperation getVirtualViewEMFModel__Reload__boolean();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#setFilterFeatures(org.eclipse.emf.common.util.EList, boolean) <em>Set Filter Features</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Set Filter Features</em>' operation.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#setFilterFeatures(org.eclipse.emf.common.util.EList, boolean)
     * @generated
     */
    EOperation getVirtualViewEMFModel__SetFilterFeatures__EList_boolean();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#closeEditors() <em>Close Editors</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Close Editors</em>' operation.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#closeEditors()
     * @generated
     */
    EOperation getVirtualViewEMFModel__CloseEditors();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel#findEditor(com.icteam.loyalty.model.EMFModel) <em>Find Editor</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Find Editor</em>' operation.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel#findEditor(com.icteam.loyalty.model.EMFModel)
     * @generated
     */
    EOperation getVirtualViewEMFModel__FindEditor__EMFModel();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    UIModelFactory getUIModelFactory();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl <em>NTo MEMF Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl
         * @see com.icteam.loyalty.ui.model.impl.UIModelPackageImpl#getNToMEMFModel()
         * @generated
         */
        EClass NTO_MEMF_MODEL = eINSTANCE.getNToMEMFModel();

        /**
         * The meta object literal for the '<em><b>All To Src Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NTO_MEMF_MODEL__ALL_TO_SRC_ACTION = eINSTANCE.getNToMEMFModel_AllToSrcAction();

        /**
         * The meta object literal for the '<em><b>To Src Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NTO_MEMF_MODEL__TO_SRC_ACTION = eINSTANCE.getNToMEMFModel_ToSrcAction();

        /**
         * The meta object literal for the '<em><b>To Dest Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NTO_MEMF_MODEL__TO_DEST_ACTION = eINSTANCE.getNToMEMFModel_ToDestAction();

        /**
         * The meta object literal for the '<em><b>All To Dest Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NTO_MEMF_MODEL__ALL_TO_DEST_ACTION = eINSTANCE.getNToMEMFModel_AllToDestAction();

        /**
         * The meta object literal for the '<em><b>Src List</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NTO_MEMF_MODEL__SRC_LIST = eINSTANCE.getNToMEMFModel_SrcList();

        /**
         * The meta object literal for the '<em><b>Dest List</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NTO_MEMF_MODEL__DEST_LIST = eINSTANCE.getNToMEMFModel_DestList();

        /**
         * The meta object literal for the '<em><b>Selected Dest List</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NTO_MEMF_MODEL__SELECTED_DEST_LIST = eINSTANCE.getNToMEMFModel_SelectedDestList();

        /**
         * The meta object literal for the '<em><b>Selected Src List</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference NTO_MEMF_MODEL__SELECTED_SRC_LIST = eINSTANCE.getNToMEMFModel_SelectedSrcList();

        /**
         * The meta object literal for the '<em><b>Move</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation NTO_MEMF_MODEL___MOVE__NTOMDIRECTION = eINSTANCE.getNToMEMFModel__Move__NToMDirection();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.ui.model.impl.DefaultEditorEMFModelImpl <em>Default Editor EMF Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.ui.model.impl.DefaultEditorEMFModelImpl
         * @see com.icteam.loyalty.ui.model.impl.UIModelPackageImpl#getDefaultEditorEMFModel()
         * @generated
         */
        EClass DEFAULT_EDITOR_EMF_MODEL = eINSTANCE.getDefaultEditorEMFModel();

        /**
         * The meta object literal for the '<em><b>Save Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEFAULT_EDITOR_EMF_MODEL__SAVE_ACTION = eINSTANCE.getDefaultEditorEMFModel_SaveAction();

        /**
         * The meta object literal for the '<em><b>Cancel Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEFAULT_EDITOR_EMF_MODEL__CANCEL_ACTION = eINSTANCE.getDefaultEditorEMFModel_CancelAction();

        /**
         * The meta object literal for the '<em><b>Internal Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEFAULT_EDITOR_EMF_MODEL__INTERNAL_MODEL = eINSTANCE.getDefaultEditorEMFModel_InternalModel();

        /**
         * The meta object literal for the '<em><b>Init</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation DEFAULT_EDITOR_EMF_MODEL___INIT__EMFMODEL_VIRTUALVIEWEMFMODEL = eINSTANCE.getDefaultEditorEMFModel__Init__EMFModel_VirtualViewEMFModel();

        /**
         * The meta object literal for the '<em><b>Init</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation DEFAULT_EDITOR_EMF_MODEL___INIT__EMFMODEL = eINSTANCE.getDefaultEditorEMFModel__Init__EMFModel();

        /**
         * The meta object literal for the '<em><b>Virtual View EMF Model</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DEFAULT_EDITOR_EMF_MODEL__VIRTUAL_VIEW_EMF_MODEL = eINSTANCE.getDefaultEditorEMFModel_VirtualViewEMFModel();

        /**
         * The meta object literal for the '<em><b>Editor ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DEFAULT_EDITOR_EMF_MODEL__EDITOR_ID = eINSTANCE.getDefaultEditorEMFModel_EditorID();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl <em>Virtual View EMF Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.ui.model.impl.VirtualViewEMFModelImpl
         * @see com.icteam.loyalty.ui.model.impl.UIModelPackageImpl#getVirtualViewEMFModel()
         * @generated
         */
        EClass VIRTUAL_VIEW_EMF_MODEL = eINSTANCE.getVirtualViewEMFModel();

        /**
         * The meta object literal for the '<em><b>Template</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIRTUAL_VIEW_EMF_MODEL__TEMPLATE = eINSTANCE.getVirtualViewEMFModel_Template();

        /**
         * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIRTUAL_VIEW_EMF_MODEL__FILTER = eINSTANCE.getVirtualViewEMFModel_Filter();

        /**
         * The meta object literal for the '<em><b>List</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIRTUAL_VIEW_EMF_MODEL__LIST = eINSTANCE.getVirtualViewEMFModel_List();

        /**
         * The meta object literal for the '<em><b>Search Provider</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIRTUAL_VIEW_EMF_MODEL__SEARCH_PROVIDER = eINSTANCE.getVirtualViewEMFModel_SearchProvider();

        /**
         * The meta object literal for the '<em><b>Selected List</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST = eINSTANCE.getVirtualViewEMFModel_SelectedList();

        /**
         * The meta object literal for the '<em><b>Open Editor Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIRTUAL_VIEW_EMF_MODEL__OPEN_EDITOR_ACTION = eINSTANCE.getVirtualViewEMFModel_OpenEditorAction();

        /**
         * The meta object literal for the '<em><b>Filter Columns Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIRTUAL_VIEW_EMF_MODEL__FILTER_COLUMNS_ACTION = eINSTANCE.getVirtualViewEMFModel_FilterColumnsAction();

        /**
         * The meta object literal for the '<em><b>Advanced Filter Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIRTUAL_VIEW_EMF_MODEL__ADVANCED_FILTER_ACTION = eINSTANCE.getVirtualViewEMFModel_AdvancedFilterAction();

        /**
         * The meta object literal for the '<em><b>Refresh Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIRTUAL_VIEW_EMF_MODEL__REFRESH_ACTION = eINSTANCE.getVirtualViewEMFModel_RefreshAction();

        /**
         * The meta object literal for the '<em><b>Select Column Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIRTUAL_VIEW_EMF_MODEL__SELECT_COLUMN_ACTION = eINSTANCE.getVirtualViewEMFModel_SelectColumnAction();

        /**
         * The meta object literal for the '<em><b>Add Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIRTUAL_VIEW_EMF_MODEL__ADD_ACTION = eINSTANCE.getVirtualViewEMFModel_AddAction();

        /**
         * The meta object literal for the '<em><b>Remove Action</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIRTUAL_VIEW_EMF_MODEL__REMOVE_ACTION = eINSTANCE.getVirtualViewEMFModel_RemoveAction();

        /**
         * The meta object literal for the '<em><b>Column Widths</b></em>' map feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIRTUAL_VIEW_EMF_MODEL__COLUMN_WIDTHS = eINSTANCE.getVirtualViewEMFModel_ColumnWidths();

        /**
         * The meta object literal for the '<em><b>Item Count</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT = eINSTANCE.getVirtualViewEMFModel_ItemCount();

        /**
         * The meta object literal for the '<em><b>View ID</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIRTUAL_VIEW_EMF_MODEL__VIEW_ID = eINSTANCE.getVirtualViewEMFModel_ViewID();

        /**
         * The meta object literal for the '<em><b>Model Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIRTUAL_VIEW_EMF_MODEL__MODEL_CLASS = eINSTANCE.getVirtualViewEMFModel_ModelClass();

        /**
         * The meta object literal for the '<em><b>Template Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIRTUAL_VIEW_EMF_MODEL__TEMPLATE_CLASS = eINSTANCE.getVirtualViewEMFModel_TemplateClass();

        /**
         * The meta object literal for the '<em><b>Column Domain Model References</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute VIRTUAL_VIEW_EMF_MODEL__COLUMN_DOMAIN_MODEL_REFERENCES = eINSTANCE.getVirtualViewEMFModel_ColumnDomainModelReferences();

        /**
         * The meta object literal for the '<em><b>Editor Model EClass</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference VIRTUAL_VIEW_EMF_MODEL__EDITOR_MODEL_ECLASS = eINSTANCE.getVirtualViewEMFModel_EditorModelEClass();

        /**
         * The meta object literal for the '<em><b>Build Template</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation VIRTUAL_VIEW_EMF_MODEL___BUILD_TEMPLATE = eINSTANCE.getVirtualViewEMFModel__BuildTemplate();

        /**
         * The meta object literal for the '<em><b>Open Editor</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation VIRTUAL_VIEW_EMF_MODEL___OPEN_EDITOR = eINSTANCE.getVirtualViewEMFModel__OpenEditor();

        /**
         * The meta object literal for the '<em><b>Set Advanced Search Template</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation VIRTUAL_VIEW_EMF_MODEL___SET_ADVANCED_SEARCH_TEMPLATE__ABSTRACTEMFTEMPLATE = eINSTANCE.getVirtualViewEMFModel__SetAdvancedSearchTemplate__AbstractEMFTemplate();

        /**
         * The meta object literal for the '<em><b>Reload</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation VIRTUAL_VIEW_EMF_MODEL___RELOAD__BOOLEAN = eINSTANCE.getVirtualViewEMFModel__Reload__boolean();

        /**
         * The meta object literal for the '<em><b>Set Filter Features</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation VIRTUAL_VIEW_EMF_MODEL___SET_FILTER_FEATURES__ELIST_BOOLEAN = eINSTANCE.getVirtualViewEMFModel__SetFilterFeatures__EList_boolean();

        /**
         * The meta object literal for the '<em><b>Close Editors</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation VIRTUAL_VIEW_EMF_MODEL___CLOSE_EDITORS = eINSTANCE.getVirtualViewEMFModel__CloseEditors();

        /**
         * The meta object literal for the '<em><b>Find Editor</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation VIRTUAL_VIEW_EMF_MODEL___FIND_EDITOR__EMFMODEL = eINSTANCE.getVirtualViewEMFModel__FindEditor__EMFModel();

    }

    void dispose();

} //UIModelPackage

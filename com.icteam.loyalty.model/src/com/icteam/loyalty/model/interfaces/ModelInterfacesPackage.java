/**
 */
package com.icteam.loyalty.model.interfaces;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesFactory
 * @model kind="package"
 * @generated
 */
public interface ModelInterfacesPackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "interfaces";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://com.icteam.loyalty/model/interfaces";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "com.icteam.loyalty.model.interfaces";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModelInterfacesPackage eINSTANCE = com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl.init();

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.IEditable <em>IEditable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.IEditable
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIEditable()
     * @generated
     */
    int IEDITABLE = 1;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEDITABLE__EDITABLE = 0;

    /**
     * The feature id for the '<em><b>Dirty</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEDITABLE__DIRTY = 1;

    /**
     * The number of structural features of the '<em>IEditable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEDITABLE_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>IEditable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEDITABLE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.IEMFModel <em>IEMF Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.IEMFModel
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIEMFModel()
     * @generated
     */
    int IEMF_MODEL = 0;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_MODEL__EDITABLE = IEDITABLE__EDITABLE;

    /**
     * The feature id for the '<em><b>Dirty</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_MODEL__DIRTY = IEDITABLE__DIRTY;

    /**
     * The number of structural features of the '<em>IEMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_MODEL_FEATURE_COUNT = IEDITABLE_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Copy To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN = IEDITABLE_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_MODEL___EQUALS__OBJECT = IEDITABLE_OPERATION_COUNT + 1;

    /**
     * The number of operations of the '<em>IEMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_MODEL_OPERATION_COUNT = IEDITABLE_OPERATION_COUNT + 2;

    /**
     * The meta object id for the '{@link java.lang.Comparable <em>Comparable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Comparable
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getComparable()
     * @generated
     */
    int COMPARABLE = 8;

    /**
     * The number of structural features of the '<em>Comparable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPARABLE_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>Comparable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPARABLE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum <em>IEMF Enhanced Enum</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIEMFEnhancedEnum()
     * @generated
     */
    int IEMF_ENHANCED_ENUM = 2;

    /**
     * The number of structural features of the '<em>IEMF Enhanced Enum</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_ENHANCED_ENUM_FEATURE_COUNT = COMPARABLE_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Compare To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_ENHANCED_ENUM___COMPARE_TO__IEMFENHANCEDENUM = COMPARABLE_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Get Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_ENHANCED_ENUM___GET_NAME = COMPARABLE_OPERATION_COUNT + 1;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_ENHANCED_ENUM___EQUALS__OBJECT = COMPARABLE_OPERATION_COUNT + 2;

    /**
     * The number of operations of the '<em>IEMF Enhanced Enum</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_ENHANCED_ENUM_OPERATION_COUNT = COMPARABLE_OPERATION_COUNT + 3;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate <em>IEMF Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIEMFTemplate()
     * @generated
     */
    int IEMF_TEMPLATE = 4;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.IStatusEMFTemplate <em>IStatus EMF Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.IStatusEMFTemplate
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIStatusEMFTemplate()
     * @generated
     */
    int ISTATUS_EMF_TEMPLATE = 6;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.IEMFSelectable <em>IEMF Selectable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.IEMFSelectable
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIEMFSelectable()
     * @generated
     */
    int IEMF_SELECTABLE = 7;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.DistinctEMF <em>Distinct EMF</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.DistinctEMF
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getDistinctEMF()
     * @generated
     */
    int DISTINCT_EMF = 19;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.OrderDirectionEMF <em>Order Direction EMF</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.OrderDirectionEMF
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getOrderDirectionEMF()
     * @generated
     */
    int ORDER_DIRECTION_EMF = 20;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.EWhereClauseEMF <em>EWhere Clause EMF</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.EWhereClauseEMF
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getEWhereClauseEMF()
     * @generated
     */
    int EWHERE_CLAUSE_EMF = 21;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.EWhereTemplateClauseEMF <em>EWhere Template Clause EMF</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.EWhereTemplateClauseEMF
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getEWhereTemplateClauseEMF()
     * @generated
     */
    int EWHERE_TEMPLATE_CLAUSE_EMF = 22;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.EDynamicFilterableEMF <em>EDynamic Filterable EMF</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.EDynamicFilterableEMF
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getEDynamicFilterableEMF()
     * @generated
     */
    int EDYNAMIC_FILTERABLE_EMF = 23;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.impl.StatusImpl <em>Status</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.impl.StatusImpl
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getStatus()
     * @generated
     */
    int STATUS = 10;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.impl.PerspectiveImpl <em>Perspective</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.impl.PerspectiveImpl
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getPerspective()
     * @generated
     */
    int PERSPECTIVE = 12;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl <em>Status Reason</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getStatusReason()
     * @generated
     */
    int STATUS_REASON = 11;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.impl.LanguageImpl <em>Language</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.impl.LanguageImpl
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getLanguage()
     * @generated
     */
    int LANGUAGE = 13;

    /**
     * The meta object id for the '<em>Image</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.swt.graphics.Image
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getImage()
     * @generated
     */
    int IMAGE = 24;

    /**
     * The meta object id for the '<em>EStructural Feature</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EStructuralFeature
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getEStructuralFeature()
     * @generated
     */
    int ESTRUCTURAL_FEATURE = 25;

    /**
     * The meta object id for the '<em>Entity Manager</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see javax.persistence.EntityManager
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getEntityManager()
     * @generated
     */
    int ENTITY_MANAGER = 26;

    /**
     * The meta object id for the '{@link java.io.Serializable <em>Serializable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.io.Serializable
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getSerializable()
     * @generated
     */
    int SERIALIZABLE = 9;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.IPerspectiveProvider <em>IPerspective Provider</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.IPerspectiveProvider
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIPerspectiveProvider()
     * @generated
     */
    int IPERSPECTIVE_PROVIDER = 5;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.impl.PermissionImpl <em>Permission</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.impl.PermissionImpl
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getPermission()
     * @generated
     */
    int PERMISSION = 3;

    /**
     * The feature id for the '<em><b>ADMINISTRATION PERSPECTIVE VIEW</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION__ADMINISTRATION_PERSPECTIVE_VIEW = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>CONFIGURATION PERSPECTIVE VIEW</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION__CONFIGURATION_PERSPECTIVE_VIEW = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Object</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION__OBJECT = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Action</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION__ACTION = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION__NAME = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Permission</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION_FEATURE_COUNT = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 5;

    /**
     * The operation id for the '<em>Compare To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION___COMPARE_TO__IEMFENHANCEDENUM = IEMF_ENHANCED_ENUM___COMPARE_TO__IEMFENHANCEDENUM;

    /**
     * The operation id for the '<em>Get Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION___GET_NAME = IEMF_ENHANCED_ENUM___GET_NAME;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION___EQUALS__OBJECT = IEMF_ENHANCED_ENUM___EQUALS__OBJECT;

    /**
     * The operation id for the '<em>Is Star Permission</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION___IS_STAR_PERMISSION = IEMF_ENHANCED_ENUM_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Get Permission</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION___GET_PERMISSION = IEMF_ENHANCED_ENUM_OPERATION_COUNT + 1;

    /**
     * The operation id for the '<em>Get Permissions</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION___GET_PERMISSIONS = IEMF_ENHANCED_ENUM_OPERATION_COUNT + 2;

    /**
     * The number of operations of the '<em>Permission</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERMISSION_OPERATION_COUNT = IEMF_ENHANCED_ENUM_OPERATION_COUNT + 3;

    /**
     * The feature id for the '<em><b>Distinct</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__DISTINCT = 0;

    /**
     * The feature id for the '<em><b>First Result</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__FIRST_RESULT = 1;

    /**
     * The feature id for the '<em><b>Max Results</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__MAX_RESULTS = 2;

    /**
     * The feature id for the '<em><b>Single Result</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__SINGLE_RESULT = 3;

    /**
     * The feature id for the '<em><b>Light Search</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__LIGHT_SEARCH = 4;

    /**
     * The feature id for the '<em><b>Nested</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__NESTED = 5;

    /**
     * The feature id for the '<em><b>Order Features</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__ORDER_FEATURES = 6;

    /**
     * The feature id for the '<em><b>Order Directions</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__ORDER_DIRECTIONS = 7;

    /**
     * The feature id for the '<em><b>Dynamic Filter Features</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__DYNAMIC_FILTER_FEATURES = 8;

    /**
     * The feature id for the '<em><b>Dynamic Filters</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__DYNAMIC_FILTERS = 9;

    /**
     * The feature id for the '<em><b>Dynamic Order Feature</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__DYNAMIC_ORDER_FEATURE = 10;

    /**
     * The feature id for the '<em><b>Dynamic Order Direction</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION = 11;

    /**
     * The feature id for the '<em><b>Dynamic Filterable Features</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES = 12;

    /**
     * The number of structural features of the '<em>IEMF Template</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE_FEATURE_COUNT = 13;

    /**
     * The operation id for the '<em>Initialized</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE___INITIALIZED = 0;

    /**
     * The operation id for the '<em>Get Result Count</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE___GET_RESULT_COUNT__ENTITYMANAGER = 1;

    /**
     * The operation id for the '<em>Get First Result</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE___GET_FIRST_RESULT__ENTITYMANAGER = 2;

    /**
     * The operation id for the '<em>Get Result List</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE___GET_RESULT_LIST__ENTITYMANAGER = 3;

    /**
     * The operation id for the '<em>Has Dynamic Filters</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE___HAS_DYNAMIC_FILTERS = 4;

    /**
     * The operation id for the '<em>Set Dynamic Filter Features</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE___SET_DYNAMIC_FILTER_FEATURES__ELIST = 5;

    /**
     * The operation id for the '<em>Set Raw Filter</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE___SET_RAW_FILTER__STRING = 6;

    /**
     * The operation id for the '<em>Has Dynamic Order</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE___HAS_DYNAMIC_ORDER = 7;

    /**
     * The operation id for the '<em>Get Db Model Class</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE___GET_DB_MODEL_CLASS = 8;

    /**
     * The operation id for the '<em>Get Id Value</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE___GET_ID_VALUE = 9;

    /**
     * The number of operations of the '<em>IEMF Template</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_TEMPLATE_OPERATION_COUNT = 10;

    /**
     * The feature id for the '<em><b>Default Perspective</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IPERSPECTIVE_PROVIDER__DEFAULT_PERSPECTIVE = 0;

    /**
     * The number of structural features of the '<em>IPerspective Provider</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IPERSPECTIVE_PROVIDER_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>IPerspective Provider</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IPERSPECTIVE_PROVIDER_OPERATION_COUNT = 0;

    /**
     * The feature id for the '<em><b>Status</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ISTATUS_EMF_TEMPLATE__STATUS = 0;

    /**
     * The number of structural features of the '<em>IStatus EMF Template</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ISTATUS_EMF_TEMPLATE_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>IStatus EMF Template</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ISTATUS_EMF_TEMPLATE_OPERATION_COUNT = 0;

    /**
     * The number of structural features of the '<em>IEMF Selectable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_SELECTABLE_FEATURE_COUNT = 0;

    /**
     * The operation id for the '<em>Get Key</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_SELECTABLE___GET_KEY = 0;

    /**
     * The operation id for the '<em>Get Description</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_SELECTABLE___GET_DESCRIPTION = 1;

    /**
     * The number of operations of the '<em>IEMF Selectable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_SELECTABLE_OPERATION_COUNT = 2;

    /**
     * The number of structural features of the '<em>Serializable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIALIZABLE_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>Serializable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SERIALIZABLE_OPERATION_COUNT = 0;

    /**
     * The feature id for the '<em><b>ATTIVO</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS__ATTIVO = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>DISATTIVO</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS__DISATTIVO = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS__NAME = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Status</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_FEATURE_COUNT = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 3;

    /**
     * The operation id for the '<em>Compare To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS___COMPARE_TO__IEMFENHANCEDENUM = IEMF_ENHANCED_ENUM___COMPARE_TO__IEMFENHANCEDENUM;

    /**
     * The operation id for the '<em>Get Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS___GET_NAME = IEMF_ENHANCED_ENUM___GET_NAME;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS___EQUALS__OBJECT = IEMF_ENHANCED_ENUM___EQUALS__OBJECT;

    /**
     * The number of operations of the '<em>Status</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_OPERATION_COUNT = IEMF_ENHANCED_ENUM_OPERATION_COUNT + 0;

    /**
     * The feature id for the '<em><b>OK</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__OK = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>ERROR</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__ERROR = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>OBJECT UNKNOWN</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__OBJECT_UNKNOWN = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>MAX LENGTH IN IN CLAUSE REACHED</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__MAX_LENGTH_IN_IN_CLAUSE_REACHED = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>REFERENCED OBJECT FOUND</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__REFERENCED_OBJECT_FOUND = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>CUSTOM MESSAGE ADD ERROR</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__CUSTOM_MESSAGE_ADD_ERROR = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>DELEGATED SERVICE NOT FOUND</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__DELEGATED_SERVICE_NOT_FOUND = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>MIN CHARACTER SEARCH LENGTH</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__MIN_CHARACTER_SEARCH_LENGTH = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>CRON EXPRESSION INVALID</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__CRON_EXPRESSION_INVALID = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>SERVICE NOT FOUND</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__SERVICE_NOT_FOUND = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__CODE = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>Plugin Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__PLUGIN_ID = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON__NAME = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 12;

    /**
     * The number of structural features of the '<em>Status Reason</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON_FEATURE_COUNT = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 13;

    /**
     * The operation id for the '<em>Compare To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON___COMPARE_TO__IEMFENHANCEDENUM = IEMF_ENHANCED_ENUM___COMPARE_TO__IEMFENHANCEDENUM;

    /**
     * The operation id for the '<em>Get Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON___GET_NAME = IEMF_ENHANCED_ENUM___GET_NAME;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON___EQUALS__OBJECT = IEMF_ENHANCED_ENUM___EQUALS__OBJECT;

    /**
     * The number of operations of the '<em>Status Reason</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int STATUS_REASON_OPERATION_COUNT = IEMF_ENHANCED_ENUM_OPERATION_COUNT + 0;

    /**
     * The feature id for the '<em><b>ADMINISTRATION</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSPECTIVE__ADMINISTRATION = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>CONFIGURATION</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSPECTIVE__CONFIGURATION = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSPECTIVE__ID = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSPECTIVE__NAME = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 3;

    /**
     * The number of structural features of the '<em>Perspective</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSPECTIVE_FEATURE_COUNT = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 4;

    /**
     * The operation id for the '<em>Compare To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSPECTIVE___COMPARE_TO__IEMFENHANCEDENUM = IEMF_ENHANCED_ENUM___COMPARE_TO__IEMFENHANCEDENUM;

    /**
     * The operation id for the '<em>Get Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSPECTIVE___GET_NAME = IEMF_ENHANCED_ENUM___GET_NAME;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSPECTIVE___EQUALS__OBJECT = IEMF_ENHANCED_ENUM___EQUALS__OBJECT;

    /**
     * The number of operations of the '<em>Perspective</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PERSPECTIVE_OPERATION_COUNT = IEMF_ENHANCED_ENUM_OPERATION_COUNT + 0;

    /**
     * The feature id for the '<em><b>ITALIAN</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANGUAGE__ITALIAN = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>ENGLISH</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANGUAGE__ENGLISH = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Default Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANGUAGE__DEFAULT_LANGUAGE = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Locale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANGUAGE__LOCALE = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANGUAGE__NAME = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 4;

    /**
     * The number of structural features of the '<em>Language</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANGUAGE_FEATURE_COUNT = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 5;

    /**
     * The operation id for the '<em>Compare To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANGUAGE___COMPARE_TO__IEMFENHANCEDENUM = IEMF_ENHANCED_ENUM___COMPARE_TO__IEMFENHANCEDENUM;

    /**
     * The operation id for the '<em>Get Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANGUAGE___GET_NAME = IEMF_ENHANCED_ENUM___GET_NAME;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANGUAGE___EQUALS__OBJECT = IEMF_ENHANCED_ENUM___EQUALS__OBJECT;

    /**
     * The number of operations of the '<em>Language</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LANGUAGE_OPERATION_COUNT = IEMF_ENHANCED_ENUM_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.impl.ActionImpl <em>Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.impl.ActionImpl
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getAction()
     * @generated
     */
    int ACTION = 14;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION__EDITABLE = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Dirty</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION__DIRTY = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION__NAME = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Icon Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION__ICON_PATH = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Permission</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION__PERMISSION = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>General</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION__GENERAL = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION_FEATURE_COUNT = IEMF_ENHANCED_ENUM_FEATURE_COUNT + 6;

    /**
     * The operation id for the '<em>Compare To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION___COMPARE_TO__IEMFENHANCEDENUM = IEMF_ENHANCED_ENUM___COMPARE_TO__IEMFENHANCEDENUM;

    /**
     * The operation id for the '<em>Get Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION___GET_NAME = IEMF_ENHANCED_ENUM___GET_NAME;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION___EQUALS__OBJECT = IEMF_ENHANCED_ENUM___EQUALS__OBJECT;

    /**
     * The operation id for the '<em>Is Allowed</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION___IS_ALLOWED__EOBJECT_ESTRUCTURALFEATURE = IEMF_ENHANCED_ENUM_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Execute</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION___EXECUTE__EOBJECT_ESTRUCTURALFEATURE = IEMF_ENHANCED_ENUM_OPERATION_COUNT + 1;

    /**
     * The operation id for the '<em>Get Command Id</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION___GET_COMMAND_ID__EOBJECT = IEMF_ENHANCED_ENUM_OPERATION_COUNT + 2;

    /**
     * The number of operations of the '<em>Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ACTION_OPERATION_COUNT = IEMF_ENHANCED_ENUM_OPERATION_COUNT + 3;

    /**
     * The meta object id for the '{@link java.lang.Cloneable <em>Cloneable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.lang.Cloneable
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getCloneable()
     * @generated
     */
    int CLONEABLE = 15;

    /**
     * The number of structural features of the '<em>Cloneable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLONEABLE_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>Cloneable</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int CLONEABLE_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.IContained <em>IContained</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.IContained
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIContained()
     * @generated
     */
    int ICONTAINED = 16;

    /**
     * The feature id for the '<em><b>Main EObject</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ICONTAINED__MAIN_EOBJECT = 0;

    /**
     * The number of structural features of the '<em>IContained</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ICONTAINED_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>IContained</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ICONTAINED_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.IContainedFeature <em>IContained Feature</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.IContainedFeature
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIContainedFeature()
     * @generated
     */
    int ICONTAINED_FEATURE = 17;

    /**
     * The feature id for the '<em><b>Main EObject</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ICONTAINED_FEATURE__MAIN_EOBJECT = ICONTAINED__MAIN_EOBJECT;

    /**
     * The feature id for the '<em><b>Main Feature</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ICONTAINED_FEATURE__MAIN_FEATURE = ICONTAINED_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>IContained Feature</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ICONTAINED_FEATURE_FEATURE_COUNT = ICONTAINED_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>IContained Feature</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ICONTAINED_FEATURE_OPERATION_COUNT = ICONTAINED_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.interfaces.IEMFDelegant <em>IEMF Delegant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.IEMFDelegant
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIEMFDelegant()
     * @generated
     */
    int IEMF_DELEGANT = 18;

    /**
     * The feature id for the '<em><b>Delegated Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_DELEGANT__DELEGATED_ID = 0;

    /**
     * The number of structural features of the '<em>IEMF Delegant</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_DELEGANT_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>IEMF Delegant</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEMF_DELEGANT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '<em>Predicate</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see javax.persistence.criteria.Predicate
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getPredicate()
     * @generated
     */
    int PREDICATE = 27;

    /**
     * The meta object id for the '<em>Criteria Builder</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see javax.persistence.criteria.CriteriaBuilder
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getCriteriaBuilder()
     * @generated
     */
    int CRITERIA_BUILDER = 28;

    /**
     * The meta object id for the '<em>Criteria Query</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see javax.persistence.criteria.CriteriaQuery
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getCriteriaQuery()
     * @generated
     */
    int CRITERIA_QUERY = 29;

    /**
     * The meta object id for the '<em>From</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see javax.persistence.criteria.From
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getFrom()
     * @generated
     */
    int FROM = 30;

    /**
     * The meta object id for the '<em>Managed Type</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see javax.persistence.metamodel.ManagedType
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getManagedType()
     * @generated
     */
    int MANAGED_TYPE = 31;

    /**
     * The meta object id for the '<em>Locale</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see java.util.Locale
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getLocale()
     * @generated
     */
    int LOCALE = 32;

    /**
     * The meta object id for the '<em>ISearch Provider</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.interfaces.ISearchProvider
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getISearchProvider()
     * @generated
     */
    int ISEARCH_PROVIDER = 33;

    /**
     * The meta object id for the '<em>Feature Path</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.databinding.FeaturePath
     * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getFeaturePath()
     * @generated
     */
    int FEATURE_PATH = 34;

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.IEMFModel <em>IEMF Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IEMF Model</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFModel
     * @generated
     */
    EClass getIEMFModel();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFModel#copyTo(com.icteam.loyalty.model.interfaces.IEMFModel, boolean) <em>Copy To</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Copy To</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFModel#copyTo(com.icteam.loyalty.model.interfaces.IEMFModel, boolean)
     * @generated
     */
    EOperation getIEMFModel__CopyTo__IEMFModel_boolean();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFModel#equals(java.lang.Object) <em>Equals</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Equals</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFModel#equals(java.lang.Object)
     * @generated
     */
    EOperation getIEMFModel__Equals__Object();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.IEditable <em>IEditable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IEditable</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEditable
     * @generated
     */
    EClass getIEditable();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.IEditable#isEditable <em>Editable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Editable</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEditable#isEditable()
     * @see #getIEditable()
     * @generated
     */
    EAttribute getIEditable_Editable();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.IEditable#isDirty <em>Dirty</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dirty</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEditable#isDirty()
     * @see #getIEditable()
     * @generated
     */
    EAttribute getIEditable_Dirty();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum <em>IEMF Enhanced Enum</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IEMF Enhanced Enum</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum
     * @generated
     */
    EClass getIEMFEnhancedEnum();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum#compareTo(com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum) <em>Compare To</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Compare To</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum#compareTo(com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum)
     * @generated
     */
    EOperation getIEMFEnhancedEnum__CompareTo__IEMFEnhancedEnum();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum#getName() <em>Get Name</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Name</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum#getName()
     * @generated
     */
    EOperation getIEMFEnhancedEnum__GetName();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum#equals(java.lang.Object) <em>Equals</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Equals</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum#equals(java.lang.Object)
     * @generated
     */
    EOperation getIEMFEnhancedEnum__Equals__Object();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate <em>IEMF Template</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IEMF Template</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate
     * @generated
     */
    EClass getIEMFTemplate();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDistinct <em>Distinct</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Distinct</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getDistinct()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_Distinct();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getMaxResults <em>Max Results</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Max Results</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getMaxResults()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_MaxResults();

    /**
     * Returns the meta object for the attribute list '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getOrderDirections <em>Order Directions</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Order Directions</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getOrderDirections()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_OrderDirections();

    /**
     * Returns the meta object for the attribute list '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicFilterFeatures <em>Dynamic Filter Features</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Dynamic Filter Features</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicFilterFeatures()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_DynamicFilterFeatures();

    /**
     * Returns the meta object for the attribute list '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicFilters <em>Dynamic Filters</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Dynamic Filters</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicFilters()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_DynamicFilters();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#isSingleResult <em>Single Result</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Single Result</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#isSingleResult()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_SingleResult();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#isLightSearch <em>Light Search</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Light Search</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#isLightSearch()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_LightSearch();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getFirstResult <em>First Result</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>First Result</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getFirstResult()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_FirstResult();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#isNested <em>Nested</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Nested</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#isNested()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_Nested();

    /**
     * Returns the meta object for the attribute list '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getOrderFeatures <em>Order Features</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Order Features</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getOrderFeatures()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_OrderFeatures();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicOrderFeature <em>Dynamic Order Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dynamic Order Feature</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicOrderFeature()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_DynamicOrderFeature();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicOrderDirection <em>Dynamic Order Direction</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Dynamic Order Direction</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicOrderDirection()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_DynamicOrderDirection();

    /**
     * Returns the meta object for the attribute list '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicFilterableFeatures <em>Dynamic Filterable Features</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Dynamic Filterable Features</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicFilterableFeatures()
     * @see #getIEMFTemplate()
     * @generated
     */
    EAttribute getIEMFTemplate_DynamicFilterableFeatures();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#initialized() <em>Initialized</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Initialized</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#initialized()
     * @generated
     */
    EOperation getIEMFTemplate__Initialized();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getResultCount(javax.persistence.EntityManager) <em>Get Result Count</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Result Count</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getResultCount(javax.persistence.EntityManager)
     * @generated
     */
    EOperation getIEMFTemplate__GetResultCount__EntityManager();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getFirstResult(javax.persistence.EntityManager) <em>Get First Result</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get First Result</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getFirstResult(javax.persistence.EntityManager)
     * @generated
     */
    EOperation getIEMFTemplate__GetFirstResult__EntityManager();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getResultList(javax.persistence.EntityManager) <em>Get Result List</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Result List</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getResultList(javax.persistence.EntityManager)
     * @generated
     */
    EOperation getIEMFTemplate__GetResultList__EntityManager();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#hasDynamicFilters() <em>Has Dynamic Filters</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Has Dynamic Filters</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#hasDynamicFilters()
     * @generated
     */
    EOperation getIEMFTemplate__HasDynamicFilters();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#setDynamicFilterFeatures(org.eclipse.emf.common.util.EList) <em>Set Dynamic Filter Features</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Set Dynamic Filter Features</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#setDynamicFilterFeatures(org.eclipse.emf.common.util.EList)
     * @generated
     */
    EOperation getIEMFTemplate__SetDynamicFilterFeatures__EList();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#setRawFilter(java.lang.String) <em>Set Raw Filter</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Set Raw Filter</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#setRawFilter(java.lang.String)
     * @generated
     */
    EOperation getIEMFTemplate__SetRawFilter__String();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#hasDynamicOrder() <em>Has Dynamic Order</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Has Dynamic Order</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#hasDynamicOrder()
     * @generated
     */
    EOperation getIEMFTemplate__HasDynamicOrder();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDbModelClass() <em>Get Db Model Class</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Db Model Class</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getDbModelClass()
     * @generated
     */
    EOperation getIEMFTemplate__GetDbModelClass();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getIdValue() <em>Get Id Value</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Id Value</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate#getIdValue()
     * @generated
     */
    EOperation getIEMFTemplate__GetIdValue();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.IPerspectiveProvider <em>IPerspective Provider</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IPerspective Provider</em>'.
     * @see com.icteam.loyalty.model.interfaces.IPerspectiveProvider
     * @generated
     */
    EClass getIPerspectiveProvider();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.IPerspectiveProvider#getDefaultPerspective <em>Default Perspective</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Default Perspective</em>'.
     * @see com.icteam.loyalty.model.interfaces.IPerspectiveProvider#getDefaultPerspective()
     * @see #getIPerspectiveProvider()
     * @generated
     */
    EReference getIPerspectiveProvider_DefaultPerspective();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.IStatusEMFTemplate <em>IStatus EMF Template</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IStatus EMF Template</em>'.
     * @see com.icteam.loyalty.model.interfaces.IStatusEMFTemplate
     * @generated
     */
    EClass getIStatusEMFTemplate();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.IStatusEMFTemplate#getStatus <em>Status</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Status</em>'.
     * @see com.icteam.loyalty.model.interfaces.IStatusEMFTemplate#getStatus()
     * @see #getIStatusEMFTemplate()
     * @generated
     */
    EReference getIStatusEMFTemplate_Status();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.IEMFSelectable <em>IEMF Selectable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IEMF Selectable</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFSelectable
     * @generated
     */
    EClass getIEMFSelectable();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFSelectable#getKey() <em>Get Key</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Key</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFSelectable#getKey()
     * @generated
     */
    EOperation getIEMFSelectable__GetKey();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.IEMFSelectable#getDescription() <em>Get Description</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Description</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.IEMFSelectable#getDescription()
     * @generated
     */
    EOperation getIEMFSelectable__GetDescription();

    /**
     * Returns the meta object for class '{@link java.lang.Comparable <em>Comparable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Comparable</em>'.
     * @see java.lang.Comparable
     * @model instanceClass="java.lang.Comparable" typeParameters="T"
     * @generated
     */
    EClass getComparable();

    /**
     * Returns the meta object for enum '{@link com.icteam.loyalty.model.interfaces.DistinctEMF <em>Distinct EMF</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Distinct EMF</em>'.
     * @see com.icteam.loyalty.model.interfaces.DistinctEMF
     * @generated
     */
    EEnum getDistinctEMF();

    /**
     * Returns the meta object for enum '{@link com.icteam.loyalty.model.interfaces.OrderDirectionEMF <em>Order Direction EMF</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>Order Direction EMF</em>'.
     * @see com.icteam.loyalty.model.interfaces.OrderDirectionEMF
     * @generated
     */
    EEnum getOrderDirectionEMF();

    /**
     * Returns the meta object for enum '{@link com.icteam.loyalty.model.interfaces.EWhereClauseEMF <em>EWhere Clause EMF</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>EWhere Clause EMF</em>'.
     * @see com.icteam.loyalty.model.interfaces.EWhereClauseEMF
     * @generated
     */
    EEnum getEWhereClauseEMF();

    /**
     * Returns the meta object for enum '{@link com.icteam.loyalty.model.interfaces.EWhereTemplateClauseEMF <em>EWhere Template Clause EMF</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>EWhere Template Clause EMF</em>'.
     * @see com.icteam.loyalty.model.interfaces.EWhereTemplateClauseEMF
     * @generated
     */
    EEnum getEWhereTemplateClauseEMF();

    /**
     * Returns the meta object for enum '{@link com.icteam.loyalty.model.interfaces.EDynamicFilterableEMF <em>EDynamic Filterable EMF</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>EDynamic Filterable EMF</em>'.
     * @see com.icteam.loyalty.model.interfaces.EDynamicFilterableEMF
     * @generated
     */
    EEnum getEDynamicFilterableEMF();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.Status <em>Status</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Status</em>'.
     * @see com.icteam.loyalty.model.interfaces.Status
     * @generated
     */
    EClass getStatus();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.Status#getATTIVO <em>ATTIVO</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>ATTIVO</em>'.
     * @see com.icteam.loyalty.model.interfaces.Status#getATTIVO()
     * @see #getStatus()
     * @generated
     */
    EReference getStatus_ATTIVO();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.Status#getDISATTIVO <em>DISATTIVO</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>DISATTIVO</em>'.
     * @see com.icteam.loyalty.model.interfaces.Status#getDISATTIVO()
     * @see #getStatus()
     * @generated
     */
    EReference getStatus_DISATTIVO();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Status#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.icteam.loyalty.model.interfaces.Status#getName()
     * @see #getStatus()
     * @generated
     */
    EAttribute getStatus_Name();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.Perspective <em>Perspective</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Perspective</em>'.
     * @see com.icteam.loyalty.model.interfaces.Perspective
     * @generated
     */
    EClass getPerspective();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.Perspective#getADMINISTRATION <em>ADMINISTRATION</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>ADMINISTRATION</em>'.
     * @see com.icteam.loyalty.model.interfaces.Perspective#getADMINISTRATION()
     * @see #getPerspective()
     * @generated
     */
    EReference getPerspective_ADMINISTRATION();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.Perspective#getCONFIGURATION <em>CONFIGURATION</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>CONFIGURATION</em>'.
     * @see com.icteam.loyalty.model.interfaces.Perspective#getCONFIGURATION()
     * @see #getPerspective()
     * @generated
     */
    EReference getPerspective_CONFIGURATION();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Perspective#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see com.icteam.loyalty.model.interfaces.Perspective#getId()
     * @see #getPerspective()
     * @generated
     */
    EAttribute getPerspective_Id();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Perspective#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.icteam.loyalty.model.interfaces.Perspective#getName()
     * @see #getPerspective()
     * @generated
     */
    EAttribute getPerspective_Name();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.StatusReason <em>Status Reason</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Status Reason</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason
     * @generated
     */
    EClass getStatusReason();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.StatusReason#getOK <em>OK</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>OK</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getOK()
     * @see #getStatusReason()
     * @generated
     */
    EReference getStatusReason_OK();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.StatusReason#getERROR <em>ERROR</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>ERROR</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getERROR()
     * @see #getStatusReason()
     * @generated
     */
    EReference getStatusReason_ERROR();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.StatusReason#getOBJECT_UNKNOWN <em>OBJECT UNKNOWN</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>OBJECT UNKNOWN</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getOBJECT_UNKNOWN()
     * @see #getStatusReason()
     * @generated
     */
    EReference getStatusReason_OBJECT_UNKNOWN();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.StatusReason#getMAX_LENGTH_IN_IN_CLAUSE_REACHED <em>MAX LENGTH IN IN CLAUSE REACHED</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>MAX LENGTH IN IN CLAUSE REACHED</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getMAX_LENGTH_IN_IN_CLAUSE_REACHED()
     * @see #getStatusReason()
     * @generated
     */
    EReference getStatusReason_MAX_LENGTH_IN_IN_CLAUSE_REACHED();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.StatusReason#getREFERENCED_OBJECT_FOUND <em>REFERENCED OBJECT FOUND</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>REFERENCED OBJECT FOUND</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getREFERENCED_OBJECT_FOUND()
     * @see #getStatusReason()
     * @generated
     */
    EReference getStatusReason_REFERENCED_OBJECT_FOUND();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.StatusReason#getCUSTOM_MESSAGE_ADD_ERROR <em>CUSTOM MESSAGE ADD ERROR</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>CUSTOM MESSAGE ADD ERROR</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getCUSTOM_MESSAGE_ADD_ERROR()
     * @see #getStatusReason()
     * @generated
     */
    EReference getStatusReason_CUSTOM_MESSAGE_ADD_ERROR();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.StatusReason#getDELEGATED_SERVICE_NOT_FOUND <em>DELEGATED SERVICE NOT FOUND</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>DELEGATED SERVICE NOT FOUND</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getDELEGATED_SERVICE_NOT_FOUND()
     * @see #getStatusReason()
     * @generated
     */
    EReference getStatusReason_DELEGATED_SERVICE_NOT_FOUND();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.StatusReason#getMIN_CHARACTER_SEARCH_LENGTH <em>MIN CHARACTER SEARCH LENGTH</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>MIN CHARACTER SEARCH LENGTH</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getMIN_CHARACTER_SEARCH_LENGTH()
     * @see #getStatusReason()
     * @generated
     */
    EReference getStatusReason_MIN_CHARACTER_SEARCH_LENGTH();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.StatusReason#getCRON_EXPRESSION_INVALID <em>CRON EXPRESSION INVALID</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>CRON EXPRESSION INVALID</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getCRON_EXPRESSION_INVALID()
     * @see #getStatusReason()
     * @generated
     */
    EReference getStatusReason_CRON_EXPRESSION_INVALID();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.StatusReason#getSERVICE_NOT_FOUND <em>SERVICE NOT FOUND</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>SERVICE NOT FOUND</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getSERVICE_NOT_FOUND()
     * @see #getStatusReason()
     * @generated
     */
    EReference getStatusReason_SERVICE_NOT_FOUND();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.StatusReason#getCode <em>Code</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Code</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getCode()
     * @see #getStatusReason()
     * @generated
     */
    EAttribute getStatusReason_Code();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.StatusReason#getPluginId <em>Plugin Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Plugin Id</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getPluginId()
     * @see #getStatusReason()
     * @generated
     */
    EAttribute getStatusReason_PluginId();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.StatusReason#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.icteam.loyalty.model.interfaces.StatusReason#getName()
     * @see #getStatusReason()
     * @generated
     */
    EAttribute getStatusReason_Name();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.Language <em>Language</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Language</em>'.
     * @see com.icteam.loyalty.model.interfaces.Language
     * @generated
     */
    EClass getLanguage();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.Language#getITALIAN <em>ITALIAN</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>ITALIAN</em>'.
     * @see com.icteam.loyalty.model.interfaces.Language#getITALIAN()
     * @see #getLanguage()
     * @generated
     */
    EReference getLanguage_ITALIAN();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.Language#getENGLISH <em>ENGLISH</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>ENGLISH</em>'.
     * @see com.icteam.loyalty.model.interfaces.Language#getENGLISH()
     * @see #getLanguage()
     * @generated
     */
    EReference getLanguage_ENGLISH();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Language#isDefaultLanguage <em>Default Language</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Default Language</em>'.
     * @see com.icteam.loyalty.model.interfaces.Language#isDefaultLanguage()
     * @see #getLanguage()
     * @generated
     */
    EAttribute getLanguage_DefaultLanguage();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Language#getLocale <em>Locale</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Locale</em>'.
     * @see com.icteam.loyalty.model.interfaces.Language#getLocale()
     * @see #getLanguage()
     * @generated
     */
    EAttribute getLanguage_Locale();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Language#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.icteam.loyalty.model.interfaces.Language#getName()
     * @see #getLanguage()
     * @generated
     */
    EAttribute getLanguage_Name();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.Action <em>Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Action</em>'.
     * @see com.icteam.loyalty.model.interfaces.Action
     * @generated
     */
    EClass getAction();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Action#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.icteam.loyalty.model.interfaces.Action#getName()
     * @see #getAction()
     * @generated
     */
    EAttribute getAction_Name();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Action#getIconPath <em>Icon Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Icon Path</em>'.
     * @see com.icteam.loyalty.model.interfaces.Action#getIconPath()
     * @see #getAction()
     * @generated
     */
    EAttribute getAction_IconPath();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Action#getPermission <em>Permission</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Permission</em>'.
     * @see com.icteam.loyalty.model.interfaces.Action#getPermission()
     * @see #getAction()
     * @generated
     */
    EAttribute getAction_Permission();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Action#isGeneral <em>General</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>General</em>'.
     * @see com.icteam.loyalty.model.interfaces.Action#isGeneral()
     * @see #getAction()
     * @generated
     */
    EAttribute getAction_General();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.Action#isAllowed(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature) <em>Is Allowed</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Is Allowed</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.Action#isAllowed(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature)
     * @generated
     */
    EOperation getAction__IsAllowed__EObject_EStructuralFeature();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.Action#execute(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature) <em>Execute</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Execute</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.Action#execute(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature)
     * @generated
     */
    EOperation getAction__Execute__EObject_EStructuralFeature();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.Action#getCommandId(org.eclipse.emf.ecore.EObject) <em>Get Command Id</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Command Id</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.Action#getCommandId(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    EOperation getAction__GetCommandId__EObject();

    /**
     * Returns the meta object for class '{@link java.lang.Cloneable <em>Cloneable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Cloneable</em>'.
     * @see java.lang.Cloneable
     * @model instanceClass="java.lang.Cloneable"
     * @generated
     */
    EClass getCloneable();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.IContained <em>IContained</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IContained</em>'.
     * @see com.icteam.loyalty.model.interfaces.IContained
     * @generated
     */
    EClass getIContained();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.IContained#getMainEObject <em>Main EObject</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Main EObject</em>'.
     * @see com.icteam.loyalty.model.interfaces.IContained#getMainEObject()
     * @see #getIContained()
     * @generated
     */
    EReference getIContained_MainEObject();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.IContainedFeature <em>IContained Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IContained Feature</em>'.
     * @see com.icteam.loyalty.model.interfaces.IContainedFeature
     * @generated
     */
    EClass getIContainedFeature();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.IContainedFeature#getMainFeature <em>Main Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Main Feature</em>'.
     * @see com.icteam.loyalty.model.interfaces.IContainedFeature#getMainFeature()
     * @see #getIContainedFeature()
     * @generated
     */
    EAttribute getIContainedFeature_MainFeature();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.IEMFDelegant <em>IEMF Delegant</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IEMF Delegant</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFDelegant
     * @generated
     */
    EClass getIEMFDelegant();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.IEMFDelegant#getDelegatedId <em>Delegated Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Delegated Id</em>'.
     * @see com.icteam.loyalty.model.interfaces.IEMFDelegant#getDelegatedId()
     * @see #getIEMFDelegant()
     * @generated
     */
    EAttribute getIEMFDelegant_DelegatedId();

    /**
     * Returns the meta object for data type '{@link org.eclipse.swt.graphics.Image <em>Image</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Image</em>'.
     * @see org.eclipse.swt.graphics.Image
     * @model instanceClass="org.eclipse.swt.graphics.Image"
     * @generated
     */
    EDataType getImage();

    /**
     * Returns the meta object for data type '{@link org.eclipse.emf.ecore.EStructuralFeature <em>EStructural Feature</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>EStructural Feature</em>'.
     * @see org.eclipse.emf.ecore.EStructuralFeature
     * @model instanceClass="org.eclipse.emf.ecore.EStructuralFeature"
     * @generated
     */
    EDataType getEStructuralFeature();

    /**
     * Returns the meta object for data type '{@link javax.persistence.EntityManager <em>Entity Manager</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Entity Manager</em>'.
     * @see javax.persistence.EntityManager
     * @model instanceClass="javax.persistence.EntityManager"
     * @generated
     */
    EDataType getEntityManager();

    /**
     * Returns the meta object for class '{@link java.io.Serializable <em>Serializable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Serializable</em>'.
     * @see java.io.Serializable
     * @model instanceClass="java.io.Serializable"
     * @generated
     */
    EClass getSerializable();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.interfaces.Permission <em>Permission</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Permission</em>'.
     * @see com.icteam.loyalty.model.interfaces.Permission
     * @generated
     */
    EClass getPermission();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.Permission#getADMINISTRATION_PERSPECTIVE_VIEW <em>ADMINISTRATION PERSPECTIVE VIEW</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>ADMINISTRATION PERSPECTIVE VIEW</em>'.
     * @see com.icteam.loyalty.model.interfaces.Permission#getADMINISTRATION_PERSPECTIVE_VIEW()
     * @see #getPermission()
     * @generated
     */
    EReference getPermission_ADMINISTRATION_PERSPECTIVE_VIEW();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.interfaces.Permission#getCONFIGURATION_PERSPECTIVE_VIEW <em>CONFIGURATION PERSPECTIVE VIEW</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>CONFIGURATION PERSPECTIVE VIEW</em>'.
     * @see com.icteam.loyalty.model.interfaces.Permission#getCONFIGURATION_PERSPECTIVE_VIEW()
     * @see #getPermission()
     * @generated
     */
    EReference getPermission_CONFIGURATION_PERSPECTIVE_VIEW();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Permission#getObject <em>Object</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Object</em>'.
     * @see com.icteam.loyalty.model.interfaces.Permission#getObject()
     * @see #getPermission()
     * @generated
     */
    EAttribute getPermission_Object();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Permission#getAction <em>Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Action</em>'.
     * @see com.icteam.loyalty.model.interfaces.Permission#getAction()
     * @see #getPermission()
     * @generated
     */
    EAttribute getPermission_Action();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.interfaces.Permission#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see com.icteam.loyalty.model.interfaces.Permission#getName()
     * @see #getPermission()
     * @generated
     */
    EAttribute getPermission_Name();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.Permission#isStarPermission() <em>Is Star Permission</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Is Star Permission</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.Permission#isStarPermission()
     * @generated
     */
    EOperation getPermission__IsStarPermission();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.Permission#getPermission() <em>Get Permission</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Permission</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.Permission#getPermission()
     * @generated
     */
    EOperation getPermission__GetPermission();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.interfaces.Permission#getPermissions() <em>Get Permissions</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Permissions</em>' operation.
     * @see com.icteam.loyalty.model.interfaces.Permission#getPermissions()
     * @generated
     */
    EOperation getPermission__GetPermissions();

    /**
     * Returns the meta object for data type '{@link javax.persistence.criteria.Predicate <em>Predicate</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Predicate</em>'.
     * @see javax.persistence.criteria.Predicate
     * @model instanceClass="javax.persistence.criteria.Predicate"
     * @generated
     */
    EDataType getPredicate();

    /**
     * Returns the meta object for data type '{@link javax.persistence.criteria.CriteriaBuilder <em>Criteria Builder</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Criteria Builder</em>'.
     * @see javax.persistence.criteria.CriteriaBuilder
     * @model instanceClass="javax.persistence.criteria.CriteriaBuilder"
     * @generated
     */
    EDataType getCriteriaBuilder();

    /**
     * Returns the meta object for data type '{@link javax.persistence.criteria.CriteriaQuery <em>Criteria Query</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Criteria Query</em>'.
     * @see javax.persistence.criteria.CriteriaQuery
     * @model instanceClass="javax.persistence.criteria.CriteriaQuery" typeParameters="T"
     * @generated
     */
    EDataType getCriteriaQuery();

    /**
     * Returns the meta object for data type '{@link javax.persistence.criteria.From <em>From</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>From</em>'.
     * @see javax.persistence.criteria.From
     * @model instanceClass="javax.persistence.criteria.From" typeParameters="Z X"
     * @generated
     */
    EDataType getFrom();

    /**
     * Returns the meta object for data type '{@link javax.persistence.metamodel.ManagedType <em>Managed Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Managed Type</em>'.
     * @see javax.persistence.metamodel.ManagedType
     * @model instanceClass="javax.persistence.metamodel.ManagedType" typeParameters="X"
     * @generated
     */
    EDataType getManagedType();

    /**
     * Returns the meta object for data type '{@link java.util.Locale <em>Locale</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Locale</em>'.
     * @see java.util.Locale
     * @model instanceClass="java.util.Locale"
     * @generated
     */
    EDataType getLocale();

    /**
     * Returns the meta object for data type '{@link com.icteam.loyalty.model.interfaces.ISearchProvider <em>ISearch Provider</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>ISearch Provider</em>'.
     * @see com.icteam.loyalty.model.interfaces.ISearchProvider
     * @model instanceClass="com.icteam.loyalty.model.interfaces.ISearchProvider" serializeable="false"
     * @generated
     */
    EDataType getISearchProvider();

    /**
     * Returns the meta object for data type '{@link org.eclipse.emf.databinding.FeaturePath <em>Feature Path</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Feature Path</em>'.
     * @see org.eclipse.emf.databinding.FeaturePath
     * @model instanceClass="org.eclipse.emf.databinding.FeaturePath" serializeable="false"
     * @generated
     */
    EDataType getFeaturePath();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ModelInterfacesFactory getModelInterfacesFactory();

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
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.IEMFModel <em>IEMF Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.IEMFModel
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIEMFModel()
         * @generated
         */
        EClass IEMF_MODEL = eINSTANCE.getIEMFModel();

        /**
         * The meta object literal for the '<em><b>Copy To</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN = eINSTANCE.getIEMFModel__CopyTo__IEMFModel_boolean();

        /**
         * The meta object literal for the '<em><b>Equals</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_MODEL___EQUALS__OBJECT = eINSTANCE.getIEMFModel__Equals__Object();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.IEditable <em>IEditable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.IEditable
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIEditable()
         * @generated
         */
        EClass IEDITABLE = eINSTANCE.getIEditable();

        /**
         * The meta object literal for the '<em><b>Editable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEDITABLE__EDITABLE = eINSTANCE.getIEditable_Editable();

        /**
         * The meta object literal for the '<em><b>Dirty</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEDITABLE__DIRTY = eINSTANCE.getIEditable_Dirty();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum <em>IEMF Enhanced Enum</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIEMFEnhancedEnum()
         * @generated
         */
        EClass IEMF_ENHANCED_ENUM = eINSTANCE.getIEMFEnhancedEnum();

        /**
         * The meta object literal for the '<em><b>Compare To</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_ENHANCED_ENUM___COMPARE_TO__IEMFENHANCEDENUM = eINSTANCE.getIEMFEnhancedEnum__CompareTo__IEMFEnhancedEnum();

        /**
         * The meta object literal for the '<em><b>Get Name</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_ENHANCED_ENUM___GET_NAME = eINSTANCE.getIEMFEnhancedEnum__GetName();

        /**
         * The meta object literal for the '<em><b>Equals</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_ENHANCED_ENUM___EQUALS__OBJECT = eINSTANCE.getIEMFEnhancedEnum__Equals__Object();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate <em>IEMF Template</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.IEMFTemplate
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIEMFTemplate()
         * @generated
         */
        EClass IEMF_TEMPLATE = eINSTANCE.getIEMFTemplate();

        /**
         * The meta object literal for the '<em><b>Distinct</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__DISTINCT = eINSTANCE.getIEMFTemplate_Distinct();

        /**
         * The meta object literal for the '<em><b>Max Results</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__MAX_RESULTS = eINSTANCE.getIEMFTemplate_MaxResults();

        /**
         * The meta object literal for the '<em><b>Order Directions</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__ORDER_DIRECTIONS = eINSTANCE.getIEMFTemplate_OrderDirections();

        /**
         * The meta object literal for the '<em><b>Dynamic Filter Features</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__DYNAMIC_FILTER_FEATURES = eINSTANCE.getIEMFTemplate_DynamicFilterFeatures();

        /**
         * The meta object literal for the '<em><b>Dynamic Filters</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__DYNAMIC_FILTERS = eINSTANCE.getIEMFTemplate_DynamicFilters();

        /**
         * The meta object literal for the '<em><b>Single Result</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__SINGLE_RESULT = eINSTANCE.getIEMFTemplate_SingleResult();

        /**
         * The meta object literal for the '<em><b>Light Search</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__LIGHT_SEARCH = eINSTANCE.getIEMFTemplate_LightSearch();

        /**
         * The meta object literal for the '<em><b>First Result</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__FIRST_RESULT = eINSTANCE.getIEMFTemplate_FirstResult();

        /**
         * The meta object literal for the '<em><b>Nested</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__NESTED = eINSTANCE.getIEMFTemplate_Nested();

        /**
         * The meta object literal for the '<em><b>Order Features</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__ORDER_FEATURES = eINSTANCE.getIEMFTemplate_OrderFeatures();

        /**
         * The meta object literal for the '<em><b>Dynamic Order Feature</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__DYNAMIC_ORDER_FEATURE = eINSTANCE.getIEMFTemplate_DynamicOrderFeature();

        /**
         * The meta object literal for the '<em><b>Dynamic Order Direction</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION = eINSTANCE.getIEMFTemplate_DynamicOrderDirection();

        /**
         * The meta object literal for the '<em><b>Dynamic Filterable Features</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES = eINSTANCE.getIEMFTemplate_DynamicFilterableFeatures();

        /**
         * The meta object literal for the '<em><b>Initialized</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_TEMPLATE___INITIALIZED = eINSTANCE.getIEMFTemplate__Initialized();

        /**
         * The meta object literal for the '<em><b>Get Result Count</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_TEMPLATE___GET_RESULT_COUNT__ENTITYMANAGER = eINSTANCE.getIEMFTemplate__GetResultCount__EntityManager();

        /**
         * The meta object literal for the '<em><b>Get First Result</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_TEMPLATE___GET_FIRST_RESULT__ENTITYMANAGER = eINSTANCE.getIEMFTemplate__GetFirstResult__EntityManager();

        /**
         * The meta object literal for the '<em><b>Get Result List</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_TEMPLATE___GET_RESULT_LIST__ENTITYMANAGER = eINSTANCE.getIEMFTemplate__GetResultList__EntityManager();

        /**
         * The meta object literal for the '<em><b>Has Dynamic Filters</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_TEMPLATE___HAS_DYNAMIC_FILTERS = eINSTANCE.getIEMFTemplate__HasDynamicFilters();

        /**
         * The meta object literal for the '<em><b>Set Dynamic Filter Features</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_TEMPLATE___SET_DYNAMIC_FILTER_FEATURES__ELIST = eINSTANCE.getIEMFTemplate__SetDynamicFilterFeatures__EList();

        /**
         * The meta object literal for the '<em><b>Set Raw Filter</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_TEMPLATE___SET_RAW_FILTER__STRING = eINSTANCE.getIEMFTemplate__SetRawFilter__String();

        /**
         * The meta object literal for the '<em><b>Has Dynamic Order</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_TEMPLATE___HAS_DYNAMIC_ORDER = eINSTANCE.getIEMFTemplate__HasDynamicOrder();

        /**
         * The meta object literal for the '<em><b>Get Db Model Class</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_TEMPLATE___GET_DB_MODEL_CLASS = eINSTANCE.getIEMFTemplate__GetDbModelClass();

        /**
         * The meta object literal for the '<em><b>Get Id Value</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_TEMPLATE___GET_ID_VALUE = eINSTANCE.getIEMFTemplate__GetIdValue();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.IPerspectiveProvider <em>IPerspective Provider</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.IPerspectiveProvider
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIPerspectiveProvider()
         * @generated
         */
        EClass IPERSPECTIVE_PROVIDER = eINSTANCE.getIPerspectiveProvider();

        /**
         * The meta object literal for the '<em><b>Default Perspective</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference IPERSPECTIVE_PROVIDER__DEFAULT_PERSPECTIVE = eINSTANCE.getIPerspectiveProvider_DefaultPerspective();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.IStatusEMFTemplate <em>IStatus EMF Template</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.IStatusEMFTemplate
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIStatusEMFTemplate()
         * @generated
         */
        EClass ISTATUS_EMF_TEMPLATE = eINSTANCE.getIStatusEMFTemplate();

        /**
         * The meta object literal for the '<em><b>Status</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ISTATUS_EMF_TEMPLATE__STATUS = eINSTANCE.getIStatusEMFTemplate_Status();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.IEMFSelectable <em>IEMF Selectable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.IEMFSelectable
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIEMFSelectable()
         * @generated
         */
        EClass IEMF_SELECTABLE = eINSTANCE.getIEMFSelectable();

        /**
         * The meta object literal for the '<em><b>Get Key</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_SELECTABLE___GET_KEY = eINSTANCE.getIEMFSelectable__GetKey();

        /**
         * The meta object literal for the '<em><b>Get Description</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation IEMF_SELECTABLE___GET_DESCRIPTION = eINSTANCE.getIEMFSelectable__GetDescription();

        /**
         * The meta object literal for the '{@link java.lang.Comparable <em>Comparable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.lang.Comparable
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getComparable()
         * @generated
         */
        EClass COMPARABLE = eINSTANCE.getComparable();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.DistinctEMF <em>Distinct EMF</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.DistinctEMF
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getDistinctEMF()
         * @generated
         */
        EEnum DISTINCT_EMF = eINSTANCE.getDistinctEMF();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.OrderDirectionEMF <em>Order Direction EMF</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.OrderDirectionEMF
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getOrderDirectionEMF()
         * @generated
         */
        EEnum ORDER_DIRECTION_EMF = eINSTANCE.getOrderDirectionEMF();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.EWhereClauseEMF <em>EWhere Clause EMF</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.EWhereClauseEMF
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getEWhereClauseEMF()
         * @generated
         */
        EEnum EWHERE_CLAUSE_EMF = eINSTANCE.getEWhereClauseEMF();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.EWhereTemplateClauseEMF <em>EWhere Template Clause EMF</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.EWhereTemplateClauseEMF
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getEWhereTemplateClauseEMF()
         * @generated
         */
        EEnum EWHERE_TEMPLATE_CLAUSE_EMF = eINSTANCE.getEWhereTemplateClauseEMF();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.EDynamicFilterableEMF <em>EDynamic Filterable EMF</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.EDynamicFilterableEMF
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getEDynamicFilterableEMF()
         * @generated
         */
        EEnum EDYNAMIC_FILTERABLE_EMF = eINSTANCE.getEDynamicFilterableEMF();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.impl.StatusImpl <em>Status</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.impl.StatusImpl
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getStatus()
         * @generated
         */
        EClass STATUS = eINSTANCE.getStatus();

        /**
         * The meta object literal for the '<em><b>ATTIVO</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATUS__ATTIVO = eINSTANCE.getStatus_ATTIVO();

        /**
         * The meta object literal for the '<em><b>DISATTIVO</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATUS__DISATTIVO = eINSTANCE.getStatus_DISATTIVO();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STATUS__NAME = eINSTANCE.getStatus_Name();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.impl.PerspectiveImpl <em>Perspective</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.impl.PerspectiveImpl
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getPerspective()
         * @generated
         */
        EClass PERSPECTIVE = eINSTANCE.getPerspective();

        /**
         * The meta object literal for the '<em><b>ADMINISTRATION</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PERSPECTIVE__ADMINISTRATION = eINSTANCE.getPerspective_ADMINISTRATION();

        /**
         * The meta object literal for the '<em><b>CONFIGURATION</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PERSPECTIVE__CONFIGURATION = eINSTANCE.getPerspective_CONFIGURATION();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PERSPECTIVE__ID = eINSTANCE.getPerspective_Id();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PERSPECTIVE__NAME = eINSTANCE.getPerspective_Name();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl <em>Status Reason</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getStatusReason()
         * @generated
         */
        EClass STATUS_REASON = eINSTANCE.getStatusReason();

        /**
         * The meta object literal for the '<em><b>OK</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATUS_REASON__OK = eINSTANCE.getStatusReason_OK();

        /**
         * The meta object literal for the '<em><b>ERROR</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATUS_REASON__ERROR = eINSTANCE.getStatusReason_ERROR();

        /**
         * The meta object literal for the '<em><b>OBJECT UNKNOWN</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATUS_REASON__OBJECT_UNKNOWN = eINSTANCE.getStatusReason_OBJECT_UNKNOWN();

        /**
         * The meta object literal for the '<em><b>MAX LENGTH IN IN CLAUSE REACHED</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATUS_REASON__MAX_LENGTH_IN_IN_CLAUSE_REACHED = eINSTANCE.getStatusReason_MAX_LENGTH_IN_IN_CLAUSE_REACHED();

        /**
         * The meta object literal for the '<em><b>REFERENCED OBJECT FOUND</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATUS_REASON__REFERENCED_OBJECT_FOUND = eINSTANCE.getStatusReason_REFERENCED_OBJECT_FOUND();

        /**
         * The meta object literal for the '<em><b>CUSTOM MESSAGE ADD ERROR</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATUS_REASON__CUSTOM_MESSAGE_ADD_ERROR = eINSTANCE.getStatusReason_CUSTOM_MESSAGE_ADD_ERROR();

        /**
         * The meta object literal for the '<em><b>DELEGATED SERVICE NOT FOUND</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATUS_REASON__DELEGATED_SERVICE_NOT_FOUND = eINSTANCE.getStatusReason_DELEGATED_SERVICE_NOT_FOUND();

        /**
         * The meta object literal for the '<em><b>MIN CHARACTER SEARCH LENGTH</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATUS_REASON__MIN_CHARACTER_SEARCH_LENGTH = eINSTANCE.getStatusReason_MIN_CHARACTER_SEARCH_LENGTH();

        /**
         * The meta object literal for the '<em><b>CRON EXPRESSION INVALID</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATUS_REASON__CRON_EXPRESSION_INVALID = eINSTANCE.getStatusReason_CRON_EXPRESSION_INVALID();

        /**
         * The meta object literal for the '<em><b>SERVICE NOT FOUND</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference STATUS_REASON__SERVICE_NOT_FOUND = eINSTANCE.getStatusReason_SERVICE_NOT_FOUND();

        /**
         * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STATUS_REASON__CODE = eINSTANCE.getStatusReason_Code();

        /**
         * The meta object literal for the '<em><b>Plugin Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STATUS_REASON__PLUGIN_ID = eINSTANCE.getStatusReason_PluginId();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute STATUS_REASON__NAME = eINSTANCE.getStatusReason_Name();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.impl.LanguageImpl <em>Language</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.impl.LanguageImpl
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getLanguage()
         * @generated
         */
        EClass LANGUAGE = eINSTANCE.getLanguage();

        /**
         * The meta object literal for the '<em><b>ITALIAN</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LANGUAGE__ITALIAN = eINSTANCE.getLanguage_ITALIAN();

        /**
         * The meta object literal for the '<em><b>ENGLISH</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LANGUAGE__ENGLISH = eINSTANCE.getLanguage_ENGLISH();

        /**
         * The meta object literal for the '<em><b>Default Language</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LANGUAGE__DEFAULT_LANGUAGE = eINSTANCE.getLanguage_DefaultLanguage();

        /**
         * The meta object literal for the '<em><b>Locale</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LANGUAGE__LOCALE = eINSTANCE.getLanguage_Locale();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LANGUAGE__NAME = eINSTANCE.getLanguage_Name();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.impl.ActionImpl <em>Action</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.impl.ActionImpl
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getAction()
         * @generated
         */
        EClass ACTION = eINSTANCE.getAction();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ACTION__NAME = eINSTANCE.getAction_Name();

        /**
         * The meta object literal for the '<em><b>Icon Path</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ACTION__ICON_PATH = eINSTANCE.getAction_IconPath();

        /**
         * The meta object literal for the '<em><b>Permission</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ACTION__PERMISSION = eINSTANCE.getAction_Permission();

        /**
         * The meta object literal for the '<em><b>General</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ACTION__GENERAL = eINSTANCE.getAction_General();

        /**
         * The meta object literal for the '<em><b>Is Allowed</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ACTION___IS_ALLOWED__EOBJECT_ESTRUCTURALFEATURE = eINSTANCE.getAction__IsAllowed__EObject_EStructuralFeature();

        /**
         * The meta object literal for the '<em><b>Execute</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ACTION___EXECUTE__EOBJECT_ESTRUCTURALFEATURE = eINSTANCE.getAction__Execute__EObject_EStructuralFeature();

        /**
         * The meta object literal for the '<em><b>Get Command Id</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ACTION___GET_COMMAND_ID__EOBJECT = eINSTANCE.getAction__GetCommandId__EObject();

        /**
         * The meta object literal for the '{@link java.lang.Cloneable <em>Cloneable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.lang.Cloneable
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getCloneable()
         * @generated
         */
        EClass CLONEABLE = eINSTANCE.getCloneable();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.IContained <em>IContained</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.IContained
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIContained()
         * @generated
         */
        EClass ICONTAINED = eINSTANCE.getIContained();

        /**
         * The meta object literal for the '<em><b>Main EObject</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference ICONTAINED__MAIN_EOBJECT = eINSTANCE.getIContained_MainEObject();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.IContainedFeature <em>IContained Feature</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.IContainedFeature
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIContainedFeature()
         * @generated
         */
        EClass ICONTAINED_FEATURE = eINSTANCE.getIContainedFeature();

        /**
         * The meta object literal for the '<em><b>Main Feature</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ICONTAINED_FEATURE__MAIN_FEATURE = eINSTANCE.getIContainedFeature_MainFeature();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.IEMFDelegant <em>IEMF Delegant</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.IEMFDelegant
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getIEMFDelegant()
         * @generated
         */
        EClass IEMF_DELEGANT = eINSTANCE.getIEMFDelegant();

        /**
         * The meta object literal for the '<em><b>Delegated Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IEMF_DELEGANT__DELEGATED_ID = eINSTANCE.getIEMFDelegant_DelegatedId();

        /**
         * The meta object literal for the '<em>Image</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.swt.graphics.Image
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getImage()
         * @generated
         */
        EDataType IMAGE = eINSTANCE.getImage();

        /**
         * The meta object literal for the '<em>EStructural Feature</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.emf.ecore.EStructuralFeature
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getEStructuralFeature()
         * @generated
         */
        EDataType ESTRUCTURAL_FEATURE = eINSTANCE.getEStructuralFeature();

        /**
         * The meta object literal for the '<em>Entity Manager</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see javax.persistence.EntityManager
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getEntityManager()
         * @generated
         */
        EDataType ENTITY_MANAGER = eINSTANCE.getEntityManager();

        /**
         * The meta object literal for the '{@link java.io.Serializable <em>Serializable</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.io.Serializable
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getSerializable()
         * @generated
         */
        EClass SERIALIZABLE = eINSTANCE.getSerializable();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.interfaces.impl.PermissionImpl <em>Permission</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.impl.PermissionImpl
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getPermission()
         * @generated
         */
        EClass PERMISSION = eINSTANCE.getPermission();

        /**
         * The meta object literal for the '<em><b>ADMINISTRATION PERSPECTIVE VIEW</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PERMISSION__ADMINISTRATION_PERSPECTIVE_VIEW = eINSTANCE.getPermission_ADMINISTRATION_PERSPECTIVE_VIEW();

        /**
         * The meta object literal for the '<em><b>CONFIGURATION PERSPECTIVE VIEW</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PERMISSION__CONFIGURATION_PERSPECTIVE_VIEW = eINSTANCE.getPermission_CONFIGURATION_PERSPECTIVE_VIEW();

        /**
         * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PERMISSION__OBJECT = eINSTANCE.getPermission_Object();

        /**
         * The meta object literal for the '<em><b>Action</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PERMISSION__ACTION = eINSTANCE.getPermission_Action();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PERMISSION__NAME = eINSTANCE.getPermission_Name();

        /**
         * The meta object literal for the '<em><b>Is Star Permission</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation PERMISSION___IS_STAR_PERMISSION = eINSTANCE.getPermission__IsStarPermission();

        /**
         * The meta object literal for the '<em><b>Get Permission</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation PERMISSION___GET_PERMISSION = eINSTANCE.getPermission__GetPermission();

        /**
         * The meta object literal for the '<em><b>Get Permissions</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation PERMISSION___GET_PERMISSIONS = eINSTANCE.getPermission__GetPermissions();

        /**
         * The meta object literal for the '<em>Predicate</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see javax.persistence.criteria.Predicate
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getPredicate()
         * @generated
         */
        EDataType PREDICATE = eINSTANCE.getPredicate();

        /**
         * The meta object literal for the '<em>Criteria Builder</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see javax.persistence.criteria.CriteriaBuilder
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getCriteriaBuilder()
         * @generated
         */
        EDataType CRITERIA_BUILDER = eINSTANCE.getCriteriaBuilder();

        /**
         * The meta object literal for the '<em>Criteria Query</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see javax.persistence.criteria.CriteriaQuery
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getCriteriaQuery()
         * @generated
         */
        EDataType CRITERIA_QUERY = eINSTANCE.getCriteriaQuery();

        /**
         * The meta object literal for the '<em>From</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see javax.persistence.criteria.From
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getFrom()
         * @generated
         */
        EDataType FROM = eINSTANCE.getFrom();

        /**
         * The meta object literal for the '<em>Managed Type</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see javax.persistence.metamodel.ManagedType
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getManagedType()
         * @generated
         */
        EDataType MANAGED_TYPE = eINSTANCE.getManagedType();

        /**
         * The meta object literal for the '<em>Locale</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see java.util.Locale
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getLocale()
         * @generated
         */
        EDataType LOCALE = eINSTANCE.getLocale();

        /**
         * The meta object literal for the '<em>ISearch Provider</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.interfaces.ISearchProvider
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getISearchProvider()
         * @generated
         */
        EDataType ISEARCH_PROVIDER = eINSTANCE.getISearchProvider();

        /**
         * The meta object literal for the '<em>Feature Path</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.emf.databinding.FeaturePath
         * @see com.icteam.loyalty.model.interfaces.impl.ModelInterfacesPackageImpl#getFeaturePath()
         * @generated
         */
        EDataType FEATURE_PATH = eINSTANCE.getFeaturePath();

    }

    void dispose();

} //ModelInterfacesPackage

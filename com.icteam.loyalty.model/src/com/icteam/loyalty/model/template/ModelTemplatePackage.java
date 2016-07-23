/**
 */
package com.icteam.loyalty.model.template;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;

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
 * @see com.icteam.loyalty.model.template.ModelTemplateFactory
 * @model kind="package"
 * @generated
 */
public interface ModelTemplatePackage extends EPackage {
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "template";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://com.icteam.loyalty/model/template";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "com.icteam.loyalty.model.template";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModelTemplatePackage eINSTANCE = com.icteam.loyalty.model.template.impl.ModelTemplatePackageImpl.init();

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl <em>Abstract EMF Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl
     * @see com.icteam.loyalty.model.template.impl.ModelTemplatePackageImpl#getAbstractEMFTemplate()
     * @generated
     */
    int ABSTRACT_EMF_TEMPLATE = 0;

    /**
     * The feature id for the '<em><b>Distinct</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__DISTINCT = ModelInterfacesPackage.IEMF_TEMPLATE__DISTINCT;

    /**
     * The feature id for the '<em><b>First Result</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__FIRST_RESULT = ModelInterfacesPackage.IEMF_TEMPLATE__FIRST_RESULT;

    /**
     * The feature id for the '<em><b>Max Results</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__MAX_RESULTS = ModelInterfacesPackage.IEMF_TEMPLATE__MAX_RESULTS;

    /**
     * The feature id for the '<em><b>Single Result</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__SINGLE_RESULT = ModelInterfacesPackage.IEMF_TEMPLATE__SINGLE_RESULT;

    /**
     * The feature id for the '<em><b>Light Search</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__LIGHT_SEARCH = ModelInterfacesPackage.IEMF_TEMPLATE__LIGHT_SEARCH;

    /**
     * The feature id for the '<em><b>Nested</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__NESTED = ModelInterfacesPackage.IEMF_TEMPLATE__NESTED;

    /**
     * The feature id for the '<em><b>Order Features</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__ORDER_FEATURES = ModelInterfacesPackage.IEMF_TEMPLATE__ORDER_FEATURES;

    /**
     * The feature id for the '<em><b>Order Directions</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__ORDER_DIRECTIONS = ModelInterfacesPackage.IEMF_TEMPLATE__ORDER_DIRECTIONS;

    /**
     * The feature id for the '<em><b>Dynamic Filter Features</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTER_FEATURES = ModelInterfacesPackage.IEMF_TEMPLATE__DYNAMIC_FILTER_FEATURES;

    /**
     * The feature id for the '<em><b>Dynamic Filters</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERS = ModelInterfacesPackage.IEMF_TEMPLATE__DYNAMIC_FILTERS;

    /**
     * The feature id for the '<em><b>Dynamic Order Feature</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_FEATURE = ModelInterfacesPackage.IEMF_TEMPLATE__DYNAMIC_ORDER_FEATURE;

    /**
     * The feature id for the '<em><b>Dynamic Order Direction</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION = ModelInterfacesPackage.IEMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION;

    /**
     * The feature id for the '<em><b>Dynamic Filterable Features</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES = ModelInterfacesPackage.IEMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__EDITABLE = ModelInterfacesPackage.IEMF_TEMPLATE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Dirty</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__DIRTY = ModelInterfacesPackage.IEMF_TEMPLATE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Entity Manager</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__ENTITY_MANAGER = ModelInterfacesPackage.IEMF_TEMPLATE_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Wheres</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__WHERES = ModelInterfacesPackage.IEMF_TEMPLATE_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Builder</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__BUILDER = ModelInterfacesPackage.IEMF_TEMPLATE_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Criteria</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__CRITERIA = ModelInterfacesPackage.IEMF_TEMPLATE_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__ROOT = ModelInterfacesPackage.IEMF_TEMPLATE_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Excluded Features</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE__EXCLUDED_FEATURES = ModelInterfacesPackage.IEMF_TEMPLATE_FEATURE_COUNT + 7;

    /**
     * The number of structural features of the '<em>Abstract EMF Template</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE_FEATURE_COUNT = ModelInterfacesPackage.IEMF_TEMPLATE_FEATURE_COUNT + 8;

    /**
     * The operation id for the '<em>Initialized</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___INITIALIZED = ModelInterfacesPackage.IEMF_TEMPLATE___INITIALIZED;

    /**
     * The operation id for the '<em>Get Result Count</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___GET_RESULT_COUNT__ENTITYMANAGER = ModelInterfacesPackage.IEMF_TEMPLATE___GET_RESULT_COUNT__ENTITYMANAGER;

    /**
     * The operation id for the '<em>Get First Result</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___GET_FIRST_RESULT__ENTITYMANAGER = ModelInterfacesPackage.IEMF_TEMPLATE___GET_FIRST_RESULT__ENTITYMANAGER;

    /**
     * The operation id for the '<em>Get Result List</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___GET_RESULT_LIST__ENTITYMANAGER = ModelInterfacesPackage.IEMF_TEMPLATE___GET_RESULT_LIST__ENTITYMANAGER;

    /**
     * The operation id for the '<em>Has Dynamic Filters</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___HAS_DYNAMIC_FILTERS = ModelInterfacesPackage.IEMF_TEMPLATE___HAS_DYNAMIC_FILTERS;

    /**
     * The operation id for the '<em>Set Dynamic Filter Features</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___SET_DYNAMIC_FILTER_FEATURES__ELIST = ModelInterfacesPackage.IEMF_TEMPLATE___SET_DYNAMIC_FILTER_FEATURES__ELIST;

    /**
     * The operation id for the '<em>Set Raw Filter</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___SET_RAW_FILTER__STRING = ModelInterfacesPackage.IEMF_TEMPLATE___SET_RAW_FILTER__STRING;

    /**
     * The operation id for the '<em>Has Dynamic Order</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___HAS_DYNAMIC_ORDER = ModelInterfacesPackage.IEMF_TEMPLATE___HAS_DYNAMIC_ORDER;

    /**
     * The operation id for the '<em>Get Db Model Class</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___GET_DB_MODEL_CLASS = ModelInterfacesPackage.IEMF_TEMPLATE___GET_DB_MODEL_CLASS;

    /**
     * The operation id for the '<em>Get Id Value</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___GET_ID_VALUE = ModelInterfacesPackage.IEMF_TEMPLATE___GET_ID_VALUE;

    /**
     * The operation id for the '<em>Copy To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___COPY_TO__IEMFMODEL_BOOLEAN = ModelInterfacesPackage.IEMF_TEMPLATE_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___EQUALS__OBJECT = ModelInterfacesPackage.IEMF_TEMPLATE_OPERATION_COUNT + 1;

    /**
     * The operation id for the '<em>Get Metamodel</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___GET_METAMODEL = ModelInterfacesPackage.IEMF_TEMPLATE_OPERATION_COUNT + 2;

    /**
     * The operation id for the '<em>Build Fetches</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___BUILD_FETCHES = ModelInterfacesPackage.IEMF_TEMPLATE_OPERATION_COUNT + 3;

    /**
     * The operation id for the '<em>Check Dynamic Filters</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___CHECK_DYNAMIC_FILTERS__ELIST_ELIST = ModelInterfacesPackage.IEMF_TEMPLATE_OPERATION_COUNT + 4;

    /**
     * The operation id for the '<em>Build Wheres</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE___BUILD_WHERES = ModelInterfacesPackage.IEMF_TEMPLATE_OPERATION_COUNT + 5;

    /**
     * The number of operations of the '<em>Abstract EMF Template</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_EMF_TEMPLATE_OPERATION_COUNT = ModelInterfacesPackage.IEMF_TEMPLATE_OPERATION_COUNT + 6;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.template.impl.DictionaryEMFTemplateImpl <em>Dictionary EMF Template</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.template.impl.DictionaryEMFTemplateImpl
     * @see com.icteam.loyalty.model.template.impl.ModelTemplatePackageImpl#getDictionaryEMFTemplate()
     * @generated
     */
    int DICTIONARY_EMF_TEMPLATE = 1;

    /**
     * The feature id for the '<em><b>Distinct</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__DISTINCT = ABSTRACT_EMF_TEMPLATE__DISTINCT;

    /**
     * The feature id for the '<em><b>First Result</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__FIRST_RESULT = ABSTRACT_EMF_TEMPLATE__FIRST_RESULT;

    /**
     * The feature id for the '<em><b>Max Results</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__MAX_RESULTS = ABSTRACT_EMF_TEMPLATE__MAX_RESULTS;

    /**
     * The feature id for the '<em><b>Single Result</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__SINGLE_RESULT = ABSTRACT_EMF_TEMPLATE__SINGLE_RESULT;

    /**
     * The feature id for the '<em><b>Light Search</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__LIGHT_SEARCH = ABSTRACT_EMF_TEMPLATE__LIGHT_SEARCH;

    /**
     * The feature id for the '<em><b>Nested</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__NESTED = ABSTRACT_EMF_TEMPLATE__NESTED;

    /**
     * The feature id for the '<em><b>Order Features</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__ORDER_FEATURES = ABSTRACT_EMF_TEMPLATE__ORDER_FEATURES;

    /**
     * The feature id for the '<em><b>Order Directions</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__ORDER_DIRECTIONS = ABSTRACT_EMF_TEMPLATE__ORDER_DIRECTIONS;

    /**
     * The feature id for the '<em><b>Dynamic Filter Features</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__DYNAMIC_FILTER_FEATURES = ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTER_FEATURES;

    /**
     * The feature id for the '<em><b>Dynamic Filters</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__DYNAMIC_FILTERS = ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERS;

    /**
     * The feature id for the '<em><b>Dynamic Order Feature</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__DYNAMIC_ORDER_FEATURE = ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_FEATURE;

    /**
     * The feature id for the '<em><b>Dynamic Order Direction</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION = ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION;

    /**
     * The feature id for the '<em><b>Dynamic Filterable Features</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES = ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__EDITABLE = ABSTRACT_EMF_TEMPLATE__EDITABLE;

    /**
     * The feature id for the '<em><b>Dirty</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__DIRTY = ABSTRACT_EMF_TEMPLATE__DIRTY;

    /**
     * The feature id for the '<em><b>Entity Manager</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__ENTITY_MANAGER = ABSTRACT_EMF_TEMPLATE__ENTITY_MANAGER;

    /**
     * The feature id for the '<em><b>Wheres</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__WHERES = ABSTRACT_EMF_TEMPLATE__WHERES;

    /**
     * The feature id for the '<em><b>Builder</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__BUILDER = ABSTRACT_EMF_TEMPLATE__BUILDER;

    /**
     * The feature id for the '<em><b>Criteria</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__CRITERIA = ABSTRACT_EMF_TEMPLATE__CRITERIA;

    /**
     * The feature id for the '<em><b>Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__ROOT = ABSTRACT_EMF_TEMPLATE__ROOT;

    /**
     * The feature id for the '<em><b>Excluded Features</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__EXCLUDED_FEATURES = ABSTRACT_EMF_TEMPLATE__EXCLUDED_FEATURES;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__KEY = ABSTRACT_EMF_TEMPLATE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__VALUE = ABSTRACT_EMF_TEMPLATE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Language</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE__LANGUAGE = ABSTRACT_EMF_TEMPLATE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Dictionary EMF Template</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE_FEATURE_COUNT = ABSTRACT_EMF_TEMPLATE_FEATURE_COUNT + 3;

    /**
     * The operation id for the '<em>Initialized</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___INITIALIZED = ABSTRACT_EMF_TEMPLATE___INITIALIZED;

    /**
     * The operation id for the '<em>Get Result Count</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___GET_RESULT_COUNT__ENTITYMANAGER = ABSTRACT_EMF_TEMPLATE___GET_RESULT_COUNT__ENTITYMANAGER;

    /**
     * The operation id for the '<em>Get First Result</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___GET_FIRST_RESULT__ENTITYMANAGER = ABSTRACT_EMF_TEMPLATE___GET_FIRST_RESULT__ENTITYMANAGER;

    /**
     * The operation id for the '<em>Get Result List</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___GET_RESULT_LIST__ENTITYMANAGER = ABSTRACT_EMF_TEMPLATE___GET_RESULT_LIST__ENTITYMANAGER;

    /**
     * The operation id for the '<em>Has Dynamic Filters</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___HAS_DYNAMIC_FILTERS = ABSTRACT_EMF_TEMPLATE___HAS_DYNAMIC_FILTERS;

    /**
     * The operation id for the '<em>Set Dynamic Filter Features</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___SET_DYNAMIC_FILTER_FEATURES__ELIST = ABSTRACT_EMF_TEMPLATE___SET_DYNAMIC_FILTER_FEATURES__ELIST;

    /**
     * The operation id for the '<em>Set Raw Filter</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___SET_RAW_FILTER__STRING = ABSTRACT_EMF_TEMPLATE___SET_RAW_FILTER__STRING;

    /**
     * The operation id for the '<em>Has Dynamic Order</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___HAS_DYNAMIC_ORDER = ABSTRACT_EMF_TEMPLATE___HAS_DYNAMIC_ORDER;

    /**
     * The operation id for the '<em>Get Db Model Class</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___GET_DB_MODEL_CLASS = ABSTRACT_EMF_TEMPLATE___GET_DB_MODEL_CLASS;

    /**
     * The operation id for the '<em>Get Id Value</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___GET_ID_VALUE = ABSTRACT_EMF_TEMPLATE___GET_ID_VALUE;

    /**
     * The operation id for the '<em>Copy To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___COPY_TO__IEMFMODEL_BOOLEAN = ABSTRACT_EMF_TEMPLATE___COPY_TO__IEMFMODEL_BOOLEAN;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___EQUALS__OBJECT = ABSTRACT_EMF_TEMPLATE___EQUALS__OBJECT;

    /**
     * The operation id for the '<em>Get Metamodel</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___GET_METAMODEL = ABSTRACT_EMF_TEMPLATE___GET_METAMODEL;

    /**
     * The operation id for the '<em>Build Fetches</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___BUILD_FETCHES = ABSTRACT_EMF_TEMPLATE___BUILD_FETCHES;

    /**
     * The operation id for the '<em>Check Dynamic Filters</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___CHECK_DYNAMIC_FILTERS__ELIST_ELIST = ABSTRACT_EMF_TEMPLATE___CHECK_DYNAMIC_FILTERS__ELIST_ELIST;

    /**
     * The operation id for the '<em>Build Wheres</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE___BUILD_WHERES = ABSTRACT_EMF_TEMPLATE___BUILD_WHERES;

    /**
     * The number of operations of the '<em>Dictionary EMF Template</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int DICTIONARY_EMF_TEMPLATE_OPERATION_COUNT = ABSTRACT_EMF_TEMPLATE_OPERATION_COUNT + 0;

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate <em>Abstract EMF Template</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract EMF Template</em>'.
     * @see com.icteam.loyalty.model.template.AbstractEMFTemplate
     * @generated
     */
    EClass getAbstractEMFTemplate();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getEntityManager <em>Entity Manager</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Entity Manager</em>'.
     * @see com.icteam.loyalty.model.template.AbstractEMFTemplate#getEntityManager()
     * @see #getAbstractEMFTemplate()
     * @generated
     */
    EAttribute getAbstractEMFTemplate_EntityManager();

    /**
     * Returns the meta object for the attribute list '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getWheres <em>Wheres</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Wheres</em>'.
     * @see com.icteam.loyalty.model.template.AbstractEMFTemplate#getWheres()
     * @see #getAbstractEMFTemplate()
     * @generated
     */
    EAttribute getAbstractEMFTemplate_Wheres();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getBuilder <em>Builder</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Builder</em>'.
     * @see com.icteam.loyalty.model.template.AbstractEMFTemplate#getBuilder()
     * @see #getAbstractEMFTemplate()
     * @generated
     */
    EAttribute getAbstractEMFTemplate_Builder();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getCriteria <em>Criteria</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Criteria</em>'.
     * @see com.icteam.loyalty.model.template.AbstractEMFTemplate#getCriteria()
     * @see #getAbstractEMFTemplate()
     * @generated
     */
    EAttribute getAbstractEMFTemplate_Criteria();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getRoot <em>Root</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Root</em>'.
     * @see com.icteam.loyalty.model.template.AbstractEMFTemplate#getRoot()
     * @see #getAbstractEMFTemplate()
     * @generated
     */
    EAttribute getAbstractEMFTemplate_Root();

    /**
     * Returns the meta object for the attribute list '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getExcludedFeatures <em>Excluded Features</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute list '<em>Excluded Features</em>'.
     * @see com.icteam.loyalty.model.template.AbstractEMFTemplate#getExcludedFeatures()
     * @see #getAbstractEMFTemplate()
     * @generated
     */
    EAttribute getAbstractEMFTemplate_ExcludedFeatures();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getMetamodel() <em>Get Metamodel</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Metamodel</em>' operation.
     * @see com.icteam.loyalty.model.template.AbstractEMFTemplate#getMetamodel()
     * @generated
     */
    EOperation getAbstractEMFTemplate__GetMetamodel();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#buildFetches() <em>Build Fetches</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Build Fetches</em>' operation.
     * @see com.icteam.loyalty.model.template.AbstractEMFTemplate#buildFetches()
     * @generated
     */
    EOperation getAbstractEMFTemplate__BuildFetches();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#checkDynamicFilters(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Check Dynamic Filters</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Check Dynamic Filters</em>' operation.
     * @see com.icteam.loyalty.model.template.AbstractEMFTemplate#checkDynamicFilters(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
     * @generated
     */
    EOperation getAbstractEMFTemplate__CheckDynamicFilters__EList_EList();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#buildWheres() <em>Build Wheres</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Build Wheres</em>' operation.
     * @see com.icteam.loyalty.model.template.AbstractEMFTemplate#buildWheres()
     * @generated
     */
    EOperation getAbstractEMFTemplate__BuildWheres();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.template.DictionaryEMFTemplate <em>Dictionary EMF Template</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Dictionary EMF Template</em>'.
     * @see com.icteam.loyalty.model.template.DictionaryEMFTemplate
     * @generated
     */
    EClass getDictionaryEMFTemplate();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.template.DictionaryEMFTemplate#getKey <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see com.icteam.loyalty.model.template.DictionaryEMFTemplate#getKey()
     * @see #getDictionaryEMFTemplate()
     * @generated
     */
    EAttribute getDictionaryEMFTemplate_Key();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.template.DictionaryEMFTemplate#getLanguage <em>Language</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Language</em>'.
     * @see com.icteam.loyalty.model.template.DictionaryEMFTemplate#getLanguage()
     * @see #getDictionaryEMFTemplate()
     * @generated
     */
    EReference getDictionaryEMFTemplate_Language();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.template.DictionaryEMFTemplate#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see com.icteam.loyalty.model.template.DictionaryEMFTemplate#getValue()
     * @see #getDictionaryEMFTemplate()
     * @generated
     */
    EAttribute getDictionaryEMFTemplate_Value();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ModelTemplateFactory getModelTemplateFactory();

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
         * The meta object literal for the '{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl <em>Abstract EMF Template</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl
         * @see com.icteam.loyalty.model.template.impl.ModelTemplatePackageImpl#getAbstractEMFTemplate()
         * @generated
         */
        EClass ABSTRACT_EMF_TEMPLATE = eINSTANCE.getAbstractEMFTemplate();

        /**
         * The meta object literal for the '<em><b>Entity Manager</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_EMF_TEMPLATE__ENTITY_MANAGER = eINSTANCE.getAbstractEMFTemplate_EntityManager();

        /**
         * The meta object literal for the '<em><b>Wheres</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_EMF_TEMPLATE__WHERES = eINSTANCE.getAbstractEMFTemplate_Wheres();

        /**
         * The meta object literal for the '<em><b>Builder</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_EMF_TEMPLATE__BUILDER = eINSTANCE.getAbstractEMFTemplate_Builder();

        /**
         * The meta object literal for the '<em><b>Criteria</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_EMF_TEMPLATE__CRITERIA = eINSTANCE.getAbstractEMFTemplate_Criteria();

        /**
         * The meta object literal for the '<em><b>Root</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_EMF_TEMPLATE__ROOT = eINSTANCE.getAbstractEMFTemplate_Root();

        /**
         * The meta object literal for the '<em><b>Excluded Features</b></em>' attribute list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_EMF_TEMPLATE__EXCLUDED_FEATURES = eINSTANCE.getAbstractEMFTemplate_ExcludedFeatures();

        /**
         * The meta object literal for the '<em><b>Get Metamodel</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ABSTRACT_EMF_TEMPLATE___GET_METAMODEL = eINSTANCE.getAbstractEMFTemplate__GetMetamodel();

        /**
         * The meta object literal for the '<em><b>Build Fetches</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ABSTRACT_EMF_TEMPLATE___BUILD_FETCHES = eINSTANCE.getAbstractEMFTemplate__BuildFetches();

        /**
         * The meta object literal for the '<em><b>Check Dynamic Filters</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ABSTRACT_EMF_TEMPLATE___CHECK_DYNAMIC_FILTERS__ELIST_ELIST = eINSTANCE.getAbstractEMFTemplate__CheckDynamicFilters__EList_EList();

        /**
         * The meta object literal for the '<em><b>Build Wheres</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation ABSTRACT_EMF_TEMPLATE___BUILD_WHERES = eINSTANCE.getAbstractEMFTemplate__BuildWheres();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.template.impl.DictionaryEMFTemplateImpl <em>Dictionary EMF Template</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.template.impl.DictionaryEMFTemplateImpl
         * @see com.icteam.loyalty.model.template.impl.ModelTemplatePackageImpl#getDictionaryEMFTemplate()
         * @generated
         */
        EClass DICTIONARY_EMF_TEMPLATE = eINSTANCE.getDictionaryEMFTemplate();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DICTIONARY_EMF_TEMPLATE__KEY = eINSTANCE.getDictionaryEMFTemplate_Key();

        /**
         * The meta object literal for the '<em><b>Language</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference DICTIONARY_EMF_TEMPLATE__LANGUAGE = eINSTANCE.getDictionaryEMFTemplate_Language();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute DICTIONARY_EMF_TEMPLATE__VALUE = eINSTANCE.getDictionaryEMFTemplate_Value();

    }

    void dispose();

} //ModelTemplatePackage

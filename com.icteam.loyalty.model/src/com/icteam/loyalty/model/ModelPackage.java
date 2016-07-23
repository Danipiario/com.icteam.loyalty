/**
 */
package com.icteam.loyalty.model;

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
 * @see com.icteam.loyalty.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
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
    String eNS_URI = "http://com.icteam.loyalty/model";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "com.icteam.loyalty.model";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ModelPackage eINSTANCE = com.icteam.loyalty.model.impl.ModelPackageImpl.init();

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.impl.EMFModelImpl <em>EMF Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.impl.EMFModelImpl
     * @see com.icteam.loyalty.model.impl.ModelPackageImpl#getEMFModel()
     * @generated
     */
    int EMF_MODEL = 0;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_MODEL__EDITABLE = ModelInterfacesPackage.IEMF_MODEL__EDITABLE;

    /**
     * The feature id for the '<em><b>Dirty</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_MODEL__DIRTY = ModelInterfacesPackage.IEMF_MODEL__DIRTY;

    /**
     * The number of structural features of the '<em>EMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_MODEL_FEATURE_COUNT = ModelInterfacesPackage.IEMF_MODEL_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Copy To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN = ModelInterfacesPackage.IEMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_MODEL___EQUALS__OBJECT = ModelInterfacesPackage.IEMF_MODEL___EQUALS__OBJECT;

    /**
     * The operation id for the '<em>Get Model Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_MODEL___GET_MODEL_NAME = ModelInterfacesPackage.IEMF_MODEL_OPERATION_COUNT + 0;

    /**
     * The operation id for the '<em>Has Editor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_MODEL___HAS_EDITOR = ModelInterfacesPackage.IEMF_MODEL_OPERATION_COUNT + 1;

    /**
     * The operation id for the '<em>Get Permission Object</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_MODEL___GET_PERMISSION_OBJECT = ModelInterfacesPackage.IEMF_MODEL_OPERATION_COUNT + 2;

    /**
     * The number of operations of the '<em>EMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EMF_MODEL_OPERATION_COUNT = ModelInterfacesPackage.IEMF_MODEL_OPERATION_COUNT + 3;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.impl.ResultEMFModelImpl <em>Result EMF Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.impl.ResultEMFModelImpl
     * @see com.icteam.loyalty.model.impl.ModelPackageImpl#getResultEMFModel()
     * @generated
     */
    int RESULT_EMF_MODEL = 1;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_EMF_MODEL__EDITABLE = EMF_MODEL__EDITABLE;

    /**
     * The feature id for the '<em><b>Dirty</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_EMF_MODEL__DIRTY = EMF_MODEL__DIRTY;

    /**
     * The feature id for the '<em><b>Exception</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_EMF_MODEL__EXCEPTION = EMF_MODEL_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Status Reason</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_EMF_MODEL__STATUS_REASON = EMF_MODEL_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Result EMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_EMF_MODEL_FEATURE_COUNT = EMF_MODEL_FEATURE_COUNT + 2;

    /**
     * The operation id for the '<em>Copy To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_EMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN = EMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_EMF_MODEL___EQUALS__OBJECT = EMF_MODEL___EQUALS__OBJECT;

    /**
     * The operation id for the '<em>Get Model Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_EMF_MODEL___GET_MODEL_NAME = EMF_MODEL___GET_MODEL_NAME;

    /**
     * The operation id for the '<em>Has Editor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_EMF_MODEL___HAS_EDITOR = EMF_MODEL___HAS_EDITOR;

    /**
     * The operation id for the '<em>Get Permission Object</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_EMF_MODEL___GET_PERMISSION_OBJECT = EMF_MODEL___GET_PERMISSION_OBJECT;

    /**
     * The number of operations of the '<em>Result EMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int RESULT_EMF_MODEL_OPERATION_COUNT = EMF_MODEL_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.model.impl.ListEMFModelImpl <em>List EMF Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.model.impl.ListEMFModelImpl
     * @see com.icteam.loyalty.model.impl.ModelPackageImpl#getListEMFModel()
     * @generated
     */
    int LIST_EMF_MODEL = 2;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_EMF_MODEL__EDITABLE = EMF_MODEL__EDITABLE;

    /**
     * The feature id for the '<em><b>Dirty</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_EMF_MODEL__DIRTY = EMF_MODEL__DIRTY;

    /**
     * The feature id for the '<em><b>List</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_EMF_MODEL__LIST = EMF_MODEL_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Selected Model</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_EMF_MODEL__SELECTED_MODEL = EMF_MODEL_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>List EMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_EMF_MODEL_FEATURE_COUNT = EMF_MODEL_FEATURE_COUNT + 2;

    /**
     * The operation id for the '<em>Copy To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_EMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN = EMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_EMF_MODEL___EQUALS__OBJECT = EMF_MODEL___EQUALS__OBJECT;

    /**
     * The operation id for the '<em>Get Model Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_EMF_MODEL___GET_MODEL_NAME = EMF_MODEL___GET_MODEL_NAME;

    /**
     * The operation id for the '<em>Has Editor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_EMF_MODEL___HAS_EDITOR = EMF_MODEL___HAS_EDITOR;

    /**
     * The operation id for the '<em>Get Permission Object</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_EMF_MODEL___GET_PERMISSION_OBJECT = EMF_MODEL___GET_PERMISSION_OBJECT;

    /**
     * The number of operations of the '<em>List EMF Model</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LIST_EMF_MODEL_OPERATION_COUNT = EMF_MODEL_OPERATION_COUNT + 0;

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.EMFModel <em>EMF Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>EMF Model</em>'.
     * @see com.icteam.loyalty.model.EMFModel
     * @generated
     */
    EClass getEMFModel();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.EMFModel#getModelName() <em>Get Model Name</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Model Name</em>' operation.
     * @see com.icteam.loyalty.model.EMFModel#getModelName()
     * @generated
     */
    EOperation getEMFModel__GetModelName();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.EMFModel#hasEditor() <em>Has Editor</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Has Editor</em>' operation.
     * @see com.icteam.loyalty.model.EMFModel#hasEditor()
     * @generated
     */
    EOperation getEMFModel__HasEditor();

    /**
     * Returns the meta object for the '{@link com.icteam.loyalty.model.EMFModel#getPermissionObject() <em>Get Permission Object</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Get Permission Object</em>' operation.
     * @see com.icteam.loyalty.model.EMFModel#getPermissionObject()
     * @generated
     */
    EOperation getEMFModel__GetPermissionObject();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.ResultEMFModel <em>Result EMF Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Result EMF Model</em>'.
     * @see com.icteam.loyalty.model.ResultEMFModel
     * @generated
     */
    EClass getResultEMFModel();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.ResultEMFModel#getException <em>Exception</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Exception</em>'.
     * @see com.icteam.loyalty.model.ResultEMFModel#getException()
     * @see #getResultEMFModel()
     * @generated
     */
    EAttribute getResultEMFModel_Exception();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.model.ResultEMFModel#getStatusReason <em>Status Reason</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Status Reason</em>'.
     * @see com.icteam.loyalty.model.ResultEMFModel#getStatusReason()
     * @see #getResultEMFModel()
     * @generated
     */
    EReference getResultEMFModel_StatusReason();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.model.ListEMFModel <em>List EMF Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>List EMF Model</em>'.
     * @see com.icteam.loyalty.model.ListEMFModel
     * @generated
     */
    EClass getListEMFModel();

    /**
     * Returns the meta object for the reference list '{@link com.icteam.loyalty.model.ListEMFModel#getList <em>List</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>List</em>'.
     * @see com.icteam.loyalty.model.ListEMFModel#getList()
     * @see #getListEMFModel()
     * @generated
     */
    EReference getListEMFModel_List();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.model.ListEMFModel#getSelectedModel <em>Selected Model</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Selected Model</em>'.
     * @see com.icteam.loyalty.model.ListEMFModel#getSelectedModel()
     * @see #getListEMFModel()
     * @generated
     */
    EAttribute getListEMFModel_SelectedModel();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ModelFactory getModelFactory();

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
         * The meta object literal for the '{@link com.icteam.loyalty.model.impl.EMFModelImpl <em>EMF Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.impl.EMFModelImpl
         * @see com.icteam.loyalty.model.impl.ModelPackageImpl#getEMFModel()
         * @generated
         */
        EClass EMF_MODEL = eINSTANCE.getEMFModel();

        /**
         * The meta object literal for the '<em><b>Get Model Name</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation EMF_MODEL___GET_MODEL_NAME = eINSTANCE.getEMFModel__GetModelName();

        /**
         * The meta object literal for the '<em><b>Has Editor</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation EMF_MODEL___HAS_EDITOR = eINSTANCE.getEMFModel__HasEditor();

        /**
         * The meta object literal for the '<em><b>Get Permission Object</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation EMF_MODEL___GET_PERMISSION_OBJECT = eINSTANCE.getEMFModel__GetPermissionObject();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.impl.ResultEMFModelImpl <em>Result EMF Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.impl.ResultEMFModelImpl
         * @see com.icteam.loyalty.model.impl.ModelPackageImpl#getResultEMFModel()
         * @generated
         */
        EClass RESULT_EMF_MODEL = eINSTANCE.getResultEMFModel();

        /**
         * The meta object literal for the '<em><b>Exception</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute RESULT_EMF_MODEL__EXCEPTION = eINSTANCE.getResultEMFModel_Exception();

        /**
         * The meta object literal for the '<em><b>Status Reason</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference RESULT_EMF_MODEL__STATUS_REASON = eINSTANCE.getResultEMFModel_StatusReason();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.model.impl.ListEMFModelImpl <em>List EMF Model</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.model.impl.ListEMFModelImpl
         * @see com.icteam.loyalty.model.impl.ModelPackageImpl#getListEMFModel()
         * @generated
         */
        EClass LIST_EMF_MODEL = eINSTANCE.getListEMFModel();

        /**
         * The meta object literal for the '<em><b>List</b></em>' reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference LIST_EMF_MODEL__LIST = eINSTANCE.getListEMFModel_List();

        /**
         * The meta object literal for the '<em><b>Selected Model</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LIST_EMF_MODEL__SELECTED_MODEL = eINSTANCE.getListEMFModel_SelectedModel();

    }

    void dispose();

} //ModelPackage

/**
 */
package com.icteam.loyalty.ui.interfaces;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see com.icteam.loyalty.ui.interfaces.UIInterfacesFactory
 * @model kind="package"
 * @generated
 */
public interface UIInterfacesPackage extends EPackage {
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
    String eNS_URI = "http://com.icteam.loyalty/ui/interfaces";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "com.icteam.loyalty.ui.interfaces";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    UIInterfacesPackage eINSTANCE = com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl.init();

    /**
     * The meta object id for the '{@link com.icteam.loyalty.ui.interfaces.IBaseClassProvider <em>IBase Class Provider</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.ui.interfaces.IBaseClassProvider
     * @see com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl#getIBaseClassProvider()
     * @generated
     */
    int IBASE_CLASS_PROVIDER = 0;

    /**
     * The feature id for the '<em><b>Base Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IBASE_CLASS_PROVIDER__BASE_CLASS = 0;

    /**
     * The number of structural features of the '<em>IBase Class Provider</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IBASE_CLASS_PROVIDER_FEATURE_COUNT = 1;

    /**
     * The number of operations of the '<em>IBase Class Provider</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IBASE_CLASS_PROVIDER_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.ui.interfaces.impl.UIActionImpl <em>UI Action</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.ui.interfaces.impl.UIActionImpl
     * @see com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl#getUIAction()
     * @generated
     */
    int UI_ACTION = 1;

    /**
     * The feature id for the '<em><b>Editable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__EDITABLE = ModelInterfacesPackage.ACTION__EDITABLE;

    /**
     * The feature id for the '<em><b>Dirty</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__DIRTY = ModelInterfacesPackage.ACTION__DIRTY;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__NAME = ModelInterfacesPackage.ACTION__NAME;

    /**
     * The feature id for the '<em><b>Icon Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__ICON_PATH = ModelInterfacesPackage.ACTION__ICON_PATH;

    /**
     * The feature id for the '<em><b>Permission</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__PERMISSION = ModelInterfacesPackage.ACTION__PERMISSION;

    /**
     * The feature id for the '<em><b>General</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__GENERAL = ModelInterfacesPackage.ACTION__GENERAL;

    /**
     * The feature id for the '<em><b>NTOM ALL TO SRC</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__NTOM_ALL_TO_SRC = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>NTOM TO SRC</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__NTOM_TO_SRC = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>NTOM ALL TO DEST</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__NTOM_ALL_TO_DEST = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>NTOM TO DEST</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__NTOM_TO_DEST = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>EDITOR SAVE</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__EDITOR_SAVE = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>EDITOR CANCEL</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__EDITOR_CANCEL = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>VIEW OPEN EDITOR</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__VIEW_OPEN_EDITOR = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>VIEW FILTER COLUMNS</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__VIEW_FILTER_COLUMNS = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>VIEW ADVANCED FILTER</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__VIEW_ADVANCED_FILTER = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 8;

    /**
     * The feature id for the '<em><b>VIEW REFRESH</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__VIEW_REFRESH = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>VIEW SELECT COLUMN</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__VIEW_SELECT_COLUMN = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 10;

    /**
     * The feature id for the '<em><b>VIEW ADD</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__VIEW_ADD = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 11;

    /**
     * The feature id for the '<em><b>VIEW REMOVE</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION__VIEW_REMOVE = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 12;

    /**
     * The number of structural features of the '<em>UI Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION_FEATURE_COUNT = ModelInterfacesPackage.ACTION_FEATURE_COUNT + 13;

    /**
     * The operation id for the '<em>Compare To</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION___COMPARE_TO__IEMFENHANCEDENUM = ModelInterfacesPackage.ACTION___COMPARE_TO__IEMFENHANCEDENUM;

    /**
     * The operation id for the '<em>Get Name</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION___GET_NAME = ModelInterfacesPackage.ACTION___GET_NAME;

    /**
     * The operation id for the '<em>Equals</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION___EQUALS__OBJECT = ModelInterfacesPackage.ACTION___EQUALS__OBJECT;

    /**
     * The operation id for the '<em>Is Allowed</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION___IS_ALLOWED__EOBJECT_ESTRUCTURALFEATURE = ModelInterfacesPackage.ACTION___IS_ALLOWED__EOBJECT_ESTRUCTURALFEATURE;

    /**
     * The operation id for the '<em>Execute</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION___EXECUTE__EOBJECT_ESTRUCTURALFEATURE = ModelInterfacesPackage.ACTION___EXECUTE__EOBJECT_ESTRUCTURALFEATURE;

    /**
     * The operation id for the '<em>Get Command Id</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION___GET_COMMAND_ID__EOBJECT = ModelInterfacesPackage.ACTION___GET_COMMAND_ID__EOBJECT;

    /**
     * The number of operations of the '<em>UI Action</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int UI_ACTION_OPERATION_COUNT = ModelInterfacesPackage.ACTION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.ui.interfaces.impl.EStructuralFeatureToIntMapImpl <em>EStructural Feature To Int Map</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.ui.interfaces.impl.EStructuralFeatureToIntMapImpl
     * @see com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl#getEStructuralFeatureToIntMap()
     * @generated
     */
    int ESTRUCTURAL_FEATURE_TO_INT_MAP = 2;

    /**
     * The feature id for the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ESTRUCTURAL_FEATURE_TO_INT_MAP__KEY = 0;

    /**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ESTRUCTURAL_FEATURE_TO_INT_MAP__VALUE = 1;

    /**
     * The number of structural features of the '<em>EStructural Feature To Int Map</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ESTRUCTURAL_FEATURE_TO_INT_MAP_FEATURE_COUNT = 2;

    /**
     * The number of operations of the '<em>EStructural Feature To Int Map</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ESTRUCTURAL_FEATURE_TO_INT_MAP_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.ui.IEditorInput <em>IEditor Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ui.IEditorInput
     * @see com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl#getIEditorInput()
     * @generated
     */
    int IEDITOR_INPUT = 3;

    /**
     * The number of structural features of the '<em>IEditor Input</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEDITOR_INPUT_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>IEditor Input</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEDITOR_INPUT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.ui.IEditorPart <em>IEditor Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.ui.IEditorPart
     * @see com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl#getIEditorPart()
     * @generated
     */
    int IEDITOR_PART = 4;

    /**
     * The number of structural features of the '<em>IEditor Part</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEDITOR_PART_FEATURE_COUNT = 0;

    /**
     * The number of operations of the '<em>IEditor Part</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int IEDITOR_PART_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link com.icteam.loyalty.ui.interfaces.NToMDirection <em>NTo MDirection</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.icteam.loyalty.ui.interfaces.NToMDirection
     * @see com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl#getNToMDirection()
     * @generated
     */
    int NTO_MDIRECTION = 5;

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.ui.interfaces.IBaseClassProvider <em>IBase Class Provider</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IBase Class Provider</em>'.
     * @see com.icteam.loyalty.ui.interfaces.IBaseClassProvider
     * @generated
     */
    EClass getIBaseClassProvider();

    /**
     * Returns the meta object for the attribute '{@link com.icteam.loyalty.ui.interfaces.IBaseClassProvider#getBaseClass <em>Base Class</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Base Class</em>'.
     * @see com.icteam.loyalty.ui.interfaces.IBaseClassProvider#getBaseClass()
     * @see #getIBaseClassProvider()
     * @generated
     */
    EAttribute getIBaseClassProvider_BaseClass();

    /**
     * Returns the meta object for class '{@link com.icteam.loyalty.ui.interfaces.UIAction <em>UI Action</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>UI Action</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction
     * @generated
     */
    EClass getUIAction();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getNTOM_ALL_TO_SRC <em>NTOM ALL TO SRC</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>NTOM ALL TO SRC</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getNTOM_ALL_TO_SRC()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_NTOM_ALL_TO_SRC();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getNTOM_TO_SRC <em>NTOM TO SRC</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>NTOM TO SRC</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getNTOM_TO_SRC()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_NTOM_TO_SRC();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getNTOM_ALL_TO_DEST <em>NTOM ALL TO DEST</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>NTOM ALL TO DEST</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getNTOM_ALL_TO_DEST()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_NTOM_ALL_TO_DEST();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getNTOM_TO_DEST <em>NTOM TO DEST</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>NTOM TO DEST</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getNTOM_TO_DEST()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_NTOM_TO_DEST();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getEDITOR_SAVE <em>EDITOR SAVE</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>EDITOR SAVE</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getEDITOR_SAVE()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_EDITOR_SAVE();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getEDITOR_CANCEL <em>EDITOR CANCEL</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>EDITOR CANCEL</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getEDITOR_CANCEL()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_EDITOR_CANCEL();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_OPEN_EDITOR <em>VIEW OPEN EDITOR</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>VIEW OPEN EDITOR</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_OPEN_EDITOR()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_VIEW_OPEN_EDITOR();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_FILTER_COLUMNS <em>VIEW FILTER COLUMNS</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>VIEW FILTER COLUMNS</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_FILTER_COLUMNS()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_VIEW_FILTER_COLUMNS();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_ADVANCED_FILTER <em>VIEW ADVANCED FILTER</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>VIEW ADVANCED FILTER</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_ADVANCED_FILTER()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_VIEW_ADVANCED_FILTER();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_REFRESH <em>VIEW REFRESH</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>VIEW REFRESH</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_REFRESH()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_VIEW_REFRESH();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_SELECT_COLUMN <em>VIEW SELECT COLUMN</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>VIEW SELECT COLUMN</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_SELECT_COLUMN()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_VIEW_SELECT_COLUMN();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_ADD <em>VIEW ADD</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>VIEW ADD</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_ADD()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_VIEW_ADD();

    /**
     * Returns the meta object for the reference '{@link com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_REMOVE <em>VIEW REMOVE</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>VIEW REMOVE</em>'.
     * @see com.icteam.loyalty.ui.interfaces.UIAction#getVIEW_REMOVE()
     * @see #getUIAction()
     * @generated
     */
    EReference getUIAction_VIEW_REMOVE();

    /**
     * Returns the meta object for class '{@link java.util.Map.Entry <em>EStructural Feature To Int Map</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>EStructural Feature To Int Map</em>'.
     * @see java.util.Map.Entry
     * @model keyDataType="com.icteam.loyalty.model.interfaces.EStructuralFeature"
     *        valueDataType="org.eclipse.emf.ecore.EIntegerObject"
     * @generated
     */
    EClass getEStructuralFeatureToIntMap();

    /**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Key</em>'.
     * @see java.util.Map.Entry
     * @see #getEStructuralFeatureToIntMap()
     * @generated
     */
    EAttribute getEStructuralFeatureToIntMap_Key();

    /**
     * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Value</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see java.util.Map.Entry
     * @see #getEStructuralFeatureToIntMap()
     * @generated
     */
    EAttribute getEStructuralFeatureToIntMap_Value();

    /**
     * Returns the meta object for class '{@link org.eclipse.ui.IEditorInput <em>IEditor Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IEditor Input</em>'.
     * @see org.eclipse.ui.IEditorInput
     * @model instanceClass="org.eclipse.ui.IEditorInput"
     * @generated
     */
    EClass getIEditorInput();

    /**
     * Returns the meta object for class '{@link org.eclipse.ui.IEditorPart <em>IEditor Part</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>IEditor Part</em>'.
     * @see org.eclipse.ui.IEditorPart
     * @model instanceClass="org.eclipse.ui.IEditorPart"
     * @generated
     */
    EClass getIEditorPart();

    /**
     * Returns the meta object for enum '{@link com.icteam.loyalty.ui.interfaces.NToMDirection <em>NTo MDirection</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for enum '<em>NTo MDirection</em>'.
     * @see com.icteam.loyalty.ui.interfaces.NToMDirection
     * @generated
     */
    EEnum getNToMDirection();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    UIInterfacesFactory getUIInterfacesFactory();

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
         * The meta object literal for the '{@link com.icteam.loyalty.ui.interfaces.IBaseClassProvider <em>IBase Class Provider</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.ui.interfaces.IBaseClassProvider
         * @see com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl#getIBaseClassProvider()
         * @generated
         */
        EClass IBASE_CLASS_PROVIDER = eINSTANCE.getIBaseClassProvider();

        /**
         * The meta object literal for the '<em><b>Base Class</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute IBASE_CLASS_PROVIDER__BASE_CLASS = eINSTANCE.getIBaseClassProvider_BaseClass();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.ui.interfaces.impl.UIActionImpl <em>UI Action</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.ui.interfaces.impl.UIActionImpl
         * @see com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl#getUIAction()
         * @generated
         */
        EClass UI_ACTION = eINSTANCE.getUIAction();

        /**
         * The meta object literal for the '<em><b>NTOM ALL TO SRC</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__NTOM_ALL_TO_SRC = eINSTANCE.getUIAction_NTOM_ALL_TO_SRC();

        /**
         * The meta object literal for the '<em><b>NTOM TO SRC</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__NTOM_TO_SRC = eINSTANCE.getUIAction_NTOM_TO_SRC();

        /**
         * The meta object literal for the '<em><b>NTOM ALL TO DEST</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__NTOM_ALL_TO_DEST = eINSTANCE.getUIAction_NTOM_ALL_TO_DEST();

        /**
         * The meta object literal for the '<em><b>NTOM TO DEST</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__NTOM_TO_DEST = eINSTANCE.getUIAction_NTOM_TO_DEST();

        /**
         * The meta object literal for the '<em><b>EDITOR SAVE</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__EDITOR_SAVE = eINSTANCE.getUIAction_EDITOR_SAVE();

        /**
         * The meta object literal for the '<em><b>EDITOR CANCEL</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__EDITOR_CANCEL = eINSTANCE.getUIAction_EDITOR_CANCEL();

        /**
         * The meta object literal for the '<em><b>VIEW OPEN EDITOR</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__VIEW_OPEN_EDITOR = eINSTANCE.getUIAction_VIEW_OPEN_EDITOR();

        /**
         * The meta object literal for the '<em><b>VIEW FILTER COLUMNS</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__VIEW_FILTER_COLUMNS = eINSTANCE.getUIAction_VIEW_FILTER_COLUMNS();

        /**
         * The meta object literal for the '<em><b>VIEW ADVANCED FILTER</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__VIEW_ADVANCED_FILTER = eINSTANCE.getUIAction_VIEW_ADVANCED_FILTER();

        /**
         * The meta object literal for the '<em><b>VIEW REFRESH</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__VIEW_REFRESH = eINSTANCE.getUIAction_VIEW_REFRESH();

        /**
         * The meta object literal for the '<em><b>VIEW SELECT COLUMN</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__VIEW_SELECT_COLUMN = eINSTANCE.getUIAction_VIEW_SELECT_COLUMN();

        /**
         * The meta object literal for the '<em><b>VIEW ADD</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__VIEW_ADD = eINSTANCE.getUIAction_VIEW_ADD();

        /**
         * The meta object literal for the '<em><b>VIEW REMOVE</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference UI_ACTION__VIEW_REMOVE = eINSTANCE.getUIAction_VIEW_REMOVE();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.ui.interfaces.impl.EStructuralFeatureToIntMapImpl <em>EStructural Feature To Int Map</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.ui.interfaces.impl.EStructuralFeatureToIntMapImpl
         * @see com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl#getEStructuralFeatureToIntMap()
         * @generated
         */
        EClass ESTRUCTURAL_FEATURE_TO_INT_MAP = eINSTANCE.getEStructuralFeatureToIntMap();

        /**
         * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ESTRUCTURAL_FEATURE_TO_INT_MAP__KEY = eINSTANCE.getEStructuralFeatureToIntMap_Key();

        /**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ESTRUCTURAL_FEATURE_TO_INT_MAP__VALUE = eINSTANCE.getEStructuralFeatureToIntMap_Value();

        /**
         * The meta object literal for the '{@link org.eclipse.ui.IEditorInput <em>IEditor Input</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ui.IEditorInput
         * @see com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl#getIEditorInput()
         * @generated
         */
        EClass IEDITOR_INPUT = eINSTANCE.getIEditorInput();

        /**
         * The meta object literal for the '{@link org.eclipse.ui.IEditorPart <em>IEditor Part</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.ui.IEditorPart
         * @see com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl#getIEditorPart()
         * @generated
         */
        EClass IEDITOR_PART = eINSTANCE.getIEditorPart();

        /**
         * The meta object literal for the '{@link com.icteam.loyalty.ui.interfaces.NToMDirection <em>NTo MDirection</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see com.icteam.loyalty.ui.interfaces.NToMDirection
         * @see com.icteam.loyalty.ui.interfaces.impl.UIInterfacesPackageImpl#getNToMDirection()
         * @generated
         */
        EEnum NTO_MDIRECTION = eINSTANCE.getNToMDirection();

    }

    void dispose();

} //UIInterfacesPackage

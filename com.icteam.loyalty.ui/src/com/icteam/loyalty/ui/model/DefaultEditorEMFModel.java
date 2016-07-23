/**
 */
package com.icteam.loyalty.ui.model;

import org.eclipse.ui.IEditorInput;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.interfaces.Action;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Editor EMF Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getSaveAction <em>Save Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getCancelAction <em>Cancel Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getVirtualViewEMFModel <em>Virtual View EMF Model</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getEditorID <em>Editor ID</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel#getInternalModel <em>Internal Model</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.ui.model.UIModelPackage#getDefaultEditorEMFModel()
 * @model superTypes="com.icteam.loyalty.model.EMFModel com.icteam.loyalty.ui.interfaces.IEditorInput"
 * @generated
 */
public interface DefaultEditorEMFModel<D extends EMFModel> extends EMFModel, IEditorInput {

    /**
     * Returns the value of the '<em><b>Save Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Save Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Save Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getDefaultEditorEMFModel_SaveAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getSaveAction();

    /**
     * Returns the value of the '<em><b>Cancel Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cancel Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cancel Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getDefaultEditorEMFModel_CancelAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getCancelAction();

    /**
     * Returns the value of the '<em><b>Internal Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Internal Model</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Internal Model</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getDefaultEditorEMFModel_InternalModel()
     * @model resolveProxies="false" transient="true" changeable="false"
     * @generated
     */
    D getInternalModel();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void init(D internalModel, VirtualViewEMFModel< ? , D> virtualViewModel);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void init(D internalModel);

    /**
     * Returns the value of the '<em><b>Virtual View EMF Model</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Virtual View EMF Model</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Virtual View EMF Model</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getDefaultEditorEMFModel_VirtualViewEMFModel()
     * @model resolveProxies="false" transient="true" changeable="false"
     * @generated
     */
    VirtualViewEMFModel< ? , D> getVirtualViewEMFModel();

    /**
     * Returns the value of the '<em><b>Editor ID</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Editor ID</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Editor ID</em>' attribute.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getDefaultEditorEMFModel_EditorID()
     * @model id="true" transient="true" changeable="false" volatile="true"
     * @generated
     */
    String getEditorID();

    D getModel();

    void setModel(D model);

} // DefaultEditorEMFModel

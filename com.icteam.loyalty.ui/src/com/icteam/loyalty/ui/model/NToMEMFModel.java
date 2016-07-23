/**
 */
package com.icteam.loyalty.ui.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.IContainedFeature;
import com.icteam.loyalty.ui.interfaces.IBaseClassProvider;
import com.icteam.loyalty.ui.interfaces.NToMDirection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>NTo MEMF Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.ui.model.NToMEMFModel#getAllToSrcAction <em>All To Src Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.NToMEMFModel#getToSrcAction <em>To Src Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.NToMEMFModel#getToDestAction <em>To Dest Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.NToMEMFModel#getAllToDestAction <em>All To Dest Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.NToMEMFModel#getSrcList <em>Src List</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.NToMEMFModel#getDestList <em>Dest List</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.NToMEMFModel#getSelectedDestList <em>Selected Dest List</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.NToMEMFModel#getSelectedSrcList <em>Selected Src List</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.ui.model.UIModelPackage#getNToMEMFModel()
 * @model
 * @generated
 */
public interface NToMEMFModel extends EMFModel, IBaseClassProvider, IContainedFeature {
    /**
     * Returns the value of the '<em><b>All To Src Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>All To Src Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>All To Src Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getNToMEMFModel_AllToSrcAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getAllToSrcAction();

    /**
     * Returns the value of the '<em><b>To Src Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To Src Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To Src Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getNToMEMFModel_ToSrcAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getToSrcAction();

    /**
     * Returns the value of the '<em><b>To Dest Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>To Dest Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>To Dest Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getNToMEMFModel_ToDestAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getToDestAction();

    /**
     * Returns the value of the '<em><b>All To Dest Action</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>All To Dest Action</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>All To Dest Action</em>' reference.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getNToMEMFModel_AllToDestAction()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Action getAllToDestAction();

    /**
     * Returns the value of the '<em><b>Src List</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Src List</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Src List</em>' reference list.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getNToMEMFModel_SrcList()
     * @model annotation="http://com.icteam.loyalty/property selectedFeature='selectedSrcList' defaultAction='toDestAction'"
     * @generated
     */
    EList<EObject> getSrcList();

    /**
     * Returns the value of the '<em><b>Dest List</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dest List</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dest List</em>' reference list.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getNToMEMFModel_DestList()
     * @model annotation="http://com.icteam.loyalty/property selectedFeature='selectedDestList' defaultAction='toSrcAction'"
     * @generated
     */
    EList<EObject> getDestList();

    /**
     * Returns the value of the '<em><b>Selected Dest List</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selected Dest List</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selected Dest List</em>' reference list.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getNToMEMFModel_SelectedDestList()
     * @model resolveProxies="false" transient="true"
     * @generated
     */
    EList<EObject> getSelectedDestList();

    /**
     * Returns the value of the '<em><b>Selected Src List</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selected Src List</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selected Src List</em>' reference list.
     * @see com.icteam.loyalty.ui.model.UIModelPackage#getNToMEMFModel_SelectedSrcList()
     * @model resolveProxies="false" transient="true"
     * @generated
     */
    EList<EObject> getSelectedSrcList();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void move(NToMDirection direction);

} // NToMDto

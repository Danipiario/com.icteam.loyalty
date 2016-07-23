/**
 */
package com.icteam.loyalty.model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List EMF Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.ListEMFModel#getList <em>List</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.ListEMFModel#getSelectedModel <em>Selected Model</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.ModelPackage#getListEMFModel()
 * @model
 * @generated
 */
public interface ListEMFModel<D extends EMFModel> extends EMFModel {
    /**
     * Returns the value of the '<em><b>List</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>List</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>List</em>' reference list.
     * @see com.icteam.loyalty.model.ModelPackage#getListEMFModel_List()
     * @model
     * @generated
     */
    EList<D> getList();

    /**
     * Returns the value of the '<em><b>Selected Model</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Selected Model</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Selected Model</em>' attribute.
     * @see #setSelectedModel(EMFModel)
     * @see com.icteam.loyalty.model.ModelPackage#getListEMFModel_SelectedModel()
     * @model
     * @generated
     */
    D getSelectedModel();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.ListEMFModel#getSelectedModel <em>Selected Model</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Selected Model</em>' attribute.
     * @see #getSelectedModel()
     * @generated
     */
    void setSelectedModel(D value);

} // ListEMFModel

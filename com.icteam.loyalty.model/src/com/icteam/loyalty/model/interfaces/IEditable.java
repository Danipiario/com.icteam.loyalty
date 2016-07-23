/**
 */
package com.icteam.loyalty.model.interfaces;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEditable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEditable#isEditable <em>Editable</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEditable#isDirty <em>Dirty</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEditable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IEditable extends EObject {
    /**
     * Returns the value of the '<em><b>Editable</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Editable</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Editable</em>' attribute.
     * @see #setEditable(boolean)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEditable_Editable()
     * @model default="true" transient="true"
     *        annotation="http://com.icteam.loyalty/property showAsColumn='false'"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    boolean isEditable();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IEditable#isEditable <em>Editable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Editable</em>' attribute.
     * @see #isEditable()
     * @generated
     */
    void setEditable(boolean value);

    /**
     * Returns the value of the '<em><b>Dirty</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dirty</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dirty</em>' attribute.
     * @see #setDirty(boolean)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEditable_Dirty()
     * @model default="false" transient="true"
     *        annotation="http://com.icteam.loyalty/property showAsColumn='false'"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    boolean isDirty();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IEditable#isDirty <em>Dirty</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dirty</em>' attribute.
     * @see #isDirty()
     * @generated
     */
    void setDirty(boolean value);

} // IEditable

/**
 */
package com.icteam.loyalty.model.interfaces;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Status#getATTIVO <em>ATTIVO</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Status#getDISATTIVO <em>DISATTIVO</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Status#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getStatus()
 * @model
 * @generated
 */
public interface Status extends IEMFEnhancedEnum<Status> {
    /**
     * Returns the value of the '<em><b>ATTIVO</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>ATTIVO</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>ATTIVO</em>' reference.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getStatus_ATTIVO()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Status getATTIVO();

    /**
     * Returns the value of the '<em><b>DISATTIVO</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>DISATTIVO</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>DISATTIVO</em>' reference.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getStatus_DISATTIVO()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Status getDISATTIVO();

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getStatus_Name()
     * @model id="true" required="true" changeable="false"
     * @generated
     */
    @Override
    String getName();

} // Status

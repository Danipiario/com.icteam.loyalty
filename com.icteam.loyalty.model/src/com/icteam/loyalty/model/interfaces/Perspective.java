/**
 */
package com.icteam.loyalty.model.interfaces;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Perspective</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Perspective#getADMINISTRATION <em>ADMINISTRATION</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Perspective#getCONFIGURATION <em>CONFIGURATION</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Perspective#getId <em>Id</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Perspective#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getPerspective()
 * @model
 * @generated
 */
public interface Perspective extends IEMFEnhancedEnum<Perspective> {

    /**
     * Returns the value of the '<em><b>ADMINISTRATION</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>ADMINISTRATION</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>ADMINISTRATION</em>' reference.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getPerspective_ADMINISTRATION()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Perspective getADMINISTRATION();

    /**
     * Returns the value of the '<em><b>CONFIGURATION</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>CONFIGURATION</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>CONFIGURATION</em>' reference.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getPerspective_CONFIGURATION()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Perspective getCONFIGURATION();

    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getPerspective_Id()
     * @model changeable="false"
     * @generated
     */
    String getId();

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getPerspective_Name()
     * @model id="true" required="true" changeable="false"
     * @generated
     */
    @Override
    String getName();

    Perspective eINSTANCE = ModelInterfacesFactory.eINSTANCE.createPerspective();

} // Perspective

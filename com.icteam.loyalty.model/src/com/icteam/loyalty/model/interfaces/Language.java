/**
 */
package com.icteam.loyalty.model.interfaces;

import java.util.Locale;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Language</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Language#getITALIAN <em>ITALIAN</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Language#getENGLISH <em>ENGLISH</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Language#isDefaultLanguage <em>Default Language</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Language#getLocale <em>Locale</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Language#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getLanguage()
 * @model
 * @generated
 */
public interface Language extends IEMFEnhancedEnum<Language> {
    /**
     * Returns the value of the '<em><b>ITALIAN</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>ITALIAN</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>ITALIAN</em>' reference.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getLanguage_ITALIAN()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Language getITALIAN();

    /**
     * Returns the value of the '<em><b>ENGLISH</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>ENGLISH</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>ENGLISH</em>' reference.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getLanguage_ENGLISH()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Language getENGLISH();

    /**
     * Returns the value of the '<em><b>Default Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Language</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Language</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getLanguage_DefaultLanguage()
     * @model required="true" changeable="false"
     * @generated
     */
    boolean isDefaultLanguage();

    /**
     * Returns the value of the '<em><b>Locale</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Locale</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Locale</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getLanguage_Locale()
     * @model dataType="com.icteam.loyalty.model.interfaces.Locale" required="true" changeable="false"
     * @generated
     */
    Locale getLocale();

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getLanguage_Name()
     * @model id="true" required="true" changeable="false"
     * @generated
     */
    @Override
    String getName();

} // Language

/**
 */
package com.icteam.loyalty.model.template;

import com.icteam.loyalty.model.interfaces.DistinctEMF;
import com.icteam.loyalty.model.interfaces.Language;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dictionary EMF Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.template.DictionaryEMFTemplate#getKey <em>Key</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.DictionaryEMFTemplate#getValue <em>Value</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.DictionaryEMFTemplate#getLanguage <em>Language</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.template.ModelTemplatePackage#getDictionaryEMFTemplate()
 * @model annotation="http://com.icteam.loyalty/property dbModel='com.icteam.loyalty.model.DictionaryEMF'"
 * @generated
 */
public interface DictionaryEMFTemplate extends AbstractEMFTemplate<DistinctEMF> {
    /**
     * Returns the value of the '<em><b>Key</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Key</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Key</em>' attribute.
     * @see #setKey(String)
     * @see com.icteam.loyalty.model.template.ModelTemplatePackage#getDictionaryEMFTemplate_Key()
     * @model id="true"
     * @generated
     */
    String getKey();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.template.DictionaryEMFTemplate#getKey <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Key</em>' attribute.
     * @see #getKey()
     * @generated
     */
    void setKey(String value);

    /**
     * Returns the value of the '<em><b>Language</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Language</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Language</em>' reference.
     * @see #setLanguage(Language)
     * @see com.icteam.loyalty.model.template.ModelTemplatePackage#getDictionaryEMFTemplate_Language()
     * @model resolveProxies="false"
     * @generated
     */
    Language getLanguage();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.template.DictionaryEMFTemplate#getLanguage <em>Language</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Language</em>' reference.
     * @see #getLanguage()
     * @generated
     */
    void setLanguage(Language value);

    /**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(String)
     * @see com.icteam.loyalty.model.template.ModelTemplatePackage#getDictionaryEMFTemplate_Value()
     * @model annotation="http://com.icteam.loyalty/where clause='LIKE_IGNORE_CASE'"
     * @generated
     */
    String getValue();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.template.DictionaryEMFTemplate#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
    void setValue(String value);

} // DictionaryEMFTemplate

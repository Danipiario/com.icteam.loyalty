/**
 */
package com.icteam.loyalty.model.template.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.icteam.loyalty.model.interfaces.DistinctEMF;
import com.icteam.loyalty.model.interfaces.Language;
import com.icteam.loyalty.model.template.DictionaryEMFTemplate;
import com.icteam.loyalty.model.template.ModelTemplatePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dictionary EMF Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.template.impl.DictionaryEMFTemplateImpl#getKey <em>Key</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.DictionaryEMFTemplateImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.DictionaryEMFTemplateImpl#getLanguage <em>Language</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DictionaryEMFTemplateImpl extends AbstractEMFTemplateImpl<DistinctEMF>implements DictionaryEMFTemplate {
    /**
     * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected static final String KEY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getKey()
     * @generated
     * @ordered
     */
    protected String key = KEY_EDEFAULT;

    /**
     * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected static final String VALUE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected String value = VALUE_EDEFAULT;

    /**
     * The cached value of the '{@link #getLanguage() <em>Language</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLanguage()
     * @generated
     * @ordered
     */
    protected Language language;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DictionaryEMFTemplateImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelTemplatePackage.Literals.DICTIONARY_EMF_TEMPLATE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getKey() {
        return key;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setKey(String newKey) {
        String oldKey = key;
        key = newKey;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__KEY, oldKey, key));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Language getLanguage() {
        return language;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setLanguage(Language newLanguage) {
        Language oldLanguage = language;
        language = newLanguage;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__LANGUAGE, oldLanguage, language));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setValue(String newValue) {
        String oldValue = value;
        value = newValue;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__VALUE, oldValue, value));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__KEY:
                return getKey();
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__VALUE:
                return getValue();
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__LANGUAGE:
                return getLanguage();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__KEY:
                setKey((String) newValue);
                return;
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__VALUE:
                setValue((String) newValue);
                return;
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__LANGUAGE:
                setLanguage((Language) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__KEY:
                setKey(KEY_EDEFAULT);
                return;
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__VALUE:
                setValue(VALUE_EDEFAULT);
                return;
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__LANGUAGE:
                setLanguage((Language) null);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__KEY:
                return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__VALUE:
                return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__LANGUAGE:
                return language != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (key: ");
        result.append(key);
        result.append(", value: ");
        result.append(value);
        result.append(')');
        return result.toString();
    }

} //DictionaryEMFTemplateImpl

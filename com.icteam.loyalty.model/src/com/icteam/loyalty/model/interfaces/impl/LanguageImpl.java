/**
 */
package com.icteam.loyalty.model.interfaces.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.icteam.loyalty.model.interfaces.Language;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.util.ModelUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Language</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.LanguageImpl#getITALIAN <em>ITALIAN</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.LanguageImpl#getENGLISH <em>ENGLISH</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.LanguageImpl#isDefaultLanguage <em>Default Language</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.LanguageImpl#getLocale <em>Locale</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.LanguageImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LanguageImpl extends MinimalEObjectImpl.Container implements Language {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * The default value of the '{@link #isDefaultLanguage() <em>Default Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDefaultLanguage()
     * @generated
     * @ordered
     */
    protected static final boolean DEFAULT_LANGUAGE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDefaultLanguage() <em>Default Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDefaultLanguage()
     * @generated
     * @ordered
     */
    protected boolean defaultLanguage = DEFAULT_LANGUAGE_EDEFAULT;

    /**
     * The default value of the '{@link #getLocale() <em>Locale</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocale()
     * @generated
     * @ordered
     */
    protected static final Locale LOCALE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getLocale() <em>Locale</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocale()
     * @generated
     * @ordered
     */
    protected Locale locale = LOCALE_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LanguageImpl() {
        super();
    }

    protected LanguageImpl(String name, Locale locale, boolean defaultLanguage) {
        this.name = name;
        this.locale = locale;
        this.defaultLanguage = defaultLanguage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelInterfacesPackage.Literals.LANGUAGE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isDefaultLanguage() {
        return defaultLanguage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Locale getLocale() {
        return locale;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int compareTo(final Language o) {
        return getName().compareTo(o.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean equals(final Object obj) {
        return ModelUtil.equals(this, obj);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Language getITALIAN() {
        return ModelUtil.valueOf(Language.class, ModelInterfacesPackage.Literals.LANGUAGE__ITALIAN.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Language getENGLISH() {
        return ModelUtil.valueOf(Language.class, ModelInterfacesPackage.Literals.LANGUAGE__ENGLISH.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelInterfacesPackage.LANGUAGE__ITALIAN:
                return getITALIAN();
            case ModelInterfacesPackage.LANGUAGE__ENGLISH:
                return getENGLISH();
            case ModelInterfacesPackage.LANGUAGE__DEFAULT_LANGUAGE:
                return isDefaultLanguage();
            case ModelInterfacesPackage.LANGUAGE__LOCALE:
                return getLocale();
            case ModelInterfacesPackage.LANGUAGE__NAME:
                return getName();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ModelInterfacesPackage.LANGUAGE__ITALIAN:
                return getITALIAN() != null;
            case ModelInterfacesPackage.LANGUAGE__ENGLISH:
                return getENGLISH() != null;
            case ModelInterfacesPackage.LANGUAGE__DEFAULT_LANGUAGE:
                return defaultLanguage != DEFAULT_LANGUAGE_EDEFAULT;
            case ModelInterfacesPackage.LANGUAGE__LOCALE:
                return LOCALE_EDEFAULT == null ? locale != null : !LOCALE_EDEFAULT.equals(locale);
            case ModelInterfacesPackage.LANGUAGE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object eInvoke(int operationID, EList< ? > arguments) throws InvocationTargetException {
        switch (operationID) {
            case ModelInterfacesPackage.LANGUAGE___COMPARE_TO__IEMFENHANCEDENUM:
                return compareTo((Language) arguments.get(0));
            case ModelInterfacesPackage.LANGUAGE___EQUALS__OBJECT:
                return equals(arguments.get(0));
        }
        return super.eInvoke(operationID, arguments);
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
        result.append(" (defaultLanguage: ");
        result.append(defaultLanguage);
        result.append(", locale: ");
        result.append(locale);
        result.append(", name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

    /**
     * Ritorna ELanguage dal Locale
     *
     * @param locale
     *            Locale
     * @return ELanguage
     */
    public static Language getLanguage(Locale locale) {
        for (Language language : ModelUtil.values(Language.class)) {
            if (language.getLocale().equals(locale)) {
                return language;
            }
        }

        return null;
    }

    /**
     * @return il valore della variabile defaultLanguage di tipo PsiType:ELanguage.
     */
    public static Language getDefaultLanguage() {
        for (Language language : ModelUtil.values(Language.class)) {
            if (language.isDefaultLanguage()) {
                return language;
            }
        }

        return null;
    }

} //LanguageImpl

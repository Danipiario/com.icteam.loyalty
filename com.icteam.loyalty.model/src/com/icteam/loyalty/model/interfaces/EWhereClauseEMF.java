/**
 */
package com.icteam.loyalty.model.interfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>EWhere Clause EMF</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getEWhereClauseEMF()
 * @model
 * @generated
 */
public enum EWhereClauseEMF implements Enumerator {
    /**
     * The '<em><b>EQUAL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #EQUAL_VALUE
     * @generated
     * @ordered
     */
    EQUAL(0, "EQUAL", ""),

    /**
     * The '<em><b>LIKE IGNORE CASE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #LIKE_IGNORE_CASE_VALUE
     * @generated
     * @ordered
     */
    LIKE_IGNORE_CASE(1, "LIKE_IGNORE_CASE", "LIKE_IGNORE_CASE"),

    /**
     * The '<em><b>GREATER EQUAL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #GREATER_EQUAL_VALUE
     * @generated
     * @ordered
     */
    GREATER_EQUAL(2, "GREATER_EQUAL", "GREATER_EQUAL"),

    /**
     * The '<em><b>I18N</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #I18N_VALUE
     * @generated
     * @ordered
     */
    I18N(3, "I18N", "I18N"), /**
                             * The '<em><b>NONE</b></em>' literal object.
                             * <!-- begin-user-doc -->
                             * <!-- end-user-doc -->
                             * @see #NONE_VALUE
                             * @generated
                             * @ordered
                             */
    NONE(4, "NONE", "NONE"), /**
                             * The '<em><b>ENUM</b></em>' literal object.
                             * <!-- begin-user-doc -->
                             * <!-- end-user-doc -->
                             * @see #ENUM_VALUE
                             * @generated
                             * @ordered
                             */
    ENUM(5, "ENUM", "ENUM");

    /**
     * The '<em><b>EQUAL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>EQUAL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #EQUAL
     * @model literal=""
     * @generated
     * @ordered
     */
    public static final int EQUAL_VALUE = 0;

    /**
     * The '<em><b>LIKE IGNORE CASE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>LIKE IGNORE CASE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #LIKE_IGNORE_CASE
     * @model
     * @generated
     * @ordered
     */
    public static final int LIKE_IGNORE_CASE_VALUE = 1;

    /**
     * The '<em><b>GREATER EQUAL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>GREATER EQUAL</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #GREATER_EQUAL
     * @model
     * @generated
     * @ordered
     */
    public static final int GREATER_EQUAL_VALUE = 2;

    /**
     * The '<em><b>I18N</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>I18N</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #I18N
     * @model
     * @generated
     * @ordered
     */
    public static final int I18N_VALUE = 3;

    /**
     * The '<em><b>NONE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #NONE
     * @model
     * @generated
     * @ordered
     */
    public static final int NONE_VALUE = 4;

    /**
     * The '<em><b>ENUM</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ENUM</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ENUM
     * @model
     * @generated
     * @ordered
     */
    public static final int ENUM_VALUE = 5;

    /**
     * An array of all the '<em><b>EWhere Clause EMF</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final EWhereClauseEMF[] VALUES_ARRAY = new EWhereClauseEMF[] { EQUAL, LIKE_IGNORE_CASE, GREATER_EQUAL, I18N, NONE, ENUM, };

    /**
     * A public read-only list of all the '<em><b>EWhere Clause EMF</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<EWhereClauseEMF> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>EWhere Clause EMF</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static EWhereClauseEMF get(String literal) {
        for (EWhereClauseEMF result : VALUES_ARRAY) {
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>EWhere Clause EMF</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static EWhereClauseEMF getByName(String name) {
        for (EWhereClauseEMF result : VALUES_ARRAY) {
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>EWhere Clause EMF</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static EWhereClauseEMF get(int value) {
        switch (value) {
            case EQUAL_VALUE:
                return EQUAL;
            case LIKE_IGNORE_CASE_VALUE:
                return LIKE_IGNORE_CASE;
            case GREATER_EQUAL_VALUE:
                return GREATER_EQUAL;
            case I18N_VALUE:
                return I18N;
            case NONE_VALUE:
                return NONE;
            case ENUM_VALUE:
                return ENUM;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EWhereClauseEMF(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getValue() {
        return value;
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
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }

} //EWhereClauseEMF

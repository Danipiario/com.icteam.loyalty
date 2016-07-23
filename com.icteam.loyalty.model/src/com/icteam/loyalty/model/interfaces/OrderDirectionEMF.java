/**
 */
package com.icteam.loyalty.model.interfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Order Direction EMF</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getOrderDirectionEMF()
 * @model
 * @generated
 */
public enum OrderDirectionEMF implements Enumerator {
    /**
     * The '<em><b>NONE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #NONE_VALUE
     * @generated
     * @ordered
     */
    NONE(0, "NONE", "NONE"), /**
                             * The '<em><b>ASC</b></em>' literal object.
                             * <!-- begin-user-doc -->
                             * <!-- end-user-doc -->
                             * @see #ASC_VALUE
                             * @generated
                             * @ordered
                             */
    ASC(1, "ASC", "ASC"), /**
                          * The '<em><b>DESC</b></em>' literal object.
                          * <!-- begin-user-doc -->
                          * <!-- end-user-doc -->
                          * @see #DESC_VALUE
                          * @generated
                          * @ordered
                          */
    DESC(2, "DESC", "DESC");

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
    public static final int NONE_VALUE = 0;

    /**
     * The '<em><b>ASC</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ASC</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ASC
     * @model
     * @generated
     * @ordered
     */
    public static final int ASC_VALUE = 1;

    /**
     * The '<em><b>DESC</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>DESC</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #DESC
     * @model
     * @generated
     * @ordered
     */
    public static final int DESC_VALUE = 2;

    /**
     * An array of all the '<em><b>Order Direction EMF</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final OrderDirectionEMF[] VALUES_ARRAY = new OrderDirectionEMF[] { NONE, ASC, DESC, };

    /**
     * A public read-only list of all the '<em><b>Order Direction EMF</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<OrderDirectionEMF> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Order Direction EMF</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static OrderDirectionEMF get(String literal) {
        for (OrderDirectionEMF result : VALUES_ARRAY) {
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Order Direction EMF</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static OrderDirectionEMF getByName(String name) {
        for (OrderDirectionEMF result : VALUES_ARRAY) {
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Order Direction EMF</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static OrderDirectionEMF get(int value) {
        switch (value) {
            case NONE_VALUE:
                return NONE;
            case ASC_VALUE:
                return ASC;
            case DESC_VALUE:
                return DESC;
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
    private OrderDirectionEMF(int value, String name, String literal) {
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

} //OrderDirectionEMF

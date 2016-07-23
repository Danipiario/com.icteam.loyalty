/**
 */
package com.icteam.loyalty.ui.interfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>NTo MDirection</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.ui.interfaces.UIInterfacesPackage#getNToMDirection()
 * @model
 * @generated
 */
public enum NToMDirection implements Enumerator {
    /**
     * The '<em><b>ALL TO SRC</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ALL_TO_SRC_VALUE
     * @generated
     * @ordered
     */
    ALL_TO_SRC(0, "ALL_TO_SRC", "ALL_TO_SRC"),

    /**
     * The '<em><b>TO SRC</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TO_SRC_VALUE
     * @generated
     * @ordered
     */
    TO_SRC(1, "TO_SRC", "TO_SRC"),

    /**
     * The '<em><b>ALL TO DEST</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #ALL_TO_DEST_VALUE
     * @generated
     * @ordered
     */
    ALL_TO_DEST(2, "ALL_TO_DEST", "ALL_TO_DEST"),

    /**
     * The '<em><b>TO DEST</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #TO_DEST_VALUE
     * @generated
     * @ordered
     */
    TO_DEST(3, "TO_DEST", "TO_DEST");

    /**
     * The '<em><b>ALL TO SRC</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ALL TO SRC</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ALL_TO_SRC
     * @model
     * @generated
     * @ordered
     */
    public static final int ALL_TO_SRC_VALUE = 0;

    /**
     * The '<em><b>TO SRC</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>TO SRC</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TO_SRC
     * @model
     * @generated
     * @ordered
     */
    public static final int TO_SRC_VALUE = 1;

    /**
     * The '<em><b>ALL TO DEST</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>ALL TO DEST</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #ALL_TO_DEST
     * @model
     * @generated
     * @ordered
     */
    public static final int ALL_TO_DEST_VALUE = 2;

    /**
     * The '<em><b>TO DEST</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of '<em><b>TO DEST</b></em>' literal object isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @see #TO_DEST
     * @model
     * @generated
     * @ordered
     */
    public static final int TO_DEST_VALUE = 3;

    /**
     * An array of all the '<em><b>NTo MDirection</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final NToMDirection[] VALUES_ARRAY = new NToMDirection[] { ALL_TO_SRC, TO_SRC, ALL_TO_DEST, TO_DEST, };

    /**
     * A public read-only list of all the '<em><b>NTo MDirection</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final List<NToMDirection> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>NTo MDirection</b></em>' literal with the specified literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static NToMDirection get(String literal) {
        for (NToMDirection result : VALUES_ARRAY) {
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>NTo MDirection</b></em>' literal with the specified name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static NToMDirection getByName(String name) {
        for (NToMDirection result : VALUES_ARRAY) {
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>NTo MDirection</b></em>' literal with the specified integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static NToMDirection get(int value) {
        switch (value) {
            case ALL_TO_SRC_VALUE:
                return ALL_TO_SRC;
            case TO_SRC_VALUE:
                return TO_SRC;
            case ALL_TO_DEST_VALUE:
                return ALL_TO_DEST;
            case TO_DEST_VALUE:
                return TO_DEST;
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
    private NToMDirection(int value, String name, String literal) {
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

} //NToMDirection

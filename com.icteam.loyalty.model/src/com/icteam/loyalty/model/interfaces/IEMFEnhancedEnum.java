/**
 */
package com.icteam.loyalty.model.interfaces;

import java.io.Serializable;

import java.lang.Cloneable;
import java.lang.Comparable;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEMF Enhanced Enum</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFEnhancedEnum()
 * @model interface="true" abstract="true" superTypes="com.icteam.loyalty.model.interfaces.Comparable<E> com.icteam.loyalty.model.interfaces.Serializable com.icteam.loyalty.model.interfaces.Cloneable"
 * @generated
 */
public interface IEMFEnhancedEnum<E extends IEMFEnhancedEnum<E>> extends EObject, Comparable<E>, Serializable, Cloneable {
    /**
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
    String getName();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return ModelUtil.equals(this, obj);'"
     * @generated
     */
    @Override
    boolean equals(Object obj);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return getName().compareTo(o.getName());'"
     * @generated
     */
    @Override
    int compareTo(E o);

} // IEMFEnhancedEnum

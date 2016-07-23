/**
 */
package com.icteam.loyalty.model;

import com.icteam.loyalty.model.interfaces.IEMFModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EMF Model</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see com.icteam.loyalty.model.ModelPackage#getEMFModel()
 * @model abstract="true"
 * @generated
 */
public interface EMFModel extends IEMFModel {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return (String) org.apache.commons.lang.ObjectUtils.defaultIfNull(ModelUtil.getID(this), \"\");'"
     * @generated
     */
    String getModelName();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return true;'"
     * @generated
     */
    boolean hasEditor();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getObjectClassName().toLowerCase();'"
     * @generated
     */
    String getPermissionObject();

} // EMFModel

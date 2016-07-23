/**
 */
package com.icteam.loyalty.model.interfaces;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Permission</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Permission#getADMINISTRATION_PERSPECTIVE_VIEW <em>ADMINISTRATION PERSPECTIVE VIEW</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Permission#getCONFIGURATION_PERSPECTIVE_VIEW <em>CONFIGURATION PERSPECTIVE VIEW</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Permission#getObject <em>Object</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Permission#getAction <em>Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Permission#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getPermission()
 * @model
 * @generated
 */
public interface Permission extends IEMFEnhancedEnum<Permission> {

    /**
     * Returns the value of the '<em><b>ADMINISTRATION PERSPECTIVE VIEW</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>ADMINISTRATION PERSPECTIVE VIEW</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>ADMINISTRATION PERSPECTIVE VIEW</em>' reference.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getPermission_ADMINISTRATION_PERSPECTIVE_VIEW()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Permission getADMINISTRATION_PERSPECTIVE_VIEW();

    /**
     * Returns the value of the '<em><b>CONFIGURATION PERSPECTIVE VIEW</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>CONFIGURATION PERSPECTIVE VIEW</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>CONFIGURATION PERSPECTIVE VIEW</em>' reference.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getPermission_CONFIGURATION_PERSPECTIVE_VIEW()
     * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
     * @generated
     */
    Permission getCONFIGURATION_PERSPECTIVE_VIEW();

    String OBJECT_ADMINISTRATION_PERSPECTIVE = "administration_perspective";
    String OBJECT_CONFIGURATION_PERSPECTIVE = "configuration_perspective";

    /**
     * Returns the value of the '<em><b>Object</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Object</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Object</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getPermission_Object()
     * @model required="true" changeable="false"
     *        annotation="http://com.icteam.loyalty/property showAsColumn='false'"
     * @generated
     */
    String getObject();

    /**
     * Returns the value of the '<em><b>Action</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Action</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Action</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getPermission_Action()
     * @model default="" required="true" changeable="false"
     *        annotation="http://com.icteam.loyalty/property showAsColumn='false'"
     * @generated
     */
    String getAction();

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getPermission_Name()
     * @model id="true" required="true" changeable="false"
     * @generated
     */
    @Override
    String getName();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return IConstants.STAR.equals(getAction());'"
     * @generated
     */
    boolean isStarPermission();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getObject() + IConstants.UNDERSCORE + getAction();'"
     * @generated
     */
    String getPermission();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return new BasicEList<>(CollectionUtils.select(ModelUtil.values(Permission.class), new BeanPropertyValueEqualsPredicate(\"object\", getObject())));'"
     * @generated
     */
    EList<Permission> getPermissions();

} // Permission

/**
 */
package com.icteam.loyalty.model.interfaces.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.collections.CollectionUtils;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.icteam.loyalty.api.interfaces.IConstants;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.interfaces.Permission;
import com.icteam.loyalty.model.util.ModelUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Permission</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.PermissionImpl#getADMINISTRATION_PERSPECTIVE_VIEW <em>ADMINISTRATION PERSPECTIVE VIEW</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.PermissionImpl#getCONFIGURATION_PERSPECTIVE_VIEW <em>CONFIGURATION PERSPECTIVE VIEW</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.PermissionImpl#getObject <em>Object</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.PermissionImpl#getAction <em>Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.PermissionImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PermissionImpl extends MinimalEObjectImpl.Container implements Permission {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * The default value of the '{@link #getObject() <em>Object</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getObject()
     * @generated
     * @ordered
     */
    protected static final String OBJECT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getObject() <em>Object</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getObject()
     * @generated
     * @ordered
     */
    protected String object = OBJECT_EDEFAULT;

    /**
     * The default value of the '{@link #getAction() <em>Action</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAction()
     * @generated
     * @ordered
     */
    protected static final String ACTION_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getAction() <em>Action</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAction()
     * @generated
     * @ordered
     */
    protected String action = ACTION_EDEFAULT;

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
    protected PermissionImpl() {
        super();
    }

    protected PermissionImpl(String name, String object, String action) {
        this.name = name;
        this.object = object;
        this.action = action;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelInterfacesPackage.Literals.PERMISSION;
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
    public String getObject() {
        return object;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getAction() {
        return action;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isStarPermission() {
        return IConstants.STAR.equals(getAction());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getPermission() {
        return getObject() + IConstants.UNDERSCORE + getAction();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Permission> getPermissions() {
        return new BasicEList<>(CollectionUtils.select(ModelUtil.values(Permission.class), new BeanPropertyValueEqualsPredicate("object", getObject())));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public int compareTo(final Permission o) {
        if (isStarPermission() && !o.isStarPermission()) {
            return -1;
        }

        if (!isStarPermission() && o.isStarPermission()) {
            return 1;
        }

        int c = getPermission().compareTo(o.getPermission());

        if (c == 0) {
            c = this.getName().compareTo(o.getName());
        }

        return c;
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
    public Permission getADMINISTRATION_PERSPECTIVE_VIEW() {
        return ModelUtil.valueOf(Permission.class, ModelInterfacesPackage.Literals.PERMISSION__ADMINISTRATION_PERSPECTIVE_VIEW.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Permission getCONFIGURATION_PERSPECTIVE_VIEW() {
        return ModelUtil.valueOf(Permission.class, ModelInterfacesPackage.Literals.PERMISSION__CONFIGURATION_PERSPECTIVE_VIEW.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelInterfacesPackage.PERMISSION__ADMINISTRATION_PERSPECTIVE_VIEW:
                return getADMINISTRATION_PERSPECTIVE_VIEW();
            case ModelInterfacesPackage.PERMISSION__CONFIGURATION_PERSPECTIVE_VIEW:
                return getCONFIGURATION_PERSPECTIVE_VIEW();
            case ModelInterfacesPackage.PERMISSION__OBJECT:
                return getObject();
            case ModelInterfacesPackage.PERMISSION__ACTION:
                return getAction();
            case ModelInterfacesPackage.PERMISSION__NAME:
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
            case ModelInterfacesPackage.PERMISSION__ADMINISTRATION_PERSPECTIVE_VIEW:
                return getADMINISTRATION_PERSPECTIVE_VIEW() != null;
            case ModelInterfacesPackage.PERMISSION__CONFIGURATION_PERSPECTIVE_VIEW:
                return getCONFIGURATION_PERSPECTIVE_VIEW() != null;
            case ModelInterfacesPackage.PERMISSION__OBJECT:
                return OBJECT_EDEFAULT == null ? object != null : !OBJECT_EDEFAULT.equals(object);
            case ModelInterfacesPackage.PERMISSION__ACTION:
                return ACTION_EDEFAULT == null ? action != null : !ACTION_EDEFAULT.equals(action);
            case ModelInterfacesPackage.PERMISSION__NAME:
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
            case ModelInterfacesPackage.PERMISSION___IS_STAR_PERMISSION:
                return isStarPermission();
            case ModelInterfacesPackage.PERMISSION___GET_PERMISSION:
                return getPermission();
            case ModelInterfacesPackage.PERMISSION___GET_PERMISSIONS:
                return getPermissions();
            case ModelInterfacesPackage.PERMISSION___COMPARE_TO__IEMFENHANCEDENUM:
                return compareTo((Permission) arguments.get(0));
            case ModelInterfacesPackage.PERMISSION___EQUALS__OBJECT:
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
        result.append(" (object: ");
        result.append(object);
        result.append(", action: ");
        result.append(action);
        result.append(", name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //PermissionImpl

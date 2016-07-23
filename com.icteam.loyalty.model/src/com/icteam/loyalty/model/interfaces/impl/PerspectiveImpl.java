/**
 */
package com.icteam.loyalty.model.interfaces.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.interfaces.Perspective;
import com.icteam.loyalty.model.util.ModelUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Perspective</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.PerspectiveImpl#getADMINISTRATION <em>ADMINISTRATION</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.PerspectiveImpl#getCONFIGURATION <em>CONFIGURATION</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.PerspectiveImpl#getId <em>Id</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.PerspectiveImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PerspectiveImpl extends MinimalEObjectImpl.Container implements Perspective {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

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
    protected PerspectiveImpl() {
        super();
    }

    protected PerspectiveImpl(String name, String id) {
        this.name = name;
        this.id = id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelInterfacesPackage.Literals.PERSPECTIVE;
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
    public String getId() {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int compareTo(final Perspective o) {
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
    public Perspective getADMINISTRATION() {
        return ModelUtil.valueOf(Perspective.class, ModelInterfacesPackage.Literals.PERSPECTIVE__ADMINISTRATION.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Perspective getCONFIGURATION() {
        return ModelUtil.valueOf(Perspective.class, ModelInterfacesPackage.Literals.PERSPECTIVE__CONFIGURATION.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelInterfacesPackage.PERSPECTIVE__ADMINISTRATION:
                return getADMINISTRATION();
            case ModelInterfacesPackage.PERSPECTIVE__CONFIGURATION:
                return getCONFIGURATION();
            case ModelInterfacesPackage.PERSPECTIVE__ID:
                return getId();
            case ModelInterfacesPackage.PERSPECTIVE__NAME:
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
            case ModelInterfacesPackage.PERSPECTIVE__ADMINISTRATION:
                return getADMINISTRATION() != null;
            case ModelInterfacesPackage.PERSPECTIVE__CONFIGURATION:
                return getCONFIGURATION() != null;
            case ModelInterfacesPackage.PERSPECTIVE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
            case ModelInterfacesPackage.PERSPECTIVE__NAME:
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
            case ModelInterfacesPackage.PERSPECTIVE___COMPARE_TO__IEMFENHANCEDENUM:
                return compareTo((Perspective) arguments.get(0));
            case ModelInterfacesPackage.PERSPECTIVE___EQUALS__OBJECT:
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
        result.append(" (id: ");
        result.append(id);
        result.append(", name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //PerspectiveImpl

/**
 */
package com.icteam.loyalty.model.interfaces.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import com.icteam.loyalty.api.Api;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.interfaces.StatusReason;
import com.icteam.loyalty.model.util.ModelUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Status Reason</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getOK <em>OK</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getERROR <em>ERROR</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getOBJECT_UNKNOWN <em>OBJECT UNKNOWN</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getMAX_LENGTH_IN_IN_CLAUSE_REACHED <em>MAX LENGTH IN IN CLAUSE REACHED</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getREFERENCED_OBJECT_FOUND <em>REFERENCED OBJECT FOUND</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getCUSTOM_MESSAGE_ADD_ERROR <em>CUSTOM MESSAGE ADD ERROR</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getDELEGATED_SERVICE_NOT_FOUND <em>DELEGATED SERVICE NOT FOUND</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getMIN_CHARACTER_SEARCH_LENGTH <em>MIN CHARACTER SEARCH LENGTH</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getCRON_EXPRESSION_INVALID <em>CRON EXPRESSION INVALID</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getSERVICE_NOT_FOUND <em>SERVICE NOT FOUND</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getCode <em>Code</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getPluginId <em>Plugin Id</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.StatusReasonImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StatusReasonImpl extends MinimalEObjectImpl.Container implements StatusReason {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCode()
     * @generated
     * @ordered
     */
    protected static final int CODE_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCode()
     * @generated
     * @ordered
     */
    protected int code = CODE_EDEFAULT;

    /**
     * The default value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPluginId()
     * @generated
     * @ordered
     */
    protected static final String PLUGIN_ID_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getPluginId() <em>Plugin Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPluginId()
     * @generated
     * @ordered
     */
    protected String pluginId = PLUGIN_ID_EDEFAULT;

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
    protected StatusReasonImpl() {
        super();
    }

    protected StatusReasonImpl(String name, int code) {
        this(name, Api.ID, code);
    }

    protected StatusReasonImpl(String name, String pluginId, int code) {
        this.name = name;
        this.pluginId = pluginId;
        this.code = code;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelInterfacesPackage.Literals.STATUS_REASON;
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
    public int getCode() {
        return code;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getPluginId() {
        return pluginId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int compareTo(final StatusReason o) {
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
    public StatusReason getOK() {
        return ModelUtil.valueOf(StatusReason.class, ModelInterfacesPackage.Literals.STATUS_REASON__OK.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public StatusReason getERROR() {
        return ModelUtil.valueOf(StatusReason.class, ModelInterfacesPackage.Literals.STATUS_REASON__ERROR.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public StatusReason getOBJECT_UNKNOWN() {
        return ModelUtil.valueOf(StatusReason.class, ModelInterfacesPackage.Literals.STATUS_REASON__OBJECT_UNKNOWN.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public StatusReason getMAX_LENGTH_IN_IN_CLAUSE_REACHED() {
        return ModelUtil.valueOf(StatusReason.class, ModelInterfacesPackage.Literals.STATUS_REASON__MAX_LENGTH_IN_IN_CLAUSE_REACHED.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public StatusReason getREFERENCED_OBJECT_FOUND() {
        return ModelUtil.valueOf(StatusReason.class, ModelInterfacesPackage.Literals.STATUS_REASON__REFERENCED_OBJECT_FOUND.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public StatusReason getCUSTOM_MESSAGE_ADD_ERROR() {
        return ModelUtil.valueOf(StatusReason.class, ModelInterfacesPackage.Literals.STATUS_REASON__CUSTOM_MESSAGE_ADD_ERROR.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public StatusReason getDELEGATED_SERVICE_NOT_FOUND() {
        return ModelUtil.valueOf(StatusReason.class, ModelInterfacesPackage.Literals.STATUS_REASON__DELEGATED_SERVICE_NOT_FOUND.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public StatusReason getMIN_CHARACTER_SEARCH_LENGTH() {
        return ModelUtil.valueOf(StatusReason.class, ModelInterfacesPackage.Literals.STATUS_REASON__MIN_CHARACTER_SEARCH_LENGTH.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public StatusReason getCRON_EXPRESSION_INVALID() {
        return ModelUtil.valueOf(StatusReason.class, ModelInterfacesPackage.Literals.STATUS_REASON__CRON_EXPRESSION_INVALID.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public StatusReason getSERVICE_NOT_FOUND() {
        return ModelUtil.valueOf(StatusReason.class, ModelInterfacesPackage.Literals.STATUS_REASON__SERVICE_NOT_FOUND.getName());

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelInterfacesPackage.STATUS_REASON__OK:
                return getOK();
            case ModelInterfacesPackage.STATUS_REASON__ERROR:
                return getERROR();
            case ModelInterfacesPackage.STATUS_REASON__OBJECT_UNKNOWN:
                return getOBJECT_UNKNOWN();
            case ModelInterfacesPackage.STATUS_REASON__MAX_LENGTH_IN_IN_CLAUSE_REACHED:
                return getMAX_LENGTH_IN_IN_CLAUSE_REACHED();
            case ModelInterfacesPackage.STATUS_REASON__REFERENCED_OBJECT_FOUND:
                return getREFERENCED_OBJECT_FOUND();
            case ModelInterfacesPackage.STATUS_REASON__CUSTOM_MESSAGE_ADD_ERROR:
                return getCUSTOM_MESSAGE_ADD_ERROR();
            case ModelInterfacesPackage.STATUS_REASON__DELEGATED_SERVICE_NOT_FOUND:
                return getDELEGATED_SERVICE_NOT_FOUND();
            case ModelInterfacesPackage.STATUS_REASON__MIN_CHARACTER_SEARCH_LENGTH:
                return getMIN_CHARACTER_SEARCH_LENGTH();
            case ModelInterfacesPackage.STATUS_REASON__CRON_EXPRESSION_INVALID:
                return getCRON_EXPRESSION_INVALID();
            case ModelInterfacesPackage.STATUS_REASON__SERVICE_NOT_FOUND:
                return getSERVICE_NOT_FOUND();
            case ModelInterfacesPackage.STATUS_REASON__CODE:
                return getCode();
            case ModelInterfacesPackage.STATUS_REASON__PLUGIN_ID:
                return getPluginId();
            case ModelInterfacesPackage.STATUS_REASON__NAME:
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
            case ModelInterfacesPackage.STATUS_REASON__OK:
                return getOK() != null;
            case ModelInterfacesPackage.STATUS_REASON__ERROR:
                return getERROR() != null;
            case ModelInterfacesPackage.STATUS_REASON__OBJECT_UNKNOWN:
                return getOBJECT_UNKNOWN() != null;
            case ModelInterfacesPackage.STATUS_REASON__MAX_LENGTH_IN_IN_CLAUSE_REACHED:
                return getMAX_LENGTH_IN_IN_CLAUSE_REACHED() != null;
            case ModelInterfacesPackage.STATUS_REASON__REFERENCED_OBJECT_FOUND:
                return getREFERENCED_OBJECT_FOUND() != null;
            case ModelInterfacesPackage.STATUS_REASON__CUSTOM_MESSAGE_ADD_ERROR:
                return getCUSTOM_MESSAGE_ADD_ERROR() != null;
            case ModelInterfacesPackage.STATUS_REASON__DELEGATED_SERVICE_NOT_FOUND:
                return getDELEGATED_SERVICE_NOT_FOUND() != null;
            case ModelInterfacesPackage.STATUS_REASON__MIN_CHARACTER_SEARCH_LENGTH:
                return getMIN_CHARACTER_SEARCH_LENGTH() != null;
            case ModelInterfacesPackage.STATUS_REASON__CRON_EXPRESSION_INVALID:
                return getCRON_EXPRESSION_INVALID() != null;
            case ModelInterfacesPackage.STATUS_REASON__SERVICE_NOT_FOUND:
                return getSERVICE_NOT_FOUND() != null;
            case ModelInterfacesPackage.STATUS_REASON__CODE:
                return code != CODE_EDEFAULT;
            case ModelInterfacesPackage.STATUS_REASON__PLUGIN_ID:
                return PLUGIN_ID_EDEFAULT == null ? pluginId != null : !PLUGIN_ID_EDEFAULT.equals(pluginId);
            case ModelInterfacesPackage.STATUS_REASON__NAME:
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
            case ModelInterfacesPackage.STATUS_REASON___COMPARE_TO__IEMFENHANCEDENUM:
                return compareTo((StatusReason) arguments.get(0));
            case ModelInterfacesPackage.STATUS_REASON___EQUALS__OBJECT:
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
        result.append(" (code: ");
        result.append(code);
        result.append(", pluginId: ");
        result.append(pluginId);
        result.append(", name: ");
        result.append(name);
        result.append(')');
        return result.toString();
    }

} //StatusReasonImpl

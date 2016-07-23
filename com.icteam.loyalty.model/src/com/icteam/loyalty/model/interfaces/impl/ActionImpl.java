/**
 */
package com.icteam.loyalty.model.interfaces.impl;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.Category;
import org.eclipse.core.commands.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.handlers.IHandlerService;

import com.icteam.loyalty.api.AppException;
import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.EStatusReason;
import com.icteam.loyalty.model.interfaces.IContained;
import com.icteam.loyalty.model.interfaces.IEditable;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.provider.LoyaltyItemProviderAdapter;
import com.icteam.loyalty.model.util.ModelUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.ActionImpl#isEditable <em>Editable</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.ActionImpl#isDirty <em>Dirty</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.ActionImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.ActionImpl#getIconPath <em>Icon Path</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.ActionImpl#getPermission <em>Permission</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.impl.ActionImpl#isGeneral <em>General</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ActionImpl extends MinimalEObjectImpl.Container implements Action {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * The default value of the '{@link #isEditable() <em>Editable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEditable()
     * @generated
     * @ordered
     */
    protected static final boolean EDITABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isEditable() <em>Editable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEditable()
     * @generated
     * @ordered
     */
    protected boolean editable = EDITABLE_EDEFAULT;

    /**
     * The default value of the '{@link #isDirty() <em>Dirty</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDirty()
     * @generated
     * @ordered
     */
    protected static final boolean DIRTY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDirty() <em>Dirty</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDirty()
     * @generated
     * @ordered
     */
    protected boolean dirty = DIRTY_EDEFAULT;

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
     * The default value of the '{@link #getIconPath() <em>Icon Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIconPath()
     * @generated
     * @ordered
     */
    protected static final String ICON_PATH_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getIconPath() <em>Icon Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getIconPath()
     * @generated
     * @ordered
     */
    protected String iconPath = ICON_PATH_EDEFAULT;

    /**
     * The default value of the '{@link #getPermission() <em>Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPermission()
     * @generated
     * @ordered
     */
    protected static final String PERMISSION_EDEFAULT = "";

    /**
     * The cached value of the '{@link #getPermission() <em>Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPermission()
     * @generated
     * @ordered
     */
    protected String permission = PERMISSION_EDEFAULT;

    /**
     * The default value of the '{@link #isGeneral() <em>General</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGeneral()
     * @generated
     * @ordered
     */
    protected static final boolean GENERAL_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isGeneral() <em>General</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isGeneral()
     * @generated
     * @ordered
     */
    protected boolean general = GENERAL_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ActionImpl() {
        super();
    }

    protected ActionImpl(String name, boolean general, String permission, String iconPath) {
        this.name = name;
        this.general = general;
        this.permission = permission;
        this.iconPath = iconPath;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelInterfacesPackage.Literals.ACTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isEditable() {
        return editable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEditable(boolean newEditable) {
        boolean oldEditable = editable;
        editable = newEditable;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelInterfacesPackage.ACTION__EDITABLE, oldEditable, editable));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isDirty() {
        return dirty;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDirty(boolean newDirty) {
        boolean oldDirty = dirty;
        dirty = newDirty;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelInterfacesPackage.ACTION__DIRTY, oldDirty, dirty));
        }
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
    public String getIconPath() {
        return iconPath;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setIconPath(String newIconPath) {
        String oldIconPath = iconPath;
        iconPath = newIconPath;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelInterfacesPackage.ACTION__ICON_PATH, oldIconPath, iconPath));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getPermission() {
        return permission;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPermission(String newPermission) {
        String oldPermission = permission;
        permission = newPermission;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelInterfacesPackage.ACTION__PERMISSION, oldPermission, permission));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isGeneral() {
        return general;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setGeneral(boolean newGeneral) {
        boolean oldGeneral = general;
        general = newGeneral;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelInterfacesPackage.ACTION__GENERAL, oldGeneral, general));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isAllowed(final EObject eObject, final EStructuralFeature feature) {
        org.eclipse.ui.services.IEvaluationService es = (org.eclipse.ui.services.IEvaluationService) org.eclipse.ui.PlatformUI.getWorkbench()
                .getService(org.eclipse.ui.services.IEvaluationService.class);
        org.eclipse.core.expressions.IEvaluationContext currentState = es.getCurrentState();

        String perm = "";

        EObject mainObject = eObject;

        if (eObject instanceof IContained) {
            mainObject = ((IContained) eObject).getMainEObject();
        }

        if (mainObject instanceof EMFModel) {
            perm = ((EMFModel) mainObject).getPermissionObject() + "_";
        }

        perm += getPermission();

        org.eclipse.core.internal.expressions.ReferenceExpression referenceExpression = new org.eclipse.core.internal.expressions.ReferenceExpression(perm);
        org.eclipse.core.expressions.EvaluationResult result;
        try {
            result = referenceExpression.evaluate(currentState);
            return org.eclipse.core.expressions.EvaluationResult.TRUE.equals(result);
        } catch (org.eclipse.core.runtime.CoreException e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void execute(final EObject eObject, final EStructuralFeature feature) {
        IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
        try {
            org.eclipse.swt.widgets.Event e = new org.eclipse.swt.widgets.Event();
            e.data = new Object[] { eObject, feature };

            ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
            Category defCategory = commandService.getCategory(null);
            String commandId = getCommandId(eObject);

            Command command = commandService.getCommand(commandId);

            if (!command.isDefined()) {
                command.define(commandId, LoyaltyItemProviderAdapter.getDiplayName(eObject, feature), defCategory);
            }

            handlerService.executeCommand(commandId, e);
        } catch (org.eclipse.core.commands.ExecutionException | org.eclipse.core.commands.common.NotDefinedException | org.eclipse.core.commands.NotEnabledException
                | org.eclipse.core.commands.NotHandledException e) {
            throw new AppException(EStatusReason.ERROR, e);
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getCommandId(final EObject eObject) {
        if (isGeneral()) {
            return getName().toLowerCase();
        }

        String commandId = "";

        EObject mainObject = eObject;

        if (eObject instanceof IContained) {
            mainObject = ((IContained) eObject).getMainEObject();
        }

        if (mainObject instanceof EMFModel) {
            commandId = ((EMFModel) mainObject).getPermissionObject() + "_";
        }

        commandId += getPermission();

        return commandId;

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int compareTo(final Action o) {
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
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelInterfacesPackage.ACTION__EDITABLE:
                return isEditable();
            case ModelInterfacesPackage.ACTION__DIRTY:
                return isDirty();
            case ModelInterfacesPackage.ACTION__NAME:
                return getName();
            case ModelInterfacesPackage.ACTION__ICON_PATH:
                return getIconPath();
            case ModelInterfacesPackage.ACTION__PERMISSION:
                return getPermission();
            case ModelInterfacesPackage.ACTION__GENERAL:
                return isGeneral();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ModelInterfacesPackage.ACTION__EDITABLE:
                setEditable((Boolean) newValue);
                return;
            case ModelInterfacesPackage.ACTION__DIRTY:
                setDirty((Boolean) newValue);
                return;
            case ModelInterfacesPackage.ACTION__ICON_PATH:
                setIconPath((String) newValue);
                return;
            case ModelInterfacesPackage.ACTION__PERMISSION:
                setPermission((String) newValue);
                return;
            case ModelInterfacesPackage.ACTION__GENERAL:
                setGeneral((Boolean) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ModelInterfacesPackage.ACTION__EDITABLE:
                setEditable(EDITABLE_EDEFAULT);
                return;
            case ModelInterfacesPackage.ACTION__DIRTY:
                setDirty(DIRTY_EDEFAULT);
                return;
            case ModelInterfacesPackage.ACTION__ICON_PATH:
                setIconPath(ICON_PATH_EDEFAULT);
                return;
            case ModelInterfacesPackage.ACTION__PERMISSION:
                setPermission(PERMISSION_EDEFAULT);
                return;
            case ModelInterfacesPackage.ACTION__GENERAL:
                setGeneral(GENERAL_EDEFAULT);
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ModelInterfacesPackage.ACTION__EDITABLE:
                return editable != EDITABLE_EDEFAULT;
            case ModelInterfacesPackage.ACTION__DIRTY:
                return dirty != DIRTY_EDEFAULT;
            case ModelInterfacesPackage.ACTION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
            case ModelInterfacesPackage.ACTION__ICON_PATH:
                return ICON_PATH_EDEFAULT == null ? iconPath != null : !ICON_PATH_EDEFAULT.equals(iconPath);
            case ModelInterfacesPackage.ACTION__PERMISSION:
                return PERMISSION_EDEFAULT == null ? permission != null : !PERMISSION_EDEFAULT.equals(permission);
            case ModelInterfacesPackage.ACTION__GENERAL:
                return general != GENERAL_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class< ? > baseClass) {
        if (baseClass == Serializable.class) {
            switch (derivedFeatureID) {
                default:
                    return -1;
            }
        }
        if (baseClass == Cloneable.class) {
            switch (derivedFeatureID) {
                default:
                    return -1;
            }
        }
        if (baseClass == IEditable.class) {
            switch (derivedFeatureID) {
                case ModelInterfacesPackage.ACTION__EDITABLE:
                    return ModelInterfacesPackage.IEDITABLE__EDITABLE;
                case ModelInterfacesPackage.ACTION__DIRTY:
                    return ModelInterfacesPackage.IEDITABLE__DIRTY;
                default:
                    return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class< ? > baseClass) {
        if (baseClass == Serializable.class) {
            switch (baseFeatureID) {
                default:
                    return -1;
            }
        }
        if (baseClass == Cloneable.class) {
            switch (baseFeatureID) {
                default:
                    return -1;
            }
        }
        if (baseClass == IEditable.class) {
            switch (baseFeatureID) {
                case ModelInterfacesPackage.IEDITABLE__EDITABLE:
                    return ModelInterfacesPackage.ACTION__EDITABLE;
                case ModelInterfacesPackage.IEDITABLE__DIRTY:
                    return ModelInterfacesPackage.ACTION__DIRTY;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
            case ModelInterfacesPackage.ACTION___IS_ALLOWED__EOBJECT_ESTRUCTURALFEATURE:
                return isAllowed((EObject) arguments.get(0), (EStructuralFeature) arguments.get(1));
            case ModelInterfacesPackage.ACTION___EXECUTE__EOBJECT_ESTRUCTURALFEATURE:
                execute((EObject) arguments.get(0), (EStructuralFeature) arguments.get(1));
                return null;
            case ModelInterfacesPackage.ACTION___GET_COMMAND_ID__EOBJECT:
                return getCommandId((EObject) arguments.get(0));
            case ModelInterfacesPackage.ACTION___COMPARE_TO__IEMFENHANCEDENUM:
                return compareTo((Action) arguments.get(0));
            case ModelInterfacesPackage.ACTION___EQUALS__OBJECT:
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
        result.append(" (editable: ");
        result.append(editable);
        result.append(", dirty: ");
        result.append(dirty);
        result.append(", name: ");
        result.append(name);
        result.append(", iconPath: ");
        result.append(iconPath);
        result.append(", permission: ");
        result.append(permission);
        result.append(", general: ");
        result.append(general);
        result.append(')');
        return result.toString();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

} //ActionImpl

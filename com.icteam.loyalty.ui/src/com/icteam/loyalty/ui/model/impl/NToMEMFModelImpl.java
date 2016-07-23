/**
 */
package com.icteam.loyalty.ui.model.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import com.icteam.loyalty.model.impl.EMFModelImpl;
import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.IContained;
import com.icteam.loyalty.model.interfaces.IContainedFeature;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.interfaces.IBaseClassProvider;
import com.icteam.loyalty.ui.interfaces.NToMDirection;
import com.icteam.loyalty.ui.interfaces.UIInterfacesPackage;
import com.icteam.loyalty.ui.model.NToMEMFModel;
import com.icteam.loyalty.ui.model.UIModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>NTo MEMF Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl#getBaseClass <em>Base Class</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl#getMainEObject <em>Main EObject</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl#getMainFeature <em>Main Feature</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl#getAllToSrcAction <em>All To Src Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl#getToSrcAction <em>To Src Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl#getToDestAction <em>To Dest Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl#getAllToDestAction <em>All To Dest Action</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl#getSrcList <em>Src List</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl#getDestList <em>Dest List</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl#getSelectedDestList <em>Selected Dest List</em>}</li>
 *   <li>{@link com.icteam.loyalty.ui.model.impl.NToMEMFModelImpl#getSelectedSrcList <em>Selected Src List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NToMEMFModelImpl extends EMFModelImpl implements NToMEMFModel {
    /**
     * The cached value of the '{@link #getMainEObject() <em>Main EObject</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMainEObject()
     * @generated
     * @ordered
     */
    protected EObject mainEObject;
    /**
     * The default value of the '{@link #getMainFeature() <em>Main Feature</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMainFeature()
     * @generated
     * @ordered
     */
    protected static final EStructuralFeature MAIN_FEATURE_EDEFAULT = null;
    /**
     * The cached value of the '{@link #getMainFeature() <em>Main Feature</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMainFeature()
     * @generated
     * @ordered
     */
    protected EStructuralFeature mainFeature = MAIN_FEATURE_EDEFAULT;
    /**
     * The cached value of the '{@link #getSrcList() <em>Src List</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSrcList()
     * @generated
     * @ordered
     */
    protected EList<EObject> srcList;
    /**
     * The cached value of the '{@link #getDestList() <em>Dest List</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDestList()
     * @generated
     * @ordered
     */
    protected EList<EObject> destList;
    /**
     * The cached value of the '{@link #getSelectedDestList() <em>Selected Dest List</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelectedDestList()
     * @generated
     * @ordered
     */
    protected EList<EObject> selectedDestList;
    /**
     * The cached value of the '{@link #getSelectedSrcList() <em>Selected Src List</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSelectedSrcList()
     * @generated
     * @ordered
     */
    protected EList<EObject> selectedSrcList;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected NToMEMFModelImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UIModelPackage.Literals.NTO_MEMF_MODEL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Class<EObject> getBaseClass() {
        if (getDestList().isEmpty()) {
            if (getSrcList().isEmpty()) {
                return EObject.class;
            }

            return (Class<EObject>) getSrcList().get(0).eClass().getInstanceClass();
        }

        return (Class<EObject>) getDestList().get(0).eClass().getInstanceClass();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject getMainEObject() {
        return mainEObject;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setMainEObject(EObject newMainEObject) {
        EObject oldMainEObject = mainEObject;
        mainEObject = newMainEObject;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.NTO_MEMF_MODEL__MAIN_EOBJECT, oldMainEObject, mainEObject));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getAllToSrcAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__NTOM_ALL_TO_SRC.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getToSrcAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__NTOM_TO_SRC.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getToDestAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__NTOM_TO_DEST.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Action getAllToDestAction() {
        return ModelUtil.valueOf(this, Action.class, UIInterfacesPackage.Literals.UI_ACTION__NTOM_ALL_TO_DEST.getName());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<EObject> getSrcList() {
        if (srcList == null) {
            srcList = new EObjectResolvingEList<EObject>(EObject.class, this, UIModelPackage.NTO_MEMF_MODEL__SRC_LIST);
        }
        return srcList;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<EObject> getDestList() {
        if (destList == null) {
            destList = new EObjectResolvingEList<EObject>(EObject.class, this, UIModelPackage.NTO_MEMF_MODEL__DEST_LIST);
        }
        return destList;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<EObject> getSelectedDestList() {
        if (selectedDestList == null) {
            selectedDestList = new EObjectEList<EObject>(EObject.class, this, UIModelPackage.NTO_MEMF_MODEL__SELECTED_DEST_LIST);
        }
        return selectedDestList;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<EObject> getSelectedSrcList() {
        if (selectedSrcList == null) {
            selectedSrcList = new EObjectEList<EObject>(EObject.class, this, UIModelPackage.NTO_MEMF_MODEL__SELECTED_SRC_LIST);
        }
        return selectedSrcList;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EStructuralFeature getMainFeature() {
        return mainFeature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setMainFeature(EStructuralFeature newMainFeature) {
        EStructuralFeature oldMainFeature = mainFeature;
        mainFeature = newMainFeature;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, UIModelPackage.NTO_MEMF_MODEL__MAIN_FEATURE, oldMainFeature, mainFeature));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public void move(NToMDirection direction) {
        EList<EObject> selDestList = ECollections.newBasicEList(getSelectedDestList());
        EList<EObject> selSrcList = ECollections.newBasicEList(getSelectedSrcList());
        Integer[] selDestIndexes = computeSelectedIndexes(selDestList, getDestList());
        Integer[] selSrcIndexes = computeSelectedIndexes(selSrcList, getSrcList());

        switch (direction) {
            case ALL_TO_SRC:
                ModelUtil.addAll(getDestList(), getSrcList());
                ModelUtil.clear(getDestList());

                if (selDestList.isEmpty()) {
                    eSet(UIModelPackage.Literals.NTO_MEMF_MODEL__SELECTED_SRC_LIST, ECollections.newBasicEList(getSrcList().get(0)));
                } else {
                    eSet(UIModelPackage.Literals.NTO_MEMF_MODEL__SELECTED_SRC_LIST, selDestList);
                }

                break;
            case TO_SRC:
                if (!selDestList.isEmpty()) {
                    ModelUtil.addAll(selDestList, getSrcList());
                    ModelUtil.removeAll(getDestList(), selDestList);

                    eSet(UIModelPackage.Literals.NTO_MEMF_MODEL__SELECTED_SRC_LIST, selDestList);

                    if (getDestList().size() > 0) {
                        eSet(UIModelPackage.Literals.NTO_MEMF_MODEL__SELECTED_DEST_LIST, ECollections.newBasicEList(getDestList().get(Math.max(0, selDestIndexes[0] - 1))));
                    }
                }

                break;
            case ALL_TO_DEST:
                ModelUtil.addAll(getSrcList(), getDestList());
                ModelUtil.clear(getSrcList());

                if (selSrcList.isEmpty()) {
                    eSet(UIModelPackage.Literals.NTO_MEMF_MODEL__SELECTED_DEST_LIST, ECollections.newBasicEList(getDestList().get(0)));
                } else {
                    eSet(UIModelPackage.Literals.NTO_MEMF_MODEL__SELECTED_DEST_LIST, selSrcList);
                }

                break;
            case TO_DEST:
                if (!selSrcList.isEmpty()) {
                    ModelUtil.addAll(selSrcList, getDestList());
                    ModelUtil.removeAll(getSrcList(), selSrcList);

                    eSet(UIModelPackage.Literals.NTO_MEMF_MODEL__SELECTED_DEST_LIST, selSrcList);

                    if (getSrcList().size() > 0) {
                        eSet(UIModelPackage.Literals.NTO_MEMF_MODEL__SELECTED_SRC_LIST, ECollections.newBasicEList(getSrcList().get(Math.max(0, selSrcIndexes[0] - 1))));
                    }
                }

                break;
            default:
                break;
        }
    }

    private static Integer[] computeSelectedIndexes(EList<EObject> selList, EList<EObject> list) {
        Integer[] selIndexes = null;

        if (selList.isEmpty()) {
            selIndexes = new Integer[] { -1 };
        } else {
            List<Integer> is = new ArrayList<>();

            for (EObject selDestObject : selList) {
                is.add(list.indexOf(selDestObject));
            }

            selIndexes = is.toArray(new Integer[] {});
        }
        Arrays.sort(selIndexes);

        return selIndexes;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UIModelPackage.NTO_MEMF_MODEL__BASE_CLASS:
                return getBaseClass();
            case UIModelPackage.NTO_MEMF_MODEL__MAIN_EOBJECT:
                return getMainEObject();
            case UIModelPackage.NTO_MEMF_MODEL__MAIN_FEATURE:
                return getMainFeature();
            case UIModelPackage.NTO_MEMF_MODEL__ALL_TO_SRC_ACTION:
                return getAllToSrcAction();
            case UIModelPackage.NTO_MEMF_MODEL__TO_SRC_ACTION:
                return getToSrcAction();
            case UIModelPackage.NTO_MEMF_MODEL__TO_DEST_ACTION:
                return getToDestAction();
            case UIModelPackage.NTO_MEMF_MODEL__ALL_TO_DEST_ACTION:
                return getAllToDestAction();
            case UIModelPackage.NTO_MEMF_MODEL__SRC_LIST:
                return getSrcList();
            case UIModelPackage.NTO_MEMF_MODEL__DEST_LIST:
                return getDestList();
            case UIModelPackage.NTO_MEMF_MODEL__SELECTED_DEST_LIST:
                return getSelectedDestList();
            case UIModelPackage.NTO_MEMF_MODEL__SELECTED_SRC_LIST:
                return getSelectedSrcList();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case UIModelPackage.NTO_MEMF_MODEL__MAIN_EOBJECT:
                setMainEObject((EObject) newValue);
                return;
            case UIModelPackage.NTO_MEMF_MODEL__MAIN_FEATURE:
                setMainFeature((EStructuralFeature) newValue);
                return;
            case UIModelPackage.NTO_MEMF_MODEL__SRC_LIST:
                getSrcList().clear();
                getSrcList().addAll((Collection< ? extends EObject>) newValue);
                return;
            case UIModelPackage.NTO_MEMF_MODEL__DEST_LIST:
                getDestList().clear();
                getDestList().addAll((Collection< ? extends EObject>) newValue);
                return;
            case UIModelPackage.NTO_MEMF_MODEL__SELECTED_DEST_LIST:
                getSelectedDestList().clear();
                getSelectedDestList().addAll((Collection< ? extends EObject>) newValue);
                return;
            case UIModelPackage.NTO_MEMF_MODEL__SELECTED_SRC_LIST:
                getSelectedSrcList().clear();
                getSelectedSrcList().addAll((Collection< ? extends EObject>) newValue);
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
            case UIModelPackage.NTO_MEMF_MODEL__MAIN_EOBJECT:
                setMainEObject((EObject) null);
                return;
            case UIModelPackage.NTO_MEMF_MODEL__MAIN_FEATURE:
                setMainFeature(MAIN_FEATURE_EDEFAULT);
                return;
            case UIModelPackage.NTO_MEMF_MODEL__SRC_LIST:
                getSrcList().clear();
                return;
            case UIModelPackage.NTO_MEMF_MODEL__DEST_LIST:
                getDestList().clear();
                return;
            case UIModelPackage.NTO_MEMF_MODEL__SELECTED_DEST_LIST:
                getSelectedDestList().clear();
                return;
            case UIModelPackage.NTO_MEMF_MODEL__SELECTED_SRC_LIST:
                getSelectedSrcList().clear();
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
            case UIModelPackage.NTO_MEMF_MODEL__BASE_CLASS:
                return getBaseClass() != null;
            case UIModelPackage.NTO_MEMF_MODEL__MAIN_EOBJECT:
                return mainEObject != null;
            case UIModelPackage.NTO_MEMF_MODEL__MAIN_FEATURE:
                return MAIN_FEATURE_EDEFAULT == null ? mainFeature != null : !MAIN_FEATURE_EDEFAULT.equals(mainFeature);
            case UIModelPackage.NTO_MEMF_MODEL__ALL_TO_SRC_ACTION:
                return getAllToSrcAction() != null;
            case UIModelPackage.NTO_MEMF_MODEL__TO_SRC_ACTION:
                return getToSrcAction() != null;
            case UIModelPackage.NTO_MEMF_MODEL__TO_DEST_ACTION:
                return getToDestAction() != null;
            case UIModelPackage.NTO_MEMF_MODEL__ALL_TO_DEST_ACTION:
                return getAllToDestAction() != null;
            case UIModelPackage.NTO_MEMF_MODEL__SRC_LIST:
                return srcList != null && !srcList.isEmpty();
            case UIModelPackage.NTO_MEMF_MODEL__DEST_LIST:
                return destList != null && !destList.isEmpty();
            case UIModelPackage.NTO_MEMF_MODEL__SELECTED_DEST_LIST:
                return selectedDestList != null && !selectedDestList.isEmpty();
            case UIModelPackage.NTO_MEMF_MODEL__SELECTED_SRC_LIST:
                return selectedSrcList != null && !selectedSrcList.isEmpty();
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
        if (baseClass == IBaseClassProvider.class) {
            switch (derivedFeatureID) {
                case UIModelPackage.NTO_MEMF_MODEL__BASE_CLASS:
                    return UIInterfacesPackage.IBASE_CLASS_PROVIDER__BASE_CLASS;
                default:
                    return -1;
            }
        }
        if (baseClass == IContained.class) {
            switch (derivedFeatureID) {
                case UIModelPackage.NTO_MEMF_MODEL__MAIN_EOBJECT:
                    return ModelInterfacesPackage.ICONTAINED__MAIN_EOBJECT;
                default:
                    return -1;
            }
        }
        if (baseClass == IContainedFeature.class) {
            switch (derivedFeatureID) {
                case UIModelPackage.NTO_MEMF_MODEL__MAIN_FEATURE:
                    return ModelInterfacesPackage.ICONTAINED_FEATURE__MAIN_FEATURE;
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
        if (baseClass == IBaseClassProvider.class) {
            switch (baseFeatureID) {
                case UIInterfacesPackage.IBASE_CLASS_PROVIDER__BASE_CLASS:
                    return UIModelPackage.NTO_MEMF_MODEL__BASE_CLASS;
                default:
                    return -1;
            }
        }
        if (baseClass == IContained.class) {
            switch (baseFeatureID) {
                case ModelInterfacesPackage.ICONTAINED__MAIN_EOBJECT:
                    return UIModelPackage.NTO_MEMF_MODEL__MAIN_EOBJECT;
                default:
                    return -1;
            }
        }
        if (baseClass == IContainedFeature.class) {
            switch (baseFeatureID) {
                case ModelInterfacesPackage.ICONTAINED_FEATURE__MAIN_FEATURE:
                    return UIModelPackage.NTO_MEMF_MODEL__MAIN_FEATURE;
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
    public Object eInvoke(int operationID, EList< ? > arguments) throws InvocationTargetException {
        switch (operationID) {
            case UIModelPackage.NTO_MEMF_MODEL___MOVE__NTOMDIRECTION:
                move((NToMDirection) arguments.get(0));
                return null;
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
        result.append(" (mainFeature: ");
        result.append(mainFeature);
        result.append(')');
        return result.toString();
    }

} //NToMEMFModelImpl

/**
 */
package com.icteam.loyalty.ui.interfaces.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.icteam.loyalty.ui.interfaces.NToMDirection;
import com.icteam.loyalty.ui.interfaces.UIAction;
import com.icteam.loyalty.ui.interfaces.UIInterfacesFactory;
import com.icteam.loyalty.ui.interfaces.UIInterfacesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UIInterfacesFactoryImpl extends EFactoryImpl implements UIInterfacesFactory {
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static UIInterfacesFactory init() {
        try {
            UIInterfacesFactory theUIInterfacesFactory = (UIInterfacesFactory) EPackage.Registry.INSTANCE.getEFactory(UIInterfacesPackage.eNS_URI);
            if (theUIInterfacesFactory != null) {
                return theUIInterfacesFactory;
            }
        } catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new UIInterfacesFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UIInterfacesFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case UIInterfacesPackage.UI_ACTION:
                return createUIAction();
            case UIInterfacesPackage.ESTRUCTURAL_FEATURE_TO_INT_MAP:
                return (EObject) createEStructuralFeatureToIntMap();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case UIInterfacesPackage.NTO_MDIRECTION:
                return createNToMDirectionFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case UIInterfacesPackage.NTO_MDIRECTION:
                return convertNToMDirectionToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public UIAction createUIAction() {
        UIActionImpl uiAction = new UIActionImpl();
        return uiAction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Map.Entry<EStructuralFeature, Integer> createEStructuralFeatureToIntMap() {
        EStructuralFeatureToIntMapImpl eStructuralFeatureToIntMap = new EStructuralFeatureToIntMapImpl();
        return eStructuralFeatureToIntMap;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NToMDirection createNToMDirectionFromString(EDataType eDataType, String initialValue) {
        NToMDirection result = NToMDirection.get(initialValue);
        if (result == null) {
            throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        }
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertNToMDirectionToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public UIInterfacesPackage getUIInterfacesPackage() {
        return (UIInterfacesPackage) getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static UIInterfacesPackage getPackage() {
        return UIInterfacesPackage.eINSTANCE;
    }

} //UIInterfacesFactoryImpl

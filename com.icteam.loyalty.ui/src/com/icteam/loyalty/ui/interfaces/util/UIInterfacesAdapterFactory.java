/**
 */
package com.icteam.loyalty.ui.interfaces.util;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;

import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum;
import com.icteam.loyalty.model.interfaces.IEditable;
import com.icteam.loyalty.ui.interfaces.IBaseClassProvider;
import com.icteam.loyalty.ui.interfaces.UIAction;
import com.icteam.loyalty.ui.interfaces.UIInterfacesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.ui.interfaces.UIInterfacesPackage
 * @generated
 */
public class UIInterfacesAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static UIInterfacesPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UIInterfacesAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = UIInterfacesPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UIInterfacesSwitch<Adapter> modelSwitch = new UIInterfacesSwitch<Adapter>() {
        @Override
        public Adapter caseIBaseClassProvider(IBaseClassProvider object) {
            return createIBaseClassProviderAdapter();
        }

        @Override
        public Adapter caseUIAction(UIAction object) {
            return createUIActionAdapter();
        }

        @Override
        public Adapter caseEStructuralFeatureToIntMap(Map.Entry<EStructuralFeature, Integer> object) {
            return createEStructuralFeatureToIntMapAdapter();
        }

        @Override
        public Adapter caseIEditorInput(IEditorInput object) {
            return createIEditorInputAdapter();
        }

        @Override
        public Adapter caseIEditorPart(IEditorPart object) {
            return createIEditorPartAdapter();
        }

        @Override
        public <T> Adapter caseComparable(Comparable<T> object) {
            return createComparableAdapter();
        }

        @Override
        public Adapter caseSerializable(Serializable object) {
            return createSerializableAdapter();
        }

        @Override
        public Adapter caseCloneable(Cloneable object) {
            return createCloneableAdapter();
        }

        @Override
        public <E extends IEMFEnhancedEnum<E>> Adapter caseIEMFEnhancedEnum(IEMFEnhancedEnum<E> object) {
            return createIEMFEnhancedEnumAdapter();
        }

        @Override
        public Adapter caseIEditable(IEditable object) {
            return createIEditableAdapter();
        }

        @Override
        public Adapter caseAction(Action object) {
            return createActionAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.ui.interfaces.IBaseClassProvider <em>IBase Class Provider</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.ui.interfaces.IBaseClassProvider
     * @generated
     */
    public Adapter createIBaseClassProviderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.ui.interfaces.UIAction <em>UI Action</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.ui.interfaces.UIAction
     * @generated
     */
    public Adapter createUIActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>EStructural Feature To Int Map</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.util.Map.Entry
     * @generated
     */
    public Adapter createEStructuralFeatureToIntMapAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ui.IEditorInput <em>IEditor Input</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ui.IEditorInput
     * @generated
     */
    public Adapter createIEditorInputAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.ui.IEditorPart <em>IEditor Part</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.ui.IEditorPart
     * @generated
     */
    public Adapter createIEditorPartAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link java.lang.Comparable <em>Comparable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.lang.Comparable
     * @generated
     */
    public Adapter createComparableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link java.io.Serializable <em>Serializable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.io.Serializable
     * @generated
     */
    public Adapter createSerializableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link java.lang.Cloneable <em>Cloneable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see java.lang.Cloneable
     * @generated
     */
    public Adapter createCloneableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum <em>IEMF Enhanced Enum</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum
     * @generated
     */
    public Adapter createIEMFEnhancedEnumAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.IEditable <em>IEditable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.IEditable
     * @generated
     */
    public Adapter createIEditableAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.Action <em>Action</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.Action
     * @generated
     */
    public Adapter createActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} //UIInterfacesAdapterFactory

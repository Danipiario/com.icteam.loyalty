/**
 */
package com.icteam.loyalty.model.interfaces.util;

import java.io.Serializable;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.IContained;
import com.icteam.loyalty.model.interfaces.IContainedFeature;
import com.icteam.loyalty.model.interfaces.IEMFDelegant;
import com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum;
import com.icteam.loyalty.model.interfaces.IEMFModel;
import com.icteam.loyalty.model.interfaces.IEMFSelectable;
import com.icteam.loyalty.model.interfaces.IEMFTemplate;
import com.icteam.loyalty.model.interfaces.IEditable;
import com.icteam.loyalty.model.interfaces.IPerspectiveProvider;
import com.icteam.loyalty.model.interfaces.IStatusEMFTemplate;
import com.icteam.loyalty.model.interfaces.Language;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.interfaces.Permission;
import com.icteam.loyalty.model.interfaces.Perspective;
import com.icteam.loyalty.model.interfaces.Status;
import com.icteam.loyalty.model.interfaces.StatusReason;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage
 * @generated
 */
public class ModelInterfacesAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ModelInterfacesPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelInterfacesAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ModelInterfacesPackage.eINSTANCE;
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
    protected ModelInterfacesSwitch<Adapter> modelSwitch = new ModelInterfacesSwitch<Adapter>() {
        @Override
        public Adapter caseIEMFModel(IEMFModel object) {
            return createIEMFModelAdapter();
        }

        @Override
        public Adapter caseIEditable(IEditable object) {
            return createIEditableAdapter();
        }

        @Override
        public <E extends IEMFEnhancedEnum<E>> Adapter caseIEMFEnhancedEnum(IEMFEnhancedEnum<E> object) {
            return createIEMFEnhancedEnumAdapter();
        }

        @Override
        public Adapter casePermission(Permission object) {
            return createPermissionAdapter();
        }

        @Override
        public <T extends Serializable> Adapter caseIEMFTemplate(IEMFTemplate<T> object) {
            return createIEMFTemplateAdapter();
        }

        @Override
        public Adapter caseIPerspectiveProvider(IPerspectiveProvider object) {
            return createIPerspectiveProviderAdapter();
        }

        @Override
        public Adapter caseIStatusEMFTemplate(IStatusEMFTemplate object) {
            return createIStatusEMFTemplateAdapter();
        }

        @Override
        public <S extends Serializable> Adapter caseIEMFSelectable(IEMFSelectable<S> object) {
            return createIEMFSelectableAdapter();
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
        public Adapter caseStatus(Status object) {
            return createStatusAdapter();
        }

        @Override
        public Adapter caseStatusReason(StatusReason object) {
            return createStatusReasonAdapter();
        }

        @Override
        public Adapter casePerspective(Perspective object) {
            return createPerspectiveAdapter();
        }

        @Override
        public Adapter caseLanguage(Language object) {
            return createLanguageAdapter();
        }

        @Override
        public Adapter caseAction(Action object) {
            return createActionAdapter();
        }

        @Override
        public Adapter caseCloneable(Cloneable object) {
            return createCloneableAdapter();
        }

        @Override
        public Adapter caseIContained(IContained object) {
            return createIContainedAdapter();
        }

        @Override
        public Adapter caseIContainedFeature(IContainedFeature object) {
            return createIContainedFeatureAdapter();
        }

        @Override
        public Adapter caseIEMFDelegant(IEMFDelegant object) {
            return createIEMFDelegantAdapter();
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
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.IEMFModel <em>IEMF Model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.IEMFModel
     * @generated
     */
    public Adapter createIEMFModelAdapter() {
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
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.Permission <em>Permission</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.Permission
     * @generated
     */
    public Adapter createPermissionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate <em>IEMF Template</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.IEMFTemplate
     * @generated
     */
    public Adapter createIEMFTemplateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.IPerspectiveProvider <em>IPerspective Provider</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.IPerspectiveProvider
     * @generated
     */
    public Adapter createIPerspectiveProviderAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.IStatusEMFTemplate <em>IStatus EMF Template</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.IStatusEMFTemplate
     * @generated
     */
    public Adapter createIStatusEMFTemplateAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.IEMFSelectable <em>IEMF Selectable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.IEMFSelectable
     * @generated
     */
    public Adapter createIEMFSelectableAdapter() {
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
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.Status <em>Status</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.Status
     * @generated
     */
    public Adapter createStatusAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.StatusReason <em>Status Reason</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.StatusReason
     * @generated
     */
    public Adapter createStatusReasonAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.Perspective <em>Perspective</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.Perspective
     * @generated
     */
    public Adapter createPerspectiveAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.Language <em>Language</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.Language
     * @generated
     */
    public Adapter createLanguageAdapter() {
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
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.IContained <em>IContained</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.IContained
     * @generated
     */
    public Adapter createIContainedAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.IContainedFeature <em>IContained Feature</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.IContainedFeature
     * @generated
     */
    public Adapter createIContainedFeatureAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.interfaces.IEMFDelegant <em>IEMF Delegant</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.interfaces.IEMFDelegant
     * @generated
     */
    public Adapter createIEMFDelegantAdapter() {
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

} //ModelInterfacesAdapterFactory

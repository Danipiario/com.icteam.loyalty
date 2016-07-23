/**
 */
package com.icteam.loyalty.ui.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorInput;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.interfaces.IContained;
import com.icteam.loyalty.model.interfaces.IContainedFeature;
import com.icteam.loyalty.model.interfaces.IEMFModel;
import com.icteam.loyalty.model.interfaces.IEditable;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.ui.interfaces.IBaseClassProvider;
import com.icteam.loyalty.ui.model.DefaultEditorEMFModel;
import com.icteam.loyalty.ui.model.NToMEMFModel;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.ui.model.UIModelPackage
 * @generated
 */
public class UIModelAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static UIModelPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UIModelAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = UIModelPackage.eINSTANCE;
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
    protected UIModelSwitch<Adapter> modelSwitch = new UIModelSwitch<Adapter>() {
        @Override
        public Adapter caseNToMEMFModel(NToMEMFModel object) {
            return createNToMEMFModelAdapter();
        }

        @Override
        public <D extends EMFModel> Adapter caseDefaultEditorEMFModel(DefaultEditorEMFModel<D> object) {
            return createDefaultEditorEMFModelAdapter();
        }

        @Override
        public <T extends AbstractEMFTemplate< ? >, D extends EMFModel> Adapter caseVirtualViewEMFModel(VirtualViewEMFModel<T, D> object) {
            return createVirtualViewEMFModelAdapter();
        }

        @Override
        public Adapter caseIEditable(IEditable object) {
            return createIEditableAdapter();
        }

        @Override
        public Adapter caseIEMFModel(IEMFModel object) {
            return createIEMFModelAdapter();
        }

        @Override
        public Adapter caseEMFModel(EMFModel object) {
            return createEMFModelAdapter();
        }

        @Override
        public Adapter caseIBaseClassProvider(IBaseClassProvider object) {
            return createIBaseClassProviderAdapter();
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
        public Adapter caseIEditorInput(IEditorInput object) {
            return createIEditorInputAdapter();
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
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.ui.model.NToMEMFModel <em>NTo MEMF Model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.ui.model.NToMEMFModel
     * @generated
     */
    public Adapter createNToMEMFModelAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel <em>Default Editor EMF Model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.ui.model.DefaultEditorEMFModel
     * @generated
     */
    public Adapter createDefaultEditorEMFModelAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.ui.model.VirtualViewEMFModel <em>Virtual View EMF Model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.ui.model.VirtualViewEMFModel
     * @generated
     */
    public Adapter createVirtualViewEMFModelAdapter() {
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
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.EMFModel <em>EMF Model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.EMFModel
     * @generated
     */
    public Adapter createEMFModelAdapter() {
        return null;
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

} //UIModelAdapterFactory

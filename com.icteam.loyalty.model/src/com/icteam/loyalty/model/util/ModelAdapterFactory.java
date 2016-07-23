/**
 */
package com.icteam.loyalty.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.ListEMFModel;
import com.icteam.loyalty.model.ModelPackage;
import com.icteam.loyalty.model.ResultEMFModel;
import com.icteam.loyalty.model.interfaces.IEMFModel;
import com.icteam.loyalty.model.interfaces.IEditable;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ModelPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = ModelPackage.eINSTANCE;
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
    protected ModelSwitch<Adapter> modelSwitch = new ModelSwitch<Adapter>() {
        @Override
        public Adapter caseEMFModel(EMFModel object) {
            return createEMFModelAdapter();
        }

        @Override
        public Adapter caseResultEMFModel(ResultEMFModel object) {
            return createResultEMFModelAdapter();
        }

        @Override
        public <D extends EMFModel> Adapter caseListEMFModel(ListEMFModel<D> object) {
            return createListEMFModelAdapter();
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
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.ResultEMFModel <em>Result EMF Model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.ResultEMFModel
     * @generated
     */
    public Adapter createResultEMFModelAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link com.icteam.loyalty.model.ListEMFModel <em>List EMF Model</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see com.icteam.loyalty.model.ListEMFModel
     * @generated
     */
    public Adapter createListEMFModelAdapter() {
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

} //ModelAdapterFactory

/**
 */
package com.icteam.loyalty.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.ListEMFModel;
import com.icteam.loyalty.model.ModelPackage;
import com.icteam.loyalty.model.ResultEMFModel;
import com.icteam.loyalty.model.interfaces.IEMFModel;
import com.icteam.loyalty.model.interfaces.IEditable;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> extends Switch<T> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ModelPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelSwitch() {
        if (modelPackage == null) {
            modelPackage = ModelPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor(EPackage ePackage) {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case ModelPackage.EMF_MODEL: {
                EMFModel emfModel = (EMFModel) theEObject;
                T result = caseEMFModel(emfModel);
                if (result == null) {
                    result = caseIEMFModel(emfModel);
                }
                if (result == null) {
                    result = caseIEditable(emfModel);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelPackage.RESULT_EMF_MODEL: {
                ResultEMFModel resultEMFModel = (ResultEMFModel) theEObject;
                T result = caseResultEMFModel(resultEMFModel);
                if (result == null) {
                    result = caseEMFModel(resultEMFModel);
                }
                if (result == null) {
                    result = caseIEMFModel(resultEMFModel);
                }
                if (result == null) {
                    result = caseIEditable(resultEMFModel);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelPackage.LIST_EMF_MODEL: {
                ListEMFModel< ? > listEMFModel = (ListEMFModel< ? >) theEObject;
                T result = caseListEMFModel(listEMFModel);
                if (result == null) {
                    result = caseEMFModel(listEMFModel);
                }
                if (result == null) {
                    result = caseIEMFModel(listEMFModel);
                }
                if (result == null) {
                    result = caseIEditable(listEMFModel);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            default:
                return defaultCase(theEObject);
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EMF Model</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EMF Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEMFModel(EMFModel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Result EMF Model</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Result EMF Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseResultEMFModel(ResultEMFModel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>List EMF Model</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>List EMF Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <D extends EMFModel> T caseListEMFModel(ListEMFModel<D> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>IEditable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IEditable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIEditable(IEditable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>IEMF Model</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IEMF Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIEMFModel(IEMFModel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase(EObject object) {
        return null;
    }

} //ModelSwitch

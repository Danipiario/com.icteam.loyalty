/**
 */
package com.icteam.loyalty.ui.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.ui.model.UIModelPackage
 * @generated
 */
public class UIModelSwitch<T1> extends Switch<T1> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static UIModelPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UIModelSwitch() {
        if (modelPackage == null) {
            modelPackage = UIModelPackage.eINSTANCE;
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
    protected T1 doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case UIModelPackage.NTO_MEMF_MODEL: {
                NToMEMFModel nToMEMFModel = (NToMEMFModel) theEObject;
                T1 result = caseNToMEMFModel(nToMEMFModel);
                if (result == null) {
                    result = caseEMFModel(nToMEMFModel);
                }
                if (result == null) {
                    result = caseIBaseClassProvider(nToMEMFModel);
                }
                if (result == null) {
                    result = caseIContainedFeature(nToMEMFModel);
                }
                if (result == null) {
                    result = caseIEMFModel(nToMEMFModel);
                }
                if (result == null) {
                    result = caseIContained(nToMEMFModel);
                }
                if (result == null) {
                    result = caseIEditable(nToMEMFModel);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL: {
                DefaultEditorEMFModel< ? > defaultEditorEMFModel = (DefaultEditorEMFModel< ? >) theEObject;
                T1 result = caseDefaultEditorEMFModel(defaultEditorEMFModel);
                if (result == null) {
                    result = caseEMFModel(defaultEditorEMFModel);
                }
                if (result == null) {
                    result = caseIEditorInput(defaultEditorEMFModel);
                }
                if (result == null) {
                    result = caseIEMFModel(defaultEditorEMFModel);
                }
                if (result == null) {
                    result = caseIEditable(defaultEditorEMFModel);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL: {
                VirtualViewEMFModel< ? , ? > virtualViewEMFModel = (VirtualViewEMFModel< ? , ? >) theEObject;
                T1 result = caseVirtualViewEMFModel(virtualViewEMFModel);
                if (result == null) {
                    result = caseEMFModel(virtualViewEMFModel);
                }
                if (result == null) {
                    result = caseIBaseClassProvider(virtualViewEMFModel);
                }
                if (result == null) {
                    result = caseIEMFModel(virtualViewEMFModel);
                }
                if (result == null) {
                    result = caseIEditable(virtualViewEMFModel);
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
     * Returns the result of interpreting the object as an instance of '<em>NTo MEMF Model</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>NTo MEMF Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseNToMEMFModel(NToMEMFModel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Default Editor EMF Model</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Default Editor EMF Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <D extends EMFModel> T1 caseDefaultEditorEMFModel(DefaultEditorEMFModel<D> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Virtual View EMF Model</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Virtual View EMF Model</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <T extends AbstractEMFTemplate< ? >, D extends EMFModel> T1 caseVirtualViewEMFModel(VirtualViewEMFModel<T, D> object) {
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
    public T1 caseIEditable(IEditable object) {
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
    public T1 caseIEMFModel(IEMFModel object) {
        return null;
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
    public T1 caseEMFModel(EMFModel object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>IBase Class Provider</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IBase Class Provider</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseIBaseClassProvider(IBaseClassProvider object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>IContained</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IContained</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseIContained(IContained object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>IContained Feature</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IContained Feature</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseIContainedFeature(IContainedFeature object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>IEditor Input</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IEditor Input</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseIEditorInput(IEditorInput object) {
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
    public T1 defaultCase(EObject object) {
        return null;
    }

} //UIModelSwitch

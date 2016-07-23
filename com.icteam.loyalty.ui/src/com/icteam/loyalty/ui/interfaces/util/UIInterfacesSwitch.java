/**
 */
package com.icteam.loyalty.ui.interfaces.util;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.Switch;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.ui.interfaces.UIInterfacesPackage
 * @generated
 */
public class UIInterfacesSwitch<T1> extends Switch<T1> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static UIInterfacesPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UIInterfacesSwitch() {
        if (modelPackage == null) {
            modelPackage = UIInterfacesPackage.eINSTANCE;
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
            case UIInterfacesPackage.IBASE_CLASS_PROVIDER: {
                IBaseClassProvider iBaseClassProvider = (IBaseClassProvider) theEObject;
                T1 result = caseIBaseClassProvider(iBaseClassProvider);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case UIInterfacesPackage.UI_ACTION: {
                UIAction uiAction = (UIAction) theEObject;
                T1 result = caseUIAction(uiAction);
                if (result == null) {
                    result = caseAction(uiAction);
                }
                if (result == null) {
                    result = caseIEMFEnhancedEnum(uiAction);
                }
                if (result == null) {
                    result = caseIEditable(uiAction);
                }
                if (result == null) {
                    result = caseComparable(uiAction);
                }
                if (result == null) {
                    result = caseSerializable(uiAction);
                }
                if (result == null) {
                    result = caseCloneable(uiAction);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case UIInterfacesPackage.ESTRUCTURAL_FEATURE_TO_INT_MAP: {
                @SuppressWarnings("unchecked")
                Map.Entry<EStructuralFeature, Integer> eStructuralFeatureToIntMap = (Map.Entry<EStructuralFeature, Integer>) theEObject;
                T1 result = caseEStructuralFeatureToIntMap(eStructuralFeatureToIntMap);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case UIInterfacesPackage.IEDITOR_INPUT: {
                IEditorInput iEditorInput = (IEditorInput) theEObject;
                T1 result = caseIEditorInput(iEditorInput);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case UIInterfacesPackage.IEDITOR_PART: {
                IEditorPart iEditorPart = (IEditorPart) theEObject;
                T1 result = caseIEditorPart(iEditorPart);
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
     * Returns the result of interpreting the object as an instance of '<em>UI Action</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>UI Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseUIAction(UIAction object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EStructural Feature To Int Map</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EStructural Feature To Int Map</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseEStructuralFeatureToIntMap(Map.Entry<EStructuralFeature, Integer> object) {
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
     * Returns the result of interpreting the object as an instance of '<em>IEditor Part</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IEditor Part</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseIEditorPart(IEditorPart object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Comparable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Comparable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <T> T1 caseComparable(Comparable<T> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Serializable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Serializable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseSerializable(Serializable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Cloneable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Cloneable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseCloneable(Cloneable object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>IEMF Enhanced Enum</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IEMF Enhanced Enum</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <E extends IEMFEnhancedEnum<E>> T1 caseIEMFEnhancedEnum(IEMFEnhancedEnum<E> object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Action</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseAction(Action object) {
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

} //UIInterfacesSwitch

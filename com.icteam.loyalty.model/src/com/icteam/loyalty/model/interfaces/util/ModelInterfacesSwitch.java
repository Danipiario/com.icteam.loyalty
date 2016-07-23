/**
 */
package com.icteam.loyalty.model.interfaces.util;

import java.io.Serializable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage
 * @generated
 */
public class ModelInterfacesSwitch<T1> extends Switch<T1> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ModelInterfacesPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelInterfacesSwitch() {
        if (modelPackage == null) {
            modelPackage = ModelInterfacesPackage.eINSTANCE;
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
            case ModelInterfacesPackage.IEMF_MODEL: {
                IEMFModel iemfModel = (IEMFModel) theEObject;
                T1 result = caseIEMFModel(iemfModel);
                if (result == null) {
                    result = caseIEditable(iemfModel);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.IEDITABLE: {
                IEditable iEditable = (IEditable) theEObject;
                T1 result = caseIEditable(iEditable);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.IEMF_ENHANCED_ENUM: {
                IEMFEnhancedEnum< ? > iemfEnhancedEnum = (IEMFEnhancedEnum< ? >) theEObject;
                T1 result = caseIEMFEnhancedEnum(iemfEnhancedEnum);
                if (result == null) {
                    result = caseComparable(iemfEnhancedEnum);
                }
                if (result == null) {
                    result = caseSerializable(iemfEnhancedEnum);
                }
                if (result == null) {
                    result = caseCloneable(iemfEnhancedEnum);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.PERMISSION: {
                Permission permission = (Permission) theEObject;
                T1 result = casePermission(permission);
                if (result == null) {
                    result = caseIEMFEnhancedEnum(permission);
                }
                if (result == null) {
                    result = caseComparable(permission);
                }
                if (result == null) {
                    result = caseSerializable(permission);
                }
                if (result == null) {
                    result = caseCloneable(permission);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.IEMF_TEMPLATE: {
                IEMFTemplate< ? > iemfTemplate = (IEMFTemplate< ? >) theEObject;
                T1 result = caseIEMFTemplate(iemfTemplate);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.IPERSPECTIVE_PROVIDER: {
                IPerspectiveProvider iPerspectiveProvider = (IPerspectiveProvider) theEObject;
                T1 result = caseIPerspectiveProvider(iPerspectiveProvider);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.ISTATUS_EMF_TEMPLATE: {
                IStatusEMFTemplate iStatusEMFTemplate = (IStatusEMFTemplate) theEObject;
                T1 result = caseIStatusEMFTemplate(iStatusEMFTemplate);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.IEMF_SELECTABLE: {
                IEMFSelectable< ? > iemfSelectable = (IEMFSelectable< ? >) theEObject;
                T1 result = caseIEMFSelectable(iemfSelectable);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.COMPARABLE: {
                Comparable< ? > comparable = (Comparable< ? >) theEObject;
                T1 result = caseComparable(comparable);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.SERIALIZABLE: {
                Serializable serializable = (Serializable) theEObject;
                T1 result = caseSerializable(serializable);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.STATUS: {
                Status status = (Status) theEObject;
                T1 result = caseStatus(status);
                if (result == null) {
                    result = caseIEMFEnhancedEnum(status);
                }
                if (result == null) {
                    result = caseComparable(status);
                }
                if (result == null) {
                    result = caseSerializable(status);
                }
                if (result == null) {
                    result = caseCloneable(status);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.STATUS_REASON: {
                StatusReason statusReason = (StatusReason) theEObject;
                T1 result = caseStatusReason(statusReason);
                if (result == null) {
                    result = caseIEMFEnhancedEnum(statusReason);
                }
                if (result == null) {
                    result = caseComparable(statusReason);
                }
                if (result == null) {
                    result = caseSerializable(statusReason);
                }
                if (result == null) {
                    result = caseCloneable(statusReason);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.PERSPECTIVE: {
                Perspective perspective = (Perspective) theEObject;
                T1 result = casePerspective(perspective);
                if (result == null) {
                    result = caseIEMFEnhancedEnum(perspective);
                }
                if (result == null) {
                    result = caseComparable(perspective);
                }
                if (result == null) {
                    result = caseSerializable(perspective);
                }
                if (result == null) {
                    result = caseCloneable(perspective);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.LANGUAGE: {
                Language language = (Language) theEObject;
                T1 result = caseLanguage(language);
                if (result == null) {
                    result = caseIEMFEnhancedEnum(language);
                }
                if (result == null) {
                    result = caseComparable(language);
                }
                if (result == null) {
                    result = caseSerializable(language);
                }
                if (result == null) {
                    result = caseCloneable(language);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.ACTION: {
                Action action = (Action) theEObject;
                T1 result = caseAction(action);
                if (result == null) {
                    result = caseIEMFEnhancedEnum(action);
                }
                if (result == null) {
                    result = caseIEditable(action);
                }
                if (result == null) {
                    result = caseComparable(action);
                }
                if (result == null) {
                    result = caseSerializable(action);
                }
                if (result == null) {
                    result = caseCloneable(action);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.CLONEABLE: {
                Cloneable cloneable = (Cloneable) theEObject;
                T1 result = caseCloneable(cloneable);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.ICONTAINED: {
                IContained iContained = (IContained) theEObject;
                T1 result = caseIContained(iContained);
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.ICONTAINED_FEATURE: {
                IContainedFeature iContainedFeature = (IContainedFeature) theEObject;
                T1 result = caseIContainedFeature(iContainedFeature);
                if (result == null) {
                    result = caseIContained(iContainedFeature);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelInterfacesPackage.IEMF_DELEGANT: {
                IEMFDelegant iemfDelegant = (IEMFDelegant) theEObject;
                T1 result = caseIEMFDelegant(iemfDelegant);
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
     * Returns the result of interpreting the object as an instance of '<em>Permission</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Permission</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 casePermission(Permission object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>IEMF Template</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IEMF Template</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <T extends Serializable> T1 caseIEMFTemplate(IEMFTemplate<T> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>IPerspective Provider</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IPerspective Provider</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseIPerspectiveProvider(IPerspectiveProvider object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>IStatus EMF Template</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IStatus EMF Template</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseIStatusEMFTemplate(IStatusEMFTemplate object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>IEMF Selectable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IEMF Selectable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <S extends Serializable> T1 caseIEMFSelectable(IEMFSelectable<S> object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Status</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Status</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseStatus(Status object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Status Reason</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Status Reason</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseStatusReason(StatusReason object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Perspective</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Perspective</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 casePerspective(Perspective object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Language</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Language</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseLanguage(Language object) {
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
     * Returns the result of interpreting the object as an instance of '<em>IEMF Delegant</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>IEMF Delegant</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseIEMFDelegant(IEMFDelegant object) {
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

} //ModelInterfacesSwitch

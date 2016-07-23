/**
 */
package com.icteam.loyalty.model.template.util;

import java.io.Serializable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.icteam.loyalty.model.interfaces.IEMFModel;
import com.icteam.loyalty.model.interfaces.IEMFTemplate;
import com.icteam.loyalty.model.interfaces.IEditable;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.model.template.DictionaryEMFTemplate;
import com.icteam.loyalty.model.template.ModelTemplatePackage;

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
 * @see com.icteam.loyalty.model.template.ModelTemplatePackage
 * @generated
 */
public class ModelTemplateSwitch<T1> extends Switch<T1> {
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ModelTemplatePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelTemplateSwitch() {
        if (modelPackage == null) {
            modelPackage = ModelTemplatePackage.eINSTANCE;
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
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE: {
                AbstractEMFTemplate< ? > abstractEMFTemplate = (AbstractEMFTemplate< ? >) theEObject;
                T1 result = caseAbstractEMFTemplate(abstractEMFTemplate);
                if (result == null) {
                    result = caseIEMFTemplate(abstractEMFTemplate);
                }
                if (result == null) {
                    result = caseIEMFModel(abstractEMFTemplate);
                }
                if (result == null) {
                    result = caseIEditable(abstractEMFTemplate);
                }
                if (result == null) {
                    result = defaultCase(theEObject);
                }
                return result;
            }
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE: {
                DictionaryEMFTemplate dictionaryEMFTemplate = (DictionaryEMFTemplate) theEObject;
                T1 result = caseDictionaryEMFTemplate(dictionaryEMFTemplate);
                if (result == null) {
                    result = caseAbstractEMFTemplate(dictionaryEMFTemplate);
                }
                if (result == null) {
                    result = caseIEMFTemplate(dictionaryEMFTemplate);
                }
                if (result == null) {
                    result = caseIEMFModel(dictionaryEMFTemplate);
                }
                if (result == null) {
                    result = caseIEditable(dictionaryEMFTemplate);
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
     * Returns the result of interpreting the object as an instance of '<em>Abstract EMF Template</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract EMF Template</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public <T extends Serializable> T1 caseAbstractEMFTemplate(AbstractEMFTemplate<T> object) {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Dictionary EMF Template</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Dictionary EMF Template</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T1 caseDictionaryEMFTemplate(DictionaryEMFTemplate object) {
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

} //ModelTemplateSwitch

/**
 */
package com.icteam.loyalty.model.interfaces;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Action#getName <em>Name</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Action#getIconPath <em>Icon Path</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Action#getPermission <em>Permission</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.Action#isGeneral <em>General</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends IEMFEnhancedEnum<Action>, IEditable {
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getAction_Name()
     * @model id="true" required="true" changeable="false"
     * @generated
     */
    @Override
    String getName();

    /**
     * Returns the value of the '<em><b>Icon Path</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Icon Path</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Icon Path</em>' attribute.
     * @see #setIconPath(String)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getAction_IconPath()
     * @model required="true"
     * @generated
     */
    String getIconPath();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.Action#getIconPath <em>Icon Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Icon Path</em>' attribute.
     * @see #getIconPath()
     * @generated
     */
    void setIconPath(String value);

    /**
     * Returns the value of the '<em><b>Permission</b></em>' attribute.
     * The default value is <code>""</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Permission</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Permission</em>' attribute.
     * @see #setPermission(String)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getAction_Permission()
     * @model default=""
     * @generated
     */
    String getPermission();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.Action#getPermission <em>Permission</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Permission</em>' attribute.
     * @see #getPermission()
     * @generated
     */
    void setPermission(String value);

    /**
     * Returns the value of the '<em><b>General</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>General</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>General</em>' attribute.
     * @see #setGeneral(boolean)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getAction_General()
     * @model
     * @generated
     */
    boolean isGeneral();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.Action#isGeneral <em>General</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>General</em>' attribute.
     * @see #isGeneral()
     * @generated
     */
    void setGeneral(boolean value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model featureDataType="com.icteam.loyalty.model.interfaces.EStructuralFeature"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='        org.eclipse.ui.services.IEvaluationService es = (org.eclipse.ui.services.IEvaluationService) org.eclipse.ui.PlatformUI.getWorkbench()\r\n                .getService(org.eclipse.ui.services.IEvaluationService.class);\r\n        org.eclipse.core.expressions.IEvaluationContext currentState = es.getCurrentState();\r\n\r\n        String perm = \"\";\r\n        \r\n        EObject mainObject = eObject;\r\n        \r\n        if (eObject instanceof IContained) {\r\n            mainObject = ((IContained) eObject).getMainEObject();\r\n        }        \r\n\r\n        if (mainObject instanceof EMFModel) {\r\n            perm = ((EMFModel) mainObject).getPermissionObject() + \"_\";\r\n        }\r\n\r\n        perm += getPermission();\r\n\r\n        org.eclipse.core.internal.expressions.ReferenceExpression referenceExpression = new org.eclipse.core.internal.expressions.ReferenceExpression(\r\n                perm);\r\n        org.eclipse.core.expressions.EvaluationResult result;\r\n        try {\r\n            result = referenceExpression.evaluate(currentState);\r\n            return org.eclipse.core.expressions.EvaluationResult.TRUE.equals(result);\r\n        } catch (org.eclipse.core.runtime.CoreException e) {\r\n            e.printStackTrace();\r\n        }\r\n\r\n        return false;'"
     * @generated
     */
    boolean isAllowed(EObject eObject, EStructuralFeature feature);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model featureDataType="com.icteam.loyalty.model.interfaces.EStructuralFeature"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='        IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);\r\n        try {\r\n            org.eclipse.swt.widgets.Event e = new org.eclipse.swt.widgets.Event();\r\n            e.data = new Object[] { eObject, feature };\r\n\r\n            ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);\r\n            Category defCategory = commandService.getCategory(null);\r\n\t     String commandId = getCommandId(eObject);\r\n\r\n            Command command = commandService.getCommand(commandId);\r\n\r\n            if (!command.isDefined()) {\r\n                command.define(commandId, LoyaltyItemProviderAdapter.getDiplayName(eObject, feature), defCategory);\r\n            }\r\n\r\n            handlerService.executeCommand(commandId, e);\r\n        } catch (org.eclipse.core.commands.ExecutionException | org.eclipse.core.commands.common.NotDefinedException\r\n                | org.eclipse.core.commands.NotEnabledException | org.eclipse.core.commands.NotHandledException e) {\r\n            throw new AppException(EStatusReason.ERROR, e);\r\n        }'"
     * @generated
     */
    void execute(EObject eObject, EStructuralFeature feature);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='        if (isGeneral()) {\r\n            return getName().toLowerCase();\r\n        }\r\n            \r\n        String commandId = \"\";\r\n\r\n        EObject mainObject = eObject;\r\n\r\n        if (eObject instanceof IContained) {\r\n            mainObject = ((IContained) eObject).getMainEObject();\r\n        }\r\n\r\n        if (mainObject instanceof EMFModel) {\r\n            commandId = ((EMFModel) mainObject).getPermissionObject() + \"_\";\r\n        }\r\n\r\n        commandId += getPermission();\r\n        \r\n        return commandId;\r\n'"
     * @generated
     */
    String getCommandId(EObject eObject);

    Action eINSTANCE = ModelInterfacesFactory.eINSTANCE.createAction();

} // Action

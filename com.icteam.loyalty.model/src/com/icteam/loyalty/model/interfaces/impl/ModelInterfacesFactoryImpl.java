/**
 */
package com.icteam.loyalty.model.interfaces.impl;

import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.metamodel.ManagedType;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.swt.graphics.Image;

import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.DistinctEMF;
import com.icteam.loyalty.model.interfaces.EDynamicFilterableEMF;
import com.icteam.loyalty.model.interfaces.EStatus;
import com.icteam.loyalty.model.interfaces.EWhereClauseEMF;
import com.icteam.loyalty.model.interfaces.EWhereTemplateClauseEMF;
import com.icteam.loyalty.model.interfaces.Language;
import com.icteam.loyalty.model.interfaces.ModelInterfacesFactory;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.interfaces.OrderDirectionEMF;
import com.icteam.loyalty.model.interfaces.Permission;
import com.icteam.loyalty.model.interfaces.Perspective;
import com.icteam.loyalty.model.interfaces.Status;
import com.icteam.loyalty.model.interfaces.StatusReason;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelInterfacesFactoryImpl extends EFactoryImpl implements ModelInterfacesFactory {

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ModelInterfacesFactory init() {
        try {
            ModelInterfacesFactory theModelInterfacesFactory = (ModelInterfacesFactory)EPackage.Registry.INSTANCE.getEFactory(ModelInterfacesPackage.eNS_URI);
            if (theModelInterfacesFactory != null) {
                return theModelInterfacesFactory;
            }
        }
        catch (Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new ModelInterfacesFactoryImpl();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModelInterfacesFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create(EClass eClass) {
        switch (eClass.getClassifierID()) {
            case ModelInterfacesPackage.PERMISSION: return createPermission();
            case ModelInterfacesPackage.STATUS: return createStatus();
            case ModelInterfacesPackage.STATUS_REASON: return createStatusReason();
            case ModelInterfacesPackage.PERSPECTIVE: return createPerspective();
            case ModelInterfacesPackage.LANGUAGE: return createLanguage();
            case ModelInterfacesPackage.ACTION: return createAction();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID()) {
            case ModelInterfacesPackage.DISTINCT_EMF:
                return createDistinctEMFFromString(eDataType, initialValue);
            case ModelInterfacesPackage.ORDER_DIRECTION_EMF:
                return createOrderDirectionEMFFromString(eDataType, initialValue);
            case ModelInterfacesPackage.EWHERE_CLAUSE_EMF:
                return createEWhereClauseEMFFromString(eDataType, initialValue);
            case ModelInterfacesPackage.EWHERE_TEMPLATE_CLAUSE_EMF:
                return createEWhereTemplateClauseEMFFromString(eDataType, initialValue);
            case ModelInterfacesPackage.EDYNAMIC_FILTERABLE_EMF:
                return createEDynamicFilterableEMFFromString(eDataType, initialValue);
            case ModelInterfacesPackage.IMAGE:
                return createImageFromString(eDataType, initialValue);
            case ModelInterfacesPackage.ESTRUCTURAL_FEATURE:
                return createEStructuralFeatureFromString(eDataType, initialValue);
            case ModelInterfacesPackage.ENTITY_MANAGER:
                return createEntityManagerFromString(eDataType, initialValue);
            case ModelInterfacesPackage.PREDICATE:
                return createPredicateFromString(eDataType, initialValue);
            case ModelInterfacesPackage.CRITERIA_BUILDER:
                return createCriteriaBuilderFromString(eDataType, initialValue);
            case ModelInterfacesPackage.CRITERIA_QUERY:
                return createCriteriaQueryFromString(eDataType, initialValue);
            case ModelInterfacesPackage.FROM:
                return createFromFromString(eDataType, initialValue);
            case ModelInterfacesPackage.MANAGED_TYPE:
                return createManagedTypeFromString(eDataType, initialValue);
            case ModelInterfacesPackage.LOCALE:
                return createLocaleFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID()) {
            case ModelInterfacesPackage.DISTINCT_EMF:
                return convertDistinctEMFToString(eDataType, instanceValue);
            case ModelInterfacesPackage.ORDER_DIRECTION_EMF:
                return convertOrderDirectionEMFToString(eDataType, instanceValue);
            case ModelInterfacesPackage.EWHERE_CLAUSE_EMF:
                return convertEWhereClauseEMFToString(eDataType, instanceValue);
            case ModelInterfacesPackage.EWHERE_TEMPLATE_CLAUSE_EMF:
                return convertEWhereTemplateClauseEMFToString(eDataType, instanceValue);
            case ModelInterfacesPackage.EDYNAMIC_FILTERABLE_EMF:
                return convertEDynamicFilterableEMFToString(eDataType, instanceValue);
            case ModelInterfacesPackage.IMAGE:
                return convertImageToString(eDataType, instanceValue);
            case ModelInterfacesPackage.ESTRUCTURAL_FEATURE:
                return convertEStructuralFeatureToString(eDataType, instanceValue);
            case ModelInterfacesPackage.ENTITY_MANAGER:
                return convertEntityManagerToString(eDataType, instanceValue);
            case ModelInterfacesPackage.PREDICATE:
                return convertPredicateToString(eDataType, instanceValue);
            case ModelInterfacesPackage.CRITERIA_BUILDER:
                return convertCriteriaBuilderToString(eDataType, instanceValue);
            case ModelInterfacesPackage.CRITERIA_QUERY:
                return convertCriteriaQueryToString(eDataType, instanceValue);
            case ModelInterfacesPackage.FROM:
                return convertFromToString(eDataType, instanceValue);
            case ModelInterfacesPackage.MANAGED_TYPE:
                return convertManagedTypeToString(eDataType, instanceValue);
            case ModelInterfacesPackage.LOCALE:
                return convertLocaleToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Permission createPermission() {
        PermissionImpl permission = new PermissionImpl();
        return permission;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Status createStatus() {
        StatusImpl status = new StatusImpl();
        return status;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public StatusReason createStatusReason() {
        StatusReasonImpl statusReason = new StatusReasonImpl();
        return statusReason;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Perspective createPerspective() {
        PerspectiveImpl perspective = new PerspectiveImpl();
        return perspective;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Language createLanguage() {
        LanguageImpl language = new LanguageImpl();
        return language;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Action createAction() {
        ActionImpl action = new ActionImpl();
        return action;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DistinctEMF createDistinctEMFFromString(EDataType eDataType, String initialValue) {
        DistinctEMF result = DistinctEMF.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertDistinctEMFToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public OrderDirectionEMF createOrderDirectionEMFFromString(EDataType eDataType, String initialValue) {
        OrderDirectionEMF result = OrderDirectionEMF.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertOrderDirectionEMFToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EWhereClauseEMF createEWhereClauseEMFFromString(EDataType eDataType, String initialValue) {
        EWhereClauseEMF result = EWhereClauseEMF.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertEWhereClauseEMFToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EWhereTemplateClauseEMF createEWhereTemplateClauseEMFFromString(EDataType eDataType, String initialValue) {
        EWhereTemplateClauseEMF result = EWhereTemplateClauseEMF.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertEWhereTemplateClauseEMFToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDynamicFilterableEMF createEDynamicFilterableEMFFromString(EDataType eDataType, String initialValue) {
        EDynamicFilterableEMF result = EDynamicFilterableEMF.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertEDynamicFilterableEMFToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public EStatus createEStatusFromString(EDataType eDataType, String initialValue) {
        return EnhancedEnum.valueOf(EStatus.class, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    public String convertEStatusToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? "" : instanceValue.toString();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Image createImageFromString(EDataType eDataType, String initialValue) {
        return (Image)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertImageToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EStructuralFeature createEStructuralFeatureFromString(EDataType eDataType, String initialValue) {
        return (EStructuralFeature)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertEStructuralFeatureToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EntityManager createEntityManagerFromString(EDataType eDataType, String initialValue) {
        return (EntityManager)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertEntityManagerToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Predicate createPredicateFromString(EDataType eDataType, String initialValue) {
        return (Predicate)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPredicateToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CriteriaBuilder createCriteriaBuilderFromString(EDataType eDataType, String initialValue) {
        return (CriteriaBuilder)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertCriteriaBuilderToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CriteriaQuery<?> createCriteriaQueryFromString(EDataType eDataType, String initialValue) {
        return (CriteriaQuery<?>)super.createFromString(initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertCriteriaQueryToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public From<?, ?> createFromFromString(EDataType eDataType, String initialValue) {
        return (From<?, ?>)super.createFromString(initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertFromToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ManagedType<?> createManagedTypeFromString(EDataType eDataType, String initialValue) {
        return (ManagedType<?>)super.createFromString(initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertManagedTypeToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Locale createLocaleFromString(EDataType eDataType, String initialValue) {
        return (Locale)super.createFromString(eDataType, initialValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertLocaleToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ModelInterfacesPackage getModelInterfacesPackage() {
        return (ModelInterfacesPackage)getEPackage();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ModelInterfacesPackage getPackage() {
        return ModelInterfacesPackage.eINSTANCE;
    }

//    private void initLazyEnums(EClass lazyEnumEClass) {
//        Field[] fields = lazyEnumEClass.getFields();
//
//        for (Field field : fields) {
//            if (Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers())) {
//                try {
//                    field.get(null);
//                    break;
//                } catch (IllegalArgumentException | IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

} //ModelInterfacesFactoryImpl

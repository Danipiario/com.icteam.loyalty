/**
 */
package com.icteam.loyalty.model.interfaces.impl;

import java.io.Serializable;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.metamodel.ManagedType;

import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.swt.graphics.Image;

import com.icteam.loyalty.api.interfaces.IConstants;
import com.icteam.loyalty.model.ModelPackage;
import com.icteam.loyalty.model.impl.ModelPackageImpl;
import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.DistinctEMF;
import com.icteam.loyalty.model.interfaces.EDynamicFilterableEMF;
import com.icteam.loyalty.model.interfaces.EWhereClauseEMF;
import com.icteam.loyalty.model.interfaces.EWhereTemplateClauseEMF;
import com.icteam.loyalty.model.interfaces.IContained;
import com.icteam.loyalty.model.interfaces.IContainedFeature;
import com.icteam.loyalty.model.interfaces.IEMFDelegant;
import com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum;
import com.icteam.loyalty.model.interfaces.IEMFModel;
import com.icteam.loyalty.model.interfaces.IEMFSelectable;
import com.icteam.loyalty.model.interfaces.IEMFTemplate;
import com.icteam.loyalty.model.interfaces.IEditable;
import com.icteam.loyalty.model.interfaces.IPerspectiveProvider;
import com.icteam.loyalty.model.interfaces.ISearchProvider;
import com.icteam.loyalty.model.interfaces.IStatusEMFTemplate;
import com.icteam.loyalty.model.interfaces.Language;
import com.icteam.loyalty.model.interfaces.ModelInterfacesFactory;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.interfaces.OrderDirectionEMF;
import com.icteam.loyalty.model.interfaces.Permission;
import com.icteam.loyalty.model.interfaces.Perspective;
import com.icteam.loyalty.model.interfaces.Status;
import com.icteam.loyalty.model.interfaces.StatusReason;
import com.icteam.loyalty.model.template.ModelTemplatePackage;
import com.icteam.loyalty.model.template.impl.ModelTemplatePackageImpl;
import com.icteam.loyalty.model.util.ModelUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelInterfacesPackageImpl extends EPackageImpl implements ModelInterfacesPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iemfModelEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iEditableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iemfEnhancedEnumEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass permissionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iemfTemplateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iPerspectiveProviderEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iStatusEMFTemplateEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iemfSelectableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass comparableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass serializableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass statusEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass statusReasonEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass perspectiveEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass languageEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass actionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass cloneableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iContainedEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iContainedFeatureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass iemfDelegantEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum distinctEMFEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum orderDirectionEMFEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum eWhereClauseEMFEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum eWhereTemplateClauseEMFEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum eDynamicFilterableEMFEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType imageEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType eStructuralFeatureEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType entityManagerEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType predicateEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType criteriaBuilderEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType criteriaQueryEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType fromEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType managedTypeEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType localeEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType iSearchProviderEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType featurePathEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ModelInterfacesPackageImpl() {
        super(eNS_URI, ModelInterfacesFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     *
     * <p>This method is used to initialize {@link ModelInterfacesPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ModelInterfacesPackage init() {
        if (isInited) {
            return (ModelInterfacesPackage) EPackage.Registry.INSTANCE.getEPackage(ModelInterfacesPackage.eNS_URI);
        }

        // Obtain or create and register package
        ModelInterfacesPackageImpl theModelInterfacesPackage = (ModelInterfacesPackageImpl) (EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ModelInterfacesPackageImpl
                ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ModelInterfacesPackageImpl());

        isInited = true;

        // Obtain or create and register interdependencies
        ModelTemplatePackageImpl theModelTemplatePackage = (ModelTemplatePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ModelTemplatePackage.eNS_URI) instanceof ModelTemplatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelTemplatePackage.eNS_URI)
                        : ModelTemplatePackage.eINSTANCE);
        ModelPackageImpl theModelPackage = (ModelPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl
                ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);

        // Create package meta-data objects
        theModelInterfacesPackage.createPackageContents();
        theModelTemplatePackage.createPackageContents();
        theModelPackage.createPackageContents();

        // Initialize created meta-data
        theModelInterfacesPackage.initializePackageContents();
        theModelTemplatePackage.initializePackageContents();
        theModelPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theModelInterfacesPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ModelInterfacesPackage.eNS_URI, theModelInterfacesPackage);
        return theModelInterfacesPackage;
    }

    @Override
    public void dispose() {
        EPackage.Registry.INSTANCE.remove(ModelInterfacesPackage.eNS_URI);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIEMFModel() {
        return iemfModelEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFModel__CopyTo__IEMFModel_boolean() {
        return iemfModelEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFModel__Equals__Object() {
        return iemfModelEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIEditable() {
        return iEditableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEditable_Editable() {
        return (EAttribute) iEditableEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEditable_Dirty() {
        return (EAttribute) iEditableEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIEMFEnhancedEnum() {
        return iemfEnhancedEnumEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFEnhancedEnum__CompareTo__IEMFEnhancedEnum() {
        return iemfEnhancedEnumEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFEnhancedEnum__GetName() {
        return iemfEnhancedEnumEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFEnhancedEnum__Equals__Object() {
        return iemfEnhancedEnumEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIEMFTemplate() {
        return iemfTemplateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_Distinct() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_MaxResults() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_OrderDirections() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_DynamicFilterFeatures() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_DynamicFilters() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_SingleResult() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_LightSearch() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_FirstResult() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_Nested() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_OrderFeatures() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_DynamicOrderFeature() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_DynamicOrderDirection() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFTemplate_DynamicFilterableFeatures() {
        return (EAttribute) iemfTemplateEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFTemplate__Initialized() {
        return iemfTemplateEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFTemplate__GetResultCount__EntityManager() {
        return iemfTemplateEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFTemplate__GetFirstResult__EntityManager() {
        return iemfTemplateEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFTemplate__GetResultList__EntityManager() {
        return iemfTemplateEClass.getEOperations().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFTemplate__HasDynamicFilters() {
        return iemfTemplateEClass.getEOperations().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFTemplate__SetDynamicFilterFeatures__EList() {
        return iemfTemplateEClass.getEOperations().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFTemplate__SetRawFilter__String() {
        return iemfTemplateEClass.getEOperations().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFTemplate__HasDynamicOrder() {
        return iemfTemplateEClass.getEOperations().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFTemplate__GetDbModelClass() {
        return iemfTemplateEClass.getEOperations().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFTemplate__GetIdValue() {
        return iemfTemplateEClass.getEOperations().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIPerspectiveProvider() {
        return iPerspectiveProviderEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getIPerspectiveProvider_DefaultPerspective() {
        return (EReference) iPerspectiveProviderEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIStatusEMFTemplate() {
        return iStatusEMFTemplateEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getIStatusEMFTemplate_Status() {
        return (EReference) iStatusEMFTemplateEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIEMFSelectable() {
        return iemfSelectableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFSelectable__GetKey() {
        return iemfSelectableEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getIEMFSelectable__GetDescription() {
        return iemfSelectableEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getComparable() {
        return comparableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getDistinctEMF() {
        return distinctEMFEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getOrderDirectionEMF() {
        return orderDirectionEMFEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getEWhereClauseEMF() {
        return eWhereClauseEMFEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getEWhereTemplateClauseEMF() {
        return eWhereTemplateClauseEMFEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getEDynamicFilterableEMF() {
        return eDynamicFilterableEMFEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getStatus() {
        return statusEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatus_ATTIVO() {
        return (EReference) statusEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatus_DISATTIVO() {
        return (EReference) statusEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getStatus_Name() {
        return (EAttribute) statusEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPerspective() {
        return perspectiveEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPerspective_ADMINISTRATION() {
        return (EReference) perspectiveEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPerspective_CONFIGURATION() {
        return (EReference) perspectiveEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPerspective_Id() {
        return (EAttribute) perspectiveEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPerspective_Name() {
        return (EAttribute) perspectiveEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getStatusReason() {
        return statusReasonEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatusReason_OK() {
        return (EReference) statusReasonEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatusReason_ERROR() {
        return (EReference) statusReasonEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatusReason_OBJECT_UNKNOWN() {
        return (EReference) statusReasonEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatusReason_MAX_LENGTH_IN_IN_CLAUSE_REACHED() {
        return (EReference) statusReasonEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatusReason_REFERENCED_OBJECT_FOUND() {
        return (EReference) statusReasonEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatusReason_CUSTOM_MESSAGE_ADD_ERROR() {
        return (EReference) statusReasonEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatusReason_DELEGATED_SERVICE_NOT_FOUND() {
        return (EReference) statusReasonEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatusReason_MIN_CHARACTER_SEARCH_LENGTH() {
        return (EReference) statusReasonEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatusReason_CRON_EXPRESSION_INVALID() {
        return (EReference) statusReasonEClass.getEStructuralFeatures().get(8);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStatusReason_SERVICE_NOT_FOUND() {
        return (EReference) statusReasonEClass.getEStructuralFeatures().get(9);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getStatusReason_Code() {
        return (EAttribute) statusReasonEClass.getEStructuralFeatures().get(10);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getStatusReason_PluginId() {
        return (EAttribute) statusReasonEClass.getEStructuralFeatures().get(11);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getStatusReason_Name() {
        return (EAttribute) statusReasonEClass.getEStructuralFeatures().get(12);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getLanguage() {
        return languageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getLanguage_ITALIAN() {
        return (EReference) languageEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getLanguage_ENGLISH() {
        return (EReference) languageEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLanguage_DefaultLanguage() {
        return (EAttribute) languageEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLanguage_Locale() {
        return (EAttribute) languageEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getLanguage_Name() {
        return (EAttribute) languageEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAction() {
        return actionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAction_Name() {
        return (EAttribute) actionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAction_IconPath() {
        return (EAttribute) actionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAction_Permission() {
        return (EAttribute) actionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAction_General() {
        return (EAttribute) actionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getAction__IsAllowed__EObject_EStructuralFeature() {
        return actionEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getAction__Execute__EObject_EStructuralFeature() {
        return actionEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getAction__GetCommandId__EObject() {
        return actionEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getCloneable() {
        return cloneableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIContained() {
        return iContainedEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getIContained_MainEObject() {
        return (EReference) iContainedEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIContainedFeature() {
        return iContainedFeatureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIContainedFeature_MainFeature() {
        return (EAttribute) iContainedFeatureEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIEMFDelegant() {
        return iemfDelegantEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getIEMFDelegant_DelegatedId() {
        return (EAttribute) iemfDelegantEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getImage() {
        return imageEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getEStructuralFeature() {
        return eStructuralFeatureEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getEntityManager() {
        return entityManagerEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getSerializable() {
        return serializableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPermission() {
        return permissionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPermission_ADMINISTRATION_PERSPECTIVE_VIEW() {
        return (EReference) permissionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getPermission_CONFIGURATION_PERSPECTIVE_VIEW() {
        return (EReference) permissionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPermission_Object() {
        return (EAttribute) permissionEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPermission_Action() {
        return (EAttribute) permissionEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getPermission_Name() {
        return (EAttribute) permissionEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPermission__IsStarPermission() {
        return permissionEClass.getEOperations().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPermission__GetPermission() {
        return permissionEClass.getEOperations().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getPermission__GetPermissions() {
        return permissionEClass.getEOperations().get(2);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getPredicate() {
        return predicateEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getCriteriaBuilder() {
        return criteriaBuilderEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getCriteriaQuery() {
        return criteriaQueryEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getFrom() {
        return fromEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getManagedType() {
        return managedTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getLocale() {
        return localeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getISearchProvider() {
        return iSearchProviderEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EDataType getFeaturePath() {
        return featurePathEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ModelInterfacesFactory getModelInterfacesFactory() {
        return (ModelInterfacesFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) {
            return;
        }
        isCreated = true;

        // Create classes and their features
        iemfModelEClass = createEClass(IEMF_MODEL);
        createEOperation(iemfModelEClass, IEMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN);
        createEOperation(iemfModelEClass, IEMF_MODEL___EQUALS__OBJECT);

        iEditableEClass = createEClass(IEDITABLE);
        createEAttribute(iEditableEClass, IEDITABLE__EDITABLE);
        createEAttribute(iEditableEClass, IEDITABLE__DIRTY);

        iemfEnhancedEnumEClass = createEClass(IEMF_ENHANCED_ENUM);
        createEOperation(iemfEnhancedEnumEClass, IEMF_ENHANCED_ENUM___COMPARE_TO__IEMFENHANCEDENUM);
        createEOperation(iemfEnhancedEnumEClass, IEMF_ENHANCED_ENUM___GET_NAME);
        createEOperation(iemfEnhancedEnumEClass, IEMF_ENHANCED_ENUM___EQUALS__OBJECT);

        permissionEClass = createEClass(PERMISSION);
        createEReference(permissionEClass, PERMISSION__ADMINISTRATION_PERSPECTIVE_VIEW);
        createEReference(permissionEClass, PERMISSION__CONFIGURATION_PERSPECTIVE_VIEW);
        createEAttribute(permissionEClass, PERMISSION__OBJECT);
        createEAttribute(permissionEClass, PERMISSION__ACTION);
        createEAttribute(permissionEClass, PERMISSION__NAME);
        createEOperation(permissionEClass, PERMISSION___IS_STAR_PERMISSION);
        createEOperation(permissionEClass, PERMISSION___GET_PERMISSION);
        createEOperation(permissionEClass, PERMISSION___GET_PERMISSIONS);

        iemfTemplateEClass = createEClass(IEMF_TEMPLATE);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__DISTINCT);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__FIRST_RESULT);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__MAX_RESULTS);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__SINGLE_RESULT);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__LIGHT_SEARCH);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__NESTED);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__ORDER_FEATURES);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__ORDER_DIRECTIONS);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__DYNAMIC_FILTER_FEATURES);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__DYNAMIC_FILTERS);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__DYNAMIC_ORDER_FEATURE);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION);
        createEAttribute(iemfTemplateEClass, IEMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES);
        createEOperation(iemfTemplateEClass, IEMF_TEMPLATE___INITIALIZED);
        createEOperation(iemfTemplateEClass, IEMF_TEMPLATE___GET_RESULT_COUNT__ENTITYMANAGER);
        createEOperation(iemfTemplateEClass, IEMF_TEMPLATE___GET_FIRST_RESULT__ENTITYMANAGER);
        createEOperation(iemfTemplateEClass, IEMF_TEMPLATE___GET_RESULT_LIST__ENTITYMANAGER);
        createEOperation(iemfTemplateEClass, IEMF_TEMPLATE___HAS_DYNAMIC_FILTERS);
        createEOperation(iemfTemplateEClass, IEMF_TEMPLATE___SET_DYNAMIC_FILTER_FEATURES__ELIST);
        createEOperation(iemfTemplateEClass, IEMF_TEMPLATE___SET_RAW_FILTER__STRING);
        createEOperation(iemfTemplateEClass, IEMF_TEMPLATE___HAS_DYNAMIC_ORDER);
        createEOperation(iemfTemplateEClass, IEMF_TEMPLATE___GET_DB_MODEL_CLASS);
        createEOperation(iemfTemplateEClass, IEMF_TEMPLATE___GET_ID_VALUE);

        iPerspectiveProviderEClass = createEClass(IPERSPECTIVE_PROVIDER);
        createEReference(iPerspectiveProviderEClass, IPERSPECTIVE_PROVIDER__DEFAULT_PERSPECTIVE);

        iStatusEMFTemplateEClass = createEClass(ISTATUS_EMF_TEMPLATE);
        createEReference(iStatusEMFTemplateEClass, ISTATUS_EMF_TEMPLATE__STATUS);

        iemfSelectableEClass = createEClass(IEMF_SELECTABLE);
        createEOperation(iemfSelectableEClass, IEMF_SELECTABLE___GET_KEY);
        createEOperation(iemfSelectableEClass, IEMF_SELECTABLE___GET_DESCRIPTION);

        comparableEClass = createEClass(COMPARABLE);

        serializableEClass = createEClass(SERIALIZABLE);

        statusEClass = createEClass(STATUS);
        createEReference(statusEClass, STATUS__ATTIVO);
        createEReference(statusEClass, STATUS__DISATTIVO);
        createEAttribute(statusEClass, STATUS__NAME);

        statusReasonEClass = createEClass(STATUS_REASON);
        createEReference(statusReasonEClass, STATUS_REASON__OK);
        createEReference(statusReasonEClass, STATUS_REASON__ERROR);
        createEReference(statusReasonEClass, STATUS_REASON__OBJECT_UNKNOWN);
        createEReference(statusReasonEClass, STATUS_REASON__MAX_LENGTH_IN_IN_CLAUSE_REACHED);
        createEReference(statusReasonEClass, STATUS_REASON__REFERENCED_OBJECT_FOUND);
        createEReference(statusReasonEClass, STATUS_REASON__CUSTOM_MESSAGE_ADD_ERROR);
        createEReference(statusReasonEClass, STATUS_REASON__DELEGATED_SERVICE_NOT_FOUND);
        createEReference(statusReasonEClass, STATUS_REASON__MIN_CHARACTER_SEARCH_LENGTH);
        createEReference(statusReasonEClass, STATUS_REASON__CRON_EXPRESSION_INVALID);
        createEReference(statusReasonEClass, STATUS_REASON__SERVICE_NOT_FOUND);
        createEAttribute(statusReasonEClass, STATUS_REASON__CODE);
        createEAttribute(statusReasonEClass, STATUS_REASON__PLUGIN_ID);
        createEAttribute(statusReasonEClass, STATUS_REASON__NAME);

        perspectiveEClass = createEClass(PERSPECTIVE);
        createEReference(perspectiveEClass, PERSPECTIVE__ADMINISTRATION);
        createEReference(perspectiveEClass, PERSPECTIVE__CONFIGURATION);
        createEAttribute(perspectiveEClass, PERSPECTIVE__ID);
        createEAttribute(perspectiveEClass, PERSPECTIVE__NAME);

        languageEClass = createEClass(LANGUAGE);
        createEReference(languageEClass, LANGUAGE__ITALIAN);
        createEReference(languageEClass, LANGUAGE__ENGLISH);
        createEAttribute(languageEClass, LANGUAGE__DEFAULT_LANGUAGE);
        createEAttribute(languageEClass, LANGUAGE__LOCALE);
        createEAttribute(languageEClass, LANGUAGE__NAME);

        actionEClass = createEClass(ACTION);
        createEAttribute(actionEClass, ACTION__NAME);
        createEAttribute(actionEClass, ACTION__ICON_PATH);
        createEAttribute(actionEClass, ACTION__PERMISSION);
        createEAttribute(actionEClass, ACTION__GENERAL);
        createEOperation(actionEClass, ACTION___IS_ALLOWED__EOBJECT_ESTRUCTURALFEATURE);
        createEOperation(actionEClass, ACTION___EXECUTE__EOBJECT_ESTRUCTURALFEATURE);
        createEOperation(actionEClass, ACTION___GET_COMMAND_ID__EOBJECT);

        cloneableEClass = createEClass(CLONEABLE);

        iContainedEClass = createEClass(ICONTAINED);
        createEReference(iContainedEClass, ICONTAINED__MAIN_EOBJECT);

        iContainedFeatureEClass = createEClass(ICONTAINED_FEATURE);
        createEAttribute(iContainedFeatureEClass, ICONTAINED_FEATURE__MAIN_FEATURE);

        iemfDelegantEClass = createEClass(IEMF_DELEGANT);
        createEAttribute(iemfDelegantEClass, IEMF_DELEGANT__DELEGATED_ID);

        // Create enums
        distinctEMFEEnum = createEEnum(DISTINCT_EMF);
        orderDirectionEMFEEnum = createEEnum(ORDER_DIRECTION_EMF);
        eWhereClauseEMFEEnum = createEEnum(EWHERE_CLAUSE_EMF);
        eWhereTemplateClauseEMFEEnum = createEEnum(EWHERE_TEMPLATE_CLAUSE_EMF);
        eDynamicFilterableEMFEEnum = createEEnum(EDYNAMIC_FILTERABLE_EMF);

        // Create data types
        imageEDataType = createEDataType(IMAGE);
        eStructuralFeatureEDataType = createEDataType(ESTRUCTURAL_FEATURE);
        entityManagerEDataType = createEDataType(ENTITY_MANAGER);
        predicateEDataType = createEDataType(PREDICATE);
        criteriaBuilderEDataType = createEDataType(CRITERIA_BUILDER);
        criteriaQueryEDataType = createEDataType(CRITERIA_QUERY);
        fromEDataType = createEDataType(FROM);
        managedTypeEDataType = createEDataType(MANAGED_TYPE);
        localeEDataType = createEDataType(LOCALE);
        iSearchProviderEDataType = createEDataType(ISEARCH_PROVIDER);
        featurePathEDataType = createEDataType(FEATURE_PATH);
    }

    @Override
    public void freeze() {
        super.freeze();

        ModelUtil.registerEnhancedEnum(new LanguageImpl(getLanguage_ITALIAN().getName(), Locale.ITALY, true), Language.class);
        ModelUtil.registerEnhancedEnum(new LanguageImpl(getLanguage_ENGLISH().getName(), Locale.UK, false), Language.class);

        ModelUtil.registerEnhancedEnum(new StatusImpl(getStatus_ATTIVO().getName()), Status.class);
        ModelUtil.registerEnhancedEnum(new StatusImpl(getStatus_DISATTIVO().getName()), Status.class);

        ModelUtil.registerEnhancedEnum(new PerspectiveImpl(getPerspective_ADMINISTRATION().getName(), "administration_perspective"), Perspective.class);
        ModelUtil.registerEnhancedEnum(new PerspectiveImpl(getPerspective_CONFIGURATION().getName(), "configuration_perspective"), Perspective.class);

        ModelUtil.registerEnhancedEnum(new PermissionImpl(getPermission_ADMINISTRATION_PERSPECTIVE_VIEW().getName(), Permission.OBJECT_ADMINISTRATION_PERSPECTIVE, IConstants.VIEW),
                Permission.class);
        ModelUtil.registerEnhancedEnum(new PermissionImpl(getPermission_CONFIGURATION_PERSPECTIVE_VIEW().getName(), Permission.OBJECT_CONFIGURATION_PERSPECTIVE, IConstants.VIEW),
                Permission.class);

        ModelUtil.registerEnhancedEnum(new StatusReasonImpl(getStatusReason_OK().getName(), 0), StatusReason.class);
        ModelUtil.registerEnhancedEnum(new StatusReasonImpl(getStatusReason_ERROR().getName(), 1), StatusReason.class);
        ModelUtil.registerEnhancedEnum(new StatusReasonImpl(getStatusReason_OBJECT_UNKNOWN().getName(), 2), StatusReason.class);
        ModelUtil.registerEnhancedEnum(new StatusReasonImpl(getStatusReason_MAX_LENGTH_IN_IN_CLAUSE_REACHED().getName(), 3), StatusReason.class);
        ModelUtil.registerEnhancedEnum(new StatusReasonImpl(getStatusReason_REFERENCED_OBJECT_FOUND().getName(), 4), StatusReason.class);
        ModelUtil.registerEnhancedEnum(new StatusReasonImpl(getStatusReason_CUSTOM_MESSAGE_ADD_ERROR().getName(), 5), StatusReason.class);
        ModelUtil.registerEnhancedEnum(new StatusReasonImpl(getStatusReason_DELEGATED_SERVICE_NOT_FOUND().getName(), 6), StatusReason.class);
        ModelUtil.registerEnhancedEnum(new StatusReasonImpl(getStatusReason_MIN_CHARACTER_SEARCH_LENGTH().getName(), 7), StatusReason.class);
        ModelUtil.registerEnhancedEnum(new StatusReasonImpl(getStatusReason_CRON_EXPRESSION_INVALID().getName(), 8), StatusReason.class);
        ModelUtil.registerEnhancedEnum(new StatusReasonImpl(getStatusReason_SERVICE_NOT_FOUND().getName(), 9), StatusReason.class);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) {
            return;
        }
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Create type parameters
        ETypeParameter iemfEnhancedEnumEClass_E = addETypeParameter(iemfEnhancedEnumEClass, "E");
        ETypeParameter iemfTemplateEClass_T = addETypeParameter(iemfTemplateEClass, "T");
        ETypeParameter iemfSelectableEClass_S = addETypeParameter(iemfSelectableEClass, "S");
        addETypeParameter(comparableEClass, "T");
        addETypeParameter(criteriaQueryEDataType, "T");
        addETypeParameter(fromEDataType, "Z");
        addETypeParameter(fromEDataType, "X");
        addETypeParameter(managedTypeEDataType, "X");

        // Set bounds for type parameters
        EGenericType g1 = createEGenericType(this.getIEMFEnhancedEnum());
        EGenericType g2 = createEGenericType(iemfEnhancedEnumEClass_E);
        g1.getETypeArguments().add(g2);
        iemfEnhancedEnumEClass_E.getEBounds().add(g1);
        g1 = createEGenericType(this.getSerializable());
        iemfTemplateEClass_T.getEBounds().add(g1);
        g1 = createEGenericType(this.getSerializable());
        iemfSelectableEClass_S.getEBounds().add(g1);

        // Add supertypes to classes
        iemfModelEClass.getESuperTypes().add(this.getIEditable());
        g1 = createEGenericType(this.getComparable());
        g2 = createEGenericType(iemfEnhancedEnumEClass_E);
        g1.getETypeArguments().add(g2);
        iemfEnhancedEnumEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getSerializable());
        iemfEnhancedEnumEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getCloneable());
        iemfEnhancedEnumEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getIEMFEnhancedEnum());
        g2 = createEGenericType(this.getPermission());
        g1.getETypeArguments().add(g2);
        permissionEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getIEMFEnhancedEnum());
        g2 = createEGenericType(this.getStatus());
        g1.getETypeArguments().add(g2);
        statusEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getIEMFEnhancedEnum());
        g2 = createEGenericType(this.getStatusReason());
        g1.getETypeArguments().add(g2);
        statusReasonEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getIEMFEnhancedEnum());
        g2 = createEGenericType(this.getPerspective());
        g1.getETypeArguments().add(g2);
        perspectiveEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getIEMFEnhancedEnum());
        g2 = createEGenericType(this.getLanguage());
        g1.getETypeArguments().add(g2);
        languageEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getIEMFEnhancedEnum());
        g2 = createEGenericType(this.getAction());
        g1.getETypeArguments().add(g2);
        actionEClass.getEGenericSuperTypes().add(g1);
        g1 = createEGenericType(this.getIEditable());
        actionEClass.getEGenericSuperTypes().add(g1);
        iContainedFeatureEClass.getESuperTypes().add(this.getIContained());

        // Initialize classes, features, and operations; add parameters
        initEClass(iemfModelEClass, IEMFModel.class, "IEMFModel", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        EOperation op = initEOperation(getIEMFModel__CopyTo__IEMFModel_boolean(), null, "copyTo", 0, 1, IS_UNIQUE, IS_ORDERED);
        ETypeParameter t1 = addETypeParameter(op, "C");
        g1 = createEGenericType(this.getIEMFModel());
        t1.getEBounds().add(g1);
        g1 = createEGenericType(t1);
        addEParameter(op, g1, "destModel", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEBoolean(), "deliver", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getIEMFModel__Equals__Object(), ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEJavaObject(), "obj", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(iEditableEClass, IEditable.class, "IEditable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIEditable_Editable(), ecorePackage.getEBoolean(), "editable", "true", 0, 1, IEditable.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEditable_Dirty(), ecorePackage.getEBoolean(), "dirty", "false", 0, 1, IEditable.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(iemfEnhancedEnumEClass, IEMFEnhancedEnum.class, "IEMFEnhancedEnum", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        op = initEOperation(getIEMFEnhancedEnum__CompareTo__IEMFEnhancedEnum(), ecorePackage.getEInt(), "compareTo", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(iemfEnhancedEnumEClass_E);
        addEParameter(op, g1, "o", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEOperation(getIEMFEnhancedEnum__GetName(), ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getIEMFEnhancedEnum__Equals__Object(), ecorePackage.getEBoolean(), "equals", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEJavaObject(), "obj", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(permissionEClass, Permission.class, "Permission", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPermission_ADMINISTRATION_PERSPECTIVE_VIEW(), this.getPermission(), null, "ADMINISTRATION_PERSPECTIVE_VIEW", null, 0, 1, Permission.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPermission_CONFIGURATION_PERSPECTIVE_VIEW(), this.getPermission(), null, "CONFIGURATION_PERSPECTIVE_VIEW", null, 0, 1, Permission.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPermission_Object(), ecorePackage.getEString(), "object", null, 1, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPermission_Action(), ecorePackage.getEString(), "action", "", 1, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPermission_Name(), ecorePackage.getEString(), "name", null, 1, 1, Permission.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getPermission__IsStarPermission(), ecorePackage.getEBoolean(), "isStarPermission", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEOperation(getPermission__GetPermission(), ecorePackage.getEString(), "getPermission", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEOperation(getPermission__GetPermissions(), this.getPermission(), "getPermissions", 0, -1, IS_UNIQUE, IS_ORDERED);

        initEClass(iemfTemplateEClass, IEMFTemplate.class, "IEMFTemplate", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIEMFTemplate_Distinct(), this.getDistinctEMF(), "distinct", "SQL", 1, 1, IEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEMFTemplate_FirstResult(), ecorePackage.getEInt(), "firstResult", "-1", 0, 1, IEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEMFTemplate_MaxResults(), ecorePackage.getEInt(), "maxResults", "-1", 0, 1, IEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEMFTemplate_SingleResult(), ecorePackage.getEBoolean(), "singleResult", "false", 0, 1, IEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEMFTemplate_LightSearch(), ecorePackage.getEBoolean(), "lightSearch", "false", 0, 1, IEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEMFTemplate_Nested(), ecorePackage.getEBoolean(), "nested", "false", 0, 1, IEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEMFTemplate_OrderFeatures(), this.getFeaturePath(), "orderFeatures", null, 0, -1, IEMFTemplate.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEMFTemplate_OrderDirections(), this.getOrderDirectionEMF(), "orderDirections", null, 0, -1, IEMFTemplate.class, IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEMFTemplate_DynamicFilterFeatures(), this.getEStructuralFeature(), "dynamicFilterFeatures", null, 0, -1, IEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEMFTemplate_DynamicFilters(), ecorePackage.getEString(), "dynamicFilters", null, 0, -1, IEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEMFTemplate_DynamicOrderFeature(), this.getFeaturePath(), "dynamicOrderFeature", null, 0, 1, IEMFTemplate.class, IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEMFTemplate_DynamicOrderDirection(), this.getOrderDirectionEMF(), "dynamicOrderDirection", null, 0, 1, IEMFTemplate.class, IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getIEMFTemplate_DynamicFilterableFeatures(), this.getEStructuralFeature(), "dynamicFilterableFeatures", null, 0, -1, IEMFTemplate.class, IS_TRANSIENT,
                !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEOperation(getIEMFTemplate__Initialized(), ecorePackage.getEBoolean(), "initialized", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getIEMFTemplate__GetResultCount__EntityManager(), ecorePackage.getELongObject(), "getResultCount", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getEntityManager(), "em", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getIEMFTemplate__GetFirstResult__EntityManager(), null, "getFirstResult", 0, 1, IS_UNIQUE, IS_ORDERED);
        t1 = addETypeParameter(op, "R");
        addEParameter(op, this.getEntityManager(), "em", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(t1);
        initEOperation(op, g1);

        op = initEOperation(getIEMFTemplate__GetResultList__EntityManager(), null, "getResultList", 0, -1, IS_UNIQUE, IS_ORDERED);
        t1 = addETypeParameter(op, "R");
        addEParameter(op, this.getEntityManager(), "em", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(t1);
        initEOperation(op, g1);

        initEOperation(getIEMFTemplate__HasDynamicFilters(), ecorePackage.getEBoolean(), "hasDynamicFilters", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getIEMFTemplate__SetDynamicFilterFeatures__EList(), null, "setDynamicFilterFeatures", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getEStructuralFeature(), "dynamicFilterFeatures", 0, -1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getIEMFTemplate__SetRawFilter__String(), null, "setRawFilter", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEString(), "rawFilter", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEOperation(getIEMFTemplate__HasDynamicOrder(), ecorePackage.getEBoolean(), "hasDynamicOrder", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getIEMFTemplate__GetDbModelClass(), null, "getDbModelClass", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(ecorePackage.getEJavaClass());
        g2 = createEGenericType(iemfTemplateEClass_T);
        g1.getETypeArguments().add(g2);
        initEOperation(op, g1);

        initEOperation(getIEMFTemplate__GetIdValue(), ecorePackage.getEJavaObject(), "getIdValue", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(iPerspectiveProviderEClass, IPerspectiveProvider.class, "IPerspectiveProvider", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getIPerspectiveProvider_DefaultPerspective(), this.getPerspective(), null, "defaultPerspective", null, 1, 1, IPerspectiveProvider.class, !IS_TRANSIENT,
                !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(iStatusEMFTemplateEClass, IStatusEMFTemplate.class, "IStatusEMFTemplate", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getIStatusEMFTemplate_Status(), this.getStatus(), null, "status", null, 0, 1, IStatusEMFTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(iemfSelectableEClass, IEMFSelectable.class, "IEMFSelectable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        op = initEOperation(getIEMFSelectable__GetKey(), null, "getKey", 0, 1, IS_UNIQUE, IS_ORDERED);
        g1 = createEGenericType(iemfSelectableEClass_S);
        initEOperation(op, g1);

        initEOperation(getIEMFSelectable__GetDescription(), ecorePackage.getEString(), "getDescription", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(comparableEClass, Comparable.class, "Comparable", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        initEClass(serializableEClass, Serializable.class, "Serializable", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        initEClass(statusEClass, Status.class, "Status", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getStatus_ATTIVO(), this.getStatus(), null, "ATTIVO", null, 0, 1, Status.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStatus_DISATTIVO(), this.getStatus(), null, "DISATTIVO", null, 0, 1, Status.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getStatus_Name(), ecorePackage.getEString(), "name", null, 1, 1, Status.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);

        initEClass(statusReasonEClass, StatusReason.class, "StatusReason", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getStatusReason_OK(), this.getStatusReason(), null, "OK", null, 0, 1, StatusReason.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStatusReason_ERROR(), this.getStatusReason(), null, "ERROR", null, 0, 1, StatusReason.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStatusReason_OBJECT_UNKNOWN(), this.getStatusReason(), null, "OBJECT_UNKNOWN", null, 0, 1, StatusReason.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStatusReason_MAX_LENGTH_IN_IN_CLAUSE_REACHED(), this.getStatusReason(), null, "MAX_LENGTH_IN_IN_CLAUSE_REACHED", null, 0, 1, StatusReason.class,
                IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStatusReason_REFERENCED_OBJECT_FOUND(), this.getStatusReason(), null, "REFERENCED_OBJECT_FOUND", null, 0, 1, StatusReason.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStatusReason_CUSTOM_MESSAGE_ADD_ERROR(), this.getStatusReason(), null, "CUSTOM_MESSAGE_ADD_ERROR", null, 0, 1, StatusReason.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStatusReason_DELEGATED_SERVICE_NOT_FOUND(), this.getStatusReason(), null, "DELEGATED_SERVICE_NOT_FOUND", null, 0, 1, StatusReason.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStatusReason_MIN_CHARACTER_SEARCH_LENGTH(), this.getStatusReason(), null, "MIN_CHARACTER_SEARCH_LENGTH", null, 0, 1, StatusReason.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStatusReason_CRON_EXPRESSION_INVALID(), this.getStatusReason(), null, "CRON_EXPRESSION_INVALID", null, 0, 1, StatusReason.class, IS_TRANSIENT,
                IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getStatusReason_SERVICE_NOT_FOUND(), this.getStatusReason(), null, "SERVICE_NOT_FOUND", null, 0, 1, StatusReason.class, IS_TRANSIENT, IS_VOLATILE,
                !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getStatusReason_Code(), ecorePackage.getEInt(), "code", null, 1, 1, StatusReason.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getStatusReason_PluginId(), ecorePackage.getEString(), "pluginId", "", 0, 1, StatusReason.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getStatusReason_Name(), ecorePackage.getEString(), "name", null, 1, 1, StatusReason.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE,
                IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(perspectiveEClass, Perspective.class, "Perspective", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPerspective_ADMINISTRATION(), this.getPerspective(), null, "ADMINISTRATION", null, 0, 1, Perspective.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getPerspective_CONFIGURATION(), this.getPerspective(), null, "CONFIGURATION", null, 0, 1, Perspective.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPerspective_Id(), ecorePackage.getEString(), "id", null, 0, 1, Perspective.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getPerspective_Name(), ecorePackage.getEString(), "name", null, 1, 1, Perspective.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(languageEClass, Language.class, "Language", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLanguage_ITALIAN(), this.getLanguage(), null, "ITALIAN", null, 0, 1, Language.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getLanguage_ENGLISH(), this.getLanguage(), null, "ENGLISH", null, 0, 1, Language.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLanguage_DefaultLanguage(), ecorePackage.getEBoolean(), "defaultLanguage", null, 1, 1, Language.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLanguage_Locale(), this.getLocale(), "locale", null, 1, 1, Language.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getLanguage_Name(), ecorePackage.getEString(), "name", null, 1, 1, Language.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAction_Name(), ecorePackage.getEString(), "name", null, 1, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE,
                !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAction_IconPath(), ecorePackage.getEString(), "iconPath", null, 1, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAction_Permission(), ecorePackage.getEString(), "permission", "", 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getAction_General(), ecorePackage.getEBoolean(), "general", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        op = initEOperation(getAction__IsAllowed__EObject_EStructuralFeature(), ecorePackage.getEBoolean(), "isAllowed", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEObject(), "eObject", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getEStructuralFeature(), "feature", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getAction__Execute__EObject_EStructuralFeature(), null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEObject(), "eObject", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, this.getEStructuralFeature(), "feature", 0, 1, IS_UNIQUE, IS_ORDERED);

        op = initEOperation(getAction__GetCommandId__EObject(), ecorePackage.getEString(), "getCommandId", 0, 1, IS_UNIQUE, IS_ORDERED);
        addEParameter(op, ecorePackage.getEObject(), "eObject", 0, 1, IS_UNIQUE, IS_ORDERED);

        initEClass(cloneableEClass, Cloneable.class, "Cloneable", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

        initEClass(iContainedEClass, IContained.class, "IContained", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getIContained_MainEObject(), ecorePackage.getEObject(), null, "mainEObject", null, 0, 1, IContained.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(iContainedFeatureEClass, IContainedFeature.class, "IContainedFeature", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIContainedFeature_MainFeature(), this.getEStructuralFeature(), "mainFeature", null, 0, 1, IContainedFeature.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(iemfDelegantEClass, IEMFDelegant.class, "IEMFDelegant", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getIEMFDelegant_DelegatedId(), ecorePackage.getEString(), "delegatedId", "false", 0, 1, IEMFDelegant.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Initialize enums and add enum literals
        initEEnum(distinctEMFEEnum, DistinctEMF.class, "DistinctEMF");
        addEEnumLiteral(distinctEMFEEnum, DistinctEMF.SQL);
        addEEnumLiteral(distinctEMFEEnum, DistinctEMF.CODE);
        addEEnumLiteral(distinctEMFEEnum, DistinctEMF.NONE);

        initEEnum(orderDirectionEMFEEnum, OrderDirectionEMF.class, "OrderDirectionEMF");
        addEEnumLiteral(orderDirectionEMFEEnum, OrderDirectionEMF.NONE);
        addEEnumLiteral(orderDirectionEMFEEnum, OrderDirectionEMF.ASC);
        addEEnumLiteral(orderDirectionEMFEEnum, OrderDirectionEMF.DESC);

        initEEnum(eWhereClauseEMFEEnum, EWhereClauseEMF.class, "EWhereClauseEMF");
        addEEnumLiteral(eWhereClauseEMFEEnum, EWhereClauseEMF.EQUAL);
        addEEnumLiteral(eWhereClauseEMFEEnum, EWhereClauseEMF.LIKE_IGNORE_CASE);
        addEEnumLiteral(eWhereClauseEMFEEnum, EWhereClauseEMF.GREATER_EQUAL);
        addEEnumLiteral(eWhereClauseEMFEEnum, EWhereClauseEMF.I18N);
        addEEnumLiteral(eWhereClauseEMFEEnum, EWhereClauseEMF.NONE);
        addEEnumLiteral(eWhereClauseEMFEEnum, EWhereClauseEMF.ENUM);

        initEEnum(eWhereTemplateClauseEMFEEnum, EWhereTemplateClauseEMF.class, "EWhereTemplateClauseEMF");
        addEEnumLiteral(eWhereTemplateClauseEMFEEnum, EWhereTemplateClauseEMF.EQUAL);

        initEEnum(eDynamicFilterableEMFEEnum, EDynamicFilterableEMF.class, "EDynamicFilterableEMF");
        addEEnumLiteral(eDynamicFilterableEMFEEnum, EDynamicFilterableEMF.NO);
        addEEnumLiteral(eDynamicFilterableEMFEEnum, EDynamicFilterableEMF.FILTER);
        addEEnumLiteral(eDynamicFilterableEMFEEnum, EDynamicFilterableEMF.DEFAULT_FILTER);

        // Initialize data types
        initEDataType(imageEDataType, Image.class, "Image", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(eStructuralFeatureEDataType, EStructuralFeature.class, "EStructuralFeature", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(entityManagerEDataType, EntityManager.class, "EntityManager", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(predicateEDataType, Predicate.class, "Predicate", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(criteriaBuilderEDataType, CriteriaBuilder.class, "CriteriaBuilder", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(criteriaQueryEDataType, CriteriaQuery.class, "CriteriaQuery", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(fromEDataType, From.class, "From", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(managedTypeEDataType, ManagedType.class, "ManagedType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(localeEDataType, Locale.class, "Locale", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(iSearchProviderEDataType, ISearchProvider.class, "ISearchProvider", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
        initEDataType(featurePathEDataType, FeaturePath.class, "FeaturePath", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

        // Create resource
        createResource(eNS_URI);

        // Create annotations
        // http://www.eclipse.org/emf/2002/GenModel
        createGenModelAnnotations();
        // http://com.icteam.loyalty/property
        createPropertyAnnotations();
        // http://com.icteam.loyalty/where
        createWhereAnnotations();
    }

    /**
     * Initializes the annotations for <b>http://com.icteam.loyalty/property</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createPropertyAnnotations() {
        String source = "http://com.icteam.loyalty/property";
        addAnnotation(getIEditable_Editable(), source, new String[] { "showAsColumn", "false" });
        addAnnotation(getIEditable_Dirty(), source, new String[] { "showAsColumn", "false" });
        addAnnotation(getPermission_Object(), source, new String[] { "showAsColumn", "false" });
        addAnnotation(getPermission_Action(), source, new String[] { "showAsColumn", "false" });
        addAnnotation(getIEMFDelegant_DelegatedId(), source, new String[] { "showAsColumn", "false" });
    }

    /**
     * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/GenModel</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createGenModelAnnotations() {
        String source = "http://www.eclipse.org/emf/2002/GenModel";
        addAnnotation(getIEMFModel__CopyTo__IEMFModel_boolean(), source, new String[] { "body",
                "        if (!deliver) {\r\n            destModel.eSetDeliver(false);\r\n        }\r\n\r\n        for (EStructuralFeature feature : eClass().getEAllStructuralFeatures()) {\r\n            if (feature.isChangeable()) {\r\n                Boolean copy = (Boolean) ModelUtil.getAnnotation(feature, com.icteam.loyalty.model.interfaces.EAnnotation.COPY);\r\n\r\n                if (copy) {\r\n                    destModel.eSet(feature, eGet(feature));\r\n                }\r\n            }\r\n        }\r\n\r\n        destModel.setDirty(isDirty());\r\n\r\n        if (!deliver) {\r\n            destModel.eSetDeliver(true);\r\n        }" });
        addAnnotation(getIEMFModel__Equals__Object(), source, new String[] { "body", "return ModelUtil.equals(this, obj);" });
        addAnnotation(getIEMFEnhancedEnum__CompareTo__IEMFEnhancedEnum(), source, new String[] { "body", "return getName().compareTo(o.getName());" });
        addAnnotation(getIEMFEnhancedEnum__Equals__Object(), source, new String[] { "body", "return ModelUtil.equals(this, obj);" });
        addAnnotation(getPermission__IsStarPermission(), source, new String[] { "body", "return IConstants.STAR.equals(getAction());" });
        addAnnotation(getPermission__GetPermission(), source, new String[] { "body", "return getObject() + IConstants.UNDERSCORE + getAction();" });
        addAnnotation(getPermission__GetPermissions(), source, new String[] { "body",
                "return new BasicEList<>(CollectionUtils.select(ModelUtil.values(Permission.class), new BeanPropertyValueEqualsPredicate(\"object\", getObject())));" });
        addAnnotation(getIEMFTemplate__HasDynamicFilters(), source, new String[] { "body", "return !dynamicFilterFeatures.isEmpty() && !dynamicFilters.isEmpty();" });
        addAnnotation(getIEMFTemplate__SetDynamicFilterFeatures__EList(), source, new String[] { "body",
                "       checkDynamicFilters(dynamicFilterFeatures, getDynamicFilters());\r\n\r\n       eSet(ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTER_FEATURES, dynamicFilterFeatures);\r\n" });
        addAnnotation(getIEMFTemplate__SetRawFilter__String(), source, new String[] { "body",
                "        BasicEList<String> filterList = ECollections.newBasicEList(StringUtils.stripAll(StringUtils.split(StringUtils.defaultString(rawFilter))));\r\n\r\n        checkDynamicFilters(getDynamicFilterFeatures(), filterList);\r\n\r\n        eSet(ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERS, filterList);\r\n" });
        addAnnotation(getIEMFTemplate__HasDynamicOrder(), source,
                new String[] { "body", "return dynamicOrderDirection != null && !OrderDirectionEMF.NONE.equals(dynamicOrderDirection);" });
        addAnnotation(getIEMFTemplate__GetDbModelClass(), source, new String[] { "body", "return  (Class<T>) ModelUtil.getAnnotation(eClass(), EAnnotation.DB_MODEL);" });
        addAnnotation(getIEMFTemplate__GetIdValue(), source, new String[] { "body", "return eGet(eClass().getEIDAttribute());" });
        addAnnotation(getAction__IsAllowed__EObject_EStructuralFeature(), source, new String[] { "body",
                "        org.eclipse.ui.services.IEvaluationService es = (org.eclipse.ui.services.IEvaluationService) org.eclipse.ui.PlatformUI.getWorkbench()\r\n                .getService(org.eclipse.ui.services.IEvaluationService.class);\r\n        org.eclipse.core.expressions.IEvaluationContext currentState = es.getCurrentState();\r\n\r\n        String perm = \"\";\r\n        \r\n        EObject mainObject = eObject;\r\n        \r\n        if (eObject instanceof IContained) {\r\n            mainObject = ((IContained) eObject).getMainEObject();\r\n        }        \r\n\r\n        if (mainObject instanceof EMFModel) {\r\n            perm = ((EMFModel) mainObject).getPermissionObject() + \"_\";\r\n        }\r\n\r\n        perm += getPermission();\r\n\r\n        org.eclipse.core.internal.expressions.ReferenceExpression referenceExpression = new org.eclipse.core.internal.expressions.ReferenceExpression(\r\n                perm);\r\n        org.eclipse.core.expressions.EvaluationResult result;\r\n        try {\r\n            result = referenceExpression.evaluate(currentState);\r\n            return org.eclipse.core.expressions.EvaluationResult.TRUE.equals(result);\r\n        } catch (org.eclipse.core.runtime.CoreException e) {\r\n            e.printStackTrace();\r\n        }\r\n\r\n        return false;" });
        addAnnotation(getAction__Execute__EObject_EStructuralFeature(), source, new String[] { "body",
                "        IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);\r\n        try {\r\n            org.eclipse.swt.widgets.Event e = new org.eclipse.swt.widgets.Event();\r\n            e.data = new Object[] { eObject, feature };\r\n\r\n            ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);\r\n            Category defCategory = commandService.getCategory(null);\r\n\t     String commandId = getCommandId(eObject);\r\n\r\n            Command command = commandService.getCommand(commandId);\r\n\r\n            if (!command.isDefined()) {\r\n                command.define(commandId, LoyaltyItemProviderAdapter.getDiplayName(eObject, feature), defCategory);\r\n            }\r\n\r\n            handlerService.executeCommand(commandId, e);\r\n        } catch (org.eclipse.core.commands.ExecutionException | org.eclipse.core.commands.common.NotDefinedException\r\n                | org.eclipse.core.commands.NotEnabledException | org.eclipse.core.commands.NotHandledException e) {\r\n            throw new AppException(EStatusReason.ERROR, e);\r\n        }" });
        addAnnotation(getAction__GetCommandId__EObject(), source, new String[] { "body",
                "        if (isGeneral()) {\r\n            return getName().toLowerCase();\r\n        }\r\n            \r\n        String commandId = \"\";\r\n\r\n        EObject mainObject = eObject;\r\n\r\n        if (eObject instanceof IContained) {\r\n            mainObject = ((IContained) eObject).getMainEObject();\r\n        }\r\n\r\n        if (mainObject instanceof EMFModel) {\r\n            commandId = ((EMFModel) mainObject).getPermissionObject() + \"_\";\r\n        }\r\n\r\n        commandId += getPermission();\r\n        \r\n        return commandId;\r\n" });
    }

    /**
     * Initializes the annotations for <b>http://com.icteam.loyalty/where</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createWhereAnnotations() {
        String source = "http://com.icteam.loyalty/where";
        addAnnotation(getIEditable_Editable(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEditable_Dirty(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_Distinct(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_FirstResult(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_MaxResults(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_SingleResult(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_LightSearch(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_Nested(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_OrderFeatures(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_OrderDirections(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_DynamicFilterFeatures(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_DynamicFilters(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_DynamicOrderFeature(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_DynamicOrderDirection(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFTemplate_DynamicFilterableFeatures(), source, new String[] { "clause", "NONE" });
        addAnnotation(getIEMFDelegant_DelegatedId(), source, new String[] { "clause", "NONE" });
    }

} //ModelInterfacesPackageImpl

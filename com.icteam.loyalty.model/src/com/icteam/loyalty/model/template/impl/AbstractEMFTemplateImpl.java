/**
 */
package com.icteam.loyalty.model.template.impl;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.security.auth.Subject;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import com.icteam.loyalty.api.AppException;
import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.api.interfaces.IConstants;
import com.icteam.loyalty.model.DictionaryEMF;
import com.icteam.loyalty.model.EAnnotationClosure;
import com.icteam.loyalty.model.ModelProperties;
import com.icteam.loyalty.model.interfaces.DistinctEMF;
import com.icteam.loyalty.model.interfaces.EAnnotation;
import com.icteam.loyalty.model.interfaces.EDynamicFilterableEMF;
import com.icteam.loyalty.model.interfaces.EStatusReason;
import com.icteam.loyalty.model.interfaces.EWhereClauseEMF;
import com.icteam.loyalty.model.interfaces.EWhereTemplateClauseEMF;
import com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum;
import com.icteam.loyalty.model.interfaces.IEMFModel;
import com.icteam.loyalty.model.interfaces.IEMFTemplate;
import com.icteam.loyalty.model.interfaces.IEditable;
import com.icteam.loyalty.model.interfaces.IFilterPriority;
import com.icteam.loyalty.model.interfaces.IFromToDateTemplate;
import com.icteam.loyalty.model.interfaces.IOperatorGroupPermission;
import com.icteam.loyalty.model.interfaces.IPrioritized;
import com.icteam.loyalty.model.interfaces.IStatusEMFTemplate;
import com.icteam.loyalty.model.interfaces.IValidDateTemplate;
import com.icteam.loyalty.model.interfaces.IValidDateTime;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.interfaces.OrderDirectionEMF;
import com.icteam.loyalty.model.interfaces.Status;
import com.icteam.loyalty.model.provider.LoyaltyItemProviderAdapter;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.model.template.DictionaryEMFTemplate;
import com.icteam.loyalty.model.template.ModelTemplateFactory;
import com.icteam.loyalty.model.template.ModelTemplatePackage;
import com.icteam.loyalty.model.util.ModelUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract EMF Template</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getDistinct <em>Distinct</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getFirstResult <em>First Result</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getMaxResults <em>Max Results</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#isSingleResult <em>Single Result</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#isLightSearch <em>Light Search</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#isNested <em>Nested</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getOrderFeatures <em>Order Features</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getOrderDirections <em>Order Directions</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getDynamicFilterFeatures <em>Dynamic Filter Features</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getDynamicFilters <em>Dynamic Filters</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getDynamicOrderFeature <em>Dynamic Order Feature</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getDynamicOrderDirection <em>Dynamic Order Direction</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getDynamicFilterableFeatures <em>Dynamic Filterable Features</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#isEditable <em>Editable</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#isDirty <em>Dirty</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getEntityManager <em>Entity Manager</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getWheres <em>Wheres</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getBuilder <em>Builder</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getCriteria <em>Criteria</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.impl.AbstractEMFTemplateImpl#getExcludedFeatures <em>Excluded Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractEMFTemplateImpl<T extends Serializable> extends MinimalEObjectImpl.Container implements AbstractEMFTemplate<T> {
    /**
     * The default value of the '{@link #getDistinct() <em>Distinct</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDistinct()
     * @generated
     * @ordered
     */
    protected static final DistinctEMF DISTINCT_EDEFAULT = DistinctEMF.SQL;

    private final Map<EStructuralFeature, String> dbProperties = new HashMap<>();

    /**
     * The cached value of the '{@link #getDistinct() <em>Distinct</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDistinct()
     * @generated
     * @ordered
     */
    protected DistinctEMF distinct = DISTINCT_EDEFAULT;

    /**
     * The default value of the '{@link #getFirstResult() <em>First Result</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFirstResult()
     * @generated
     * @ordered
     */
    protected static final int FIRST_RESULT_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getFirstResult() <em>First Result</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFirstResult()
     * @generated
     * @ordered
     */
    protected int firstResult = FIRST_RESULT_EDEFAULT;

    /**
     * The default value of the '{@link #getMaxResults() <em>Max Results</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxResults()
     * @generated
     * @ordered
     */
    protected static final int MAX_RESULTS_EDEFAULT = -1;

    /**
     * The cached value of the '{@link #getMaxResults() <em>Max Results</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaxResults()
     * @generated
     * @ordered
     */
    protected int maxResults = MAX_RESULTS_EDEFAULT;

    /**
     * The default value of the '{@link #isSingleResult() <em>Single Result</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSingleResult()
     * @generated
     * @ordered
     */
    protected static final boolean SINGLE_RESULT_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isSingleResult() <em>Single Result</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSingleResult()
     * @generated
     * @ordered
     */
    protected boolean singleResult = SINGLE_RESULT_EDEFAULT;

    /**
     * The default value of the '{@link #isLightSearch() <em>Light Search</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLightSearch()
     * @generated
     * @ordered
     */
    protected static final boolean LIGHT_SEARCH_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isLightSearch() <em>Light Search</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isLightSearch()
     * @generated
     * @ordered
     */
    protected boolean lightSearch = LIGHT_SEARCH_EDEFAULT;

    /**
     * The default value of the '{@link #isNested() <em>Nested</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNested()
     * @generated
     * @ordered
     */
    protected static final boolean NESTED_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isNested() <em>Nested</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isNested()
     * @generated
     * @ordered
     */
    protected boolean nested = NESTED_EDEFAULT;

    /**
     * The cached value of the '{@link #getOrderFeatures() <em>Order Features</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrderFeatures()
     * @generated
     * @ordered
     */
    protected EList<FeaturePath> orderFeatures;

    /**
     * The cached value of the '{@link #getOrderDirections() <em>Order Directions</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrderDirections()
     * @generated
     * @ordered
     */
    protected EList<OrderDirectionEMF> orderDirections;

    /**
     * The cached value of the '{@link #getDynamicFilterFeatures() <em>Dynamic Filter Features</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDynamicFilterFeatures()
     * @generated
     * @ordered
     */
    protected EList<EStructuralFeature> dynamicFilterFeatures;

    /**
     * The cached value of the '{@link #getDynamicFilters() <em>Dynamic Filters</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDynamicFilters()
     * @generated
     * @ordered
     */
    protected EList<String> dynamicFilters;

    /**
     * The default value of the '{@link #getDynamicOrderFeature() <em>Dynamic Order Feature</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDynamicOrderFeature()
     * @generated
     * @ordered
     */
    protected static final FeaturePath DYNAMIC_ORDER_FEATURE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDynamicOrderFeature() <em>Dynamic Order Feature</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDynamicOrderFeature()
     * @generated
     * @ordered
     */
    protected FeaturePath dynamicOrderFeature = DYNAMIC_ORDER_FEATURE_EDEFAULT;

    /**
     * The default value of the '{@link #getDynamicOrderDirection() <em>Dynamic Order Direction</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDynamicOrderDirection()
     * @generated
     * @ordered
     */
    protected static final OrderDirectionEMF DYNAMIC_ORDER_DIRECTION_EDEFAULT = OrderDirectionEMF.NONE;

    /**
     * The cached value of the '{@link #getDynamicOrderDirection() <em>Dynamic Order Direction</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDynamicOrderDirection()
     * @generated
     * @ordered
     */
    protected OrderDirectionEMF dynamicOrderDirection = DYNAMIC_ORDER_DIRECTION_EDEFAULT;

    /**
     * The cached value of the '{@link #getDynamicFilterableFeatures() <em>Dynamic Filterable Features</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDynamicFilterableFeatures()
     * @generated
     * @ordered
     */
    protected EList<EStructuralFeature> dynamicFilterableFeatures;

    /**
     * The default value of the '{@link #isEditable() <em>Editable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEditable()
     * @generated
     * @ordered
     */
    protected static final boolean EDITABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isEditable() <em>Editable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEditable()
     * @generated
     * @ordered
     */
    protected boolean editable = EDITABLE_EDEFAULT;

    /**
     * The default value of the '{@link #isDirty() <em>Dirty</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDirty()
     * @generated
     * @ordered
     */
    protected static final boolean DIRTY_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDirty() <em>Dirty</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDirty()
     * @generated
     * @ordered
     */
    protected boolean dirty = DIRTY_EDEFAULT;

    /**
     * The default value of the '{@link #getEntityManager() <em>Entity Manager</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntityManager()
     * @generated
     * @ordered
     */
    protected static final EntityManager ENTITY_MANAGER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getEntityManager() <em>Entity Manager</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntityManager()
     * @generated
     * @ordered
     */
    protected EntityManager entityManager = ENTITY_MANAGER_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    protected AbstractEMFTemplateImpl() {
        super();

        initDefaultDynamicFilterFeatures();

        initExcludefeatures();
    }

    private void initExcludefeatures() {
        getExcludedFeatures().add(ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DISTINCT);
        getExcludedFeatures().add(ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DYNAMIC_FILTER_FEATURES);
        getExcludedFeatures().add(ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DYNAMIC_FILTERS);
        getExcludedFeatures().add(ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION);
        getExcludedFeatures().add(ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DYNAMIC_ORDER_FEATURE);
        getExcludedFeatures().add(ModelInterfacesPackage.Literals.IEMF_TEMPLATE__FIRST_RESULT);
        getExcludedFeatures().add(ModelInterfacesPackage.Literals.IEMF_TEMPLATE__LIGHT_SEARCH);
        getExcludedFeatures().add(ModelInterfacesPackage.Literals.IEMF_TEMPLATE__MAX_RESULTS);
        getExcludedFeatures().add(ModelInterfacesPackage.Literals.IEMF_TEMPLATE__NESTED);
        getExcludedFeatures().add(ModelInterfacesPackage.Literals.IEMF_TEMPLATE__ORDER_DIRECTIONS);
        getExcludedFeatures().add(ModelInterfacesPackage.Literals.IEMF_TEMPLATE__ORDER_FEATURES);
        getExcludedFeatures().add(ModelInterfacesPackage.Literals.IEMF_TEMPLATE__SINGLE_RESULT);
        getExcludedFeatures().add(ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE__BUILDER);
        getExcludedFeatures().add(ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE__CRITERIA);
        getExcludedFeatures().add(ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE__ENTITY_MANAGER);
        getExcludedFeatures().add(ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE__EXCLUDED_FEATURES);
        getExcludedFeatures().add(ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE__ROOT);
        getExcludedFeatures().add(ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE__WHERES);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DistinctEMF getDistinct() {
        return distinct;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDistinct(DistinctEMF newDistinct) {
        DistinctEMF oldDistinct = distinct;
        distinct = newDistinct == null ? DISTINCT_EDEFAULT : newDistinct;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DISTINCT, oldDistinct, distinct));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getMaxResults() {
        return maxResults;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setMaxResults(int newMaxResults) {
        int oldMaxResults = maxResults;
        maxResults = newMaxResults;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__MAX_RESULTS, oldMaxResults, maxResults));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<OrderDirectionEMF> getOrderDirections() {
        if (orderDirections == null) {
            orderDirections = new EDataTypeUniqueEList<OrderDirectionEMF>(OrderDirectionEMF.class, this, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ORDER_DIRECTIONS);
        }
        return orderDirections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<EStructuralFeature> getDynamicFilterFeatures() {
        if (dynamicFilterFeatures == null) {
            dynamicFilterFeatures = new EDataTypeUniqueEList<EStructuralFeature>(EStructuralFeature.class, this,
                    ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTER_FEATURES);
        }
        return dynamicFilterFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isEditable() {
        return editable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEditable(boolean newEditable) {
        boolean oldEditable = editable;
        editable = newEditable;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EDITABLE, oldEditable, editable));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isDirty() {
        return dirty;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDirty(boolean newDirty) {
        boolean oldDirty = dirty;
        dirty = newDirty;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DIRTY, oldDirty, dirty));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<String> getDynamicFilters() {
        if (dynamicFilters == null) {
            dynamicFilters = new EDataTypeUniqueEList<String>(String.class, this, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERS);
        }
        return dynamicFilters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isSingleResult() {
        return singleResult;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setSingleResult(boolean newSingleResult) {
        boolean oldSingleResult = singleResult;
        singleResult = newSingleResult;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__SINGLE_RESULT, oldSingleResult, singleResult));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isLightSearch() {
        return lightSearch;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setLightSearch(boolean newLightSearch) {
        boolean oldLightSearch = lightSearch;
        lightSearch = newLightSearch;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__LIGHT_SEARCH, oldLightSearch, lightSearch));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setEntityManager(EntityManager newEntityManager) {
        EntityManager oldEntityManager = entityManager;
        entityManager = newEntityManager;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ENTITY_MANAGER, oldEntityManager, entityManager));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<Predicate> getWheres() {
        if (wheres == null) {
            wheres = new EDataTypeUniqueEList<Predicate>(Predicate.class, this, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__WHERES);
        }
        return wheres;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public CriteriaBuilder getBuilder() {
        return builder;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setBuilder(CriteriaBuilder newBuilder) {
        CriteriaBuilder oldBuilder = builder;
        builder = newBuilder;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__BUILDER, oldBuilder, builder));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public CriteriaQuery< ? > getCriteria() {
        return criteria;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setCriteria(CriteriaQuery< ? > newCriteria) {
        CriteriaQuery< ? > oldCriteria = criteria;
        criteria = newCriteria;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__CRITERIA, oldCriteria, criteria));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getFirstResult() {
        return firstResult;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setFirstResult(int newFirstResult) {
        int oldFirstResult = firstResult;
        firstResult = newFirstResult;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__FIRST_RESULT, oldFirstResult, firstResult));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isNested() {
        return nested;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setNested(boolean newNested) {
        boolean oldNested = nested;
        nested = newNested;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__NESTED, oldNested, nested));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<FeaturePath> getOrderFeatures() {
        if (orderFeatures == null) {
            orderFeatures = new EDataTypeUniqueEList<FeaturePath>(FeaturePath.class, this, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ORDER_FEATURES);
        }
        return orderFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public FeaturePath getDynamicOrderFeature() {
        return dynamicOrderFeature;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDynamicOrderFeature(FeaturePath newDynamicOrderFeature) {
        FeaturePath oldDynamicOrderFeature = dynamicOrderFeature;
        dynamicOrderFeature = newDynamicOrderFeature;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_FEATURE, oldDynamicOrderFeature, dynamicOrderFeature));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public OrderDirectionEMF getDynamicOrderDirection() {
        return dynamicOrderDirection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDynamicOrderDirection(OrderDirectionEMF newDynamicOrderDirection) {
        OrderDirectionEMF oldDynamicOrderDirection = dynamicOrderDirection;
        dynamicOrderDirection = newDynamicOrderDirection == null ? DYNAMIC_ORDER_DIRECTION_EDEFAULT : newDynamicOrderDirection;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION, oldDynamicOrderDirection,
                    dynamicOrderDirection));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public From< ? , T> getRoot() {
        return root;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setRoot(From< ? , T> newRoot) {
        From< ? , T> oldRoot = root;
        root = newRoot;
        if (eNotificationRequired()) {
            eNotify(new ENotificationImpl(this, Notification.SET, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ROOT, oldRoot, root));
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getIdValue() {
        return eGet(eClass().getEIDAttribute());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ManagedType<T> getMetamodel() {
        return entityManager == null ? null : entityManager.getMetamodel().managedType(getDbModelClass());
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public EList<EStructuralFeature> getDynamicFilterableFeatures() {
        if (dynamicFilterableFeatures == null) {
            dynamicFilterableFeatures = new EDataTypeUniqueEList<EStructuralFeature>(EStructuralFeature.class, this,
                    ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES);

            ModelUtil.forAllDo(eClass(), new EAnnotationClosure<EDynamicFilterableEMF>(EAnnotation.DYNAMIC_FILTERABLE) {
                @Override
                public void execute(EStructuralFeature feature, EDynamicFilterableEMF value) {
                    if (!EDynamicFilterableEMF.NO.equals(value)) {
                        dynamicFilterableFeatures.add(feature);
                    }
                }
            });
        }

        return dynamicFilterableFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void buildFetches() {
        // nothing
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void checkDynamicFilters(final EList<EStructuralFeature> dynamicFilterFeatures, final EList<String> dynamicFilters) {
        for (EStructuralFeature feature : dynamicFilterFeatures) {
            if (ModelUtil.isI18NFeature(feature)) {
                for (String dynamicFilter : dynamicFilters) {
                    if (!ModelUtil.checkMinLengthI18N(dynamicFilter)) {
                        throw new AppException(EStatusReason.MIN_CHARACTER_SEARCH_LENGTH, ModelProperties.getInstance().minSearchCharacterI18N());
                    }
                }
            }
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public void buildWheres() {
        buildAnnotationWheres();

        buildWhereValidDate();
        buildWhereFromToDate();
        buildWhereStatus();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public <C extends IEMFModel> void copyTo(final C destModel, final boolean deliver) {
        if (!deliver) {
            destModel.eSetDeliver(false);
        }

        for (EStructuralFeature feature : eClass().getEAllStructuralFeatures()) {
            if (feature.isChangeable()) {
                Boolean copy = (Boolean) ModelUtil.getAnnotation(feature, com.icteam.loyalty.model.interfaces.EAnnotation.COPY);

                if (copy) {
                    destModel.eSet(feature, eGet(feature));
                }
            }
        }

        destModel.setDirty(isDirty());

        if (!deliver) {
            destModel.eSetDeliver(true);
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean equals(final Object obj) {
        return ModelUtil.equals(this, obj);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean hasDynamicFilters() {
        return !dynamicFilterFeatures.isEmpty() && !dynamicFilters.isEmpty();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setDynamicFilterFeatures(final EList<EStructuralFeature> dynamicFilterFeatures) {
        checkDynamicFilters(dynamicFilterFeatures, getDynamicFilters());

        eSet(ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTER_FEATURES, dynamicFilterFeatures);

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setRawFilter(final String rawFilter) {
        BasicEList<String> filterList = ECollections.newBasicEList(StringUtils.stripAll(StringUtils.split(StringUtils.defaultString(rawFilter))));

        checkDynamicFilters(getDynamicFilterFeatures(), filterList);

        eSet(ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERS, filterList);

    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public boolean initialized() {
        boolean set = false;

        for (EStructuralFeature feature : eClass().getEAllStructuralFeatures()) {
            if (initialized(feature)) {
                set = true;
                break;
            }
        }

        return set;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public Long getResultCount(EntityManager em) {
        setEntityManager(em);

        CriteriaQuery<Long> criteriaCount = buildCriteria(em.getCriteriaBuilder());
        criteriaCount.select(getBuilder().countDistinct(getRoot()));
        criteriaCount.orderBy((List<Order>) null); // annullo l'eventuale ordinamento, con la count si rompe

        return em.createQuery(criteriaCount).getSingleResult();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public <R> R getFirstResult(EntityManager em) {
        int oldMaxResults = maxResults;

        setMaxResults(1);

        try {
            List<R> list = getResultList(em);
            if (list.isEmpty()) {
                return null;
            }

            return list.get(0);
        } finally {
            setMaxResults(oldMaxResults);
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated NOT
     */
    @Override
    public <R> EList<R> getResultList(EntityManager em) {
        setEntityManager(em);

        EList<R> list;

        if (isLightSearch()) {
            list = getResultListLightSearch(em);
        } else {
            CriteriaQuery<R> internalCriteria = buildCriteria(em.getCriteriaBuilder());

            TypedQuery<R> query = em.createQuery(internalCriteria);

            handleMaxResults(query);
            handleFirstResult(query);

            list = ECollections.newBasicEList(query.getResultList());
        }

        list = initializeAndApplyFilters(list);

        if (isSingleResult()) {
            if (list.isEmpty()) {
                throw new NoResultException();
            }

            if (list.size() > 1) {
                throw new NonUniqueResultException();
            }
        }

        return list;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DISTINCT:
                return getDistinct();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__FIRST_RESULT:
                return getFirstResult();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__MAX_RESULTS:
                return getMaxResults();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__SINGLE_RESULT:
                return isSingleResult();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__LIGHT_SEARCH:
                return isLightSearch();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__NESTED:
                return isNested();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ORDER_FEATURES:
                return getOrderFeatures();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ORDER_DIRECTIONS:
                return getOrderDirections();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTER_FEATURES:
                return getDynamicFilterFeatures();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERS:
                return getDynamicFilters();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_FEATURE:
                return getDynamicOrderFeature();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION:
                return getDynamicOrderDirection();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES:
                return getDynamicFilterableFeatures();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EDITABLE:
                return isEditable();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DIRTY:
                return isDirty();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ENTITY_MANAGER:
                return getEntityManager();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__WHERES:
                return getWheres();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__BUILDER:
                return getBuilder();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__CRITERIA:
                return getCriteria();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ROOT:
                return getRoot();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EXCLUDED_FEATURES:
                return getExcludedFeatures();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DISTINCT:
                setDistinct((DistinctEMF) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__FIRST_RESULT:
                setFirstResult((Integer) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__MAX_RESULTS:
                setMaxResults((Integer) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__SINGLE_RESULT:
                setSingleResult((Boolean) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__LIGHT_SEARCH:
                setLightSearch((Boolean) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__NESTED:
                setNested((Boolean) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ORDER_FEATURES:
                getOrderFeatures().clear();
                getOrderFeatures().addAll((Collection< ? extends FeaturePath>) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ORDER_DIRECTIONS:
                getOrderDirections().clear();
                getOrderDirections().addAll((Collection< ? extends OrderDirectionEMF>) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTER_FEATURES:
                getDynamicFilterFeatures().clear();
                getDynamicFilterFeatures().addAll((Collection< ? extends EStructuralFeature>) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERS:
                getDynamicFilters().clear();
                getDynamicFilters().addAll((Collection< ? extends String>) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_FEATURE:
                setDynamicOrderFeature((FeaturePath) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION:
                setDynamicOrderDirection((OrderDirectionEMF) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EDITABLE:
                setEditable((Boolean) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DIRTY:
                setDirty((Boolean) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ENTITY_MANAGER:
                setEntityManager((EntityManager) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__WHERES:
                getWheres().clear();
                getWheres().addAll((Collection< ? extends Predicate>) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__BUILDER:
                setBuilder((CriteriaBuilder) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__CRITERIA:
                setCriteria((CriteriaQuery< ? >) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ROOT:
                setRoot((From< ? , T>) newValue);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EXCLUDED_FEATURES:
                getExcludedFeatures().clear();
                getExcludedFeatures().addAll((Collection< ? extends EStructuralFeature>) newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DISTINCT:
                setDistinct(DISTINCT_EDEFAULT);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__FIRST_RESULT:
                setFirstResult(FIRST_RESULT_EDEFAULT);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__MAX_RESULTS:
                setMaxResults(MAX_RESULTS_EDEFAULT);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__SINGLE_RESULT:
                setSingleResult(SINGLE_RESULT_EDEFAULT);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__LIGHT_SEARCH:
                setLightSearch(LIGHT_SEARCH_EDEFAULT);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__NESTED:
                setNested(NESTED_EDEFAULT);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ORDER_FEATURES:
                getOrderFeatures().clear();
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ORDER_DIRECTIONS:
                getOrderDirections().clear();
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTER_FEATURES:
                getDynamicFilterFeatures().clear();
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERS:
                getDynamicFilters().clear();
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_FEATURE:
                setDynamicOrderFeature(DYNAMIC_ORDER_FEATURE_EDEFAULT);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION:
                setDynamicOrderDirection(DYNAMIC_ORDER_DIRECTION_EDEFAULT);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EDITABLE:
                setEditable(EDITABLE_EDEFAULT);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DIRTY:
                setDirty(DIRTY_EDEFAULT);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ENTITY_MANAGER:
                setEntityManager(ENTITY_MANAGER_EDEFAULT);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__WHERES:
                getWheres().clear();
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__BUILDER:
                setBuilder(BUILDER_EDEFAULT);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__CRITERIA:
                setCriteria((CriteriaQuery< ? >) null);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ROOT:
                setRoot((From< ? , T>) null);
                return;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EXCLUDED_FEATURES:
                getExcludedFeatures().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DISTINCT:
                return distinct != DISTINCT_EDEFAULT;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__FIRST_RESULT:
                return firstResult != FIRST_RESULT_EDEFAULT;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__MAX_RESULTS:
                return maxResults != MAX_RESULTS_EDEFAULT;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__SINGLE_RESULT:
                return singleResult != SINGLE_RESULT_EDEFAULT;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__LIGHT_SEARCH:
                return lightSearch != LIGHT_SEARCH_EDEFAULT;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__NESTED:
                return nested != NESTED_EDEFAULT;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ORDER_FEATURES:
                return orderFeatures != null && !orderFeatures.isEmpty();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ORDER_DIRECTIONS:
                return orderDirections != null && !orderDirections.isEmpty();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTER_FEATURES:
                return dynamicFilterFeatures != null && !dynamicFilterFeatures.isEmpty();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERS:
                return dynamicFilters != null && !dynamicFilters.isEmpty();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_FEATURE:
                return DYNAMIC_ORDER_FEATURE_EDEFAULT == null ? dynamicOrderFeature != null : !DYNAMIC_ORDER_FEATURE_EDEFAULT.equals(dynamicOrderFeature);
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION:
                return dynamicOrderDirection != DYNAMIC_ORDER_DIRECTION_EDEFAULT;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES:
                return dynamicFilterableFeatures != null && !dynamicFilterableFeatures.isEmpty();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EDITABLE:
                return editable != EDITABLE_EDEFAULT;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DIRTY:
                return dirty != DIRTY_EDEFAULT;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ENTITY_MANAGER:
                return ENTITY_MANAGER_EDEFAULT == null ? entityManager != null : !ENTITY_MANAGER_EDEFAULT.equals(entityManager);
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__WHERES:
                return wheres != null && !wheres.isEmpty();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__BUILDER:
                return BUILDER_EDEFAULT == null ? builder != null : !BUILDER_EDEFAULT.equals(builder);
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__CRITERIA:
                return criteria != null;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ROOT:
                return root != null;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EXCLUDED_FEATURES:
                return excludedFeatures != null && !excludedFeatures.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class< ? > baseClass) {
        if (baseClass == IEditable.class) {
            switch (derivedFeatureID) {
                case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EDITABLE:
                    return ModelInterfacesPackage.IEDITABLE__EDITABLE;
                case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DIRTY:
                    return ModelInterfacesPackage.IEDITABLE__DIRTY;
                default:
                    return -1;
            }
        }
        if (baseClass == IEMFModel.class) {
            switch (derivedFeatureID) {
                default:
                    return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class< ? > baseClass) {
        if (baseClass == IEditable.class) {
            switch (baseFeatureID) {
                case ModelInterfacesPackage.IEDITABLE__EDITABLE:
                    return ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EDITABLE;
                case ModelInterfacesPackage.IEDITABLE__DIRTY:
                    return ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DIRTY;
                default:
                    return -1;
            }
        }
        if (baseClass == IEMFModel.class) {
            switch (baseFeatureID) {
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedOperationID(int baseOperationID, Class< ? > baseClass) {
        if (baseClass == IEditable.class) {
            switch (baseOperationID) {
                default:
                    return -1;
            }
        }
        if (baseClass == IEMFModel.class) {
            switch (baseOperationID) {
                case ModelInterfacesPackage.IEMF_MODEL___COPY_TO__IEMFMODEL_BOOLEAN:
                    return ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___COPY_TO__IEMFMODEL_BOOLEAN;
                case ModelInterfacesPackage.IEMF_MODEL___EQUALS__OBJECT:
                    return ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___EQUALS__OBJECT;
                default:
                    return -1;
            }
        }
        return super.eDerivedOperationID(baseOperationID, baseClass);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object eInvoke(int operationID, EList< ? > arguments) throws InvocationTargetException {
        switch (operationID) {
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___GET_METAMODEL:
                return getMetamodel();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___BUILD_FETCHES:
                buildFetches();
                return null;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___CHECK_DYNAMIC_FILTERS__ELIST_ELIST:
                checkDynamicFilters((EList<EStructuralFeature>) arguments.get(0), (EList<String>) arguments.get(1));
                return null;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___BUILD_WHERES:
                buildWheres();
                return null;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___COPY_TO__IEMFMODEL_BOOLEAN:
                copyTo((IEMFModel) arguments.get(0), (Boolean) arguments.get(1));
                return null;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___EQUALS__OBJECT:
                return equals(arguments.get(0));
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___INITIALIZED:
                return initialized();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___GET_RESULT_COUNT__ENTITYMANAGER:
                return getResultCount((EntityManager) arguments.get(0));
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___GET_FIRST_RESULT__ENTITYMANAGER:
                return getFirstResult((EntityManager) arguments.get(0));
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___GET_RESULT_LIST__ENTITYMANAGER:
                return getResultList((EntityManager) arguments.get(0));
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___HAS_DYNAMIC_FILTERS:
                return hasDynamicFilters();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___SET_DYNAMIC_FILTER_FEATURES__ELIST:
                setDynamicFilterFeatures((EList<EStructuralFeature>) arguments.get(0));
                return null;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___SET_RAW_FILTER__STRING:
                setRawFilter((String) arguments.get(0));
                return null;
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___HAS_DYNAMIC_ORDER:
                return hasDynamicOrder();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___GET_DB_MODEL_CLASS:
                return getDbModelClass();
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE___GET_ID_VALUE:
                return getIdValue();
        }
        return super.eInvoke(operationID, arguments);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) {
            return super.toString();
        }

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (distinct: ");
        result.append(distinct);
        result.append(", firstResult: ");
        result.append(firstResult);
        result.append(", maxResults: ");
        result.append(maxResults);
        result.append(", singleResult: ");
        result.append(singleResult);
        result.append(", lightSearch: ");
        result.append(lightSearch);
        result.append(", nested: ");
        result.append(nested);
        result.append(", orderFeatures: ");
        result.append(orderFeatures);
        result.append(", orderDirections: ");
        result.append(orderDirections);
        result.append(", dynamicFilterFeatures: ");
        result.append(dynamicFilterFeatures);
        result.append(", dynamicFilters: ");
        result.append(dynamicFilters);
        result.append(", dynamicOrderFeature: ");
        result.append(dynamicOrderFeature);
        result.append(", dynamicOrderDirection: ");
        result.append(dynamicOrderDirection);
        result.append(", dynamicFilterableFeatures: ");
        result.append(dynamicFilterableFeatures);
        result.append(", editable: ");
        result.append(editable);
        result.append(", dirty: ");
        result.append(dirty);
        result.append(", entityManager: ");
        result.append(entityManager);
        result.append(", wheres: ");
        result.append(wheres);
        result.append(", builder: ");
        result.append(builder);
        result.append(", criteria: ");
        result.append(criteria);
        result.append(", root: ");
        result.append(root);
        result.append(", excludedFeatures: ");
        result.append(excludedFeatures);
        result.append(')');
        return result.toString();
    }

    protected void initDefaultDynamicFilterFeatures() {
        List<EStructuralFeature> filterableFeatures = getDynamicFilterableFeatures();
        final EList<EStructuralFeature> defaultDynamicFilterFeatures = ECollections.newBasicEList();

        ModelUtil.forAllDo(filterableFeatures, new EAnnotationClosure<EDynamicFilterableEMF>(EAnnotation.DYNAMIC_FILTERABLE) {
            @Override
            public void execute(EStructuralFeature feature, EDynamicFilterableEMF value) {
                if (EDynamicFilterableEMF.DEFAULT_FILTER.equals(value)) {
                    defaultDynamicFilterFeatures.add(feature);
                }
            }
        });

        setDynamicFilterFeatures(defaultDynamicFilterFeatures);
    }

    /**
     * The cached value of the '{@link #getWheres() <em>Wheres</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getWheres()
     * @generated
     * @ordered
     */
    protected EList<Predicate> wheres;

    /**
     * The default value of the '{@link #getBuilder() <em>Builder</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBuilder()
     * @generated
     * @ordered
     */
    protected static final CriteriaBuilder BUILDER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBuilder() <em>Builder</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBuilder()
     * @generated
     * @ordered
     */
    protected CriteriaBuilder builder = BUILDER_EDEFAULT;

    /**
     * The cached value of the '{@link #getCriteria() <em>Criteria</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCriteria()
     * @generated
     * @ordered
     */
    protected CriteriaQuery< ? > criteria;

    /**
     * The cached value of the '{@link #getRoot() <em>Root</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRoot()
     * @generated
     * @ordered
     */
    protected From< ? , T> root;

    /**
     * The cached value of the '{@link #getExcludedFeatures() <em>Excluded Features</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExcludedFeatures()
     * @generated
     * @ordered
     */
    protected EList<EStructuralFeature> excludedFeatures;

    protected boolean initialized(EStructuralFeature feature) {
        if (getExcludedFeatures().contains(feature)) {
            return false;
        }

        if (feature instanceof IEMFTemplate< ? >) {
            return ((IEMFTemplate< ? >) feature).initialized();
        }

        return !eIsSet(feature);
    }

    private void buildOrder() {
        List<Order> orders = new ArrayList<>();

        for (int i = 0; i < getOrderDirections().size(); i++) {
            if (getOrderDirections().get(i).equals(OrderDirectionEMF.ASC)) {
                orders.add(builder.asc(buildFeatureExpression(getOrderFeatures().get(i))));
            } else if (getOrderDirections().get(i).equals(OrderDirectionEMF.DESC)) {
                orders.add(builder.desc(buildFeatureExpression(getOrderFeatures().get(i))));
            }
        }

        if (hasDynamicOrder()) {
            if (dynamicOrderDirection.equals(OrderDirectionEMF.ASC)) {
                orders.add(builder.asc(buildFeatureExpression(dynamicOrderFeature)));
            } else if (dynamicOrderDirection.equals(OrderDirectionEMF.DESC)) {
                orders.add(builder.desc(buildFeatureExpression(dynamicOrderFeature)));
            }
        }

        criteria.orderBy(orders);
    }

    private Expression< ? > buildFeatureExpression(FeaturePath feature) {
        Path< ? > out = root;
        for (EStructuralFeature structuralFeature : feature.getFeaturePath()) {
            out = out.get(getDbProperty(structuralFeature));
        }

        return out;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<EStructuralFeature> getExcludedFeatures() {
        if (excludedFeatures == null) {
            excludedFeatures = new EDataTypeUniqueEList<EStructuralFeature>(EStructuralFeature.class, this, ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EXCLUDED_FEATURES);
        }
        return excludedFeatures;
    }

    private <R> EList<R> initializeAndApplyFilters(EList<R> list) {
        list = filterDistinctValues(list);

        list = filterPriority(list);

        return list;
    }

    /**
     * Crea Criteria
     *
     * @param builder
     *            CriteriaBuilder
     * @return CriteriaQuery criteria query
     */
    public <R> CriteriaQuery<R> buildCriteria(CriteriaBuilder builder) {
        return (CriteriaQuery<R>) buildCriteria(getDbModelClass(), builder);
    }

    public <R> CriteriaQuery<R> buildCriteria(Class<R> resultClass, CriteriaBuilder builder) {
        initCriteria(resultClass, builder);

        return buildCriteria();
    }

    /**
     * Init criteria.
     *
     * @param builder
     *            the builder
     */
    protected <R> void initCriteria(Class<R> resultClass, CriteriaBuilder builder) {
        setCriteria(builder.createQuery(resultClass));
        setRoot(criteria.from(getDbModelClass()));
        setBuilder(builder);
        eUnset(ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__WHERES);
    }

    private <R> EList<R> filterPriority(EList<R> list) {
        if (this instanceof IFilterPriority) {
            if (BooleanUtils.isTrue(((IFilterPriority) this).getFilterPriority())) {
                list = (EList<R>) ModelUtil.filter((EList<IPrioritized>) list);
            }
        }

        return list;
    }

    /**
     * filtro i risultati via codice se il valore di
     *
     * @param list
     */
    private <R> EList<R> filterDistinctValues(EList<R> list) {
        if (getDistinct().equals(DistinctEMF.CODE)) {
            Set<R> set = new LinkedHashSet<>(list);
            list = ECollections.newBasicEList(set);
        }

        return list;
    }

    private <R> void handleFirstResult(TypedQuery<R> query) {
        if (getFirstResult() != -1) {
            query.setFirstResult(getFirstResult());
        }
    }

    private <R> void handleMaxResults(TypedQuery<R> query) {
        if (getMaxResults() != -1) {
            query.setMaxResults(getMaxResults());
        }
    }

    /**
     * Gets result list light search.
     *
     * @param em
     *            the entity manager
     * @return the result list light search
     */
    protected <R> EList<R> getResultListLightSearch(EntityManager em) {
        T result = entityManager.find(getDbModelClass(), getIdValue());

        EList<T> list = ECollections.newBasicEList();

        if (result != null) {
            list.add(result);
        }

        Iterator<T> iterator = list.iterator();
        while (iterator.hasNext()) {
            result = iterator.next();

            if (checkDefaultWheres(result) && checkLightSearch(result)) {
                continue;
            }

            iterator.remove();
        }

        return (EList<R>) list;
    }

    protected boolean checkLightSearch(T result) {
        return true;
    }

    /**
     * Build criteria.
     *
     * @return the criteria query
     */
    protected <R> CriteriaQuery<R> buildCriteria() {
        buildWheres();

        buildFetches();

        buildDynamicFilters();

        criteria.where(getWheres().toArray(new Predicate[getWheres().size()]));

        buildOrder();

        criteria.distinct(getDistinct().equals(DistinctEMF.SQL));

        return (CriteriaQuery<R>) getCriteria();
    }

    @SuppressWarnings("rawtypes")
    private void buildAnnotationWheres() {
        for (EStructuralFeature feature : eClass().getEAllStructuralFeatures()) {
            String dbProperty = getDbProperty(feature);

            if (dbProperty.equals(ModelInterfacesPackage.Literals.ISTATUS_EMF_TEMPLATE__STATUS.getName())) {
                continue;
            }

            if (AbstractEMFTemplate.class.isAssignableFrom(feature.getEType().getInstanceClass())) {
                handleWhereTemplate(feature);
            }

            if (eIsSet(feature)) {
                EWhereClauseEMF whereClause = (EWhereClauseEMF) ModelUtil.getAnnotation(feature, EAnnotation.CLAUSE);

                switch (whereClause) {
                    case EQUAL:
                        handleWhereEqual(dbProperty, (Serializable) eGet(feature));
                        break;
                    case GREATER_EQUAL:
                        handleWhereGreaterOrEqual(dbProperty, (Comparable) eGet(feature));
                        break;
                    case LIKE_IGNORE_CASE:
                        handleWhereLikeIgnoreCase(dbProperty, (String) eGet(feature));
                        break;
                    case I18N:
                        // nel caso di template innestato se il campo e' un id ho la chiave e non la traduzione
                        if (isNested() && eClass().getEIDAttribute().equals(feature)) {
                            handleWhereEqual(dbProperty, (Serializable) eGet(feature));
                        } else {
                            String prefixI18N = (String) ModelUtil.getAnnotation(feature, EAnnotation.DB_PROPERTY);
                            handleWhereI18N(dbProperty, (String) eGet(feature), prefixI18N);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private String getDbProperty(EStructuralFeature feature) {
        String dbProperty = dbProperties.get(feature);

        if (dbProperty == null) {
            dbProperty = (String) ModelUtil.getAnnotation(feature, EAnnotation.DB_PROPERTY, feature.getName());
            dbProperties.put(feature, dbProperty);
        }

        return dbProperty;
    }

    private void handleWhereTemplate(EStructuralFeature feature) {
        EWhereTemplateClauseEMF clause = (EWhereTemplateClauseEMF) ModelUtil.getAnnotation(feature, EAnnotation.TEMPLATE_CLAUSE);

        switch (clause) {
            case EQUAL:
                handleWhereTemplateEqual(getDbProperty(feature), (AbstractEMFTemplate<Serializable>) eGet(feature));
                break;
            default:
                break;
        }
    }

    <Y extends Serializable> void handleWhereEqual(String field, Y value) {
        SingularAttribute< ? super T, Y> singularAttribute = (SingularAttribute< ? super T, Y>) getMetamodel().getSingularAttribute(field);

        buildWhereEqual(singularAttribute, value);
    }

    <Y extends Comparable< ? super Y>> void handleWhereGreaterOrEqual(String field, Y value) {
        SingularAttribute< ? super T, Y> singularAttribute = (SingularAttribute< ? super T, Y>) getMetamodel().getSingularAttribute(field);

        buildWhereGreaterThanOrEqualTo(singularAttribute, value);
    }

    void handleWhereLikeIgnoreCase(String field, String value) {
        SingularAttribute< ? super T, String> singularAttribute = (SingularAttribute< ? super T, String>) getMetamodel().getSingularAttribute(field);

        buildWhereLikeIgnoreCase(singularAttribute, value);
    }

    void handleWhereI18N(String field, String value, String prefixI18N) {
        if (value != null) {
            SingularAttribute< ? super T, String> singularAttribute = (SingularAttribute< ? super T, String>) getMetamodel().getSingularAttribute(field);

            getWheres().add(buildPredicateI18N(singularAttribute, value, prefixI18N));
        }
    }

    private Predicate buildPredicateI18N(SingularAttribute< ? super T, String> singularAttribute, String value, String prefixI18N) {
        String keyClass = prefixI18N;

        if (StringUtils.isBlank(keyClass)) {
            keyClass = getMetamodel().getJavaType().getSimpleName() + "Model";
        }

        Collection<String> keys = Messages.getKeys(keyClass, value);

        if (keys.size() > ModelProperties.getInstance().inClauseMaxLength()) {
            throw new AppException(EStatusReason.MAX_LENGTH_IN_IN_CLAUSE_REACHED);
        }

        return builder.isMember(root.get(singularAttribute), builder.literal(keys));
    }

    @SuppressWarnings("rawtypes")
    private Predicate buildPredicateEnum(SingularAttribute< ? super T, IEMFEnhancedEnum< ? >> singularAttribute, final String filter, EStructuralFeature feature) {
        EClassifier eClassifier = feature.getEType();

        Collection<IEMFEnhancedEnum< ? >> enums;

        if (IEMFEnhancedEnum.class.isAssignableFrom(eClassifier.getInstanceClass())) {
            enums = ModelUtil.values((Class< ? extends IEMFEnhancedEnum>) eClassifier.getInstanceClass());

            CollectionUtils.filter(enums, new org.apache.commons.collections.Predicate() {
                @Override
                public boolean evaluate(Object arg0) {
                    IEMFEnhancedEnum e = (IEMFEnhancedEnum) arg0;

                    String text = LoyaltyItemProviderAdapter.getLabelText(e, e.eClass().getEStructuralFeature("name"));

                    return text != null && text.indexOf(filter) != -1;
                }
            });
        } else {
            enums = new ArrayList<>();
        }

        return builder.isMember(root.get(singularAttribute), builder.literal(enums));
    }

    <Y extends Serializable> void handleWhereTemplateEqual(String field, AbstractEMFTemplate<Y> value) {
        SingularAttribute< ? super T, Y> singularAttribute = (SingularAttribute< ? super T, Y>) getMetamodel().getSingularAttribute(field);

        buildWhereTemplate(singularAttribute, value);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean hasDynamicOrder() {
        return dynamicOrderDirection != null && !OrderDirectionEMF.NONE.equals(dynamicOrderDirection);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Class<T> getDbModelClass() {
        return (Class<T>) ModelUtil.getAnnotation(eClass(), EAnnotation.DB_MODEL);
    }

    protected void buildDynamicFilters() {
        if (hasDynamicFilters()) {
            List<Predicate> predicates = new ArrayList<>();

            for (EStructuralFeature feature : getDynamicFilterFeatures()) {
                EntityType<T> metaModel = (EntityType<T>) getRoot().getModel();

                SingularAttribute< ? super T, ? > attribute = metaModel.getSingularAttribute(getDbProperty(feature));

                EWhereClauseEMF clause = (EWhereClauseEMF) ModelUtil.getAnnotation(feature, EAnnotation.CLAUSE);

                for (String filter : dynamicFilters) {
                    switch (clause) {
                        case I18N: {
                            String prefixI18N = (String) ModelUtil.getAnnotation(feature, EAnnotation.PREFIX_I18N);

                            predicates.add(buildPredicateI18N((SingularAttribute< ? super T, String>) attribute, filter, prefixI18N));

                            break;
                        }
                        case ENUM:
                            predicates.add(buildPredicateEnum((SingularAttribute< ? super T, IEMFEnhancedEnum< ? >>) attribute, filter, feature));

                            break;
                        default:
                            predicates.add(buildPredicateLikeIgnoreCase((SingularAttribute< ? super T, String>) attribute, filter));
                            break;
                    }
                }
            }

            if (!predicates.isEmpty()) {
                getWheres().add(builder.or(predicates.toArray(new Predicate[] {})));
            }
        }
    }

    /**
     * Build where status.
     */
    protected void buildWhereStatus() {
        if (this instanceof IStatusEMFTemplate) {
            IStatusEMFTemplate template = (IStatusEMFTemplate) this;

            buildWhereEqual(getMetamodel().getSingularAttribute(ModelInterfacesPackage.Literals.ISTATUS_EMF_TEMPLATE__STATUS.getName(), Status.class), template.getStatus());
        }
    }

    /**
     * Build where valid date.
     */
    protected void buildWhereValidDate() {
        if (this instanceof IValidDateTemplate) {
            IValidDateTemplate template = (IValidDateTemplate) this;

            if (template.getValidDate() != null) {
                Date validDate = DateUtils.truncate(template.getValidDate(), Calendar.DAY_OF_MONTH);
                getWheres().add(builder.lessThanOrEqualTo(root.get(getMetamodel().getSingularAttribute(IConstants.T_START, Date.class)), validDate));
                getWheres().add(builder.or(builder.isNull(root.get(getMetamodel().getSingularAttribute(IConstants.T_END, Date.class))),
                        builder.greaterThanOrEqualTo(root.get(getMetamodel().getSingularAttribute(IConstants.T_END, Date.class)), validDate)));
            }
        } else if (this instanceof IValidDateTime) {
            IValidDateTime template = (IValidDateTime) this;

            Date validDate = template.getValidDateTime();
            if (validDate != null) {
                getWheres().add(builder.lessThanOrEqualTo(root.get(getMetamodel().getSingularAttribute(IConstants.T_START, Date.class)), validDate));
                getWheres().add(builder.or(builder.isNull(root.get(getMetamodel().getSingularAttribute(IConstants.T_END, Date.class))),
                        builder.greaterThanOrEqualTo(root.get(getMetamodel().getSingularAttribute(IConstants.T_END, Date.class)), validDate)));
            }
        }
    }

    /**
     * Build where from to date.
     */
    protected void buildWhereFromToDate() {
        if (this instanceof IFromToDateTemplate) {
            IFromToDateTemplate template = (IFromToDateTemplate) this;

            Date from = template.getFrom();
            if (from != null) {
                from = ModelUtil.safeSetDateTruncate(from);
                getWheres().add(builder.or(builder.isNull(root.get(getMetamodel().getSingularAttribute(IConstants.T_END, Date.class))),
                        builder.greaterThanOrEqualTo(root.get(getMetamodel().getSingularAttribute(IConstants.T_END, Date.class)), from)));
            }
            Date to = template.getTo();
            if (to != null) {
                to = ModelUtil.safeSetDateTruncate(to);
                getWheres().add(builder.lessThanOrEqualTo(root.get(getMetamodel().getSingularAttribute(IConstants.T_START, Date.class)), to));
            }
        }
    }

    protected <Y extends Serializable> void buildWhereEqual(SingularAttribute< ? super T, Y> field, Y value) {
        if (value != null) {
            getWheres().add(builder.equal(root.get(field), value));
        }
    }

    /**
     * Build where equal match null.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected <Y extends Serializable> void buildWhereEqualMatchNull(SingularAttribute< ? super T, Y> field, Y value) {
        if (value == null) {
            buildWhereIsNull(field);
        } else {
            buildWhereEqual(field, value);
        }
    }

    /**
     * Build where not equal.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected <Y extends Serializable> void buildWhereNotEqual(SingularAttribute< ? super T, Y> field, Y value) {
        if (value != null) {
            getWheres().add(builder.not(builder.equal(root.get(field), value)));
        }
    }

    /**
     * Build where equal or null.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected <Y extends Serializable> void buildWhereEqualOrNull(SingularAttribute< ? super T, Y> field, Y value) {
        if (value != null) {
            getWheres().add(builder.or(builder.isNull(root.get(field)), builder.equal(root.get(field), value)));
        }
    }

    /**
     * Build where id equal.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected <Y, V extends Serializable> void buildWhereIdEqual(SingularAttribute< ? super T, Y> id, SingularAttribute< ? super Y, V> field, V value) {
        if (value != null) {
            getWheres().add(builder.equal(root.get(id).get(field), value));
        }
    }

    /**
     * Build where equal ignore case.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected void buildWhereEqualIgnoreCase(SingularAttribute< ? super T, String> field, String value) {
        if (value != null) {
            getWheres().add(builder.equal(builder.lower(root.get(field)), StringUtils.trim(StringUtils.lowerCase(value))));
        }
    }

    /**
     * Build where like ignore case.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected void buildWhereLikeIgnoreCase(SingularAttribute< ? super T, String> field, String value) {
        buildWhereLikeIgnoreCase(field, value, null);
    }

    /**
     * Build where like ignore case.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     * @param pattern
     *            the pattern
     */
    protected void buildWhereLikeIgnoreCase(SingularAttribute< ? super T, String> field, String value, String pattern) {
        if (value != null) {
            if (pattern == null) {
                getWheres().add(buildPredicateLikeIgnoreCase(field, value));
            } else {
                getWheres().add(buildPredicateLikeIgnoreCasePattern(field, pattern));
            }
        }
    }

    protected Predicate buildPredicateLikeIgnoreCase(SingularAttribute< ? super T, String> field, String value) {
        return builder.like(builder.lower(root.get(field)), forLikeIgnoreCase(value));
    }

    protected Predicate buildPredicateLikeIgnoreCasePattern(SingularAttribute< ? super T, String> field, String pattern) {
        return builder.like(builder.lower(root.get(field)), StringUtils.trim(StringUtils.lowerCase(pattern)));
    }

    /**
     * Build where like.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected void buildWhereLike(SingularAttribute< ? super T, String> field, String value) {
        buildWhereLike(field, value, null);
    }

    /**
     * Build where like.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     * @param pattern
     *            the pattern
     */
    protected void buildWhereLike(SingularAttribute< ? super T, String> field, String value, String pattern) {
        if (value != null) {
            if (pattern == null) {
                getWheres().add(builder.like(root.get(field), forLike(value)));
            } else {
                getWheres().add(builder.like(root.get(field), pattern));
            }
        }
    }

    /**
     * Build where i 18 n.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    @SuppressWarnings("rawtypes")
    protected void buildWhereI18N(SetAttribute< ? super T, DictionaryEMF> field, String value) {
        if (value != null) {
            DictionaryEMFTemplate dictionaryTemplate = ModelTemplateFactory.eINSTANCE.createDictionaryEMFTemplate();
            dictionaryTemplate.setValue(value);

            buildWhereTemplate((SetAttribute) field, dictionaryTemplate);
        }
    }

    /**
     * Build where in.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected <Y extends Serializable> void buildWhereIn(SingularAttribute< ? super T, Y> field, Collection<Y> value) {
        if (ModelUtil.safeIsNotEmpty(value)) {
            getWheres().add(root.get(field).in(value));
        }
    }

    /**
     * Build where in or null.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected <Y extends Serializable> void buildWhereInOrNull(SingularAttribute< ? super T, Y> field, Collection<Y> value) {
        if (ModelUtil.safeIsNotEmpty(value)) {
            getWheres().add(builder.or(builder.isNull(root.get(field)), root.get(field).in(value)));
        }
    }

    /**
     * Build where is not null.
     *
     * @param field
     *            the field
     */
    protected <Y extends Serializable> void buildWhereIsNotNull(SingularAttribute< ? super T, Y> field) {
        getWheres().add(builder.isNotNull(root.get(field)));
    }

    /**
     * Build where not in.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected <Y extends Serializable> void buildWhereNotIn(SingularAttribute< ? super T, Y> field, Collection<Y> value) {
        if (ModelUtil.safeIsNotEmpty(value)) {
            getWheres().add(builder.not(root.get(field).in(value)));
        }
    }

    /**
     * Build where is null.
     *
     * @param field
     *            the field
     */
    protected <Y extends Serializable> void buildWhereIsNull(SingularAttribute< ? super T, Y> field) {
        getWheres().add(builder.isNull(root.get(field)));
    }

    @SuppressWarnings("rawtypes")
    protected <Y extends Serializable> void buildWhereIsEmpty(SetAttribute< ? super T, Y> field) {
        getWheres().add(builder.isEmpty(root.get((SetAttribute) field)));
    }

    @SuppressWarnings("rawtypes")
    protected <Y extends Serializable> void buildWhereContains(SetAttribute< ? super T, Y> field, Y value) {
        getWheres().add(builder.isMember(value, root.get((SetAttribute) field)));
    }

    /**
     * Build where less than or equal to.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected <Y extends Comparable< ? super Y>> void buildWhereLessThanOrEqualTo(SingularAttribute< ? super T, Y> field, Y value) {
        if (value != null) {
            getWheres().add(builder.lessThanOrEqualTo(root.get(field), value));
        }
    }

    /**
     * Build where greater than or equal to.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected <Y extends Comparable< ? super Y>> void buildWhereGreaterThanOrEqualTo(SingularAttribute< ? super T, Y> field, Y value) {
        if (value != null) {
            getWheres().add(builder.greaterThanOrEqualTo(root.get(field), value));
        }
    }

    /**
     * Build where greater than or equal to or null.
     *
     * @param field
     *            the field
     * @param value
     *            the value
     */
    protected <Y extends Comparable< ? super Y>> void buildWhereGreaterThanOrEqualToOrNull(SingularAttribute< ? super T, Y> field, Y value) {
        if (value != null) {
            getWheres().add(builder.or(builder.isNull(root.get(field)), builder.greaterThanOrEqualTo(root.get(field), value)));
        }
    }

    protected <Y extends Serializable> void buildWhereTemplate(SetAttribute< ? super T, Y> joinField, AbstractEMFTemplate<Y> template) {
        if (root instanceof Join) {
            buildWhereTemplate(joinField, ((Join< ? , ? >) getRoot()).getJoinType(), template);
        } else {
            buildWhereTemplate(joinField, JoinType.INNER, template);
        }
    }

    protected <Y extends Serializable> void buildWhereTemplate(SingularAttribute< ? super T, Y> joinField, AbstractEMFTemplate<Y> template) {
        if (root instanceof Join) {
            buildWhereTemplate(joinField, ((Join< ? , ? >) getRoot()).getJoinType(), template);
        } else {
            buildWhereTemplate(joinField, JoinType.INNER, template);
        }
    }

    protected <Y extends Serializable> void buildWhereTemplate(SingularAttribute< ? super T, Y> joinField, JoinType joinType, AbstractEMFTemplate<Y> template) {
        if (template != null && template.initialized()) {
            template.setRoot(root.join(joinField, joinType));
            template.getWheres().addAll(getWheres());
            template.setBuilder(builder);
            template.setNested(true);
            template.setEntityManager(getEntityManager());

            template.buildWheres();
        }
    }

    protected <Y extends Serializable> void buildWhereTemplate(SetAttribute< ? super T, Y> joinField, JoinType joinType, AbstractEMFTemplate<Y> template) {
        if (template != null && template.initialized()) {
            template.setRoot(root.join(joinField, joinType));
            template.getWheres().addAll(getWheres());
            template.setBuilder(builder);
            template.setNested(true);
            template.setEntityManager(getEntityManager());

            template.buildWheres();
        }
    }

    protected <Y> void buildWhereExists(SingularAttribute<Y, T> joinEntity, SingularAttribute<T, Y> joinField, Boolean exists) {
        if (exists == null) {
            return;
        }

        Class<Y> joinClass = joinEntity.getDeclaringType().getJavaType();
        Subquery<Y> subquery = criteria.subquery(joinClass);
        Root<Y> subroot = subquery.from(joinClass);
        subquery.where(builder.equal(root.get(joinField), subroot.get(joinEntity).get(joinField)));
        subquery.select(subroot);

        if (exists) {
            getWheres().add(builder.exists(subquery));
        } else {
            getWheres().add(builder.not(builder.exists(subquery)));
        }
    }

    /**
     * For like ignore case.
     *
     * @param s
     *            the s
     * @return the string
     */
    private static String forLikeIgnoreCase(String s) {
        return StringUtils.isBlank(s) ? null : '%' + StringUtils.trim(StringUtils.lowerCase(s)) + '%';
    }

    /**
     * For like.
     *
     * @param s
     *            the s
     * @return the string
     */
    private static String forLike(String s) {
        return StringUtils.isBlank(s) ? null : '%' + s + '%';
    }

    /**
     * Check where in.
     *
     * @param object
     *            the object
     * @param field
     *            the field
     * @param values
     *            the values
     * @return the boolean
     */
    protected <Y extends Serializable> boolean checkWhereIn(T object, SingularAttribute< ? super T, Y> field, Collection<Y> values) {
        if (ModelUtil.safeIsNotEmpty(values)) {
            Y value = getValue(object, field);

            return values.contains(value);
        }

        return true;
    }

    /**
     * Check default wheres.
     *
     * @param object
     *            the object
     * @return the boolean
     */
    protected boolean checkDefaultWheres(T object) {
        return checkValidDate(object) && checkFromDate(object) && checkStatus(object);
    }

    protected boolean checkStatus(T object) {
        if (this instanceof IStatusEMFTemplate) {
            IStatusEMFTemplate template = (IStatusEMFTemplate) this;

            return checkWhereEqual(object, getMetamodel().getSingularAttribute(IConstants.STATUS, Status.class), template.getStatus());
        }

        return true;
    }

    /**
     * Check valid date.
     *
     * @param object
     *            the object
     * @return the boolean
     */
    protected boolean checkValidDate(T object) {
        if (this instanceof IValidDateTemplate) {
            IValidDateTemplate template = (IValidDateTemplate) this;

            if (template.getValidDate() != null) {
                Date validDate = DateUtils.truncate(template.getValidDate(), Calendar.DAY_OF_MONTH);

                Date tStart = ModelUtil.safeSetDateTruncate(getValue(object, getMetamodel().getSingularAttribute(IConstants.T_START, Date.class)));
                if (tStart.after(validDate)) {
                    return false;
                }

                Date tEnd = ModelUtil.safeSetDateTruncate(getValue(object, getMetamodel().getSingularAttribute(IConstants.T_END, Date.class)));
                if (tEnd != null && tEnd.before(validDate)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Check from date.
     *
     * @param object
     *            the object
     * @return the boolean
     */
    protected boolean checkFromDate(T object) {
        if (this instanceof IFromToDateTemplate) {
            IFromToDateTemplate template = (IFromToDateTemplate) this;

            if (template.getFrom() != null) {
                Date tEnd = ModelUtil.safeSetDateTruncate(getValue(object, getMetamodel().getSingularAttribute(IConstants.T_END, Date.class)));

                if (tEnd != null && tEnd.before(template.getFrom())) {
                    return false;
                }
            }

            if (template.getTo() != null) {
                Date tStart = ModelUtil.safeSetDateTruncate(getValue(object, getMetamodel().getSingularAttribute(IConstants.T_START, Date.class)));

                if (tStart.after(template.getTo())) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Check where equal.
     *
     * @param object
     *            the object
     * @param field
     *            the field
     * @param value
     *            the value
     * @return the boolean
     */
    protected <Y extends Serializable> boolean checkWhereEqual(T object, SingularAttribute< ? super T, Y> field, Y value) {
        if (value != null) {
            Y fieldValue = getValue(object, field);
            return fieldValue != null && fieldValue.equals(value);
        }

        return true;
    }

    /**
     * Gets value.
     *
     * @param object
     *            the object
     * @param field
     *            the field
     * @return the value
     */
    protected <Y extends Serializable> Y getValue(T object, SingularAttribute< ? super T, Y> field) {
        PropertyDescriptor propertyDescriptor;
        try {
            propertyDescriptor = PropertyUtils.getPropertyDescriptor(object, field.getName());

            return (Y) propertyDescriptor.getReadMethod().invoke(object, (Object[]) null);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public AbstractEMFTemplate<T> clone() {
        try {
            return (AbstractEMFTemplate<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    protected void buildWhereOperatorGroupPermission() {
        if (this instanceof IOperatorGroupPermission) {
            Subject subject = Subject.getSubject(AccessController.getContext());

            if (subject != null) {
                for (Object credential : subject.getPrivateCredentials()) {
                    if (credential instanceof EnhancedEnum< ? , ? >) {
                        String match = '"' + ((EnhancedEnum< ? , String>) credential).getKey() + '"';

                        getWheres().add(builder.equal(builder.locate(builder.coalesce(
                                root.get(getMetamodel().getSingularAttribute(((IOperatorGroupPermission) this).getOperatorGroupPermissionField(), String.class)), " "), match), 0));
                    }
                }
            }
        }
    }

} //AbstractEMFTemplateImpl

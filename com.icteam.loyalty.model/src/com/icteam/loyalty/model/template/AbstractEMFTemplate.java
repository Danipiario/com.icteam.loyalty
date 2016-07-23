/**
 */
package com.icteam.loyalty.model.template;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import javax.persistence.metamodel.ManagedType;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.icteam.loyalty.model.interfaces.IEMFModel;
import com.icteam.loyalty.model.interfaces.IEMFTemplate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract EMF Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getEntityManager <em>Entity Manager</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getWheres <em>Wheres</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getBuilder <em>Builder</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getCriteria <em>Criteria</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getRoot <em>Root</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getExcludedFeatures <em>Excluded Features</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.template.ModelTemplatePackage#getAbstractEMFTemplate()
 * @model abstract="true" TBounds="com.icteam.loyalty.model.interfaces.Serializable"
 * @generated
 */
public interface AbstractEMFTemplate<T extends Serializable> extends IEMFTemplate<T>, IEMFModel {
    /**
     * Returns the value of the '<em><b>Entity Manager</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Entity Manager</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Entity Manager</em>' attribute.
     * @see #setEntityManager(EntityManager)
     * @see com.icteam.loyalty.model.template.ModelTemplatePackage#getAbstractEMFTemplate_EntityManager()
     * @model dataType="com.icteam.loyalty.model.interfaces.EntityManager"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     *        annotation="http://com.icteam.loyalty/property copy='false'"
     * @generated
     */
    EntityManager getEntityManager();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getEntityManager <em>Entity Manager</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Entity Manager</em>' attribute.
     * @see #getEntityManager()
     * @generated
     */
    void setEntityManager(EntityManager value);

    /**
     * Returns the value of the '<em><b>Wheres</b></em>' attribute list.
     * The list contents are of type {@link javax.persistence.criteria.Predicate}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Wheres</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Wheres</em>' attribute list.
     * @see com.icteam.loyalty.model.template.ModelTemplatePackage#getAbstractEMFTemplate_Wheres()
     * @model dataType="com.icteam.loyalty.model.interfaces.Predicate"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     *        annotation="http://com.icteam.loyalty/property copy='false'"
     * @generated
     */
    EList<Predicate> getWheres();

    /**
     * Returns the value of the '<em><b>Builder</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Builder</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Builder</em>' attribute.
     * @see #setBuilder(CriteriaBuilder)
     * @see com.icteam.loyalty.model.template.ModelTemplatePackage#getAbstractEMFTemplate_Builder()
     * @model dataType="com.icteam.loyalty.model.interfaces.CriteriaBuilder"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     *        annotation="http://com.icteam.loyalty/property copy='false'"
     * @generated
     */
    CriteriaBuilder getBuilder();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getBuilder <em>Builder</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Builder</em>' attribute.
     * @see #getBuilder()
     * @generated
     */
    void setBuilder(CriteriaBuilder value);

    /**
     * Returns the value of the '<em><b>Criteria</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Criteria</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Criteria</em>' attribute.
     * @see #setCriteria(CriteriaQuery)
     * @see com.icteam.loyalty.model.template.ModelTemplatePackage#getAbstractEMFTemplate_Criteria()
     * @model dataType="com.icteam.loyalty.model.interfaces.CriteriaQuery<?>"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     *        annotation="http://com.icteam.loyalty/property copy='false'"
     * @generated
     */
    CriteriaQuery< ? > getCriteria();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getCriteria <em>Criteria</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Criteria</em>' attribute.
     * @see #getCriteria()
     * @generated
     */
    void setCriteria(CriteriaQuery< ? > value);

    /**
     * Returns the value of the '<em><b>Root</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Root</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Root</em>' attribute.
     * @see #setRoot(From)
     * @see com.icteam.loyalty.model.template.ModelTemplatePackage#getAbstractEMFTemplate_Root()
     * @model dataType="com.icteam.loyalty.model.interfaces.From<?, T>"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     *        annotation="http://com.icteam.loyalty/property copy='false'"
     * @generated
     */
    From< ? , T> getRoot();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.template.AbstractEMFTemplate#getRoot <em>Root</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Root</em>' attribute.
     * @see #getRoot()
     * @generated
     */
    void setRoot(From< ? , T> value);

    /**
     * Returns the value of the '<em><b>Excluded Features</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Excluded Features</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Excluded Features</em>' attribute list.
     * @see com.icteam.loyalty.model.template.ModelTemplatePackage#getAbstractEMFTemplate_ExcludedFeatures()
     * @model dataType="com.icteam.loyalty.model.interfaces.EStructuralFeature"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     *        annotation="http://com.icteam.loyalty/property copy='false'"
     * @generated
     */
    EList<EStructuralFeature> getExcludedFeatures();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" dataType="com.icteam.loyalty.model.interfaces.ManagedType<T>"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return entityManager == null ? null : entityManager.getMetamodel().managedType(getDbModelClass());'"
     * @generated
     */
    ManagedType<T> getMetamodel();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='// nothing'"
     * @generated
     */
    void buildFetches();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model dynamicFilterFeaturesDataType="com.icteam.loyalty.model.interfaces.EStructuralFeature" dynamicFilterFeaturesMany="true" dynamicFiltersMany="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='for (EStructuralFeature feature : dynamicFilterFeatures) {\r\n            if (ModelUtil.isI18NFeature(feature)) {\r\n                for (String dynamicFilter : dynamicFilters) {\r\n                    if (!ModelUtil.checkMinLengthI18N(dynamicFilter)) {\r\n                        throw new AppException(EStatusReason.MIN_CHARACTER_SEARCH_LENGTH, ModelProperties.getInstance().minSearchCharacterI18N());\r\n                    }\r\n                }\r\n            }\r\n        }'"
     * @generated
     */
    void checkDynamicFilters(EList<EStructuralFeature> dynamicFilterFeatures, EList<String> dynamicFilters);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    void buildWheres();

} // AbstractEMFTemplate

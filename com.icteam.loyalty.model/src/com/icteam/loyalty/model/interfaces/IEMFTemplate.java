/**
 */
package com.icteam.loyalty.model.interfaces;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IEMF Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDistinct <em>Distinct</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getFirstResult <em>First Result</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getMaxResults <em>Max Results</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#isSingleResult <em>Single Result</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#isLightSearch <em>Light Search</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#isNested <em>Nested</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getOrderFeatures <em>Order Features</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getOrderDirections <em>Order Directions</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicFilterFeatures <em>Dynamic Filter Features</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicFilters <em>Dynamic Filters</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicOrderFeature <em>Dynamic Order Feature</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicOrderDirection <em>Dynamic Order Direction</em>}</li>
 *   <li>{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicFilterableFeatures <em>Dynamic Filterable Features</em>}</li>
 * </ul>
 *
 * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate()
 * @model interface="true" abstract="true" TBounds="com.icteam.loyalty.model.interfaces.Serializable"
 * @generated
 */
public interface IEMFTemplate<T extends Serializable> extends EObject {
    /**
     * Returns the value of the '<em><b>Distinct</b></em>' attribute.
     * The default value is <code>"SQL"</code>.
     * The literals are from the enumeration {@link com.icteam.loyalty.model.interfaces.DistinctEMF}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Distinct</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Distinct</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.DistinctEMF
     * @see #setDistinct(DistinctEMF)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_Distinct()
     * @model default="SQL" required="true"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    DistinctEMF getDistinct();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDistinct <em>Distinct</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Distinct</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.DistinctEMF
     * @see #getDistinct()
     * @generated
     */
    void setDistinct(DistinctEMF value);

    /**
     * Returns the value of the '<em><b>Max Results</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max Results</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Max Results</em>' attribute.
     * @see #setMaxResults(int)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_MaxResults()
     * @model default="-1"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    int getMaxResults();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getMaxResults <em>Max Results</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max Results</em>' attribute.
     * @see #getMaxResults()
     * @generated
     */
    void setMaxResults(int value);

    /**
     * Returns the value of the '<em><b>Order Directions</b></em>' attribute list.
     * The list contents are of type {@link com.icteam.loyalty.model.interfaces.OrderDirectionEMF}.
     * The literals are from the enumeration {@link com.icteam.loyalty.model.interfaces.OrderDirectionEMF}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Order Directions</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Order Directions</em>' attribute list.
     * @see com.icteam.loyalty.model.interfaces.OrderDirectionEMF
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_OrderDirections()
     * @model transient="true"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    EList<OrderDirectionEMF> getOrderDirections();

    /**
     * Returns the value of the '<em><b>Dynamic Filter Features</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dynamic Filter Features</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dynamic Filter Features</em>' attribute list.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_DynamicFilterFeatures()
     * @model dataType="com.icteam.loyalty.model.interfaces.EStructuralFeature"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    EList<EStructuralFeature> getDynamicFilterFeatures();

    /**
     * Returns the value of the '<em><b>Dynamic Filters</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dynamic Filters</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dynamic Filters</em>' attribute list.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_DynamicFilters()
     * @model annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    EList<String> getDynamicFilters();

    /**
     * Returns the value of the '<em><b>Single Result</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Single Result</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Single Result</em>' attribute.
     * @see #setSingleResult(boolean)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_SingleResult()
     * @model default="false"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    boolean isSingleResult();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#isSingleResult <em>Single Result</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Single Result</em>' attribute.
     * @see #isSingleResult()
     * @generated
     */
    void setSingleResult(boolean value);

    /**
     * Returns the value of the '<em><b>Light Search</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Light Search</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Light Search</em>' attribute.
     * @see #setLightSearch(boolean)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_LightSearch()
     * @model default="false"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    boolean isLightSearch();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#isLightSearch <em>Light Search</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Light Search</em>' attribute.
     * @see #isLightSearch()
     * @generated
     */
    void setLightSearch(boolean value);

    /**
     * Returns the value of the '<em><b>First Result</b></em>' attribute.
     * The default value is <code>"-1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>First Result</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>First Result</em>' attribute.
     * @see #setFirstResult(int)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_FirstResult()
     * @model default="-1"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    int getFirstResult();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getFirstResult <em>First Result</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>First Result</em>' attribute.
     * @see #getFirstResult()
     * @generated
     */
    void setFirstResult(int value);

    /**
     * Returns the value of the '<em><b>Nested</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nested</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Nested</em>' attribute.
     * @see #setNested(boolean)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_Nested()
     * @model default="false"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    boolean isNested();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#isNested <em>Nested</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Nested</em>' attribute.
     * @see #isNested()
     * @generated
     */
    void setNested(boolean value);

    /**
     * Returns the value of the '<em><b>Order Features</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.databinding.FeaturePath}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Order Features</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Order Features</em>' attribute list.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_OrderFeatures()
     * @model dataType="com.icteam.loyalty.model.interfaces.FeaturePath" transient="true"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    EList<FeaturePath> getOrderFeatures();

    /**
     * Returns the value of the '<em><b>Dynamic Order Feature</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dynamic Order Feature</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dynamic Order Feature</em>' attribute.
     * @see #setDynamicOrderFeature(FeaturePath)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_DynamicOrderFeature()
     * @model dataType="com.icteam.loyalty.model.interfaces.FeaturePath" transient="true"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    FeaturePath getDynamicOrderFeature();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicOrderFeature <em>Dynamic Order Feature</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dynamic Order Feature</em>' attribute.
     * @see #getDynamicOrderFeature()
     * @generated
     */
    void setDynamicOrderFeature(FeaturePath value);

    /**
     * Returns the value of the '<em><b>Dynamic Order Direction</b></em>' attribute.
     * The literals are from the enumeration {@link com.icteam.loyalty.model.interfaces.OrderDirectionEMF}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Dynamic Order Direction</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dynamic Order Direction</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.OrderDirectionEMF
     * @see #setDynamicOrderDirection(OrderDirectionEMF)
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_DynamicOrderDirection()
     * @model transient="true"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    OrderDirectionEMF getDynamicOrderDirection();

    /**
     * Sets the value of the '{@link com.icteam.loyalty.model.interfaces.IEMFTemplate#getDynamicOrderDirection <em>Dynamic Order Direction</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Dynamic Order Direction</em>' attribute.
     * @see com.icteam.loyalty.model.interfaces.OrderDirectionEMF
     * @see #getDynamicOrderDirection()
     * @generated
     */
    void setDynamicOrderDirection(OrderDirectionEMF value);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    boolean initialized();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model emDataType="com.icteam.loyalty.model.interfaces.EntityManager"
     * @generated
     */
    Long getResultCount(EntityManager em);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model emDataType="com.icteam.loyalty.model.interfaces.EntityManager"
     * @generated
     */
    <R> R getFirstResult(EntityManager em);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model emDataType="com.icteam.loyalty.model.interfaces.EntityManager"
     * @generated
     */
    <R> EList<R> getResultList(EntityManager em);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return !dynamicFilterFeatures.isEmpty() && !dynamicFilters.isEmpty();'"
     * @generated
     */
    boolean hasDynamicFilters();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model dynamicFilterFeaturesDataType="com.icteam.loyalty.model.interfaces.EStructuralFeature" dynamicFilterFeaturesMany="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='       checkDynamicFilters(dynamicFilterFeatures, getDynamicFilters());\r\n\r\n       eSet(ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTER_FEATURES, dynamicFilterFeatures);\r\n'"
     * @generated
     */
    void setDynamicFilterFeatures(EList<EStructuralFeature> dynamicFilterFeatures);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='        BasicEList<String> filterList = ECollections.newBasicEList(StringUtils.stripAll(StringUtils.split(StringUtils.defaultString(rawFilter))));\r\n\r\n        checkDynamicFilters(getDynamicFilterFeatures(), filterList);\r\n\r\n        eSet(ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERS, filterList);\r\n'"
     * @generated
     */
    void setRawFilter(String rawFilter);

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='return dynamicOrderDirection != null && !OrderDirectionEMF.NONE.equals(dynamicOrderDirection);'"
     * @generated
     */
    boolean hasDynamicOrder();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return  (Class<T>) ModelUtil.getAnnotation(eClass(), EAnnotation.DB_MODEL);'"
     * @generated
     */
    Class<T> getDbModelClass();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return eGet(eClass().getEIDAttribute());'"
     * @generated
     */
    Object getIdValue();

    /**
     * Returns the value of the '<em><b>Dynamic Filterable Features</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the value of the '<em>Dynamic Filterable Features</em>' attribute list.
     * @see com.icteam.loyalty.model.interfaces.ModelInterfacesPackage#getIEMFTemplate_DynamicFilterableFeatures()
     * @model dataType="com.icteam.loyalty.model.interfaces.EStructuralFeature" transient="true" changeable="false"
     *        annotation="http://com.icteam.loyalty/where clause='NONE'"
     * @generated
     */
    EList<EStructuralFeature> getDynamicFilterableFeatures();

} // IEMFTemplate

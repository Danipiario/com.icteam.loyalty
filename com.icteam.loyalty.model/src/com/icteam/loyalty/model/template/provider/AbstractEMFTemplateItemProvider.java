/**
 */
package com.icteam.loyalty.model.template.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.icteam.loyalty.model.interfaces.DistinctEMF;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.provider.LoyaltyItemProviderAdapter;
import com.icteam.loyalty.model.provider.ModelEditPlugin;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.model.template.ModelTemplatePackage;

/**
 * This is the item provider adapter for a {@link com.icteam.loyalty.model.template.AbstractEMFTemplate} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AbstractEMFTemplateItemProvider extends LoyaltyItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AbstractEMFTemplateItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);

            addDistinctPropertyDescriptor(object);
            addFirstResultPropertyDescriptor(object);
            addMaxResultsPropertyDescriptor(object);
            addSingleResultPropertyDescriptor(object);
            addLightSearchPropertyDescriptor(object);
            addNestedPropertyDescriptor(object);
            addOrderFeaturesPropertyDescriptor(object);
            addOrderDirectionsPropertyDescriptor(object);
            addDynamicFilterFeaturesPropertyDescriptor(object);
            addDynamicFiltersPropertyDescriptor(object);
            addDynamicOrderFeaturePropertyDescriptor(object);
            addDynamicOrderDirectionPropertyDescriptor(object);
            addDynamicFilterableFeaturesPropertyDescriptor(object);
            addEditablePropertyDescriptor(object);
            addDirtyPropertyDescriptor(object);
            addEntityManagerPropertyDescriptor(object);
            addWheresPropertyDescriptor(object);
            addBuilderPropertyDescriptor(object);
            addCriteriaPropertyDescriptor(object);
            addRootPropertyDescriptor(object);
            addExcludedFeaturesPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Distinct feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDistinctPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_distinct_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_distinct_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DISTINCT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the First Result feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addFirstResultPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_firstResult_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_firstResult_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__FIRST_RESULT, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null,
                null));
    }

    /**
     * This adds a property descriptor for the Max Results feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMaxResultsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_maxResults_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_maxResults_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__MAX_RESULTS, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null,
                null));
    }

    /**
     * This adds a property descriptor for the Single Result feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSingleResultPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_singleResult_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_singleResult_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__SINGLE_RESULT, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null,
                null));
    }

    /**
     * This adds a property descriptor for the Light Search feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addLightSearchPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_lightSearch_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_lightSearch_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__LIGHT_SEARCH, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null,
                null));
    }

    /**
     * This adds a property descriptor for the Nested feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNestedPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_nested_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_nested_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__NESTED, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Order Features feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOrderFeaturesPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_orderFeatures_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_orderFeatures_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__ORDER_FEATURES, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
                null));
    }

    /**
     * This adds a property descriptor for the Order Directions feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOrderDirectionsPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_orderDirections_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_orderDirections_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__ORDER_DIRECTIONS, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                null, null));
    }

    /**
     * This adds a property descriptor for the Dynamic Filter Features feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDynamicFilterFeaturesPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_dynamicFilterFeatures_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_dynamicFilterFeatures_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DYNAMIC_FILTER_FEATURES, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Dynamic Filters feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDynamicFiltersPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_dynamicFilters_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_dynamicFilters_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DYNAMIC_FILTERS, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                null, null));
    }

    /**
     * This adds a property descriptor for the Dynamic Order Feature feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDynamicOrderFeaturePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_dynamicOrderFeature_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_dynamicOrderFeature_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DYNAMIC_ORDER_FEATURE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                null, null));
    }

    /**
     * This adds a property descriptor for the Dynamic Order Direction feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDynamicOrderDirectionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_dynamicOrderDirection_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_dynamicOrderDirection_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Dynamic Filterable Features feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDynamicFilterableFeaturesPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEMFTemplate_dynamicFilterableFeatures_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEMFTemplate_dynamicFilterableFeatures_feature", "_UI_IEMFTemplate_type"),
                ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES, false, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Editable feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEditablePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEditable_editable_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEditable_editable_feature", "_UI_IEditable_type"),
                ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Dirty feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDirtyPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_IEditable_dirty_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IEditable_dirty_feature", "_UI_IEditable_type"),
                ModelInterfacesPackage.Literals.IEDITABLE__DIRTY, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Entity Manager feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEntityManagerPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_AbstractEMFTemplate_entityManager_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractEMFTemplate_entityManager_feature", "_UI_AbstractEMFTemplate_type"),
                ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE__ENTITY_MANAGER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                null, null));
    }

    /**
     * This adds a property descriptor for the Wheres feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addWheresPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_AbstractEMFTemplate_wheres_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractEMFTemplate_wheres_feature", "_UI_AbstractEMFTemplate_type"),
                ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE__WHERES, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
                null));
    }

    /**
     * This adds a property descriptor for the Builder feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBuilderPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_AbstractEMFTemplate_builder_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractEMFTemplate_builder_feature", "_UI_AbstractEMFTemplate_type"),
                ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE__BUILDER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
                null));
    }

    /**
     * This adds a property descriptor for the Criteria feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addCriteriaPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_AbstractEMFTemplate_criteria_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractEMFTemplate_criteria_feature", "_UI_AbstractEMFTemplate_type"),
                ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE__CRITERIA, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
                null));
    }

    /**
     * This adds a property descriptor for the Root feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addRootPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                        getString("_UI_AbstractEMFTemplate_root_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_AbstractEMFTemplate_root_feature", "_UI_AbstractEMFTemplate_type"),
                        ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE__ROOT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null, null));
    }

    /**
     * This adds a property descriptor for the Excluded Features feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addExcludedFeaturesPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_AbstractEMFTemplate_excludedFeatures_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_AbstractEMFTemplate_excludedFeatures_feature", "_UI_AbstractEMFTemplate_type"),
                ModelTemplatePackage.Literals.ABSTRACT_EMF_TEMPLATE__EXCLUDED_FEATURES, true, false, false,
                ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        DistinctEMF labelValue = ((AbstractEMFTemplate< ? >) object).getDistinct();
        String label = labelValue == null ? null : labelValue.toString();
        return label == null || label.length() == 0 ? getString("_UI_AbstractEMFTemplate_type") : getString("_UI_AbstractEMFTemplate_type")
                + " "
                + label;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);

        switch (notification.getFeatureID(AbstractEMFTemplate.class)) {
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DISTINCT:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__FIRST_RESULT:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__MAX_RESULTS:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__SINGLE_RESULT:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__LIGHT_SEARCH:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__NESTED:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ORDER_FEATURES:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ORDER_DIRECTIONS:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTER_FEATURES:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERS:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_FEATURE:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_ORDER_DIRECTION:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EDITABLE:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__DIRTY:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ENTITY_MANAGER:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__WHERES:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__BUILDER:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__CRITERIA:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__ROOT:
            case ModelTemplatePackage.ABSTRACT_EMF_TEMPLATE__EXCLUDED_FEATURES:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
        }
        super.notifyChanged(notification);
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return ModelEditPlugin.INSTANCE;
    }

}

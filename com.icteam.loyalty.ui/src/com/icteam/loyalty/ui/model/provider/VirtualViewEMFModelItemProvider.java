/**
 */
package com.icteam.loyalty.ui.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.icteam.loyalty.model.provider.EMFModelItemProvider;
import com.icteam.loyalty.ui.interfaces.UIInterfacesFactory;
import com.icteam.loyalty.ui.interfaces.UIInterfacesPackage;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;
import com.icteam.loyalty.ui.provider.UIEditPlugin;

/**
 * This is the item provider adapter for a {@link com.icteam.loyalty.ui.model.VirtualViewEMFModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VirtualViewEMFModelItemProvider extends EMFModelItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VirtualViewEMFModelItemProvider(AdapterFactory adapterFactory) {
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

            addBaseClassPropertyDescriptor(object);
            addTemplatePropertyDescriptor(object);
            addFilterPropertyDescriptor(object);
            addListPropertyDescriptor(object);
            addSearchProviderPropertyDescriptor(object);
            addSelectedListPropertyDescriptor(object);
            addOpenEditorActionPropertyDescriptor(object);
            addFilterColumnsActionPropertyDescriptor(object);
            addAdvancedFilterActionPropertyDescriptor(object);
            addRefreshActionPropertyDescriptor(object);
            addSelectColumnActionPropertyDescriptor(object);
            addAddActionPropertyDescriptor(object);
            addRemoveActionPropertyDescriptor(object);
            addItemCountPropertyDescriptor(object);
            addViewIDPropertyDescriptor(object);
            addModelClassPropertyDescriptor(object);
            addTemplateClassPropertyDescriptor(object);
            addColumnDomainModelReferencesPropertyDescriptor(object);
            addEditorModelEClassPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Base Class feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBaseClassPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_IBaseClassProvider_baseClass_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IBaseClassProvider_baseClass_feature", "_UI_IBaseClassProvider_type"),
                UIInterfacesPackage.Literals.IBASE_CLASS_PROVIDER__BASE_CLASS, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Search Provider feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSearchProviderPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_searchProvider_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_searchProvider_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__SEARCH_PROVIDER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Selected List feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSelectedListPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_selectedList_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_selectedList_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Open Editor Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOpenEditorActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_openEditorAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_openEditorAction_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__OPEN_EDITOR_ACTION, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Item Count feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addItemCountPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_itemCount_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_itemCount_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the View ID feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addViewIDPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_viewID_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_viewID_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__VIEW_ID, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Model Class feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addModelClassPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_modelClass_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_modelClass_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__MODEL_CLASS, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Template Class feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTemplateClassPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_templateClass_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_templateClass_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__TEMPLATE_CLASS, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Column Domain Model References feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addColumnDomainModelReferencesPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_columnDomainModelReferences_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_columnDomainModelReferences_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__COLUMN_DOMAIN_MODEL_REFERENCES, true, false, true, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Editor Model EClass feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEditorModelEClassPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_editorModelEClass_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_editorModelEClass_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__EDITOR_MODEL_ECLASS, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Refresh Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addRefreshActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_refreshAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_refreshAction_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__REFRESH_ACTION, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Select Column Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSelectColumnActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_selectColumnAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_selectColumnAction_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__SELECT_COLUMN_ACTION, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Add Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAddActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_addAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_addAction_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__ADD_ACTION, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Remove Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addRemoveActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_removeAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_removeAction_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__REMOVE_ACTION, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Filter Columns Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addFilterColumnsActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_filterColumnsAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_filterColumnsAction_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__FILTER_COLUMNS_ACTION, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Advanced Filter Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAdvancedFilterActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_advancedFilterAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_advancedFilterAction_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__ADVANCED_FILTER_ACTION, false, false, false, null, null, null));
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Collection< ? extends EStructuralFeature> getChildrenFeatures(Object object) {
        if (childrenFeatures == null) {
            super.getChildrenFeatures(object);
            childrenFeatures.add(UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__COLUMN_WIDTHS);
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature(Object object, Object child) {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature(object, child);
    }

    /**
     * This returns VirtualViewEMFModel.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/VirtualViewEMFModel"));
    }

    /**
     * This adds a property descriptor for the Template feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTemplatePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_template_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_template_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__TEMPLATE, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Filter feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addFilterPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_filter_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_filter_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__FILTER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the List feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addListPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_VirtualViewEMFModel_list_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_VirtualViewEMFModel_list_feature", "_UI_VirtualViewEMFModel_type"),
                UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__LIST, true, false, true, null, null, null));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        VirtualViewEMFModel< ? , ? > virtualViewEMFModel = (VirtualViewEMFModel< ? , ? >) object;
        return getString("_UI_VirtualViewEMFModel_type") + " " + virtualViewEMFModel.isEditable();
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

        switch (notification.getFeatureID(VirtualViewEMFModel.class)) {
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__BASE_CLASS:
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__FILTER:
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__SEARCH_PROVIDER:
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT:
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__VIEW_ID:
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__MODEL_CLASS:
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__TEMPLATE_CLASS:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
                return;
            case UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__COLUMN_WIDTHS:
                fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
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

        newChildDescriptors.add(createChildParameter(UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__COLUMN_WIDTHS,
                UIInterfacesFactory.eINSTANCE.create(UIInterfacesPackage.Literals.ESTRUCTURAL_FEATURE_TO_INT_MAP)));
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return UIEditPlugin.INSTANCE;
    }

}

/**
 */
package com.icteam.loyalty.model.interfaces.provider;

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

import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.interfaces.StatusReason;
import com.icteam.loyalty.model.provider.LoyaltyItemProviderAdapter;
import com.icteam.loyalty.model.provider.ModelEditPlugin;

/**
 * This is the item provider adapter for a {@link com.icteam.loyalty.model.interfaces.StatusReason} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StatusReasonItemProvider extends LoyaltyItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider,
        ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StatusReasonItemProvider(AdapterFactory adapterFactory) {
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

            addOKPropertyDescriptor(object);
            addERRORPropertyDescriptor(object);
            addOBJECT_UNKNOWNPropertyDescriptor(object);
            addMAX_LENGTH_IN_IN_CLAUSE_REACHEDPropertyDescriptor(object);
            addREFERENCED_OBJECT_FOUNDPropertyDescriptor(object);
            addCUSTOM_MESSAGE_ADD_ERRORPropertyDescriptor(object);
            addDELEGATED_SERVICE_NOT_FOUNDPropertyDescriptor(object);
            addMIN_CHARACTER_SEARCH_LENGTHPropertyDescriptor(object);
            addCRON_EXPRESSION_INVALIDPropertyDescriptor(object);
            addSERVICE_NOT_FOUNDPropertyDescriptor(object);
            addCodePropertyDescriptor(object);
            addPluginIdPropertyDescriptor(object);
            addNamePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_StatusReason_name_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_name_feature", "_UI_StatusReason_type"),
                ModelInterfacesPackage.Literals.STATUS_REASON__NAME, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Code feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addCodePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_StatusReason_code_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_code_feature", "_UI_StatusReason_type"),
                ModelInterfacesPackage.Literals.STATUS_REASON__CODE, false, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Plugin Id feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addPluginIdPropertyDescriptor(Object object) {
        itemPropertyDescriptors
                .add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                        getString("_UI_StatusReason_pluginId_feature"),
                        getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_pluginId_feature", "_UI_StatusReason_type"),
                        ModelInterfacesPackage.Literals.STATUS_REASON__PLUGIN_ID, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null, null));
    }

    /**
     * This adds a property descriptor for the OK feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOKPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_StatusReason_OK_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_OK_feature", "_UI_StatusReason_type"),
                ModelInterfacesPackage.Literals.STATUS_REASON__OK, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the ERROR feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addERRORPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_StatusReason_ERROR_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_ERROR_feature", "_UI_StatusReason_type"),
                ModelInterfacesPackage.Literals.STATUS_REASON__ERROR, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the OBJECT UNKNOWN feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOBJECT_UNKNOWNPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_StatusReason_OBJECT_UNKNOWN_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_OBJECT_UNKNOWN_feature", "_UI_StatusReason_type"),
                ModelInterfacesPackage.Literals.STATUS_REASON__OBJECT_UNKNOWN, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the MAX LENGTH IN IN CLAUSE REACHED feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMAX_LENGTH_IN_IN_CLAUSE_REACHEDPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_StatusReason_MAX_LENGTH_IN_IN_CLAUSE_REACHED_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_MAX_LENGTH_IN_IN_CLAUSE_REACHED_feature", "_UI_StatusReason_type"),
                ModelInterfacesPackage.Literals.STATUS_REASON__MAX_LENGTH_IN_IN_CLAUSE_REACHED, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the REFERENCED OBJECT FOUND feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addREFERENCED_OBJECT_FOUNDPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_StatusReason_REFERENCED_OBJECT_FOUND_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_REFERENCED_OBJECT_FOUND_feature", "_UI_StatusReason_type"),
                ModelInterfacesPackage.Literals.STATUS_REASON__REFERENCED_OBJECT_FOUND, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the CUSTOM MESSAGE ADD ERROR feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addCUSTOM_MESSAGE_ADD_ERRORPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_StatusReason_CUSTOM_MESSAGE_ADD_ERROR_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_CUSTOM_MESSAGE_ADD_ERROR_feature", "_UI_StatusReason_type"),
                ModelInterfacesPackage.Literals.STATUS_REASON__CUSTOM_MESSAGE_ADD_ERROR, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the DELEGATED SERVICE NOT FOUND feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDELEGATED_SERVICE_NOT_FOUNDPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_StatusReason_DELEGATED_SERVICE_NOT_FOUND_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_DELEGATED_SERVICE_NOT_FOUND_feature", "_UI_StatusReason_type"),
                ModelInterfacesPackage.Literals.STATUS_REASON__DELEGATED_SERVICE_NOT_FOUND, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the MIN CHARACTER SEARCH LENGTH feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMIN_CHARACTER_SEARCH_LENGTHPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_StatusReason_MIN_CHARACTER_SEARCH_LENGTH_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_MIN_CHARACTER_SEARCH_LENGTH_feature", "_UI_StatusReason_type"),
                ModelInterfacesPackage.Literals.STATUS_REASON__MIN_CHARACTER_SEARCH_LENGTH, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the CRON EXPRESSION INVALID feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addCRON_EXPRESSION_INVALIDPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_StatusReason_CRON_EXPRESSION_INVALID_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_CRON_EXPRESSION_INVALID_feature", "_UI_StatusReason_type"),
                ModelInterfacesPackage.Literals.STATUS_REASON__CRON_EXPRESSION_INVALID, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the SERVICE NOT FOUND feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSERVICE_NOT_FOUNDPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_StatusReason_SERVICE_NOT_FOUND_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_StatusReason_SERVICE_NOT_FOUND_feature", "_UI_StatusReason_type"),
                ModelInterfacesPackage.Literals.STATUS_REASON__SERVICE_NOT_FOUND, false, false, false, null, null, null));
    }

    /**
     * This returns StatusReason.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/StatusReason"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((StatusReason) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_StatusReason_type") : getString("_UI_StatusReason_type") + " " + label;
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

        switch (notification.getFeatureID(StatusReason.class)) {
            case ModelInterfacesPackage.STATUS_REASON__CODE:
            case ModelInterfacesPackage.STATUS_REASON__PLUGIN_ID:
            case ModelInterfacesPackage.STATUS_REASON__NAME:
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

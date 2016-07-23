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
import com.icteam.loyalty.model.interfaces.Permission;
import com.icteam.loyalty.model.provider.LoyaltyItemProviderAdapter;
import com.icteam.loyalty.model.provider.ModelEditPlugin;

/**
 * This is the item provider adapter for a {@link com.icteam.loyalty.model.interfaces.Permission} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PermissionItemProvider extends LoyaltyItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider,
ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PermissionItemProvider(AdapterFactory adapterFactory) {
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

            addADMINISTRATION_PERSPECTIVE_VIEWPropertyDescriptor(object);
            addCONFIGURATION_PERSPECTIVE_VIEWPropertyDescriptor(object);
            addObjectPropertyDescriptor(object);
            addActionPropertyDescriptor(object);
            addNamePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the ADMINISTRATION PERSPECTIVE VIEW feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addADMINISTRATION_PERSPECTIVE_VIEWPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_Permission_ADMINISTRATION_PERSPECTIVE_VIEW_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Permission_ADMINISTRATION_PERSPECTIVE_VIEW_feature", "_UI_Permission_type"),
                ModelInterfacesPackage.Literals.PERMISSION__ADMINISTRATION_PERSPECTIVE_VIEW, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the CONFIGURATION PERSPECTIVE VIEW feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addCONFIGURATION_PERSPECTIVE_VIEWPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_Permission_CONFIGURATION_PERSPECTIVE_VIEW_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Permission_CONFIGURATION_PERSPECTIVE_VIEW_feature", "_UI_Permission_type"),
                ModelInterfacesPackage.Literals.PERMISSION__CONFIGURATION_PERSPECTIVE_VIEW, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNamePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_Permission_name_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Permission_name_feature", "_UI_Permission_type"),
                ModelInterfacesPackage.Literals.PERMISSION__NAME, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Object feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addObjectPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_Permission_object_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Permission_object_feature", "_UI_Permission_type"),
                ModelInterfacesPackage.Literals.PERMISSION__OBJECT, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_Permission_action_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Permission_action_feature", "_UI_Permission_type"),
                ModelInterfacesPackage.Literals.PERMISSION__ACTION, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns Permission.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/Permission"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((Permission) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_Permission_type") : getString("_UI_Permission_type") + " " + label;
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

        switch (notification.getFeatureID(Permission.class)) {
            case ModelInterfacesPackage.PERMISSION__OBJECT:
            case ModelInterfacesPackage.PERMISSION__ACTION:
            case ModelInterfacesPackage.PERMISSION__NAME:
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

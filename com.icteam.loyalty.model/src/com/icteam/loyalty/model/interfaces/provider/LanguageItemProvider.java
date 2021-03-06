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

import com.icteam.loyalty.model.interfaces.Language;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.provider.LoyaltyItemProviderAdapter;
import com.icteam.loyalty.model.provider.ModelEditPlugin;

/**
 * This is the item provider adapter for a {@link com.icteam.loyalty.model.interfaces.Language} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LanguageItemProvider extends LoyaltyItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider,
ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LanguageItemProvider(AdapterFactory adapterFactory) {
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

            addITALIANPropertyDescriptor(object);
            addENGLISHPropertyDescriptor(object);
            addDefaultLanguagePropertyDescriptor(object);
            addLocalePropertyDescriptor(object);
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
                getResourceLocator(), getString("_UI_Language_name_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Language_name_feature", "_UI_Language_type"),
                ModelInterfacesPackage.Literals.LANGUAGE__NAME, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the Default Language feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultLanguagePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_Language_defaultLanguage_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Language_defaultLanguage_feature", "_UI_Language_type"),
                ModelInterfacesPackage.Literals.LANGUAGE__DEFAULT_LANGUAGE, false, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null,
                null));
    }

    /**
     * This adds a property descriptor for the Locale feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addLocalePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_Language_locale_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Language_locale_feature", "_UI_Language_type"),
                ModelInterfacesPackage.Literals.LANGUAGE__LOCALE, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This adds a property descriptor for the ITALIAN feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addITALIANPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_Language_ITALIAN_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Language_ITALIAN_feature", "_UI_Language_type"),
                ModelInterfacesPackage.Literals.LANGUAGE__ITALIAN, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the ENGLISH feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addENGLISHPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
                getResourceLocator(), getString("_UI_Language_ENGLISH_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_Language_ENGLISH_feature", "_UI_Language_type"),
                ModelInterfacesPackage.Literals.LANGUAGE__ENGLISH, false, false, false, null, null, null));
    }

    /**
     * This returns Language.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/Language"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((Language) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_Language_type") : getString("_UI_Language_type") + " " + label;
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

        switch (notification.getFeatureID(Language.class)) {
            case ModelInterfacesPackage.LANGUAGE__DEFAULT_LANGUAGE:
            case ModelInterfacesPackage.LANGUAGE__LOCALE:
            case ModelInterfacesPackage.LANGUAGE__NAME:
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

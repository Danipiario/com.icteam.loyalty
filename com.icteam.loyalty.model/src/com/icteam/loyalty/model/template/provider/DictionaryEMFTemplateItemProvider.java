/**
 */
package com.icteam.loyalty.model.template.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.icteam.loyalty.model.interfaces.DistinctEMF;
import com.icteam.loyalty.model.template.DictionaryEMFTemplate;
import com.icteam.loyalty.model.template.ModelTemplatePackage;

/**
 * This is the item provider adapter for a {@link com.icteam.loyalty.model.template.DictionaryEMFTemplate} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DictionaryEMFTemplateItemProvider extends AbstractEMFTemplateItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DictionaryEMFTemplateItemProvider(AdapterFactory adapterFactory) {
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

            addKeyPropertyDescriptor(object);
            addValuePropertyDescriptor(object);
            addLanguagePropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Key feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addKeyPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DictionaryEMFTemplate_key_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DictionaryEMFTemplate_key_feature", "_UI_DictionaryEMFTemplate_type"),
                 ModelTemplatePackage.Literals.DICTIONARY_EMF_TEMPLATE__KEY,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Language feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addLanguagePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DictionaryEMFTemplate_language_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DictionaryEMFTemplate_language_feature", "_UI_DictionaryEMFTemplate_type"),
                 ModelTemplatePackage.Literals.DICTIONARY_EMF_TEMPLATE__LANGUAGE,
                 true,
                 false,
                 false,
                 null,
                 null,
                 null));
    }

    /**
     * This adds a property descriptor for the Value feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addValuePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add
            (createItemPropertyDescriptor
                (((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
                 getResourceLocator(),
                 getString("_UI_DictionaryEMFTemplate_value_feature"),
                 getString("_UI_PropertyDescriptor_description", "_UI_DictionaryEMFTemplate_value_feature", "_UI_DictionaryEMFTemplate_type"),
                 ModelTemplatePackage.Literals.DICTIONARY_EMF_TEMPLATE__VALUE,
                 true,
                 false,
                 false,
                 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                 null,
                 null));
    }

    /**
     * This returns DictionaryEMFTemplate.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/DictionaryEMFTemplate"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        DistinctEMF labelValue = ((DictionaryEMFTemplate)object).getDistinct();
        String label = labelValue == null ? null : labelValue.toString();
        return label == null || label.length() == 0 ?
            getString("_UI_DictionaryEMFTemplate_type") :
            getString("_UI_DictionaryEMFTemplate_type") + " " + label;
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

        switch (notification.getFeatureID(DictionaryEMFTemplate.class)) {
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__KEY:
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__VALUE:
            case ModelTemplatePackage.DICTIONARY_EMF_TEMPLATE__LANGUAGE:
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

}

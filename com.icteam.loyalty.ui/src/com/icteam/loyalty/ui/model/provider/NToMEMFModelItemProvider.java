/**
 */
package com.icteam.loyalty.ui.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.provider.EMFModelItemProvider;
import com.icteam.loyalty.ui.interfaces.UIInterfacesPackage;
import com.icteam.loyalty.ui.model.NToMEMFModel;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.provider.UIEditPlugin;

/**
 * This is the item provider adapter for a {@link com.icteam.loyalty.ui.model.NToMEMFModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NToMEMFModelItemProvider extends EMFModelItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NToMEMFModelItemProvider(AdapterFactory adapterFactory) {
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
            addMainEObjectPropertyDescriptor(object);
            addMainFeaturePropertyDescriptor(object);
            addAllToSrcActionPropertyDescriptor(object);
            addToSrcActionPropertyDescriptor(object);
            addToDestActionPropertyDescriptor(object);
            addAllToDestActionPropertyDescriptor(object);
            addSrcListPropertyDescriptor(object);
            addDestListPropertyDescriptor(object);
            addSelectedDestListPropertyDescriptor(object);
            addSelectedSrcListPropertyDescriptor(object);
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
     * This adds a property descriptor for the Main EObject feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMainEObjectPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_IContained_mainEObject_feature"), getString("_UI_PropertyDescriptor_description", "_UI_IContained_mainEObject_feature", "_UI_IContained_type"),
                ModelInterfacesPackage.Literals.ICONTAINED__MAIN_EOBJECT, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the All To Src Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAllToSrcActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NToMEMFModel_allToSrcAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_NToMEMFModel_allToSrcAction_feature", "_UI_NToMEMFModel_type"),
                UIModelPackage.Literals.NTO_MEMF_MODEL__ALL_TO_SRC_ACTION, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the To Src Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addToSrcActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NToMEMFModel_toSrcAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_NToMEMFModel_toSrcAction_feature", "_UI_NToMEMFModel_type"),
                UIModelPackage.Literals.NTO_MEMF_MODEL__TO_SRC_ACTION, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the To Dest Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addToDestActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NToMEMFModel_toDestAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_NToMEMFModel_toDestAction_feature", "_UI_NToMEMFModel_type"),
                UIModelPackage.Literals.NTO_MEMF_MODEL__TO_DEST_ACTION, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the All To Dest Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAllToDestActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NToMEMFModel_allToDestAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_NToMEMFModel_allToDestAction_feature", "_UI_NToMEMFModel_type"),
                UIModelPackage.Literals.NTO_MEMF_MODEL__ALL_TO_DEST_ACTION, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Src List feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSrcListPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NToMEMFModel_srcList_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NToMEMFModel_srcList_feature", "_UI_NToMEMFModel_type"),
                UIModelPackage.Literals.NTO_MEMF_MODEL__SRC_LIST, true, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Dest List feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDestListPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NToMEMFModel_destList_feature"), getString("_UI_PropertyDescriptor_description", "_UI_NToMEMFModel_destList_feature", "_UI_NToMEMFModel_type"),
                UIModelPackage.Literals.NTO_MEMF_MODEL__DEST_LIST, true, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Selected Dest List feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSelectedDestListPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NToMEMFModel_selectedDestList_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_NToMEMFModel_selectedDestList_feature", "_UI_NToMEMFModel_type"),
                UIModelPackage.Literals.NTO_MEMF_MODEL__SELECTED_DEST_LIST, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Selected Src List feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSelectedSrcListPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_NToMEMFModel_selectedSrcList_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_NToMEMFModel_selectedSrcList_feature", "_UI_NToMEMFModel_type"),
                UIModelPackage.Literals.NTO_MEMF_MODEL__SELECTED_SRC_LIST, true, false, true, null, null, null));
    }

    /**
     * This adds a property descriptor for the Main Feature feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMainFeaturePropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_IContainedFeature_mainFeature_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_IContainedFeature_mainFeature_feature", "_UI_IContainedFeature_type"),
                ModelInterfacesPackage.Literals.ICONTAINED_FEATURE__MAIN_FEATURE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns NToMEMFModel.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/NToMEMFModel"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        NToMEMFModel nToMEMFModel = (NToMEMFModel) object;
        return getString("_UI_NToMEMFModel_type") + " " + nToMEMFModel.isEditable();
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

        switch (notification.getFeatureID(NToMEMFModel.class)) {
            case UIModelPackage.NTO_MEMF_MODEL__BASE_CLASS:
            case UIModelPackage.NTO_MEMF_MODEL__MAIN_FEATURE:
            case UIModelPackage.NTO_MEMF_MODEL__SRC_LIST:
            case UIModelPackage.NTO_MEMF_MODEL__DEST_LIST:
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
        return UIEditPlugin.INSTANCE;
    }

}

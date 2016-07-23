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

import com.icteam.loyalty.model.provider.EMFModelItemProvider;
import com.icteam.loyalty.ui.model.DefaultEditorEMFModel;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.provider.UIEditPlugin;

/**
 * This is the item provider adapter for a {@link com.icteam.loyalty.ui.model.DefaultEditorEMFModel} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class DefaultEditorEMFModelItemProvider extends EMFModelItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DefaultEditorEMFModelItemProvider(AdapterFactory adapterFactory) {
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

            addSaveActionPropertyDescriptor(object);
            addCancelActionPropertyDescriptor(object);
            addVirtualViewEMFModelPropertyDescriptor(object);
            addEditorIDPropertyDescriptor(object);
            addInternalModelPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Save Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSaveActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DefaultEditorEMFModel_saveAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_DefaultEditorEMFModel_saveAction_feature", "_UI_DefaultEditorEMFModel_type"),
                UIModelPackage.Literals.DEFAULT_EDITOR_EMF_MODEL__SAVE_ACTION, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Cancel Action feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addCancelActionPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DefaultEditorEMFModel_cancelAction_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_DefaultEditorEMFModel_cancelAction_feature", "_UI_DefaultEditorEMFModel_type"),
                UIModelPackage.Literals.DEFAULT_EDITOR_EMF_MODEL__CANCEL_ACTION, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Internal Model feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addInternalModelPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DefaultEditorEMFModel_internalModel_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_DefaultEditorEMFModel_internalModel_feature", "_UI_DefaultEditorEMFModel_type"),
                UIModelPackage.Literals.DEFAULT_EDITOR_EMF_MODEL__INTERNAL_MODEL, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Virtual View EMF Model feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addVirtualViewEMFModelPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DefaultEditorEMFModel_virtualViewEMFModel_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_DefaultEditorEMFModel_virtualViewEMFModel_feature", "_UI_DefaultEditorEMFModel_type"),
                UIModelPackage.Literals.DEFAULT_EDITOR_EMF_MODEL__VIRTUAL_VIEW_EMF_MODEL, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the Editor ID feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEditorIDPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_DefaultEditorEMFModel_editorID_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_DefaultEditorEMFModel_editorID_feature", "_UI_DefaultEditorEMFModel_type"),
                UIModelPackage.Literals.DEFAULT_EDITOR_EMF_MODEL__EDITOR_ID, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
    }

    /**
     * This returns DefaultEditorEMFModel.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/DefaultEditorEMFModel"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        DefaultEditorEMFModel< ? > defaultEditorEMFModel = (DefaultEditorEMFModel< ? >) object;
        return getString("_UI_DefaultEditorEMFModel_type") + " " + defaultEditorEMFModel.isEditable();
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

        switch (notification.getFeatureID(DefaultEditorEMFModel.class)) {
            case UIModelPackage.DEFAULT_EDITOR_EMF_MODEL__EDITOR_ID:
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

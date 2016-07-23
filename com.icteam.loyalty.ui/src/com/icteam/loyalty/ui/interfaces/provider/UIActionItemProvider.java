/**
 */
package com.icteam.loyalty.ui.interfaces.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;

import com.icteam.loyalty.model.interfaces.provider.ActionItemProvider;
import com.icteam.loyalty.ui.interfaces.UIAction;
import com.icteam.loyalty.ui.interfaces.UIInterfacesPackage;
import com.icteam.loyalty.ui.provider.UIEditPlugin;

/**
 * This is the item provider adapter for a {@link com.icteam.loyalty.ui.interfaces.UIAction} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UIActionItemProvider extends ActionItemProvider {
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UIActionItemProvider(AdapterFactory adapterFactory) {
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

            addNTOM_ALL_TO_SRCPropertyDescriptor(object);
            addNTOM_TO_SRCPropertyDescriptor(object);
            addNTOM_ALL_TO_DESTPropertyDescriptor(object);
            addNTOM_TO_DESTPropertyDescriptor(object);
            addEDITOR_SAVEPropertyDescriptor(object);
            addEDITOR_CANCELPropertyDescriptor(object);
            addVIEW_OPEN_EDITORPropertyDescriptor(object);
            addVIEW_FILTER_COLUMNSPropertyDescriptor(object);
            addVIEW_ADVANCED_FILTERPropertyDescriptor(object);
            addVIEW_REFRESHPropertyDescriptor(object);
            addVIEW_SELECT_COLUMNPropertyDescriptor(object);
            addVIEW_ADDPropertyDescriptor(object);
            addVIEW_REMOVEPropertyDescriptor(object);
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the NTOM ALL TO SRC feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNTOM_ALL_TO_SRCPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_NTOM_ALL_TO_SRC_feature"), getString("_UI_PropertyDescriptor_description", "_UI_UIAction_NTOM_ALL_TO_SRC_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__NTOM_ALL_TO_SRC, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the NTOM TO SRC feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNTOM_TO_SRCPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_NTOM_TO_SRC_feature"), getString("_UI_PropertyDescriptor_description", "_UI_UIAction_NTOM_TO_SRC_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__NTOM_TO_SRC, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the NTOM ALL TO DEST feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNTOM_ALL_TO_DESTPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_NTOM_ALL_TO_DEST_feature"), getString("_UI_PropertyDescriptor_description", "_UI_UIAction_NTOM_ALL_TO_DEST_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__NTOM_ALL_TO_DEST, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the NTOM TO DEST feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNTOM_TO_DESTPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_NTOM_TO_DEST_feature"), getString("_UI_PropertyDescriptor_description", "_UI_UIAction_NTOM_TO_DEST_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__NTOM_TO_DEST, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the EDITOR SAVE feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEDITOR_SAVEPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_EDITOR_SAVE_feature"), getString("_UI_PropertyDescriptor_description", "_UI_UIAction_EDITOR_SAVE_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__EDITOR_SAVE, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the EDITOR CANCEL feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEDITOR_CANCELPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_EDITOR_CANCEL_feature"), getString("_UI_PropertyDescriptor_description", "_UI_UIAction_EDITOR_CANCEL_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__EDITOR_CANCEL, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the VIEW OPEN EDITOR feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addVIEW_OPEN_EDITORPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_VIEW_OPEN_EDITOR_feature"), getString("_UI_PropertyDescriptor_description", "_UI_UIAction_VIEW_OPEN_EDITOR_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__VIEW_OPEN_EDITOR, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the VIEW FILTER COLUMNS feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addVIEW_FILTER_COLUMNSPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_VIEW_FILTER_COLUMNS_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_UIAction_VIEW_FILTER_COLUMNS_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__VIEW_FILTER_COLUMNS, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the VIEW ADVANCED FILTER feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addVIEW_ADVANCED_FILTERPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_VIEW_ADVANCED_FILTER_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_UIAction_VIEW_ADVANCED_FILTER_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__VIEW_ADVANCED_FILTER, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the VIEW REFRESH feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addVIEW_REFRESHPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_VIEW_REFRESH_feature"), getString("_UI_PropertyDescriptor_description", "_UI_UIAction_VIEW_REFRESH_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__VIEW_REFRESH, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the VIEW SELECT COLUMN feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addVIEW_SELECT_COLUMNPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_VIEW_SELECT_COLUMN_feature"),
                getString("_UI_PropertyDescriptor_description", "_UI_UIAction_VIEW_SELECT_COLUMN_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__VIEW_SELECT_COLUMN, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the VIEW ADD feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addVIEW_ADDPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_VIEW_ADD_feature"), getString("_UI_PropertyDescriptor_description", "_UI_UIAction_VIEW_ADD_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__VIEW_ADD, false, false, false, null, null, null));
    }

    /**
     * This adds a property descriptor for the VIEW REMOVE feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addVIEW_REMOVEPropertyDescriptor(Object object) {
        itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
                getString("_UI_UIAction_VIEW_REMOVE_feature"), getString("_UI_PropertyDescriptor_description", "_UI_UIAction_VIEW_REMOVE_feature", "_UI_UIAction_type"),
                UIInterfacesPackage.Literals.UI_ACTION__VIEW_REMOVE, false, false, false, null, null, null));
    }

    /**
     * This returns UIAction.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage(Object object) {
        return overlayImage(object, getResourceLocator().getImage("full/obj16/UIAction"));
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText(Object object) {
        String label = ((UIAction) object).getName();
        return label == null || label.length() == 0 ? getString("_UI_UIAction_type") : getString("_UI_UIAction_type") + " " + label;
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

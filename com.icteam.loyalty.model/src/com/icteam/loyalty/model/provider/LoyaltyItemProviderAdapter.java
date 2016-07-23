package com.icteam.loyalty.model.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.view.model.common.edit.provider.CustomReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.EAnnotation;
import com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum;
import com.icteam.loyalty.model.util.ModelUtil;

public class LoyaltyItemProviderAdapter extends ItemProviderAdapter {

    final class EnhancedEnumItemPropertyDescriptor extends ItemPropertyDescriptor {
        EnhancedEnumItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator, String displayName, String description, EStructuralFeature feature,
                boolean isSettable, boolean multiLine, boolean sortChoices, Object staticImage, String category, String[] filterFlags) {
            super(adapterFactory, resourceLocator, displayName, description, feature, isSettable, multiLine, sortChoices, staticImage, category, filterFlags);
        }

        @Override
        public IItemLabelProvider getLabelProvider(Object object) {
            return new EnhancedEnumItemLabelProvider(feature, resourceLocator);
        }

        @SuppressWarnings("rawtypes")
        @Override
        protected Collection< ? > getComboBoxObjects(Object object) {
            EStructuralFeature choicesFeature = (EStructuralFeature) ModelUtil.getAnnotation(feature, EAnnotation.CHOICES_FEATURE);

            Collection< ? > choices = null;
            if (choicesFeature != null) {
                choices = (List< ? >) ((EObject) object).eGet(choicesFeature);
            } else {
                EClassifier eClassifier = feature.getEType();

                if (IEMFEnhancedEnum.class.isAssignableFrom(eClassifier.getInstanceClass())) {
                    choices = ModelUtil.values((Class< ? extends IEMFEnhancedEnum>) eClassifier.getInstanceClass());
                } else {
                    choices = new ArrayList<>();
                }
            }

            EStructuralFeature revertChoicesFeature = (EStructuralFeature) ModelUtil.getAnnotation(feature, EAnnotation.REVERT_CHOICES_FEATURE);

            if (revertChoicesFeature != null) {
                choices = CollectionUtils.subtract(choices, (List< ? >) ((EObject) object).eGet(revertChoicesFeature));
            }

            return choices;
        }

    }

    final class ActionItemPropertyDescriptor extends ItemPropertyDescriptor {
        ActionItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator, String displayName, String description, EStructuralFeature feature,
                boolean isSettable, boolean multiLine, boolean sortChoices, Object staticImage, String category, String[] filterFlags) {
            super(adapterFactory, resourceLocator, displayName, description, feature, isSettable, multiLine, sortChoices, staticImage, category, filterFlags);
        }

        @Override
        public IItemLabelProvider getLabelProvider(Object object) {
            return new CommandItemLabelProvider(feature, resourceLocator);
        }
    }

    public LoyaltyItemProviderAdapter(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    @Override
    protected ItemPropertyDescriptor createItemPropertyDescriptor(AdapterFactory adapterFactory, ResourceLocator resourceLocator, String displayName, String description,
            EStructuralFeature feature, boolean isSettable, boolean multiLine, boolean sortChoices, Object staticImage, String category, String[] filterFlags) {
        if (Action.class.isAssignableFrom(feature.getEType().getInstanceClass())) {
            return new ActionItemPropertyDescriptor(adapterFactory, resourceLocator, displayName, description, feature, isSettable, multiLine, sortChoices, staticImage, category,
                    filterFlags);
        }

        if (IEMFEnhancedEnum.class.isAssignableFrom(feature.getEType().getInstanceClass())
                || feature.getName().equals("name")
                && IEMFEnhancedEnum.class.isAssignableFrom(feature.getContainerClass())) {
            return new EnhancedEnumItemPropertyDescriptor(adapterFactory, resourceLocator, displayName, description, feature, isSettable, multiLine, sortChoices, staticImage,
                    category, filterFlags);
        }

        return super.createItemPropertyDescriptor(adapterFactory, resourceLocator, displayName, description, feature, isSettable, multiLine, sortChoices, staticImage, category,
                filterFlags);
    }

    public static String getLabelText(EObject eObject, EStructuralFeature feature) {
        return getLabelText(eObject, feature, eObject.eGet(feature));
    }

    public static String getLabelText(EObject eObject, EStructuralFeature feature, Object featureValue) {
        IItemPropertyDescriptor descriptor = getItemPropertyDescriptor(eObject, feature);

        return descriptor.getLabelProvider(null).getText(featureValue);
    }

    public static String getDiplayName(EObject eObject, EStructuralFeature feature) {
        IItemPropertyDescriptor descriptor = getItemPropertyDescriptor(eObject, feature);

        return descriptor.getDisplayName(null);
    }

    public static IItemPropertyDescriptor getItemPropertyDescriptor(EObject eObject, EStructuralFeature feature) {
        ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(new AdapterFactory[] { new CustomReflectiveItemProviderAdapterFactory(),
                new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE) });
        AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(composedAdapterFactory);

        try {
            return adapterFactoryItemDelegator.getPropertyDescriptor(eObject, feature);
        } finally {
            if (composedAdapterFactory != null) {
                composedAdapterFactory.dispose();
            }
        }
    }

}

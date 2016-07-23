package com.icteam.loyalty.model.provider;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

import com.icteam.loyalty.model.interfaces.IEMFEnhancedEnum;

public class EnhancedEnumItemLabelProvider implements IItemLabelProvider {
    private final ResourceLocator resourceLocator;
    private final EStructuralFeature feature;

    public EnhancedEnumItemLabelProvider(EStructuralFeature feature, ResourceLocator resourceLocator) {
        this.feature = feature;
        this.resourceLocator = resourceLocator;
    }

    @Override
    public String getText(Object object) {
        if (object == null) {
            return convert(feature.getEType(), object);
        }

        if (object instanceof IEMFEnhancedEnum) {
            return convert(feature.getEType(), ((IEMFEnhancedEnum< ? >) object).getName());
        }

        return convert(feature.getEContainingClass(), object);
    }

    protected String convert(ENamedElement element, Object value) {
        if (this.resourceLocator != null && value != null) {
            return this.resourceLocator.getString("_UI_" + element.getName() + "_" + value + "_feature");
        }

        String text = "";

        if (element instanceof EDataType) {
            EcoreUtil.convertToString((EDataType) element, value);
        }

        return crop(text);
    }

    protected String crop(String text) {
        if (text != null) {
            char[] chars = text.toCharArray();
            for (int i = 0; i < chars.length; ++i) {
                if (Character.isISOControl(chars[i])) {
                    return text.substring(0, i) + "...";
                }
            }
        }
        return text;
    }

    @Override
    public Object getImage(Object object) {
        return null;
    }
}
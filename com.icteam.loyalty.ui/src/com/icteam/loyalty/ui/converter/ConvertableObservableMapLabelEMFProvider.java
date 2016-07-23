package com.icteam.loyalty.ui.converter;

import java.beans.PropertyDescriptor;
import java.util.Collection;

import org.eclipse.core.databinding.beans.IBeanObservable;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.icteam.loyalty.api.interfaces.ISelectable;
import com.icteam.loyalty.ui.interfaces.IImageProvider;

public class ConvertableObservableMapLabelEMFProvider extends ObservableMapLabelProvider {

    private static final long serialVersionUID = -925016602830502837L;

    private IConverter[] converters;
    private IImageProvider[] imageProviders;

    /**
     * @param attributeMaps
     */
    public ConvertableObservableMapLabelEMFProvider(IObservableMap[] attributeMaps, EStructuralFeature[] featureColumns) {
        super(attributeMaps);

        initDefaults(featureColumns);
    }

    private void initDefaults(EStructuralFeature[] featureColumns) {
        setConverters(new IConverter[attributeMaps.length]);
        setImageProviders(new IImageProvider[attributeMaps.length]);

        for (int i = 0; i < featureColumns.length; i++) {
            Class< ? > valueType = featureColumns[i].getEType().getInstanceClass();

            if (ISelectable.class.isAssignableFrom(valueType)) {
                setColumnConverter(new ModelToLabelConverter(), i);
            } else if (Boolean.class.isAssignableFrom(valueType)) {
                setColumnConverter(new BooleanToLabelConverter(), i);
            } else if (attributeMaps[i] instanceof IBeanObservable) {
                IBeanObservable bean = (IBeanObservable) attributeMaps[i];
                PropertyDescriptor propertyDescriptor = bean.getPropertyDescriptor();

                setColumnConverter(ConverterUtils.computePropertyConverter(propertyDescriptor, true), i);
                setImageProvider(ConverterUtils.computePropertyImageProvider(propertyDescriptor), i);
            }
        }
    }

    public void setConverters(IConverter[] converters) {
        if (converters.length != attributeMaps.length) {
            throw new IllegalArgumentException("array converter must have same length of array attributeMaps");
        }

        this.converters = converters;
    }

    public void setImageProviders(IImageProvider[] imageProviders) {
        this.imageProviders = imageProviders;
    }

    public void setColumnConverter(IConverter converter, int columnIndex) {
        converters[columnIndex] = converter;
    }

    public void setImageProvider(IImageProvider imageProvider, int columnIndex) {
        imageProviders[columnIndex] = imageProvider;
    }

    @Override
    public String getColumnText(Object element, int columnIndex) {
        if (columnIndex < attributeMaps.length) {
            Object result = attributeMaps[columnIndex].get(element);

            if (converters[columnIndex] != null) {
                return converters[columnIndex].convert(result).toString();
            }

            if (result instanceof Collection && ((Collection< ? >) result).isEmpty()) {
                return "";
            }
        }

        return super.getColumnText(element, columnIndex);
    }

    @Override
    public Image getColumnImage(Object element, int columnIndex) {
        if (columnIndex < attributeMaps.length) {
            if (imageProviders[columnIndex] != null) {
                return imageProviders[columnIndex].getColumnImage(element, columnIndex);
            }
        }

        return super.getColumnImage(element, columnIndex);
    }

}
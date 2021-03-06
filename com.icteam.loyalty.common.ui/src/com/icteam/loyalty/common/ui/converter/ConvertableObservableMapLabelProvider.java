package com.icteam.loyalty.common.ui.converter;

import java.beans.PropertyDescriptor;
import java.util.Collection;

import org.eclipse.core.databinding.beans.IBeanObservable;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.swt.graphics.Image;

public class ConvertableObservableMapLabelProvider extends ObservableMapLabelProvider {

	private static final long serialVersionUID = -925016602830502837L;

	private IConverter[] converters;
	// private IImageProvider[] imageProviders;

	/**
	 * @param attributeMaps
	 */
	public ConvertableObservableMapLabelProvider(IObservableMap[] attributeMaps) {
		super(attributeMaps);

		initDefaults();
	}

	private void initDefaults() {
		setConverters(new IConverter[attributeMaps.length]);
		// setImageProviders(new IImageProvider[attributeMaps.length]);

		for (int i = 0; i < attributeMaps.length; i++) {
			final Class<?> valueType = (Class<?>) attributeMaps[i].getValueType();

			// if (ISelectable.class.isAssignableFrom(valueType)) {
			// setColumnConverter(new ModelToLabelConverter(), i);
			// } else
			if (Boolean.class.isAssignableFrom(valueType)) {
				setColumnConverter(new BooleanToLabelConverter(), i);
			} else if (attributeMaps[i] instanceof IBeanObservable) {
				final IBeanObservable bean = (IBeanObservable) attributeMaps[i];
				final PropertyDescriptor propertyDescriptor = bean.getPropertyDescriptor();

				// setColumnConverter(ConverterUtils.computePropertyConverter(propertyDescriptor,
				// true), i);
				// setImageProvider(ConverterUtils.computePropertyImageProvider(propertyDescriptor),
				// i);
			}
		}
	}

	public void setConverters(IConverter[] converters) {
		if (converters.length != attributeMaps.length) {
			throw new IllegalArgumentException("array converter must have same length of array attributeMaps");
		}

		this.converters = converters;
	}

	// public void setImageProviders(IImageProvider[] imageProviders) {
	// this.imageProviders = imageProviders;
	// }

	public void setColumnConverter(IConverter converter, int columnIndex) {
		converters[columnIndex] = converter;
	}

	// public void setImageProvider(IImageProvider imageProvider, int
	// columnIndex) {
	// imageProviders[columnIndex] = imageProvider;
	// }

	@Override
	public String getColumnText(Object element, int columnIndex) {
		final Object result = attributeMaps[columnIndex].get(element);

		if (converters[columnIndex] != null) {
			return converters[columnIndex].convert(result).toString();
		}

		if (result instanceof Collection && ((Collection<?>) result).isEmpty()) {
			return "";
		}

		return super.getColumnText(element, columnIndex);
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// if (imageProviders[columnIndex] != null) {
		// return imageProviders[columnIndex].getColumnImage(element,
		// columnIndex);
		// }

		return super.getColumnImage(element, columnIndex);
	}

}
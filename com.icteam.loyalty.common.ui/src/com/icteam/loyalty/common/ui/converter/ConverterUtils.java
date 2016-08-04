package com.icteam.loyalty.common.ui.converter;

import java.beans.FeatureDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.Id;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osgi.framework.FrameworkUtil;

import com.icteam.loyalty.common.annotations.Format;
import com.icteam.loyalty.common.annotations.Link;
import com.icteam.loyalty.common.interfaces.IImageDTO;
import com.icteam.loyalty.common.ui.interfaces.IImageProvider;

public class ConverterUtils {

	private static Class<?> extractPropertyClass(PropertyDescriptor propertyDescriptor) {
		Method getClass;
		try {
			getClass = FeatureDescriptor.class.getDeclaredMethod("getClass0", (Class[]) null);
			getClass.setAccessible(true);

			final Class<?> propertyClass = (Class<?>) getClass.invoke(propertyDescriptor, (Object[]) null);
			return propertyClass;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static IConverter computePropertyConverter(PropertyDescriptor propertyDescriptor, boolean toTarget) {
		IConverter converter = null;

		final Method getter = propertyDescriptor.getReadMethod();
		final Class<?> propertyClass = propertyDescriptor.getPropertyType();

		// if (getter.isAnnotationPresent(Translated.class) && toTarget) {
		// if (ISelectable.class.isAssignableFrom(propertyClass)) {
		// converter = new ModelToLabelConverter();
		// } else {
		// Class<?> beanClass = extractPropertyClass(propertyDescriptor);
		// converter = new StringToMessageConverter(beanClass);
		// }
		// } else
		if (getter.isAnnotationPresent(Format.class)) {
			if (toTarget) {
				converter = FormatConverter.newTargetConverter(propertyClass, getter.getAnnotation(Format.class));
			} else {
				converter = FormatConverter.newModelConverter(propertyClass, getter.getAnnotation(Format.class));
			}
		} else if (getter.isAnnotationPresent(Link.class)) {
			converter = new StringToLinkConverter(getter.getAnnotation(Link.class));
		}

		return converter;
	}

	public static IImageProvider computePropertyImageProvider(PropertyDescriptor propertyDescriptor) {
		final Method getter = propertyDescriptor.getReadMethod();

		if (getter.isAnnotationPresent(Id.class)) {
			final Class<?> beanClass = extractPropertyClass(propertyDescriptor);

			if (IImageDTO.class.isAssignableFrom(beanClass)) {
				final IEclipseContext context = EclipseContextFactory
						.getServiceContext(FrameworkUtil.getBundle(ConverterUtils.class).getBundleContext());

				return ContextInjectionFactory.make(DefaultImageProvider.class, context);
			}
		}

		return null;
	}

}

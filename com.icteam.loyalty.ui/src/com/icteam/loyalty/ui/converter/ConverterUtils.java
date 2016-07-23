package com.icteam.loyalty.ui.converter;

import java.beans.FeatureDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.persistence.Id;

import org.eclipse.core.databinding.conversion.IConverter;

import com.icteam.loyalty.api.interfaces.ISelectable;
import com.icteam.loyalty.api.interfaces.Translated;
import com.icteam.loyalty.model.interfaces.Format;
import com.icteam.loyalty.model.interfaces.IImageDtoModel;
import com.icteam.loyalty.model.interfaces.Link;
import com.icteam.loyalty.ui.interfaces.IImageProvider;

public class ConverterUtils {

    private static Class< ? > extractPropertyClass(PropertyDescriptor propertyDescriptor) {
        Method getClass;
        try {
            getClass = FeatureDescriptor.class.getDeclaredMethod("getClass0", (Class[]) null);
            getClass.setAccessible(true);

            Class< ? > propertyClass = (Class< ? >) getClass.invoke(propertyDescriptor, (Object[]) null);
            return propertyClass;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static IConverter computePropertyConverter(PropertyDescriptor propertyDescriptor, boolean toTarget) {
        IConverter converter = null;

        Method getter = propertyDescriptor.getReadMethod();
        Class< ? > propertyClass = propertyDescriptor.getPropertyType();

        if (getter.isAnnotationPresent(Translated.class) && toTarget) {
            if (ISelectable.class.isAssignableFrom(propertyClass)) {
                converter = new ModelToLabelConverter();
            } else {
                Class< ? > beanClass = extractPropertyClass(propertyDescriptor);
                converter = new StringToMessageConverter(beanClass);
            }
        } else if (getter.isAnnotationPresent(Format.class)) {
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
        Method getter = propertyDescriptor.getReadMethod();

        if (getter.isAnnotationPresent(Id.class)) {
            Class< ? > beanClass = extractPropertyClass(propertyDescriptor);

            if (IImageDtoModel.class.isAssignableFrom(beanClass)) {
                return new DefaultImageProvider();
            }
        }

        return null;
    }

}

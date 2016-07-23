package com.icteam.loyalty.ui.converter;

import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.conversion.IConverter;

/**
 * Converts any object to a boolean.
 * Return true if the object is not null or not an empty Collection or String
 */
public class ObjectToBooleanConverter implements IConverter {
    private final Class<?> fromClass;

    /**
	 * 
	 */
    public ObjectToBooleanConverter() {
        this(Object.class);
    }

    /**
     * @param fromClass
     */
    public ObjectToBooleanConverter(Class<?> fromClass) {
        this.fromClass = fromClass;
    }

    @Override
    public Object convert(Object source) {
        return !(source == null || StringUtils.isBlank(source.toString()) || (source instanceof Collection<?> && CollectionUtils.isEmpty((Collection<?>) source)));
    }

    @Override
    public Object getFromType() {
        return fromClass;
    }

    @Override
    public Object getToType() {
        return boolean.class;
    }

}

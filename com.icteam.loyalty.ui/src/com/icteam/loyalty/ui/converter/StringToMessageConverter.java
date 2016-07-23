package com.icteam.loyalty.ui.converter;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;

import com.icteam.loyalty.api.Messages;

public class StringToMessageConverter extends Converter implements IConverter {

    private final Class< ? > propertyClass;

    public StringToMessageConverter(Class< ? > propertyClass) {
        super(String.class, String.class);

        this.propertyClass = propertyClass;
    }

    @Override
    public Object convert(Object fromObject) {
        if (fromObject == null) {
            return "";
        }

        return Messages.get(propertyClass, (String) fromObject);
    }
}
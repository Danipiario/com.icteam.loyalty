package com.icteam.loyalty.ui.converter;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;

public class StringToLabelConverter extends Converter implements IConverter {

    public StringToLabelConverter() {
        super(String.class, String.class);
    }

    @Override
    public Object convert(Object fromObject) {
        return StringUtils.defaultString((String) fromObject) + ":";
    }
}
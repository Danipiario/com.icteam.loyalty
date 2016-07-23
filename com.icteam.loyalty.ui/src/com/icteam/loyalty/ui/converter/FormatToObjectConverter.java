package com.icteam.loyalty.ui.converter;

import java.text.MessageFormat;
import java.text.ParseException;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;

import com.icteam.loyalty.model.interfaces.Format;

public class FormatToObjectConverter extends Converter implements IConverter {

    private final MessageFormat messageFormat;

    public FormatToObjectConverter(Class< ? > propertyClass, Format format) {
        super(String.class, propertyClass);

        messageFormat = new MessageFormat(format.value());
    }

    @Override
    public Object convert(Object fromObject) {
        if (StringUtils.isEmpty((String) fromObject)) {
            return null;
        }

        try {
            return messageFormat.parseObject((String) fromObject);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
package com.icteam.loyalty.ui.converter;

import org.eclipse.core.databinding.conversion.Converter;

import com.icteam.loyalty.api.Messages;

public class BooleanToLabelConverter extends Converter {

    public BooleanToLabelConverter() {
        super(Boolean.class, String.class);
    }

    @Override
    public Object convert(Object fromObject) {
        if (fromObject == null) {
            return "";
        }

        return Messages.get(Boolean.class, fromObject.toString());
    }
}
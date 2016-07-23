package com.icteam.loyalty.ui.converter;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.conversion.Converter;

public class LabelToModelConverter extends Converter {

    private final Map<String, ? > valuesToNames;

    public LabelToModelConverter(Map<String, ? > valuesToNames) {
        super(String.class, Serializable.class);

        this.valuesToNames = valuesToNames;
    }

    @Override
    public Object convert(Object fromObject) {
        if (StringUtils.isBlank((String) fromObject)) {
            return null;
        }

        return valuesToNames.get(fromObject);
    }

}
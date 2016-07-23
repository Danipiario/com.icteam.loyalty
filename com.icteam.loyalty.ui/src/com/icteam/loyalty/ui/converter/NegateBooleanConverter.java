package com.icteam.loyalty.ui.converter;

import org.eclipse.core.databinding.conversion.Converter;

public class NegateBooleanConverter extends Converter {

    public NegateBooleanConverter() {
        super(boolean.class, boolean.class);
    }

    @Override
    public Object convert(Object fromObject) {
        return !((boolean) fromObject);
    }
}
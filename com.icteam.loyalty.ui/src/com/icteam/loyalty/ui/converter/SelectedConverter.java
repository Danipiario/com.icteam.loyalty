package com.icteam.loyalty.ui.converter;

import org.eclipse.core.databinding.conversion.Converter;

public class SelectedConverter extends Converter {

    public SelectedConverter(Class<?> selectedClass) {
        super(selectedClass, boolean.class);
    }

    @Override
    public Object convert(Object fromObject) {
        return fromObject != null;
    }

}

package com.icteam.loyalty.ui.converter;

import java.util.Collection;

import org.eclipse.core.databinding.conversion.Converter;

public class CollectionToBooleanConverter extends Converter {

    public CollectionToBooleanConverter() {
        super(Collection.class, boolean.class);
    }

    @Override
    public Object convert(Object fromObject) {
        return !((Collection<?>) fromObject).isEmpty();
    }
}
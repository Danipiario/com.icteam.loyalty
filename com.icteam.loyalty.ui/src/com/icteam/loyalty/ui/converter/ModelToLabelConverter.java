package com.icteam.loyalty.ui.converter;

import java.io.Serializable;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.api.interfaces.ISelectable;

public class ModelToLabelConverter extends Converter implements IConverter {

    public ModelToLabelConverter() {
        super(Serializable.class, String.class);
    }

    @Override
    public Object convert(Object fromObject) {
        if (fromObject == null) {
            return "";
        }

        if (ISelectable.class.isAssignableFrom(fromObject.getClass())) {
            return Messages.get(((ISelectable< ? >) fromObject).getDescription());
        }

        return fromObject;
    }
}
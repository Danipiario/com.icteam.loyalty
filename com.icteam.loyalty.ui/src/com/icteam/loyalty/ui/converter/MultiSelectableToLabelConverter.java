package com.icteam.loyalty.ui.converter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.conversion.IConverter;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.api.interfaces.ISelectable;

public class MultiSelectableToLabelConverter extends Converter implements IConverter {

    public MultiSelectableToLabelConverter() {
        super(List.class, List.class);
    }

    @Override
    public Object convert(Object fromObject) {
        List<ISelectable< ? >> list = (List<ISelectable< ? >>) fromObject;

        if (list == null || list.isEmpty()) {
            return "";
        }

        List<String> labels = new ArrayList<>();

        for (ISelectable< ? > value : list) {
            labels.add(Messages.get(value.getDescription()));

        }

        return labels;
    }
}
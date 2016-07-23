package com.icteam.loyalty.ui.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.conversion.Converter;

import com.icteam.loyalty.api.interfaces.ISelectable;

public class MultiLabelToSelectableConverter<S extends ISelectable<String> & Comparable<S>> extends Converter {

    private final Map<String, S> valuesToNames;

    public MultiLabelToSelectableConverter(Map<String, S> valuesToNames) {
        super(List.class, List.class);

        this.valuesToNames = valuesToNames;
    }

    @Override
    public Object convert(Object fromObject) {
        List<String> list = (List<String>) fromObject;

        if (list == null || list.isEmpty()) {
            return null;
        }

        List<S> selectables = new ArrayList<>();
        for (String value : list) {
            selectables.add(valuesToNames.get(value));
        }

        return selectables;
    }
}
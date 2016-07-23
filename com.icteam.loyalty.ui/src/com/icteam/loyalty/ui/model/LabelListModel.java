package com.icteam.loyalty.ui.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.ListUtils;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.api.interfaces.ISelectable;
import com.icteam.loyalty.model.interfaces.IModel;

public class LabelListModel<M extends IModel, S extends ISelectable<String> & Comparable<S>> extends LabelModel<M, List<S>> {

    private static final long serialVersionUID = -389856560005584245L;

    private List<String> values;
    private final Map<String, S> valuesToSelectables = new HashMap<>();

    public LabelListModel(M model, String property, Class<S> listPropertyClass, List<S> customValues, boolean minus) {
        this(model, property, listPropertyClass, null, customValues, minus);
    }

    public LabelListModel(M model, String property, Class<S> listPropertyClass, List<S> srcValues, List<S> customValues, boolean minus) {
        super(model, property);

        initValues(listPropertyClass, srcValues, customValues, minus);
    }

    private <E extends EnhancedEnum<E, S>> void initValues(Class<S> listPropertyClass, List<S> srcValues, List<S> customValues, boolean minus) {
        List<S> vs = srcValues;

        if (srcValues == null) {
            if (!EnhancedEnum.class.isAssignableFrom(listPropertyClass)) {
                if (customValues == null || minus) {
                    throw new IllegalArgumentException(
                            "listPropertyClass must be an instance of EnhancedEnum if srcValues and customValues is null or minus is true");
                }
            } else {
                vs = (List<S>) EnhancedEnum.values((Class<E>) listPropertyClass);
            }
        }

        if (customValues != null) {
            if (minus) {
                vs = ListUtils.subtract(vs, customValues);
            } else {
                vs = customValues;
            }
        }

        for (S v : vs) {
            valuesToSelectables.put(Messages.get(v.getDescription()), v);
        }

        this.values = new ArrayList<>(valuesToSelectables.keySet());
    }

    public List<String> getValues() {
        return values;
    }

    public Map<String, S> getValuesToSelectables() {
        return valuesToSelectables;
    }

}

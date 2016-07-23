package com.icteam.loyalty.ui.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.ListUtils;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.api.interfaces.EnhancedEnum;
import com.icteam.loyalty.api.interfaces.ISelectable;
import com.icteam.loyalty.model.interfaces.IModel;

public class LabelComboModel<M extends IModel, S extends Serializable & Comparable<S>> extends LabelModel<M, S> {

    private static final long serialVersionUID = -389856560005584245L;

    private List<String> values;
    private final Map<String, S> valueMap = new HashMap<>();

    public LabelComboModel(M model, String property) {
        this(model, property, null, false);
    }

    public LabelComboModel(M model, String property, List<S> customValues, boolean minus) {
        this(model, property, null, customValues, minus);
    }

    public LabelComboModel(M model, String property, List<S> srcValues, List<S> customValues, boolean minus) {
        super(model, property);

        initValues(srcValues, customValues, minus);
    }

    private <E extends EnhancedEnum<E, S>> void initValues(List<S> srcValues, List<S> customValues, boolean minus) {
        List<S> vs = srcValues;

        if (srcValues == null) {
            Class<S> nestedPropertyClass = getNestedPropertyClass();

            if (!EnhancedEnum.class.isAssignableFrom(nestedPropertyClass)) {
                if (customValues == null || minus) {
                    throw new IllegalArgumentException(
                            "nestedPropertyClass must be an instance of EnhancedEnum if srcValues and customValues is null or minus is true");
                }
            } else {
                vs = (List<S>) EnhancedEnum.values((Class<E>) nestedPropertyClass);
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
            if (ISelectable.class.isAssignableFrom(v.getClass())) {
                valueMap.put(Messages.get(((ISelectable<String>) v).getDescription()), v);
            } else {
                valueMap.put(v.toString(), v);
            }
        }

        this.values = new ArrayList<>(valueMap.keySet());
    }

    public List<String> getValues() {
        return values;
    }

    public Map<String, S> getValueMap() {
        return valueMap;
    }

}

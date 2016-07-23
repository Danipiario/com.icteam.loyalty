package com.icteam.loyalty.ui.model;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.model.util.ModelUtil;

public class TableViewerModel<M extends IModel, S extends Object> extends LabelModel<M, List<S>> {

    private static final long serialVersionUID = -389856560005584245L;

    private String[] propertyNames;

    private final Class<S> itemClass;

    private S selectedItem;

    public TableViewerModel(M model, String property, Class<S> itemClass, String... propertyNames) {
        super(model, property);

        this.itemClass = itemClass;

        setPropertyNames(propertyNames);
    }

    public Class<S> getItemClass() {
        return itemClass;
    }

    public String[] getPropertyNames() {
        return propertyNames;
    }

    public void setPropertyNames(String[] propertyNames) {
        if (ArrayUtils.isEmpty(propertyNames)) {
            this.propertyNames = ModelUtil.collectPropertyNames(itemClass);
        } else {
            this.propertyNames = propertyNames;
        }
    }

    public S getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(S selected) {
        this.selectedItem = selected;
    }

}

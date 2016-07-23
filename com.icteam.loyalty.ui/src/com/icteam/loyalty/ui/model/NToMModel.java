package com.icteam.loyalty.ui.model;

import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.icteam.loyalty.model.interfaces.IModel;

public class NToMModel<M extends IModel, S extends Object> extends LabelModel<M, List<S>> {

    private static final long serialVersionUID = -389856560005584245L;

    private final List<S> originalSrcList;
    private final List<S> srcList;
    private final String[] srcPropertyNames;
    private final String[] destPropertyNames;

    public NToMModel(M model, String property, List<S> originalSrcList, String[] srcPropertyNames, String[] destPropertyNames) {
        super(model, property);

        this.originalSrcList = originalSrcList;
        this.srcPropertyNames = srcPropertyNames;
        this.destPropertyNames = destPropertyNames;
        this.srcList = ListUtils.subtract(originalSrcList, getPropertyValue());
    }

    public List<S> getSrcList() {
        return srcList;
    }

    public List<S> getOriginalSrcList() {
        return originalSrcList;
    }

    public Class<S> getPropertyItemType() {
        S item = originalSrcList.get(0);

        return (Class<S>) item.getClass();
    }

    public String[] getSrcPropertyNames() {
        return srcPropertyNames;
    }

    public String[] getDestPropertyNames() {
        return destPropertyNames;
    }
}

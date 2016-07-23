package com.icteam.loyalty.ui.model;

import com.icteam.loyalty.model.HierarchyDtoModel;

public class TreeItemModel<D extends HierarchyDtoModel<D>> {

    public D dtoModel;
    public int itemCount;

    public TreeItemModel(D dtoModel, int itemCount) {
        this.dtoModel = dtoModel;
        this.itemCount = itemCount;
    }

}

package com.icteam.loyalty.model.interfaces;

import java.io.Serializable;

public interface IHierarchyTemplate<T extends Serializable> extends ITemplate<T> {

    T getParent();

    void setParent(Object parent);

    T getChild();

    void setChild(Object child);

    Boolean getHierarchySearch();

    void setHierarchySearch(Boolean hierarchySearch);

}
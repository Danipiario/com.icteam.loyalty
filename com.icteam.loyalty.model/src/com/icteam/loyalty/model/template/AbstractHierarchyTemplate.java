package com.icteam.loyalty.model.template;

import java.io.Serializable;

import com.icteam.loyalty.model.interfaces.IHierarchyTemplate;

public abstract class AbstractHierarchyTemplate<T extends Serializable> extends AbstractTemplate<T> implements IHierarchyTemplate<T> {

    private static final long serialVersionUID = 5930061878114793620L;

    private T parent;
    private T child;
    private Boolean hierarchySearch = Boolean.FALSE;

    @Override
    public T getParent() {
        return parent;
    }

    @Override
    public void setParent(Object parent) {
        this.parent = (T) parent;
        this.child = null;
    }

    @Override
    public T getChild() {
        return child;
    }

    @Override
    public void setChild(Object child) {
        this.child = (T) child;
        this.parent = null;
    }

    @Override
    public Boolean getHierarchySearch() {
        return hierarchySearch;
    }

    @Override
    public void setHierarchySearch(Boolean hierarchySearch) {
        this.hierarchySearch = hierarchySearch;
    }

    @Override
    protected void buildWheres() {
        super.buildWheres();

        if (hierarchySearch) {
            if (getParent() != null) {
                buildWhereContains(getMetamodelClass().getSet("parents", getTemplateClass()), getParent());
            } else if (getChild() != null) {
                buildWhereContains(getMetamodelClass().getSet("children", getTemplateClass()), getChild());
            } else {
                buildWhereIsEmpty(getMetamodelClass().getSet("parents", getTemplateClass()));
            }
        }
    }

}

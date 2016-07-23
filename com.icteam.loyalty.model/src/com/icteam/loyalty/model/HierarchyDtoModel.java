package com.icteam.loyalty.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.icteam.loyalty.api.interfaces.Property;
import com.icteam.loyalty.model.interfaces.IImageDtoModel;

public abstract class HierarchyDtoModel<H extends HierarchyDtoModel<H>> extends DtoModel implements IImageDtoModel {

    private static final long serialVersionUID = -1642752769980375148L;

    @Property(translatable = false)
    public static final String ROOT = "-ROOT-";

    @Expose
    private List<H> childrenDto = new ArrayList<>();

    @Expose
    private List<H> parentsDto = new ArrayList<>();

    @Property(translatable = false)
    @Expose
    private Boolean hasChildren = Boolean.TRUE;

    public HierarchyDtoModel() {
        super();
    }

    public List<H> getChildrenDto() {
        return childrenDto;
    }

    public void setChildrenDto(List<H> childrenDto) {
        firePropertyChange("childrenDto", this.childrenDto, this.childrenDto = childrenDto);

        hasChildren = this.childrenDto != null && !this.childrenDto.isEmpty();
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;

        System.out.println("setHasChildren #" + this + " - " + hasChildren);
    }

    public List<H> getParentsDto() {
        return parentsDto;
    }

    public void setParentsDto(List<H> parentsDto) {
        firePropertyChange("parentsDto", this.parentsDto, this.parentsDto = parentsDto);
    }

    public String getHierarchyTable() {
        return getObjectClassName().toUpperCase() + "_HIERARCHY";
    }

    public boolean isPlaceholderDto() {
        return getId() == null || ROOT.equals(getId());
    }

}
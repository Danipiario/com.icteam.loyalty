package com.icteam.loyalty.model.interfaces;

public interface IModel {

    boolean isDirty();

    void setDirty(boolean dirty);

    boolean isEditable();

    void setEditable(boolean editable);

}
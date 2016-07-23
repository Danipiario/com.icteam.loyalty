package com.icteam.loyalty.common.interfaces;

import java.beans.PropertyChangeListener;

public interface IDtoModel extends IModel, Cloneable {

    <C extends IDtoModel> void copyTo(C destModel);

    String getTootlTipText();

    String getDtoName();

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);

    void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);

    void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);

    void enableTrackChanges();

    boolean hasEditor();

    String getPermissionObject();
}

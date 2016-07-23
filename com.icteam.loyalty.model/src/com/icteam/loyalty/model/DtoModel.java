package com.icteam.loyalty.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.Id;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;

import com.icteam.loyalty.api.interfaces.Property;
import com.icteam.loyalty.model.interfaces.IDtoModel;

public class DtoModel implements Serializable, IDtoModel {
    private static final long serialVersionUID = -6386918028206160727L;

    @Property(translatable = false)
    private boolean dirty = false;

    @Property(translatable = false)
    private boolean editable = true;

    @Property(translatable = false)
    private PropertyChangeSupport changeSupport;

    public DtoModel() {
        changeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public void enableTrackChanges() {
        changeSupport.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (!evt.getPropertyName().equals("dirty") && !evt.getPropertyName().equals("editable")) {
                    setDirty(true);
                }
            }
        });
    }

    @Override
    public boolean hasEditor() {
        return true;
    }

    @Override
    public boolean isDirty() {
        return dirty && editable;
    }

    @Override
    public void setDirty(boolean dirty) {
        if (editable || !dirty) {
            firePropertyChange("dirty", this.dirty, this.dirty = dirty);
        }
    }

    @Override
    public boolean isEditable() {
        return editable;
    }

    @Override
    public void setEditable(boolean editable) {
        firePropertyChange("editable", this.editable, this.editable = editable);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @Override
    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(propertyName, listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        if (!ObjectUtils.equals(oldValue, newValue)) {
            changeSupport.firePropertyChange(propertyName, oldValue, newValue);
        }
    }

    @Override
    public <C extends IDtoModel> void copyTo(C destModel) {
        try {
            PropertyUtils.copyProperties(destModel, this);
            destModel.setDirty(this.isDirty());
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object clone() {
        try {
            DtoModel dtoModel = (DtoModel) super.clone();

            dtoModel.changeSupport = new PropertyChangeSupport(dtoModel);

            return dtoModel;
        } catch (CloneNotSupportedException e) {
            // cloneable
            return null;
        }
    }

//    public <T extends DbModel< ? extends IDtoModel>> T build() {
//        DtoClass dtoClassAnn = getClass().getAnnotation(DtoClass.class);
//
//        Class<T> dbModelClass = (Class<T>) dtoClassAnn.sourceClasses()[0];
//
//        T dbModel = null;
//        try {
//            dbModel = dbModelClass.newInstance();
//            PropertyUtils.copyProperties(dbModel, this);
//        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
//            e.printStackTrace();
//        }
//
//        return dbModel;
//    }

    public static <C extends DtoModel> void copyTo(List<C> srcListModel, List<C> destListModel) {
        for (int i = 0; i < srcListModel.size(); i++) {
            C srcDto = srcListModel.get(i);
            C destDto = destListModel.get(i);

            srcDto.copyTo(destDto);
        }
    }

    @Override
    public String getTootlTipText() {
        return "";
    }

    @Override
    public String getDtoName() {
        return "";
    }

    @Override
    public String getPermissionObject() {
        return getObjectClassName().toLowerCase();
    }

    protected String getObjectClassName() {
        return StringUtils.removeEnd(getClass().getSimpleName(), "Dto");
    }

    public Object getId() {
        PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(getClass());
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            Method readMethod = propertyDescriptor.getReadMethod();

            if (readMethod.isAnnotationPresent(Id.class)) {
                try {
                    return PropertyUtils.getProperty(this, propertyDescriptor.getName());
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
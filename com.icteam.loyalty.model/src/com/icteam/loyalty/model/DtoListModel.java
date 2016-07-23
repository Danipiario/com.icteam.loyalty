package com.icteam.loyalty.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;

import com.icteam.loyalty.api.interfaces.Property;
import com.icteam.loyalty.model.interfaces.IDtoModel;

public class DtoListModel<D extends DtoModel> extends DtoModel {
    private static final long serialVersionUID = -5524566324875189559L;

    @Property(translatable = false)
    private D selectedDto;

    @Property
    private List<D> list;

    private final PropertyChangeListener dirtypropertyChangeListener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (!ObjectUtils.equals(evt.getOldValue(), evt.getNewValue())) {
                updateDirty();
            }
        }
    };

    public DtoListModel() {
        list = new ArrayList<>();
    }

    public DtoListModel(Collection< ? extends D> c) {
        this();

        addAll(c);
    }

    public D getSelectedDto() {
        return selectedDto;
    }

    public void setSelectedDto(D selectedDto) {
        firePropertyChange("selectedDto", this.selectedDto, this.selectedDto = selectedDto);
    }

    void updateDirty() {
        boolean dirty = false;
        for (D dtoModel : list) {
            dirty = dirty || dtoModel.isDirty();
        }

        setDirty(dirty);
    }

    @Override
    public boolean isEditable() {
        return super.isEditable();
    }

    @Override
    public void setEditable(boolean editable) {
        super.setEditable(editable);

        for (D dtoModel : list) {
            dtoModel.setEditable(editable);
        }
    }

    public void add(D dtoModel) {
        list.add(dtoModel);

        addDirtyListener(dtoModel);
    }

    public void addAll(Collection< ? extends D> c) {
        list.addAll(c);

        for (D dtoModel : c) {
            addDirtyListener(dtoModel);
        }
    }

    private void addDirtyListener(D dtoModel) {
        dtoModel.addPropertyChangeListener("dirty", dirtypropertyChangeListener);
    }

    @Override
    public <C extends IDtoModel> void copyTo(C destModel) {
        for (int i = 0; i < list.size(); i++) {
            D srcDto = list.get(i);
            D destDto = ((DtoListModel<D>) destModel).getList().get(i);

            srcDto.copyTo(destDto);
        }
    }

    @Override
    public Object clone() {
        DtoListModel<D> clone = (DtoListModel<D>) super.clone();

        clone.getList().clear();

        for (D dtoModel : list) {
            clone.getList().add((D) dtoModel.clone());
        }

        return clone;
    }

//    @Override
//    public <T extends DbModel< ? extends IDtoModel>> T build() {
//        throw new IllegalArgumentException();
//    }

//    public <T extends DbModel<D>> T build(Class<T> dbModelClass) {
//        T dbModel = null;
//
//        if (selectedDto != null) {
//            try {
//                dbModel = dbModelClass.newInstance();
//                PropertyUtils.copyProperties(dbModel, selectedDto);
//            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return dbModel;
//    }

    @Override
    public String getTootlTipText() {
        return getSelectedDto() == null ? "" : getSelectedDto().getTootlTipText();
    }

    @Override
    public String getDtoName() {
        return getSelectedDto() == null ? "" : getSelectedDto().getDtoName();
    }

    public List<D> getList() {
        return list;
    }

    public void setList(List<D> list) {
        this.list.clear();

        this.list.addAll(list);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null) {
//            return false;
//        }
//        if (getClass() != o.getClass()) {
//            return false;
//        }
//
//        return getSelectedDto() == null ? super.equals(o) : getSelectedDto().equals(((DtoListModel<D>) o).getSelectedDto());
//    }
//
//    @Override
//    public int hashCode() {
//        return getSelectedDto() == null ? super.hashCode() : getSelectedDto().hashCode();
//    }

}
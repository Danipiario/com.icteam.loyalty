package com.icteam.loyalty.ui.model;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.model.interfaces.IModel;

public class LabelModel<M extends IModel, S extends Object> extends ModelProperty<M, S> {

    private static final long serialVersionUID = 6762910668714074083L;

    private String label;

    public LabelModel(M model, String property) {
        super(model, property);

        initLabel();
    }

    protected void initLabel() {
        setLabel(Messages.get(getNestedModelClass(), getNestedProperty())); //$NON-NLS-1$
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        changeSupport.firePropertyChange("label", this.label, this.label = label);
    }
}

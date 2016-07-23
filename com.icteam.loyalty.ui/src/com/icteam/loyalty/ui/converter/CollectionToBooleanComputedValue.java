package com.icteam.loyalty.ui.converter;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.ComputedValue;

public class CollectionToBooleanComputedValue extends ComputedValue {

    public CollectionToBooleanComputedValue(IObservableList observableList) {
        super(observableList);
    }

    @Override
    protected Object calculate() {
        return !((IObservableList) getValueType()).isEmpty();
    }

}

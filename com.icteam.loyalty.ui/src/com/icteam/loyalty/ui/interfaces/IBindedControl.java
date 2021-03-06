package com.icteam.loyalty.ui.interfaces;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.internal.databinding.BindingStatus;

public interface IBindedControl {

    DataBindingContext getBindingContext();

    void updateModelToTarget();

    BindingStatus validate();

}
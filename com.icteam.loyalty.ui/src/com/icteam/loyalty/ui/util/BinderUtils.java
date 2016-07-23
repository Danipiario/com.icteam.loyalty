package com.icteam.loyalty.ui.util;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.ui.interfaces.IBindedControl;
import com.icteam.loyalty.ui.interfaces.IBindingController;
import com.icteam.loyalty.ui.interfaces.IModelControl;
import com.icteam.loyalty.ui.interfaces.IModelProperty;

public class BinderUtils {

    public static BindingStatus validate(IBindedControl bindedControl) {
        BindingStatus bindingStatus = BindingStatus.ok();

        for (Object object : bindedControl.getBindingContext().getValidationStatusProviders()) {
            if (object instanceof ValidationStatusProvider) {
                IObservableValue value = ((ValidationStatusProvider) object).getValidationStatus();
                Status status = (Status) value.getValue();

                if (!status.isOK()) {
                    bindingStatus.merge(status);
                }
            }
        }

        return bindingStatus;
    }

    public static BindingStatus validateControls(Control parent) {
        BindingStatus bindingStatus = BindingStatus.ok();

        if (parent instanceof IBindedControl) {
            bindingStatus.merge(((IBindedControl) parent).validate());
        } else {
            for (Control control : ((Composite) parent).getChildren()) {
                BindingStatus bs = BindingStatus.ok();

                if (control instanceof IBindedControl) {
                    bs = ((IBindedControl) control).validate();
                } else if (control instanceof Composite) {
                    bs = validateControls(control);
                }

                bindingStatus.merge(bs);
            }
        }

        return bindingStatus;
    }

    public static <M extends IModel, SM extends Object, TM extends IModelProperty<M, SM>, SD extends Object, TD extends IModelProperty<M, SD>> void bind(
            final IBindingController controller, IModelControl<M, SM, TM>... masterControls) {
        controller.setModelProperty();

        for (IModelControl<M, SM, TM> masterControl : masterControls) {
            masterControl.getModelProperty().addPropertyChangeListener("propertyValue", new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    controller.setModelProperty();
                }
            });
        }
    }

}
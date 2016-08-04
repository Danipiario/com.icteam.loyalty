package com.icteam.loyalty.common.ui.util;

import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.ui.interfaces.IBindedControl;
import com.icteam.loyalty.common.ui.interfaces.IBindingController;
import com.icteam.loyalty.common.ui.interfaces.IDTOControl;
import com.icteam.loyalty.common.ui.interfaces.IDTOProperty;

public class BinderUtils {

	public static BindingStatus validate(IBindedControl bindedControl) {
		final BindingStatus bindingStatus = BindingStatus.ok();

		for (final Object object : bindedControl.getBindingContext().getValidationStatusProviders()) {
			if (object instanceof ValidationStatusProvider) {
				final IObservableValue<Status> value = ((ValidationStatusProvider) object).getValidationStatus();
				final Status status = value.getValue();

				if (!status.isOK()) {
					bindingStatus.merge(status);
				}
			}
		}

		return bindingStatus;
	}

	public static BindingStatus validateControls(Control parent) {
		final BindingStatus bindingStatus = BindingStatus.ok();

		if (parent instanceof IBindedControl) {
			bindingStatus.merge(((IBindedControl) parent).validate());
		} else {
			for (final Control control : ((Composite) parent).getChildren()) {
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

	public static <M extends IDTO, SM extends Object, TM extends IDTOProperty<M, SM>, SD extends Object, TD extends IDTOProperty<M, SD>> void bind(
			final IBindingController controller, IDTOControl<M, SM, TM>... masterControls) {
		controller.setModelProperty();

		for (final IDTOControl<M, SM, TM> masterControl : masterControls) {
			masterControl.getModelProperty().addPropertyChangeListener("propertyValue",
					evt -> controller.setModelProperty());
		}
	}

}
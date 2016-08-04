package com.icteam.loyalty.common.ui.validator;

import java.lang.ref.WeakReference;
import java.util.List;

import org.eclipse.core.databinding.validation.MultiValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Control;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.nls.Messages;
import com.icteam.loyalty.common.nls.NLS;
import com.icteam.loyalty.common.ui.model.LabelModel;

public class RequiredListValidator<M extends IDTO, S extends Object> extends MultiValidator {

	private final WeakReference<LabelModel<M, List<S>>> model;
	final SimpleControlDecorationUpdater controlDecorationUpdater;

	public RequiredListValidator(LabelModel<M, List<S>> model, Control control, int position) {
		this.model = new WeakReference<>(model);

		controlDecorationUpdater = new SimpleControlDecorationUpdater(control, position);
		controlDecorationUpdater.update((Status) getValidationStatus().getValue());

		getValidationStatus().addValueChangeListener(
				event -> controlDecorationUpdater.update((Status) getValidationStatus().getValue()));
	}

	public void forceRevalidate() {
		revalidate();
	}

	@Override
	protected IStatus validate() {
		return model.get().isRequired() && model.get().getPropertyValue().isEmpty()
				? ValidationStatus.error(NLS.getFormatted(Messages.get().listNotEmpty, model.get().getLabel()))
				: ValidationStatus.ok();
	}

}

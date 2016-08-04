package com.icteam.loyalty.common.ui.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.ui.interfaces.IDTOProperty;

public class MultiPropertyValidator<M extends IDTO, S extends Object> implements IValidator {

	private final List<IValidator> validators;

	public MultiPropertyValidator(IDTOProperty<M, S> modelProperty) {
		validators = new ArrayList<>();

		validators.add(new RequiredValidator<>(modelProperty));
		validators.add(new ValidatedValidator<>(modelProperty));
	}

	@Override
	public IStatus validate(Object value) {
		for (final IValidator validator : validators) {
			final IStatus status = validator.validate(value);

			if (!status.isOK()) {
				return status;
			}
		}

		return ValidationStatus.ok();
	}
}

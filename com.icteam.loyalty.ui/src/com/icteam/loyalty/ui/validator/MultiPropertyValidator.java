package com.icteam.loyalty.ui.validator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.ui.interfaces.IModelProperty;

public class MultiPropertyValidator<M extends IModel, S extends Object> implements IValidator {

    private final List<IValidator> validators;

    public MultiPropertyValidator(IModelProperty<M, S> modelProperty) {
        validators = new ArrayList<>();

        validators.add(new RequiredValidator<>(modelProperty));
        validators.add(new MinLengthI18NValidator<>(modelProperty));
        validators.add(new ValidatedValidator<>(modelProperty));
    }

    @Override
    public IStatus validate(Object value) {
        for (IValidator validator : validators) {
            IStatus status = validator.validate(value);

            if (!status.isOK()) {
                return status;
            }
        }

        return ValidationStatus.ok();
    }
}

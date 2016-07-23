package com.icteam.loyalty.ui.validator;

import org.apache.commons.lang.ObjectUtils;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.icteam.loyalty.api.Messages;

public class EmailValidator implements IValidator {

    @Override
    public IStatus validate(Object value) {
        String stringValue = ObjectUtils.toString(value);

        IStatus status = ValidationStatus.ok();

        org.apache.commons.validator.routines.EmailValidator emailValidator = org.apache.commons.validator.routines.EmailValidator.getInstance();

        if (!emailValidator.isValid(stringValue)) {
            status = ValidationStatus.error(Messages.get().email_not_invalid);
        }

        return status;
    }
}

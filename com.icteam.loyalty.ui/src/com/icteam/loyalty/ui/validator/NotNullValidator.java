package com.icteam.loyalty.ui.validator;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.IInputValidator;

import com.icteam.loyalty.api.Messages;

public class NotNullValidator implements IInputValidator {

    private static final long serialVersionUID = 4691710552292468676L;

    @Override
    public String isValid(String newText) {
        return StringUtils.isEmpty(newText) ? Messages.get().value_not_null : null;
    }
}

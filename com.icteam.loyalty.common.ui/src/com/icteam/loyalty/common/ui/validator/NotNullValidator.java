package com.icteam.loyalty.common.ui.validator;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jface.dialogs.IInputValidator;

import com.icteam.loyalty.common.nls.Messages;

public class NotNullValidator implements IInputValidator {

	private static final long serialVersionUID = 4691710552292468676L;

	@Override
	public String isValid(String newText) {
		return StringUtils.isEmpty(newText) ? Messages.get().valueNotNull : null;
	}
}

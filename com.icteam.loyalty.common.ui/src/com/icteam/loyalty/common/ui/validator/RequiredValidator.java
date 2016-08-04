package com.icteam.loyalty.common.ui.validator;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Objects;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.nls.Messages;
import com.icteam.loyalty.common.nls.NLS;
import com.icteam.loyalty.common.ui.interfaces.IDTOProperty;

public class RequiredValidator<M extends IDTO, S extends Object> implements IValidator {

	private final IDTOProperty<M, S> modelProperty;

	public RequiredValidator(IDTOProperty<M, S> modelProperty) {
		this.modelProperty = modelProperty;
	}

	@Override
	public IStatus validate(Object value) {
		if (modelProperty.isRequired() && (StringUtils.isBlank(Objects.toString(value))
				|| value instanceof Collection && CollectionUtils.isEmpty((Collection<?>) value))) {
			return ValidationStatus.error(MessageFormat.format(Messages.get().valueRequired,
					NLS.get(modelProperty.getNestedModelClass(), modelProperty.getNestedProperty())));
		}

		return ValidationStatus.ok();
	}
}

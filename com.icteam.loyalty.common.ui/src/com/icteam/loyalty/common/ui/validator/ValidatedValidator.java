package com.icteam.loyalty.common.ui.validator;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.common.annotations.Validated;
import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.nls.Messages;
import com.icteam.loyalty.common.nls.NLS;
import com.icteam.loyalty.common.ui.interfaces.IDTOProperty;

public class ValidatedValidator<M extends IDTO, S extends Object> implements IValidator {

	private final IDTOProperty<M, S> modelProperty;
	private Validated validated;
	private String regExpr;
	private Pattern pattern;
	private IValidator validator;

	public ValidatedValidator(IDTOProperty<M, S> modelProperty) {
		this.modelProperty = modelProperty;

		init();
	}

	private void init() {
		validated = modelProperty.getValidated();

		if (validated != null) {
			switch (validated.validation()) {
			case REG_EXPR:
				regExpr = validated.regExpr();
				pattern = Pattern.compile(regExpr);

				break;
			case VALIDATOR:
				ServiceTracker<IValidator, IValidator> serviceTracker = null;
				try {
					final Filter filter = FrameworkUtil.createFilter("(&(" + Constants.OBJECTCLASS + "="
							+ IValidator.class.getName() + ")(validatorId=" + validated.validatorId() + "))");

					serviceTracker = new ServiceTracker<>(FrameworkUtil.getBundle(getClass()).getBundleContext(),
							filter, null);
					serviceTracker.open();

					validator = serviceTracker.getService();
				} catch (final InvalidSyntaxException e) {
					e.printStackTrace();
				} finally {
					if (serviceTracker != null) {
						serviceTracker.close();
					}
				}

				break;
			default:
			}
		}
	}

	@Override
	public IStatus validate(Object value) {
		IStatus status = ValidationStatus.ok();

		if (validated != null) {
			final String stringValue = Objects.toString(value);

			if (StringUtils.isNotEmpty(stringValue)) {
				switch (validated.validation()) {
				case REG_EXPR:
					status = validateRegExpr(status, stringValue);

					break;
				case VALIDATOR:
					status = validateValidator(value);
					break;
				default:
				}
			}
		}

		return status;
	}

	private IStatus validateValidator(Object value) {
		return validator.validate(value);
	}

	private IStatus validateRegExpr(IStatus status, String stringValue) {
		if (!pattern.matcher(stringValue).matches()) {
			status = ValidationStatus.error(MessageFormat.format(Messages.get().valueFormatInvalid,
					NLS.get(modelProperty.getNestedModelClass(), modelProperty.getNestedProperty()),
					MessageFormat.format(NLS.get(validated.validationMessage()), regExpr)));
		}

		return status;
	}
}

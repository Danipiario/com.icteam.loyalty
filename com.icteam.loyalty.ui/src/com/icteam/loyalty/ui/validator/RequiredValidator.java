package com.icteam.loyalty.ui.validator;

import java.text.MessageFormat;
import java.util.Collection;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.ui.interfaces.IModelProperty;

public class RequiredValidator<M extends IModel, S extends Object> implements IValidator {

    private final IModelProperty<M, S> modelProperty;

    public RequiredValidator(IModelProperty<M, S> modelProperty) {
        this.modelProperty = modelProperty;
    }

    @Override
    public IStatus validate(Object value) {
        if (modelProperty.isRequired()
                && (StringUtils.isBlank(ObjectUtils.toString(value)) || value instanceof Collection
                        && CollectionUtils.isEmpty((Collection< ? >) value))) {
            return ValidationStatus.error(MessageFormat.format(Messages.get().value_required,
                    Messages.get(modelProperty.getNestedModelClass(), modelProperty.getNestedProperty())));
        }

        return ValidationStatus.ok();
    }
}

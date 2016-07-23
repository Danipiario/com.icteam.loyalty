package com.icteam.loyalty.ui.validator;

import java.text.MessageFormat;

import org.apache.commons.lang.ObjectUtils;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.model.ModelProperties;
import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.interfaces.IModelProperty;

public class MinLengthI18NValidator<M extends IModel, S extends Object> implements IValidator {

    private final IModelProperty<M, S> modelProperty;
    private final boolean i18nField;

    public MinLengthI18NValidator(IModelProperty<M, S> modelProperty) {
        this.modelProperty = modelProperty;

        i18nField = ModelUtil.isI18NField(modelProperty.getFieldProperty());
    }

    @Override
    public IStatus validate(Object value) {
        if (i18nField) {
            String stringValue = ObjectUtils.toString(value);

            if (!ModelUtil.checkMinLengthI18N(stringValue)) {
                return ValidationStatus.error(MessageFormat.format(Messages.get().value_not_min_length, Messages.get(
                        modelProperty.getNestedModelClass(), modelProperty.getNestedProperty()), ModelProperties.getInstance()
                        .minSearchCharacterI18N()));
            }
        }

        return ValidationStatus.ok();
    }
}

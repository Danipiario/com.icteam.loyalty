package com.icteam.loyalty.ui.validator;

import java.lang.ref.WeakReference;
import java.util.List;

import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.validation.MultiValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.widgets.Control;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.ui.model.LabelModel;

public class RequiredListValidator<M extends IModel, S extends Object> extends MultiValidator {

    private final WeakReference<LabelModel<M, List<S>>> model;
    final SimpleControlDecorationUpdater controlDecorationUpdater;

    public RequiredListValidator(LabelModel<M, List<S>> model, Control control, int position) {
        this.model = new WeakReference<>(model);

        controlDecorationUpdater = new SimpleControlDecorationUpdater(control, position);
        controlDecorationUpdater.update((Status) getValidationStatus().getValue());

        getValidationStatus().addValueChangeListener(new IValueChangeListener() {
            @Override
            public void handleValueChange(ValueChangeEvent event) {
                controlDecorationUpdater.update((Status) getValidationStatus().getValue());
            }
        });
    }

    public void forceRevalidate() {
        revalidate();
    }

    @Override
    protected IStatus validate() {
        return model.get().isRequired() && model.get().getPropertyValue().isEmpty() ? ValidationStatus.error(Messages.getFormatted(
                Messages.get().list_not_empty, model.get().getLabel())) : ValidationStatus.ok();
    }

}

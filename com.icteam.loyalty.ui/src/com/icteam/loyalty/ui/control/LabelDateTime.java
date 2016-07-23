package com.icteam.loyalty.ui.control;

import java.util.Date;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.internal.databinding.swt.WidgetDateChooserComboSelectionProperty;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.ui.converter.StringToLabelConverter;
import com.icteam.loyalty.ui.interfaces.IBindedControl;
import com.icteam.loyalty.ui.interfaces.ILabelControl;
import com.icteam.loyalty.ui.interfaces.IModelControl;
import com.icteam.loyalty.ui.model.LabelDateTimeModel;
import com.icteam.loyalty.ui.util.BinderUtils;
import com.icteam.loyalty.ui.validator.RequiredValidator;

public class LabelDateTime<M extends IModel> extends Composite implements IBindedControl, ILabelControl,
        IModelControl<M, Date, LabelDateTimeModel<M>> {
    private static final long serialVersionUID = 4106014725142032588L;

    private final DateChooserCombo dateTimeControl;
    private final Label labelControl;

    private LabelDateTimeModel<M> modelProperty;

    private DataBindingContext bindingContext;

    private Binding binding;

    /**
     * Create the composite.
     *
     * @param parent
     */
    public LabelDateTime(Composite parent) {
        super(parent, SWT.NO_FOCUS);
        setLayout(new GridLayout(2, false));

        labelControl = new Label(this, SWT.NONE);
        labelControl.setText("New Label");

        dateTimeControl = new DateChooserCombo(this, SWT.BORDER | SWT.READ_ONLY);
        dateTimeControl.setFooterVisible(true);
        dateTimeControl.setTextLimit(10);
        dateTimeControl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    }

    public DateChooserCombo getDateTimeControl() {
        return dateTimeControl;
    }

    @Override
    public Label getLabelControl() {
        return labelControl;
    }

    @Override
    public void setModelProperty(M dtoModel, String property) {
        modelProperty = new LabelDateTimeModel<>(dtoModel, property);

        if (modelProperty.isRequired()) {
            labelControl.setData(RWT.CUSTOM_VARIANT, "required");
        }

        initDataBindings();
    }

    @Override
    public LabelDateTimeModel<M> getModelProperty() {
        return modelProperty;
    }

    @Override
    public DataBindingContext getBindingContext() {
        return bindingContext;
    }

    @Override
    public void updateModelToTarget() {
        binding.updateModelToTarget();
    }

    @Override
    public BindingStatus validate() {
        return BinderUtils.validate(this);
    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }

    protected void initDataBindings() {
        if (bindingContext != null) {
            bindingContext.dispose();
        }

        bindingContext = new DataBindingContext();
        //
        IObservableValue observeTextLblControlObserveWidget = WidgetProperties.text().observe(labelControl);
        IObservableValue labelModelObserveValue = BeanProperties.value("label").observe(modelProperty);
        UpdateValueStrategy strategy = new UpdateValueStrategy();
        strategy.setConverter(new StringToLabelConverter());
        bindingContext.bindValue(observeTextLblControlObserveWidget, labelModelObserveValue, null, strategy);
        //
        IObservableValue observeDateTimeControlObserveWidget = new WidgetDateChooserComboSelectionProperty().observe(dateTimeControl);
        IObservableValue dateTimeModelObserveValue = BeanProperties.value("propertyValue").observe(modelProperty);

        strategy = new UpdateValueStrategy();
        strategy.setBeforeSetValidator(new RequiredValidator<>(modelProperty));
        strategy.setConverter(modelProperty.getModelConverter());
        binding = bindingContext.bindValue(observeDateTimeControlObserveWidget, dateTimeModelObserveValue, strategy, strategy);
        ControlDecorationSupport.create(binding, SWT.LEFT | SWT.TOP);

        //
        IObservableValue observeEnabledTxtControlObserveWidget = WidgetProperties.enabled().observe(dateTimeControl);
        IObservableValue enabledModelObserveValue = BeanProperties.value("enabled").observe(modelProperty);
        bindingContext.bindValue(observeEnabledTxtControlObserveWidget, enabledModelObserveValue, null, null);
    }
}

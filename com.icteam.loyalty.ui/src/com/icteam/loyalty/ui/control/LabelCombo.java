package com.icteam.loyalty.ui.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.ui.converter.LabelToModelConverter;
import com.icteam.loyalty.ui.converter.ModelToLabelConverter;
import com.icteam.loyalty.ui.converter.StringToLabelConverter;
import com.icteam.loyalty.ui.interfaces.IBindedControl;
import com.icteam.loyalty.ui.interfaces.ILabelControl;
import com.icteam.loyalty.ui.interfaces.IModelControl;
import com.icteam.loyalty.ui.model.LabelComboModel;
import com.icteam.loyalty.ui.util.BinderUtils;
import com.icteam.loyalty.ui.validator.RequiredValidator;

public class LabelCombo<M extends IModel, S extends Serializable & Comparable<S>> extends Composite implements IBindedControl, ILabelControl,
        IModelControl<M, S, LabelComboModel<M, S>> {
    private static final long serialVersionUID = 4106014725142032588L;

    public static final int NO_AUTO_SELECT = 1 << 17;

    private DataBindingContext bindingContext;
    private final Combo cmbControl;
    final Label labelControl;

    LabelComboModel<M, S> modelProperty;

    Binding binding;

    private boolean selectFirst = true;

    /**
     * Create the composite.
     *
     * @param parent
     * @param style
     */
    public LabelCombo(Composite parent, int style) {
        super(parent, style | SWT.NO_FOCUS);
        setLayout(new GridLayout(2, false));

//        if (parent.getLayout() instanceof GridLayout) {
//            setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
//        }

        selectFirst = !((style & NO_AUTO_SELECT) == NO_AUTO_SELECT);

        labelControl = new Label(this, SWT.NONE);
        labelControl.setText("New Label");

        cmbControl = new Combo(this, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
        cmbControl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
    }

//    public LabelCombo(Composite parent, int style) {
//        super(parent, SWT.NONE);
//        setLayout(new FormLayout());
//
//        labelControl = new Label(this, SWT.NONE);
//        FormData fd_labelControl = new FormData();
//        fd_labelControl.top = new FormAttachment(0, 9);
//        fd_labelControl.left = new FormAttachment(0, 5);
//        labelControl.setLayoutData(fd_labelControl);
//        labelControl.setText("New Label");
//
//        cmbControl = new Combo(this, SWT.READ_ONLY);
//        FormData fd_cmbControl = new FormData();
//        fd_cmbControl.right = new FormAttachment(100, -5);
//        fd_cmbControl.left = new FormAttachment(labelControl, 5);
//        fd_cmbControl.top = new FormAttachment(0, 5);
//        cmbControl.setLayoutData(fd_cmbControl);
//    }
//
//

    public void setSelectFirst(boolean selectFirst) {
        this.selectFirst = selectFirst;
    }

    public Combo getCmbControl() {
        return cmbControl;
    }

    @Override
    public Label getLabelControl() {
        return labelControl;
    }

    @Override
    public void setModelProperty(M model, String property) {
        setModelProperty(model, property, null, false);
    }

    public void setModelProperty(M model, String property, List<S> customValues) {
        setModelProperty(model, property, customValues, false);
    }

    public void setModelProperty(M model, String property, List<S> customValues, boolean minus) {
        modelProperty = new LabelComboModel<>(model, property, customValues, minus);

        manageRequired();

        initDataBindings();

        initCustomBindings();
    }

    private void manageRequired() {
        if (modelProperty.isRequired()) {
            labelControl.setData(RWT.CUSTOM_VARIANT, "required");
        }

        modelProperty.addPropertyChangeListener("required", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (modelProperty.isRequired()) {
                    labelControl.setData(RWT.CUSTOM_VARIANT, "required");
                } else {
                    labelControl.setData(RWT.CUSTOM_VARIANT, null);
                }

                binding.validateTargetToModel();
            }
        });
    }

    @Override
    public LabelComboModel<M, S> getModelProperty() {
        return modelProperty;
    }

    private void initCustomBindings() {
        ControlDecorationSupport.create(binding, SWT.LEFT | SWT.TOP);

        if (cmbControl.getSelectionIndex() == -1 && selectFirst) {
            cmbControl.select(0);
        }
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
        IObservableValue observeComboLblControlObserveWidget = WidgetProperties.text().observe(labelControl);
        IObservableValue labelModelObserveValue = BeanProperties.value("label").observe(modelProperty);
        UpdateValueStrategy strategy = new UpdateValueStrategy();
        strategy.setConverter(new StringToLabelConverter());
        bindingContext.bindValue(observeComboLblControlObserveWidget, labelModelObserveValue, null, strategy);
        //
        IObservableList itemsCmbControlObserveWidget = WidgetProperties.items().observe(cmbControl);
        IObservableList valuesModelObserveList = BeanProperties.list("values").observe(modelProperty);
        bindingContext.bindList(itemsCmbControlObserveWidget, valuesModelObserveList, null, null);

        IObservableValue observeComboCmbControlObserveWidget = WidgetProperties.selection().observe(cmbControl);
        IObservableValue textModelObserveValue = BeanProperties.value("propertyValue").observe(modelProperty);
        UpdateValueStrategy strategy2 = new UpdateValueStrategy();
        strategy2.setBeforeSetValidator(new RequiredValidator<>(modelProperty));

        strategy2.setConverter(new LabelToModelConverter(modelProperty.getValueMap()));

        UpdateValueStrategy strategy3 = new UpdateValueStrategy();
        strategy3.setBeforeSetValidator(new RequiredValidator<>(modelProperty));
        strategy3.setConverter(new ModelToLabelConverter());

        binding = bindingContext.bindValue(observeComboCmbControlObserveWidget, textModelObserveValue, strategy2, strategy3);
        //
        IObservableValue observeEnabledCmbControlObserveWidget = WidgetProperties.enabled().observe(cmbControl);
        final IObservableValue enabledModelObserveValue = BeanProperties.value("enabled").observe(modelProperty);
        final IObservableValue editableModelObserveValue = BeanProperties.value("editable").observe(modelProperty);

        IObservableValue observeEnableEditableValue = new ComputedValue() {
            @Override
            protected Object calculate() {
                return (Boolean) enabledModelObserveValue.getValue() && (Boolean) editableModelObserveValue.getValue();
            }
        };

        bindingContext.bindValue(observeEnabledCmbControlObserveWidget, observeEnableEditableValue, null, null);
    }
}

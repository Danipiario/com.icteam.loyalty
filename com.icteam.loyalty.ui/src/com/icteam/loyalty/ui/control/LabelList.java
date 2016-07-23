package com.icteam.loyalty.ui.control;

import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.internal.databinding.swt.ListMultiSelectionProperty;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.icteam.loyalty.api.interfaces.ISelectable;
import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.ui.converter.MultiLabelToSelectableConverter;
import com.icteam.loyalty.ui.converter.MultiSelectableToLabelConverter;
import com.icteam.loyalty.ui.converter.StringToLabelConverter;
import com.icteam.loyalty.ui.interfaces.IBindedControl;
import com.icteam.loyalty.ui.interfaces.ILabelControl;
import com.icteam.loyalty.ui.interfaces.IModelProvider;
import com.icteam.loyalty.ui.model.LabelListModel;
import com.icteam.loyalty.ui.util.BinderUtils;
import com.icteam.loyalty.ui.validator.RequiredValidator;

public class LabelList<M extends IModel, S extends ISelectable<String> & Comparable<S>> extends Composite implements IBindedControl,
        IModelProvider<M, List<S>, LabelListModel<M, S>>, ILabelControl {

    private static final long serialVersionUID = -8536935429447636321L;

    private DataBindingContext bindingContext;

    private LabelListModel<M, S> modelProperty;

    private Binding binding;

    private final org.eclipse.swt.widgets.List listControl;

    private final Label labelControl;

    public LabelList(Composite parent, int style) {
        super(parent, style | SWT.NO_FOCUS);

        setLayout(new GridLayout(2, false));

        labelControl = new Label(this, SWT.NONE);
        labelControl.setText("New Label");

        listControl = new org.eclipse.swt.widgets.List(this, SWT.MULTI | SWT.BORDER);
        listControl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1));
    }

    public org.eclipse.swt.widgets.List getListControl() {
        return listControl;
    }

    @Override
    public Label getLabelControl() {
        return labelControl;
    }

    @Override
    public LabelListModel<M, S> getModelProperty() {
        return modelProperty;
    }

    public void setModelProperty(M model, String property, Class<S> listPropertyClass) {
        setModelProperty(model, property, listPropertyClass, null, false);
    }

    public void setModelProperty(M model, String property, Class<S> listPropertyClass, List<S> customValues) {
        setModelProperty(model, property, listPropertyClass, customValues, false);
    }

    public void setModelProperty(M model, String property, Class<S> listPropertyClass, List<S> customValues, boolean minus) {
        modelProperty = new LabelListModel<>(model, property, listPropertyClass, customValues, minus);

        if (modelProperty.isRequired()) {
            labelControl.setData(RWT.CUSTOM_VARIANT, "required");
        }

        initDataBindings();
    }

    protected void initDataBindings() {
        if (Realm.getDefault() == null) {
            return;
        }

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
        IObservableList itemsCmbControlObserveWidget = WidgetProperties.items().observe(listControl);
        IObservableList valuesModelObserveList = BeanProperties.list("values").observe(modelProperty);
        bindingContext.bindList(itemsCmbControlObserveWidget, valuesModelObserveList, null, null);

        IObservableValue observeComboCmbControlObserveWidget = new ListMultiSelectionProperty().observe(listControl);
        IObservableValue listModelObserveValue = BeanProperties.value("propertyValue").observe(modelProperty);
        UpdateValueStrategy strategy2 = new UpdateValueStrategy();
        strategy2.setBeforeSetValidator(new RequiredValidator<>(modelProperty));
        strategy2.setConverter(new MultiLabelToSelectableConverter<>(modelProperty.getValuesToSelectables()));

        UpdateValueStrategy strategy3 = new UpdateValueStrategy();
        strategy3.setBeforeSetValidator(new RequiredValidator<>(modelProperty));
        strategy3.setConverter(new MultiSelectableToLabelConverter());

        binding = bindingContext.bindValue(observeComboCmbControlObserveWidget, listModelObserveValue, strategy2, strategy3);
        //
        IObservableValue observeEnabledCmbControlObserveWidget = WidgetProperties.enabled().observe(listControl);
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
}

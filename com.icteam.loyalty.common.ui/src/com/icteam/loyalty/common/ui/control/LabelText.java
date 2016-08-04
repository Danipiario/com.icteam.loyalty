package com.icteam.loyalty.common.ui.control;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.ui.converter.StringToLabelConverter;
import com.icteam.loyalty.common.ui.interfaces.IBindedControl;
import com.icteam.loyalty.common.ui.interfaces.IDTOControl;
import com.icteam.loyalty.common.ui.interfaces.ILabelControl;
import com.icteam.loyalty.common.ui.model.LabelTextModel;
import com.icteam.loyalty.common.ui.util.BinderUtils;
import com.icteam.loyalty.common.ui.validator.MultiPropertyValidator;

public class LabelText<M extends IDTO, S extends Object> extends Composite
		implements IBindedControl, ILabelControl, IDTOControl<M, S, LabelTextModel<M, S>> {
	private static final long serialVersionUID = 4106014725142032588L;

	private Text txtControl;
	private final Label labelControl;

	private LabelTextModel<M, S> modelProperty;

	private DataBindingContext bindingContext;

	private Binding binding;

	/**
	 * Create the composite.
	 *
	 * @param parent
	 * @param style
	 */
	public LabelText(Composite parent, int style) {
		super(parent, style | SWT.NO_FOCUS);
		super.setLayout(new GridLayout(2, false));

		// fa il fill del text a destra
		// if (parent.getLayout() instanceof GridLayout) {
		// setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
		// 1));
		// }

		labelControl = new Label(this, SWT.NONE);
		labelControl.setText("New Label");

		txtControl = new Text(this, SWT.SINGLE | SWT.BORDER);

		layoutTxtControl();
	}

	@Override
	public void setLayout(Layout layout) {
		checkWidget();
		return;
	}

	private void layoutTxtControl() {
		final GridData layoutData = new GridData(SWT.FILL, SWT.CENTER, true, true, 1, 1);
		txtControl.setLayoutData(layoutData);
	}

	public Text getTxtControl() {
		return txtControl;
	}

	@Override
	public Label getLabelControl() {
		return labelControl;
	}

	@Override
	public void setModelProperty(M dtoModel, String property) {
		modelProperty = new LabelTextModel<>(dtoModel, property);

		if (modelProperty.isRequired()) {
			labelControl.setData(RWT.CUSTOM_VARIANT, "required");
		}

		int style = SWT.NONE;

		if (modelProperty.isPassword()) {
			style |= SWT.PASSWORD | SWT.SINGLE | SWT.LEAD | SWT.BORDER;
		}

		if (!modelProperty.isEditable()) {
			style |= SWT.NO_FOCUS | SWT.READ_ONLY | SWT.SINGLE | SWT.LEAD;
		}

		if ((style | SWT.NONE) != 0) {
			txtControl.dispose();

			txtControl = new Text(this, style);
			layoutTxtControl();
		}

		initDataBindings();
	}

	@Override
	public LabelTextModel<M, S> getModelProperty() {
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
		// $hide>>$
		if (bindingContext != null) {
			bindingContext.dispose();
		}

		bindingContext = new DataBindingContext();
		//
		final IObservableValue<String> observeTextLblControlObserveWidget = WidgetProperties.text()
				.observe(labelControl);
		final IObservableValue<String> labelModelObserveValue = BeanProperties.value("label").observe(modelProperty);
		final UpdateValueStrategy labelUpdateValuestrategy = new UpdateValueStrategy();
		labelUpdateValuestrategy.setConverter(new StringToLabelConverter());
		bindingContext.bindValue(observeTextLblControlObserveWidget, labelModelObserveValue, null,
				labelUpdateValuestrategy);
		//
		final IObservableValue<String> observeTextTxtControlObserveWidget = WidgetProperties.text(SWT.Modify)
				.observe(txtControl);
		final IObservableValue<String> textModelObserveValue = BeanProperties
				.value("propertyValue", modelProperty.getNestedPropertyClass()).observe(modelProperty);

		observeTextTxtControlObserveWidget.addValueChangeListener(event -> getParent().layout(true, true));

		final UpdateValueStrategy modelUpdateValueStrategy = new UpdateValueStrategy();
		modelUpdateValueStrategy.setBeforeSetValidator(new MultiPropertyValidator<>(modelProperty));
		modelUpdateValueStrategy.setConverter(modelProperty.getModelConverter());

		final UpdateValueStrategy targetUpdateValueStrategy = new UpdateValueStrategy();
		targetUpdateValueStrategy.setConverter(modelProperty.getTargetConverter());

		binding = bindingContext.bindValue(observeTextTxtControlObserveWidget, textModelObserveValue,
				modelUpdateValueStrategy, targetUpdateValueStrategy);
		ControlDecorationSupport.create(binding, SWT.LEFT | SWT.TOP);

		//
		final IObservableValue<Boolean> observeEnabledTxtControlObserveWidget = WidgetProperties.enabled()
				.observe(txtControl);
		final IObservableValue<Boolean> enabledModelObserveValue = BeanProperties.value("enabled")
				.observe(modelProperty);
		bindingContext.bindValue(observeEnabledTxtControlObserveWidget, enabledModelObserveValue, null, null);

		final IObservableValue<Boolean> observeEditableTxtControlObserveWidget = WidgetProperties.editable()
				.observe(txtControl);
		final IObservableValue<Boolean> editableModelObserveValue = BeanProperties.value("editable")
				.observe(modelProperty);
		bindingContext.bindValue(observeEditableTxtControlObserveWidget, editableModelObserveValue, null, null);
		// $hide<<$
	}

}

package com.icteam.loyalty.common.ui.control;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.internal.databinding.swt.TriStateSelectionProperty;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.ui.converter.StringToLabelConverter;
import com.icteam.loyalty.common.ui.interfaces.IBindedControl;
import com.icteam.loyalty.common.ui.interfaces.IDTOControl;
import com.icteam.loyalty.common.ui.interfaces.ILabelControl;
import com.icteam.loyalty.common.ui.model.LabelCheckModel;
import com.icteam.loyalty.common.ui.util.BinderUtils;
import com.icteam.loyalty.common.ui.validator.RequiredValidator;

public class LabelCheck<M extends IDTO> extends Composite
implements IBindedControl, ILabelControl, IDTOControl<M, Boolean, LabelCheckModel<M>> {
	private static final long serialVersionUID = 4106014725142032588L;

	final Button chkControl;
	private final Label labelControl;

	private LabelCheckModel<M> modelProperty;

	private DataBindingContext bindingContext;

	/**
	 * Create the composite.
	 *
	 * @param parent
	 */
	public LabelCheck(Composite parent) {
		super(parent, SWT.NO_FOCUS);
		setLayout(new GridLayout(2, false));

		labelControl = new Label(this, SWT.NONE);
		final GridData gd_labelControl = new GridData();
		labelControl.setLayoutData(gd_labelControl);
		labelControl.setText("New Label");

		chkControl = new Button(this, SWT.CHECK);
		chkControl.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		chkControl.setGrayed(true); // set initial value

		chkControl.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent e) {
				chkControl.setGrayed(false);

				// if (chkControl.getSelection()) {
				// chkControl.setGrayed(false);
				// if (!chkControl.getGrayed()) {
				// chkControl.setGrayed(true);
				// }
				// } else {
				// if (chkControl.getGrayed()) {
				// chkControl.setGrayed(false);
				// chkControl.setSelection(true);
				// }
				// }
			}
		});
	}

	public Button getChkControl() {
		return chkControl;
	}

	@Override
	public Label getLabelControl() {
		return labelControl;
	}

	@Override
	public void setModelProperty(M model, String property) {
		modelProperty = new LabelCheckModel<>(model, property);

		if (modelProperty.isRequired()) {
			labelControl.setData(RWT.CUSTOM_VARIANT, "required");
		}

		initDataBindings();
	}

	@Override
	public LabelCheckModel<M> getModelProperty() {
		return modelProperty;
	}

	@Override
	public DataBindingContext getBindingContext() {
		return bindingContext;
	}

	@Override
	public void updateModelToTarget() {
		for (final Object object : bindingContext.getValidationStatusProviders()) {
			if (object instanceof Binding) {
				((Binding) object).updateModelToTarget();
			}
		}
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
		final IObservableValue<String> observeTextLblControlObserveWidget = WidgetProperties.text().observe(labelControl);
		final IObservableValue<String> labelModelObserveValue = BeanProperties.value("label").observe(modelProperty);
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setConverter(new StringToLabelConverter());
		bindingContext.bindValue(observeTextLblControlObserveWidget, labelModelObserveValue, null, strategy);
		//
		final IObservableValue<Boolean> observeCheckChkControlObserveWidget = new TriStateSelectionProperty()
				.observe(chkControl);
		final IObservableValue<Boolean> checkModelObserveValue = BeanProperties.value("propertyValue").observe(modelProperty);

		strategy = new UpdateValueStrategy();
		strategy.setBeforeSetValidator(new RequiredValidator<>(modelProperty));
		final Binding binding = bindingContext.bindValue(observeCheckChkControlObserveWidget, checkModelObserveValue,
				strategy, strategy);
		ControlDecorationSupport.create(binding, SWT.LEFT | SWT.TOP);

		//
		final IObservableValue<Boolean> observeEnabledTxtControlObserveWidget = WidgetProperties.enabled()
				.observe(chkControl);
		final IObservableValue<Boolean> enabledModelObserveValue = BeanProperties.value("enabled").observe(modelProperty);
		bindingContext.bindValue(observeEnabledTxtControlObserveWidget, enabledModelObserveValue, null, null);
	}
}

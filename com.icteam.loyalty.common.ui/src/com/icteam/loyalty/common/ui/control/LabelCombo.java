package com.icteam.loyalty.common.ui.control;

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
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.osgi.framework.FrameworkUtil;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.ui.converter.LabelToModelConverter;
import com.icteam.loyalty.common.ui.converter.ModelToLabelConverter;
import com.icteam.loyalty.common.ui.converter.StringToLabelConverter;
import com.icteam.loyalty.common.ui.interfaces.IBindedControl;
import com.icteam.loyalty.common.ui.interfaces.IDTOControl;
import com.icteam.loyalty.common.ui.interfaces.ILabelControl;
import com.icteam.loyalty.common.ui.model.LabelComboModel;
import com.icteam.loyalty.common.ui.util.BinderUtils;
import com.icteam.loyalty.common.ui.validator.RequiredValidator;

public class LabelCombo<D extends IDTO, S extends Serializable> extends Composite
implements IBindedControl, ILabelControl, IDTOControl<D, S, LabelComboModel<D, S>> {
	private static final long serialVersionUID = 4106014725142032588L;

	public static final int NO_AUTO_SELECT = 1 << 17;

	private DataBindingContext bindingContext;
	private final Combo cmbControl;
	final Label labelControl;

	LabelComboModel<D, S> modelProperty;

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

		// if (parent.getLayout() instanceof GridLayout) {
		// setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
		// 1));
		// }

		selectFirst = !((style & NO_AUTO_SELECT) == NO_AUTO_SELECT);

		labelControl = new Label(this, SWT.NONE);
		labelControl.setText("New Label");

		cmbControl = new Combo(this, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		cmbControl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	}

	// public LabelCombo(Composite parent, int style) {
	// super(parent, SWT.NONE);
	// setLayout(new FormLayout());
	//
	// labelControl = new Label(this, SWT.NONE);
	// FormData fd_labelControl = new FormData();
	// fd_labelControl.top = new FormAttachment(0, 9);
	// fd_labelControl.left = new FormAttachment(0, 5);
	// labelControl.setLayoutData(fd_labelControl);
	// labelControl.setText("New Label");
	//
	// cmbControl = new Combo(this, SWT.READ_ONLY);
	// FormData fd_cmbControl = new FormData();
	// fd_cmbControl.right = new FormAttachment(100, -5);
	// fd_cmbControl.left = new FormAttachment(labelControl, 5);
	// fd_cmbControl.top = new FormAttachment(0, 5);
	// cmbControl.setLayoutData(fd_cmbControl);
	// }
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
	public void setModelProperty(D model, String property) {
		setModelProperty(model, property, null, false);
	}

	public void setModelProperty(D model, String property, List<S> customValues) {
		setModelProperty(model, property, customValues, false);
	}

	public void setModelProperty(D model, String property, List<S> customValues, boolean minus) {
		modelProperty = new LabelComboModel<>(model, property, customValues, minus);

		final IEclipseContext osgiContext = EclipseContextFactory
				.getServiceContext(FrameworkUtil.getBundle(getClass()).getBundleContext());

		ContextInjectionFactory.inject(modelProperty, osgiContext);

		manageRequired();

		initDataBindings();

		initCustomBindings();
	}

	private void manageRequired() {
		if (modelProperty.isRequired()) {
			labelControl.setData(RWT.CUSTOM_VARIANT, "required");
		}

		modelProperty.addPropertyChangeListener("required", evt -> {
			if (modelProperty.isRequired()) {
				labelControl.setData(RWT.CUSTOM_VARIANT, "required");
			} else {
				labelControl.setData(RWT.CUSTOM_VARIANT, null);
			}

			binding.validateTargetToModel();
		});
	}

	@Override
	public LabelComboModel<D, S> getModelProperty() {
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
		final IObservableValue<String> observeComboLblControlObserveWidget = WidgetProperties.text()
				.observe(labelControl);
		final IObservableValue<String> labelModelObserveValue = BeanProperties.value("label").observe(modelProperty);
		final UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setConverter(new StringToLabelConverter());
		bindingContext.bindValue(observeComboLblControlObserveWidget, labelModelObserveValue, null, strategy);
		//
		final IObservableList<S> itemsCmbControlObserveWidget = WidgetProperties.items().observe(cmbControl);
		final IObservableList<S> valuesModelObserveList = BeanProperties.list("values").observe(modelProperty);
		bindingContext.bindList(itemsCmbControlObserveWidget, valuesModelObserveList, null, null);

		final IObservableValue<S> observeComboCmbControlObserveWidget = WidgetProperties.selection()
				.observe(cmbControl);
		final IObservableValue<S> textModelObserveValue = BeanProperties.value("propertyValue").observe(modelProperty);
		final UpdateValueStrategy strategy2 = new UpdateValueStrategy();
		strategy2.setBeforeSetValidator(new RequiredValidator<>(modelProperty));

		strategy2.setConverter(new LabelToModelConverter(modelProperty.getValueMap()));

		final UpdateValueStrategy strategy3 = new UpdateValueStrategy();
		strategy3.setBeforeSetValidator(new RequiredValidator<>(modelProperty));
		strategy3.setConverter(new ModelToLabelConverter());

		binding = bindingContext.bindValue(observeComboCmbControlObserveWidget, textModelObserveValue, strategy2,
				strategy3);
		//
		final IObservableValue<Boolean> observeEnabledCmbControlObserveWidget = WidgetProperties.enabled()
				.observe(cmbControl);
		final IObservableValue<Boolean> enabledModelObserveValue = BeanProperties.value("enabled")
				.observe(modelProperty);
		final IObservableValue<Boolean> editableModelObserveValue = BeanProperties.value("editable")
				.observe(modelProperty);

		final IObservableValue<Boolean> observeEnableEditableValue = new ComputedValue<Boolean>() {
			@Override
			protected Boolean calculate() {
				return enabledModelObserveValue.getValue() && editableModelObserveValue.getValue();
			}
		};

		bindingContext.bindValue(observeEnabledCmbControlObserveWidget, observeEnableEditableValue, null, null);
	}
}

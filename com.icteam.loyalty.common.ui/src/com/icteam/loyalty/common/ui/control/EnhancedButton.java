package com.icteam.loyalty.common.ui.control;

import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.ui.interfaces.IBindedControl;
import com.icteam.loyalty.common.ui.model.EnhancedButtonModel;
import com.icteam.loyalty.common.ui.util.BinderUtils;

public class EnhancedButton<D extends IDTO> extends Button implements IBindedControl {
	private static final long serialVersionUID = 4106014725142032588L;

	EnhancedButtonModel<D> modelProperty;

	private DataBindingContext bindingContext;

	@Inject
	private EHandlerService handlerService;

	@Inject
	private ECommandService commandService;

	@Inject
	private IEclipseContext context;

	/**
	 * Create the composite.
	 *
	 * @param parent
	 * @param style
	 */
	public EnhancedButton(Composite parent, int style) {
		super(parent, style);

		addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetSelected(SelectionEvent se) {
				handlerService.executeHandler(
						new ParameterizedCommand(commandService.getCommand(modelProperty.getCommandId()), null));
			}
		});
	}

	public void setModel(D dtoModel, String action, String iconPath) {
		modelProperty = new EnhancedButtonModel<>(dtoModel, action, iconPath);

		ContextInjectionFactory.inject(modelProperty, context);

		initDataBindings();
	}

	public void setModel(D dtoModel, String commandId, String permissionAction, String iconPath) {
		modelProperty = new EnhancedButtonModel<>(dtoModel, commandId, permissionAction, iconPath);

		ContextInjectionFactory.inject(modelProperty, context);

		initDataBindings();
	}

	public EnhancedButtonModel<D> getModelProperty() {
		return modelProperty;
	}

	@Override
	public DataBindingContext getBindingContext() {
		return bindingContext;
	}

	@Override
	public void updateModelToTarget() {
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
		if (Realm.getDefault() == null) {
			return;
		}

		if (bindingContext != null) {
			bindingContext.dispose();
		}

		bindingContext = new DataBindingContext();

		//
		setImage(modelProperty.getImage());
		setToolTipText(modelProperty.getToolTipText());
		setText(modelProperty.getText());

		setEnabled(true);
		setVisible(modelProperty.isVisible());
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled && modelProperty.isEnabled());
	}

}

package com.icteam.loyalty.common.ui.editor;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.Persist;
import org.eclipse.e4.ui.model.application.ui.MDirtyable;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.progress.WorkbenchJob;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.nls.Messages;
import com.icteam.loyalty.common.ui.control.EnhancedButton;
import com.icteam.loyalty.common.ui.interfaces.IBindedControl;
import com.icteam.loyalty.common.ui.util.BinderUtils;
import com.icteam.loyalty.common.ui.util.ControlUtils;
import com.icteam.loyalty.common.util.Constants;

public abstract class AbstractEditor<D extends IDTO> implements IBindedControl {

	@Inject
	protected MPart part;

	@Inject
	private MDirtyable dirtyable;

	protected Composite parent;

	protected D dto;

	protected DataBindingContext bindingContext;

	private Composite defaultButtonArea;
	private Composite customButtonArea;
	private Composite editorArea;
	private EnhancedButton<D> cmdSave;
	private EnhancedButton<D> cmdCancel;

	@PostConstruct
	public final void createControl(Composite parent, @SuppressWarnings("rawtypes") @Named("dto") IDTO dto) {
		this.parent = parent;
		this.dto = (D) dto;

		this.parent = parent;
		parent.setLayout(new FormLayout());

		defaultButtonArea = new Composite(parent, SWT.NONE);
		FormData fd_buttonArea = new FormData();
		fd_buttonArea.bottom = new FormAttachment(100, 0);
		fd_buttonArea.right = new FormAttachment(100, 0);
		defaultButtonArea.setLayoutData(fd_buttonArea);
		defaultButtonArea.setLayout(new GridLayout(2, false));

		cmdSave = new EnhancedButton<>(defaultButtonArea, SWT.NONE);
		cmdCancel = new EnhancedButton<>(defaultButtonArea, SWT.NONE);

		customButtonArea = new Composite(parent, SWT.NONE);
		FormData fd_customButtonArea = new FormData();
		fd_customButtonArea.right = new FormAttachment(defaultButtonArea, -5);
		fd_customButtonArea.top = new FormAttachment(defaultButtonArea, 0, SWT.TOP);
		fd_customButtonArea.left = new FormAttachment(0);
		fd_customButtonArea.bottom = new FormAttachment(100, 0);
		customButtonArea.setLayoutData(fd_customButtonArea);

		fillCustomButtonArea(customButtonArea);

		editorArea = new Composite(parent, SWT.NONE);
		FormData fd_editorArea = new FormData();
		fd_editorArea.bottom = new FormAttachment(defaultButtonArea, -5);
		fd_editorArea.right = new FormAttachment(100);
		fd_editorArea.top = new FormAttachment(0, 5);
		fd_editorArea.left = new FormAttachment(0);
		editorArea.setLayoutData(fd_editorArea);
		editorArea.setLayout(new GridLayout(1, false));

		fillEditorArea(editorArea);

		initBinding();

		ControlUtils.adjustLayout(parent);
	}

	protected void initBinding() {
		if (bindingContext != null) {
			bindingContext.dispose();
		}

		if (Realm.getDefault() == null) {
			return;
		}

		bindingContext = new DataBindingContext();

		initCustomBindings();
		initDataBindings();
	}

	protected void fillCustomButtonArea(Composite customButtonArea) {
	}

	protected abstract void fillEditorArea(Composite ea);

	private void doSave(IProgressMonitor monitor) {
		BindingStatus bindingStatus = validate();

		if (!bindingStatus.isOK()) {
			if (monitor != null) {
				monitor.setCanceled(true);
			}

			ErrorDialog.openError(null, "", Messages.get().validationError, bindingStatus);

			updateModelToTarget();
		} else {
			D dtoSaved = internalSave();

			dtoSaved.copyTo(dto);

			part.setLabel(getDeafultPartLabel());
		}
	}

	protected abstract D internalSave();

	protected String getDeafultPartLabel() {
		return dto.getLabel();
	}

	@Override
	public BindingStatus validate() {
		return BinderUtils.validateControls(parent);
	}

	@Override
	public DataBindingContext getBindingContext() {
		return bindingContext;
	}

	@Override
	public void updateModelToTarget() {
		updateModelToTarget(parent);
	}

	public static void updateModelToTarget(Composite composite) {
		for (Control control : composite.getChildren()) {
			if (control instanceof IBindedControl) {
				((IBindedControl) control).updateModelToTarget();
			} else if (control instanceof Composite) {
				updateModelToTarget((Composite) control);
			}
		}
	}

	@Focus
	public void onFocus() {
		Control control = getFocusControl();
		if (control != null && !control.isDisposed()) {
			control.setFocus();
		}
	}

	protected abstract Control getFocusControl();

	protected void initCustomBindings() {
		dto.addPropertyChangeListener("dirty", evt -> dirtyable.setDirty(true));

		ContextInjectionFactory.inject(cmdSave, part.getContext());
		ContextInjectionFactory.inject(cmdCancel, part.getContext());

		cmdSave.setModel(dto, "save", Constants.EDIT, "save_edit.gif");
		cmdCancel.setModel(dto, "cancel", Constants.VIEW, "cancel.gif");
	}

	protected void initDataBindings() {
		if (Realm.getDefault() == null) {
			return;
		}

		//
		IObservableValue<Boolean> observeEnabledCmdSaveObserveWidget = WidgetProperties.enabled().observe(cmdSave);
		final IObservableValue<Boolean> dirtyOperatorEMFModelObserveValue = BeanProperties.value("dirty").observe(dto);
		final IObservableValue<Boolean> editableModelObserveValue = BeanProperties.value("editable").observe(dto);

		IObservableValue<Boolean> observeEnableEditableValue = new ComputedValue<Boolean>() {
			@Override
			protected Boolean calculate() {
				return editableModelObserveValue.getValue() && dirtyOperatorEMFModelObserveValue.getValue();
			}
		};

		bindingContext.bindValue(observeEnabledCmdSaveObserveWidget, observeEnableEditableValue, null, null);

		// IObservableValue nameGetEditorInputObserveValue =
		// PojoProperties.value("partName").observe(this);
		// IObservableValue kOperatorOperatorEMFModelObserveValue =
		// BeanProperties.value("kOperator").observe(modelDTO);
		// bindingContext.bindValue(nameGetEditorInputObserveValue,
		// kOperatorOperatorEMFModelObserveValue, null, null);
		//
	}

	@Persist
	public void save() {
		WorkbenchJob job = new WorkbenchJob(Messages.get().save) {
			@Override
			public IStatus runInUIThread(final IProgressMonitor monitor) {
				doSave(monitor);

				return monitor.isCanceled() ? Status.CANCEL_STATUS : Status.OK_STATUS;
			}
		};

		job.setUser(true);
		job.schedule();
	}

	public static void bindTableMenu(TableViewer tableViewer, IWorkbenchPartSite site) {
		Table table = tableViewer.getTable();

		MenuManager menuManager = new MenuManager();
		Menu menu = menuManager.createContextMenu(table);
		// Set the MenuManager
		table.setMenu(menu);
		site.registerContextMenu(menuManager, tableViewer);
		// make the selection available
		site.setSelectionProvider(tableViewer);
	}
}

package com.icteam.loyalty.ui.editor;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.progress.WorkbenchJob;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.api.interfaces.IConstants;
import com.icteam.loyalty.model.DtoModel;
import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.ui.control.EnhancedButton;
import com.icteam.loyalty.ui.interfaces.IBindedControl;
import com.icteam.loyalty.ui.interfaces.IDtoEditor;
import com.icteam.loyalty.ui.interfaces.IDtoEditorInput;
import com.icteam.loyalty.ui.model.DtoEditorInput;
import com.icteam.loyalty.ui.util.BinderUtils;
import com.icteam.loyalty.ui.util.ControlUtils;

public abstract class DefaultEditor<D extends IDtoModel> extends EditorPart implements IDtoEditor<D> {
    protected DataBindingContext bindingContext;

    private D dto;
    private Composite parent;
    private Composite defaultButtonArea;
    private Composite customButtonArea;
    private Composite editorArea;
    private EnhancedButton<D, String> cmdSave;
    private EnhancedButton<D, String> cmdCancel;

    public DefaultEditor() {
    }

    @Override
    public D getDtoModel() {
        if (dto == null) {
            dto = getEditorInput().getDto();
        }

        return dto;
    }

    @Override
    public IDtoEditorInput<D> getEditorInput() {
        try {
            return (IDtoEditorInput<D>) super.getEditorInput();
        } catch (ClassCastException e) {
            return createFooEditorInput();
        }
    }

    protected IDtoEditorInput<D> createFooEditorInput() {
        D foo = (D) new DtoModel();
        return new DtoEditorInput<>(foo);
    }

    /**
     * Create contents of the editor part.
     *
     * @param p
     */
    @Override
    public void createPartControl(final Composite p) {
        parent = p;
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

        ControlUtils.adjustLayout(p);
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

    @Override
    public void doSave(IProgressMonitor monitor) {
        BindingStatus bindingStatus = validate();

        if (!bindingStatus.isOK()) {
            if (monitor != null) {
                monitor.setCanceled(true);
            }

            ErrorDialog.openError(null, "", Messages.get().validation_error, bindingStatus);

            updateModelToTarget();
        } else {
            D dtoSaved = internalSave();

            dtoSaved.copyTo(dto);

            getEditorInput().setDto(dto);

            setPartName(getDeafultPartName());
        }
    }

    protected abstract D internalSave();

    @Override
    public void doSaveAs() {
        // Do the Save As operation
    }

    @Override
    public void init(IEditorSite site, IEditorInput input) {
        setInput(input);
        setSite(site);

        setPartName(getDeafultPartName());
    }

    protected String getDeafultPartName() {
        return getDtoModel().getDtoName();
    }

    @Override
    public boolean isDirty() {
        return dto.isDirty();
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

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public void setFocus() {
        Control control = getFocusControl();
        if (control != null && !control.isDisposed()) {
            control.setFocus();
        }
    }

    protected abstract Control getFocusControl();

    protected void initCustomBindings() {
        dto.addPropertyChangeListener("dirty", new PropertyChangeListener() {
            @SuppressWarnings("synthetic-access")
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                firePropertyChange(PROP_DIRTY);
            }
        });

        cmdSave.setModel(getDtoModel(), "save", IConstants.EDIT, "save_edit.gif");
        cmdCancel.setModel(getDtoModel(), "cancel", IConstants.VIEW, "cancel.gif");
    }

    protected void initDataBindings() {
        if (Realm.getDefault() == null) {
            return;
        }

        //
        IObservableValue observeEnabledCmdSaveObserveWidget = WidgetProperties.enabled().observe(cmdSave);
        final IObservableValue dirtyOperatorEMFModelObserveValue = BeanProperties.value("dirty").observe(dto);
        final IObservableValue editableModelObserveValue = BeanProperties.value("editable").observe(dto);

        IObservableValue observeEnableEditableValue = new ComputedValue() {
            @Override
            protected Object calculate() {
                return (Boolean) editableModelObserveValue.getValue() && (Boolean) dirtyOperatorEMFModelObserveValue.getValue();
            }
        };

        bindingContext.bindValue(observeEnabledCmdSaveObserveWidget, observeEnableEditableValue, null, null);

        // IObservableValue nameGetEditorInputObserveValue = PojoProperties.value("partName").observe(this);
        // IObservableValue kOperatorOperatorEMFModelObserveValue = BeanProperties.value("kOperator").observe(dto);
        // bindingContext.bindValue(nameGetEditorInputObserveValue, kOperatorOperatorEMFModelObserveValue, null, null);
        //
    }

    @Override
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

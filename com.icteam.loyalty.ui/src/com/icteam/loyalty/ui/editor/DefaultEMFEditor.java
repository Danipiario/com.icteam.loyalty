package com.icteam.loyalty.ui.editor;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecp.view.spi.horizontal.model.VHorizontalFactory;
import org.eclipse.emf.ecp.view.spi.horizontal.model.VHorizontalLayout;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;
import org.eclipse.jface.action.MenuManager;
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
import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.ModelPackage;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.ui.control.SWTRenderUtil;
import com.icteam.loyalty.ui.dialog.MultiLineDiagnosticDialog;
import com.icteam.loyalty.ui.interfaces.IBindedControl;
import com.icteam.loyalty.ui.interfaces.IDefaultEMFEditor;
import com.icteam.loyalty.ui.model.DefaultEditorEMFModel;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.util.BinderUtils;
import com.icteam.loyalty.ui.util.UIUtils;

public abstract class DefaultEMFEditor<D extends EMFModel, M extends DefaultEditorEMFModel<D>> extends EditorPart implements IDefaultEMFEditor<M> {

    protected DataBindingContext bindingContext;

    private Composite parent;
    private Composite defaultButtonArea;
    private Composite customButtonArea;
    private Composite editorArea;

    public DefaultEMFEditor() {
    }

    public D getModel() {
        return getEditorInput().getModel();
    }

    @Override
    public M getEditorInput() {
        try {
            return (M) super.getEditorInput();
        } catch (ClassCastException e) {
            return null;//createFooEditorInput();
        }
    }

//    protected IDtoEMFEditorInput<D> createFooEditorInput() {
//        D foo = (D) new DtoModel();
//        return new DtoEditorInput<>(foo);
//    }

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

        SWTRenderUtil.render(getEditorSite(), defaultButtonArea, getEditorInput(), getDefaultButtonAreaView());

        FormData fd_buttonArea = new FormData();
        fd_buttonArea.bottom = new FormAttachment(100, 0);
        fd_buttonArea.right = new FormAttachment(100, 0);
        defaultButtonArea.setLayoutData(fd_buttonArea);
        defaultButtonArea.setLayout(new GridLayout(2, false));

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
//
//        ControlUtils.adjustLayout(p);
    }

    protected VView getDefaultButtonAreaView() {
        VView view = VViewFactory.eINSTANCE.createView();
        VHorizontalLayout horizontalLayout = VHorizontalFactory.eINSTANCE.createHorizontalLayout();
        view.getChildren().add(horizontalLayout);

        VControl control = VViewFactory.eINSTANCE.createControl();

        control.setDomainModelReference(UIModelPackage.Literals.DEFAULT_EDITOR_EMF_MODEL__SAVE_ACTION);
        horizontalLayout.getChildren().add(control);

        control = VViewFactory.eINSTANCE.createControl();

        control.setDomainModelReference(UIModelPackage.Literals.DEFAULT_EDITOR_EMF_MODEL__CANCEL_ACTION);
        horizontalLayout.getChildren().add(control);

        return view;
    }

    protected void initBinding() {
        if (Realm.getDefault() == null) {
            return;
        }

        if (bindingContext != null) {
            bindingContext.dispose();
        }

        bindingContext = new DataBindingContext();

        initDataBindings();
        initCustomBindings();
    }

    protected void fillCustomButtonArea(Composite customButtonArea) {
    }

    protected Control getFocusControl() {
        return editorArea;
    }

    protected abstract void fillEditorArea(Composite ea);

    @Override
    public void doSave(IProgressMonitor monitor) {
        final Diagnostic diagnostic = UIUtils.validate(getEditorInput());

        if (diagnostic.getSeverity() != Diagnostic.OK) {
            if (monitor != null) {
                monitor.setCanceled(true);
            }

            MultiLineDiagnosticDialog.openProblem(null, "", Messages.get().validation_error, diagnostic);

            updateModelToTarget();
        } else {
            D dtoSaved = internalSave();

            dtoSaved.copyTo(getModel(), true);

            getEditorInput().setModel(getModel());

//            initBinding();
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
    }

    protected String getDeafultPartName() {
        return getModel().getModelName();
    }

    @Override
    public boolean isDirty() {
        return getModel().isDirty() && getEditorInput().isEditable();
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

    protected void initCustomBindings() {
    }

    protected void initDataBindings() {
        if (Realm.getDefault() == null) {
            return;
        }

        setPartName(getDeafultPartName() + getReadOnlyMarker());

        getModel().eAdapters().add(new EContentAdapter() {
            @SuppressWarnings("synthetic-access")
            @Override
            public void notifyChanged(Notification notification) {
                if (!notification.isTouch() && notification.getFeatureID(EClassifier.class) == ModelPackage.EMF_MODEL__DIRTY) {
                    firePropertyChange(PROP_DIRTY);
                }
            }
        });

        firePropertyChange(PROP_DIRTY);

        //
        IObservableValue observeEnabledSaveActionObserveWidget = EMFObservables.observeValue(getEditorInput().getSaveAction(), ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);
        final IObservableValue dirtyOperatorEMFModelObserveValue = EMFObservables.observeValue(getModel(), ModelInterfacesPackage.Literals.IEDITABLE__DIRTY);
        final IObservableValue editableModelObserveValue = EMFObservables.observeValue(getModel(), ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);

        IObservableValue observeEnableEditableValue = new ComputedValue() {
            @Override
            protected Object calculate() {
                return (Boolean) editableModelObserveValue.getValue() && (Boolean) dirtyOperatorEMFModelObserveValue.getValue();
            }
        };

        bindingContext.bindValue(observeEnabledSaveActionObserveWidget, observeEnableEditableValue, null, null);
    }

    private String getReadOnlyMarker() {
        if (!getEditorInput().isEditable()) {
            return " " + Messages.get().readonly_marker;
        }

        return "";
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

package com.icteam.loyalty.ui.control;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;

import com.icteam.loyalty.api.AppException;
import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.interfaces.EStatusReason;
import com.icteam.loyalty.ui.interfaces.IBindedControl;
import com.icteam.loyalty.ui.model.EnhancedButtonEMFModel;
import com.icteam.loyalty.ui.util.BinderUtils;

public class EnhancedEMFButton<M extends EMFModel, S extends String> extends Button implements IBindedControl {
    private static final long serialVersionUID = 4106014725142032588L;

    EnhancedButtonEMFModel<M, S> modelProperty;

    private DataBindingContext bindingContext;

    /**
     * Create the composite.
     *
     * @param parent
     * @param style
     */
    public EnhancedEMFButton(Composite parent, int style) {
        super(parent, style);

        addSelectionListener(new SelectionAdapter() {
            private static final long serialVersionUID = 1L;

            @Override
            public void widgetSelected(SelectionEvent se) {
                IHandlerService handlerService = (IHandlerService) PlatformUI.getWorkbench().getService(IHandlerService.class);
                try {
                    handlerService.executeCommand(modelProperty.getCommandId(), null);
                } catch (ExecutionException | NotDefinedException | NotEnabledException | NotHandledException e) {
                    throw new AppException(EStatusReason.ERROR, e);
                }
            }
        });
    }

    public void setModel(M dtoModel, String action, String iconPath) {
        modelProperty = new EnhancedButtonEMFModel<>(dtoModel, action, iconPath);

        initDataBindings();
    }

    public void setModel(M dtoModel, String commandId, String permissionAction, String iconPath) {
        modelProperty = new EnhancedButtonEMFModel<>(dtoModel, commandId, permissionAction, iconPath);

        initDataBindings();
    }

    public EnhancedButtonEMFModel<M, S> getModelProperty() {
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

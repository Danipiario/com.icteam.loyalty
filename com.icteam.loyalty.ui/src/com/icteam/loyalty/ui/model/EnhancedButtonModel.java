package com.icteam.loyalty.ui.model;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.internal.expressions.ReferenceExpression;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.wb.swt.ResourceManager;

import com.icteam.loyalty.model.interfaces.IDtoModel;

public class EnhancedButtonModel<M extends IDtoModel, S extends Object> {

    private ImageDescriptor image;
    private final String iconPath;

    private static final String PREFIX_ICON_PATH = "/icons/";
    private final M model;
    private final String commandId;
    private boolean enabled;
    private final String permission;
    private Command command;

    public EnhancedButtonModel(M model, String action, String iconPath) {
        this(model, model.getPermissionObject() + "_" + action, action, iconPath);
    }

    public EnhancedButtonModel(M model, String commandId, String permissionAction, String iconPath) {
        this.model = model;
        this.commandId = commandId;
        this.permission = model.getPermissionObject() + "_" + permissionAction;
        this.iconPath = PREFIX_ICON_PATH + iconPath;

        initialize();
    }

    private void initialize() {
        setEnabled(getModel().isEditable());

        ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
        command = commandService.getCommand(commandId);
    }

    public M getModel() {
        return model;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getToolTipText() {
        try {
            return command.getDescription();
        } catch (NotDefinedException e) {
            e.printStackTrace();
        }

        return "";
    }

    public String getText() {
        try {
            return command.getName();
        } catch (NotDefinedException e) {
            e.printStackTrace();
        }

        return "";
    }

    public Image getImage() {
        Image img = null;

        if (image == null) {
            this.image = ResourceManager.getImageDescriptor(getModel().getClass(), iconPath);

            img = image.createImage(false);

            if (img == null) {
                this.image = ResourceManager.getImageDescriptor(getClass(), iconPath);

                img = image.createImage();
            }
        } else {
            img = image.createImage();
        }

        return img;
    }

    public String getCommandId() {
        return commandId;
    }

    public boolean isVisible() {
        IEvaluationService es = (IEvaluationService) PlatformUI.getWorkbench().getService(IEvaluationService.class);
        IEvaluationContext currentState = es.getCurrentState();

        ReferenceExpression referenceExpression = new ReferenceExpression(permission);
        EvaluationResult result;
        try {
            result = referenceExpression.evaluate(currentState);
            return EvaluationResult.TRUE.equals(result);
        } catch (CoreException e) {
            e.printStackTrace();
        }

        return false;
    }

}

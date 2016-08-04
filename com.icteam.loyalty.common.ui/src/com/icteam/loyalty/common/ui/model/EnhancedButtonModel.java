package com.icteam.loyalty.common.ui.model;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.swt.graphics.Image;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.ui.service.IconService;

public class EnhancedButtonModel<D extends IDTO> {

	private Image image;
	private final String iconPath;

	private static final String PREFIX_ICON_PATH = "/icons/";
	private final D model;
	private final String commandId;
	private boolean enabled;
	private final String permission;
	private Command command;

	@Inject
	private IconService iconService;

	@Inject
	private ECommandService commandService;

	public EnhancedButtonModel(D model, String action, String iconPath) {
		this(model, model.getPermissionObject() + "_" + action, action, iconPath);
	}

	public EnhancedButtonModel(D model, String commandId, String permissionAction, String iconPath) {
		this.model = model;
		this.commandId = commandId;
		this.permission = model.getPermissionObject() + "_" + permissionAction;
		this.iconPath = PREFIX_ICON_PATH + iconPath;
	}

	@PostConstruct
	void initialize() {
		setEnabled(getModel().isEditable());

		command = commandService.getCommand(commandId);
	}

	public D getModel() {
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
		} catch (final NotDefinedException e) {
			e.printStackTrace();
		}

		return "";
	}

	public String getText() {
		try {
			return command.getName();
		} catch (final NotDefinedException e) {
			e.printStackTrace();
		}

		return "";
	}

	public Image getImage() {
		if (image == null) {
			this.image = iconService.getIcon(iconPath);
		}

		return image;
	}

	public String getCommandId() {
		return commandId;
	}

	public boolean isVisible() {
		// IEvaluationService evaluationService =
		// PlatformUI.getWorkbench().getService(IEvaluationService.class);
		//
		// IEvaluationContext currentState =
		// evaluationService.getCurrentState();
		//
		// ReferenceExpression referenceExpression = new
		// ReferenceExpression(permission);
		// EvaluationResult result;
		// try {
		// result = referenceExpression.evaluate(currentState);
		// return EvaluationResult.TRUE.equals(result);
		// } catch (CoreException e) {
		// e.printStackTrace();
		// }

		return true;
	}

}

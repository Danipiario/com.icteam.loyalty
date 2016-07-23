package com.icteam.loyalty.ui.handler;

import org.eclipse.core.commands.Category;
import org.eclipse.core.commands.Command;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.internal.expressions.ReferenceExpression;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.menus.AbstractContributionFactory;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.menus.IMenuService;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.wb.swt.ResourceManager;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.api.interfaces.IConstants;
import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.provider.LoyaltyItemProviderAdapter;

public class DefaultContributionFactory extends AbstractContributionFactory {

    public enum CommandType {
        toolbar, popup;
    }

    private String iconPath;
    private String commandId;
    private boolean separator = false;
    private String separatorName;

    public DefaultContributionFactory(String location, String namespace) {
        super(location, namespace);
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getIconPath() {
        return "/icons/" + iconPath;
    }

    public String getCommandId() {
        return commandId;
    }

    private void setSeparator(boolean separator) {
        this.separator = separator;
    }

    public void setSeparatorName(String separatorName) {
        this.separatorName = separatorName;
    }

    public static void addToolbarSeparator(String partId, String separatorName) {
        String location = CommandType.toolbar + ":" + partId;

        DefaultContributionFactory contributionFactory = new DefaultContributionFactory(location, null);
        contributionFactory.setSeparator(true);
        contributionFactory.setSeparatorName(separatorName);

        addContributionFactory(contributionFactory);
    }

    public static void addToolbarContribution(String partId, String commandId, String iconPath) {
        String location = CommandType.toolbar + ":" + partId;

        addContribution(location, commandId, iconPath);
    }

    public static void addContribution(String location, String commandId, String iconPath) {
        DefaultContributionFactory contributionFactory = new DefaultContributionFactory(location, null);

        if (commandId != null) {
            contributionFactory.setCommandId(commandId);
            contributionFactory.setIconPath(iconPath);

            addContributionFactory(contributionFactory);
        }
    }

    private static void addContributionFactory(DefaultContributionFactory contributionFactory) {
        IMenuService menuService = (IMenuService) PlatformUI.getWorkbench().getService(IMenuService.class);
        menuService.removeContributionFactory(contributionFactory);
        menuService.addContributionFactory(contributionFactory);
    }

    public static void addToolbar(String partId, EObject eObject, EStructuralFeature feature) {
        addToolbar(partId, (Action) eObject.eGet(feature), eObject, feature);
    }

    public static void addToolbar(String partId, Action action, EObject eObject, EStructuralFeature feature) {
        addCommand(partId, action, eObject, feature, CommandType.toolbar);
    }

    public static void addPopup(String partId, EObject eObject, EStructuralFeature feature) {
        addPopup(partId, (Action) eObject.eGet(feature), eObject, feature);
    }

    public static void addPopup(String partId, Action action, EObject eObject, EStructuralFeature feature) {
        addCommand(partId, action, eObject, feature, CommandType.popup);
    }

    public static void addCommand(String partId, Action action, EObject eObject, EStructuralFeature feature, CommandType commandType) {
        if (action.isAllowed(eObject, feature)) {
            String location = commandType.name() + ":" + partId;
            String commandId = action.getCommandId(eObject);

            ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
            Category defCategory = commandService.getCategory(null);
            Command command = commandService.getCommand(commandId);

            if (!command.isDefined()) {
                String text = LoyaltyItemProviderAdapter.getDiplayName(eObject, feature);
                command.define(text, text, defCategory);
            }

            addContribution(location, commandId, action.getIconPath());
        }
    }

    public static void addToolbar(String partId, String commandId, String iconPath) {
        if (checkActivity(commandId)) {
            String location = "toolbar:" + partId;
            String commandIdTooltip = commandId + IConstants.UNDERSCORE + IConstants.TOOLTIP;

            ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
            Category defCategory = commandService.getCategory(null);
            Command addCommand = commandService.getCommand(commandId);

            if (!addCommand.isDefined()) {
                addCommand.define(Messages.get(commandId), Messages.get(commandIdTooltip), defCategory);
            }

            addContribution(location, commandId, iconPath);
        }
    }

    public static void addPopup(String partId, String commandId, String iconPath) {
        if (checkActivity(commandId)) {
            String location = "popup:" + partId;

            ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
            Category defCategory = commandService.getCategory(null);
            Command addCommand = commandService.getCommand(commandId);

            if (!addCommand.isDefined()) {
                addCommand.define(Messages.get(commandId), null, defCategory);
            }

            addContribution(location, commandId, iconPath);
        }
    }

    public static boolean checkActivity(String commandId) {
        IEvaluationService es = (IEvaluationService) PlatformUI.getWorkbench().getService(IEvaluationService.class);
        IEvaluationContext currentState = es.getCurrentState();

        ReferenceExpression referenceExpression = new ReferenceExpression(commandId);
        try {
            EvaluationResult result;
            result = referenceExpression.evaluate(currentState);
            return EvaluationResult.TRUE.equals(result);
        } catch (CoreException e) {
            return false;
        }
    }

    @Override
    public final void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
        IContributionItem item = buildContributionItem(serviceLocator);
        item.setVisible(true);

        additions.addContributionItem(item, null);
    }

    public IContributionItem buildContributionItem(IServiceLocator serviceLocator) {
        if (separator) {
            return new Separator(separatorName);
        }

        CommandContributionItemParameter p = new CommandContributionItemParameter(serviceLocator, "", commandId, CommandContributionItem.STYLE_PUSH);
        p.icon = ResourceManager.getImageDescriptor(DefaultContributionFactory.class, getIconPath());

        return new CommandContributionItem(p);

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (getLocation() == null ? 0 : getLocation().hashCode());
        result = prime * result + (commandId == null ? 0 : commandId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DefaultContributionFactory other = (DefaultContributionFactory) obj;
        if (getLocation() == null) {
            if (other.getLocation() != null) {
                return false;
            }
        } else if (!getLocation().equals(other.getLocation())) {
            return false;
        }
        if (commandId == null) {
            if (other.commandId != null) {
                return false;
            }
        } else if (!commandId.equals(other.commandId)) {
            return false;
        }
        return true;
    }

//    public static Button createCommand(Composite comp, String commandId, String label, String iconPath) {
//        return createCommand(comp, commandId, label, DefaultContributionFactory.class, iconPath);
//    }
//
//    public static Button createCommand(Composite comp, String commandId, String label, Class< ? > iconClassRef, String iconPath) {
//        ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
//        Command command = commandService.getCommand(commandId);
//
//        CommandContributionItemParameter p = new CommandContributionItemParameter(PlatformUI.getWorkbench(), "", command.getId(),
//                CommandContributionItem.STYLE_PUSH);
//        p.icon = ResourceManager.getImageDescriptor(iconClassRef, iconPath);
//        p.label = label;
//        WidgetCommandContributionItem item = new WidgetCommandContributionItem(p);
//        item.setVisible(true);
//        item.fill(comp);
//
//        return item.getButton();
//    }

}

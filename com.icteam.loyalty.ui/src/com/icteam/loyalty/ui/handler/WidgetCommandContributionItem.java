package com.icteam.loyalty.ui.handler;

import java.lang.reflect.Field;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

public class WidgetCommandContributionItem extends CommandContributionItem {

    private static final long serialVersionUID = 7395522587849649174L;

    public WidgetCommandContributionItem(CommandContributionItemParameter contributionParameters) {
        super(contributionParameters);
    }

    @Override
    public void fill(Composite parent) {
        super.fill(parent);

        Button btn = getButton();

        if (btn != null) {
            try {
                ImageDescriptor imgDescr = getData().icon;
                if (imgDescr != null) {
                    btn.setImage(imgDescr.createImage());
                }

                btn.setToolTipText(getCommand().getCommand().getDescription());
            } catch (Exception e) {
                // no log
            }
        }
    }

    public Button getButton() {
        Widget w = getWidget();

        if (getWidget() instanceof Button) {
            return (Button) w;
        }

        return null;
    }

    public Widget getWidget() {
        try {
            Field widgetField = CommandContributionItem.class.getDeclaredField("widget");

            widgetField.setAccessible(true);

            return (Widget) widgetField.get(this);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}

package com.icteam.loyalty.ui.internal;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Configures the perspective layout. This class is contributed through the
 * plugin.xml.
 */
public class AdministrationPerspective implements IPerspectiveFactory {

    public static final String ID = "administration_perspective";

    @Override
    public void createInitialLayout(IPageLayout layout) {
        layout.setEditorAreaVisible(true);

        layout.createPlaceholderFolder("leftView", IPageLayout.LEFT, 0.3f, layout.getEditorArea());
    }

}

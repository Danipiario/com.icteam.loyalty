package com.icteam.loyalty.ui.internal;

import java.net.URL;
import java.util.Enumeration;

import org.eclipse.wb.swt.SWTResourceManager;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

public class IconTracker extends BundleTracker<Bundle> {

    public IconTracker(BundleContext context) {
        super(context, Bundle.ACTIVE, null);
    }

    @Override
    public Bundle addingBundle(Bundle bundle, BundleEvent event) {
        if (hasIcons(bundle)) {
            addIcons(bundle);
        }

        return super.addingBundle(bundle, event);
    }

    private static void addIcons(final Bundle bundle) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Enumeration<URL> icons = bundle.findEntries("icons", "*.gif", true);

                if (icons != null) {
                    while (icons.hasMoreElements()) {
                        URL iconURL = icons.nextElement();
                        SWTResourceManager.addImagePath(iconURL.getPath());
                    }
                }
            }
        }).start();
    }

    private static boolean hasIcons(Bundle bundle) {
        return bundle.getEntry("icons") != null;
    }
}

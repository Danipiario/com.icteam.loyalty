package com.icteam.loyalty.api.internal;

import org.apache.commons.lang.StringUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

import com.icteam.loyalty.api.interfaces.EnhancedEnum;

public class EnhancedEnumExtensionTracker extends BundleTracker<Bundle> {

    public EnhancedEnumExtensionTracker(BundleContext context) {
        super(context, Bundle.UNINSTALLED | Bundle.ACTIVE, null);
    }

    @Override
    public Bundle addingBundle(Bundle bundle, BundleEvent event) {
        String extension = bundle.getHeaders().get("EnhancedEnum-Extension");

        if (extension != null) {
            addEnhancedEnumExtension(bundle, extension);
        }

        return super.addingBundle(bundle, event);
    }

    private static void addEnhancedEnumExtension(final Bundle bundle, final String extension) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] enhancedEnumClasses = StringUtils.stripAll(StringUtils.split(extension, ","));

                for (String enhancedEnumClass : enhancedEnumClasses) {
                    try {
                        EnhancedEnum.initLazyEnums(bundle.loadClass(enhancedEnumClass));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

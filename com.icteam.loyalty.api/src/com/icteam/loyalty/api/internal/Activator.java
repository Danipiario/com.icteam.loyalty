package com.icteam.loyalty.api.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.icteam.loyalty.api.ConfigurationExtensionTracker;

public class Activator implements BundleActivator {

    EnhancedEnumExtensionTracker enhancedEnumExtensionTracker;
    ConfigurationExtensionTracker configurationExtensionTracker;

    @Override
    public void start(BundleContext context) throws Exception {
//        this.enhancedEnumExtensionTracker = new EnhancedEnumExtensionTracker(context);
        this.configurationExtensionTracker = new ConfigurationExtensionTracker(context);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//        this.enhancedEnumExtensionTracker.open();
        this.configurationExtensionTracker.open();
//            }
//        }).start();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
//        this.enhancedEnumExtensionTracker.close();
        this.configurationExtensionTracker.close();
    }

}

package com.icteam.loyalty.common.tracker;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    private AutomaticExtensionTracker automaticExtensionTracker;

    @Override
    public void start(BundleContext context) throws Exception {
        this.automaticExtensionTracker = new AutomaticExtensionTracker(context);
        this.automaticExtensionTracker.open();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        this.automaticExtensionTracker.close();
    }

}

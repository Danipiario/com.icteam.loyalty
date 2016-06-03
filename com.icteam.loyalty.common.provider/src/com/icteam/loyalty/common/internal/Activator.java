package com.icteam.loyalty.common.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.icteam.loyalty.common.provider.EnumTracker;

public class Activator implements BundleActivator {

    EnumTracker enumTracker;

    @Override
    public void start(BundleContext context) throws Exception {
        this.enumTracker = new EnumTracker(context);

        this.enumTracker.open();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        this.enumTracker.close();
    }

}

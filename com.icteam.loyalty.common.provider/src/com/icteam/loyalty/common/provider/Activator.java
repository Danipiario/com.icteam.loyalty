package com.icteam.loyalty.common.provider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.icteam.loyalty.common.provider.tracker.AutomaticExtensionTracker;

public class Activator implements BundleActivator {

	AutomaticExtensionTracker automaticExtensionTracker;

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

package com.icteam.loyalty.common.provider.tracker;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.common.api.EnumService;

public class AutomaticExtensionTracker extends BundleTracker<Bundle> {

	EnumService enumService;

	private final ServiceTracker<EnumService, EnumService> serviceTracker;

	private final Map<String, List<BundleTracker<?>>> bundleTrackers = new HashMap<>();

	public AutomaticExtensionTracker(BundleContext context) {
		super(context, Bundle.UNINSTALLED | Bundle.ACTIVE, null);

		serviceTracker = new ServiceTracker<>(context, EnumService.class, null);
		serviceTracker.open();
	}

	@Override
	public Bundle addingBundle(Bundle bundle, BundleEvent event) {
		final String extension = bundle.getHeaders().get("Tracker-Extension");

		if (extension != null) {
			addTrackerExtension(bundle, extension);
		}

		return super.addingBundle(bundle, event);
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event, Bundle object) {
		removeTrackers(bundle);

		super.removedBundle(bundle, event, object);
	}

	private void removeTrackers(Bundle bundle) {
		final List<BundleTracker<?>> trackers = bundleTrackers.remove(bundle.getSymbolicName());

		if (trackers != null) {
			for (final BundleTracker<?> tracker : trackers) {
				tracker.close();
			}
		}
	}

	@Override
	public void close() {
		super.close();

		serviceTracker.close();
	}

	private void addTrackerExtension(final Bundle bundle, final String extension) {
		new Thread(() -> {
			final String[] trackerClasses = StringUtils.stripAll(StringUtils.split(extension, ","));

			final List<BundleTracker<?>> trackers = new ArrayList<>();

			for (final String trackerClassName : trackerClasses) {
				try {
					final Class<? extends BundleTracker<?>> trackerClass = (Class<? extends BundleTracker<?>>) bundle
							.loadClass(trackerClassName);

					final Constructor<? extends BundleTracker<?>> constructor = trackerClass
							.getConstructor(BundleContext.class);

					final BundleTracker<?> tracker = constructor.newInstance(bundle.getBundleContext());

					trackers.add(tracker);
					tracker.open();
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
						| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}

			bundleTrackers.put(bundle.getSymbolicName(), trackers);
		}).start();
	}
}

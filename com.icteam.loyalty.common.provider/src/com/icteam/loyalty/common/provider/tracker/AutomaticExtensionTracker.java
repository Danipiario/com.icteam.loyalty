package com.icteam.loyalty.common.provider.tracker;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

public class AutomaticExtensionTracker extends BundleTracker<Bundle> {

    private static final String TRACKER_EXTENSION = "Tracker-Extension";

    private final Map<String, List<BundleTracker< ? >>> bundleTrackers = new HashMap<>();

    private final Logger logger = Log.getLogger(AutomaticExtensionTracker.class);

    public AutomaticExtensionTracker(BundleContext context) {
        super(context, Bundle.UNINSTALLED | Bundle.ACTIVE, null);
    }

    @Override
    public Bundle addingBundle(Bundle bundle, BundleEvent event) {
        final String extension = bundle.getHeaders().get(TRACKER_EXTENSION);

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

    private void removeAllTrackers() {
        logger.info("untrack all trackers extension");

        synchronized (bundleTrackers) {
            for (List<BundleTracker< ? >> trackers : bundleTrackers.values()) {
                close(trackers);
            }
        }
    }

    private static void close(List<BundleTracker< ? >> trackers) {
        for (final BundleTracker< ? > tracker : trackers) {
            tracker.close();
        }
    }

    private void removeTrackers(Bundle bundle) {
        final List<BundleTracker< ? >> trackers;

        synchronized (bundleTrackers) {
            trackers = bundleTrackers.remove(bundle.getSymbolicName());
        }

        if (trackers != null) {
            logger.info("bundle #{} - remove trackers", bundle.getSymbolicName());

            for (final BundleTracker< ? > tracker : trackers) {
                tracker.close();
            }
        }
    }

    @Override
    public void close() {
        super.close();

        removeAllTrackers();
    }

    private void addTrackerExtension(final Bundle bundle, final String extension) {
        new Thread(() -> {
            logger.info("bundle #{} - track extension #{}", bundle.getSymbolicName(), extension);

            final String[] trackerClasses = StringUtils.stripAll(StringUtils.split(extension, ","));

            final List<BundleTracker< ? >> trackers = new ArrayList<>();

            for (final String trackerClassName : trackerClasses) {
                try {
                    final Class< ? extends BundleTracker< ? >> trackerClass = (Class< ? extends BundleTracker< ? >>) bundle
                            .loadClass(trackerClassName);

                    final Constructor< ? extends BundleTracker< ? >> constructor = trackerClass.getConstructor(BundleContext.class);

                    final BundleTracker< ? > tracker = constructor.newInstance(bundle.getBundleContext());

                    trackers.add(tracker);
                    tracker.open();
                } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                        | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            synchronized (bundleTrackers) {
                bundleTrackers.put(bundle.getSymbolicName(), trackers);
            }
        }).start();
    }
}

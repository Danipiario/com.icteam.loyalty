package com.icteam.loyalty.common.ui.internal.tracker;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.common.ui.service.IconService;

public class IconTracker extends BundleTracker<Bundle> {

	private static final String ICONS = "OSGI-INF/icons";

	private static final String GIF_SUFFIX = "gif";

	private static final String PNG_SUFFIX = "png";

	private final Logger logger = Log.getLogger(IconTracker.class);

	private final ServiceTracker<IconService, IconService> serviceTracker;

	public IconTracker(BundleContext context) {
		super(context, Bundle.UNINSTALLED | Bundle.ACTIVE, null);

		serviceTracker = new ServiceTracker<>(context, IconService.class, null);
		serviceTracker.open();
	}

	@Override
	public Bundle addingBundle(Bundle bundle, BundleEvent event) {
		if (hasIcons(bundle)) {
			loadIcons(bundle);
		}

		return super.addingBundle(bundle, event);
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event, Bundle object) {
		if (hasIcons(bundle)) {
			removeIcons(bundle);
		}

		super.removedBundle(bundle, event, object);
	}

	private void removeIcons(final Bundle bundle) {
		new Thread(() -> {
			final Enumeration<URL> icons = bundle.findEntries(ICONS, "*", true);

			try {
				if (icons != null) {
					while (icons.hasMoreElements()) {
						final URL iconURL = icons.nextElement();

						final String iconFile = iconURL.getFile();

						if (iconFile.endsWith(GIF_SUFFIX) || iconFile.endsWith(PNG_SUFFIX)) {
							final String iconFileName = iconFile.substring(iconFile.lastIndexOf('/') + 1);

							final IconService iconService = serviceTracker.waitForService(1000);

							if (iconService != null) {
								iconService.removeIcon(iconFileName);

								logger.info("bundle #{} - remove icon file #{}", bundle.getSymbolicName(),
										iconFileName);
							}
						}
					}
				}
			} catch (final InterruptedException e) {
				logger.warn("error remove icon files for bundle #" + bundle.getSymbolicName(), e);
			}
		}).start();
	}

	private void loadIcons(final Bundle bundle) {
		new Thread(() -> {
			final Enumeration<URL> icons = bundle.findEntries(ICONS, "*", true);

			try {
				if (icons != null) {
					while (icons.hasMoreElements()) {
						final URL iconURL = icons.nextElement();
						final File iconFile = new File(FileLocator.toFileURL(iconURL).toURI());
						final String iconFileName = iconFile.getName();

						if (iconFileName.endsWith(GIF_SUFFIX) || iconFileName.endsWith(PNG_SUFFIX)) {
							final IconService iconService = serviceTracker.waitForService(10000);

							if (iconService != null) {
								iconService.addIcon(iconFile);

								logger.info("bundle #{} - manage icon file #{}", bundle.getSymbolicName(),
										iconFileName);
							}
						}
					}
				}
			} catch (URISyntaxException | IOException | InterruptedException e) {
				logger.warn("error manage icon files for bundle #" + bundle.getSymbolicName(), e);
			}
		}).start();
	}

	private static boolean hasIcons(Bundle bundle) {
		return bundle.getEntry(ICONS) != null;
	}
}

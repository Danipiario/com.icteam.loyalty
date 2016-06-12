package com.icteam.loyalty.common.provider.tracker;

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
import org.osgi.framework.Constants;
import org.osgi.util.tracker.BundleTracker;

public class MessagesTracker extends BundleTracker<Bundle> {

	private static final String LOCALIZATION_EXTENSION = "Localization-Extension";

	private final Logger logger = Log.getLogger(MessagesTracker.class);

	public MessagesTracker(BundleContext context) {
		super(context, Bundle.UNINSTALLED | Bundle.ACTIVE, null);
	}

	@Override
	public Bundle addingBundle(Bundle bundle, BundleEvent event) {
		//		if (hasLocalization(bundle)) {
		//			loadLocalization(bundle);
		//		}

		return super.addingBundle(bundle, event);
	}

	private boolean hasLocalization(Bundle bundle) {
		return bundle.getEntry(LOCALIZATION_EXTENSION)!=null;
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event, Bundle object) {
		//		if (hasLocalization(bundle)) {
		//			removeConfigurations(bundle);
		//		}

		super.removedBundle(bundle, event, object);
	}

	private void removeConfigurations(final Bundle bundle) {
		new Thread(() -> {
			final Enumeration<URL> configurations = bundle.findEntries(Constants.BUNDLE_LOCALIZATION_DEFAULT_BASENAME, "*.properties", true);

			try {
				if (configurations != null) {
					while (configurations.hasMoreElements()) {
						final URL newConfigURL = configurations.nextElement();
						final File newConfigFile = new File(FileLocator.toFileURL(newConfigURL).toURI());
						newConfigFile.getName();

						//						final File configFile = new File(configuration, configFileName);
						//
						//						configFile.delete();
						//
						//						logger.info("bundle #{} - remove configuration file #{}", bundle.getSymbolicName(), configFileName);
					}
				}
			} catch (URISyntaxException | IOException e) {
				logger.warn("error remove configuration files", e);
			}
		}).start();
	}

	private void loadLocalization(final Bundle bundle) {
		new Thread(() -> {
			final Enumeration<URL> configurations = bundle.findEntries(Constants.BUNDLE_LOCALIZATION_DEFAULT_BASENAME, "*.properties", true);

			try {
				if (configurations != null) {
					while (configurations.hasMoreElements()) {
						final URL newConfigURL = configurations.nextElement();
						final File newConfigFile = new File(FileLocator.toFileURL(newConfigURL).toURI());
						newConfigFile.getName();

						//
						//
						//						final File configFile = new File(configuration, configFileName);
						//
						//						final Properties newProperties = new Properties();
						//						newProperties.load(new FileInputStream(newConfigFile));
						//
						//						final Properties properties = new Properties();
						//
						//						if (configFile.exists()) {
						//							try (FileInputStream inStream = new FileInputStream(configFile)) {
						//								properties.load(inStream);
						//							}
						//						}
						//
						//						newProperties.putAll(properties);
						//
						//						try (FileOutputStream outStream = new FileOutputStream(configFile)) {
						//							newProperties.store(outStream, "");
						//						}
						//
						//						logger.info("bundle #{} - manage configuration file #{}", bundle.getSymbolicName(), configFileName);
					}
				}
			} catch (URISyntaxException | IOException e) {
				logger.warn("error manage configuration files", e);
			}
		}).start();
	}
}

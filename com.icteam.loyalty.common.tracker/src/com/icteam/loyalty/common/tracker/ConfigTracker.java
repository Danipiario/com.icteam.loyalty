package com.icteam.loyalty.common.tracker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

public class ConfigTracker extends BundleTracker<Bundle> {

	private static final String CONFIGURATION = "OSGI-INF/configuration";

	private final Logger logger = Log.getLogger(ConfigTracker.class);

	private final File configuration;

	public ConfigTracker(BundleContext context) {
		super(context, Bundle.UNINSTALLED | Bundle.ACTIVE, null);

		configuration = new File(System.getProperty("felix.fileinstall.dir").split(",")[0]);

		if (!configuration.exists()) {
			configuration.mkdirs();
		}
	}

	@Override
	public Bundle addingBundle(Bundle bundle, BundleEvent event) {
		if (hasConfiguration(bundle)) {
			updateConfigurations(bundle);
		}

		return super.addingBundle(bundle, event);
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event, Bundle object) {
		if (hasConfiguration(bundle)) {
			removeConfigurations(bundle);
		}

		super.removedBundle(bundle, event, object);
	}

	private void removeConfigurations(final Bundle bundle) {
		new Thread(() -> {
			final Enumeration<URL> configurations = bundle.findEntries(CONFIGURATION, "*.cfg", true);

			try {
				if (configurations != null) {
					while (configurations.hasMoreElements()) {
						final URL newConfigURL = configurations.nextElement();
						final File newConfigFile = new File(FileLocator.toFileURL(newConfigURL).toURI());
						final String configFileName = newConfigFile.getName();

						final File configFile = new File(configuration, configFileName);

						configFile.delete();

						logger.info("bundle #{} - remove configuration file #{}", bundle.getSymbolicName(),
								configFileName);
					}
				}
			} catch (URISyntaxException | IOException e) {
				logger.warn("error remove configuration files for bundle #" + bundle.getSymbolicName(), e);
			}
		}).start();
	}

	private void updateConfigurations(final Bundle bundle) {
		new Thread(() -> {
			final Enumeration<URL> configurations = bundle.findEntries(CONFIGURATION, "*.cfg", true);

			try {
				if (configurations != null) {
					while (configurations.hasMoreElements()) {
						final URL newConfigURL = configurations.nextElement();
						final File newConfigFile = new File(FileLocator.toFileURL(newConfigURL).toURI());
						final String configFileName = newConfigFile.getName();

						final File configFile = new File(configuration, configFileName);

						final Properties newProperties = new Properties();
						try (FileInputStream inStream = new FileInputStream(newConfigFile)) {
							newProperties.load(inStream);
						}

						final Properties properties = new Properties();

						if (configFile.exists()) {
							try (FileInputStream inStream = new FileInputStream(configFile)) {
								properties.load(inStream);
							}
						}

						newProperties.putAll(properties);

						try (FileOutputStream outStream = new FileOutputStream(configFile)) {
							newProperties.store(outStream, "");
						}

						logger.info("bundle #{} - manage configuration file #{}", bundle.getSymbolicName(),
								configFileName);
					}
				}
			} catch (URISyntaxException | IOException e) {
				logger.warn("error manage configuration files for bundle #" + bundle.getSymbolicName(), e);
			}
		}).start();
	}

	private static boolean hasConfiguration(Bundle bundle) {
		return bundle.getEntry(CONFIGURATION) != null;
	}
}

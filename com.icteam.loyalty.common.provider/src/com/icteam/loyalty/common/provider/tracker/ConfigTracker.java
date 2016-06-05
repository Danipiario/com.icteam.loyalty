package com.icteam.loyalty.common.provider.tracker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

public class ConfigTracker extends BundleTracker<Bundle> {

	private static final String CONFIGURATION = "OSGI-INF/configuration";

	public ConfigTracker(BundleContext context) {
		super(context, Bundle.UNINSTALLED | Bundle.ACTIVE, null);
	}

	@Override
	public Bundle addingBundle(Bundle bundle, BundleEvent event) {
		if (hasConfiguration(bundle)) {
			updateConfigurations(bundle);
		}

		return super.addingBundle(bundle, event);
	}

	private static void updateConfigurations(final Bundle bundle) {
		new Thread(() -> {
			// assumiamo che la prima directory di poll sia quella delle
			// configurazioni
			final File configuration = new File(System.getProperty("felix.fileinstall.dir").split(",")[0]);

			if (!configuration.exists()) {
				configuration.mkdirs();
			}

			final Enumeration<URL> configurations = bundle.findEntries(CONFIGURATION, "*.cfg", true);

			try {
				if (configurations != null) {
					while (configurations.hasMoreElements()) {
						final URL newConfigURL = configurations.nextElement();
						final File newConfigFile = new File(FileLocator.toFileURL(newConfigURL).toURI());
						final String configFileName = newConfigFile.getName();

						final File configFile = new File(configuration, configFileName);

						final Properties newProperties = new Properties();
						newProperties.load(new FileInputStream(newConfigFile));

						final Properties properties = new Properties();

						if (configFile.exists()) {
							try (FileInputStream inStream = new FileInputStream(configFile)){
								properties.load(inStream);
							}
						}

						newProperties.putAll(properties);

						try (FileOutputStream outStream = new FileOutputStream(configFile)) {
							newProperties.store(outStream, "");
						}

					}
				}
			} catch (URISyntaxException | IOException e1) {
				e1.printStackTrace();
			}
		}).start();
	}

	private static boolean hasConfiguration(Bundle bundle) {
		return bundle.getEntry(CONFIGURATION) != null;
	}

}

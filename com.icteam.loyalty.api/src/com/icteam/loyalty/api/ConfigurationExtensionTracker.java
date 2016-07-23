package com.icteam.loyalty.api;

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

public class ConfigurationExtensionTracker extends BundleTracker<Bundle> {

    private static final String CONFIGURATION = "OSGI-INF/configuration";

    public ConfigurationExtensionTracker(BundleContext context) {
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
        new Thread(new Runnable() {
            @Override
            public void run() {
                // assumiamo che la prima directory di poll sia quella delle configurazioni
                File configuration = new File(System.getProperty("felix.fileinstall.dir").split(",")[0]);

                if (!configuration.exists()) {
                    configuration.mkdirs();
                }

                Enumeration<URL> configurations = bundle.findEntries(CONFIGURATION, "*.cfg", true);

                try {
                    if (configurations != null) {
                        while (configurations.hasMoreElements()) {
                            URL newConfigURL = configurations.nextElement();
                            File newConfigFile = new File(FileLocator.toFileURL(newConfigURL).toURI());
                            String configFileName = newConfigFile.getName();

                            File configFile = new File(configuration, configFileName);

                            Properties newProperties = new Properties();
                            newProperties.load(new FileInputStream(newConfigFile));

                            Properties properties = new Properties();

                            if (configFile.exists()) {
                                FileInputStream inStream = new FileInputStream(configFile);
                                try {
                                    properties.load(inStream);
                                } finally {
                                    inStream.close();
                                }
                            }

                            newProperties.putAll(properties);

                            FileOutputStream outStream = new FileOutputStream(configFile);
                            try {
                                newProperties.store(outStream, "");
                            } finally {
                                outStream.close();
                            }

                        }
                    }
                } catch (URISyntaxException | IOException e1) {
                    e1.printStackTrace();
                }
            }
        }).start();
    }

    private static boolean hasConfiguration(Bundle bundle) {
        return bundle.getEntry(CONFIGURATION) != null;
    }

}

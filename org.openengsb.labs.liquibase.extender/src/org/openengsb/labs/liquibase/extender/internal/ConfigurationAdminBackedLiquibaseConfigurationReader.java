/**
 * Licensed to the Austrian Association for Software Tool Integration (AASTI)
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. The AASTI licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openengsb.labs.liquibase.extender.internal;

import java.io.IOException;
import java.util.Dictionary;

import org.openengsb.labs.liquibase.extender.ILiquibaseConfiguration;
import org.openengsb.labs.liquibase.extender.LiquibaseConfigurationReader;
import org.osgi.framework.BundleContext;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.util.tracker.ServiceTracker;

public class ConfigurationAdminBackedLiquibaseConfigurationReader implements LiquibaseConfigurationReader {
    private final BundleContext bundleContext;

    private volatile boolean initialized = false;
    private final Object monitor = new Object();

    private ServiceTracker<ConfigurationAdmin, ConfigurationAdmin> serviceTracker;

    public ConfigurationAdminBackedLiquibaseConfigurationReader(BundleContext bundleContext) {
        this.bundleContext = bundleContext;

    }

    @Override
    public ILiquibaseConfiguration readConfiguration() {
        serviceTracker = new ServiceTracker<>(bundleContext, ConfigurationAdmin.class, null);
        try {
            serviceTracker.open();

            ConfigurationAdmin configAdmin = serviceTracker.waitForService(10000l);
            if (configAdmin == null) {
                throw new RuntimeException("Database configuration not found. Please provide one");
            }

            Configuration configuration = getConfiguration(configAdmin);
            Dictionary< ? , ? > databaseConfiguration = configuration.getProperties();

            if (databaseConfiguration == null) {
                throw new RuntimeException("Database configuration not found. Please provide one");
            }

            return new LiquibaseConfiguration(databaseConfiguration);
        } catch (InterruptedException e) {
            throw new RuntimeException("Database configuration not found. Please provide one");
        } finally {
            serviceTracker.close();
        }
    }

    private Configuration getConfiguration(ConfigurationAdmin configAdmin) {
        Configuration configuration = null;
        try {
            configuration = configAdmin.getConfiguration(LiquibaseConfigurationReader.SETTINGS_PID);

            if (configuration == null || configuration.getProperties() == null) {
                int i = 0;
                synchronized (monitor) {
                    while (!initialized && i < 5) {
                        try {
                            monitor.wait(10000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException("Database configuration not found. Please provide one");
                        }

                        i++;
                    }
                }

                configuration = configAdmin.getConfiguration(LiquibaseConfigurationReader.SETTINGS_PID);

                if (configuration == null || configuration.getProperties() == null) {
                    throw new RuntimeException("Database configuration not found. Please provide one");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Database configuration not found. Please provide one");
        }

        return configuration;
    }

    @Override
    public void updated(Dictionary<String, ? > properties) {
        if (properties != null) {
            synchronized (monitor) {
                initialized = true;
                monitor.notifyAll();
            }
        }
    }

}

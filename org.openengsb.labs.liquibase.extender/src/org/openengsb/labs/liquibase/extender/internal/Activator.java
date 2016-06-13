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

import java.util.Dictionary;
import java.util.Hashtable;

import org.openengsb.labs.liquibase.extender.DatabaseMigrationCenter;
import org.openengsb.labs.liquibase.extender.LiquibaseConfigurationReader;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ManagedService;

public class Activator implements BundleActivator {

    MigrationBundleListener bundleListener;
    private ServiceRegistration<ManagedService> configurationReaderRegistration;
    private ServiceRegistration<DatabaseMigrationCenter> databaseMigrationCenterRegistration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        LiquibaseConfigurationReader reader = new ConfigurationAdminBackedLiquibaseConfigurationReader(bundleContext);

        Dictionary<String, String> properties = new Hashtable<>();
        properties.put(Constants.SERVICE_PID, LiquibaseConfigurationReader.SETTINGS_PID);

        configurationReaderRegistration = bundleContext.registerService(ManagedService.class, reader, properties);

        SqlConnectionFactory sqlConnectionFactory = new OsgiSqlConnectionFactory(bundleContext);

        LiquibaseMigrationBundleFactory liquibaseMigrationBundleFactory = new LiquibaseMigrationBundleFactory(reader, sqlConnectionFactory);

        LiquibaseDatabaseMigrationCenter liquibaseDatabaseMigrationCenter = new LiquibaseDatabaseMigrationCenter();

        LiquibaseMigrationCenterHead migrationCenterHeader = new LiquibaseMigrationCenterHead(liquibaseMigrationBundleFactory,
                liquibaseDatabaseMigrationCenter);

        bundleListener = new MigrationBundleListener(bundleContext, migrationCenterHeader);

        new Thread(new Runnable() {
            @Override
            public void run() {
                bundleListener.open();
            }
        }).start();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        databaseMigrationCenterRegistration.unregister();
        configurationReaderRegistration.unregister();
        bundleListener.close();
    }

}

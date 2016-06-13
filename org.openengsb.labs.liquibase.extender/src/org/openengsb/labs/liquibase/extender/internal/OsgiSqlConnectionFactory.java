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

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

public class OsgiSqlConnectionFactory implements SqlConnectionFactory {

    private final BundleContext liquibaseBundleContext;

    public OsgiSqlConnectionFactory(BundleContext liquibaseBundleContext) {
        this.liquibaseBundleContext = liquibaseBundleContext;
    }

    @Override
    public Connection loadConnection(String connectionName) throws SQLException {
        Connection connection = null;
        DataSource dataSource = null;
        ServiceTracker<DataSource, DataSource> serviceTracker = null;
        String filter = "(&(" + Constants.OBJECTCLASS + "=" + DataSource.class.getName() + ")" + "(osgi.jndi.service.name=" + connectionName + ")";

        if (connectionName == null) {
            serviceTracker = new ServiceTracker<>(liquibaseBundleContext, DataSource.class.getName(), null);
        } else {
            try {
                serviceTracker = new ServiceTracker<>(liquibaseBundleContext, liquibaseBundleContext.createFilter(filter), null);
            } catch (InvalidSyntaxException e) {
                e.printStackTrace();
            }
        }

        try {
            if (serviceTracker != null) {
                serviceTracker.open();

                int i = 0;
                while (i < 10) {
                    dataSource = serviceTracker.waitForService(20000);

                    if (dataSource != null) {
                        try {
                            connection = dataSource.getConnection();
                            break;
                        } catch (SQLException e) {
                            // Invalid Oracle URL
                            // try again, placeholder not substituted
                            if (e.getErrorCode() != 17067) {
                                throw e;
                            } else {
                                Thread.sleep(1000);
                                i++;
                            }
                        }
                    }
                }
            }

            if (dataSource == null || connection == null) {
                throw new IllegalStateException("No service could be retrieved");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (serviceTracker != null) {
                serviceTracker.close();
            }
        }

        return connection;
    }
}

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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openengsb.labs.liquibase.extender.DatabaseMigrationCenter;
import org.openengsb.labs.liquibase.extender.DatabaseMigrationException;
import org.osgi.framework.FrameworkUtil;

public class LiquibaseDatabaseMigrationCenter implements DatabaseMigrationCenter, LiquibaseMigrationCenterConfiguration {

    private final List<String> migrationBundles = new ArrayList<>();
    private final Map<String, DatabaseMigrationBundle> migrationBundlesToExecute = new HashMap<>();

    private boolean lastMigrationRequiredResult;
    private boolean isMigrationResultValid;
    private MigrationWatcher migrationWatcher;

    class MigrationWatcher extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);

                while (isMigrationRequired()) {
                    for (DatabaseMigrationBundle databaseMigrationBundle : getSortedMigrationBundles()) {
                        System.out.println("Migration Bundle #"
                                + databaseMigrationBundle.getName()
                                + " - waiting for #"
                                + databaseMigrationBundle.getPrecedenceBundles());
                    }

                    Thread.sleep(5000);

                    synchronized (LiquibaseDatabaseMigrationCenter.this) {
                        executeMigration();
                    }
                }

                FrameworkUtil.getBundle(LiquibaseDatabaseMigrationCenter.class).getBundleContext()
                        .registerService(DatabaseMigrationCenter.class, LiquibaseDatabaseMigrationCenter.this, null);
            } catch (InterruptedException | DatabaseMigrationException e) {
                e.printStackTrace();
            }
        }
    }

    public LiquibaseDatabaseMigrationCenter() {
    }

    @Override
    public synchronized boolean isMigrationRequired() {
        if (isMigrationResultValid) {
            return lastMigrationRequiredResult;
        }

        if (!migrationBundlesToExecute.isEmpty()) {
            lastMigrationRequiredResult = true;
            isMigrationResultValid = true;

            return true;
        }

        lastMigrationRequiredResult = false;
        isMigrationResultValid = true;

        return false;
    }

    @Override
    public void forceMigrationRevaluation() {
        isMigrationResultValid = false;
    }

    @Override
    public void executeMigration() throws DatabaseMigrationException {
        isMigrationResultValid = false;

        for (DatabaseMigrationBundle databaseMigrationBundle : getSortedMigrationBundles()) {
            if (canStart(databaseMigrationBundle)) {
                if (databaseMigrationBundle.isMigrationRequired()) {
                    databaseMigrationBundle.executeMigration();
                }

                String bundleName = databaseMigrationBundle.getName();

                migrationBundlesToExecute.remove(bundleName);
                migrationBundles.add(bundleName);
            }
        }
    }

    @Override
    public synchronized void register(DatabaseMigrationBundle databaseMigrationBundle) throws DatabaseMigrationException {
        String bundleName = databaseMigrationBundle.getName();

        isMigrationResultValid = false;

        migrationBundlesToExecute.put(bundleName, databaseMigrationBundle);

        if (migrationWatcher == null || !migrationWatcher.isAlive()) {
            migrationWatcher = new MigrationWatcher();
            migrationWatcher.start();
        }

        executeMigration();
    }

    private boolean canStart(DatabaseMigrationBundle databaseMigrationBundle) {
        boolean canStart = true;

        for (String precedenceBundle : databaseMigrationBundle.getPrecedenceBundles()) {
            if (!migrationBundles.contains(precedenceBundle)) {
                canStart = false;
                break;
            }
        }

        return canStart;
    }

    @Override
    public void cancelBundleRegistration(String bundleName) {
        isMigrationResultValid = false;

        migrationBundlesToExecute.remove(bundleName);
        migrationBundles.remove(bundleName);
    }

    synchronized List<DatabaseMigrationBundle> getSortedMigrationBundles() {
        List<DatabaseMigrationBundle> sortedMigrationBundles = new ArrayList<>(migrationBundlesToExecute.values());

        Collections.sort(sortedMigrationBundles);

        return sortedMigrationBundles;
    }
}

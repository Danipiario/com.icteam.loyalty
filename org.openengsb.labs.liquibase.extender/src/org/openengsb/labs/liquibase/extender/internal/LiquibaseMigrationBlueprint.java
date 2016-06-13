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

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.osgi.framework.Bundle;

import liquibase.changelog.ChangeLogParameters;
import liquibase.changelog.DatabaseChangeLog;
import liquibase.exception.LiquibaseException;
import liquibase.osgi.OSGiResourceAccessor;
import liquibase.parser.ChangeLogParserFactory;

public class LiquibaseMigrationBlueprint {

    // private static final String LIQUIBASE_MASTER_XML_DEFAULT_PATH = "OSGI-INF/liquibase/master.xml";

    Bundle bundle;

    List<String> precedenceBundles;

    public LiquibaseMigrationBlueprint(Bundle bundle) {
        this.bundle = bundle;
    }

    public boolean hasMigrationBlueprint() {
        return bundle.getHeaders().get(ManifestParameters.LIQUIBASE_PERSITENCE) != null;
    }

    public DatabaseChangeLog loadDatabaseChangelogWith(ChangeLogParameters changeLogParameters) throws LiquibaseException {
        if (!hasMigrationBlueprint()) {
            throw new IllegalStateException("Couldn't load changelog without liquibase manifest header");
        }
        OSGiResourceAccessor resourceAccessor = new OSGiResourceAccessor(bundle);

        return ChangeLogParserFactory.getInstance().getParser(liquibaseFilePath(), resourceAccessor).parse(liquibaseFilePath(), changeLogParameters,
                resourceAccessor);
    }

    private String liquibaseFilePath() {
        return bundle.getHeaders().get(ManifestParameters.LIQUIBASE_PERSITENCE).toString();
    }

    public List<String> getPrecedenceBundles() {
        if (precedenceBundles == null) {
            String[] array = null;

            String str = bundle.getHeaders().get(ManifestParameters.LIQUIBASE_PRECEDENCE_BUNDLE_LIST);
            str = StringUtils.defaultString(str, "");

            array = StringUtils.split(str, ',');
            array = StringUtils.stripAll(array);

            precedenceBundles = Arrays.asList(array);
        }

        return precedenceBundles;
    }

    public String getName() {
        return bundle.getSymbolicName();
    }

    private interface ManifestParameters {
        String LIQUIBASE_PERSITENCE = "Liquibase-Persistence";
        String LIQUIBASE_PRECEDENCE_BUNDLE_LIST = "Liquibase-PrecedenceBundleList";
    }

}

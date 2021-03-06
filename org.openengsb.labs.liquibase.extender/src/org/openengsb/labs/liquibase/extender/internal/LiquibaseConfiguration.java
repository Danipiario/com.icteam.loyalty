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
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import org.openengsb.labs.liquibase.extender.ILiquibaseConfiguration;

import liquibase.util.StringUtils;

public class LiquibaseConfiguration implements ILiquibaseConfiguration {
    public static final Boolean USE_LIQUIBASE_DEFAULT_VALUE = true;
    public static final String SCHEMA_NAME_DEFAULT_VALUE = "public";
    public static final String CONTEXTS_DEFAULT_VALUE = "";
    public static final String DATASOURCE_DEFAULT_VALUE = null;
    public static final String LOG_LVL_DEFAULT_VALUE = "SEVERE";

    public static final String USE_LIQUIBASE_ID = "useLiquibase";
    public static final String SCHEMA_NAME_ID = "defaultSchema";
    public static final String CONTEXTS_ID = "contexts";
    public static final String PARAMTERS_ID = "parameter.";
    public static final String DATASOURCE_ID = "datasource";
    public static final String LOG_LVL = "loglevel";

    private final boolean shouldLiquibaseBeApplied;
    private final String defaultSchemaName;
    private final String contexts;
    private final String dataSource;
    private final String logLevel;

    private final List<Map.Entry<String, Object>> parameters;

    public LiquibaseConfiguration() {
        this.shouldLiquibaseBeApplied = USE_LIQUIBASE_DEFAULT_VALUE;
        this.defaultSchemaName = SCHEMA_NAME_DEFAULT_VALUE;
        this.contexts = CONTEXTS_DEFAULT_VALUE;
        this.dataSource = DATASOURCE_DEFAULT_VALUE;
        this.logLevel = LOG_LVL_DEFAULT_VALUE;
        this.parameters = new ArrayList<>();
    }

    public LiquibaseConfiguration(Dictionary< ? , ? > databaseConfiguration) {
        Object useLiquibaseFlag = databaseConfiguration.get(LiquibaseConfiguration.USE_LIQUIBASE_ID);
        if (useLiquibaseFlag == null) {
            shouldLiquibaseBeApplied = LiquibaseConfiguration.USE_LIQUIBASE_DEFAULT_VALUE;
        } else {
            shouldLiquibaseBeApplied = Boolean.valueOf(useLiquibaseFlag.toString());
        }
        Object schemaName = databaseConfiguration.get(LiquibaseConfiguration.SCHEMA_NAME_ID);
        if (schemaName == null) {
            defaultSchemaName = LiquibaseConfiguration.SCHEMA_NAME_DEFAULT_VALUE;
        } else {
            defaultSchemaName = (String) schemaName;
        }
        Object contexts = databaseConfiguration.get(LiquibaseConfiguration.CONTEXTS_ID);
        if (contexts == null) {
            this.contexts = LiquibaseConfiguration.CONTEXTS_DEFAULT_VALUE;
        } else {
            this.contexts = (String) contexts;
        }
        Object datasource = databaseConfiguration.get(LiquibaseConfiguration.DATASOURCE_ID);
        if (datasource == null) {
            this.dataSource = LiquibaseConfiguration.DATASOURCE_DEFAULT_VALUE;
        } else {
            this.dataSource = (String) datasource;
        }
        Object logLevel = databaseConfiguration.get(LiquibaseConfiguration.LOG_LVL);
        if (logLevel == null) {
            this.logLevel = LiquibaseConfiguration.LOG_LVL_DEFAULT_VALUE;
        } else {
            this.logLevel = (String) logLevel;
        }
        ArrayList<Map.Entry<String, Object>> entries = new ArrayList<>();
        Enumeration< ? > keys = databaseConfiguration.keys();
        if (keys == null) {
            parameters = entries;
        } else {
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                if (key.startsWith(LiquibaseConfiguration.PARAMTERS_ID)) {
                    entries.add(new PropertyEntry(key.substring(LiquibaseConfiguration.PARAMTERS_ID.length()), databaseConfiguration.get(key)));
                }
            }
            parameters = entries;
        }
    }

    @Override
    public boolean isShouldLiquibaseBeApplied() {
        return shouldLiquibaseBeApplied;
    }

    @Override
    public String getDefaultSchemaName() {
        return defaultSchemaName;
    }

    @Override
    public String getContexts() {
        return contexts;
    }

    public List<String> getSplittedContexts() {
        return StringUtils.splitAndTrim(StringUtils.trimToNull(getContexts()), ",");
    }

    @Override
    public String[] getSplittedContextsAsArray() {
        return getSplittedContexts() != null ? getSplittedContexts().toArray(new String[getSplittedContexts().size()]) : new String[0];
    }

    @Override
    public String getDataSource() {
        return dataSource;
    }

    @Override
    public String getLogLvl() {
        return logLevel;
    }

    @Override
    public List<Map.Entry<String, Object>> getParameters() {
        return parameters;
    }

    private class PropertyEntry implements Map.Entry<String, Object> {

        private final String key;
        private final Object value;

        public PropertyEntry(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            throw new RuntimeException("Object is read only!");
        }
    }
}

package org.openengsb.labs.liquibase.extender;

import java.util.List;
import java.util.Map;

public interface ILiquibaseConfiguration {

    boolean isShouldLiquibaseBeApplied();

    String getDefaultSchemaName();

    String getContexts();

    String getDataSource();

    String getLogLvl();

    List<Map.Entry<String, Object>> getParameters();

    public abstract String[] getSplittedContextsAsArray();

}
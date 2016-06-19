package com.icteam.loyalty.common.internal.db;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Loyalty Db Configuration", id = "com.icteam.loyalty.db", pid = "com.icteam.loyalty.db", description = "Parametri di configurazione specifici del db")
public interface DbConfiguration {

    @AttributeDefinition(defaultValue = "LOYALTY", required = true, description = "Username database")
    String user();

    @AttributeDefinition(defaultValue = "LOYALTY", required = true, description = "Password database in chiaro")
    String password();

    @AttributeDefinition(defaultValue = "jdbc:oracle:thin:@localhost:1521:XE", required = true, description = "URL di connessione. Es. jdbc:oracle:thin:@localhost:1521:XE")
    String URL();

}

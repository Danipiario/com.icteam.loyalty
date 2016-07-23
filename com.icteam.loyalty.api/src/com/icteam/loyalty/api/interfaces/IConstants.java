package com.icteam.loyalty.api.interfaces;

import java.math.BigDecimal;

/**
 * IConstants
 */
public interface IConstants {
    String DATASOURCE = "java:/LoyaltyDataSource";
    String WS_CONTEXT_ROOT = "loyaltyws";

    String FLAG_YES = "Y";
    String FLAG_NO = "N";
    String OPERATOR_LOGIN = "process";
    String BACKGROUND_OPERATOR = "process";
    String FINAL_USER_LOGIN = "final_user";

    String ERROR = "error";

    String NULL = "null";
    String LOGIN = "login";
    String STATUS = "status";

    String NULL_RESOURCE_STRING = "???";

    String KEY_CLUSTER_NAME = "cluser.name";
    String KEY_JMS_PROVIDER_URL = "jms.provider.url";
    String KEY_EAR_PREFIX = "ear.prefix";
    String KEY_ENVIRONMENT = "environment";
    String KEY_PROXY = "proxy";
    String KEY_TEST = "test";
    String KEY_REMOTE_INITIAL_CONTEXT_FACTORY = "remote.context.factory";
    String KEY_INITIAL_CONTEXT_FACTORY = "context.factory";
    String KEY_SECURITY_DOMAIN = "security.domain";
    String KEY_PKG_PREFIXES = "pkg.prefixes";
    String KEY_SESSION_FACTORY = "session.factory";
    String KEY_INSTALLATION = "installation";

    // String DB_NAME = "DB_NAME";
    //
    // String ORACLE_DB = "Oracle";
    // String SQLSRVER_DB = "SQL Server";
    // String H2_DB = "H2";

    String FORMAT_ITALIAN_TIME = "HH:mm:ss";
    String FORMAT_ITALIAN_TIMESTAMP = "dd/MM/yyyy HH:mm:ss";
    String FORMAT_ITALIAN_TIMESTAMP_FOR_FILE = "yyyyMMdd_HHmmss";
    String MESSAGE_FORMAT_ITALIAN_TIMESTAMP = "{0,date,dd/MM/yyyy HH:mm:ss}";
    String FORMAT_ITALIAN = "dd/MM/yyyy";

    String FORMAT_ISO8601 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";

    String FIELD_PARAM_SEPARATOR = ",";
    String PARAM_SEPARATOR = ";";

    String DEFUALT_SEQUENCE_NAME = "HIBERNATE_SEQUENCE";

    String TRANSLATION_SEQUENCE_NAME = "TRANSLATION_SEQUENCE";
    String DEFAULT_FILE_SEP = System.getProperty("file.separator");
    String DEFAULT_LINE_SEP = System.getProperty("line.separator");
    String DEFAULT_FIELD_SEP = ";";

    String T_END = "tEnd";
    String T_START = "tStart";
    String CASH_DESK = "cashDesk";
    String NODE_CODE = "nodeCode";
    String OPERATION_DATE = "operationDate";

    String OK = "OK";
    String ENUM_RETRIEVE_CLASS = "com.icteam.loyalty.core.retrieve.EnumRetrieve";
    String IDENTITY_RETRIEVE_CLASS = "com.icteam.loyalty.core.retrieve.IdentityRetrieve";
    String DB_RETRIEVE_CLASS = "com.icteam.loyalty.core.retrieve.DbRetrieve";

    String DB_PROPERTY_GROUP_CLASS = "com.icteam.loyalty.core.property.DbPropertyGroup";
    String FILE_PROPERTY_GROUP_CLASS = "com.icteam.loyalty.core.property.FilePropertyGroup";

    BigDecimal PERCENT = new BigDecimal("100");

    String UNDERSCORE = "_";
    String STAR = "*";
    String REMOVE = "remove";
    String ADD = "add";
    String REFRESH = "refresh";
    String RUN = "run";
    String VIEW = "view";
    String EDIT = "edit";
    String TOOLTIP = "tooltip";

    String ICON_PATH_PREFIX = "/icons/";
    String SOURCE_URI_PROPERTY = "http://com.icteam.loyalty/property";
    String SOURCE_URI_WHERE = "http://com.icteam.loyalty/where";
    String SOURCE_URI_UI = "http://com.icteam.loyalty/ui";
}

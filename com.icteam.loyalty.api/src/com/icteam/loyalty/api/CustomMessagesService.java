package com.icteam.loyalty.api;

import java.io.IOException;
import java.util.Map;

public interface CustomMessagesService {

    public static final String PID = "com.icteam.loyalty.api.custommessages";

    String getCustomMessage(String key);

    boolean containsCustomMessage(String key);

    String addCustomMessage(String message, Class< ? > clazz) throws IOException;

    String getCustomClassMessage(String keyClass, String keyObject);

    boolean containsCustomClassMessage(String keyClass, String keyObject);

    Map<String, String> getKeys(String keyClass);

}

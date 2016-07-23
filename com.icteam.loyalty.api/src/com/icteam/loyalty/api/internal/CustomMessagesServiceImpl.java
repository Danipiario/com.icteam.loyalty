package com.icteam.loyalty.api.internal;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

import com.icteam.loyalty.api.CustomMessagesService;
import com.icteam.loyalty.api.Messages;

public class CustomMessagesServiceImpl implements CustomMessagesService {

    private ConfigurationAdmin configurationAdmin;
    private final Dictionary<String, String> customMessages = new Hashtable<>();
    private final Map<String, Map<String, String>> customClassMessages = new HashMap<>();

    public ConfigurationAdmin getConfigurationAdmin() {
        return configurationAdmin;
    }

    public void setConfigurationAdmin(ConfigurationAdmin configurationAdmin) {
        this.configurationAdmin = configurationAdmin;
    }

    private static Dictionary<String, Object> getProperties(Configuration configuration) {
        Dictionary<String, Object> properties = configuration.getProperties();

        if (properties == null) {
            properties = new Hashtable<>();
        }

        return properties;
    }

    private Configuration getConfiguration() throws IOException {
        return configurationAdmin.getConfiguration(CustomMessagesService.PID);
    }

    public void refresh(Map<String, String> properties) {
        if (properties == null) {
            return;
        }

        synchronized (customMessages) {
            synchronized (customClassMessages) {
                for (Entry<String, String> entry : properties.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();

                    customMessages.put(key, value);

                    String keyClass = key;
                    String keyObject = "";

                    int classSep = key.indexOf('_');

                    if (classSep != -1) {
                        keyClass = key.substring(0, classSep);
                        keyObject = key.substring(classSep + 1);
                    }

                    Map<String, String> classMessages = customClassMessages.get(keyClass);
                    if (classMessages == null) {
                        customClassMessages.put(keyClass, classMessages = new HashMap<>());
                    }

                    classMessages.put(keyObject, value);
                }

                for (Enumeration<String> keys = customMessages.keys(); keys.hasMoreElements();) {
                    String key = keys.nextElement();

                    if (!properties.containsKey(key)) {
                        customMessages.remove(key);

                        String keyClass = key;
                        String keyObject = "";

                        int classSep = key.indexOf('_');

                        if (classSep != -1) {
                            keyClass = key.substring(0, classSep);
                            keyObject = key.substring(classSep + 1);
                        }

                        Map<String, String> classMessages = customClassMessages.get(keyClass);
                        if (classMessages != null) {
                            classMessages.remove(keyObject);

                            if (classMessages != null && classMessages.isEmpty()) {
                                customClassMessages.remove(keyClass);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public String getCustomMessage(String key) {
        synchronized (customMessages) {
            return customMessages.get(key);
        }
    }

    @Override
    public String getCustomClassMessage(String keyClass, String keyObject) {
        synchronized (customClassMessages) {
            Map<String, String> classMessages = customClassMessages.get(keyClass);

            return classMessages != null ? classMessages.get(keyObject) : null;
        }
    }

    @Override
    public boolean containsCustomMessage(String key) {
        return getCustomMessage(key) != null;
    }

    @Override
    public boolean containsCustomClassMessage(String keyClass, String keyObject) {
        return getCustomClassMessage(keyClass, keyObject) != null;
    }

    @Override
    public String addCustomMessage(String message, Class< ? > clazz) throws IOException {
        int index = 0;
        String prefix = clazz == null ? "" : clazz.getSimpleName() + "_";
        String key = buildKey(message, prefix, index);

        while (Messages.contains(key)) {
            key = buildKey(message, prefix, ++index);
        }

        Configuration configuration = getConfiguration();
        Dictionary<String, Object> properties = getProperties(configuration);

        properties.put(key, message);

        configuration.update(properties);

        key = key.substring(prefix.length());

        return key;
    }

    @Override
    public Map<String, String> getKeys(String keyClass) {
        synchronized (customClassMessages) {
            return customClassMessages.get(keyClass);
        }
    }

    private static String buildKey(String message, String prefix, int index) {
        String[] blocks = message.toUpperCase().split(" ");

        for (int i = 0; i < blocks.length; i++) {
            String b = blocks[i];

            if (b.length() < 3) {
                blocks = (String[]) ArrayUtils.remove(blocks, i);
                i--;
            } else {
                blocks[i] = b.substring(0, 3);
            }
        }

        String key = prefix + StringUtils.join(blocks, "_");
        int l = index == 0 ? 0 : ("" + index).length();
        key = StringUtils.substring(key, 0, 50 - l);
        if (key.endsWith("_")) {
            key = StringUtils.substring(key, 0, -1);
        }

        if (index != 0) {
            key += index;
        }

        return key;
    }
}
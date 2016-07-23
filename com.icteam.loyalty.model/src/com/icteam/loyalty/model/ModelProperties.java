package com.icteam.loyalty.model;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.osgi.service.cm.ManagedService;

import aQute.bnd.annotation.metatype.Configurable;
import aQute.bnd.annotation.metatype.Meta.OCD;

public class ModelProperties implements ModelConfiguration, ManagedService {

    public static ModelConfiguration modelConfigurationDelegate = ModelProperties.createConfiguration(ModelConfiguration.class);

    private static ModelProperties INSTANCE;

    public void init() {

        INSTANCE = this;
    }

    @Override
    public void updated(Dictionary<String, ? > properties) {
        if (properties != null) {
            modelConfigurationDelegate = ModelProperties.createConfiguration(ModelConfiguration.class, properties);
        }
    }

    public static ModelProperties getInstance() {
        return INSTANCE;
    }

    @Override
    public int tooltipShowTimeMillis() {
        return modelConfigurationDelegate.tooltipShowTimeMillis();
    }

    @Override
    public int minSearchCharacterI18N() {
        return modelConfigurationDelegate.minSearchCharacterI18N();
    }

    @Override
    public int inClauseMaxLength() {
        return modelConfigurationDelegate.inClauseMaxLength();
    }

    public static <T> T createConfiguration(Class<T> configurationClass) {
        return createConfiguration(configurationClass, new Hashtable<>());
    }

    public static <T> T createConfiguration(Class<T> configurationClass, @SuppressWarnings("rawtypes") Dictionary properties) {
        OCD meta = configurationClass.getAnnotation(OCD.class);
        if (meta != null) {
            String id = meta.id();

            Properties systemProperties = System.getProperties();
            for (Entry<Object, Object> entry : systemProperties.entrySet()) {
                String key = (String) entry.getKey();

                if (key.startsWith(id)) {
                    String prop = StringUtils.removeStart(key, id);
                    prop = StringUtils.removeStart(prop, ".");

                    if (properties.get(prop) == null) {
                        properties.put(prop, entry.getValue());
                    }
                }
            }
        }

        return Configurable.createConfigurable(configurationClass, properties);
    }

}

package com.icteam.loyalty.common.nls;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.WeakHashMap;

import org.apache.commons.lang3.LocaleUtils;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.component.annotations.Component;

import com.icteam.loyalty.common.configuration.Configurable;

@Component(immediate = true, configurationPid = "com.icteam.loyalty.common.nls")
public class NLS implements ManagedService {

	private static final Logger logger = Log.getLogger(NLS.class);

	private static NLSConfiguration configuration = Configurable.createConfigurable(NLSConfiguration.class,
			new HashMap<>());

	private final static Map<ResourceBundle, Object> map = new WeakHashMap<>();

	/**
	 * Returns a NLS object for the given resource bundle and type. See class
	 * description for usage information. The resource bundles read by this
	 * method have to be UTF-8 encoded. Note that this is not according to the
	 * {@link java.util.Properties Properties} file specification and meant for
	 * a more convenient use.
	 *
	 * @param clazz
	 *            the class of the NLS object to load.
	 */
	public static <T> T getUTF8Encoded(Class<T> clazz) {
		final Optional<ResourceBundle> resourceBundle = Utf8ResourceBundle.getBundle(clazz, getLocale());

		return internalGet(resourceBundle.get(), clazz);
	}

	public static Locale getLocale() {
		return LocaleUtils.toLocale(configuration.defaultLocale());
	}

	@SuppressWarnings("unchecked")
	private static <T> T internalGet(ResourceBundle bundle, Class<T> clazz) {
		T result;
		synchronized (map) {
			result = (T) map.get(bundle);
			if (result == null) {
				try {
					result = clazz.newInstance();
				} catch (InstantiationException | IllegalAccessException e) {
					logger.warn("error instantiating class", e);
				}
				final Field[] fields = clazz.getDeclaredFields();
				for (int i = 0; i < fields.length; i++) {
					final String fieldName = fields[i].getName();
					try {
						if (String.class.isAssignableFrom(fields[i].getType())
								&& Modifier.isPublic(fields[i].getModifiers())
								&& !Modifier.isStatic(fields[i].getModifiers())) {
							try {
								final String value = bundle.getString(fieldName);
								if (value != null) {
									fields[i].setAccessible(true);
									fields[i].set(result, value);
								}
							} catch (final MissingResourceException mre) {
								fields[i].setAccessible(true);
								fields[i].set(result, "");
								throw mre;
							}
						}
					} catch (final Exception ex) {
						final String qualifiedName = clazz.getName() + "#" + fieldName;
						logger.warn("Failed to load localized message for: " + qualifiedName, ex);
					}
				}

				map.put(bundle, result);
			}
		}

		return result;
	}

	public static <T> String get(Class<T> clazz, String key) {
		final Optional<ResourceBundle> resourceBundle = Utf8ResourceBundle.getBundle(clazz, getLocale());

		if (resourceBundle.isPresent() && resourceBundle.get().containsKey(key)) {
			return resourceBundle.get().getString(key);
		}

		for (final Map<String, ResourceBundle> map : Utf8ResourceBundle.getResourceBundleMaps().values()) {
			for (final ResourceBundle rb : map.values()) {
				if (rb.containsKey(key)) {
					return rb.getString(key);
				}
			}
		}

		logger.warn("Failed to get localized message for class {} and field {}", clazz.getName(), key);

		return "???"+ key+ "???";
	}

	@Override
	public void updated(Dictionary<String, ?> properties) throws ConfigurationException {
		if (properties != null) {
			synchronized (NLS.class) {
				configuration = Configurable.createConfigurable(NLSConfiguration.class, properties);
			}
		}
	}

}

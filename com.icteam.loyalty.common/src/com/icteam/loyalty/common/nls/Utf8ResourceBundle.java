package com.icteam.loyalty.common.nls;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.FrameworkUtil;

public final class Utf8ResourceBundle {

	private final static Map<String, Map<String, ResourceBundle>> resourceBundleMaps = new HashMap<>();

	public static void removeBundle(Bundle bundle) {
		synchronized (resourceBundleMaps) {
			resourceBundleMaps.remove(bundle.getSymbolicName());
		}
	}

	public static ResourceBundle getBundle(Class<?> clazz, Locale locale) {
		final Bundle bundle = FrameworkUtil.getBundle(clazz);

		final String classLocaleKey = clazz.getSimpleName().toLowerCase() + "_" + locale.toString();
		ResourceBundle result = null;

		Map<String, ResourceBundle> resourceBundleMap;

		synchronized (resourceBundleMaps) {
			resourceBundleMap = resourceBundleMaps.get(bundle.getSymbolicName());

			if (resourceBundleMap == null) {
				resourceBundleMaps.put(bundle.getSymbolicName(), resourceBundleMap = new HashMap<>());
			}

			result = resourceBundleMap.get(classLocaleKey);
		}

		if (result == null) {
			final URL propertiesURL = getPropertiesURL(bundle, clazz.getSimpleName().toLowerCase(), locale);

			if (propertiesURL != null) {
				ResourceBundle resourceBundle;
				try {
					resourceBundle = new PropertyResourceBundle(propertiesURL.openStream());

					result = createUtf8Bundle(resourceBundle);
					resourceBundleMap.put(classLocaleKey, result);
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}

		return result;
	}

	private static URL getPropertiesURL(Bundle bundle, String baseName, Locale locale) {
		String localizationHeader = bundle.getHeaders().get(Constants.BUNDLE_LOCALIZATION);
		if (localizationHeader == null) {
			localizationHeader = Constants.BUNDLE_LOCALIZATION_DEFAULT_BASENAME;
		}

		// la definzione della location contiene anche il prefisso del file di
		// properties
		// che deve essere tolto
		// es OSGI-INF/l10n/bundle -> OSGI-INF/l10n
		localizationHeader = localizationHeader.substring(0, localizationHeader.lastIndexOf('/'));

		final String[] nlVariants = buildNLVariants(locale.toString());

		URL propertiesURL = null;
		for (final String nlVariant : nlVariants) {
			propertiesURL = bundle.getEntry(localizationHeader + "/" + baseName
					+ (nlVariant.equals("") ? nlVariant : '_' + nlVariant) + ".properties");

			if (propertiesURL != null) {
				break;
			}
		}

		return propertiesURL;
	}

	private static String[] buildNLVariants(String nl) {
		final List<String> result = new ArrayList<>();
		while (nl.length() > 0) {
			result.add(nl);
			final int i = nl.lastIndexOf('_');
			nl = i < 0 ? "" : nl.substring(0, i); //$NON-NLS-1$
		}
		result.add(""); //$NON-NLS-1$
		return result.toArray(new String[result.size()]);
	}

	private static ResourceBundle createUtf8Bundle(ResourceBundle bundle) {
		ResourceBundle result = bundle;
		if (bundle instanceof PropertyResourceBundle) {
			final PropertyResourceBundle prb = (PropertyResourceBundle) bundle;
			result = new Utf8PropertyResourceBundle(prb);
		}
		return result;
	}

	private static class Utf8PropertyResourceBundle extends ResourceBundle {
		private final PropertyResourceBundle bundle;

		private Utf8PropertyResourceBundle(PropertyResourceBundle bundle) {
			this.bundle = bundle;
		}

		@Override
		public Enumeration<String> getKeys() {
			return bundle.getKeys();
		}

		@Override
		protected Object handleGetObject(String key) {
			String result = (String) bundle.handleGetObject(key);
			try {
				// We do not buffer the encoded result since the RWT.NLS
				// mechanism
				// creates and buffers the completely initialized nls instance.
				// So each
				// entry should only be read once.
				if (result != null) {
					result = new String(result.getBytes("ISO-8859-1"), "UTF-8");
				}
			} catch (final UnsupportedEncodingException uee) {
				throw new RuntimeException("should not happen", uee);
			}
			return result;
		}
	}
}

package com.icteam.loyalty.common.internal.tracker;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

import com.icteam.loyalty.common.nls.NLS;
import com.icteam.loyalty.common.nls.Utf8ResourceBundle;

public class MessageTracker extends BundleTracker<Bundle> {

	private static final String LOCALIZATION = "OSGI-INF/l10n";
	private final Logger logger = Log.getLogger(MessageTracker.class);

	public MessageTracker(BundleContext context) {
		super(context, Bundle.ACTIVE | Bundle.UNINSTALLED, null);
	}

	@Override
	public Bundle addingBundle(Bundle bundle, BundleEvent event) {
		if (hasBundleMessages(bundle)) {
			addMessageBundle(bundle);
		}

		return super.addingBundle(bundle, event);
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event, Bundle object) {
		if (hasBundleMessages(bundle)) {
			removeMessageBundle(bundle);
		}

		super.removedBundle(bundle, event, object);
	}

	private void addMessageBundle(Bundle bundle) {
		new Thread(() -> {
			Enumeration<URL> localizations = bundle.findEntries(LOCALIZATION, "*.properties", true);

			String[] nlVariants = Utf8ResourceBundle.getNLVariants(NLS.getLocale());

			while (localizations.hasMoreElements()) {
				final URL localizationURL = localizations.nextElement();
				try {
					File newConfigFile;
					newConfigFile = new File(FileLocator.toFileURL(localizationURL).toURI());
					final String configFileName = newConfigFile.getName();

					for (String nlVariant : nlVariants) {
						if (configFileName.endsWith(nlVariant)) {
							String classLocaleKey = StringUtils.removeEnd(configFileName, nlVariant);
							Utf8ResourceBundle.loadResourceBundle(bundle, classLocaleKey, localizationURL);
						}
					}

				} catch (URISyntaxException | IOException e) {
					e.printStackTrace();
				}
			}

			logger.info("bundle #{} - add message for bundle", bundle.getSymbolicName());
		}).start();

	}

	private void removeMessageBundle(final Bundle bundle) {
		new Thread(() -> {
			Utf8ResourceBundle.removeBundle(bundle);
			logger.info("bundle #{} - remove message for bundle", bundle.getSymbolicName());
		}).start();
	}

	private static boolean hasBundleMessages(Bundle bundle) {
		return bundle.getEntry(LOCALIZATION) != null;
	}
}

package com.icteam.loyalty.common.internal.tracker;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

import com.icteam.loyalty.common.nls.Utf8ResourceBundle;

public class MessageTracker extends BundleTracker<Bundle> {

	private static final String LOCALIZATION = "OSGI-INF/l10n";
	private final Logger logger = Log.getLogger(MessageTracker.class);

	public MessageTracker(BundleContext context) {
		super(context, Bundle.ACTIVE | Bundle.UNINSTALLED, null);
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event, Bundle object) {
		if (hasBundleMessages(bundle)) {
			removeMessageBundle(bundle);
		}

		super.removedBundle(bundle, event, object);
	}

	private void removeMessageBundle(final Bundle bundle) {
		new Thread(() -> {
			Utf8ResourceBundle.removeBundle(bundle);
			logger.info("bundle #{} - remove message bundle", bundle.getSymbolicName());
		}).start();
	}

	private static boolean hasBundleMessages(Bundle bundle) {
		return bundle.getEntry(LOCALIZATION) != null;
	}
}

package com.icteam.loyalty.ui.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

import com.icteam.loyalty.ui.provider.xmi.LoyaltyViewModelFileExtensionsManager;

public class EMFTracker extends BundleTracker<Bundle> {

    public EMFTracker(BundleContext context) {
        super(context, Bundle.ACTIVE, null);
    }

    @Override
    public void removedBundle(Bundle bundle, BundleEvent event, Bundle object) {
        if (hasEMFPlugin(bundle)) {
            resetViewModelFIleExtensionManager(bundle);
        }

        super.removedBundle(bundle, event, object);
    }

    static List<String> getNsURIs(Bundle bundle) {
        String bundleName = bundle.getSymbolicName();

        IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
                EcorePlugin.INSTANCE.getSymbolicName() + "." + EcorePlugin.GENERATED_PACKAGE_PPID);

        List<String> nsURIs = new ArrayList<>();

        for (IConfigurationElement configurationElement : configurationElements) {
            if (bundleName.equals(configurationElement.getContributor().getName())) {
                nsURIs.add(configurationElement.getAttribute("uri"));
            }
        }

        return nsURIs;
    }

    private static void resetViewModelFIleExtensionManager(final Bundle bundle) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> nsURIs = getNsURIs(bundle);

                if (!nsURIs.isEmpty()) {
                    LoyaltyViewModelFileExtensionsManager.dispose();
                }
            }
        }).start();
    }

    private static boolean hasEMFPlugin(Bundle bundle) {
        return bundle.getEntry("plugin.xml") != null;
    }
}

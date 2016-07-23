/**
 */
package com.icteam.loyalty.ui.provider;

import java.util.Locale;
import java.util.MissingResourceException;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.emf.ecp.view.spi.model.provider.ViewEditPlugin;
import org.osgi.framework.BundleContext;

import com.icteam.loyalty.model.provider.ModelEditPlugin;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.interfaces.UIInterfacesPackage;
import com.icteam.loyalty.ui.internal.EMFTracker;
import com.icteam.loyalty.ui.internal.IconTracker;
import com.icteam.loyalty.ui.model.UIModelPackage;

/**
 * This is the central singleton for the Ui edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class UIEditPlugin extends EMFPlugin {
    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final UIEditPlugin INSTANCE = new UIEditPlugin();

    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static Implementation plugin;

    /**
     * Create the instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UIEditPlugin() {
        super(new ResourceLocator[] { EcoreEditPlugin.INSTANCE, ModelEditPlugin.INSTANCE, ViewEditPlugin.INSTANCE, });
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    @Override
    public ResourceLocator getPluginResourceLocator() {
        return plugin;
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    public static Implementation getPlugin() {
        return plugin;
    }

    @Override
    public String getString(String key, boolean translate) {
        String localeString = ModelUtil.getRAPLocaleString(translate);

        String result = null;
        if (localeString != null) {
            try {
                result = getPluginResourceLocator().getString(key, translate);
            } catch (MissingResourceException mre) {
                result = delegatedGetString(key, translate);
            }
        } else {
            result = super.getString(key, translate);
        }

        return result;
    }

    /**
     * The actual implementation of the Eclipse <b>Plugin</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static class Implementation extends EclipsePlugin {

        private IconTracker iconTracker;
        private EMFTracker emfTracker;

        /**
         * Creates an instance.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Implementation() {
            super();

            // Remember the static instance.
            //
            plugin = this;
        }

        @Override
        public void start(BundleContext context) throws Exception {
            this.iconTracker = new IconTracker(context);
            this.iconTracker.open();

            this.emfTracker = new EMFTracker(context);
            this.emfTracker.open();

            UIInterfacesPackage.eINSTANCE.getName();
            UIModelPackage.eINSTANCE.getName();
        }

        @Override
        public void stop(BundleContext context) throws Exception {
            this.iconTracker.close();
            this.emfTracker.close();

            UIInterfacesPackage.eINSTANCE.dispose();
            UIModelPackage.eINSTANCE.dispose();

        }

        @Override
        public String getString(String key, boolean translate) {
            Locale locale = ModelUtil.getRAPLocale(translate);

            if (locale != null) {
                return org.eclipse.core.internal.runtime.Activator.getDefault().getLocalization(getBundle(), locale.getLanguage()).getString(key);
            }

            return super.getString(key, translate);
        }

    }

}

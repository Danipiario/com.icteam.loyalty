package com.icteam.loyalty.ui.provider.xmi;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecp.view.model.provider.xmi.ViewModelFileExtensionsManager;
import org.eclipse.emf.ecp.view.spi.model.VView;

/**
 * Manages the view models provided by the file extension point.
 *
 * @author Daniele Pirola
 *
 *
 */
public final class LoyaltyViewModelFileExtensionsManager {

    static final class ExtensionDescription {
        private final Map<String, String> keyValuPairs;
        private final String bundleId;

        private ExtensionDescription(Map<String, String> keyValuPairs, String bundleId) {
            this.keyValuPairs = keyValuPairs;
            this.bundleId = bundleId;
        }

        /**
         * Return the KeyValuePairs defined in the extension point.
         *
         * @return The KeyValuePair Map
         */
        Map<String, String> getKeyValuPairs() {
            return keyValuPairs;
        }

        /**
         * The Bundle Id of the bundle contributing the extension point.
         *
         * @return The BundleId
         */
        String getBundleId() {
            return bundleId;
        }
    }

    private static final String FILTER_VALUE_ATTRIBUTE = "value"; //$NON-NLS-1$
    private static final String FILTER_KEY_ATTRIBUTE = "key"; //$NON-NLS-1$
    private static final String FILTER_ELEMENT = "filter"; //$NON-NLS-1$
    private static final String FILE_EXTENSION = "org.eclipse.emf.ecp.view.model.provider.xmi.file"; //$NON-NLS-1$
    private static final String FILEPATH_ATTRIBUTE = "filePath"; //$NON-NLS-1$

    private final Map<EClass, Map<VView, Map<String, String>>> map = new LinkedHashMap<>();

    private LoyaltyViewModelFileExtensionsManager() {
    }

    private static LoyaltyViewModelFileExtensionsManager instance;

    /**
     * @return the iNSTANCE
     */
    public static LoyaltyViewModelFileExtensionsManager getInstance() {
        if (instance == null) {
            instance = new LoyaltyViewModelFileExtensionsManager();
            instance.init();
        }
        return instance;
    }

    public static Map<URI, ExtensionDescription> getExtensionURIS() {
        final Map<URI, ExtensionDescription> ret = new LinkedHashMap<URI, ExtensionDescription>();
        final IConfigurationElement[] files = Platform.getExtensionRegistry().getConfigurationElementsFor(FILE_EXTENSION);
        final URIConverter converter = new ResourceSetImpl().getURIConverter();
        for (final IConfigurationElement file : files) {
            final String bundleId = file.getContributor().getName();
            final String filePath = file.getAttribute(FILEPATH_ATTRIBUTE);

            final IConfigurationElement[] children = file.getChildren(FILTER_ELEMENT);
            final Map<String, String> keyValuePairs = new LinkedHashMap<String, String>();
            for (final IConfigurationElement child : children) {
                final String key = child.getAttribute(FILTER_KEY_ATTRIBUTE);
                final String value = child.getAttribute(FILTER_VALUE_ATTRIBUTE);
                keyValuePairs.put(key, value);
            }

            URI uri;
            final String bundleName = file.getContributor().getName();
            final String path = bundleName + '/' + filePath;
            uri = URI.createPlatformPluginURI(path, false);
            if (converter.exists(uri, null)) {
                ret.put(uri, new ExtensionDescription(keyValuePairs, bundleId));
            } else {
                uri = URI.createPlatformResourceURI(filePath, false);
                if (converter.exists(uri, null)) {
                    ret.put(uri, new ExtensionDescription(keyValuePairs, bundleId));
                }
            }

        }
        return ret;
    }

    /**
     *
     */
    private void init() {
        final Map<URI, ExtensionDescription> extensionURIS = getExtensionURIS();
        for (final URI uri : extensionURIS.keySet()) {
            final ExtensionDescription extensionDescription = extensionURIS.get(uri);
            final Resource resource = ViewModelFileExtensionsManager.loadResource(uri);
            final EObject eObject = resource.getContents().get(0);
            if (!(eObject instanceof VView)) {
                // TODO:log
                continue;
            }
            final VView view = (VView) eObject;
            if (view.getRootEClass() == null) {
                // TODO:log
                continue;
            }
            if (!map.containsKey(view.getRootEClass())) {
                map.put(view.getRootEClass(), new LinkedHashMap<VView, Map<String, String>>());
            }
            map.get(view.getRootEClass()).put(view, extensionDescription.getKeyValuPairs());
        }

    }

    /**
     * Disposed the instance.
     */
    public static void dispose() {
        instance = null;
    }

    /**
     * @param eObject the object to be rendered
     * @param context a key-value-map from String to Object
     * @return if there is a xmi file registered containing a view model for the given type
     */
    public boolean hasViewModelFor(EObject eObject, Map<String, Object> context) {
        return findEClassViewModelFor(eObject.eClass()) != null;
    }

    private EClass findEClassViewModelFor(EClass eClass) {
        if (map.containsKey(eClass)) {
            return eClass;
        }

        for (EClass superEClass : eClass.getESuperTypes()) {
            if (!superEClass.equals(EcorePackage.Literals.EOBJECT)) {
                if (findEClassViewModelFor(superEClass) != null) {
                    return superEClass;
                }
            }
        }

        return null;
    }

    /**
     * @param eObject The {@link EObject} to create a view for
     * @param context a key-value-map from String to Object
     * @return a view model for the given eObject
     */
    public VView createView(EObject eObject, Map<String, Object> context) {
        EClass eClass = findEClassViewModelFor(eObject.eClass());

        final Map<VView, Map<String, String>> viewMap = map.get(eClass);
        if (context == null) {
            return viewMap.keySet().iterator().next();
        }
        VView bestFitting = null;
        int maxNumberFittingKeyValues = -1;
        for (final VView view : viewMap.keySet()) {
            final Map<String, String> viewFilter = viewMap.get(view);
            int currentFittingKeyValues = 0;
            for (final String viewFilterKey : viewFilter.keySet()) {
                if (context.containsKey(viewFilterKey)) {
                    final Object contextValue = context.get(viewFilterKey);
                    final String viewFilterValue = viewFilter.get(viewFilterKey);
                    if (contextValue.toString().equalsIgnoreCase(viewFilterValue)) {
                        currentFittingKeyValues++;
                    } else {
                        currentFittingKeyValues = -1;
                        break;
                    }
                } else {
                    currentFittingKeyValues = -1;
                    break;
                }
            }
            if (currentFittingKeyValues > maxNumberFittingKeyValues) {
                maxNumberFittingKeyValues = currentFittingKeyValues;
                bestFitting = view;
            }
        }

        return EcoreUtil.copy(bestFitting);
    }

}

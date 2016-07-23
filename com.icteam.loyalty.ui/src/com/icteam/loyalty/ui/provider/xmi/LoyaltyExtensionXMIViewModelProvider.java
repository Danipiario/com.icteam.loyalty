package com.icteam.loyalty.ui.provider.xmi;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.provider.IViewProvider;

/**
 * An {@link IViewProvider} which loads view models from extension points.
 *
 * @author Jonas Helming
 *
 */
public class LoyaltyExtensionXMIViewModelProvider implements IViewProvider {

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.ecp.view.spi.provider.IViewProvider#canRender(EObject, Map)
     */
    @Override
    public int canRender(EObject eObject, Map<String, Object> context) {
        if (LoyaltyViewModelFileExtensionsManager.getInstance().hasViewModelFor(eObject, context)) {
            return 10;
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.ecp.view.spi.provider.IViewProvider#generate(EObject, Map)
     */
    @Override
    public VView generate(EObject eObject, Map<String, Object> context) {
        return LoyaltyViewModelFileExtensionsManager.getInstance().createView(eObject, context);
    }

}

package com.icteam.loyalty.ui.model;

import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VElement;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emfforms.spi.swt.core.AbstractSWTRenderer;
import org.eclipse.emfforms.spi.swt.core.di.EMFFormsDIRendererService;
import org.osgi.service.component.annotations.Component;

import com.icteam.loyalty.ui.control.LoyaltyViewSWTRenderer;

@Component(service = EMFFormsDIRendererService.class)
public class ViewRendererService implements EMFFormsDIRendererService<VView> {
    @Override
    public double isApplicable(VElement vElement, ViewModelContext viewModelContext) {
        if (!VView.class.isInstance(vElement)) {
            return NOT_APPLICABLE;
        }

        return 10d;
    }

    @Override
    public Class< ? extends AbstractSWTRenderer<VView>> getRendererClass() {
        return LoyaltyViewSWTRenderer.class;
    }
}
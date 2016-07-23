package com.icteam.loyalty.ui.model;

import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.group.model.VGroup;
import org.eclipse.emf.ecp.view.spi.model.VElement;
import org.eclipse.emfforms.spi.swt.core.AbstractSWTRenderer;
import org.eclipse.emfforms.spi.swt.core.di.EMFFormsDIRendererService;
import org.osgi.service.component.annotations.Component;

import com.icteam.loyalty.ui.control.CustomGroupSWTRenderer;

@Component(service = EMFFormsDIRendererService.class)
public class GroupRendererService implements EMFFormsDIRendererService<VGroup> {
    @Override
    public double isApplicable(VElement vElement, ViewModelContext viewModelContext) {
        if (!VGroup.class.isInstance(vElement)) {
            return NOT_APPLICABLE;
        }

        return 10d;
    }

    @Override
    public Class< ? extends AbstractSWTRenderer<VGroup>> getRendererClass() {
        return CustomGroupSWTRenderer.class;
    }
}
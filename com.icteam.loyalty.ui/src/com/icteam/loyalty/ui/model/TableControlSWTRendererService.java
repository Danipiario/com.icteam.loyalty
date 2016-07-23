package com.icteam.loyalty.ui.model;

import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VElement;
import org.eclipse.emf.ecp.view.spi.table.model.VTableControl;
import org.eclipse.emfforms.spi.swt.core.AbstractSWTRenderer;
import org.eclipse.emfforms.spi.swt.core.di.EMFFormsDIRendererService;
import org.osgi.service.component.annotations.Component;

import com.icteam.loyalty.ui.control.TableControlSWTRenderer;

@Component(service = EMFFormsDIRendererService.class)
public class TableControlSWTRendererService implements EMFFormsDIRendererService<VTableControl> {

    @Override
    public Class< ? extends AbstractSWTRenderer<VTableControl>> getRendererClass() {
        return (Class< ? extends AbstractSWTRenderer<VTableControl>>) TableControlSWTRenderer.class;
    }

    @Override
    public double isApplicable(VElement vElement, ViewModelContext context) {
        if (VTableControl.class.isInstance(vElement)) {
            return 10d;
        }

        return NOT_APPLICABLE;
    }

}
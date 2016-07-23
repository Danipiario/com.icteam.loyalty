package com.icteam.loyalty.ui.model;

import org.eclipse.emf.ecp.view.internal.core.swt.renderer.TextControlSWTRendererService;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.model.VElement;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.swt.core.AbstractSWTRenderer;
import org.eclipse.emfforms.spi.swt.core.di.EMFFormsDIRendererService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.icteam.loyalty.ui.control.TextControlRenderer;

@Component(service = EMFFormsDIRendererService.class)
public class TextControlRendererService extends TextControlSWTRendererService {

    @Override
    public Class< ? extends AbstractSWTRenderer<VControl>> getRendererClass() {
        return TextControlRenderer.class;
    }

    @Override
    @Reference(service = org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding.class, name = "EMFFormsDatabinding", policy = ReferencePolicy.STATIC)
    protected void setEMFFormsDatabinding(EMFFormsDatabinding databindingService) {
        super.setEMFFormsDatabinding(databindingService);
    }

    @Override
    @Reference(service = org.eclipse.emfforms.spi.common.report.ReportService.class, name = "ReportService", policy = ReferencePolicy.STATIC)
    protected void setReportService(ReportService reportService) {
        super.setReportService(reportService);
    }

    @Override
    public double isApplicable(VElement vElement, ViewModelContext viewModelContext) {
        double priority = super.isApplicable(vElement, viewModelContext);

        if (!Double.isNaN(priority)) {
            priority = 10d;
        }

        return priority;
    }
}

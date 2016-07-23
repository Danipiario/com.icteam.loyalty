package com.icteam.loyalty.ui.control;

import javax.inject.Inject;

import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.editsupport.EMFFormsEditSupport;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.swt.SWT;

public class PasswordTextControlRenderer extends TextControlRenderer {

    @Inject
    public PasswordTextControlRenderer(VControl vElement, ViewModelContext viewContext, ReportService reportService, EMFFormsDatabinding emfFormsDatabinding,
            EMFFormsLabelProvider emfFormsLabelProvider, VTViewTemplateProvider vtViewTemplateProvider, EMFFormsEditSupport emfFormsEditSupport) {
        super(vElement, viewContext, reportService, emfFormsDatabinding, emfFormsLabelProvider, vtViewTemplateProvider, emfFormsEditSupport);

    }

    @Override
    protected int getTextWidgetStyle() {
        return super.getTextWidgetStyle() | SWT.PASSWORD;
    }
}

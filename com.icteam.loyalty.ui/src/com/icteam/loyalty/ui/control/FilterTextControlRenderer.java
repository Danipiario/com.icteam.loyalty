package com.icteam.loyalty.ui.control;

import javax.inject.Inject;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.renderer.TextControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.editsupport.EMFFormsEditSupport;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;

public class FilterTextControlRenderer extends TextControlSWTRenderer {

    @Inject
    public FilterTextControlRenderer(VControl vElement, ViewModelContext viewContext, ReportService reportService, EMFFormsDatabinding emfFormsDatabinding,
            EMFFormsLabelProvider emfFormsLabelProvider, VTViewTemplateProvider vtViewTemplateProvider, EMFFormsEditSupport emfFormsEditSupport) {
        super(vElement, viewContext, reportService, emfFormsDatabinding, emfFormsLabelProvider, vtViewTemplateProvider, emfFormsEditSupport);
    }

    @Override
    protected int getTextWidgetStyle() {
        return super.getTextWidgetStyle() | SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL;
    }

    @Override
    protected Binding bindValue(Control text, IObservableValue modelValue, DataBindingContext dataBindingContext, UpdateValueStrategy targetToModel,
            UpdateValueStrategy modelToTarget) {
        final IObservableValue value = SWTObservables.observeText(text, SWT.DefaultSelection);
        final Binding binding = dataBindingContext.bindValue(value, modelValue, targetToModel, modelToTarget);
        return binding;
    }
}

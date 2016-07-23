package com.icteam.loyalty.ui.model;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.model.VElement;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.swt.core.AbstractSWTRenderer;
import org.eclipse.emfforms.spi.swt.core.di.EMFFormsDIRendererService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.icteam.loyalty.model.interfaces.EAnnotation;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.control.PasswordTextControlRenderer;
import com.icteam.loyalty.ui.util.UIUtils;

@Component(service = EMFFormsDIRendererService.class)
public class PasswordTextControlRendererService implements EMFFormsDIRendererService<VControl> {

    private EMFFormsDatabinding databindingService;

    @Override
    public Class< ? extends AbstractSWTRenderer<VControl>> getRendererClass() {
        return PasswordTextControlRenderer.class;
    }

    @Reference(service = org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding.class, name = "EMFFormsDatabinding", policy = ReferencePolicy.STATIC)
    protected void setEMFFormsDatabinding(EMFFormsDatabinding databindingService) {
        this.databindingService = databindingService;
    }

    public double isApplicableForFeature(EStructuralFeature feature, VElement vElement, ViewModelContext context) {
        if ((Boolean) ModelUtil.getAnnotation(feature, EAnnotation.PASSWORD)) {
            return 10d;
        }

        return NOT_APPLICABLE;
    }

    @Override
    public double isApplicable(VElement vElement, ViewModelContext context) {
        if (!VControl.class.isInstance(vElement)) {
            return NOT_APPLICABLE;
        }

        EStructuralFeature feature = UIUtils.getEStructuralFeature(databindingService, (VControl) vElement, context);

        return isApplicableForFeature(feature, vElement, context);
    }

}
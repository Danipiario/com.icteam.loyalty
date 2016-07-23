package com.icteam.loyalty.ui.control;

import java.util.Collection;
import java.util.Set;

import javax.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecp.edit.internal.swt.Activator;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.ContainerSWTRenderer;
import org.eclipse.emf.ecp.view.spi.group.model.VGroup;
import org.eclipse.emf.ecp.view.spi.model.VContainedElement;
import org.eclipse.emf.ecp.view.spi.model.VFeaturePathDomainModelReference;
import org.eclipse.emf.ecp.view.spi.swt.layout.LayoutProviderHelper;
import org.eclipse.emf.ecp.view.template.model.VTStyleProperty;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emf.ecp.view.template.style.mandatory.model.VTMandatoryFactory;
import org.eclipse.emf.ecp.view.template.style.mandatory.model.VTMandatoryStyleProperty;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.swt.core.EMFFormsRendererFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Layout;

import com.icteam.loyalty.model.interfaces.IContainedFeature;
import com.icteam.loyalty.model.provider.LoyaltyItemProviderAdapter;
import com.icteam.loyalty.ui.util.UIUtils;

/**
 * Renders a SWT group.
 *
 * @since 1.3
 *
 */
public class CustomGroupSWTRenderer extends ContainerSWTRenderer<VGroup> {
    private static final String CONTROL_GROUP = "org_eclipse_emf_ecp_ui_control_group"; //$NON-NLS-1$

    @Inject
    public CustomGroupSWTRenderer(VGroup vElement, ViewModelContext viewContext, ReportService reportService, EMFFormsRendererFactory factory,
            EMFFormsDatabinding emfFormsDatabinding) {
        super(vElement, viewContext, reportService, factory, emfFormsDatabinding);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.ecp.view.spi.core.swt.ContainerSWTRenderer#getCustomVariant()
     */
    @Override
    protected String getCustomVariant() {
        return CONTROL_GROUP;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.ecp.view.spi.core.swt.ContainerSWTRenderer#getChildren()
     */

    @Override
    protected Collection<VContainedElement> getChildren() {
        return getVElement().getChildren();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.ecp.view.spi.core.swt.ContainerSWTRenderer#getComposite(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Composite getComposite(Composite parent) {
        final Group group = new Group(parent, SWT.TITLE);

        EObject model = getViewModelContext().getDomainModel();

        EObject eObject = model;
        EStructuralFeature feature = null;

        if (model instanceof IContainedFeature) {
            IContainedFeature contained = (IContainedFeature) model;

            eObject = contained.getMainEObject();
            feature = contained.getMainFeature();
        } else {
            String name = getVElement().getName();

            if (name != null) {
                VFeaturePathDomainModelReference featurePathDomainModelReference = UIUtils.calculateFeaturePathDomainModelReference(eObject.eClass(), name);

                if (featurePathDomainModelReference != null) {
                    Setting setting = UIUtils.getLastFeatureSetting(featurePathDomainModelReference, eObject);

                    if (setting != null) {
                        eObject = setting.getEObject();
                        feature = setting.getEStructuralFeature();
                    }
                }
            }
        }

        if (feature != null) {
            IItemPropertyDescriptor itemPropertyDescriptor = LoyaltyItemProviderAdapter.getItemPropertyDescriptor(eObject, feature);

            String text = itemPropertyDescriptor.getDisplayName(null);

            String extra = ""; //$NON-NLS-1$
            final VTMandatoryStyleProperty mandatoryStyle = getMandatoryStyle();
            if (mandatoryStyle.isHighliteMandatoryFields() && feature.getLowerBound() > 0) {
                extra = mandatoryStyle.getMandatoryMarker();
            }

            group.setText(text + extra);
        }

        return group;
    }

    @Override
    protected Layout getLayout(int numControls, boolean equalWidth) {
        return LayoutProviderHelper.getColumnLayout(numControls, equalWidth);
    }

    private VTMandatoryStyleProperty getMandatoryStyle() {
        final VTViewTemplateProvider vtViewTemplateProvider = Activator.getDefault().getVTViewTemplateProvider();
        if (vtViewTemplateProvider == null) {
            return getDefaultStyle();
        }
        final Set<VTStyleProperty> styleProperties = vtViewTemplateProvider.getStyleProperties(getVElement(), getViewModelContext());
        for (final VTStyleProperty styleProperty : styleProperties) {
            if (VTMandatoryStyleProperty.class.isInstance(styleProperty)) {
                return (VTMandatoryStyleProperty) styleProperty;
            }
        }
        return getDefaultStyle();
    }

    private static VTMandatoryStyleProperty getDefaultStyle() {
        return VTMandatoryFactory.eINSTANCE.createMandatoryStyleProperty();
    }
}

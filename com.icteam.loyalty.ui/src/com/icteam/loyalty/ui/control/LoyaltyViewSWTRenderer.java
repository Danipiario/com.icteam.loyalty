package com.icteam.loyalty.ui.control;

import java.util.Collection;

import javax.inject.Inject;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.ContainerSWTRenderer;
import org.eclipse.emf.ecp.view.spi.group.model.VGroup;
import org.eclipse.emf.ecp.view.spi.model.VContainedContainer;
import org.eclipse.emf.ecp.view.spi.model.VContainedElement;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.model.VElement;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.swt.core.EMFFormsRendererFactory;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridCell;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridDescription;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;

/**
 * The Class ViewSWTRenderer.
 */
public class LoyaltyViewSWTRenderer extends ContainerSWTRenderer<VView> {

    @Inject
    public LoyaltyViewSWTRenderer(VView vElement, ViewModelContext viewContext, ReportService reportService, EMFFormsRendererFactory factory,
            EMFFormsDatabinding emfFormsDatabinding) {
        super(vElement, viewContext, reportService, factory, emfFormsDatabinding);
    }

    @Override
    protected final void setLayoutDataForControl(SWTGridCell gridCell, SWTGridDescription controlGridDescription, SWTGridDescription currentRowGridDescription,
            SWTGridDescription fullGridDescription, VElement vElement, Control control) {
        if (VControl.class.isInstance(vElement) && !(control instanceof Group)) {
            // last column of control
            if (gridCell.getColumn() + gridCell.getHorizontalSpan() == controlGridDescription.getColumns()) {
                getControlGridData(gridCell.getHorizontalSpan() + fullGridDescription.getColumns() - currentRowGridDescription.getColumns(), VControl.class.cast(vElement), control)
                        .applyTo(control);
            } else if (controlGridDescription.getColumns() == 3 && gridCell.getColumn() == 0) {
                GridDataFactory.fillDefaults().grab(false, false).align(SWT.BEGINNING, SWT.CENTER).applyTo(control);
            } else if (controlGridDescription.getColumns() == 3 && gridCell.getColumn() == 1) {
                GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.CENTER).hint(0, 0).grab(false, false).applyTo(control);
            } else if (controlGridDescription.getColumns() == 2 && gridCell.getColumn() == 0) {
                GridDataFactory.fillDefaults().align(SWT.CENTER, SWT.CENTER).hint(0, 0).grab(false, false).applyTo(control);
            }
        } else if (VGroup.class.isInstance(vElement) || control instanceof Group) {
            GridDataFactory.fillDefaults().align(gridCell.isHorizontalFill() ? SWT.FILL : SWT.BEGINNING, gridCell.isVerticalFill() ? SWT.FILL : SWT.CENTER)
                    .grab(gridCell.isHorizontalGrab(), true).span(gridCell.getHorizontalSpan() + fullGridDescription.getColumns() - currentRowGridDescription.getColumns(), 1)
                    .applyTo(control);
        } else if (VContainedContainer.class.isInstance(vElement)) {
            GridDataFactory.fillDefaults().align(gridCell.isHorizontalFill() ? SWT.FILL : SWT.BEGINNING, gridCell.isVerticalFill() ? SWT.FILL : SWT.CENTER)
                    .grab(gridCell.isHorizontalGrab(), false).span(gridCell.getHorizontalSpan() + fullGridDescription.getColumns() - currentRowGridDescription.getColumns(), 1)
                    .applyTo(control);
        } else {
            // we have some kind of container -> render with necessary span
            GridDataFactory.fillDefaults().align(gridCell.isHorizontalFill() ? SWT.FILL : SWT.BEGINNING, gridCell.isVerticalFill() ? SWT.FILL : SWT.CENTER)
                    .grab(gridCell.isHorizontalGrab(), gridCell.isVerticalGrab())
                    .span(gridCell.getHorizontalSpan() + fullGridDescription.getColumns() - currentRowGridDescription.getColumns(), 1).applyTo(control);
        }

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

    @Override
    protected Layout getLayout(int numControls, boolean equalWidth) {
        return GridLayoutFactory.fillDefaults().numColumns(numControls).equalWidth(equalWidth).create();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.ecp.view.spi.core.swt.ContainerSWTRenderer#getCustomVariant()
     */
    @Override
    protected String getCustomVariant() {
        return "org_eclipse_emf_ecp_ui_layout_view"; //$NON-NLS-1$
    }

    private static GridDataFactory getControlGridData(int xSpan, VControl vControl, Control control) {
        GridDataFactory gdf = null;
//        if (VTableControl.class.isInstance(vControl)) {
        gdf = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.FILL).grab(true, true).span(xSpan, 1);
//        } else {
//            gdf = GridDataFactory.fillDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).span(xSpan, 1);
//        }

        if (Text.class.isInstance(control) && vControl.getDomainModelReference() != null) {
            final Setting setting = vControl.getDomainModelReference().getIterator().next();

            if (isMultiLine(setting)) {
                gdf = gdf.hint(50, 200); // set x hint to enable wrapping
            }
        }

        return gdf;
    }

    private static boolean isMultiLine(Setting setting) {
        final ComposedAdapterFactory composedAdapterFactory = new ComposedAdapterFactory(
                new AdapterFactory[] { new ReflectiveItemProviderAdapterFactory(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE) });
        final AdapterFactoryItemDelegator adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(composedAdapterFactory);
        final IItemPropertyDescriptor descriptor = adapterFactoryItemDelegator.getPropertyDescriptor(setting.getEObject(), setting.getEStructuralFeature());
        final boolean multiline = descriptor.isMultiLine(null);

        composedAdapterFactory.dispose();

        return multiline;

    }
}

package com.icteam.loyalty.ui.control;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecp.ui.view.ECPRendererException;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTView;
import org.eclipse.emf.ecp.ui.view.swt.ECPSWTViewRenderer;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContextFactory;
import org.eclipse.emf.ecp.view.spi.model.LabelAlignment;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.model.VElement;
import org.eclipse.emf.ecp.view.spi.model.VFeaturePathDomainModelReference;
import org.eclipse.emf.ecp.view.spi.model.VView;
import org.eclipse.emf.ecp.view.spi.model.VViewFactory;
import org.eclipse.emf.ecp.view.spi.provider.ViewProviderHelper;
import org.eclipse.emf.ecp.view.spi.renderer.NoPropertyDescriptorFoundExeption;
import org.eclipse.emf.ecp.view.spi.renderer.NoRendererFoundException;
import org.eclipse.emf.ecp.view.spi.table.model.VTableControl;
import org.eclipse.emf.ecp.view.spi.table.model.VTableDomainModelReference;
import org.eclipse.emf.ecp.view.spi.table.model.VTableFactory;
import org.eclipse.emfforms.spi.swt.core.AbstractSWTRenderer;
import org.eclipse.emfforms.spi.swt.core.EMFFormsNoRendererException;
import org.eclipse.emfforms.spi.swt.core.EMFFormsRendererFactory;
import org.eclipse.emfforms.spi.swt.core.layout.GridDescriptionFactory;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridDescription;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbenchPartSite;

public class SWTRenderUtil {

    public static final String SITE = "site";
//    private static SWTRendererFactory swtRendererFactory = new SWTRendererFactoryImpl();

    private static EMFFormsRendererFactory emfFormsRendererFactory = org.eclipse.emf.ecp.view.internal.swt.Activator.getDefault().getEMFFormsRendererFactory();

    private static void showLayoutData(Control control, int level) {
        System.out.println(StringUtils.repeat("\t", level) + "control #" + control + " - layout data #" + control.getLayoutData());

        if (control instanceof Composite) {
            Composite composite = (Composite) control;
            System.out.println(StringUtils.repeat("\t", level) + "layout #" + composite.getLayout());
            System.out.println(StringUtils.repeat("\t", level) + "children #" + composite.getChildren().length);

            level++;
            for (Control child : composite.getChildren()) {
                showLayoutData(child, level);
            }
            level--;
        }
    }

    public static ECPSWTView render(IWorkbenchPartSite site, Composite parent, EObject domainObject) {
        return render(site, parent, domainObject, ViewProviderHelper.getView(domainObject, null));
    }

    public static ECPSWTView render(IWorkbenchPartSite site, Composite parent, EObject domainObject, VView viewModel) {
        final ViewModelContext viewContext = ViewModelContextFactory.INSTANCE.createViewModelContext(viewModel, domainObject);
        return render(site, parent, viewContext);
    }

    public static ECPSWTView render(IWorkbenchPartSite site, Composite parent, ViewModelContext viewModelContext) {
        try {
            viewModelContext.putContextValue(SWTRenderUtil.SITE, site);

            return ECPSWTViewRenderer.INSTANCE.render(parent, viewModelContext);
        } catch (ECPRendererException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ECPSWTView render(IWorkbenchPartSite site, Composite parent, EObject domainObject, Map<String, Object> context) {
        final VView view = ViewProviderHelper.getView(domainObject, context);
        return render(site, parent, domainObject, view);
    }

    public static VElement createElement(EObject eObject, EStructuralFeature feature, LabelAlignment alignment) {
        VFeaturePathDomainModelReference domainModelReference = VViewFactory.eINSTANCE.createFeaturePathDomainModelReference();
        domainModelReference.setDomainModelEFeature(feature);

        if (eObject != null) {
            domainModelReference.init(eObject);
        }

        VControl control = VViewFactory.eINSTANCE.createControl();
        control.setDomainModelReference(domainModelReference);
        control.setLabelAlignment(alignment);

        return control;
    }

    public static VTableControl createTableControl(EObject eObject, EStructuralFeature feature, LabelAlignment alignment) {
        VTableDomainModelReference domainModelReference = VTableFactory.eINSTANCE.createTableDomainModelReference();
        domainModelReference.setDomainModelEFeature(feature);
        if (eObject != null) {
            domainModelReference.init(eObject);
        }

        VTableControl control = VTableFactory.eINSTANCE.createTableControl();
        control.setDomainModelReference(domainModelReference);
        control.setLabelAlignment(alignment);

        return control;
    }

    public static Control renderControl(Composite parent, EObject eObject, EStructuralFeature feature) {
        return renderControl(parent, eObject, feature, LabelAlignment.NONE);
    }

    public static Control renderControl(Composite parent, EObject eObject, EStructuralFeature feature, LabelAlignment alignment) {
        return renderControl(parent, eObject, feature, -1, alignment);
    }

    public static Control renderControl(Composite parent, EObject eObject, EStructuralFeature feature, int column) {
        return renderControl(parent, eObject, feature, column, LabelAlignment.NONE);
    }

    public static Control renderControl(Composite parent, EObject eObject, EStructuralFeature feature, int column, LabelAlignment alignment) {
        VElement element = createElement(eObject, feature, alignment);

        return renderControl(parent, eObject, element, column);
    }

    public static Control renderControl(Composite parent, EObject eObject, VElement element) {
        return renderControl(parent, eObject, element, -1);
    }

    public static Control renderControl(Composite parent, EObject eObject, VElement element, int column) {
        ViewModelContext context = createViewModelContext(null, element, eObject);

        try {
            AbstractSWTRenderer<VElement> renderer = emfFormsRendererFactory.getRendererInstance(element, context);
            SWTGridDescription gridDescription = renderer.getGridDescription(GridDescriptionFactory.INSTANCE.createEmptyGridDescription());

            if (column == -1) {
                return renderer.render(gridDescription.getGrid().get(gridDescription.getGrid().size() - 1), parent);
            }

            return renderer.render(gridDescription.getGrid().get(column), parent);
        } catch (NoRendererFoundException | NoPropertyDescriptorFoundExeption | EMFFormsNoRendererException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Control renderTableControl(IWorkbenchPartSite site, Composite parent, EObject eObject, EStructuralFeature feature) {
        return renderTableControl(site, parent, eObject, feature, LabelAlignment.NONE);
    }

    @SuppressWarnings("rawtypes")
    public static Control renderTableControl(IWorkbenchPartSite site, Composite parent, EObject eObject, EStructuralFeature feature, LabelAlignment alignment) {
        VElement element = createTableControl(eObject, feature, alignment);

        ViewModelContext context = createViewModelContext(site, element, eObject);

        Control control = null;

        try {
            TableControlSWTRenderer< ? , ? > renderer = (TableControlSWTRenderer) emfFormsRendererFactory.getRendererInstance(element, context);
            SWTGridDescription gridDescription = renderer.getGridDescription(GridDescriptionFactory.INSTANCE.createEmptyGridDescription());

            control = renderer.render(gridDescription.getGrid().get(gridDescription.getGrid().size() - 1), parent);
        } catch (NoRendererFoundException | NoPropertyDescriptorFoundExeption | EMFFormsNoRendererException e) {
            e.printStackTrace();
        }

        return control;
    }

    private static ViewModelContext createViewModelContext(IWorkbenchPartSite site, VElement element, EObject domainObject) {
        ViewModelContext viewModelContext = ViewModelContextFactory.INSTANCE.createViewModelContext(element, domainObject);
        viewModelContext.putContextValue(SITE, site);

        return viewModelContext;
    }

}

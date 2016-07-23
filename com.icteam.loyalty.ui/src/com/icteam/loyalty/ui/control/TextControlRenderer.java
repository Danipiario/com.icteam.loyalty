package com.icteam.loyalty.ui.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecp.view.model.common.edit.provider.CustomReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.renderer.TextControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.editsupport.EMFFormsEditSupport;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.widgets.Control;

import com.icteam.loyalty.model.interfaces.IEditable;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.ui.util.UIUtils;

public class TextControlRenderer extends TextControlSWTRenderer {

    private final AdapterFactoryItemDelegator adapterFactoryItemDelegator;
    private final ComposedAdapterFactory composedAdapterFactory;

    @Inject
    public TextControlRenderer(VControl vElement, ViewModelContext viewContext, ReportService reportService, EMFFormsDatabinding emfFormsDatabinding,
            EMFFormsLabelProvider emfFormsLabelProvider, VTViewTemplateProvider vtViewTemplateProvider, EMFFormsEditSupport emfFormsEditSupport) {
        super(vElement, viewContext, reportService, emfFormsDatabinding, emfFormsLabelProvider, vtViewTemplateProvider, emfFormsEditSupport);

        composedAdapterFactory = new ComposedAdapterFactory(
                new AdapterFactory[] { new CustomReflectiveItemProviderAdapterFactory(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE) });
        adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(composedAdapterFactory);
    }

    protected final IItemPropertyDescriptor getItemPropertyDescriptor() {
        Setting setting = UIUtils.getLastFeatureSetting(getVElement().getDomainModelReference(), getViewModelContext().getDomainModel());

        return adapterFactoryItemDelegator.getPropertyDescriptor(setting.getEObject(), setting.getEStructuralFeature());
    }

    protected EStructuralFeature getEStructuralFeature() {
        return UIUtils.getEStructuralFeature(getEMFFormsDatabinding(), getVElement(), getViewModelContext());
    }

    @Override
    protected Binding[] createBindings(Control control) throws DatabindingFailedException {
        List<Binding> bindings = new ArrayList<>(Arrays.asList(super.createBindings(control)));

        final IObservableValue changeableObserveValue = EMFProperties.value(EcorePackage.Literals.ESTRUCTURAL_FEATURE__CHANGEABLE).observe(getEStructuralFeature());
        final boolean readonly = getVElement().isReadonly();

        if (getViewModelContext().getDomainModel() instanceof IEditable) {
            final IObservableValue editableModelObserveValue = EMFObservables.observeValue(getViewModelContext().getDomainModel(),
                    ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);

            IObservableValue computedEditableValue = new ComputedValue() {
                @Override
                protected Object calculate() {
                    return (Boolean) editableModelObserveValue.getValue() && (Boolean) changeableObserveValue.getValue() && !readonly;
                }
            };

            bindings.add(getDataBindingContext().bindValue(SWTObservables.observeEnabled(control), computedEditableValue));
            if (!getVElement().isReadonly()) {
                getVElement().setReadonly(!(Boolean) computedEditableValue.getValue());
            }
        } else {
            IObservableValue computedEditableValue = new ComputedValue() {
                @Override
                protected Object calculate() {
                    return (Boolean) changeableObserveValue.getValue() && !readonly;
                }
            };

            bindings.add(getDataBindingContext().bindValue(SWTObservables.observeEnabled(control), computedEditableValue));
            if (!getVElement().isReadonly()) {
                getVElement().setReadonly(!(Boolean) changeableObserveValue.getValue());
            }
        }

        return bindings.toArray(new Binding[] {});
    }

}

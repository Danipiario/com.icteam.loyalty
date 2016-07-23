package com.icteam.loyalty.ui.control;

import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.emf.ecp.view.internal.core.swt.MessageKeys;
import org.eclipse.emf.ecp.view.model.common.edit.provider.CustomReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.SimpleControlJFaceViewerSWTRenderer;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.emfforms.spi.localization.LocalizationServiceHelper;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Composite;

import com.icteam.loyalty.model.interfaces.IEditable;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.ui.util.UIUtils;

public class EnhancedEnumComboViewerRenderer extends SimpleControlJFaceViewerSWTRenderer {

    private final AdapterFactoryItemDelegator adapterFactoryItemDelegator;
    private final ComposedAdapterFactory composedAdapterFactory;
    private final Setting setting;

    @Inject
    public EnhancedEnumComboViewerRenderer(VControl vElement, ViewModelContext viewContext, ReportService reportService, EMFFormsDatabinding emfFormsDatabinding,
            EMFFormsLabelProvider emfFormsLabelProvider, VTViewTemplateProvider vtViewTemplateProvider) {
        super(vElement, viewContext, reportService, emfFormsDatabinding, emfFormsLabelProvider, vtViewTemplateProvider);

        composedAdapterFactory = new ComposedAdapterFactory(
                new AdapterFactory[] { new CustomReflectiveItemProviderAdapterFactory(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE) });
        adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(composedAdapterFactory);

        setting = UIUtils.getLastFeatureSetting(getVElement().getDomainModelReference(), getViewModelContext().getDomainModel());
    }

    protected final IItemPropertyDescriptor getItemPropertyDescriptor() {
        return adapterFactoryItemDelegator.getPropertyDescriptor(setting.getEObject(), setting.getEStructuralFeature());
    }

    protected EStructuralFeature getEStructuralFeature() {
        return UIUtils.getEStructuralFeature(getEMFFormsDatabinding(), getVElement(), getViewModelContext());
    }

    @Override
    protected Binding[] createBindings(Viewer viewer) throws DatabindingFailedException {
        List<Binding> bindings = new ArrayList<>();

        bindings.add(getDataBindingContext().bindValue(ViewersObservables.observeSingleSelection(viewer), getModelValue()));

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

            bindings.add(getDataBindingContext().bindValue(SWTObservables.observeEnabled(viewer.getControl()), computedEditableValue));
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

            bindings.add(getDataBindingContext().bindValue(SWTObservables.observeEnabled(viewer.getControl()), computedEditableValue));
            if (!getVElement().isReadonly()) {
                getVElement().setReadonly(!(Boolean) changeableObserveValue.getValue());
            }
        }

        return bindings.toArray(new Binding[] {});
    }

    /**
     * {@inheritDoc}
     * @throws DatabindingFailedException
     *
     * @see org.eclipse.emf.ecp.view.spi.core.swt.SimpleControlJFaceViewerSWTRenderer#createJFaceViewer(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Viewer createJFaceViewer(Composite parent) throws DatabindingFailedException {
        final ComboViewer combo = new ComboViewer(parent);

        IItemPropertyDescriptor itemPropertyDescriptor = getItemPropertyDescriptor();
        final IItemLabelProvider labelProvider = itemPropertyDescriptor.getLabelProvider(null);
        combo.setContentProvider(new ArrayContentProvider());
        combo.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                return labelProvider.getText(element);
            }
        });

        Collection< ? > input = itemPropertyDescriptor.getChoiceOfValues(setting.getEObject());
        combo.setInput(input);

        selectFirstElement(combo, input);

        combo.setData(CUSTOM_VARIANT, "org_eclipse_emf_ecp_control_enum"); //$NON-NLS-1$
        return combo;
    }

    private void selectFirstElement(final ComboViewer combo, Collection< ? > input) {
        if (setting.getEStructuralFeature().isRequired() && combo.getSelection().isEmpty() && !input.isEmpty()) {
            combo.setSelection(new StructuredSelection(input.iterator().next()));
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.ecp.view.spi.core.swt.SimpleControlSWTRenderer#getUnsetText()
     */
    @Override
    protected String getUnsetText() {
        return LocalizationServiceHelper.getString(getClass(), MessageKeys.EEnumControl_NoValueSetClickToSetValue);
    }

}

package com.icteam.loyalty.ui.control;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecp.view.model.common.edit.provider.CustomReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.AbstractControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.model.LabelAlignment;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.spi.renderer.NoPropertyDescriptorFoundExeption;
import org.eclipse.emf.ecp.view.spi.renderer.NoRendererFoundException;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.emfforms.spi.swt.core.layout.GridDescriptionFactory;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridCell;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridDescription;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.IEditable;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.ui.util.UIUtils;

public class CommandControlSWTControlSWTRenderer extends AbstractControlSWTRenderer<VControl> {

    private final AdapterFactoryItemDelegator adapterFactoryItemDelegator;
    private final ComposedAdapterFactory composedAdapterFactory;
    private SWTGridDescription rendererGridDescription;

    @Inject
    public CommandControlSWTControlSWTRenderer(VControl vElement, ViewModelContext viewContext, ReportService reportService, EMFFormsDatabinding emfFormsDatabinding,
            EMFFormsLabelProvider emfFormsLabelProvider, VTViewTemplateProvider vtViewTemplateProvider) {
        super(vElement, viewContext, reportService, emfFormsDatabinding, emfFormsLabelProvider, vtViewTemplateProvider);
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

    protected Binding[] createBindings(Control control) {
        List<Binding> bindings = new ArrayList<>();

        EStructuralFeature feature = getEStructuralFeature();
        EObject eObject = getViewModelContext().getDomainModel();
        final Action action = (Action) eObject.eGet(feature);

        final IObservableValue actionEditableObserveValue = EMFObservables.observeValue(action, ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);

        if (eObject instanceof IEditable) {
            final IObservableValue editableModelObserveValue = EMFObservables.observeValue(eObject, ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);

            IObservableValue observeEditableValue = new ComputedValue() {
                @Override
                protected Object calculate() {
                    return (Boolean) editableModelObserveValue.getValue() && (Boolean) actionEditableObserveValue.getValue();
                }
            };

            bindings.add(getDataBindingContext().bindValue(SWTObservables.observeEnabled(control), observeEditableValue));

            if (!getVElement().isReadonly()) {
                getVElement().setReadonly(!(Boolean) observeEditableValue.getValue());
            }
        } else {
            bindings.add(getDataBindingContext().bindValue(SWTObservables.observeEnabled(control), actionEditableObserveValue));
            if (!getVElement().isReadonly()) {
                getVElement().setReadonly(!(Boolean) actionEditableObserveValue.getValue());
            }
        }

        return bindings.toArray(new Binding[] {});
    }

    @Override
    public SWTGridDescription getGridDescription(SWTGridDescription gridDescription) {
        if (this.rendererGridDescription == null) {
            this.rendererGridDescription = GridDescriptionFactory.INSTANCE.createSimpleGrid(1, 1, this);
        }

        return this.rendererGridDescription;
    }

    @Override
    protected Control renderControl(SWTGridCell cell, Composite composite) {
        if (!getVElement().getDomainModelReference().getIterator().hasNext()) {
            return null;
        }

        Button command = new Button(composite, SWT.NONE);

        command.setData("org.eclipse.rap.rwt.customVariant", "org_eclipse_emf_ecp_control_action");
        GridDataFactory.defaultsFor(command).applyTo(command);

        IItemPropertyDescriptor itemPropertyDescriptor = getItemPropertyDescriptor();

        final IItemLabelProvider labelProvider = itemPropertyDescriptor.getLabelProvider(null);

        final EStructuralFeature feature = getEStructuralFeature();
        final EObject eObject = getViewModelContext().getDomainModel();
        final Action action = (Action) eObject.eGet(feature);

        command.setImage((Image) labelProvider.getImage(action));
        command.setToolTipText(labelProvider.getText(null));

        if (getVElement().getLabelAlignment() == LabelAlignment.LEFT) {
            command.setText(labelProvider.getText(null));
        }

        command.setVisible(action.isAllowed(eObject, feature));
//        command.setEnabled(itemPropertyDescriptor.canSetProperty(eObject));

        command.addSelectionListener(new SelectionAdapter() {
            private static final long serialVersionUID = 1L;

            @Override
            public void widgetSelected(SelectionEvent se) {
                action.execute(eObject, feature);
            }
        });

        return command;
    }

    @Override
    public Control render(SWTGridCell cell, Composite parent) throws NoRendererFoundException, NoPropertyDescriptorFoundExeption {
        Control control = super.render(cell, parent);

        final Binding[] bindings = createBindings(control);

        control.addDisposeListener(new DisposeListener() {
            @Override
            public void widgetDisposed(DisposeEvent e) {
                if (bindings != null) {
                    for (final Binding binding : bindings) {
                        binding.dispose();
                    }
                }

            }
        });

        return control;
    }

}

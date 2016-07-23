package com.icteam.loyalty.ui.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.EObjectObservableMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecp.edit.internal.swt.controls.TableViewerColumnBuilder;
import org.eclipse.emf.ecp.edit.internal.swt.util.CellEditorFactory;
import org.eclipse.emf.ecp.edit.spi.swt.table.ECPCellEditor;
import org.eclipse.emf.ecp.view.model.common.edit.provider.CustomReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.AbstractControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.model.LabelAlignment;
import org.eclipse.emf.ecp.view.spi.model.VDiagnostic;
import org.eclipse.emf.ecp.view.spi.model.VDomainModelReference;
import org.eclipse.emf.ecp.view.spi.model.VFeaturePathDomainModelReference;
import org.eclipse.emf.ecp.view.spi.table.model.VTableControl;
import org.eclipse.emf.ecp.view.spi.table.model.VTableDomainModelReference;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.DatabindingFailedException;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.emfforms.spi.swt.core.layout.GridDescriptionFactory;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridCell;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridDescription;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.internal.databinding.swt.TableColumnWidthProperty;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.menus.MenuLocationURI;
import org.eclipse.ui.internal.menus.WorkbenchMenuService;
import org.eclipse.ui.menus.IMenuService;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.interfaces.Action;
import com.icteam.loyalty.model.interfaces.EAnnotation;
import com.icteam.loyalty.model.interfaces.IEditable;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.interfaces.IBaseClassProvider;
import com.icteam.loyalty.ui.interfaces.UIInterfacesPackage;
import com.icteam.loyalty.ui.listener.DefaultSortSelectionEMFListener;
import com.icteam.loyalty.ui.listener.PartListener2Adapter;
import com.icteam.loyalty.ui.listener.VirtuaTableEMFListener;
import com.icteam.loyalty.ui.listener.VirtualSortSelectionEMFListener;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;
import com.icteam.loyalty.ui.provider.UIEditPlugin;
import com.icteam.loyalty.ui.util.UIUtils;

public class TableControlSWTRenderer<T extends AbstractEMFTemplate< ? >, D extends EMFModel> extends AbstractControlSWTRenderer<VTableControl> {

    class OpenListener implements IOpenListener {

        private final EObject eObject;
        private final EStructuralFeature feature;

        OpenListener(EObject eObject, EStructuralFeature feature) {
            this.eObject = eObject;
            this.feature = feature;
        }

        @Override
        public void open(OpenEvent event) {
            Action action = (Action) eObject.eGet(feature);

            if (action != null) {
                if (action.isAllowed(eObject, feature)) {
                    action.execute(eObject, feature);
                }
            } else {
                UIEditPlugin.INSTANCE.log("Default action feature #" + feature + " not found in rootEObject #" + rootEObject + " and in mainEObject #" + mainEObject);
            }
        }

    }

    private SWTGridDescription rendererGridDescription;

    TableViewer tableViewer;

    Label validationIcon;
    private Button addButton;
    private Button removeButton;

    private Setting mainSetting;
    EObject mainEObject;
    private EStructuralFeature mainFeature;
    private EClass mainEClass;

    private Setting rootSetting;
    EObject rootEObject;
    private EClass rootEClass;
    EStructuralFeature rootFeature;

    final List<Binding> bindings = new ArrayList<>();

    private PartListener2Adapter listener;

    private final AdapterFactoryItemDelegator adapterFactoryItemDelegator;
    private ComposedAdapterFactory composedAdapterFactory;

    @Inject
    public TableControlSWTRenderer(VTableControl vElement, ViewModelContext viewContext, ReportService reportService, EMFFormsDatabinding emfFormsDatabinding,
            EMFFormsLabelProvider emfFormsLabelProvider, VTViewTemplateProvider vtViewTemplateProvider) {
        super(vElement, viewContext, reportService, emfFormsDatabinding, emfFormsLabelProvider, vtViewTemplateProvider);

        composedAdapterFactory = new ComposedAdapterFactory(
                new AdapterFactory[] { new CustomReflectiveItemProviderAdapterFactory(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE) });
        adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(composedAdapterFactory);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.ecp.view.spi.swt.AbstractSWTRenderer#getGridDescription(SWTGridDescription)
     */
    @Override
    public SWTGridDescription getGridDescription(SWTGridDescription gridDescription) {
        if (rendererGridDescription == null) {
            rendererGridDescription = GridDescriptionFactory.INSTANCE.createSimpleGrid(1, 1, this);
        }
        return rendererGridDescription;
    }

    protected final IItemPropertyDescriptor getItemPropertyDescriptor(Setting setting) {
        final IItemPropertyDescriptor descriptor = adapterFactoryItemDelegator.getPropertyDescriptor(setting.getEObject(), setting.getEStructuralFeature());
        return descriptor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Control renderControl(SWTGridCell gridCell, final Composite parent) {
        final Iterator<Setting> settings = getVElement().getDomainModelReference().getIterator();
        if (!settings.hasNext()) {
            return null;
        }

        rootSetting = getVElement().getDomainModelReference().getFullPathIterator().next().getPath().next();
        rootEObject = rootSetting.getEObject();
        rootEClass = rootEObject.eClass();
        rootFeature = rootSetting.getEStructuralFeature();

        mainSetting = settings.next();
        mainEObject = mainSetting.getEObject();
        mainFeature = mainSetting.getEStructuralFeature();

        if (mainEObject instanceof IBaseClassProvider) {
            mainEClass = ModelUtil.getEClass(((IBaseClassProvider) mainEObject).getBaseClass());
        } else {
            mainEClass = ((EReference) mainFeature).getEReferenceType();
        }

        final Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new GridLayout(1, false));
        composite.setBackground(parent.getBackground());

        // TODO discuss
        // final Control label = createLabel(titleComposite);

        if (getVElement().getLabelAlignment() == LabelAlignment.LEFT) {
            final Composite titleComposite = new Composite(composite, SWT.NONE);
            titleComposite.setBackground(parent.getBackground());
            GridDataFactory.fillDefaults().grab(true, false).align(SWT.FILL, SWT.BEGINNING).applyTo(titleComposite);
            GridLayoutFactory.fillDefaults().numColumns(3).equalWidth(false).applyTo(titleComposite);

            final Label label = new Label(titleComposite, SWT.NONE);
            label.setBackground(parent.getBackground());
            final IItemPropertyDescriptor propDescriptor = getItemPropertyDescriptor(mainSetting);
            String labelText = ""; //$NON-NLS-1$
            if (propDescriptor != null) {
                labelText = propDescriptor.getDisplayName(null);
            }

            label.setText(labelText);
            GridDataFactory.fillDefaults().align(SWT.FILL, SWT.BEGINNING).grab(true, false).applyTo(label);
        }

        // VALIDATION
        // final Label validationLabel = new Label(titleComposite, SWT.NONE);
        // validationLabel.setBackground(parent.getBackground());
        // // set the size of the label to the size of the image
//        validationIcon = createValidationIcon(titleComposite);
//        GridDataFactory.fillDefaults().hint(16, 17).grab(false, false).applyTo(validationIcon);

        final Composite controlComposite = createControlComposite(composite);
        setTableViewer(createTableViewer(controlComposite));

        return composite;
    }

    public VirtualViewEMFModel<T, D> getVirtualViewEMFModel() {
        return isVirtual() ? (VirtualViewEMFModel<T, D>) mainEObject : null;
    }

    /**
     * Creates and returns the composite which will be the parent for the table viewer.
     *
     * @param composite the parent composite including the title/button bar
     * @return the parent for the table viewer
     */
    protected Composite createControlComposite(Composite composite) {
        final Composite controlComposite = new Composite(composite, SWT.NONE);
        GridDataFactory.fillDefaults().grab(true, true).align(SWT.FILL, SWT.FILL).hint(-1, -1/*getTableHeightHint()*/).applyTo(controlComposite);
        GridLayoutFactory.fillDefaults().numColumns(1).applyTo(controlComposite);
        return controlComposite;
    }

    /**
     * Returns the prefereed height for the table. This will be passed to the layoutdata.
     *
     * @return the height in px
     */
    protected int getTableHeightHint() {
        return 200;
    }

    /**
     * Returns the table viewer.
     *
     * @return the viewer
     */
    protected TableViewer getTableViewer() {
        return tableViewer;
    }

    /**
     * Sets the table viewer.
     *
     * @param tableViewer the viewer
     */
    protected void setTableViewer(TableViewer tableViewer) {
        this.tableViewer = tableViewer;
    }

    private TableViewer createTableViewer(Composite composite) {

        final TableViewer tableViewer = new TableViewer(new Table(composite, getTableStyle()) {
            // select item in natural order
            // default impl reverse the order
            // problem with EList and multi selection
            @Override
            public void select(int[] indices) {
                checkWidget();

                int length = indices.length;
                if (length != 0 && ((getStyle() & SWT.SINGLE) == 0 || length <= 1)) {
                    for (int i = 0; i < length; i++) {
                        select(indices[i]);
                    }
                }
            }
        });

        tableViewer.getTable().setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));
        tableViewer.getTable().setData(CUSTOM_VARIANT, "org_eclipse_emf_ecp_control_table"); //$NON-NLS-1$
        tableViewer.getTable().setHeaderVisible(true);
        tableViewer.getTable().setLinesVisible(true);

        tableViewer.getTable().addDisposeListener(new DisposeListener() {

            @Override
            public void widgetDisposed(DisposeEvent e) {
                if (bindings != null) {
                    for (final Binding binding : bindings) {
                        binding.dispose();
                    }
                }

            }
        });

//        final TableViewerFocusCellManager focusCellManager = new TableViewerFocusCellManager(tableViewer,
//                new ECPFocusCellDrawHighlighter(tableViewer));
//        final ColumnViewerEditorActivationStrategy actSupport = new ColumnViewerEditorActivationStrategy(tableViewer) {
//            @Override
//            protected boolean isEditorActivationEvent(ColumnViewerEditorActivationEvent event) {
//                return event.eventType == ColumnViewerEditorActivationEvent.TRAVERSAL
//                        || event.eventType == ColumnViewerEditorActivationEvent.MOUSE_CLICK_SELECTION
//                        || event.eventType == ColumnViewerEditorActivationEvent.KEY_PRESSED
//                        && event.keyCode == SWT.CR
//                        || event.eventType == ColumnViewerEditorActivationEvent.PROGRAMMATIC;
//            }
//        };
//
//        TableViewerEditor.create(tableViewer, focusCellManager, actSupport, ColumnViewerEditor.TABBING_HORIZONTAL
//                | ColumnViewerEditor.TABBING_MOVE_TO_ROW_NEIGHBOR
//                | ColumnViewerEditor.TABBING_VERTICAL
//                | ColumnViewerEditor.KEYBOARD_ACTIVATION);

//        tableViewer.getTable().setData(FIXED_COLUMNS, new Integer(1));
//        ColumnViewerToolTipSupport.enableFor(tableViewer);

        final ObservableListContentProvider cp = new ObservableListContentProvider();
        InternalEObject tempInstance = null;
        if (!mainEClass.isAbstract() && !mainEClass.isInterface()) {
            tempInstance = getInstanceOf(mainEClass);
        }
        final ECPTableViewerComparator comparator = new ECPTableViewerComparator();
        tableViewer.setComparator(comparator);
        int columnNumber = 0;

        // final Map<EStructuralFeature, Boolean> readOnlyConfig = createReadOnlyConfig(clazz,
        // tableControlConfiguration);
        // final List<EStructuralFeature> structuralFeatures = new ArrayList<>();
        // structuralFeatures.addAll(readOnlyConfig.keySet());
//        if (!getVElement().isReadonly()) {
//            createFixedValidationStatusColumn(tableViewer);
//        }
        final VTableDomainModelReference tableDomainModelReference = VTableDomainModelReference.class.cast(getVElement().getDomainModelReference());

        if (tableDomainModelReference.getColumnDomainModelReferences().isEmpty()) {
            tableDomainModelReference.getColumnDomainModelReferences().addAll(UIUtils.getColumnDomainModelReferences(mainEClass));
        }

        for (final VDomainModelReference dmr : tableDomainModelReference.getColumnDomainModelReferences()) {
            if (dmr == null) {
                continue;
            }
            EStructuralFeature columnFeature = null;

            if (dmr instanceof VFeaturePathDomainModelReference) {
                columnFeature = ((VFeaturePathDomainModelReference) dmr).getDomainModelEFeature();
            } else {
                final Iterator<EStructuralFeature> columnFeatureIterator = dmr.getEStructuralFeatureIterator();
                if (columnFeatureIterator == null || !columnFeatureIterator.hasNext()) {
                    continue;
                }
                columnFeature = columnFeatureIterator.next();
            }

            String text = columnFeature.getName();

            final IItemPropertyDescriptor itemPropertyDescriptor = getItemPropertyDescriptor(UIUtils.getLastFeatureSetting(dmr, tempInstance));
            if (itemPropertyDescriptor != null) {
                text = itemPropertyDescriptor.getDisplayName(null);
            }

            final CellEditor cellEditor = createCellEditor(tempInstance, columnFeature, tableViewer.getTable());
            final TableViewerColumn column = TableViewerColumnBuilder.create().setText(text).setResizable(true).setMoveable(true).setStyle(SWT.NONE).setData("width", //$NON-NLS-1$
                    ECPCellEditor.class.isInstance(cellEditor) ? ECPCellEditor.class.cast(cellEditor).getColumnWidthWeight() : 100).build(tableViewer);

            column.setLabelProvider(
                    new ECPCellLabelProvider(columnFeature, cellEditor, getObservableMap(dmr, columnFeature, cp), getVElement(), dmr, tempInstance, itemPropertyDescriptor));
            addSelectionListener(tableViewer, comparator, column.getColumn(), columnNumber, columnFeature);

            bindColumnWidth(column, columnFeature, columnNumber);

//            if (!isReadOnly(getVElement(), dmr)) {
//                // remove if no editing needed
//                final EditingSupport observableSupport = new ECPTableEditingSupport(tableViewer, cellEditor,
//                // eStructuralFeature,
//                // itemPropertyDescriptor
//                // null,
//                        getVElement(), dmr);
//                column.setEditingSupport(observableSupport);
//            }
            columnNumber++;
        }
        tableViewer.setContentProvider(cp);
        final IObservableList list = EMFObservables.observeList(mainEObject, mainFeature);
        tableViewer.setInput(list);

        bindItemCount(tableViewer);

        // IMPORTANT:
        // - the minimumWidth and (non)resizable settings of the ColumnWeightData are not supported properly
        // - the layout stops resizing columns that have been resized manually by the user (this could be considered a
        // feature though)
        final TableColumnLayout layout = new TableColumnLayout();
        composite.setLayout(layout);
        for (int i = 0; i < tableViewer.getTable().getColumns().length; i++) {
            final Integer storedValue = (Integer) tableViewer.getTable().getColumns()[i].getData("width"); //$NON-NLS-1$
            layout.setColumnData(tableViewer.getTable().getColumns()[i], new ColumnWeightData(storedValue == null ? 50 : storedValue));
        }

        bindSelection(tableViewer);

        bindPartSite(tableViewer);

        bindVirtualListener(tableViewer, tempInstance);

        bindEnabled(tableViewer);

//        tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
//            @Override
//            public void selectionChanged(SelectionChangedEvent event) {
//                viewerSelectionChanged(event);
//            }
//        });
        return tableViewer;
    }

    private void bindEnabled(TableViewer tableViewer) {
        final IObservableValue changeableObserveValue = EMFProperties.value(EcorePackage.Literals.ESTRUCTURAL_FEATURE__CHANGEABLE).observe(mainFeature);

        if (mainEObject instanceof IEditable) {
            final IObservableValue editableModelObserveValue = EMFObservables.observeValue(mainEObject, ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);

            IObservableValue observeEditableValue = new ComputedValue() {
                @Override
                protected Object calculate() {
                    return (Boolean) editableModelObserveValue.getValue() && (Boolean) changeableObserveValue.getValue();
                }
            };

            bindings.add(getDataBindingContext().bindValue(SWTObservables.observeEnabled(tableViewer.getTable()), observeEditableValue));
            if (!getVElement().isReadonly()) {
                getVElement().setReadonly(!(Boolean) observeEditableValue.getValue());
            }
        } else {
            bindings.add(getDataBindingContext().bindValue(SWTObservables.observeEnabled(tableViewer.getTable()), changeableObserveValue));
            if (!getVElement().isReadonly()) {
                getVElement().setReadonly(!(Boolean) changeableObserveValue.getValue());
            }
        }

    }

    private void bindColumnWidth(final TableViewerColumn column, final EStructuralFeature columnFeature, final int index) {
        if (!isVirtual()) {
            return;
        }

        IObservableValue columnWidthObservable = new TableColumnWidthProperty().observe(column.getColumn());

        EObject entry = (EObject) getVirtualViewEMFModel().getColumnWidths().get(index);

        IObservableValue dtoColumnWidthObservable = EMFObservables.observeValue(entry, UIInterfacesPackage.Literals.ESTRUCTURAL_FEATURE_TO_INT_MAP__VALUE);

        UpdateValueStrategy mapToColumnsUpdateStrategy = new UpdateValueStrategy();
        mapToColumnsUpdateStrategy.setConverter(new Converter(Integer.class, Integer.class) {

            @Override
            public Object convert(Object width) {
                if (width == null) {
                    column.getColumn().setData("width", 100);

                    return 100;
                }

                return width;
            }
        });

        bindings.add(getDataBindingContext().bindValue(columnWidthObservable, dtoColumnWidthObservable, null, mapToColumnsUpdateStrategy));
    }

    private void bindItemCount(final TableViewer tableViewer) {
        if (!isVirtual()) {
            return;
        }

        setItemCount(tableViewer);

        getVirtualViewEMFModel().eAdapters().add(new EContentAdapter() {
            @Override
            public void notifyChanged(Notification notification) {
                if (!notification.isTouch() && notification.getFeatureID(EClassifier.class) == UIModelPackage.VIRTUAL_VIEW_EMF_MODEL__ITEM_COUNT) {
                    setItemCount(tableViewer);
                }
            }
        });
    }

    void setItemCount(final TableViewer tableViewer) {
        tableViewer.setItemCount(getVirtualViewEMFModel().getItemCount());
    }

    private void bindVirtualListener(final TableViewer tableViewer, final EObject tempInstance) {
        if (!isVirtual()) {
            return;
        }

        tableViewer.getControl().addListener(SWT.SetData, new VirtuaTableEMFListener<>(getVirtualViewEMFModel(), tableViewer, (D) tempInstance));
    }

    private int getTableStyle() {
        int tableStyle = SWT.NONE;

        if (isVirtual()) {
            tableStyle |= SWT.VIRTUAL;
        }

        tableStyle |= SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER;

        return tableStyle;
    }

    private boolean isVirtual() {
        return mainEObject instanceof VirtualViewEMFModel;
    }

    private void bindSelection(final TableViewer tableViewer) {
        EStructuralFeature selectedItemsFeature = (EStructuralFeature) ModelUtil.getAnnotation(mainFeature, EAnnotation.SELECTED_FEATURE);

        EObject selectedItemsEObject = mainEObject;
        if (selectedItemsFeature == null) {
            selectedItemsFeature = (EStructuralFeature) ModelUtil.getAnnotation(rootEClass, EAnnotation.SELECTED_FEATURE);
            selectedItemsEObject = rootEObject;
        }

        if (selectedItemsFeature == null) {
            selectedItemsFeature = (EStructuralFeature) ModelUtil.getAnnotation(getViewModelContext().getDomainModel().eClass(), EAnnotation.SELECTED_FEATURE);
            selectedItemsEObject = getViewModelContext().getDomainModel();
        }

        if (selectedItemsFeature != null) {
            IObservableList observeTableViewerSelection = ViewerProperties.multiplePostSelection().observe(tableViewer);
            IObservableList selectedItemsObserveList = EMFProperties.list(selectedItemsFeature).observe(selectedItemsEObject);

            bindings.add(getDataBindingContext().bindList(observeTableViewerSelection, selectedItemsObserveList, null, null));
        }

        EStructuralFeature defaultActionFeature = (EStructuralFeature) ModelUtil.getAnnotation(mainFeature, EAnnotation.DEFAULT_ACTION);
        EObject defaultActionEObject = mainEObject;

        if (defaultActionFeature == null) {
            defaultActionFeature = (EStructuralFeature) ModelUtil.getAnnotation(rootEClass, EAnnotation.DEFAULT_ACTION);
            defaultActionEObject = rootEObject;
        }

        if (defaultActionFeature == null) {
            defaultActionFeature = (EStructuralFeature) ModelUtil.getAnnotation(getViewModelContext().getDomainModel().eClass(), EAnnotation.DEFAULT_ACTION);
            defaultActionEObject = getViewModelContext().getDomainModel();
        }

        if (defaultActionFeature != null) {
            tableViewer.addOpenListener(new OpenListener(defaultActionEObject, defaultActionFeature));
        }

        IObservableList input = (IObservableList) tableViewer.getInput();
        if (input.size() > 0) {
            tableViewer.setSelection(new StructuredSelection(input.get(0)));
        }
    }

    protected void bindPartSite(final TableViewer tableViewer) {
        IWorkbenchPartSite site = (IWorkbenchPartSite) getViewModelContext().getContextValue(SWTRenderUtil.SITE);

        if (site != null) {
            site.setSelectionProvider(tableViewer);

            WorkbenchMenuService menuService = (WorkbenchMenuService) PlatformUI.getWorkbench().getService(IMenuService.class);

            if (!menuService.getAdditionsForURI(new MenuLocationURI("popup:" + site.getId())).isEmpty()) {
                Table table = tableViewer.getTable();

                MenuManager menuManager = new MenuManager();
                Menu menu = menuManager.createContextMenu(table);
                // Set the MenuManager
                table.setMenu(menu);

                site.registerContextMenu(menuManager, tableViewer);
            }
        }
    }

    /**
     * This method gets called when the selection on the {@link TableViewer} (see {@link #getTableViewer()}) has
     * changed.
     * <p>
     * If you override this method make sure to call super.
     * </p>
     *
     * @param event the {@link SelectionChangedEvent}
     */
    protected void viewerSelectionChanged(SelectionChangedEvent event) {
        if (event.getSelection().isEmpty()) {
            if (removeButton != null) {
                removeButton.setEnabled(false);
            }
        } else {
            if (removeButton != null) {
                removeButton.setEnabled(true);
            }
        }
    }

    private IObservableMap getObservableMap(VDomainModelReference dmr, EStructuralFeature eStructuralFeature, ObservableListContentProvider cp) {
        if (eStructuralFeature.isMany()) {
            return new EObjectObservableMap(cp.getKnownElements(), eStructuralFeature);
        }

        return getValueProperty(dmr).observeDetail(cp.getKnownElements());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private IValueProperty getValueProperty(VDomainModelReference dmr) {
//        ServiceReference<EMFFormsDatabinding> databindingProviderServiceReference = null;

        IValueProperty result = null;
        try {
//            final Collection<ServiceReference<EMFFormsDatabinding>> serviceReferences = FrameworkUtil.getBundle(getClass()).getBundleContext()
//                    .getServiceReferences(EMFFormsDatabinding.class, String.format("(domainModelReference=%s)", dmr.getClass().getName())); //$NON-NLS-1$
//            final Iterator<ServiceReference<EMFFormsDatabinding>> iterator = serviceReferences.iterator();
//            if (iterator.hasNext()) {
//                databindingProviderServiceReference = iterator.next();
//            }
//            if (databindingProviderServiceReference == null) {
//                throw new IllegalStateException("No EMFFormsDatabinding available."); //$NON-NLS-1$
//            }
//
//            final EMFFormsDatabinding databindingProviderService = FrameworkUtil.getBundle(getClass()).getBundleContext().getService(databindingProviderServiceReference);
            result = getEMFFormsDatabinding().getValueProperty(dmr, getViewModelContext().getDomainModel());
//            FrameworkUtil.getBundle(getClass()).getBundleContext().ungetService(databindingProviderServiceReference);
        } catch (final DatabindingFailedException e) {
            throw new IllegalStateException(e);
        }

        return result;
    }

    private void addSelectionListener(final TableViewer tableViewer, final ECPTableViewerComparator comparator, final TableColumn column, final int index,
            EStructuralFeature columnFeature) {
        SelectionListener selectionListener = null;

        if (isVirtual()) {
            if (DefaultSortSelectionEMFListener.isSortable(columnFeature)) {
                selectionListener = new VirtualSortSelectionEMFListener<>(getVirtualViewEMFModel(), tableViewer, mainEClass.getInstanceClass(), columnFeature);
            }
        } else {
            selectionListener = new SelectionAdapter() {
                @Override
                public void widgetSelected(SelectionEvent e) {
                    comparator.setColumn(index);
                    final int dir = comparator.getDirection();

                    tableViewer.getTable().setSortDirection(dir);
                    tableViewer.getTable().setSortColumn(column);
                    tableViewer.refresh();
                }
            };
        }

        if (selectionListener != null) {
            column.addSelectionListener(selectionListener);
        }
    }

//    private void createFixedValidationStatusColumn(TableViewer tableViewer) {
//        final VTTableValidationStyleProperty tableValidationStyleProperty = getTableValidationStyleProperty();
//        final int columnWidth = tableValidationStyleProperty.getColumnWidth();
//        final String columnName = tableValidationStyleProperty.getColumnName();
//        final String imagePath = tableValidationStyleProperty.getImagePath();
//        final TableViewerColumn column = TableViewerColumnBuilder.create().setMoveable(false).setText(columnName).setWidth(columnWidth)
//                .build(tableViewer);
//
//        if (imagePath != null && !imagePath.isEmpty()) {
//            Image image = null;
//            try {
//                image = Activator.getImage(new File(imagePath).toURI().toURL());
//            } catch (final MalformedURLException ex) {
//                ex.printStackTrace();
//            }
//            if (image != null) {
//                column.getColumn().setImage(image);
//            }
//        }
//        column.setLabelProvider(new ValidationStatusCellLabelProvider(getVElement()));
//    }

//    private VTTableValidationStyleProperty getTableValidationStyleProperty() {
//        VTTableValidationStyleProperty tableValidationStyleProperties;
////        final Set<VTStyleProperty> styleProperties = Activator.getInstance().getVTViewTemplateProvider()
////                .getStyleProperties(getVElement(), getViewModelContext());
////        for (final VTStyleProperty styleProperty : styleProperties) {
////            if (VTTableValidationStyleProperty.class.isInstance(styleProperty)) {
////                tableValidationStyleProperties = VTTableValidationStyleProperty.class.cast(styleProperty);
////                return tableValidationStyleProperties;
////            }
////        }
//
//        tableValidationStyleProperties = getDefaultTableValidationStyleProperty();
//        return tableValidationStyleProperties;
//    }
//
//    private VTTableValidationStyleProperty getDefaultTableValidationStyleProperty() {
//        final VTTableValidationStyleProperty tableValidationProp = VTTableValidationFactory.eINSTANCE.createTableValidationStyleProperty();
//        tableValidationProp.setColumnWidth(80);
//        tableValidationProp.setColumnName(ControlMessages.TableControl_ValidationStatusColumn);
//        tableValidationProp.setImagePath(null);
//        return tableValidationProp;
//    }

    private CellEditor createCellEditor(final EObject tempInstance, final EStructuralFeature feature, Table table) {
        return CellEditorFactory.INSTANCE.getCellEditor(feature, tempInstance, table, getViewModelContext());
    }

    private static InternalEObject getInstanceOf(EClass clazz) {
        return InternalEObject.class.cast(clazz.getEPackage().getEFactoryInstance().create(clazz));
    }

//    private Button createRemoveRowButton(EClass clazz, final Composite buttonComposite, Setting mainSetting) {
//        removeButton = new Button(buttonComposite, SWT.None);
//        final Image image = Activator.getImage(ICON_DELETE);
//        removeButton.setImage(image);
//        removeButton.setEnabled(false);
//        final String instanceName = clazz.getInstanceClass() == null ? "" : clazz.getInstanceClass().getSimpleName(); //$NON-NLS-1$
//        removeButton.setToolTipText(String.format(ControlMessages.TableControl_RemoveSelected, instanceName));
//
//        final List< ? > containments = (List< ? >) mainSetting.get(true);
//        if (containments.size() <= mainFeature.getLowerBound()) {
//            removeButton.setEnabled(false);
//        }
//        return removeButton;
//    }
//
//    private Button createAddRowButton(final EClass clazz, final Composite buttonComposite, final Setting mainSetting) {
//        addButton = new Button(buttonComposite, SWT.None);
//        final Image image = Activator.getImage(ICON_ADD);
//        addButton.setImage(image);
//        final String instanceName = clazz.getInstanceClass() == null ? "" : clazz.getInstanceClass().getSimpleName(); //$NON-NLS-1$
//        addButton.setToolTipText(String.format(ControlMessages.TableControl_AddInstanceOf, instanceName));
//
//        final List< ? > containments = (List< ? >) mainSetting.get(true);
//        if (mainFeature.getUpperBound() != -1 && containments.size() >= mainFeature.getUpperBound()) {
//            addButton.setEnabled(false);
//        }
//        return addButton;
//    }

//    /**
//     * This method shows a user confirmation dialog when the user attempts to delete a row in the table.
//     *
//     * @param deletionList the list of selected EObjects to delete
//     * @param mainSetting the containment reference setting
//     * @param addButton the add button
//     * @param removeButton the remove button
//     */
//    protected void deleteRowUserConfirmDialog(final List<EObject> deletionList, final Setting mainSetting, final Button addButton,
//            final Button removeButton) {
//        final MessageDialog dialog = new MessageDialog(addButton.getShell(), ControlMessages.TableControl_Delete, null,
//                ControlMessages.TableControl_DeleteAreYouSure, MessageDialog.CONFIRM, new String[] {
//                        JFaceResources.getString(IDialogLabelKeys.YES_LABEL_KEY), JFaceResources.getString(IDialogLabelKeys.NO_LABEL_KEY) }, 0);
//
//        new ECPDialogExecutor(dialog) {
//
//            @Override
//            public void handleResult(int codeResult) {
//                if (codeResult == IDialogConstants.CANCEL_ID) {
//                    return;
//                }
//
//                deleteRows(deletionList, mainSetting);
//
//                final List< ? > containments = (List< ? >) mainSetting.get(true);
//                if (containments.size() < mainFeature.getUpperBound()) {
//                    addButton.setEnabled(true);
//                }
//                if (containments.size() <= mainFeature.getLowerBound()) {
//                    removeButton.setEnabled(false);
//                }
//            }
//        }.execute();
//    }
//
//    /**
//     * This is called by {@link #deleteRowUserConfirmDialog(List)} after the user confirmed to delete the selected
//     * elements.
//     *
//     * @param deletionList the list of {@link EObject EObjects} to delete
//     * @param mainSetting the containment reference setting
//     */
//    protected void deleteRows(List<EObject> deletionList, Setting mainSetting) {
//        final EObject modelElement = mainEObject;
//        final EditingDomain editingDomain = getEditingDomain(mainSetting);
//        editingDomain.getCommandStack().execute(RemoveCommand.create(editingDomain, modelElement, mainFeature, deletionList));
//    }

//    /**
//     * This method is called to add a new entry in the domain model and thus to create a new row in the table. The
//     * element to create is defined by the provided class.
//     * You can override this method but you have to call super nonetheless.
//     *
//     * @param clazz the {@link EClass} defining the EObject to create
//     * @param mainSetting the containment reference setting
//     */
//    protected void addRow(EClass clazz, Setting mainSetting) {
//        final EObject modelElement = mainEObject;
//        final EObject instance = clazz.getEPackage().getEFactoryInstance().create(clazz);
//        final EditingDomain editingDomain = getEditingDomain(mainSetting);
//        if (editingDomain == null) {
//            return;
//        }
//        editingDomain.getCommandStack().execute(AddCommand.create(editingDomain, modelElement, mainFeature, instance));
//
//    }

    @Override
    protected void applyValidation() {
        Display.getDefault().asyncExec(new Runnable() {

            @Override
            public void run() {
                // triggered due to another validation rule before this control is rendered
                if (validationIcon == null) {
                    return;
                }
                // validation rule triggered after the control was disposed
                if (validationIcon.isDisposed()) {
                    return;
                }
                // no diagnostic set
                if (getVElement().getDiagnostic() == null) {
                    return;
                }
                validationIcon.setImage(getValidationIcon(getVElement().getDiagnostic().getHighestSeverity()));
                validationIcon.setToolTipText(getVElement().getDiagnostic().getMessage());
                final Setting mainSetting = getVElement().getDomainModelReference().getIterator().next();
                final Collection< ? > collection = (Collection< ? >) mainSetting.get(true);
                if (!collection.isEmpty()) {
                    for (final Object object : collection) {
                        tableViewer.update(object, null);
                    }
                }
            }
        });

    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.ecp.view.spi.swt.AbstractSWTRenderer#applyEnable()
     */
    @Override
    protected void applyEnable() {
        if (addButton != null) {
            addButton.setVisible(getVElement().isEnabled() && !getVElement().isReadonly());
        }
        if (removeButton != null) {
            removeButton.setVisible(getVElement().isEnabled() && !getVElement().isReadonly());
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.ecp.view.spi.swt.AbstractSWTRenderer#applyReadOnly()
     */
    @Override
    protected void applyReadOnly() {
        if (addButton != null) {
            addButton.setVisible(getVElement().isEnabled() && !getVElement().isReadonly());
        }
        if (removeButton != null) {
            removeButton.setVisible(getVElement().isEnabled() && !getVElement().isReadonly());
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.ecp.view.spi.swt.AbstractSWTRenderer#dispose()
     */
    @Override
    protected void dispose() {
        rendererGridDescription = null;

        if (composedAdapterFactory != null) {
            composedAdapterFactory.dispose();
            composedAdapterFactory = null;
        }

        if (listener != null) {
            final IWorkbenchPage workbenchPage = UIUtils.getActivePage();

            if (workbenchPage != null) {
                workbenchPage.removePartListener(listener);
            }
        }

        super.dispose();
    }

    /**
     * The {@link ViewerComparator} for this table which allows 3 states for sort order:
     * none, up and down.
     *
     * @author Eugen Neufeld
     *
     */
    private class ECPTableViewerComparator extends ViewerComparator {
        private int propertyIndex;
        private static final int NONE = 0;
        private int direction = NONE;

        public ECPTableViewerComparator() {
            propertyIndex = 0;
            direction = NONE;
        }

        public int getDirection() {
            switch (direction) {
                case 0:
                    return SWT.NONE;
                case 1:
                    return SWT.UP;
                case 2:
                    return SWT.DOWN;
                default:
                    return SWT.NONE;
            }

        }

        public void setColumn(int column) {
            if (column == propertyIndex) {
                // Same column as last sort; toggle the direction
                direction = (direction + 1) % 3;
            } else {
                // New column; do an ascending sort
                propertyIndex = column;
                direction = 1;
            }
        }

        @Override
        public int compare(Viewer viewer, Object e1, Object e2) {
            if (direction == 0) {
                return 0;
            }

            final EObject object1 = (EObject) e1;
            final EObject object2 = (EObject) e2;

            int rc = ModelUtil.compareTo(object1, object2);

            // If descending order, flip the direction
            if (direction == 2) {
                rc = -rc;
            }

            return rc;
        }
    }

    /**
     * ECP specficic cell label provider that does also implement {@link IColorProvider} in
     * order to correctly.
     *
     * @author emueller
     *
     */
    public class ECPCellLabelProvider extends ObservableMapCellLabelProvider implements IColorProvider {

        private final EStructuralFeature feature;
        private final CellEditor cellEditor;
        private final VTableControl vTableControl;
        private final VDomainModelReference dmr;
        private final Map<EClass, IItemPropertyDescriptor> itemPropertyDescriptors = new HashMap<>();
        private final IItemPropertyDescriptor defaultItemPropertyDescriptor;

        /**
         * Constructor.
         *
         * @param feature
         *            the {@link EStructuralFeature} the cell is bound to
         * @param cellEditor
         *            the {@link CellEditor} instance
         * @param attributeMap
         *            an {@link IObservableMap} instance that is passed to the {@link ObservableMapCellLabelProvider}
         * @param vTableControl the {@link VTableControl}
         * @param dmr the {@link VDomainModelReference} for this cell
         * @param itemPropertyDescriptor
         * @param basicInstance
         */
        public ECPCellLabelProvider(EStructuralFeature feature, CellEditor cellEditor, IObservableMap attributeMap, VTableControl vTableControl, VDomainModelReference dmr,
                EObject basicInstance, IItemPropertyDescriptor itemPropertyDescriptor) {
            super(attributeMap);
            this.vTableControl = vTableControl;
            this.feature = feature;
            this.cellEditor = cellEditor;
            this.dmr = dmr;
            this.defaultItemPropertyDescriptor = itemPropertyDescriptor;
            this.itemPropertyDescriptors.put(basicInstance.eClass(), itemPropertyDescriptor);
        }

        /**
         * {@inheritDoc}
         *
         * @see org.eclipse.jface.viewers.CellLabelProvider#getToolTipText(java.lang.Object)
         */
        @Override
        public String getToolTipText(Object element) {
//            final EObject domainObject = (EObject) element;
//            final VDomainModelReference copy = EcoreUtil.copy(dmr);
//            copy.init(domainObject);
//            final Iterator<Setting> iterator = copy.getIterator();
//            Setting setting = null;
//            if (iterator.hasNext()) {
//                setting = iterator.next();
//            } else {
//                return null;
//            }
//
//            // final Setting setting = InternalEObject.class.cast(domainObject).eSetting(feature);
//            final StringBuffer tooltip = new StringBuffer();
//            final VDiagnostic vDiagnostic = vTableControl.getDiagnostic();
//            final List<Diagnostic> diagnostics = vDiagnostic.getDiagnostic(domainObject, feature);
//            for (final Diagnostic diagnostic : diagnostics) {
//                if (tooltip.length() > 0) {
//                    tooltip.append("\n"); //$NON-NLS-1$
//                }
//                tooltip.append(diagnostic.getMessage());
//            }
//            if (tooltip.length() != 0) {
//                return ECPTooltipModifierHelper.modifyString(tooltip.toString(), setting);
//            }
//            final Object value = setting.get(true);
//            if (value == null) {
//                return null;
//            }
//            return ECPTooltipModifierHelper.modifyString(String.valueOf(value), setting);

            return "";
        }

        @SuppressWarnings("synthetic-access")
        @Override
        public void update(ViewerCell cell) {
            final EObject element = (EObject) cell.getElement();
            final Object value = attributeMaps[0].get(element);
            String text = null;

            IItemPropertyDescriptor itemPropertyDescriptor = defaultItemPropertyDescriptor;

            if (element != null) {
                itemPropertyDescriptor = itemPropertyDescriptors.get(element.eClass());

                if (itemPropertyDescriptor == null) {
                    itemPropertyDescriptor = getItemPropertyDescriptor(UIUtils.getLastFeatureSetting(dmr, element));

                    if (itemPropertyDescriptor != null) {
                        itemPropertyDescriptors.put(element.eClass(), itemPropertyDescriptor);
                    }
                }
            }

            if (itemPropertyDescriptor != null) {
                text = itemPropertyDescriptor.getLabelProvider(null).getText(value);
            } else if (ECPCellEditor.class.isInstance(cellEditor)) {
                final ECPCellEditor ecpCellEditor = (ECPCellEditor) cellEditor;
                text = ecpCellEditor.getFormatedString(value);
            } else {
                if (value != null) {
                    text = value.toString(); //$NON-NLS-1$
                }

                cell.getControl().setData(CUSTOM_VARIANT, "org_eclipse_emf_ecp_edit_cellEditor_string"); //$NON-NLS-1$
            }

            cell.setText(text == null ? "" : text); //$NON-NLS-1$
            cell.setBackground(getBackground(element));
        }

        /**
         * {@inheritDoc}
         *
         * @see org.eclipse.jface.viewers.IColorProvider#getForeground(java.lang.Object)
         */
        @Override
        public Color getForeground(Object element) {
            return null;
        }

        /**
         * {@inheritDoc}
         *
         * @see org.eclipse.jface.viewers.IColorProvider#getBackground(java.lang.Object)
         */
        @Override
        public Color getBackground(Object element) {
            final VDiagnostic vDiagnostic = vTableControl.getDiagnostic();
            if (vDiagnostic == null || element == null) {
                return getValidationBackgroundColor(Diagnostic.OK);
            }
            final List<Diagnostic> diagnostic = vDiagnostic.getDiagnostic((EObject) element, feature);
            return getValidationBackgroundColor(diagnostic.size() == 0 ? Diagnostic.OK : diagnostic.get(0).getSeverity());
        }
    }

    /**
     * Implementation of the {@link EditingSupport} for the generic ECP Table.
     *
     * @author Eugen Neufeld
     *
     */
//    private class ECPTableEditingSupport extends EditingSupport {
//
//        private final CellEditor cellEditor;
//
//        // private final IItemPropertyDescriptor itemPropertyDescriptor;
//
//        private final VTableControl tableControl;
//
//        private final VDomainModelReference domainModelReference;
//
//        /**
//         * @param viewer
//         */
//        public ECPTableEditingSupport(ColumnViewer viewer, CellEditor cellEditor, VTableControl tableControl,
//                VDomainModelReference domainModelReference) {
//            super(viewer);
//            this.cellEditor = cellEditor;
//            this.tableControl = tableControl;
//            this.domainModelReference = domainModelReference;
//            // itemPropertyDescriptor = getItemPropertyDescriptor(domainModelReference.getIterator().next());
//        }
//
//        EditingState editingState;
//
//        private final ColumnViewerEditorActivationListenerHelper activationListener = new ColumnViewerEditorActivationListenerHelper();
//
//        /**
//         * Default implementation always returns <code>true</code>.
//         *
//         * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
//         */
//        @Override
//        protected boolean canEdit(Object element) {
//
//            boolean editable = tableControl.isEnabled() && !tableControl.isReadonly();
//
//            final Setting setting = getCellSetting(domainModelReference, element);
//            if (setting == null) {
//                return false;
//            }
//            editable &= getItemPropertyDescriptor(setting).canSetProperty(null);
////            editable &= !CellReadOnlyTesterHelper.getInstance().isReadOnly(getVElement(), setting);
//
//            if (ECPCellEditor.class.isInstance(cellEditor)) {
//                ECPCellEditor.class.cast(cellEditor).setEditable(editable);
//                return true;
//            }
//            return editable;
//        }
//
//        /**
//         * Default implementation always returns <code>null</code> as this will be
//         * handled by the Binding.
//         *
//         * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
//         */
//        @Override
//        protected Object getValue(Object element) {
//            // no op
//            return null;
//        }
//
//        /**
//         * Default implementation does nothing as this will be handled by the
//         * Binding.
//         *
//         * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
//         */
//        @Override
//        protected void setValue(Object element, Object value) {
//            // no op
//        }
//
//        /**
//         * Creates a {@link Binding} between the editor and the element to be
//         * edited. Invokes {@link #doCreateCellEditorObservable(CellEditor)},
//         * {@link #doCreateElementObservable(Object, ViewerCell)}, and then
//         * {@link #createBinding(IObservableValue, IObservableValue)}.
//         */
//        @Override
//        protected void initializeCellEditorValue(CellEditor cellEditor, ViewerCell cell) {
//
//            final IObservableValue target = doCreateCellEditorObservable(cellEditor);
//            Assert.isNotNull(target, "doCreateCellEditorObservable(...) did not return an observable"); //$NON-NLS-1$
//
//            final IObservableValue model = doCreateElementObservable(cell.getElement(), cell);
//            Assert.isNotNull(model, "doCreateElementObservable(...) did not return an observable"); //$NON-NLS-1$
//
//            final Binding binding = createBinding(target, model);
//
//            Assert.isNotNull(binding, "createBinding(...) did not return a binding"); //$NON-NLS-1$
//
//            editingState = new EditingState(binding, target, model);
//
//            getViewer().getColumnViewerEditor().addEditorActivationListener(activationListener);
//        }
//
//        @Override
//        protected CellEditor getCellEditor(Object element) {
//            return cellEditor;
//        }
//
//        protected Binding createBinding(IObservableValue target, IObservableValue model) {
//            if (ECPCellEditor.class.isInstance(cellEditor)) {
//                return getDataBindingContext().bindValue(target, model, ((ECPCellEditor) cellEditor).getTargetToModelStrategy(),
//                        ((ECPCellEditor) cellEditor).getModelToTargetStrategy());
//            }
//            return getDataBindingContext().bindValue(target, model);
//        }
//
//        protected IObservableValue doCreateElementObservable(Object element, ViewerCell cell) {
//            return getValueProperty(domainModelReference).observe(element);
//
//            // return EMFEditObservables..observeValue(
//            // getEditingDomain(InternalEObject.class.cast(element).eSetting(cellFeature)),
//            // (EObject) element, cellFeature);
//        }
//
//        protected IObservableValue doCreateCellEditorObservable(CellEditor cellEditor) {
//            if (ECPCellEditor.class.isInstance(cellEditor)) {
//                return ((ECPCellEditor) cellEditor).getValueProperty().observe(cellEditor);
//            }
//            return SWTObservables.observeText(cellEditor.getControl(), SWT.FocusOut);
//        }
//
//        @Override
//        protected final void saveCellEditorValue(CellEditor cellEditor, ViewerCell cell) {
//            editingState.binding.updateTargetToModel();
//        }
//
//        /**
//         * A ColumnViewerEditorActivationListener to reset the cells after focus lost.
//         *
//         * @author Eugen Neufeld
//         *
//         */
//        private class ColumnViewerEditorActivationListenerHelper extends ColumnViewerEditorActivationListener {
//
//            @Override
//            public void afterEditorActivated(ColumnViewerEditorActivationEvent event) {
//                // do nothing
//            }
//
//            @Override
//            public void afterEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
//                editingState.dispose();
//                editingState = null;
//
//                getViewer().getColumnViewerEditor().removeEditorActivationListener(this);
//                final ViewerCell focusCell = getViewer().getColumnViewerEditor().getFocusCell();
//                if (focusCell != null) {
//                    getViewer().update(focusCell.getElement(), null);
//                }
//            }
//
//            @Override
//            public void beforeEditorActivated(ColumnViewerEditorActivationEvent event) {
//                // do nothing
//            }
//
//            @Override
//            public void beforeEditorDeactivated(ColumnViewerEditorDeactivationEvent event) {
//                // do nothing
//            }
//        }
//
//        /**
//         * Maintains references to objects that only live for the length of the edit
//         * cycle.
//         */
//        class EditingState {
//            private final IObservableValue target;
//
//            private final IObservableValue model;
//
//            final Binding binding;
//
//            EditingState(Binding binding, IObservableValue target, IObservableValue model) {
//                this.binding = binding;
//                this.target = target;
//                this.model = model;
//            }
//
//            void dispose() {
//                binding.dispose();
//                target.dispose();
//                model.dispose();
//            }
//        }
//    }

//    /**
//     * The {@link CellLabelProvider} to update the validation status on the cells.
//     *
//     * @author Eugen Neufeld
//     *
//     */
//    private class ValidationStatusCellLabelProvider extends CellLabelProvider {
//        private final VTableControl vTableControl;
//
//        public ValidationStatusCellLabelProvider(VTableControl vTableControl) {
//            this.vTableControl = vTableControl;
//        }
//
//        @Override
//        public void update(ViewerCell cell) {
//            Integer mostSevere = Diagnostic.OK;
//            final VDiagnostic vDiagnostic = vTableControl.getDiagnostic();
//            if (vDiagnostic == null) {
//                return;
//            }
//            final List<Diagnostic> diagnostics = vDiagnostic.getDiagnostics((EObject) cell.getElement());
//            if (diagnostics.size() != 0) {
//                mostSevere = diagnostics.get(0).getSeverity();
//            }
//            cell.setImage(getValidationIcon(mostSevere));
//        }
//
//        @Override
//        public String getToolTipText(Object element) {
//            final StringBuffer tooltip = new StringBuffer();
//            final VDiagnostic vDiagnostic = vTableControl.getDiagnostic();
//
//            final List<Diagnostic> diagnostics = vDiagnostic.getDiagnostics((EObject) element);
//            for (final Diagnostic diagnostic : diagnostics) {
//                if (tooltip.length() > 0) {
//                    tooltip.append("\n"); //$NON-NLS-1$
//                }
//                tooltip.append(diagnostic.getMessage());
//            }
//
//            return tooltip.toString();
//        }
//    }
}

package com.icteam.loyalty.ui.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.collections.CollectionUtils;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.UpdateListStrategy;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecp.view.model.common.edit.provider.CustomReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.ecp.view.spi.context.ViewModelContext;
import org.eclipse.emf.ecp.view.spi.core.swt.AbstractControlSWTRenderer;
import org.eclipse.emf.ecp.view.spi.group.model.VGroupFactory;
import org.eclipse.emf.ecp.view.spi.model.LabelAlignment;
import org.eclipse.emf.ecp.view.spi.model.VControl;
import org.eclipse.emf.ecp.view.template.model.VTViewTemplateProvider;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emfforms.spi.common.report.ReportService;
import org.eclipse.emfforms.spi.core.services.databinding.EMFFormsDatabinding;
import org.eclipse.emfforms.spi.core.services.label.EMFFormsLabelProvider;
import org.eclipse.emfforms.spi.swt.core.layout.GridDescriptionFactory;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridCell;
import org.eclipse.emfforms.spi.swt.core.layout.SWTGridDescription;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.RowLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;

import com.icteam.loyalty.model.interfaces.IEditable;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.ui.converter.CollectionToBooleanComputedValue;
import com.icteam.loyalty.ui.model.NToMEMFModel;
import com.icteam.loyalty.ui.model.UIModelFactory;
import com.icteam.loyalty.ui.model.UIModelPackage;

public class NToMControlRenderer<T extends EObject> extends AbstractControlSWTRenderer<VControl> {

    enum Direction {
        TO_SRC, TO_DEST, ALL_TO_SRC, ALL_TO_DEST;
    }

//    private TableViewer tableViewerSrc;
//    private TableViewer tableViewerDest;

    private Button cmdAllToSrc;
    private Button cmdToSrc;
    private Button cmdToDest;
    private Button cmdAllToDest;

//    private Binding allSrcBinding;
//    private Binding allDestBinding;
//    private Binding srcBinding;
//    private Binding destBinding;

    private Group grpMain;

//    private Label lblDest;
//
//    private Label lblValidator;
//
//    private Label lblSrc;

    private SWTGridDescription rendererGridDescription;

    private EStructuralFeature.Setting mainSetting;

//    private Class<T> clazz;
    private EStructuralFeature mainFeature;
    private EObject mainEObject;
    private NToMEMFModel ntomModel;

    private final AdapterFactoryItemDelegator adapterFactoryItemDelegator;
    private final ComposedAdapterFactory composedAdapterFactory;

    @Inject
    public NToMControlRenderer(VControl vElement, ViewModelContext viewContext, ReportService reportService, EMFFormsDatabinding emfFormsDatabinding,
            EMFFormsLabelProvider emfFormsLabelProvider, VTViewTemplateProvider vtViewTemplateProvider) {
        super(vElement, viewContext, reportService, emfFormsDatabinding, emfFormsLabelProvider, vtViewTemplateProvider);

        composedAdapterFactory = new ComposedAdapterFactory(
                new AdapterFactory[] { new CustomReflectiveItemProviderAdapterFactory(), new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE) });
        adapterFactoryItemDelegator = new AdapterFactoryItemDelegator(composedAdapterFactory);
    }

    protected final IItemPropertyDescriptor getItemPropertyDescriptor(Setting setting) {
        final IItemPropertyDescriptor descriptor = adapterFactoryItemDelegator.getPropertyDescriptor(setting.getEObject(), setting.getEStructuralFeature());
        return descriptor;
    }

    @Override
    public SWTGridDescription getGridDescription(SWTGridDescription arg0) {
        if (this.rendererGridDescription == null) {
            this.rendererGridDescription = GridDescriptionFactory.INSTANCE.createSimpleGrid(1, 1, this);
        }

        return this.rendererGridDescription;
    }

    private Binding[] createBindings() {
        List<Binding> bindings = new ArrayList<>();

        IObservableList observeDestList = EMFObservables.observeList(ntomModel, UIModelPackage.Literals.NTO_MEMF_MODEL__DEST_LIST);
        IObservableList observeSrcList = EMFObservables.observeList(ntomModel, UIModelPackage.Literals.NTO_MEMF_MODEL__SRC_LIST);
        IObservableList observeSelectedDestList = EMFObservables.observeList(ntomModel, UIModelPackage.Literals.NTO_MEMF_MODEL__SELECTED_DEST_LIST);
        IObservableList observeSelectedSrcList = EMFObservables.observeList(ntomModel, UIModelPackage.Literals.NTO_MEMF_MODEL__SELECTED_SRC_LIST);

        IObservableValue observeEmptyDestListValue = new CollectionToBooleanComputedValue(observeDestList);
        IObservableValue observeEmptySrcListValue = new CollectionToBooleanComputedValue(observeSrcList);
        IObservableValue observeEmptySelectedDestListValue = new CollectionToBooleanComputedValue(observeSelectedDestList);
        IObservableValue observeEmptySelectedSrcListValue = new CollectionToBooleanComputedValue(observeSelectedSrcList);

        // bind between main EObject and NToM destList
        UpdateListStrategy updateListStrategy = new UpdateListStrategy(UpdateListStrategy.POLICY_NEVER);
        bindings.add(getDataBindingContext().bindList(observeDestList, EMFObservables.observeList(mainEObject, mainFeature), null, updateListStrategy));

        IObservableValue editableAllToDestActionObserveValue = EMFObservables.observeValue(ntomModel.getAllToDestAction(), ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);
        IObservableValue editableAllToSrcActionObserveValue = EMFObservables.observeValue(ntomModel.getAllToSrcAction(), ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);
        IObservableValue editableToDestActionObserveValue = EMFObservables.observeValue(ntomModel.getToDestAction(), ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);
        IObservableValue editableToSrcActionObserveValue = EMFObservables.observeValue(ntomModel.getToSrcAction(), ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);

        bindings.add(getDataBindingContext().bindValue(editableAllToSrcActionObserveValue, observeEmptyDestListValue, null, null));
        bindings.add(getDataBindingContext().bindValue(editableAllToDestActionObserveValue, observeEmptySrcListValue, null, null));
        bindings.add(getDataBindingContext().bindValue(editableToDestActionObserveValue, observeEmptySelectedSrcListValue, null, null));
        bindings.add(getDataBindingContext().bindValue(editableToSrcActionObserveValue, observeEmptySelectedDestListValue, null, null));

        if (mainEObject instanceof IEditable) {
            IObservableValue dtoEditableValue = EMFObservables.observeValue(ntomModel, ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);
            IObservableValue mainEObjectEditableValue = EMFObservables.observeValue(mainEObject, ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);

            bindings.add(getDataBindingContext().bindValue(dtoEditableValue, mainEObjectEditableValue, null, null));
        }

        return bindings.toArray(new Binding[] {});
    }

    @Override
    protected Control renderControl(SWTGridCell arg0, Composite parent) {
        Iterator<EStructuralFeature.Setting> settings = getVElement().getDomainModelReference().getIterator();
        if (!settings.hasNext()) {
            return null;
        }

        mainSetting = settings.next();
        mainFeature = mainSetting.getEStructuralFeature();
        mainEObject = mainSetting.getEObject();
//        clazz = (Class<T>) mainFeature.getEType().getInstanceClass();

        ntomModel = UIModelFactory.eINSTANCE.createNToMEMFModel();
        ntomModel.setMainEObject(mainEObject);
        ntomModel.setMainFeature(mainFeature);

        IItemPropertyDescriptor itemPropertyDescriptor = getItemPropertyDescriptor(mainSetting);

        Collection<T> values = (Collection<T>) itemPropertyDescriptor.getChoiceOfValues(mainEObject);

        ntomModel.getDestList().addAll((Collection<T>) mainSetting.get(true));
        ntomModel.getSrcList().addAll(CollectionUtils.subtract(values, ntomModel.getDestList()));

        final Binding[] bindings = createBindings();

        grpMain = (Group) SWTRenderUtil.renderControl(parent, ntomModel, VGroupFactory.eINSTANCE.createGroup());
        grpMain.setLayout(new FormLayout());

        grpMain.addDisposeListener(new DisposeListener() {
            @Override
            public void widgetDisposed(DisposeEvent e) {
                if (bindings != null) {
                    for (final Binding binding : bindings) {
                        binding.dispose();
                    }
                }

            }
        });

        //       grpMain.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 0, 0));

        Composite controlArea = new Composite(grpMain, SWT.NONE);
        GridLayout gl_controlArea = new GridLayout(4, true);
        gl_controlArea.horizontalSpacing = 0;
        gl_controlArea.verticalSpacing = 0;
        gl_controlArea.marginWidth = 0;
        gl_controlArea.marginHeight = 0;
        controlArea.setLayout(gl_controlArea);
        FormData fd_controlArea = new FormData();
        fd_controlArea.left = new FormAttachment(20);
        fd_controlArea.right = new FormAttachment(80);
        fd_controlArea.top = new FormAttachment(0);
        controlArea.setLayoutData(fd_controlArea);

        GridData controlAreaGridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);

        Composite controlAreaComp = new Composite(controlArea, SWT.NONE);
        controlAreaComp.setLayoutData(controlAreaGridData);
        RowLayout rl_composite = new RowLayout(SWT.HORIZONTAL);
        rl_composite.wrap = false;
        rl_composite.pack = false;
        rl_composite.spacing = 0;
        rl_composite.marginTop = 0;
        rl_composite.marginRight = 0;
        rl_composite.marginLeft = 0;
        rl_composite.marginBottom = 0;
        rl_composite.justify = true;
        controlAreaComp.setLayout(rl_composite);

        cmdAllToSrc = (Button) SWTRenderUtil.renderControl(controlAreaComp, ntomModel, UIModelPackage.Literals.NTO_MEMF_MODEL__ALL_TO_SRC_ACTION);
        cmdAllToSrc.setLayoutData(null);

        Composite controlAreaComp_1 = new Composite(controlArea, SWT.NONE);
        controlAreaComp_1.setLayoutData(GridDataFactory.copyData(controlAreaGridData));
        controlAreaComp_1.setLayout(RowLayoutFactory.copyLayout(rl_composite));

        cmdToSrc = (Button) SWTRenderUtil.renderControl(controlAreaComp_1, ntomModel, UIModelPackage.Literals.NTO_MEMF_MODEL__TO_SRC_ACTION);
        cmdToSrc.setLayoutData(null);

        Composite controlAreaComp_2 = new Composite(controlArea, SWT.NONE);
        controlAreaComp_2.setLayoutData(GridDataFactory.copyData(controlAreaGridData));
        controlAreaComp_2.setLayout(RowLayoutFactory.copyLayout(rl_composite));

        cmdToDest = (Button) SWTRenderUtil.renderControl(controlAreaComp_2, ntomModel, UIModelPackage.Literals.NTO_MEMF_MODEL__TO_DEST_ACTION);
        cmdToDest.setLayoutData(null);

        Composite controlAreaComp_3 = new Composite(controlArea, SWT.NONE);
        controlAreaComp_3.setLayoutData(GridDataFactory.copyData(controlAreaGridData));
        controlAreaComp_3.setLayout(RowLayoutFactory.copyLayout(rl_composite));

        cmdAllToDest = (Button) SWTRenderUtil.renderControl(controlAreaComp_3, ntomModel, UIModelPackage.Literals.NTO_MEMF_MODEL__ALL_TO_DEST_ACTION);
        cmdAllToDest.setLayoutData(null);

        SashForm sashForm = new SashForm(grpMain, SWT.NONE);
        FormData fd_sashForm = new FormData();
        fd_sashForm.top = new FormAttachment(controlArea, 5);
        fd_sashForm.bottom = new FormAttachment(100);

        fd_sashForm.right = new FormAttachment(100);
        fd_sashForm.left = new FormAttachment(0);
        sashForm.setLayoutData(fd_sashForm);

        SWTRenderUtil.renderTableControl(null, sashForm, ntomModel, UIModelPackage.Literals.NTO_MEMF_MODEL__SRC_LIST, LabelAlignment.LEFT);
        SWTRenderUtil.renderTableControl(null, sashForm, ntomModel, UIModelPackage.Literals.NTO_MEMF_MODEL__DEST_LIST, LabelAlignment.LEFT);

//        tableViewerSrc = new TableViewer(compSrc, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
//        Table tblSrc = tableViewerSrc.getTable();
//        FormData fd_tblSrc = new FormData();
//        fd_tblSrc.bottom = new FormAttachment(100);
//        fd_tblSrc.right = new FormAttachment(100);
//        fd_tblSrc.left = new FormAttachment(0);
//        tblSrc.setLayoutData(fd_tblSrc);
//
//        lblSrc = new Label(compSrc, SWT.CENTER);
//        fd_tblSrc.top = new FormAttachment(lblSrc);
//        FormData fd_lblSrc = new FormData();
//        fd_lblSrc.right = new FormAttachment(100);
//        fd_lblSrc.left = new FormAttachment(0);
//        lblSrc.setLayoutData(fd_lblSrc);
//        lblSrc.setText(Messages.get().nToMSrcLabel);
//
//        Composite compDest = new Composite(sashForm, SWT.NONE);
//        compDest.setLayout(new FormLayout());
//
//        lblDest = new Label(compDest, SWT.CENTER);
//        FormData fd_lblDest = new FormData();
//        fd_lblDest.right = new FormAttachment(100);
//        fd_lblDest.left = new FormAttachment(0);
//        lblDest.setLayoutData(fd_lblDest);
//        lblDest.setText(Messages.get().nToMDestLabel);
//
//        tableViewerDest = new TableViewer(compDest, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
//        Table tblDest = tableViewerDest.getTable();
//        FormData fd_tblDest = new FormData();
//        fd_tblDest.top = new FormAttachment(lblDest);
//        fd_tblDest.bottom = new FormAttachment(100);
//        fd_tblDest.right = new FormAttachment(100);
//        fd_tblDest.left = new FormAttachment(0);
//        tblDest.setLayoutData(fd_tblDest);
//
//        lblValidator = new Label(compDest, SWT.NONE);
//        FormData fd_lblNewLabel = new FormData();
//        fd_lblNewLabel.left = new FormAttachment(0);
//        lblValidator.setLayoutData(fd_lblNewLabel);

        sashForm.setWeights(new int[] { 1, 1 });

//        initCustomDataBindings();
//        initDataBindings();

        return grpMain;
    }

//    private void initCustomDataBindings() {
//        if (mainSetting.getEStructuralFeature().isRequired()) {
//            lblDest.setData(RWT.CUSTOM_VARIANT, "required");
//        }
//
//        List<T> srcList = ListUtils.subtract(EnhancedEnum.values((Class< ? extends EnhancedEnum>) clazz), (List<T>) mainSetting.get(true));
//
//        bindTable(tableViewerSrc, srcList, clazz, new String[] { "key" });
//        bindTable(tableViewerDest, (List<T>) mainSetting.get(true), clazz, new String[] { "key" });
//
//        tableViewerSrc.addOpenListener(new IOpenListener() {
//            @Override
//            public void open(OpenEvent event) {
//                moveElement(Direction.TO_DEST);
//            }
//        });
//
//        tableViewerDest.addOpenListener(new IOpenListener() {
//            @Override
//            public void open(OpenEvent event) {
//                moveElement(Direction.TO_SRC);
//            }
//        });
//    }

//    protected void initDataBindings() {
//        //
////        IObservableValue observeTextLblControlObserveWidget = new WidgetGroupTextProperty().observe(grpMain);
////        IObservableValue labelModelObserveValue = BeanProperties.value("label").observe();
////        bindingContext.bindValue(observeTextLblControlObserveWidget, labelModelObserveValue, null, null);
//
//        grpMain.setText(getItemPropertyDescriptor(mainSetting).getDisplayName(null));
//
//        //
//        IObservableValue observeEnabledCmdAllToSrcObserveWidget = WidgetProperties.enabled().observe(cmdAllToSrc);
//        IObservableValue emptyDestModelObserveValue = PojoProperties.value("empty").observe(tableViewerDest.getInput());
//        UpdateValueStrategy updateValueStrategy = new UpdateValueStrategy();
//        updateValueStrategy.setConverter(new TableInputToBooleanConverter(tableViewerDest));
//        allSrcBinding = getDataBindingContext().bindValue(observeEnabledCmdAllToSrcObserveWidget, emptyDestModelObserveValue, null,
//                updateValueStrategy);
//        //
//        //
//        IObservableValue observeEnabledCmdAllToDestObserveWidget = WidgetProperties.enabled().observe(cmdAllToDest);
//        IObservableValue emptySrcModelObserveValue = PojoProperties.value("empty").observe(tableViewerSrc.getInput());
//        UpdateValueStrategy updateValueStrategy2 = new UpdateValueStrategy();
//        updateValueStrategy2.setConverter(new TableInputToBooleanConverter(tableViewerSrc));
//        allDestBinding = getDataBindingContext().bindValue(observeEnabledCmdAllToDestObserveWidget, emptySrcModelObserveValue, null,
//                updateValueStrategy2);
//        //
//        IObservableValue enabledCmdToDestObserveValue = WidgetProperties.enabled().observe(cmdToDest);
//        IObservableValue selectionTableViewerSrcObserveValue = ViewerProperties.singleSelection().observe(tableViewerSrc);
//        UpdateValueStrategy updateValueStrategy3 = new UpdateValueStrategy();
//        updateValueStrategy3.setConverter(new ObjectToBooleanConverter(clazz));
//        srcBinding = getDataBindingContext().bindValue(enabledCmdToDestObserveValue, selectionTableViewerSrcObserveValue, null, updateValueStrategy3);
//        //
//        IObservableValue observeEnabledCmdToSrcObserveWidget = WidgetProperties.enabled().observe(cmdToSrc);
//        IObservableValue observeSingleSelectionTableViewer_1 = ViewerProperties.singleSelection().observe(tableViewerDest);
//        UpdateValueStrategy updateValueStrategy4 = new UpdateValueStrategy();
//        updateValueStrategy4.setConverter(new ObjectToBooleanConverter(clazz));
//        destBinding = getDataBindingContext().bindValue(observeEnabledCmdToSrcObserveWidget, observeSingleSelectionTableViewer_1, null,
//                updateValueStrategy4);
//
//        grpMain.setEnabled(mainSetting.getEStructuralFeature().isChangeable()
//                && getItemPropertyDescriptor(mainSetting).canSetProperty(mainSetting.getEObject()));
////
////        //
////        IObservableValue observeEnabledGrpMainObserveWidget = WidgetProperties.enabled().observe(grpMain);
////        IObservableValue enabledModelObserveValue = BeanProperties.value("changeable").observe(mainSetting.getEStructuralFeature());
////        getDataBindingContext().bindValue(observeEnabledGrpMainObserveWidget, enabledModelObserveValue, null, null);
//
//        //
////        multiValidator = new RequiredListValidator<>(modelProperty, lblValidator, SWT.RIGHT | SWT.TOP);
////        bindingContext.addValidationStatusProvider(multiValidator);
//    }

//    public void bindSelection(TableViewer tableViewer, List<T> model) {
//        if (model instanceof DtoListModel) {
//            IObservableValue observeTableViewerSelection = ViewerProperties.singleSelection().observe(tableViewer);
//            IObservableValue selectedDtoObserveValue = BeanProperties.value("selectedDto").observe(model);
//            UpdateValueStrategy noUpdateStrategy = new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER);
//
//            getDataBindingContext().bindValue(observeTableViewerSelection, selectedDtoObserveValue, null, noUpdateStrategy);
//        }
//
//        if (model.size() > 0) {
//            tableViewer.setSelection(new StructuredSelection(model.get(0)));
//        }
//    }

//    private <R extends Object> void bindContent(TableViewer tableViewer, List<T> model, Class<T> beanClass, String... propertyNames) {
//        ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
//        IObservableMap[] observeMaps = null;
//        if (IDtoModel.class.isAssignableFrom(beanClass)) {
//            observeMaps = BeansObservables.observeMaps(listContentProvider.getKnownElements(), beanClass, propertyNames);
//        } else {
//            observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), beanClass, propertyNames);
//        }
//
//        ConvertableObservableMapLabelProvider labelProvider = new ConvertableObservableMapLabelProvider(observeMaps);
//
//        tableViewer.setLabelProvider(labelProvider);
//        tableViewer.setContentProvider(listContentProvider);
//
//        IObservableList selfList = Properties.selfList(beanClass).observe(model);
//        tableViewer.setInput(selfList);
//
//        for (IObservableMap observableMap : observeMaps) {
//            observableMap.addMapChangeListener(new MapChangeListener(tableViewer));
//        }
//
//        bindSelection(tableViewer, model);
//    }

//    private void bindTable(TableViewer tableViewer, List<T> model, Class<T> beanClass, String[] propertyNames) {
//        bindTableColumn(tableViewer, beanClass, propertyNames);
//
//        bindContent(tableViewer, model, beanClass, propertyNames);
//
//        ControlUtils.pack(tableViewer);
//    }

//    private static <T extends AbstractEMFTemplate< ? >, D extends DtoModel> void bindTableColumn(TableViewer tableViewer,
//            Class< ? extends Object> beanClass, String... propertyNames) {
//        Table table = tableViewer.getTable();
//        table.setHeaderVisible(true);
//        table.setLinesVisible(true);
//
////        for (TableColumn tableColumn : tableViewer.getTable().getColumns()) {
////            tableColumn.dispose();
////        }
////
////        tableViewer.getTable().removeAll();
//
//        tableViewer.setComparator(new PropertyViewerComparator());
//
//        for (String propertyName : propertyNames) {
//            createTableColumn(tableViewer, beanClass, propertyName);
//        }
//
//    }

//    protected static void createTableColumn(TableViewer tableViewer, Class< ? extends Object> beanClass, String propertyName) {
//        for (TableColumn tableColumn : tableViewer.getTable().getColumns()) {
//            String columnName = (String) tableColumn.getData(IData.COLUMN_NAME);
//
//            if (propertyName.equals(columnName)) {
//                return;
//            }
//        }
//
//        TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
//        TableColumn tableColumn = tableViewerColumn.getColumn();
//
//        tableColumn.setData(IData.COLUMN_NAME, propertyName);
//        tableColumn.addSelectionListener(new DefaultSortSelectionListener(tableViewer, beanClass, propertyName));
//        tableColumn.setMoveable(true);
//        tableColumn.setResizable(true);
//
//        tableColumn.addSelectionListener(new DefaultSortSelectionListener(tableViewer, beanClass, propertyName));
//
//        tableColumn.setText(Messages.get(beanClass, propertyName));
//    }

//    void moveElement(Direction direction) {
//        T element = null;
//        List<T> inputSrc = (List<T>) tableViewerSrc.getInput();
//        List<T> inputDest = (List<T>) tableViewerDest.getInput();
//
//        IStructuredSelection selectionSrc = (IStructuredSelection) tableViewerSrc.getSelection();
//        IStructuredSelection selectionDest = (IStructuredSelection) tableViewerDest.getSelection();
//
//        int selSrc = tableViewerSrc.getTable().getSelectionIndex();
//        int selDest = tableViewerDest.getTable().getSelectionIndex();
//
//        switch (direction) {
//            case ALL_TO_SRC:
//
//                for (T s : inputDest) {
//                    if (!inputSrc.contains(s)) {
//                        inputSrc.add(s);
//                    }
//                }
//
//                inputDest.clear();
//
//                tableViewerSrc.getTable().setSelection(0);
//
//                break;
//            case TO_SRC:
//                element = (T) selectionDest.getFirstElement();
//
//                if (element != null) {
//                    inputDest.remove(element);
//
//                    if (!inputSrc.contains(element)) {
//                        inputSrc.add(element);
//                    }
//
//                    tableViewerSrc.setSelection(new StructuredSelection(element));
//                    tableViewerDest.getTable().setSelection(Math.max(0, Math.min(selDest, inputDest.size() - 1)));
//                }
//
//                break;
//            case TO_DEST:
//                element = (T) selectionSrc.getFirstElement();
//
//                if (element != null) {
//                    inputSrc.remove(element);
//
//                    if (!inputDest.contains(element)) {
//                        inputDest.add(element);
//                    }
//
//                    tableViewerDest.setSelection(new StructuredSelection(element));
//                    tableViewerSrc.getTable().setSelection(Math.max(0, Math.min(selSrc, inputSrc.size() - 1)));
//                }
//
//                break;
//            case ALL_TO_DEST:
//                for (T s : inputSrc) {
//                    if (!inputDest.contains(s)) {
//                        inputDest.add(s);
//                    }
//                }
//
//                inputSrc.clear();
//
//                tableViewerDest.getTable().setSelection(0);
//
//                break;
//        }
//
//        allSrcBinding.updateModelToTarget();
//        allDestBinding.updateModelToTarget();
//        srcBinding.updateModelToTarget();
//        destBinding.updateModelToTarget();
//
//        ControlUtils.refresh(tableViewerSrc);
//        ControlUtils.refresh(tableViewerDest);
//    }

}

package com.icteam.loyalty.ui.view;

import java.lang.reflect.ParameterizedType;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.interfaces.ModelInterfacesPackage;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.control.SWTRenderUtil;
import com.icteam.loyalty.ui.converter.CollectionToBooleanConverter;
import com.icteam.loyalty.ui.handler.DefaultContributionFactory;
import com.icteam.loyalty.ui.interfaces.IData;
import com.icteam.loyalty.ui.interfaces.IVirtualEMFView;
import com.icteam.loyalty.ui.model.UIModelPackage;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;
import com.icteam.loyalty.ui.util.TableTreeUtils;
import com.icteam.loyalty.ui.util.UIUtils;

public abstract class VirtualEMFView<T extends AbstractEMFTemplate< ? >, D extends EMFModel, V extends VirtualViewEMFModel<T, D>> extends ViewPart implements IVirtualEMFView<V> {

//    protected T template;
    private Composite parent;
    private Composite filterArea;
    private Composite tableViewerArea;
    Text text;
    protected String filter;

    private DataBindingContext bindingContext;
    private Button cmdFilterColumns;
    private Button cmdAdvancedFilter;
    private IMemento memento;
//    private final Class<D> dtoModelClass;
//    private final EClass dtoEClass;
//    private final Class<T> templateClass;
    private Class<V> virtualViewEMFModelModelClass;
    private V virtualViewEMFModel;

    public VirtualEMFView() {
//        templateClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//        dtoModelClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        try {
            virtualViewEMFModelModelClass = (Class<V>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
        } catch (Exception e) {
            // ignore now
        }
//        dtoEClass = ModelUtil.getEClass(dtoModelClass);
    }

    @Override
    public void dispose() {
        super.dispose();

        if (bindingContext != null) {
            bindingContext.dispose();
        }

        virtualViewEMFModel = null;
    }

    //    @Override
    @Override
    public final V getVirtualViewEMFModel() {
        if (virtualViewEMFModel == null) {
            virtualViewEMFModel = createVirtualViewEMFModel();
        }

        return virtualViewEMFModel;
    }

    protected V createVirtualViewEMFModel() {
        EClass dtoEClass = ModelUtil.getEClass(virtualViewEMFModelModelClass);

        EFactory factory = dtoEClass.getEPackage().getEFactoryInstance();
        V v = (V) factory.create(dtoEClass);
        v.setSearchProvider(getSearchProvider());

        return v;
    }

    @Override
    public void createPartControl(Composite p) {
        this.parent = p;
        parent.setLayout(new FormLayout());

        createFilterArea();

        createTableViewerArea();

        addActionToolbar();

        initBinding();

//        restoreSavedState();
    }

    protected void createTableViewerArea() {
        tableViewerArea = new Composite(parent, SWT.BORDER);
        FormData fd_editorArea = new FormData();
        fd_editorArea.top = new FormAttachment(filterArea, 0);
        fd_editorArea.right = new FormAttachment(100, 0);
        fd_editorArea.bottom = new FormAttachment(100, 0);
        fd_editorArea.left = new FormAttachment(0, 0);

        tableViewerArea.setLayout(new GridLayout(1, false));
        tableViewerArea.setLayoutData(fd_editorArea);

        Control control = SWTRenderUtil.renderTableControl(getViewSite(), tableViewerArea, getVirtualViewEMFModel(), UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__LIST);
        GridDataFactory.defaultsFor(control).applyTo(control);

//        fillTableViewerArea(tableViewerArea);
    }

    protected void createFilterArea() {
        filterArea = new Composite(parent, SWT.NONE);
        filterArea.setLayout(new FormLayout());

        FormData fd_filterArea = new FormData();
        fd_filterArea.right = new FormAttachment(100);
        fd_filterArea.top = new FormAttachment(0, 0);
        fd_filterArea.left = new FormAttachment(0, 0);

        filterArea.setLayoutData(fd_filterArea);

        fillFilterArea(filterArea);
    }

    private void restoreSavedState() {
        if (memento == null) {
            return;
        }

        try {
            IMemento colsMem = memento.getChild("VV_COLS");
            Control control = getColumnViewer().getControl();

            String colsOrderRaw = colsMem.getString("VV_COLS_ORDER");
            String[] colsOrdersStr = StringUtils.stripAll(StringUtils.split(colsOrderRaw, ","));

            int[] colsOrders = new int[colsOrdersStr.length];
            for (int i = 0; i < colsOrdersStr.length; i++) {
                colsOrders[i] = Integer.valueOf(colsOrdersStr[i]);
            }

            TableTreeUtils.setColumnOrder(control, colsOrders);

            int colsCount = colsMem.getInteger("VV_COLS_COUNT");

            for (int i = 0; i < colsCount; i++) {
                Item column = TableTreeUtils.getColumn(control, i);

                int width = colsMem.getInteger("VV_COL_WIDTH_" + i);
                TableTreeUtils.setColumnWidth(column, width);

                Object data = colsMem.getInteger("VV_COL_DATA_WIDTH_" + i);
                if (data != null) {
                    column.setData(IData.WIDTH, (int) data);
                }
            }

            int dynFilterCount = colsMem.getInteger("VV_COLS_FILTER_COUNT");
            EList<EStructuralFeature> dynFilterProps = ECollections.newBasicEList();
            for (int i = 0; i < dynFilterCount; i++) {
//                dynFilterProps.add(dtoEClass.getEStructuralFeature(colsMem.getString("VV_COLS_FILTER_" + i)));
            }

//            setFilterFeatures(dynFilterProps, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//
    private ColumnViewer getColumnViewer() {
        return null;
    }

    protected void fillFilterArea(Composite fa) {
        Composite filterComp = new Composite(fa, SWT.NONE);
        FormData fd_filterComp = new FormData();
        fd_filterComp.left = new FormAttachment(0, 0);
        filterComp.setLayoutData(fd_filterComp);
        filterComp.setLayout(new GridLayout(3, false));

        text = (Text) SWTRenderUtil.renderControl(filterComp, getVirtualViewEMFModel(), UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__FILTER);
        GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_text.minimumWidth = 100;
        text.setLayoutData(gd_text);

//        text = new Text(filterComp, SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
//        text.addSelectionListener(new SelectionAdapter() {
//            private static final long serialVersionUID = 1L;
//
//            @Override
//            public void widgetDefaultSelected(SelectionEvent e) {
//                try {
//                    setFilter(text.getText());
//                } catch (AppException ae) {
//                    UIUtils.showTooltip(getViewSite().getShell(), ae);
//
//                    e.doit = false;
//                    text.setText(StringUtils.defaultString(filter));
//                }
//            }
//        });
//
//        text.setMessage(Messages.get().filterMessage);

        cmdFilterColumns = (Button) SWTRenderUtil.renderControl(filterComp, getVirtualViewEMFModel(), UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__FILTER_COLUMNS_ACTION);
        GridData gd_cmdFilterColumns = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        cmdFilterColumns.setLayoutData(gd_cmdFilterColumns);

        cmdAdvancedFilter = (Button) SWTRenderUtil.renderControl(filterComp, getVirtualViewEMFModel(), UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__ADVANCED_FILTER_ACTION);
        cmdAdvancedFilter.setLayoutData(GridDataFactory.copyData(gd_cmdFilterColumns));

//        cmdFilterColumns = createFilterTableCommand(filterComp);
//
//        createSearchDialogCommand(filterComp);
//
//        GridData gd_cmdFilters = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
//        // design mode
//        if (cmdFilterColumns != null) {
//            cmdFilterColumns.setLayoutData(gd_cmdFilters);
//        }
    }

    public Composite getParent() {
        return parent;
    }

    protected void addActionToolbar() {
        String partId = getVirtualViewEMFModel().getViewID();

        DefaultContributionFactory.addToolbar(partId, getVirtualViewEMFModel(), UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__REFRESH_ACTION);
        DefaultContributionFactory.addToolbar(partId, getVirtualViewEMFModel(), UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__SELECT_COLUMN_ACTION);

        //        DefaultContributionFactory.addToolbarContribution(getViewID(), UI.RefreshViewEMFHandler_ID, "/icons/refresh.gif");
//        DefaultContributionFactory.addToolbarContribution(getViewID(), UI.ListColumnTableEMFHandler_ID, "/icons/edit-column.gif");

        DefaultContributionFactory.addToolbarSeparator(partId, "custom");

        DefaultContributionFactory.addToolbar(partId, getVirtualViewEMFModel(), UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__ADD_ACTION);
        DefaultContributionFactory.addToolbar(partId, getVirtualViewEMFModel(), UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__REMOVE_ACTION);

//        DefaultContributionFactory.addToolbar(getViewID(), getObjectID() + IConstants.UNDERSCORE + IConstants.ADD, "/icons/add.gif");
//        DefaultContributionFactory.addToolbar(getViewID(), getObjectID() + IConstants.UNDERSCORE + IConstants.REMOVE, "/icons/remove.gif");
    }

    @Override
    public void setFocus() {
//        getColumnViewer().getControl().setFocus();
    }

//    @Override
//    public T getTemplate() {
//        if (template == null) {
//            template = getDefaultTemplate();
//        }
//
//        return template;
//    }

//    @Override
//    public T getDefaultTemplate() {
//        return buildTemplate();
//    }

//    @Override
//    public String getFilter() {
//        return filter;
//    }
//
//    @Override
//    public void setFilter(String filter) {
//        if (!ObjectUtils.equals(filter, this.filter)) {
//            String oldFilter = this.filter;
//
//            getTemplate().setRawFilter(filter);
//
//            this.filter = filter;
//
//            text.setText(StringUtils.defaultString(filter));
//
//            if (!reload(true)) {
//                setFilter(oldFilter);
//            }
//        }
//    }

//    @Override
//    public void setAdvancedSearchTemplate(T template) {
//        T oldTemplate = this.template;
//
//        this.template = template;
//
//        if (!reload(true)) {
//            setAdvancedSearchTemplate(oldTemplate);
//        }
//    }

//    @Override
//    public void setFilterFeatures(EList<EStructuralFeature> filterFeatures, boolean reload) {
//        EList<EStructuralFeature> oldFilterFeatures = getTemplate().getDynamicFilterFeatures();
//
//        getTemplate().setDynamicFilterFeatures(filterFeatures);
//
//        if (reload) {
//            if (!reload(true)) {
//                setFilterFeatures(oldFilterFeatures, reload);
//            }
//        }
//
//        filterPropertiesBinding.updateModelToTarget();
//    }

    protected void initBinding() {
        if (bindingContext != null) {
            bindingContext.dispose();
        }

        bindingContext = new DataBindingContext();

        initCustomBindings();
        initDataBindings();
    }

    protected void initCustomBindings() {
    }

    protected void initDataBindings() {
        if (Realm.getDefault() == null) {
            return;
        }

        if (text != null) {
            IObservableValue observeEnabledFilterColumnActionObserveWidget = EMFObservables.observeValue(getVirtualViewEMFModel().getFilterColumnsAction(),
                    ModelInterfacesPackage.Literals.IEDITABLE__EDITABLE);

            IObservableList filterFeaturesTemplateObserveList = EMFProperties
                    .list(FeaturePath.fromList(UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__TEMPLATE, ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DYNAMIC_FILTER_FEATURES))
                    .observe(getVirtualViewEMFModel());
            filterFeaturesTemplateObserveList.addListChangeListener(new IListChangeListener() {
                @Override
                public void handleListChange(ListChangeEvent event) {
                    text.setEnabled(!getVirtualViewEMFModel().getTemplate().getDynamicFilterFeatures().isEmpty());
                }
            });

            IObservableValue filterDefaultFeaturesTemplateObserveValue = EMFProperties.value(
                    FeaturePath.fromList(UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__TEMPLATE, ModelInterfacesPackage.Literals.IEMF_TEMPLATE__DYNAMIC_FILTERABLE_FEATURES))
                    .observe(getVirtualViewEMFModel());

            UpdateValueStrategy updateValueStrategy = new UpdateValueStrategy();
            updateValueStrategy.setConverter(new CollectionToBooleanConverter());

            bindingContext.bindValue(observeEnabledFilterColumnActionObserveWidget, filterDefaultFeaturesTemplateObserveValue, null, updateValueStrategy);
        }

        IObservableList observableList = EMFObservables.observeList(getVirtualViewEMFModel(), UIModelPackage.Literals.VIRTUAL_VIEW_EMF_MODEL__SELECTED_LIST);
        observableList.addListChangeListener(new IListChangeListener() {
            @Override
            public void handleListChange(ListChangeEvent event) {
                if (!getVirtualViewEMFModel().getSelectedList().isEmpty()) {
                    D model = getVirtualViewEMFModel().getSelectedList().get(0);

                    IEditorPart editorPart = getVirtualViewEMFModel().findEditor(model);

                    if (editorPart != null) {
                        UIUtils.getActivePage().bringToTop(editorPart);
                    }
                }
            }
        });
    }

//    @Override
//    public Class<D> getDtoModelClass() {
//        return dtoModelClass;
//    }

//    public Class<T> getTemplateClass() {
//        return templateClass;
//    }

//    public EClass getDtoEClass() {
//        return dtoEClass;
//    }

//    @Override
//    public List<D> getViewInput() {
//        return (List<D>) getColumnViewer().getInput();
//    }

    @Override
    public void saveState(IMemento memento) {
        super.saveState(memento);

//        try {
//            IMemento colsMem = memento.createChild("VV_COLS");
//            Control control = getColumnViewer().getControl();
//
//            String colsOrderRaw = Arrays.toString(TableTreeUtils.getColumnOrder(control));
//            colsOrderRaw = colsOrderRaw.substring(1, colsOrderRaw.length() - 1);
//
//            colsMem.putString("VV_COLS_ORDER", colsOrderRaw);
//            colsMem.putInteger("VV_COLS_COUNT", TableTreeUtils.getColumnCount(control));
//
//            Item[] columns = TableTreeUtils.getColumns(control);
//
//            for (int i = 0; i < columns.length; i++) {
//                colsMem.putInteger("VV_COL_WIDTH_" + i, TableTreeUtils.getColumnWidth(columns[i]));
//                Object data = columns[i].getData(IData.WIDTH);
//                if (data != null) {
//                    colsMem.putInteger("VV_COL_DATA_WIDTH_" + i, (int) data);
//                }
//            }
//
//            colsMem.putInteger("VV_COLS_FILTER_COUNT", getVirtualViewEMFModel().getTemplate().getDynamicFilterFeatures().size());
//            for (int i = 0; i < getVirtualViewEMFModel().getTemplate().getDynamicFilterFeatures().size(); i++) {
//                colsMem.putString("VV_COLS_FILTER_" + i, getVirtualViewEMFModel().getTemplate().getDynamicFilterFeatures().get(i).getName());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void init(IViewSite site, IMemento memento) throws PartInitException {
        super.init(site, memento);

        this.memento = memento;
    }

//    @Override
//    public boolean reload(boolean closeEditors) {
//        try {
//            final ColumnViewer columnViewer = getColumnViewer();
//            final Control control = columnViewer.getControl();
//
//            Listener[] listeners = control.getListeners(SWT.SetData);
//
//            for (Listener listener : listeners) {
//                control.removeListener(SWT.SetData, listener);
//            }
//
//            TableTreeUtils.clear(columnViewer, createDtoPlaceholder());
//
//            for (Listener listener : listeners) {
//                control.addListener(SWT.SetData, listener);
//            }
//
//            TableTreeUtils.clearAll(control);
//
//            bindItemCount();
//
//            ControlUtils.pack(columnViewer, true);
//        } catch (AppException e) {
//            MessageDialog.openError(getSite().getShell(), Messages.get().loadError, e.getLocalizedMessage());
//            return false;
//        }
//
//        return true;
//    }

//    private void bindItemCount() {
////        int itemCount = handleCount(getVirtualViewEMFModel().getTemplate());
////
////        TableTreeUtils.setItemCount(getColumnViewer(), itemCount);
//    }
//
//    protected D createDtoPlaceholder() {
//        return (D) dtoEClass.getEPackage().getEFactoryInstance().create(dtoEClass);
//    }

//    private void bindVirtualTableColumn(EStructuralFeature... featureColumns) {
//        Control control = getColumnViewer().getControl();
//        TableTreeUtils.setHeaderVisible(control, true);
//        TableTreeUtils.setLinesVisible(control, true);
//
//        for (EStructuralFeature structuralFeature : featureColumns) {
//            ViewerColumn viewerColumn = TableTreeUtils.newColumnViewer(getColumnViewer(), SWT.NONE);
//
//            Item column = TableTreeUtils.getColumn(viewerColumn);
//            TableTreeUtils.setColumnMoveable(column, true);
//            TableTreeUtils.setColumnResizable(column, true);
//
////            addSortListener(column, structuralFeature);
//
////            column.setText(ModelUtil.getDiplayName(createDtoPlaceholder(), structuralFeature));
//            column.setData(IData.COLUMN_FEATURE, structuralFeature);
//        }
//    }
//
//    private void addSortListener(Item column, EStructuralFeature structuralFeature) {
//        if (column instanceof TableColumn) {
//            ((TableColumn) column).addSelectionListener(new VirtualSortSelectionEMFListener<>(getVirtualViewEMFModel(),
//                    (TableViewer) getColumnViewer(), getVirtualViewEMFModel().getDtoModelClass(), structuralFeature));
//        }
//    }

//    private void bindLazyContent(EStructuralFeature... featureColumns) {
//        ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
//        IObservableMap[] observeMaps = null;
//        if (EMFModel.class.isAssignableFrom(getVirtualViewEMFModel().getModelClass())) {
//            observeMaps = EMFObservables.observeMaps(listContentProvider.getKnownElements(), featureColumns);
//        } else {
////            observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), getDtoModelClass(), propertyNames);
//        }
//
//        ConvertableObservableMapLabelEMFProvider labelProvider = new ConvertableObservableMapLabelEMFProvider(observeMaps, featureColumns);
//
//        ColumnViewer tableViewer = getColumnViewer();
//        tableViewer.setLabelProvider(labelProvider);
//        tableViewer.setContentProvider(listContentProvider);
//
//        IObservableList selfList = Properties.selfList(getVirtualViewEMFModel().getModelClass()).observe(new ArrayList<>()); // lista vuota popolata in lazy
//        tableViewer.setInput(selfList);
//
//        bindItemCount();
//
//        for (IObservableMap observableMap : observeMaps) {
//            observableMap.addMapChangeListener(new MapChangeListener(tableViewer));
//        }
//
////        selfList.addListChangeListener(new ListChangeListener(tableViewer, createDtoPlaceholder()));
//    }

//    private void bindVirtualListener() {
////        if (getColumnViewer() instanceof TableViewer) {
////            getColumnViewer().getControl().addListener(SWT.SetData,
////                    new VirtuaTableEMFListener<>(getVirtualViewEMFModel(), (TableViewer) getColumnViewer(), createDtoPlaceholder()));
////        }
//    }
//
//    private void bindViewTableSelection() {
//        ColumnViewer columnViewer = getColumnViewer();
//
////        columnViewer.addOpenListener(new OpenEditorEMFListener<>(getEditorID(), this));
////        columnViewer.addSelectionChangedListener(new SelectionChangeEMFListener<D>());
//
//        getViewSite().setSelectionProvider(columnViewer);
//    }
//
//    private void bindViewTable() {
////        EStructuralFeature[] featureColumns = ModelUtil.collectEMFFeatureColumns(getDtoEClass());
////
////        bindVirtualTableColumn(featureColumns);
////
////        bindLazyContent(featureColumns);
////
////        bindVirtualListener();
////
////        ControlUtils.pack(getColumnViewer());
//    }

//    protected boolean hasCustomFilter() {
//        return !StringUtils.isBlank(filter) || template.isDirty();
//    }
}

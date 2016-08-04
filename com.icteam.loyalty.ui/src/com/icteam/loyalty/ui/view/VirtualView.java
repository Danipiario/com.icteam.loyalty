package com.icteam.loyalty.ui.view;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.ResourceManager;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.api.AppException;
import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.api.interfaces.IConstants;
import com.icteam.loyalty.model.DtoModel;
import com.icteam.loyalty.model.ModelBuilder;
import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.model.template.AbstractTemplate;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.UI;
import com.icteam.loyalty.ui.converter.CollectionToBooleanConverter;
import com.icteam.loyalty.ui.converter.ConvertableObservableMapLabelProvider;
import com.icteam.loyalty.ui.handler.DefaultContributionFactory;
import com.icteam.loyalty.ui.handler.WidgetCommandContributionItem;
import com.icteam.loyalty.ui.interfaces.IData;
import com.icteam.loyalty.ui.interfaces.IVirtualView;
import com.icteam.loyalty.ui.listener.ListChangeListener;
import com.icteam.loyalty.ui.listener.MapChangeListener;
import com.icteam.loyalty.ui.listener.OpenEditorListener;
import com.icteam.loyalty.ui.listener.PartListenerActivateEditor;
import com.icteam.loyalty.ui.listener.SelectionChangeListener;
import com.icteam.loyalty.ui.listener.VirtuaTableListener;
import com.icteam.loyalty.ui.listener.VirtualSortSelectionListener;
import com.icteam.loyalty.ui.util.ControlUtils;
import com.icteam.loyalty.ui.util.TableTreeUtils;
import com.icteam.loyalty.ui.util.UIUtils;

public abstract class VirtualView<T extends AbstractTemplate< ? >, D extends DtoModel> extends ViewPart implements IVirtualView<T, D> {

    protected T template;
    private Composite parent;
    private Composite filterArea;
    private Composite tableViewerArea;
    Text text;
    protected String filter;

    private DataBindingContext bindingContext;
    private Binding filterPropertiesBinding;
    private Button cmdFilters;
    private IMemento memento;
    private final Class<D> dtoModelClass;
    private final Class<T> templateClass;

    private ServiceTracker<ModelBuilder<D>, ModelBuilder<D>> modelBuilderServiceTracker;

    public VirtualView() {
        templateClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        dtoModelClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    private void initModelBuilderServiceTracker() {
        Filter filter;
        try {
            filter = FrameworkUtil.createFilter("(&("
                    + Constants.OBJECTCLASS
                    + "="
                    + ModelBuilder.class.getName()
                    + ")(dto.model="
                    + dtoModelClass.getSimpleName()
                    + "))");

            modelBuilderServiceTracker = new ServiceTracker<>(FrameworkUtil.getBundle(getClass()).getBundleContext(), filter, null);

            modelBuilderServiceTracker.open();
        } catch (InvalidSyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ModelBuilder<D> getModelBuilder() {
        return modelBuilderServiceTracker.getService();
    }

    @Override
    public void createPartControl(Composite p) {
        this.parent = p;
        parent.setLayout(new FormLayout());

        createFilterArea();

        createTableViewerArea();

        addActionToolbar();

        initBinding();

        restoreSavedState();
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

        fillTableViewerArea(tableViewerArea);
    }

    protected void createFilterArea() {
        filterArea = new Composite(parent, SWT.NONE);
        filterArea.setLayout(new FormLayout());

        FormData fd_buttonArea = new FormData();
        fd_buttonArea.right = new FormAttachment(100);
        fd_buttonArea.top = new FormAttachment(0, 0);
        fd_buttonArea.left = new FormAttachment(0, 0);

        filterArea.setLayoutData(fd_buttonArea);

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
            List<String> dynFilterProps = new ArrayList<>();
            for (int i = 0; i < dynFilterCount; i++) {
                dynFilterProps.add(colsMem.getString("VV_COLS_FILTER_" + i));
            }

            setFilterProperties(dynFilterProps, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void fillTableViewerArea(Composite tva);

    protected void fillFilterArea(Composite fa) {
        Composite filterComp = new Composite(fa, SWT.NONE);
        FormData fd_filterComp = new FormData();
        fd_filterComp.left = new FormAttachment(0, 0);
        filterComp.setLayoutData(fd_filterComp);
        filterComp.setLayout(new GridLayout(3, false));

        text = new Text(filterComp, SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
        GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
        gd_text.minimumWidth = 100;
        text.setLayoutData(gd_text);
        text.addSelectionListener(new SelectionAdapter() {
            private static final long serialVersionUID = 1L;

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                try {
                    setFilter(text.getText());
                } catch (AppException ae) {
                    UIUtils.showTooltip(getViewSite().getShell(), ae);

                    e.doit = false;
                    text.setText(StringUtils.defaultString(filter));
                }
            }
        });

        text.setMessage(Messages.get().filterMessage);

        cmdFilters = createFilterTableCommand(filterComp);

        createSearchDialogCommand(filterComp);

        GridData gd_cmdFilters = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        // design mode
        if (cmdFilters != null) {
            cmdFilters.setLayoutData(gd_cmdFilters);
        }
    }

    public Composite getParent() {
        return parent;
    }

    @Override
    public abstract String getViewID();

    @Override
    public abstract String getEditorID();

    protected void addActionToolbar() {
        DefaultContributionFactory.addToolbarContribution(getViewID(), UI.RefreshViewEMFHandler_ID, "/icons/refresh.gif");
        DefaultContributionFactory.addToolbarContribution(getViewID(), UI.ListColumnTableEMFHandler_ID, "/icons/edit-column.gif");

        DefaultContributionFactory.addToolbarSeparator(getViewID(), "custom");

        DefaultContributionFactory.addToolbar(getViewID(), getObjectID() + IConstants.UNDERSCORE + IConstants.ADD, "/icons/add.gif");
        DefaultContributionFactory.addToolbar(getViewID(), getObjectID() + IConstants.UNDERSCORE + IConstants.REMOVE, "/icons/remove.gif");
    }

    private static Button createFilterTableCommand(Composite comp) {
        ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
        Command filterCommand = commandService.getCommand(UI.FilterTableEMFHandler_ID);

        CommandContributionItemParameter p = new CommandContributionItemParameter(PlatformUI.getWorkbench(), "", filterCommand.getId(),
                CommandContributionItem.STYLE_PUSH);
        p.icon = ResourceManager.getImageDescriptor(IVirtualView.class, "/icons/filter.gif");
        p.label = "";
        try {
            p.tooltip = filterCommand.getDescription();
        } catch (NotDefinedException e) {
            e.printStackTrace();
        }
        // p.label = "Exit the application";
        WidgetCommandContributionItem item = new WidgetCommandContributionItem(p);
        item.setVisible(true);
        item.fill(comp);

        return item.getButton();
    }

    private static Button createSearchDialogCommand(Composite comp) {
        ICommandService commandService = (ICommandService) PlatformUI.getWorkbench().getService(ICommandService.class);
        Command searchDialogCommand = commandService.getCommand(UI.AdvancedSearchDialogEMFHandler_ID);

        CommandContributionItemParameter p = new CommandContributionItemParameter(PlatformUI.getWorkbench(), "", searchDialogCommand.getId(),
                CommandContributionItem.STYLE_PUSH);
        p.icon = ResourceManager.getImageDescriptor(IVirtualView.class, "/icons/advanced_search.gif");
        p.label = "";
        try {
            p.tooltip = searchDialogCommand.getDescription();
        } catch (NotDefinedException e) {
            e.printStackTrace();
        }
        // p.label = "Exit the application";
        WidgetCommandContributionItem item = new WidgetCommandContributionItem(p);
        item.setVisible(true);
        item.fill(comp);

        return item.getButton();
    }

    @Override
    public void setFocus() {
        getColumnViewer().getControl().setFocus();
    }

    @Override
    public T getTemplate() {
        if (template == null) {
            template = getDefaultTemplate();
        }

        return template;
    }

    @Override
    public T getDefaultTemplate() {
        return buildTemplate();
    }

    @Override
    public String getFilter() {
        return filter;
    }

    @Override
    public void setFilter(String filter) {
        if (!ObjectUtils.equals(filter, this.filter)) {
            String oldFilter = this.filter;

            getTemplate().setRawFilter(filter);

            this.filter = filter;

            text.setText(StringUtils.defaultString(filter));

            if (!reload(true)) {
                setFilter(oldFilter);
            }
        }
    }

    @Override
    public void setAdvancedSearchTemplate(T template) {
        T oldTemplate = this.template;

        this.template = template;

        if (!reload(true)) {
            setAdvancedSearchTemplate(oldTemplate);
        }
    }

    @Override
    public void setFilterProperties(List<String> filterProperties, boolean reload) {
        List<String> oldFilterProperties = getTemplate().getDynamicFilterProperties();

        getTemplate().setDynamicFilterProperties(filterProperties);

        if (reload) {
            if (!reload(true)) {
                setFilterProperties(oldFilterProperties, reload);
            }
        }

        filterPropertiesBinding.updateModelToTarget();
    }

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

        //
        if (text != null) {
            IObservableValue observeEnabledTextObserveWidget = WidgetProperties.enabled().observe(text);
            IObservableValue filterPropertiesTemplateObserveValue = PojoProperties.value("dynamicFilterProperties").observe(getTemplate());

            UpdateValueStrategy updateValueStrategy = new UpdateValueStrategy();
            updateValueStrategy.setConverter(new CollectionToBooleanConverter());
            filterPropertiesBinding = bindingContext.bindValue(observeEnabledTextObserveWidget, filterPropertiesTemplateObserveValue, null,
                    updateValueStrategy);
        }

        // $hide>>$
        // Add the IPartListener2 to the page
        IWorkbenchPage page = this.getSite().getPage();
        page.addPartListener(new PartListenerActivateEditor<>(this));
        // $hide<<$
    }

    @Override
    public Class<D> getDtoModelClass() {
        return dtoModelClass;
    }

    public Class<T> getTemplateClass() {
        return templateClass;
    }

    @Override
    public List<D> getViewInput() {
        return (List<D>) getColumnViewer().getInput();
    }

    @Override
    public void saveState(IMemento memento) {
        super.saveState(memento);

        try {
            IMemento colsMem = memento.createChild("VV_COLS");
            Control control = getColumnViewer().getControl();

            String colsOrderRaw = Arrays.toString(TableTreeUtils.getColumnOrder(control));
            colsOrderRaw = colsOrderRaw.substring(1, colsOrderRaw.length() - 1);

            colsMem.putString("VV_COLS_ORDER", colsOrderRaw);
            colsMem.putInteger("VV_COLS_COUNT", TableTreeUtils.getColumnCount(control));

            Item[] columns = TableTreeUtils.getColumns(control);

            for (int i = 0; i < columns.length; i++) {
                colsMem.putInteger("VV_COL_WIDTH_" + i, TableTreeUtils.getColumnWidth(columns[i]));
                Object data = columns[i].getData(IData.WIDTH);
                if (data != null) {
                    colsMem.putInteger("VV_COL_DATA_WIDTH_" + i, (int) data);
                }
            }

            colsMem.putInteger("VV_COLS_FILTER_COUNT", getTemplate().getDynamicFilterProperties().size());
            for (int i = 0; i < getTemplate().getDynamicFilterProperties().size(); i++) {
                colsMem.putString("VV_COLS_FILTER_" + i, getTemplate().getDynamicFilterProperties().get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(IViewSite site, IMemento memento) throws PartInitException {
        super.init(site, memento);

        this.memento = memento;

        initModelBuilderServiceTracker();
    }

    @Override
    public void dispose() {
        super.dispose();

        if (modelBuilderServiceTracker != null) {
            modelBuilderServiceTracker.close();
        }
    }

    @Override
    public boolean reload(boolean closeEditors) {
        try {
            final ColumnViewer columnViewer = getColumnViewer();
            final Control control = columnViewer.getControl();

            Listener[] listeners = control.getListeners(SWT.SetData);

            for (Listener listener : listeners) {
                control.removeListener(SWT.SetData, listener);
            }

            TableTreeUtils.clear(columnViewer, createDtoPlaceholder());

            for (Listener listener : listeners) {
                control.addListener(SWT.SetData, listener);
            }

            TableTreeUtils.clearAll(control);

            bindItemCount();

            ControlUtils.pack(columnViewer, true);

            if (closeEditors) {
                closeEditors();
            }
        } catch (AppException e) {
            MessageDialog.openError(getSite().getShell(), Messages.get().loadError, e.getLocalizedMessage());
            return false;
        }

        return true;
    }

    protected void closeEditors() {
        IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getEditorReferences();
        List<IEditorReference> list = new ArrayList<>();

        for (IEditorReference editorReference : editorReferences) {
            if (editorReference.getId().equals(getEditorID())) {
                list.add(editorReference);
            }
        }

        PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditors(list.toArray(new IEditorReference[] {}), true);
    }

    void bindItemCount() {
        int itemCount = handleCount(getTemplate());

        TableTreeUtils.setItemCount(getColumnViewer(), itemCount);
    }

    protected D createDtoPlaceholder() {
        return getModelBuilder().newDto();
    }

    void bindVirtualTableColumn(String... propertyNames) {
        Control control = getColumnViewer().getControl();
        TableTreeUtils.setHeaderVisible(control, true);
        TableTreeUtils.setLinesVisible(control, true);

        for (String propertyName : propertyNames) {
            ViewerColumn viewerColumn = TableTreeUtils.newColumnViewer(getColumnViewer(), SWT.NONE);

            Item column = TableTreeUtils.getColumn(viewerColumn);
            TableTreeUtils.setColumnMoveable(column, true);
            TableTreeUtils.setColumnResizable(column, true);

            addSortListener(column, propertyName);

            column.setText(Messages.get(getDtoModelClass(), propertyName));
            column.setData(IData.COLUMN_NAME, propertyName);
        }
    }

    private void addSortListener(Item column, String propertyName) {
        if (column instanceof TableColumn) {
            ((TableColumn) column).addSelectionListener(new VirtualSortSelectionListener<>(this, getDtoModelClass(), propertyName));
        }
    }

    private void bindLazyContent(String... propertyNames) {
        ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
        IObservableMap[] observeMaps = null;
        if (IDtoModel.class.isAssignableFrom(getDtoModelClass())) {
            observeMaps = BeansObservables.observeMaps(listContentProvider.getKnownElements(), getDtoModelClass(), propertyNames);
        } else {
            observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), getDtoModelClass(), propertyNames);
        }

        //        IObservableMap[] observeMaps = BeansObservables.observeMaps(listContentProvider.getKnownElements(), beanClass, propertyNames);
        //        observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), beanClass, propertyNames);

        ConvertableObservableMapLabelProvider labelProvider = new ConvertableObservableMapLabelProvider(observeMaps);

        ColumnViewer tableViewer = getColumnViewer();
        tableViewer.setLabelProvider(labelProvider);
        tableViewer.setContentProvider(listContentProvider);

        IObservableList selfList = Properties.selfList(getDtoModelClass()).observe(new ArrayList<>()); // lista vuota popolata in lazy
        tableViewer.setInput(selfList);

        bindItemCount();

        for (IObservableMap observableMap : observeMaps) {
            observableMap.addMapChangeListener(new MapChangeListener(tableViewer));
        }

        selfList.addListChangeListener(new ListChangeListener(tableViewer, createDtoPlaceholder()));
    }

    private void bindVirtualListener() {
        if (getColumnViewer() instanceof TableViewer) {
            getColumnViewer().getControl().addListener(SWT.SetData, new VirtuaTableListener<>(this, createDtoPlaceholder()));
        }
    }

    public void bindViewTableSelection() {
        ColumnViewer columnViewer = getColumnViewer();

        columnViewer.addOpenListener(new OpenEditorListener<>(getEditorID(), this));
        columnViewer.addSelectionChangedListener(new SelectionChangeListener<D>());

        getViewSite().setSelectionProvider(columnViewer);
    }

    public void bindViewTable() {
        String[] propertyNames = ModelUtil.collectPropertyNames(getDtoModelClass());

        bindVirtualTableColumn(propertyNames);

        bindLazyContent(propertyNames);

        bindVirtualListener();

        ControlUtils.pack(getColumnViewer());
    }

    protected boolean hasCustomFilter() {
        return !StringUtils.isBlank(filter) || template.isDirty();
    }
}

package com.icteam.loyalty.ui.control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.internal.databinding.swt.WidgetGroupTextProperty;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.ui.converter.ConvertableObservableMapLabelProvider;
import com.icteam.loyalty.ui.interfaces.IBindedControl;
import com.icteam.loyalty.ui.interfaces.IData;
import com.icteam.loyalty.ui.interfaces.IModelProvider;
import com.icteam.loyalty.ui.listener.DefaultSortSelectionListener;
import com.icteam.loyalty.ui.listener.MapChangeListener;
import com.icteam.loyalty.ui.model.TableViewerModel;
import com.icteam.loyalty.ui.util.BinderUtils;
import com.icteam.loyalty.ui.util.ControlUtils;
import com.icteam.loyalty.ui.util.PropertyViewerComparator;
import com.icteam.loyalty.ui.validator.RequiredListValidator;

public class LabelTableViewer<M extends IModel, S extends Object> extends Group implements IBindedControl,
        IModelProvider<M, List<S>, TableViewerModel<M, S>> {

    private static final long serialVersionUID = -8536935429447636321L;

    private DataBindingContext bindingContext;

    private TableViewerModel<M, S> modelProperty;

    private final TableViewer tableViewer;

    private RequiredListValidator<M, S> multiValidator;

    private final Label lblValidator;

    private final Table table;

    public LabelTableViewer(Composite parent, int style) {
        super(parent, style | SWT.NO_FOCUS);

        setLayout(new FormLayout());

        tableViewer = new TableViewer(this, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        table = tableViewer.getTable();
        table.setData(RWT.MARKUP_ENABLED, Boolean.TRUE);

        FormData fd_tbl = new FormData();
        fd_tbl.top = new FormAttachment(0);
        fd_tbl.bottom = new FormAttachment(100);
        fd_tbl.right = new FormAttachment(100);
        fd_tbl.left = new FormAttachment(0);
        table.setLayoutData(fd_tbl);

        lblValidator = new Label(this, SWT.NONE);
        FormData fd_lblNewLabel = new FormData();
        fd_lblNewLabel.top = new FormAttachment(0, -10);
        lblValidator.setLayoutData(fd_lblNewLabel);
    }

    @Override
    public void setLayoutData(Object layoutData) {
        super.setLayoutData(layoutData);
    }

    public TableViewer getTableViewer() {
        return tableViewer;
    }

    public Table getTable() {
        return table;
    }

    @Override
    public TableViewerModel<M, S> getModelProperty() {
        return modelProperty;
    }

    @Override
    protected void checkSubclass() {
        // Disable the check that prevents subclassing of SWT components
    }

    public void setModelProperty(M model, String property, Class<S> itemClass, String... propertyNames) {
        modelProperty = new TableViewerModel<>(model, property, itemClass, propertyNames);

        initBinding();

        modelProperty.addPropertyChangeListener("propertyValue", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                setTableInput();
            }
        });
    }

    protected void initBinding() {
        if (bindingContext != null) {
            bindingContext.dispose();
        }

        bindingContext = new DataBindingContext();

        initCustomDataBindings();
        initDataBindings();
    }

    private void initCustomDataBindings() {
        bindColumns();

        bindContent();

        ControlUtils.pack(tableViewer);
    }

    private void bindContent() {
        ObservableListContentProvider listContentProvider = new ObservableListContentProvider();

        IObservableMap[] observeMaps = null;
        Class<S> itemClass = modelProperty.getItemClass();

        if (IDtoModel.class.isAssignableFrom(itemClass)) {
            observeMaps = BeansObservables.observeMaps(listContentProvider.getKnownElements(), itemClass, modelProperty.getPropertyNames());
        } else {
            observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), itemClass, modelProperty.getPropertyNames());
        }

        ConvertableObservableMapLabelProvider labelProvider = new ConvertableObservableMapLabelProvider(observeMaps);

        tableViewer.setLabelProvider(labelProvider);
        tableViewer.setContentProvider(listContentProvider);

        setTableInput();

        for (IObservableMap observableMap : observeMaps) {
            observableMap.addMapChangeListener(new MapChangeListener(tableViewer));
        }

        bindSelection();
    }

    void setTableInput() {
        IObservableList selfList = Properties.selfList(modelProperty.getItemClass()).observe(modelProperty.getPropertyValue());

        tableViewer.setInput(selfList);
    }

    private void bindSelection() {
        if (modelProperty.isDtoListModel()) {
            IObservableValue observeTableViewerSelection = ViewerProperties.singleSelection().observe(tableViewer);
            IObservableValue selectedDtoObserveValue = BeanProperties.value("selectedDto").observe(modelProperty.getModel());
            UpdateValueStrategy noUpdateStrategy = new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER);

            bindingContext.bindValue(observeTableViewerSelection, selectedDtoObserveValue, null, noUpdateStrategy);
        }

        IObservableValue observeTableViewerSelection = ViewerProperties.singleSelection().observe(tableViewer);
        IObservableValue selectedDtoObserveValue = BeanProperties.value("selectedItem").observe(modelProperty);
        UpdateValueStrategy noUpdateStrategy = new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER);

        bindingContext.bindValue(observeTableViewerSelection, selectedDtoObserveValue, null, noUpdateStrategy);

        IObservableList list = (IObservableList) tableViewer.getInput();

        if (list.size() > 0) {
            tableViewer.setSelection(new StructuredSelection(list.get(0)));
        }
    }

    private void bindColumns() {
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        tableViewer.setComparator(new PropertyViewerComparator());

        for (String propertyName : modelProperty.getPropertyNames()) {
            createTableColumn(tableViewer, modelProperty.getItemClass(), propertyName);
        }

    }

    protected static void createTableColumn(TableViewer tableViewer, Class< ? extends Object> beanClass, String propertyName) {
        for (TableColumn tableColumn : tableViewer.getTable().getColumns()) {
            String columnName = (String) tableColumn.getData(IData.COLUMN_NAME);

            if (propertyName.equals(columnName)) {
                return;
            }
        }

        TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
        TableColumn tableColumn = tableViewerColumn.getColumn();

        tableColumn.setData(IData.COLUMN_NAME, propertyName);
        tableColumn.addSelectionListener(new DefaultSortSelectionListener(tableViewer, beanClass, propertyName));
        tableColumn.setMoveable(true);
        tableColumn.setResizable(true);

        tableColumn.addSelectionListener(new DefaultSortSelectionListener(tableViewer, beanClass, propertyName));

        tableColumn.setText(Messages.get(beanClass, propertyName));
    }

    protected void initDataBindings() {
        //
        IObservableValue observeTextLblControlObserveWidget = new WidgetGroupTextProperty().observe(this);
        IObservableValue labelModelObserveValue = BeanProperties.value("label").observe(modelProperty);
        bindingContext.bindValue(observeTextLblControlObserveWidget, labelModelObserveValue, null, null);
        //
        IObservableValue observeEnabledGrpMainObserveWidget = WidgetProperties.enabled().observe(this);
        final IObservableValue enabledModelObserveValue = BeanProperties.value("enabled").observe(modelProperty);
        final IObservableValue editableModelObserveValue = BeanProperties.value("editable").observe(modelProperty);

        IObservableValue observeEnableEditableValue = new ComputedValue() {
            @Override
            protected Object calculate() {
                return (Boolean) enabledModelObserveValue.getValue() && (Boolean) editableModelObserveValue.getValue();
            }
        };

        bindingContext.bindValue(observeEnabledGrpMainObserveWidget, observeEnableEditableValue, null, null);

        //
        multiValidator = new RequiredListValidator<>(modelProperty, tableViewer.getTable(), SWT.LEFT | SWT.TOP);
        bindingContext.addValidationStatusProvider(multiValidator);
    }

    @Override
    public DataBindingContext getBindingContext() {
        return bindingContext;
    }

    @Override
    public void updateModelToTarget() {
        ControlUtils.refresh(tableViewer);

        multiValidator.forceRevalidate();
    }

    @Override
    public BindingStatus validate() {
        multiValidator.forceRevalidate();

        return BinderUtils.validate(this);
    }

    @Override
    public boolean setFocus() {
        return table.setFocus();
    }

    @Override
    public boolean isFocusControl() {
        return table.isFocusControl();
    }

}

package com.icteam.loyalty.ui.control;

import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.core.internal.databinding.BindingStatus;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.internal.databinding.swt.WidgetGroupTextProperty;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.model.DtoListModel;
import com.icteam.loyalty.model.DtoModel;
import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.model.interfaces.IModel;
import com.icteam.loyalty.model.template.AbstractTemplate;
import com.icteam.loyalty.ui.converter.ConvertableObservableMapLabelProvider;
import com.icteam.loyalty.ui.converter.ObjectToBooleanConverter;
import com.icteam.loyalty.ui.converter.TableInputToBooleanConverter;
import com.icteam.loyalty.ui.interfaces.IBindedControl;
import com.icteam.loyalty.ui.interfaces.IData;
import com.icteam.loyalty.ui.interfaces.IModelProvider;
import com.icteam.loyalty.ui.listener.DefaultSortSelectionListener;
import com.icteam.loyalty.ui.listener.MapChangeListener;
import com.icteam.loyalty.ui.model.NToMModel;
import com.icteam.loyalty.ui.util.BinderUtils;
import com.icteam.loyalty.ui.util.ControlUtils;
import com.icteam.loyalty.ui.util.PropertyViewerComparator;
import com.icteam.loyalty.ui.validator.RequiredListValidator;

public class NToM<M extends IModel, S extends Object> extends Composite implements IBindedControl, IModelProvider<M, List<S>, NToMModel<M, S>> {

    private static final long serialVersionUID = -8536935429447636321L;

    enum Direction {
        TO_SRC, TO_DEST, ALL_TO_SRC, ALL_TO_DEST;
    }

    private DataBindingContext bindingContext;

    private NToMModel<M, S> modelProperty;

    private final TableViewer tableViewerSrc;
    private final TableViewer tableViewerDest;

    private final Button cmdAllToSrc;
    private final Button cmdToSrc;
    private final Button cmdToDest;
    private final Button cmdAllToDest;

    private Binding allSrcBinding;
    private Binding allDestBinding;
    private Binding srcBinding;
    private Binding destBinding;

    private final Group grpMain;

    private final Label lblDest;

    private RequiredListValidator<M, S> multiValidator;

    private final Label lblValidator;

    private final Label lblSrc;

    public NToM(Composite parent, int style) {
        super(parent, style | SWT.NO_FOCUS);

        setLayout(new GridLayout());

        grpMain = new Group(this, SWT.NONE);
        grpMain.setLayout(new FormLayout());
        grpMain.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true, 0, 0));

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

        Composite composite = new Composite(controlArea, SWT.NONE);
        composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        RowLayout rl_composite = new RowLayout(SWT.HORIZONTAL);
        rl_composite.wrap = false;
        rl_composite.pack = false;
        rl_composite.spacing = 0;
        rl_composite.marginTop = 0;
        rl_composite.marginRight = 0;
        rl_composite.marginLeft = 0;
        rl_composite.marginBottom = 0;
        rl_composite.justify = true;
        composite.setLayout(rl_composite);

        cmdAllToSrc = new Button(composite, SWT.NONE);
        cmdAllToSrc.setText("<<");
        cmdAllToSrc.addSelectionListener(new SelectionAdapter() {
            private static final long serialVersionUID = 1L;

            @Override
            public void widgetSelected(SelectionEvent e) {
                moveElement(Direction.ALL_TO_SRC);
            }
        });

        Composite composite_1 = new Composite(controlArea, SWT.NONE);
        composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        RowLayout rl_composite_1 = new RowLayout(SWT.HORIZONTAL);
        rl_composite_1.wrap = false;
        rl_composite_1.marginBottom = 0;
        rl_composite_1.marginLeft = 0;
        rl_composite_1.marginRight = 0;
        rl_composite_1.marginTop = 0;
        rl_composite_1.spacing = 0;
        rl_composite_1.pack = false;
        rl_composite_1.justify = true;
        composite_1.setLayout(rl_composite_1);

        cmdToSrc = new Button(composite_1, SWT.NONE);
        cmdToSrc.addSelectionListener(new SelectionAdapter() {
            private static final long serialVersionUID = 1L;

            @Override
            public void widgetSelected(SelectionEvent e) {
                moveElement(Direction.TO_SRC);
            }
        });
        cmdToSrc.setText("<");

        Composite composite_2 = new Composite(controlArea, SWT.NONE);
        composite_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        RowLayout rl_composite_2 = new RowLayout(SWT.HORIZONTAL);
        rl_composite_2.marginBottom = 0;
        rl_composite_2.marginLeft = 0;
        rl_composite_2.marginRight = 0;
        rl_composite_2.marginTop = 0;
        rl_composite_2.pack = false;
        rl_composite_2.spacing = 0;
        rl_composite_2.wrap = false;
        rl_composite_2.justify = true;
        composite_2.setLayout(rl_composite_2);

        cmdToDest = new Button(composite_2, SWT.NONE);
        cmdToDest.setSize(20, 25);
        cmdToDest.setText(">");
        cmdToDest.addSelectionListener(new SelectionAdapter() {
            private static final long serialVersionUID = 1L;

            @Override
            public void widgetSelected(SelectionEvent e) {
                moveElement(Direction.TO_DEST);
            }
        });

        Composite composite_3 = new Composite(controlArea, SWT.NONE);
        composite_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        RowLayout rl_composite_3 = new RowLayout(SWT.HORIZONTAL);
        rl_composite_3.marginBottom = 0;
        rl_composite_3.marginLeft = 0;
        rl_composite_3.marginRight = 0;
        rl_composite_3.marginTop = 0;
        rl_composite_3.spacing = 0;
        rl_composite_3.pack = false;
        rl_composite_3.wrap = false;
        rl_composite_3.justify = true;
        composite_3.setLayout(rl_composite_3);

        cmdAllToDest = new Button(composite_3, SWT.NONE);
        cmdAllToDest.setText(">>");
        cmdAllToDest.addSelectionListener(new SelectionAdapter() {
            private static final long serialVersionUID = 1L;

            @Override
            public void widgetSelected(SelectionEvent e) {
                moveElement(Direction.ALL_TO_DEST);
            }
        });

        SashForm sashForm = new SashForm(grpMain, SWT.NONE);
        FormData fd_sashForm = new FormData();
        fd_sashForm.top = new FormAttachment(controlArea, 5);
        fd_sashForm.bottom = new FormAttachment(100);

        fd_sashForm.right = new FormAttachment(100);
        fd_sashForm.left = new FormAttachment(0);
        sashForm.setLayoutData(fd_sashForm);

        Composite compSrc = new Composite(sashForm, SWT.NONE);
        compSrc.setLayout(new FormLayout());
        tableViewerSrc = new TableViewer(compSrc, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        Table tblSrc = tableViewerSrc.getTable();
        FormData fd_tblSrc = new FormData();
        fd_tblSrc.bottom = new FormAttachment(100);
        fd_tblSrc.right = new FormAttachment(100);
        fd_tblSrc.left = new FormAttachment(0);
        tblSrc.setLayoutData(fd_tblSrc);

        lblSrc = new Label(compSrc, SWT.CENTER);
        fd_tblSrc.top = new FormAttachment(lblSrc);
        FormData fd_lblSrc = new FormData();
        fd_lblSrc.right = new FormAttachment(100);
        fd_lblSrc.left = new FormAttachment(0);
        lblSrc.setLayoutData(fd_lblSrc);
        lblSrc.setText(Messages.get().nToMSrcLabel);

        Composite compDest = new Composite(sashForm, SWT.NONE);
        compDest.setLayout(new FormLayout());

        lblDest = new Label(compDest, SWT.CENTER);
        FormData fd_lblDest = new FormData();
        fd_lblDest.right = new FormAttachment(100);
        fd_lblDest.left = new FormAttachment(0);
        lblDest.setLayoutData(fd_lblDest);
        lblDest.setText(Messages.get().nToMDestLabel);

        tableViewerDest = new TableViewer(compDest, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        Table tblDest = tableViewerDest.getTable();
        FormData fd_tblDest = new FormData();
        fd_tblDest.top = new FormAttachment(lblDest);
        fd_tblDest.bottom = new FormAttachment(100);
        fd_tblDest.right = new FormAttachment(100);
        fd_tblDest.left = new FormAttachment(0);
        tblDest.setLayoutData(fd_tblDest);

        lblValidator = new Label(compDest, SWT.NONE);
        FormData fd_lblNewLabel = new FormData();
        fd_lblNewLabel.left = new FormAttachment(0);
        lblValidator.setLayoutData(fd_lblNewLabel);

        sashForm.setWeights(new int[] { 1, 1 });
    }

    @Override
    public NToMModel<M, S> getModelProperty() {
        return modelProperty;
    }

    public void setModelProperty(M model, String property, List<S> srcList, String... propertyNames) {
        setModelProperty(model, property, srcList, propertyNames, propertyNames);
    }

    public void setModelProperty(M model, String property, List<S> srcList, String[] srcPropertyNames, String[] destPropertyNames) {
        modelProperty = new NToMModel<>(model, property, srcList, srcPropertyNames, destPropertyNames);

        initBinding();
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
        if (modelProperty.isRequired()) {
            lblDest.setData(RWT.CUSTOM_VARIANT, "required");
        }

        bindTable(tableViewerSrc, modelProperty.getSrcList(), modelProperty.getPropertyItemType(), modelProperty.getSrcPropertyNames());
        bindTable(tableViewerDest, modelProperty.getPropertyValue(), modelProperty.getPropertyItemType(), modelProperty.getDestPropertyNames());

        tableViewerSrc.addOpenListener(new IOpenListener() {
            @Override
            public void open(OpenEvent event) {
                moveElement(Direction.TO_DEST);
            }
        });

        tableViewerDest.addOpenListener(new IOpenListener() {
            @Override
            public void open(OpenEvent event) {
                moveElement(Direction.TO_SRC);
            }
        });
    }

    void moveElement(Direction direction) {
        S element = null;
        List<S> inputSrc = (List<S>) tableViewerSrc.getInput();
        List<S> inputDest = (List<S>) tableViewerDest.getInput();

        IStructuredSelection selectionSrc = (IStructuredSelection) tableViewerSrc.getSelection();
        IStructuredSelection selectionDest = (IStructuredSelection) tableViewerDest.getSelection();

        int selSrc = tableViewerSrc.getTable().getSelectionIndex();
        int selDest = tableViewerDest.getTable().getSelectionIndex();

        switch (direction) {
            case ALL_TO_SRC:

                for (S s : inputDest) {
                    if (!inputSrc.contains(s)) {
                        inputSrc.add(s);
                    }
                }

                inputDest.clear();

                tableViewerSrc.getTable().setSelection(0);

                break;
            case TO_SRC:
                element = (S) selectionDest.getFirstElement();

                if (element != null) {
                    inputDest.remove(element);

                    if (!inputSrc.contains(element)) {
                        inputSrc.add(element);
                    }

                    tableViewerSrc.setSelection(new StructuredSelection(element));
                    tableViewerDest.getTable().setSelection(Math.max(0, Math.min(selDest, inputDest.size() - 1)));
                }

                break;
            case TO_DEST:
                element = (S) selectionSrc.getFirstElement();

                if (element != null) {
                    inputSrc.remove(element);

                    if (!inputDest.contains(element)) {
                        inputDest.add(element);
                    }

                    tableViewerDest.setSelection(new StructuredSelection(element));
                    tableViewerSrc.getTable().setSelection(Math.max(0, Math.min(selSrc, inputSrc.size() - 1)));
                }

                break;
            case ALL_TO_DEST:
                for (S s : inputSrc) {
                    if (!inputDest.contains(s)) {
                        inputDest.add(s);
                    }
                }

                inputSrc.clear();

                tableViewerDest.getTable().setSelection(0);

                break;
        }

        multiValidator.forceRevalidate();

        allSrcBinding.updateModelToTarget();
        allDestBinding.updateModelToTarget();
        srcBinding.updateModelToTarget();
        destBinding.updateModelToTarget();

        ControlUtils.refresh(tableViewerSrc);
        ControlUtils.refresh(tableViewerDest);

        modelProperty.setDirty(true);
    }

    protected void initDataBindings() {
        //
        IObservableValue observeTextLblControlObserveWidget = new WidgetGroupTextProperty().observe(grpMain);
        IObservableValue labelModelObserveValue = BeanProperties.value("label").observe(modelProperty);
        bindingContext.bindValue(observeTextLblControlObserveWidget, labelModelObserveValue, null, null);
        //
        IObservableValue observeEnabledCmdAllToSrcObserveWidget = WidgetProperties.enabled().observe(cmdAllToSrc);
        IObservableValue emptyDestModelObserveValue = PojoProperties.value("empty").observe(tableViewerDest.getInput());
        UpdateValueStrategy updateValueStrategy = new UpdateValueStrategy();
        updateValueStrategy.setConverter(new TableInputToBooleanConverter(tableViewerDest));
        allSrcBinding = bindingContext.bindValue(observeEnabledCmdAllToSrcObserveWidget, emptyDestModelObserveValue, null, updateValueStrategy);
        //
        //
        IObservableValue observeEnabledCmdAllToDestObserveWidget = WidgetProperties.enabled().observe(cmdAllToDest);
        IObservableValue emptySrcModelObserveValue = PojoProperties.value("empty").observe(tableViewerSrc.getInput());
        UpdateValueStrategy updateValueStrategy2 = new UpdateValueStrategy();
        updateValueStrategy2.setConverter(new TableInputToBooleanConverter(tableViewerSrc));
        allDestBinding = bindingContext.bindValue(observeEnabledCmdAllToDestObserveWidget, emptySrcModelObserveValue, null, updateValueStrategy2);
        //
        IObservableValue enabledCmdToDestObserveValue = WidgetProperties.enabled().observe(cmdToDest);
        IObservableValue selectionTableViewerSrcObserveValue = ViewerProperties.singleSelection().observe(tableViewerSrc);
        UpdateValueStrategy updateValueStrategy3 = new UpdateValueStrategy();
        updateValueStrategy3.setConverter(new ObjectToBooleanConverter(modelProperty.getPropertyItemType()));
        srcBinding = bindingContext.bindValue(enabledCmdToDestObserveValue, selectionTableViewerSrcObserveValue, null, updateValueStrategy3);
        //
        IObservableValue observeEnabledCmdToSrcObserveWidget = WidgetProperties.enabled().observe(cmdToSrc);
        IObservableValue observeSingleSelectionTableViewer_1 = ViewerProperties.singleSelection().observe(tableViewerDest);
        UpdateValueStrategy updateValueStrategy4 = new UpdateValueStrategy();
        updateValueStrategy4.setConverter(new ObjectToBooleanConverter(modelProperty.getPropertyItemType()));
        destBinding = bindingContext.bindValue(observeEnabledCmdToSrcObserveWidget, observeSingleSelectionTableViewer_1, null, updateValueStrategy4);

        //
        IObservableValue observeEnabledGrpMainObserveWidget = WidgetProperties.enabled().observe(grpMain);
        IObservableValue enabledModelObserveValue = BeanProperties.value("enabled").observe(modelProperty);
        bindingContext.bindValue(observeEnabledGrpMainObserveWidget, enabledModelObserveValue, null, null);

        //
        multiValidator = new RequiredListValidator<>(modelProperty, lblValidator, SWT.RIGHT | SWT.TOP);
        bindingContext.addValidationStatusProvider(multiValidator);
    }

    @Override
    public DataBindingContext getBindingContext() {
        return bindingContext;
    }

    @Override
    public void updateModelToTarget() {
        allSrcBinding.updateModelToTarget();
        allDestBinding.updateModelToTarget();
        srcBinding.updateModelToTarget();
        destBinding.updateModelToTarget();

        ControlUtils.refresh(tableViewerSrc);
        ControlUtils.refresh(tableViewerDest);
    }

    @Override
    public BindingStatus validate() {
        multiValidator.forceRevalidate();

        return BinderUtils.validate(this);
    }

    public <R> void bindSelection(TableViewer tableViewer, List<R> model) {
        if (model instanceof DtoListModel) {
            IObservableValue observeTableViewerSelection = ViewerProperties.singleSelection().observe(tableViewer);
            IObservableValue selectedDtoObserveValue = BeanProperties.value("selectedDto").observe(model);
            UpdateValueStrategy noUpdateStrategy = new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER);

            bindingContext.bindValue(observeTableViewerSelection, selectedDtoObserveValue, null, noUpdateStrategy);
        }

        if (model.size() > 0) {
            tableViewer.setSelection(new StructuredSelection(model.get(0)));
        }
    }

    private <R extends Object> void bindContent(TableViewer tableViewer, List<R> model, Class<R> beanClass, String... propertyNames) {
        ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
        IObservableMap[] observeMaps = null;
        if (IDtoModel.class.isAssignableFrom(beanClass)) {
            observeMaps = BeansObservables.observeMaps(listContentProvider.getKnownElements(), beanClass, propertyNames);
        } else {
            observeMaps = PojoObservables.observeMaps(listContentProvider.getKnownElements(), beanClass, propertyNames);
        }

        ConvertableObservableMapLabelProvider labelProvider = new ConvertableObservableMapLabelProvider(observeMaps);

        tableViewer.setLabelProvider(labelProvider);
        tableViewer.setContentProvider(listContentProvider);

        IObservableList selfList = Properties.selfList(beanClass).observe(model);
        tableViewer.setInput(selfList);

        for (IObservableMap observableMap : observeMaps) {
            observableMap.addMapChangeListener(new MapChangeListener(tableViewer));
        }

        bindSelection(tableViewer, model);
    }

    private <R extends Object> void bindTable(TableViewer tableViewer, List<R> model, Class<R> beanClass, String[] propertyNames) {
        bindTableColumn(tableViewer, beanClass, propertyNames);

        bindContent(tableViewer, model, beanClass, propertyNames);

        ControlUtils.pack(tableViewer);
    }

    private static <T extends AbstractTemplate< ? >, D extends DtoModel> void bindTableColumn(TableViewer tableViewer,
            Class< ? extends Object> beanClass, String... propertyNames) {
        Table table = tableViewer.getTable();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

//        for (TableColumn tableColumn : tableViewer.getTable().getColumns()) {
//            tableColumn.dispose();
//        }
//
//        tableViewer.getTable().removeAll();

        tableViewer.setComparator(new PropertyViewerComparator());

        for (String propertyName : propertyNames) {
            createTableColumn(tableViewer, beanClass, propertyName);
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

}

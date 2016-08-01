package com.icteam.loyalty.common.ui.view;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartStack;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.EPartService.PartState;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.icteam.loyalty.common.dto.IModelDTO;
import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.interfaces.ISearchDTO;
import com.icteam.loyalty.common.nls.NLS;
import com.icteam.loyalty.common.service.DTOService;
import com.icteam.loyalty.common.ui.converter.ConvertableObservableMapLabelProvider;
import com.icteam.loyalty.common.ui.internal.Messages;
import com.icteam.loyalty.common.ui.listener.ListChangeListener;
import com.icteam.loyalty.common.ui.listener.MapChangeListener;
import com.icteam.loyalty.common.ui.listener.VirtuaTableListener;
import com.icteam.loyalty.common.ui.util.ControlUtils;
import com.icteam.loyalty.common.ui.util.TableTreeUtils;
import com.icteam.loyalty.common.util.ModelUtil;
import com.querydsl.sql.RelationalPathBase;

public abstract class VirtualView<MD extends IModelDTO<? extends RelationalPathBase<?>>, S extends ISearchDTO<? extends RelationalPathBase<?>>> {

	protected ColumnViewer columnViewer;

	@Inject
	protected DTOService dtoService;

	protected S searchDTO = null;

	private Composite filterArea;

	private Composite parent;

	private Text text;

	private Button cmdFilters;

	private String filter;

	public abstract long count();

	@Inject
	@Named(IServiceConstants.ACTIVE_SHELL)
	protected Shell shell;

	public abstract List<MD> search();

	protected Class<MD> getModelDTOClass() {
		return (Class<MD>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected final S getSearchDTO() {
		if (searchDTO == null) {
			searchDTO = dtoService.newDTO(getSearchDTOClass(), false);

			initSearchDTO();
		}

		return searchDTO;
	}

	protected void initSearchDTO() {
		searchDTO.enableTrackChanges();
	}

	protected Class<S> getSearchDTOClass() {
		return (Class<S>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	protected void createFilterArea() {
		filterArea = new Composite(parent, SWT.NONE);
		filterArea.setLayout(new FormLayout());

		final FormData fd_buttonArea = new FormData();
		fd_buttonArea.right = new FormAttachment(100);
		fd_buttonArea.top = new FormAttachment(0, 0);
		fd_buttonArea.left = new FormAttachment(0, 0);

		filterArea.setLayoutData(fd_buttonArea);

		fillFilterArea(filterArea);
	}

	protected void fillFilterArea(Composite fa) {
		final Composite filterComp = new Composite(fa, SWT.NONE);
		final FormData fd_filterComp = new FormData();
		fd_filterComp.left = new FormAttachment(0, 0);
		filterComp.setLayoutData(fd_filterComp);
		filterComp.setLayout(new GridLayout(3, false));

		text = new Text(filterComp, SWT.SEARCH | SWT.ICON_SEARCH | SWT.ICON_CANCEL);
		final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text.minimumWidth = 100;
		text.setLayoutData(gd_text);
		text.addSelectionListener(new SelectionAdapter() {
			private static final long serialVersionUID = 1L;

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// try {
				setFilter(text.getText());
				// } catch (final AppException ae) {
				// UIUtils.showTooltip(getViewSite().getShell(), ae);
				//
				// e.doit = false;
				// text.setText(StringUtils.defaultString(filter));
				// }
			}
		});

		text.setMessage(Messages.get().filter_message);

		// cmdFilters = createFilterTableCommand(filterComp);
		//
		// createSearchDialogCommand(filterComp);
		//
		// final GridData gd_cmdFilters = new GridData(SWT.LEFT, SWT.CENTER,
		// false, false, 1, 1);
		// // design mode
		// if (cmdFilters != null) {
		// cmdFilters.setLayoutData(gd_cmdFilters);
		// }
	}

	public void setFilter(String filter) {
		if (!Objects.equals(filter, this.filter)) {
			final String oldFilter = this.filter;

			getSearchDTO().setRawFilter(filter);

			this.filter = filter;

			text.setText(StringUtils.defaultString(filter));

			if (!reload(true)) {
				setFilter(oldFilter);
			}
		}
	}

	public boolean reload(boolean closeEditors) {
		try {
			final ColumnViewer columnViewer = getColumnViewer();
			final Control control = columnViewer.getControl();

			final Listener[] listeners = control.getListeners(SWT.SetData);

			for (final Listener listener : listeners) {
				control.removeListener(SWT.SetData, listener);
			}

			TableTreeUtils.clear(columnViewer, getModelDTO());

			for (final Listener listener : listeners) {
				control.addListener(SWT.SetData, listener);
			}

			TableTreeUtils.clearAll(control);

			bindItemCount();

			ControlUtils.pack(columnViewer, true);

			if (closeEditors) {
				closeEditors();
			}
		} catch (final Exception e) {
			MessageDialog.openError(shell, Messages.get().load_error, e.getLocalizedMessage());
			return false;
		}

		return true;
	}

	@Inject
	protected EPartService partService;

	private Composite tableViewerArea;

	protected void closeEditors() {
		partService.getParts().stream().filter(part -> part.getElementId().startsWith(getModelDTO().getEditorID()))
				.forEach(part -> {
					if (partService.savePart(part, true)) {
						partService.hidePart(part);
					}
				});
	}

	protected void createTableViewerArea() {
		tableViewerArea = new Composite(parent, SWT.BORDER);
		final FormData fd_editorArea = new FormData();
		fd_editorArea.top = new FormAttachment(filterArea, 0);
		fd_editorArea.right = new FormAttachment(100, 0);
		fd_editorArea.bottom = new FormAttachment(100, 0);
		fd_editorArea.left = new FormAttachment(0, 0);

		tableViewerArea.setLayout(new GridLayout(1, false));
		tableViewerArea.setLayoutData(fd_editorArea);

		fillTableViewerArea(tableViewerArea);
	}

	protected void fillTableViewerArea(Composite tva) {
		initColumnViewer(tva);

		final String[] propertyNames = ModelUtil.collectPropertyNames(getModelDTOClass());

		bindVirtualTableColumn(propertyNames);

		bindLazyContent(propertyNames);

		bindVirtualListener();

		bindViewTableSelection();

		ControlUtils.pack(getColumnViewer());
	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		this.parent = parent;
		parent.setLayout(new FormLayout());

		createFilterArea();

		createTableViewerArea();

	}

	protected void initColumnViewer(Composite parent) {
		columnViewer = new TableViewer(parent, SWT.VIRTUAL | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		columnViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
	}

	private void bindVirtualListener() {
		if (columnViewer instanceof TableViewer) {
			columnViewer.getControl().addListener(SWT.SetData,
					new VirtuaTableListener<>(this, dtoService.newDTO(getModelDTOClass(), false)));
		}
	}

	protected MD getModelDTO() {
		return dtoService.newDTO(getModelDTOClass());
	}

	private void bindVirtualTableColumn(String... propertyNames) {
		final Control control = columnViewer.getControl();
		TableTreeUtils.setHeaderVisible(control, true);
		TableTreeUtils.setLinesVisible(control, true);

		for (final String propertyName : propertyNames) {
			final ViewerColumn viewerColumn = TableTreeUtils.newColumnViewer(columnViewer, SWT.NONE);

			final Item column = TableTreeUtils.getColumn(viewerColumn);
			TableTreeUtils.setColumnMoveable(column, true);
			TableTreeUtils.setColumnResizable(column, true);

			addSortListener(column, propertyName);

			column.setText(NLS.get(OperatorDTO.class, propertyName));
			column.setData("COLUMN_NAME", propertyName);
		}
	}

	private void addSortListener(Item column, String propertyName) {
		// if (column instanceof TableColumn) {
		// ((TableColumn) column)
		// .addSelectionListener(new VirtualSortSelectionListener<>(this,
		// getDtoModelClass(), propertyName));
		// }
	}

	@Inject
	protected ESelectionService selectionService;

	@Inject
	protected MPerspective perspective;

	@Inject
	protected EModelService modelService;

	protected void bindViewTableSelection() {
		final ColumnViewer columnViewer = getColumnViewer();

		columnViewer.addOpenListener(event -> {
			final IStructuredSelection selection = columnViewer.getStructuredSelection();

			Stream.of(selection.toArray()).forEach(md -> {
				final MD modelDTO = (MD) md;
				final String editorInstanceID = modelDTO.getEditorInstanceID();
				MPart part = partService.findPart(editorInstanceID);

				if (part == null) {
					part = partService.createPart(modelDTO.getEditorID());

					if (part != null) {
						part.setLabel(modelDTO.getValueID());
						part.setElementId(editorInstanceID);
						part.getTransientData().put("modelDTO", modelDTO);

						final MPartStack partStack = (MPartStack) modelService
								.find("com.icteam.loyalty.application.partstack.center", perspective);
						partStack.getChildren().add(part);
					}
				}

				if (part != null) {
					partService.showPart(part, PartState.ACTIVATE);
				}
			});
		});

		columnViewer.addSelectionChangedListener(event -> {
			final IStructuredSelection selection = columnViewer.getStructuredSelection();

			selectionService.setSelection(selection.size() == 1 ? selection.getFirstElement() : selection.toArray());
		});
	}

	/**
	 * Con i generici non funziona
	 */
	@Inject
	private final void setSelection(
			@SuppressWarnings("rawtypes") @Optional @Named(IServiceConstants.ACTIVE_SELECTION) IModelDTO modelDTO) {
		setSelectionInternal((MD) modelDTO);
	}

	/**
	 * Fatto così perchè l'injection con i generici non funziona
	 *
	 * @param modelDTO
	 */
	protected void setSelectionInternal(MD modelDTO) {
		if (modelDTO != null) {
			final MPart part = partService.findPart(modelDTO.getEditorInstanceID());

			if (part != null) {
				partService.bringToTop(part);
			}
		}
	}

	private void bindLazyContent(String... propertyNames) {
		final ObservableListContentProvider listContentProvider = new ObservableListContentProvider();

		final IObservableMap<OperatorDTO, ?>[] observeMaps = Stream.of(propertyNames)
				.map(propertyName -> BeanProperties.value(getModelDTOClass(), propertyName)
						.observeDetail(listContentProvider.getKnownElements()))
				.collect(Collectors.toList()).toArray(new IObservableMap[] {});

		// IObservableMap[] observeMaps =
		// BeansObservables.observeMaps(listContentProvider.getKnownElements(),
		// beanClass, propertyNames);
		// observeMaps =
		// PojoObservables.observeMaps(listContentProvider.getKnownElements(),
		// beanClass, propertyNames);

		final ObservableMapLabelProvider labelProvider = new ConvertableObservableMapLabelProvider(observeMaps);

		columnViewer.setLabelProvider(labelProvider);
		columnViewer.setContentProvider(listContentProvider);

		// lista vuota popolata in lazy
		final IObservableList<Object> selfList = Properties.selfList(getModelDTOClass()).observe(new ArrayList<>());
		columnViewer.setInput(selfList);

		bindItemCount();

		for (final IObservableMap<OperatorDTO, ?> observableMap : observeMaps) {
			observableMap.addMapChangeListener(new MapChangeListener(columnViewer));
		}

		selfList.addListChangeListener(new ListChangeListener(columnViewer));
	}

	void bindItemCount() {
		final int itemCount = (int) count();

		TableTreeUtils.setItemCount(columnViewer, itemCount);
	}

	public ColumnViewer getColumnViewer() {
		return columnViewer;
	}

}

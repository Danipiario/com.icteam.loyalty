
package com.icteam.loyalty.common.view;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;

import com.icteam.loyalty.common.converter.ConvertableObservableMapLabelProvider;
import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.dto.OperatorSearchDTO;
import com.icteam.loyalty.common.listener.ListChangeListener;
import com.icteam.loyalty.common.listener.MapChangeListener;
import com.icteam.loyalty.common.listener.VirtuaTableListener;
import com.icteam.loyalty.common.nls.NLS;
import com.icteam.loyalty.common.service.AuthService;
import com.icteam.loyalty.common.service.DTOService;
import com.icteam.loyalty.common.util.ControlUtils;
import com.icteam.loyalty.common.util.ModelUtil;
import com.icteam.loyalty.common.util.TableTreeUtils;

public class OperatorView {

	@Inject
	private AuthService authService;

	@Inject
	private DTOService dtoService;

	protected ColumnViewer columnViewer;

	private OperatorSearchDTO operatorSearchDTO;

	@PostConstruct
	public void postConstruct(Composite parent) {
		operatorSearchDTO = dtoService.newDTO(OperatorSearchDTO.class);

		columnViewer = new TableViewer(parent, SWT.VIRTUAL | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		columnViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		parent.setLayout(new GridLayout(1, false));

		final String[] propertyNames = ModelUtil.collectPropertyNames(getDtoModelClass());

		bindVirtualTableColumn(propertyNames);

		bindLazyContent(propertyNames);

		bindVirtualListener();

		ControlUtils.pack(getColumnViewer());
	}

	private void bindVirtualListener() {
		if (columnViewer instanceof TableViewer) {
			columnViewer.getControl().addListener(SWT.SetData,
					new VirtuaTableListener<>(this, dtoService.newDTO(getDtoModelClass())));
		}
	}

	void bindVirtualTableColumn(String... propertyNames) {
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

	private void bindLazyContent(String... propertyNames) {
		final ObservableListContentProvider listContentProvider = new ObservableListContentProvider();

		final IObservableMap<OperatorDTO, ?>[] observeMaps = Stream.of(propertyNames)
				.map(propertyName -> BeanProperties.value(getDtoModelClass(), propertyName)
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
		final IObservableList<Object> selfList = Properties.selfList(getDtoModelClass()).observe(new ArrayList<>());
		columnViewer.setInput(selfList);

		bindItemCount();

		for (final IObservableMap<OperatorDTO, ?> observableMap : observeMaps) {
			observableMap.addMapChangeListener(new MapChangeListener(columnViewer));
		}

		selfList.addListChangeListener(new ListChangeListener(columnViewer));
	}

	void bindItemCount() {
		final int itemCount = 1;// handleCount(1);

		TableTreeUtils.setItemCount(columnViewer, itemCount);
	}

	private Class<? extends IDTO> getDtoModelClass() {
		return OperatorDTO.class;
	}

	public ColumnViewer getColumnViewer() {
		return columnViewer;
	}

	public List<OperatorDTO> search() {
		return authService.search(operatorSearchDTO);

	}

}
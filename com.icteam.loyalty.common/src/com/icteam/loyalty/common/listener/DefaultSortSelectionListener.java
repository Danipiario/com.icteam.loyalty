package com.icteam.loyalty.common.listener;
// package com.icteam.loyalty.ui.listener;
//
// import org.eclipse.jface.viewers.TableViewer;
// import org.eclipse.jface.viewers.ViewerComparator;
// import org.eclipse.swt.SWT;
// import org.eclipse.swt.events.SelectionAdapter;
// import org.eclipse.swt.events.SelectionEvent;
// import org.eclipse.swt.widgets.Table;
// import org.eclipse.swt.widgets.TableColumn;
//
// import com.icteam.loyalty.api.interfaces.Property;
// import com.icteam.loyalty.model.util.ModelUtil;
// import com.icteam.loyalty.ui.interfaces.IPropertyViewerComparator;
// import com.icteam.loyalty.ui.util.ControlUtils;
//
// public class DefaultSortSelectionListener extends SelectionAdapter {
//
// private static final long serialVersionUID = -5335144747231037618L;
//
// protected final Table table;
//
// private final TableViewer tableViewer;
//
// protected final String propertyName;
//
// private final Property property;
//
// public DefaultSortSelectionListener(TableViewer tableViewer, Class< ? extends
// Object> beanClass, String propertyName) {
// this.tableViewer = tableViewer;
// this.table = tableViewer.getTable();
// this.propertyName = propertyName;
//
// property = ModelUtil.getAnnotation(beanClass, propertyName, Property.class);
// }
//
// public TableViewer getTableViewer() {
// return tableViewer;
// }
//
// public Table getTable() {
// return table;
// }
//
// @Override
// public void widgetSelected(SelectionEvent e) {
// if (property != null && !property.sortable()) {
// e.doit = false;
// return;
// }
//
// TableColumn tc = (TableColumn) e.getSource();
//
// int direction = SWT.UP;
//
// if (tc.equals(table.getSortColumn())) {
// direction = switchDirection(table.getSortDirection());
// }
//
// table.setSortDirection(direction);
// table.setSortColumn(tc);
//
// if (direction == SWT.NONE) {
// table.setSortColumn(null);
// }
//
// handleSort();
// }
//
// protected void handleSort() {
// ViewerComparator viewerComparator = tableViewer.getComparator();
//
// if (viewerComparator instanceof IPropertyViewerComparator) {
// IPropertyViewerComparator pvc = (IPropertyViewerComparator) viewerComparator;
//
// pvc.setSortColumn(table.getSortColumn());
// pvc.setSortDirection(table.getSortDirection());
// }
//
// ControlUtils.refresh(tableViewer);
// }
//
// protected int switchDirection(int direction) {
// switch (direction) {
// case SWT.UP:
// return SWT.DOWN;
// case SWT.DOWN:
// return SWT.NONE;
// default:
// return SWT.UP;
// }
// }
// }
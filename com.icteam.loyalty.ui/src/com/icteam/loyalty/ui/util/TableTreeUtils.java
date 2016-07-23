package com.icteam.loyalty.ui.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

import com.icteam.loyalty.model.HierarchyDtoModel;
import com.icteam.loyalty.ui.model.TreeItemModel;

public class TableTreeUtils {

    public static Item[] getColumns(Control control) {
        return control instanceof Table ? ((Table) control).getColumns() : ((Tree) control).getColumns();
    }

    public static Item getColumn(Control control, int i) {
        return control instanceof Table ? ((Table) control).getColumn(i) : ((Tree) control).getColumn(i);
    }

    public static Item getColumn(ViewerColumn viewerColumn) {
        return viewerColumn instanceof TableViewerColumn ? ((TableViewerColumn) viewerColumn).getColumn() : ((TreeViewerColumn) viewerColumn)
                .getColumn();
    }

    public static ViewerColumn newColumnViewer(ColumnViewer columnViewer, int style) {
        return columnViewer instanceof TableViewer ? new TableViewerColumn((TableViewer) columnViewer, style) : new TreeViewerColumn(
                (TreeViewer) columnViewer, style);
    }

    public static void setColumnWidth(Item column, int width) {
        if (column instanceof TableColumn) {
            ((TableColumn) column).setWidth(width);
        } else {
            ((TreeColumn) column).setWidth(width);
        }
    }

    public static void setColumnMoveable(Item column, boolean moveable) {
        if (column instanceof TableColumn) {
            ((TableColumn) column).setMoveable(moveable);
        } else {
            ((TreeColumn) column).setMoveable(moveable);
        }
    }

    public static void setColumnResizable(Item column, boolean resizable) {
        if (column instanceof TableColumn) {
            ((TableColumn) column).setResizable(resizable);
        } else {
            ((TreeColumn) column).setResizable(resizable);
        }
    }

    public static int getColumnWidth(Item column) {
        return column instanceof TableColumn ? ((TableColumn) column).getWidth() : ((TreeColumn) column).getWidth();
    }

    public static int[] getColumnOrder(Control control) {
        return control instanceof Table ? ((Table) control).getColumnOrder() : ((Tree) control).getColumnOrder();
    }

    public static int getColumnCount(Control control) {
        return control instanceof Table ? ((Table) control).getColumnCount() : ((Tree) control).getColumnCount();
    }

    public static void setColumnOrder(Control control, int[] columnOrder) {
        if (control instanceof Table) {
            ((Table) control).setColumnOrder(columnOrder);
        } else {
            ((Tree) control).setColumnOrder(columnOrder);
        }
    }

    public static void setSelection(Control control, Item selection) {
        if (control instanceof Table) {
            ((Table) control).setSelection((TableItem) selection);
        } else {
            ((Tree) control).setSelection((TreeItem) selection);
        }
    }

    public static void setHeaderVisible(Control control, boolean visible) {
        if (control instanceof Table) {
            ((Table) control).setHeaderVisible(visible);
        } else {
            ((Tree) control).setHeaderVisible(visible);
        }
    }

    public static void setLinesVisible(Control control, boolean visible) {
        if (control instanceof Table) {
            ((Table) control).setLinesVisible(visible);
        } else {
            ((Tree) control).setLinesVisible(visible);
        }
    }

    public static void pack(Item column) {
        if (column instanceof TableColumn) {
            ((TableColumn) column).pack();
        } else {
            ((TreeColumn) column).pack();
        }
    }

    public static void clearAll(Control control) {
        if (control instanceof Table) {
            ((Table) control).clearAll();
        } else {
            ((Tree) control).clearAll(true);
        }
    }

    public static void setItemCount(ColumnViewer columnViewer, int itemCount) {
        if (columnViewer instanceof TableViewer) {
            ((TableViewer) columnViewer).setItemCount(itemCount);
        } else {
            ((TreeViewer) columnViewer).setChildCount(TreePath.EMPTY, itemCount);
        }
    }

    public static void clear(ColumnViewer columnViewer, Object placeholderModel) {
        if (columnViewer instanceof TableViewer) {
            ((List< ? >) columnViewer.getInput()).clear();
        } else {
            ((TreeViewer) columnViewer).setInput(placeholderModel);
        }
    }

    public static <D extends HierarchyDtoModel<D>> void applyTreeItemModelCount(TreeViewer treeViewer, Map<D, TreeItemModel<D>> treeItemsModel) {
        for (Entry<D, TreeItemModel<D>> tim : treeItemsModel.entrySet()) {
            if (tim.getValue().itemCount != -1) {
                treeViewer.setChildCount(tim.getKey(), tim.getValue().itemCount);
            }
        }
    }

    public static <D extends HierarchyDtoModel<D>> Map<D, TreeItemModel<D>> saveTreeItemsModel(Tree tree) {
        Map<D, TreeItemModel<D>> treeItemsModel = new HashMap<>();

        fillTreeItemsModel(tree.getItems(), treeItemsModel);

        return treeItemsModel;
    }

    private static <D extends HierarchyDtoModel<D>> void fillTreeItemsModel(TreeItem[] treeItems, Map<D, TreeItemModel<D>> treeItemsModel) {
        for (TreeItem treeItem : treeItems) {
            D dto = (D) treeItem.getData();

            if (dto != null && !dto.isPlaceholderDto() && !treeItemsModel.containsKey(dto)) {
                treeItemsModel.put(dto, new TreeItemModel<>(dto, treeItem.getItemCount()));
            }

            fillTreeItemsModel(treeItem.getItems(), treeItemsModel);
        }
    }
}

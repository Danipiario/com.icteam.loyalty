package com.icteam.loyalty.ui.listener;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import com.icteam.loyalty.model.DbModel;
import com.icteam.loyalty.model.HierarchyDtoModel;
import com.icteam.loyalty.model.template.AbstractHierarchyTemplate;
import com.icteam.loyalty.ui.interfaces.IVirtualHierarchyView;
import com.icteam.loyalty.ui.interfaces.IVirtualView;
import com.icteam.loyalty.ui.model.TreeItemModel;
import com.icteam.loyalty.ui.util.TableTreeUtils;

public class VirtuaTreeListener<T extends AbstractHierarchyTemplate< ? extends DbModel<D>>, D extends HierarchyDtoModel<D>> implements Listener {
    private static final long serialVersionUID = 1L;

    private final WeakReference<IVirtualHierarchyView<T, D>> virtualView;
    private final D placeholderModel;

    public VirtuaTreeListener(IVirtualHierarchyView<T, D> virtualView, D placeholderModel) {
        this.virtualView = new WeakReference<>(virtualView);
        this.placeholderModel = placeholderModel;
    }

    @Override
    public void handleEvent(Event event) {
        final TreeViewer treeViewer = (TreeViewer) getVirtualView().getColumnViewer();
        Tree tree = (Tree) treeViewer.getControl();
        D input = (D) treeViewer.getInput();
        TreeItem treeItem = (TreeItem) event.item;

        boolean isRoot = false;
        final D parent = treeItem.getParentItem() != null && treeItem.getParentItem().getData() != null ? (D) treeItem.getParentItem().getData()
                : input;

        List<D> listInput = parent.getChildrenDto();

        if (parent == input) {
            isRoot = true;
        }

        T template = (T) getVirtualView().getTemplate().clone();
        template.setParent(isRoot ? null : getVirtualView().getModelBuilder().build(parent));

        int index = event.index;

        if (index >= listInput.size() || listInput.get(index).isPlaceholderDto()) {
            final int itemCount = getVirtualView().handleCount(template);

            if (index <= itemCount) {
                final Map<D, TreeItemModel<D>> treeItemsModel = TableTreeUtils.saveTreeItemsModel(tree);

                TreeItemModel<D> treeItemModelParent = treeItemsModel.get(parent);
                if (treeItemModelParent != null) {
                    treeItemModelParent.itemCount = -1; // evito di applicare al parent il vecchio valore
                }

                int start = Math.max(index - IVirtualView.HALF_PAGE_SIZE, 0);
                int end = Math.min(start + IVirtualView.PAGE_SIZE, itemCount);

                template.setFirstResult(start);
                template.setMaxResults(end - start);

                List<D> ops = getVirtualView().handleSearch(template);

                int startToFill = listInput.size();
                int endToFill = end;

                boolean changed = false;
                for (int i = startToFill; i < endToFill; i++) {
                    listInput.add(placeholderModel);
                    changed = true;
                }

                for (int i = 0, j = start; i < ops.size() && j < end; i++, j++) {
                    if (listInput.get(j).isPlaceholderDto()) {
                        D element = ops.get(i);
                        try {
                            TreeItemModel<D> treeItemModel = treeItemsModel.get(element);

                            // sostituisco l'element con quelli gia' caricati nel tree
                            if (treeItemModel != null) {
                                element = treeItemModel.dtoModel;
                            }

                            listInput.set(j, element);
                        } catch (SWTException e) {
                            e.printStackTrace();
                            // ignore
                        }

                        changed = true;
                    }
                }

                if (changed) {
                    treeViewer.setChildCount(parent, itemCount);

                    Display.getCurrent().asyncExec(new Runnable() {
                        @Override
                        public void run() {

                            treeViewer.refresh();

                            TableTreeUtils.applyTreeItemModelCount(treeViewer, treeItemsModel);

                            treeViewer.setChildCount(parent, itemCount);
                        }
                    });
                }
            }
        }
    }

    private IVirtualHierarchyView<T, D> getVirtualView() {
        return virtualView.get();
    }
}
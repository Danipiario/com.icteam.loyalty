package com.icteam.loyalty.ui.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;

import com.icteam.loyalty.model.DbModel;
import com.icteam.loyalty.model.HierarchyDtoModel;
import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.model.template.AbstractHierarchyTemplate;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.converter.ConvertableObservableMapLabelProvider;
import com.icteam.loyalty.ui.interfaces.IVirtualHierarchyView;
import com.icteam.loyalty.ui.listener.MapChangeListener;
import com.icteam.loyalty.ui.listener.VirtuaTreeListener;
import com.icteam.loyalty.ui.util.ControlUtils;

public abstract class VirtualHierarchyView<T extends AbstractHierarchyTemplate< ? extends DbModel<D>>, D extends HierarchyDtoModel<D>> extends
        VirtualView<T, D> implements IVirtualHierarchyView<T, D> {

    private void bindVirtualListener() {
        getColumnViewer().getControl().addListener(SWT.SetData, new VirtuaTreeListener<>(this, createDtoPlaceholder()));
    }

    public void bindViewTree() {
        String[] propertyNames = ModelUtil.collectPropertyNames(getDtoModelClass());

        bindVirtualTableColumn(propertyNames);

        bindLazyContentTree(propertyNames);

        bindVirtualListener();

        ControlUtils.pack(getColumnViewer(), true);
    }

    private void bindLazyContentTree(String... propertyNames) {
        ObservableListTreeContentProvider treeContentProvider = new ObservableListTreeContentProvider(BeanProperties.list(getDtoModelClass(),
                "childrenDto").listFactory(), new TreeStructureAdvisor() {
            @Override
            public Boolean hasChildren(Object element) {
                Boolean res = null;
                if (element != null) {
                    res = ((D) element).getHasChildren();

                }

                return res;
            }
        });

        IObservableMap[] observeMaps = null;
        if (IDtoModel.class.isAssignableFrom(getDtoModelClass())) {
            observeMaps = BeansObservables.observeMaps(treeContentProvider.getKnownElements(), getDtoModelClass(), propertyNames);
        } else {
            observeMaps = PojoObservables.observeMaps(treeContentProvider.getKnownElements(), getDtoModelClass(), propertyNames);
        }

        ConvertableObservableMapLabelProvider labelProvider = new ConvertableObservableMapLabelProvider(observeMaps);

        final TreeViewer treeViewer = (TreeViewer) getColumnViewer();
        treeViewer.setLabelProvider(labelProvider);
        treeViewer.setContentProvider(treeContentProvider);

        treeViewer.setInput(createDtoPlaceholder());

        bindItemCount();

        for (IObservableMap observableMap : observeMaps) {
            observableMap.addMapChangeListener(new MapChangeListener(treeViewer));
        }

        treeViewer.addTreeListener(new ITreeViewerListener() {
            @Override
            public void treeExpanded(TreeExpansionEvent event) {
                ControlUtils.pack(treeViewer, true);
            }

            @Override
            public void treeCollapsed(TreeExpansionEvent event) {
                ControlUtils.pack(treeViewer, true);
            }
        });

//        selfSet.addListChangeListener(new ListChangeListener<>(columnViewer, createDtoPlaceholder(beanClass)));
    }

    @Override
    public boolean reload(boolean closeEditors) {
        if (super.reload(closeEditors)) {
            if (hasCustomFilter()) {
                T tmpl = null;
                tmpl = (T) template.clone();

                tmpl.setHierarchySearch(Boolean.FALSE);

                List<D> children = handleSearch(tmpl);

                List<D> results = new ArrayList<>();
                List<D> parents = new ArrayList<>();

                // calcolo la gerarchia ricorsivamente partendo dal basso
                // la lista parents contiene alla fine tutti i nodi che non hanno un padre in gerarchia
                fill(results, children, parents);

                D root = (D) getColumnViewer().getInput();
                root.setChildrenDto(parents);

                expandFirst(parents);
            }

            return true;
        }

        return false;
    }

    private void expandFirst(List<D> nodes) {
        if (nodes.isEmpty()) {
            return;
        }

        D firstNode = nodes.get(0);

        ((TreeViewer) getColumnViewer()).expandToLevel(firstNode, 1);

        expandFirst(firstNode.getChildrenDto());
    }

    public void fill(List<D> results, List<D> children, List<D> parents) {
        for (D child : children) {
            if (!results.contains(child)) {
                results.add(child);

                // creo un template senza filtro
                T template = buildTemplate();
                template.setHierarchySearch(Boolean.TRUE);
                template.setChild(getModelBuilder().build(child));

                List<D> ps = handleSearch(template);

                // se il nodo non ha padri allora lo aggiungo all'elenco dei nodi padre
                if (ps.isEmpty()) {
                    parents.add(child);
                } else {
                    for (Iterator<D> iterator = ps.iterator(); iterator.hasNext();) {
                        D p = iterator.next();

                        int index = results.indexOf(p);

                        D parent = p;

                        if (index != -1) {
                            parent = results.get(index);

                            // se il parent e' gia' stato memorizzato lo escludo dalla ricorsione
                            iterator.remove();
                        }

                        if (!parent.getChildrenDto().contains(child)) {
                            parent.getChildrenDto().add(child);
                        }
                    }

                    fill(results, ps, parents);
                }
            }
        }
    }
}

package com.icteam.loyalty.ui.listener;

import java.lang.ref.WeakReference;
import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;

import com.icteam.loyalty.model.EMFModel;
import com.icteam.loyalty.model.template.AbstractEMFTemplate;
import com.icteam.loyalty.model.util.ModelUtil;
import com.icteam.loyalty.ui.model.VirtualViewEMFModel;

public class VirtuaTableEMFListener<T extends AbstractEMFTemplate< ? >, D extends EMFModel> implements Listener {
    private static final long serialVersionUID = 1L;

    private final WeakReference<VirtualViewEMFModel<T, D>> virtualViewEMFModelRef;
    private final D placeholderModel;
    final TableViewer tableViewer;

    public VirtuaTableEMFListener(VirtualViewEMFModel<T, D> virtualViewEMFModel, TableViewer tableViewer, D placeholderModel) {
        this.tableViewer = tableViewer;
        this.virtualViewEMFModelRef = new WeakReference<>(virtualViewEMFModel);
        this.placeholderModel = placeholderModel;
    }

    @Override
    public void handleEvent(Event event) {
        Table table = (Table) tableViewer.getControl();
        final int itemCount = table.getItemCount();

        int index = event.index;
        List<D> input = (List<D>) tableViewer.getInput();

        if (index <= itemCount && (index >= input.size() || placeholderModel.equals(input.get(index)))) {
            int start = Math.max(index - VirtualViewEMFModel.HALF_PAGE_SIZE, 0);
            int end = Math.min(start + VirtualViewEMFModel.PAGE_SIZE, itemCount);

            T template = ModelUtil.copy(getVirtualViewEMFModel().getTemplate());
            template.setFirstResult(start);
            template.setMaxResults(end - start);

            List<D> ops = (List<D>) getVirtualViewEMFModel().getSearchProvider().search(template);

            int startToFill = input.size();
            int endToFill = end;

            boolean changed = false;
            for (int i = startToFill; i < endToFill; i++) {
                input.add(placeholderModel);
                changed = true;
            }

            for (int i = 0, j = start; i < ops.size() && j < end; i++, j++) {
                if (placeholderModel.equals(input.get(j))) {
                    D element = ops.get(i);
                    try {
                        input.set(j, element);
                    } catch (SWTException e) {
                        e.printStackTrace();
                        // ignore
                    }

                    changed = true;
                }
            }

            if (changed) {
                tableViewer.setItemCount(itemCount);

                Display.getCurrent().asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        tableViewer.refresh();
                        tableViewer.setItemCount(itemCount);
                    }
                });
            }
        }
    }

    private VirtualViewEMFModel<T, D> getVirtualViewEMFModel() {
        return virtualViewEMFModelRef.get();
    }
}
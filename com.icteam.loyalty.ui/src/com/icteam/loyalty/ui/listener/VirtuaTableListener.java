package com.icteam.loyalty.ui.listener;

import java.lang.ref.WeakReference;
import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;

import com.icteam.loyalty.model.interfaces.IDtoModel;
import com.icteam.loyalty.model.template.AbstractTemplate;
import com.icteam.loyalty.ui.interfaces.IVirtualView;

public class VirtuaTableListener<T extends AbstractTemplate< ? >, D extends IDtoModel> implements Listener {
    private static final long serialVersionUID = 1L;

    private final WeakReference<IVirtualView<T, D>> virtualView;
    private final D placeholderModel;

    public VirtuaTableListener(IVirtualView<T, D> virtualView, D placeholderModel) {
        this.virtualView = new WeakReference<>(virtualView);
        this.placeholderModel = placeholderModel;
    }

    @Override
    public void handleEvent(Event event) {
        final TableViewer tableViewer = (TableViewer) getVirtualView().getColumnViewer();
        Table table = (Table) tableViewer.getControl();
        final int itemCount = table.getItemCount();

        int index = event.index;
        List<D> input = (List<D>) tableViewer.getInput();

        if (index <= itemCount && (index >= input.size() || placeholderModel.equals(input.get(index)))) {
            int start = Math.max(index - IVirtualView.HALF_PAGE_SIZE, 0);
            int end = Math.min(start + IVirtualView.PAGE_SIZE, itemCount);

            T template = (T) getVirtualView().getTemplate().clone();
            template.setFirstResult(start);
            template.setMaxResults(end - start);

            List<D> ops = getVirtualView().handleSearch(template);

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

    private IVirtualView<T, D> getVirtualView() {
        return virtualView.get();
    }
}
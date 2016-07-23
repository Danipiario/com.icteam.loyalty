package com.icteam.loyalty.ui.listener;

import java.lang.ref.WeakReference;

import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffEntry;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.swt.widgets.Item;

import com.icteam.loyalty.ui.util.ControlUtils;
import com.icteam.loyalty.ui.util.TableTreeUtils;

public class ListChangeListener implements IListChangeListener {
    private final WeakReference<ColumnViewer> columnViewerRef;
    private final Object placeholderModel;

    public ListChangeListener(ColumnViewer columnViewer, Object placeholderModel) {
        this.columnViewerRef = new WeakReference<>(columnViewer);
        this.placeholderModel = placeholderModel;
    }

    @Override
    public void handleListChange(ListChangeEvent event) {
        // add senza sostituzione
        if (event.diff.getDifferences().length == 1) {
            ListDiffEntry diffEntry = event.diff.getDifferences()[0];

            if (diffEntry.isAddition() && !placeholderModel.equals(diffEntry.getElement())) {
//                tableViewerRef.get().getControl().setSelection(diffEntry.getPosition());
                TableTreeUtils.setSelection(columnViewerRef.get().getControl(), (Item) diffEntry.getElement());

                ControlUtils.pack(columnViewerRef.get());
            }
        }
    }
}
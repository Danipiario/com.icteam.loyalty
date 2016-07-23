package com.icteam.loyalty.common.listener;

import java.lang.ref.WeakReference;

import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiffEntry;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.swt.widgets.Item;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.util.TableTreeUtils;

public class ListChangeListener implements IListChangeListener {
	private final WeakReference<ColumnViewer> columnViewerRef;

	public ListChangeListener(ColumnViewer columnViewer) {
		this.columnViewerRef = new WeakReference<>(columnViewer);
	}

	@Override
	public void handleListChange(ListChangeEvent event) {
		// add senza sostituzione
		if (event.diff.getDifferences().length == 1) {
			ListDiffEntry diffEntry = event.diff.getDifferences()[0];

			if (diffEntry.isAddition()
					&& !(diffEntry.getElement() instanceof IDTO && ((IDTO) diffEntry.getElement()).is_new())) {
				// tableViewerRef.get().getControl().setSelection(diffEntry.getPosition());
				TableTreeUtils.setSelection(columnViewerRef.get().getControl(), (Item) diffEntry.getElement());

				// ControlUtils.pack(columnViewerRef.get());
			}
		}
	}
}
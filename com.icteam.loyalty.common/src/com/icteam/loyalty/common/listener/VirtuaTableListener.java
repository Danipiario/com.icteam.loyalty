package com.icteam.loyalty.common.listener;

import java.lang.ref.WeakReference;
import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.view.OperatorView;

public class VirtuaTableListener<D extends IDTO> implements Listener {
	private static final long serialVersionUID = 1L;

	static final int PAGE_SIZE = 100;
	static final int HALF_PAGE_SIZE = 50;

	private final WeakReference<OperatorView> virtualView;
	private final D placeholderModel;

	public VirtuaTableListener(OperatorView virtualView, D placeholderModel) {
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
			int start = Math.max(index - HALF_PAGE_SIZE, 0);
			int end = Math.min(start + PAGE_SIZE, itemCount);

			// T template = (T) getVirtualView().getTemplate().clone();
			// template.setFirstResult(start);
			// template.setMaxResults(end - start);

			List<D> ops = (List<D>) getVirtualView().search();

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

	private OperatorView getVirtualView() {
		return virtualView.get();
	}
}
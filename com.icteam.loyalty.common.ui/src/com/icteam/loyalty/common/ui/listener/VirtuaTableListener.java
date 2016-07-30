package com.icteam.loyalty.common.ui.listener;

import java.lang.ref.WeakReference;
import java.util.List;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;

import com.icteam.loyalty.common.dto.IModelDTO;
import com.icteam.loyalty.common.ui.view.VirtualView;
import com.querydsl.sql.RelationalPathBase;

public class VirtuaTableListener<MD extends IModelDTO<? extends RelationalPathBase<?>>> implements Listener {
	private static final long serialVersionUID = 1L;

	static final int PAGE_SIZE = 100;
	static final int HALF_PAGE_SIZE = 50;

	private final WeakReference<VirtualView<MD, ?>> virtualView;
	private final MD placeholderDto;

	public VirtuaTableListener(VirtualView<MD, ?> virtualView, MD placeholderDto) {
		this.virtualView = new WeakReference<>(virtualView);
		this.placeholderDto = placeholderDto;
	}

	@Override
	public void handleEvent(Event event) {
		final TableViewer tableViewer = (TableViewer) getVirtualView().getColumnViewer();
		Table table = (Table) tableViewer.getControl();
		final int itemCount = table.getItemCount();

		int index = event.index;
		List<MD> input = (List<MD>) tableViewer.getInput();

		if (index <= itemCount && (index >= input.size() || placeholderDto.equals(input.get(index)))) {
			int start = Math.max(index - HALF_PAGE_SIZE, 0);
			int end = Math.min(start + PAGE_SIZE, itemCount);

			// T template = (T) getVirtualView().getTemplate().clone();
			// template.setFirstResult(start);
			// template.setMaxResults(end - start);

			List<MD> ops = getVirtualView().search();

			int startToFill = input.size();
			int endToFill = end;

			boolean changed = false;
			for (int i = startToFill; i < endToFill; i++) {
				input.add(placeholderDto);
				changed = true;
			}

			for (int i = 0, j = start; i < ops.size() && j < end; i++, j++) {
				if (placeholderDto.equals(input.get(j))) {
					MD element = ops.get(i);
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

	private VirtualView<MD, ?> getVirtualView() {
		return virtualView.get();
	}
}
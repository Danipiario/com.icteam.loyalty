package org.eclipse.jface.internal.databinding.swt;

import java.util.Arrays;

import org.eclipse.jface.databinding.swt.WidgetValueProperty;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;

public class ListMultiSelectionProperty extends WidgetValueProperty {

	private java.util.List<String> selections = null;
	private int[] indexes = null;

	public ListMultiSelectionProperty() {
		super(SWT.Selection);
	}

	@Override
	public Object getValueType() {
		return java.util.List.class;
	}

	@Override
	protected Object doGetValue(Object source) {
		final List list = (List) source;

		final int[] is = list.getSelectionIndices();
		if (selections == null || !Arrays.equals(is, indexes)) {
			selections = Arrays.asList(list.getSelection());
			indexes = is;

			if (selections.size() == 0) {
				selections = null;
			}
		}

		return selections;
	}

	@Override
	protected void doSetValue(Object source, Object value) {
		selections = (java.util.List<String>) value;

		final List list = (List) source;

		if (value != null) {
			list.setSelection(selections.toArray(new String[] {}));
		} else {
			list.deselectAll();
		}

		indexes = list.getSelectionIndices();
	}

}

package com.icteam.loyalty.common.ui.validator;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationUpdater;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.widgets.Control;

public class SimpleControlDecorationUpdater extends ControlDecorationUpdater {

	private final ControlDecoration controlDecoration;

	public SimpleControlDecorationUpdater(Control decorated, int position) {
		controlDecoration = new ControlDecoration(decorated, position);
	}

	public void update(Status status) {
		super.update(controlDecoration, status);
	}
}

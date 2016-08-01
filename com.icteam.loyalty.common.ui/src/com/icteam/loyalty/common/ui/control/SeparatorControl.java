package com.icteam.loyalty.common.ui.control;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SeparatorControl {

	@PostConstruct
	public void postConstruct(Composite parent) {
		new Label(parent, SWT.SEPARATOR) {
			private static final long serialVersionUID = 1L;

			@Override
			public Point computeSize(int wHint, int hHint, boolean changed) {
				return super.computeSize(wHint, 22, changed);
			}
		};
	}
}
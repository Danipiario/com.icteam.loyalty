package com.icteam.loyalty.common.ui.control;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class SpacerControl {

	@PostConstruct
	public void postConstruct(Composite parent) {
		final Composite body = new Composite(parent, SWT.NONE);

		body.setLayout(new GridLayout());
	}
}
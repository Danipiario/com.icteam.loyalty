
package com.icteam.loyalty.common.view;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class OperatorView {
	@Inject
	public OperatorView() {

	}

	@PostConstruct
	public void postConstruct(Composite parent) {
		final Label label = new Label(parent, SWT.NONE);
		label.setText("ciao");

	}




}
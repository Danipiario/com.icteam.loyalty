
package com.icteam.loyalty.application.view;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class View1 {
	@Inject
	public View1() {

	}

	@PostConstruct
	public void init(Composite parent) {
		Label label = new Label(parent, SWT.NONE);
		label.setText("Ciao mondo");
	}

}
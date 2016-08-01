
package com.icteam.loyalty.common.ui.editor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.widgets.Composite;

public class OperatorEditor {
	@Inject
	public OperatorEditor() {
	}

	@Inject
	MPart part;

	@PostConstruct
	public void postConstruct(Composite parent) {
		System.out.println(part.getTransientData().get("modelDTO"));


	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("destroy");
	}

}
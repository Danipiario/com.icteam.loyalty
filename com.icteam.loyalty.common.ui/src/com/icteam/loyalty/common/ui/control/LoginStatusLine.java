package com.icteam.loyalty.common.ui.control;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;

import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.nls.Messages;
import com.icteam.loyalty.common.nls.NLS;
import com.icteam.loyalty.common.service.AuthService;

public class LoginStatusLine {

	@Inject
	private AuthService authService;

	@PostConstruct
	void createControl(Composite parent, MToolControl control) {
		// Composite composite = new Composite(parent, SWT.None);
		// RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		// rowLayout.marginLeft = 8;
		// rowLayout.marginRight = 8;
		// rowLayout.marginTop = 6;
		// rowLayout.marginBottom = 4;
		//
		// composite.setLayout(rowLayout);

		final CLabel label = new CLabel(parent, SWT.SHADOW_NONE);
		label.setData(RWT.MARKUP_ENABLED, true);
		label.setTopMargin(3);
		label.setBottomMargin(9);

		label.setText(NLS.getFormatted(Messages.get().loginStatusLine,
				authService.getPrincipal().orElse(new OperatorDTO()).getName()));
	}

}
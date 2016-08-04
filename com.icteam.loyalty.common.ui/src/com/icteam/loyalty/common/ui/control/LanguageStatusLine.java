package com.icteam.loyalty.common.ui.control;

import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.ui.menu.MToolControl;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Composite;

import com.icteam.loyalty.common.dto.OperatorDTO;
import com.icteam.loyalty.common.interfaces.ILanguage;
import com.icteam.loyalty.common.nls.Messages;
import com.icteam.loyalty.common.nls.NLS;
import com.icteam.loyalty.common.service.AuthService;
import com.icteam.loyalty.common.ui.service.IconService;

public class LanguageStatusLine {

	@Inject
	private AuthService authService;

	@Inject
	private IconService iconService;

	/**
	 * @param control
	 */
	@PostConstruct
	void createControl(Composite parent, MToolControl control) {
		final CLabel label = new CLabel(parent, SWT.SHADOW_NONE);
		label.setData(RWT.TOOLTIP_MARKUP_ENABLED, true);
		label.setTopMargin(1);
		label.setBottomMargin(5);

		final Optional<OperatorDTO> optPrincipal = authService.getPrincipal();

		if (optPrincipal.isPresent()) {
			final ILanguage language = optPrincipal.get().getLanguage();

			label.setToolTipText(
					NLS.getFormatted(Messages.get().languageStatusLine, NLS.get(ILanguage.class, language.name())));

			label.setImage(iconService.getIcon(language.name().toLowerCase() + ".gif"));
		}
	}
}

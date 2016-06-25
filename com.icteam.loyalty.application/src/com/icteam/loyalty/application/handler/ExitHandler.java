
package com.icteam.loyalty.application.handler;

import java.text.MessageFormat;

import javax.servlet.http.HttpSession;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.client.service.JavaScriptExecutor;
import org.eclipse.swt.widgets.Shell;

import com.icteam.loyalty.application.internal.Messages;
import com.icteam.loyalty.application.util.ApplicationUtils;

public class ExitHandler {
	@Execute
	public void execute(IWorkbench workbench, Shell shell) {
		if (!ApplicationUtils.isImpersonate()) {
			if (MessageDialog.openConfirm(shell, Messages.get().confirm, Messages.get().confirm_exit)) {
				workbench.close();

				String defaultUrl = MessageFormat.format("{0}://{1}:{2}{3}",
						new Object[] { RWT.getRequest().getScheme(), RWT.getRequest().getServerName(),
								String.valueOf(RWT.getRequest().getServerPort()), RWT.getRequest().getRequestURI() });
				String browserText = MessageFormat.format("parent.window.location.href = \"{0}\";", defaultUrl);
				invalidate(RWT.getUISession().getHttpSession());
				RWT.getClient().getService(JavaScriptExecutor.class).execute(browserText);
			}
		} else {
			MessageDialog.openInformation(null, null, Messages.get().exit_not_allowed);
		}

	}

	private static void invalidate(final HttpSession session) {
		session.setMaxInactiveInterval(1);

		new Thread(new Runnable() {
			@Override
			public void run() {
				session.invalidate();
			}
		}).start();
	}
}
package com.icteam.loyalty.application.internal;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.apache.felix.jaas.LoginContextFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.lifecycle.PostContextCreate;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.application.jaas.LoginCallbackHandler;

public class LoginLifecycle {

	@PostContextCreate
	boolean login(Display display, IEclipseContext eclipseContext) {
		final ServiceTracker<LoginContextFactory, LoginContextFactory> serviceTracker = new ServiceTracker<>(
				FrameworkUtil.getBundle(getClass()).getBundleContext(), LoginContextFactory.class, null);
		try {
			serviceTracker.open();
			// Snippet.run(display);

			final String configName = "loyalty";

			LoginContext secureContext;

			while (true) {
				try {
					final Subject subject = new Subject();

					secureContext = serviceTracker.waitForService(1000).createLoginContext(configName, subject,
							new LoginCallbackHandler());
					secureContext.login();

					RWT.getUISession(display).setAttribute("secureContext", secureContext);
					eclipseContext.set("secureContext", secureContext);

					break;
				} catch (final LoginException | InterruptedException exception) {
					exception.printStackTrace();
					final Throwable cause = exception.getCause() == null ? exception : exception.getCause();
					if (cause instanceof ThreadDeath) {
						throw (ThreadDeath) cause;
					}

					final Status status = new Status(IStatus.ERROR, "com.icteam.loyalty.application", "Login failed",
							cause);
					ErrorDialog.openError(null, "Error", "Login failed", status);
				}
			}

			return secureContext.getSubject() != null;
		} finally {
			serviceTracker.close();
		}
	}
}

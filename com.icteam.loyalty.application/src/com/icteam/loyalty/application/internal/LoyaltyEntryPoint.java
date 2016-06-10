package com.icteam.loyalty.application.internal;

import java.security.PrivilegedAction;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

import org.apache.felix.jaas.LoginContextFactory;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.application.jaas.LoginCallbackHandler;

public class LoyaltyEntryPoint extends AbstractEntryPoint {

    private static final long serialVersionUID = -3357822020471836468L;

    @Override
    protected void createContents(Composite parent) {
        // nothing
    }

    @Override
    public int createUI() {
        final Display display = new Display();

        Object o = org.eclipse.jetty.util.Loader.getResource(org.eclipse.jetty.util.log.Log.class, "jetty-logging.properties");

        final ServiceTracker<LoginContextFactory, LoginContextFactory> serviceTracker = new ServiceTracker<>(
                FrameworkUtil.getBundle(getClass()).getBundleContext(), LoginContextFactory.class, null);
        serviceTracker.open();
        //		Snippet.run(display);

        final String configName = "loyalty";

        LoginContext secureContext;

        while (true) {
            try {
                final Subject subject = new Subject();

                secureContext = serviceTracker.waitForService(1000).createLoginContext(configName, subject, new LoginCallbackHandler());
                secureContext.login();

                RWT.getUISession(display).setAttribute("secureContext", secureContext);
                break;
            } catch (final LoginException | InterruptedException exception) {
                final Throwable cause = exception.getCause();
                if (cause != null && cause.getCause() instanceof ThreadDeath) {
                    throw (ThreadDeath) cause.getCause();
                }
                final Status status = new Status(IStatus.ERROR, "com.icteam.loyalty.ui", "Login failed", cause);
                ErrorDialog.openError(null, "Error", "Login failed", status);
            }
        }

        int result = 0;
        try {
            result = Subject.doAs(secureContext.getSubject(), getRunAction(display));
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            display.dispose();

            try {
                secureContext.logout();
            } catch (final LoginException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private static PrivilegedAction<Integer> getRunAction(final Display display) {
        return () -> PlatformUI.createAndRunWorkbench(display, new LoyaltyWorkbenchAdvisor());
    }

    public void stop() {
        final IWorkbench workbench = PlatformUI.getWorkbench();
        if (workbench != null) {
            final Display display = workbench.getDisplay();
            display.syncExec(() -> {
                if (!display.isDisposed()) {
                    workbench.close();
                }
            });
        }
    }
}

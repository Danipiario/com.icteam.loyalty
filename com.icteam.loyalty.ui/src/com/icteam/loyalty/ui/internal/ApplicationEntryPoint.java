package com.icteam.loyalty.ui.internal;

import java.net.URL;
import java.security.PrivilegedAction;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.security.auth.ILoginContext;
import org.eclipse.equinox.security.auth.LoginContextFactory;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.AbstractEntryPoint;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

public class ApplicationEntryPoint extends AbstractEntryPoint {

    private static final String JAAS_CONFIG_FILE = "jaas/login.conf";

    @Override
    protected void createContents(Composite parent) {
        // nothing
    }

    @Override
    public int createUI() {
        Display display = new Display();

        Snippet.run(display);

        String configName = "LOYALTY";
        BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();
        URL configUrl = bundleContext.getBundle().getEntry(JAAS_CONFIG_FILE);

        ILoginContext secureContext = null;
        while (true) {
            secureContext = LoginContextFactory.createContext(configName, configUrl);

            try {
                secureContext.login();

                RWT.getUISession(display).setAttribute("secureContext", secureContext);
                break;
            } catch (LoginException exception) {
                Throwable cause = exception.getCause();
                if (cause != null && cause.getCause() instanceof ThreadDeath) {
                    throw (ThreadDeath) cause.getCause();
                }
                Status status = new Status(IStatus.ERROR, "com.icteam.loyalty.ui", "Login failed", cause);
                ErrorDialog.openError(null, "Error", "Login failed", status);
            }
        }

        int result = 0;
        try {
            result = Subject.doAs(secureContext.getSubject(), getRunAction(display));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            display.dispose();

            try {
                secureContext.logout();
            } catch (LoginException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private static PrivilegedAction<Integer> getRunAction(final Display display) {
        return new PrivilegedAction<Integer>() {

            @Override
            public Integer run() {
                return PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
            }
        };
    }

    public void stop() {
        final IWorkbench workbench = PlatformUI.getWorkbench();
        if (workbench != null) {
            final Display display = workbench.getDisplay();
            display.syncExec(new Runnable() {
                @Override
                public void run() {
                    if (!display.isDisposed()) {
                        workbench.close();
                    }
                }
            });
        }
    }

}

package com.icteam.loyalty.ui.handler;

import java.text.MessageFormat;

import javax.servlet.http.HttpSession;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.client.service.JavaScriptExecutor;
import org.eclipse.ui.handlers.HandlerUtil;

import com.icteam.loyalty.api.Messages;
import com.icteam.loyalty.ui.util.UIUtils;

public class ExitHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) {
        if (!UIUtils.isImpersonate()) {
            if (HandlerUtil.getActiveWorkbenchWindow(event).close()) {
                String defaultUrl = MessageFormat.format("{0}://{1}:{2}{3}", new Object[] { RWT.getRequest().getScheme(),
                        RWT.getRequest().getServerName(), String.valueOf(RWT.getRequest().getServerPort()), RWT.getRequest().getRequestURI() });
                String browserText = MessageFormat.format("parent.window.location.href = \"{0}\";", defaultUrl);
                invalidate(RWT.getUISession().getHttpSession());
                RWT.getClient().getService(JavaScriptExecutor.class).execute(browserText);
            }
        } else {
            MessageDialog.openInformation(null, null, Messages.get().exit_not_allowed);
        }

        return null;
    }

    private static void invalidate(final HttpSession session) {
        session.setMaxInactiveInterval(1);

        new Thread() {
            @Override
            public void run() {
                session.invalidate();
            }
        }.start();
    }
}

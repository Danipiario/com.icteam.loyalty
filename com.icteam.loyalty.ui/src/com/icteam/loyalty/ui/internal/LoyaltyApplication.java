package com.icteam.loyalty.ui.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.Application.OperationMode;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.client.WebClient;
import org.osgi.service.component.annotations.Component;

import com.icteam.loyalty.ui.handler.DownloadServiceHandler;

@Component(property = { "contextName=icteam" })
public class LoyaltyApplication implements ApplicationConfiguration {

    @Override
    public void configure(Application application) {
        String impersonateTheme = "impersonate_theme";

        application.setOperationMode(OperationMode.SWT_COMPATIBILITY);
        application.addServiceHandler("download", new DownloadServiceHandler());

        application.addStyleSheet(RWT.DEFAULT_THEME_ID, "theme/theme.css");
        application.addStyleSheet(impersonateTheme, "theme/theme.css");
        application.addStyleSheet(impersonateTheme, "theme/impersonate_theme.css");

        Map<String, String> properties = new HashMap<>();
        properties.put(WebClient.PAGE_TITLE, "Loyalty");
        properties.put(WebClient.THEME_ID, RWT.DEFAULT_THEME_ID);

        application.addEntryPoint("/loyalty", ApplicationEntryPoint.class, properties);

        properties = new HashMap<>();
        properties.put(WebClient.PAGE_TITLE, "Loyalty Impersonificato");
        properties.put(WebClient.THEME_ID, impersonateTheme);

        application.addEntryPoint("/impersonate", ImpersonateEntryPoint.class, properties);
    }
}

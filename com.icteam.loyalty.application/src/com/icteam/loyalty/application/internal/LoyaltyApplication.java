package com.icteam.loyalty.application.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rap.e4.E4ApplicationConfig;
import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.Application.OperationMode;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.client.WebClient;
import org.osgi.service.component.annotations.Component;

@Component(name = "com.icteam.loyalty.application", property = { "contextName=icteam" })
public class LoyaltyApplication implements ApplicationConfiguration {

	@Override
	public void configure(Application application) {
		final Map<String, String> properties = new HashMap<>();
		properties.put(WebClient.PAGE_TITLE, Messages.get().pageTitle);
		application.setOperationMode(OperationMode.SWT_COMPATIBILITY);
		application.addEntryPoint("/loyalty",
				new LoyaltyEntryPointFactory(E4ApplicationConfig.create(
						"platform:/plugin/com.icteam.loyalty.application/OSGI-INF/e4/LoyaltyApplication.e4xmi",
						"bundleclass://com.icteam.loyalty.application/com.icteam.loyalty.application.internal.LoginLifecycle")),
				properties);
		// application.addEntryPoint("/loyalty", LoyaltyEntryPoint.class,
		// properties);
	}

}

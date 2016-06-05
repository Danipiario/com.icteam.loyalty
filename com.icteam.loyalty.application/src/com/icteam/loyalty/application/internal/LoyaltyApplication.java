package com.icteam.loyalty.application.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.client.WebClient;
import org.osgi.service.component.annotations.Component;

import com.icteam.loyalty.common.api.EnumService;

@Component(name = "com.icteam.loyalty.application", property = { "contextName=icteam" })
public class LoyaltyApplication implements ApplicationConfiguration {

	private EnumService es;

	@Override
	public void configure(Application application) {
		final Map<String, String> properties = new HashMap<>();
		properties.put(WebClient.PAGE_TITLE, "Hello RAP");
		application.addEntryPoint("/loyalty", LoyaltyEntryPoint.class, properties);
	}

}

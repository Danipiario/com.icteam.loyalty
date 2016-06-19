package com.icteam.loyalty.common.nls;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Loyalty Common NLS Configuration", id = "com.icteam.loyalty.common.nls", pid = "com.icteam.loyalty.common.nls", description = "Parametri di configurazione per la localizzazione dei messaggi")
public interface NLSConfiguration {

	@AttributeDefinition(defaultValue = "it_IT", description = "Default locale utilizzato se non presente il locale dell'utente")
	String defaultLocale();
}

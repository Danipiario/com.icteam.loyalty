package com.icteam.loyalty.common.internal.querydsl;

import java.util.Dictionary;
import java.util.HashMap;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import com.icteam.loyalty.common.configuration.Configurable;
import com.icteam.loyalty.common.nls.NLS;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.SQLTemplates;

/***
 * Simple component that registers Querydsl configuration as an OSGi service.
 */

@Component(immediate = true, configurationPid = "com.icteam.loyalty.common.internal.querydsl")
public class QuerydslConfigurationComponent implements ManagedService {

	public static final int P00_SERVICE_DESCRIPTION = 0;

	public static final int P01_SQL_TEMPLATES = 1;

	public static final int P02_USE_LITERALS = 2;

	private ServiceRegistration<Configuration> serviceRegistration;

	private static QuerydslConfiguration configuration = Configurable.createConfigurable(QuerydslConfiguration.class,
			new HashMap<>());

	/**
	 * Component activator method.
	 *
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@Activate
	public void activate(final BundleContext bundleContext)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String sqlTemplatesFQCN = configuration.sqlTemplatesFQCN();

		SQLTemplates sqlTemplates = (SQLTemplates) bundleContext.getBundle().loadClass(sqlTemplatesFQCN).newInstance();

		Configuration configuration = new Configuration(sqlTemplates);
		configuration.setUseLiterals(configuration.getUseLiterals());

		serviceRegistration = bundleContext.registerService(Configuration.class, configuration, null);
	}

	/**
	 * Component deactivate method.
	 */
	@Deactivate
	public void deactivate() {
		if (serviceRegistration != null) {
			serviceRegistration.unregister();
		}
	}

	@Override
	public void updated(Dictionary<String, ?> properties) throws ConfigurationException {
		if (properties != null) {
			synchronized (NLS.class) {
				configuration = Configurable.createConfigurable(QuerydslConfiguration.class, properties);
			}
		}
	}
}

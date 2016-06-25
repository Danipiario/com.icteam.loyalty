package com.icteam.loyalty.common.internal.tracker;

import java.util.List;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.common.interfaces.IEnum;
import com.icteam.loyalty.common.service.EnumService;

public class EnumTracker extends BundleTracker<Bundle> {

	private static final String ENUM_EXTENSION = "Enum-Extension";

	private final ServiceTracker<EnumService, EnumService> serviceTracker;

	private final Logger logger = Log.getLogger(EnumTracker.class);

	public EnumTracker(BundleContext context) {
		super(context, Bundle.UNINSTALLED | Bundle.ACTIVE, null);

		serviceTracker = new ServiceTracker<>(context, EnumService.class, null);
		serviceTracker.open();
	}

	@Override
	public Bundle addingBundle(Bundle bundle, BundleEvent event) {
		final String extension = bundle.getHeaders().get(ENUM_EXTENSION);

		if (extension != null) {
			addEnumExtension(bundle, extension);
		}

		return super.addingBundle(bundle, event);
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event, Bundle object) {
		final String extension = bundle.getHeaders().get(ENUM_EXTENSION);

		if (extension != null) {
			removeEnumExtension(bundle, extension);
		}

		super.removedBundle(bundle, event, object);
	}

	@Override
	public void close() {
		super.close();

		serviceTracker.close();
	}

	private void removeEnumExtension(final Bundle bundle, final String extension) {
		new Thread(() -> {
			final String[] enumClasses = StringUtils.stripAll(StringUtils.split(extension, ","));

			for (final String enumClass : enumClasses) {
				try {
					logger.info("bundle #{} - remove enum #{}", bundle.getSymbolicName(), enumClass);

					final Class<? extends Enum<?>> ec = (Class<? extends Enum<?>>) bundle.loadClass(enumClass);
					final List<Class<?>> interfaces = ClassUtils.getAllInterfaces(ec);

					for (final Class<?> interface_ : interfaces) {
						if (IEnum.class.isAssignableFrom(interface_)) {
							final Class<? extends IEnum> interfaceClass = (Class<? extends IEnum>) interface_;

							final EnumService enumService = serviceTracker.waitForService(10000);

							if (enumService != null) {
								enumService.removeEnum(interfaceClass, ec);
							}
						}
					}
				} catch (ClassNotFoundException | InterruptedException e) {
					logger.warn("error remove enum for bundle #" + bundle.getSymbolicName(), e);
				}
			}
		}).start();
	}

	private void addEnumExtension(final Bundle bundle, final String extension) {
		new Thread(() -> {
			final String[] enumClasses = StringUtils.stripAll(StringUtils.split(extension, ","));

			for (final String enumClass : enumClasses) {
				try {
					logger.info("bundle #{} - add enum #{}", bundle.getSymbolicName(), enumClass);

					final Class<? extends Enum<?>> ec = (Class<? extends Enum<?>>) bundle.loadClass(enumClass);
					final List<Class<?>> interfaces = ClassUtils.getAllInterfaces(ec);

					for (final Class<?> interface_ : interfaces) {
						if (IEnum.class.isAssignableFrom(interface_)) {
							final Class<? extends IEnum> interfaceClass = (Class<? extends IEnum>) interface_;

							final EnumService enumService = serviceTracker.waitForService(10000);

							if (enumService != null) {
								enumService.addEnum(interfaceClass, ec);
							}
						}
					}
				} catch (ClassNotFoundException | InterruptedException e) {
					logger.warn("error manage enum for bundle #" + bundle.getSymbolicName(), e);
				}
			}
		}).start();
	}
}

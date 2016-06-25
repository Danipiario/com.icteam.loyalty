package com.icteam.loyalty.common.internal.tracker;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.osgi.dto.DTO;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.common.service.DTOService;

public class DTOTracker extends BundleTracker<Bundle> {

	private static final String DTO_EXTENSION = "DTO-Extension";

	private final ServiceTracker<DTOService, DTOService> serviceTracker;

	private final Logger logger = Log.getLogger(DTOTracker.class);

	public DTOTracker(BundleContext context) {
		super(context, Bundle.UNINSTALLED | Bundle.ACTIVE, null);

		serviceTracker = new ServiceTracker<>(context, DTOService.class, null);
		serviceTracker.open();
	}

	@Override
	public Bundle addingBundle(Bundle bundle, BundleEvent event) {
		final String extension = bundle.getHeaders().get(DTO_EXTENSION);

		if (extension != null) {
			addDTOExtension(bundle, extension);
		}

		return super.addingBundle(bundle, event);
	}

	@Override
	public void removedBundle(Bundle bundle, BundleEvent event, Bundle object) {
		final String extension = bundle.getHeaders().get(DTO_EXTENSION);

		if (extension != null) {
			removeDTOExtension(bundle, extension);
		}

		super.removedBundle(bundle, event, object);
	}

	@Override
	public void close() {
		super.close();

		serviceTracker.close();
	}

	private void removeDTOExtension(final Bundle bundle, final String extension) {
		new Thread(() -> {
			final String[] dtoClasses = StringUtils.stripAll(StringUtils.split(extension, ","));

			for (final String dtoClass : dtoClasses) {
				try {
					logger.info("bundle #{} - remove DTO #{}", bundle.getSymbolicName(), dtoClass);

					final Class<? extends DTO> dtoExtendedClass = (Class<? extends DTO>) bundle.loadClass(dtoClass);
					final Class<? extends DTO> dc = (Class<? extends DTO>) dtoExtendedClass.getSuperclass();

					final DTOService dtoService = serviceTracker.waitForService(10000);

					if (dtoService != null) {
						dtoService.removeDTO(dc);
					}
				} catch (ClassNotFoundException | InterruptedException e) {
					logger.warn("error remove dto for bundle #" + bundle.getSymbolicName(), e);
				}
			}
		}).start();
	}

	private void addDTOExtension(final Bundle bundle, final String extension) {
		new Thread(() -> {
			final String[] dtoClasses = StringUtils.stripAll(StringUtils.split(extension, ","));

			for (final String dtoClass : dtoClasses) {
				try {
					logger.info("bundle #{} - add DTO #{}", bundle.getSymbolicName(), dtoClass);

					final Class<? extends DTO> dtoExtendedClass = (Class<? extends DTO>) bundle.loadClass(dtoClass);
					final Class<? extends DTO> dc = (Class<? extends DTO>) dtoExtendedClass.getSuperclass();

					final DTOService dtoService = serviceTracker.waitForService(10000);

					if (dtoService != null) {
						dtoService.addDTO(dc, dtoExtendedClass);
					}
				} catch (ClassNotFoundException | InterruptedException e) {
					logger.warn("error manage dto for bundle #" + bundle.getSymbolicName(), e);
				}
			}
		}).start();
	}
}

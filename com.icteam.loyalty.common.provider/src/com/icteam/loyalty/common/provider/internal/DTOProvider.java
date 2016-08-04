package com.icteam.loyalty.common.provider.internal;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;
import org.osgi.util.tracker.ServiceTracker;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.service.DTOService;

@Component(service = DTOService.class, immediate = true, scope = ServiceScope.SINGLETON)
public class DTOProvider implements DTOService {

	private final Logger logger = Log.getLogger(DTOProvider.class);

	@Override
	public <D extends IDTO> D newDTO(Class<D> dtoClass, boolean enableTrackChanges) {
		BundleContext bundleContext = FrameworkUtil.getBundle(getClass()).getBundleContext();

		ServiceTracker<D, D> serviceTracker = null;
		try {
			Filter filter = bundleContext.createFilter("(&(" + Constants.OBJECTCLASS + "=" + IDTO.class.getName()
					+ ")(dtoClass=" + dtoClass.getSimpleName() + "))");

			serviceTracker = new ServiceTracker<>(bundleContext, filter, null);
			serviceTracker.open();

			D dto = serviceTracker.waitForService(1000);

			if (dto != null) {
				if (enableTrackChanges) {
					dto.enableTrackChanges();
				}

				return dto;
			}
		} catch (InterruptedException | InvalidSyntaxException e) {
			logger.warn(e);
		} finally {
			if (serviceTracker != null) {
				serviceTracker.close();
			}
		}

		throw new IllegalArgumentException("error instantiating dtoClass #" + dtoClass.getName());
	}
	// private <D extends IDTO> D getDTOInstance(Class<D> dtoClass) {
	// BundleContext bundleContext =
	// FrameworkUtil.getBundle(getClass()).getBundleContext();
	//
	// ServiceTracker<ComponentFactory, ComponentFactory> serviceTracker = null;
	// try {
	// Filter filter = bundleContext
	// .createFilter("(&(" + Constants.OBJECTCLASS + "=" +
	// ComponentFactory.class.getName() + ")("
	// + ComponentConstants.COMPONENT_FACTORY + "=" + dtoClass.getName() +
	// "))");
	//
	// serviceTracker = new ServiceTracker<>(bundleContext, filter, null);
	// serviceTracker.open();
	//
	// ComponentFactory componentFactory = serviceTracker.waitForService(1000);
	//
	// if (componentFactory != null) {
	// ComponentInstance instance = componentFactory.newInstance(null);
	// return (D) instance.getInstance();
	// }
	//
	// } catch (InvalidSyntaxException | InterruptedException e) {
	// } finally {
	// if (serviceTracker != null) {
	// serviceTracker.close();
	// }
	// }
	//
	// throw new IllegalArgumentException("error instantiating dtoClass #" +
	// dtoClass.getName());
	// }

	// @Override
	// public void addDTO(Class<? extends IDTO> dtoClass, Class<? extends IDTO>
	// dtoExtendedClass) {
	// Class<? extends IDTO> old = dtoClasses.put(dtoClass, dtoExtendedClass);
	//
	// logger.info("DTO Provider - replace DTO class #{} with DTO Extension
	// #{}", old.getName(),
	// dtoExtendedClass.getName());
	// }
	//
	// @Override
	// public void removeDTO(Class<? extends IDTO> dtoClass) {
	// Class<? extends IDTO> old = dtoClasses.remove(dtoClass);
	//
	// logger.info("DTO Provider - remove DTO Extension #{}", old.getName());
	// }

}

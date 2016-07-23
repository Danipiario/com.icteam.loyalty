package com.icteam.loyalty.common.internal.provider;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.icteam.loyalty.common.dto.IDTO;
import com.icteam.loyalty.common.service.DTOService;

@Component(service = DTOService.class, immediate = true, scope = ServiceScope.SINGLETON)
public class DTOProvider implements DTOService {

	private final Logger logger = Log.getLogger(DTOProvider.class);

	private final Map<Class<? extends IDTO>, Class<? extends IDTO>> dtoClasses = new HashMap<>();

	@Override
	public <D extends IDTO> D newDTO(Class<D> dtoClass) {
		Class<? extends IDTO> dtoExtendedClass = dtoClasses.get(dtoClass);

		if (dtoExtendedClass == null) {
			dtoClasses.put(dtoClass, dtoExtendedClass = dtoClass);
		}

		try {
			D dto = (D) dtoExtendedClass.newInstance();
			dto.enableTrackChanges();

			return dto;
		} catch (InstantiationException | IllegalAccessException e) {
			throw new IllegalArgumentException("error instantiating dtoClass #" + dtoClass.getName());
		}
	}

	@Override
	public void addDTO(Class<? extends IDTO> dtoClass, Class<? extends IDTO> dtoExtendedClass) {
		Class<? extends IDTO> old = dtoClasses.put(dtoClass, dtoExtendedClass);

		logger.info("DTO Provider - replace DTO class #{} with DTO Extension #{}", old.getName(),
				dtoExtendedClass.getName());
	}

	@Override
	public void removeDTO(Class<? extends IDTO> dtoClass) {
		Class<? extends IDTO> old = dtoClasses.remove(dtoClass);

		logger.info("DTO Provider - remove DTO Extension #{}", old.getName());
	}

}

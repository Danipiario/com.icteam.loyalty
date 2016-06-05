package com.icteam.loyalty.common.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.icteam.loyalty.common.api.EnumService;
import com.icteam.loyalty.common.api.interfaces.IEnum;


/**
 *
 */
@Component(name = "com.icteam.loyalty.common.enumservice", scope = ServiceScope.SINGLETON)
public class EnumProvider implements EnumService {

	Map<Class<? extends IEnum>, List<IEnum>> enumLists = new HashMap<>();

	@Override
	public synchronized List<? extends IEnum> values(Class<? extends IEnum> interfaceClass) {
		return enumLists.get(interfaceClass);
	}

	@Override
	public synchronized void addEnum(Class<? extends IEnum> interfaceClass, Class<? extends Enum<?>> enumClass) {
		if (!enumLists.containsKey(interfaceClass)) {
			enumLists.put(interfaceClass, new ArrayList<>());
		}

		enumLists.get(interfaceClass).addAll((Collection<IEnum>) Arrays.asList(enumClass.getEnumConstants()));
	}

}

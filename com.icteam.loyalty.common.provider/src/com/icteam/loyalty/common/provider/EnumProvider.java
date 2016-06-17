package com.icteam.loyalty.common.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.icteam.loyalty.common.api.interfaces.IEnum;
import com.icteam.loyalty.common.api.service.EnumService;

/**
 *
 */
@Component(name = "com.icteam.loyalty.common.enumservice", scope = ServiceScope.SINGLETON, immediate = true)
public class EnumProvider implements EnumService {

	private final Map<Class<? extends IEnum>, List<IEnum>> enumLists = new HashMap<>();

	@Override
	public synchronized List<? extends IEnum> values(Class<? extends IEnum> interfaceClass) {
		return enumLists.get(interfaceClass);
	}

	@Override
	public synchronized void addEnum(Class<? extends IEnum> interfaceClass, Class<? extends Enum<?>> enumClass) {
		getOrCreateEnumList(interfaceClass).addAll((Collection<IEnum>) Arrays.asList(enumClass.getEnumConstants()));
	}

	private List<IEnum> getOrCreateEnumList(Class<? extends IEnum> interfaceClass) {
		if (!enumLists.containsKey(interfaceClass)) {
			enumLists.put(interfaceClass, new ArrayList<>());
		}

		return enumLists.get(interfaceClass);
	}

	@Override
	public synchronized void removeEnum(Class<? extends IEnum> interfaceClass, Class<? extends Enum<?>> enumClass) {
		getOrCreateEnumList(interfaceClass).removeAll(Arrays.asList(enumClass.getEnumConstants()));
	}

}

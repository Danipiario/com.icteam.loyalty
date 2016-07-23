package com.icteam.loyalty.common.internal.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import com.icteam.loyalty.common.interfaces.IEnum;
import com.icteam.loyalty.common.service.EnumService;

@Component(scope = ServiceScope.SINGLETON)
public class EnumProvider implements EnumService {

	Map<Class<? extends IEnum>, List<IEnum>> enumLists = new HashMap<>();

	@Override
	public synchronized List<? extends IEnum> values(Class<? extends IEnum> interfaceClass) {
		return getOrCreateEnumList(interfaceClass);
	}

	@Override
	public <E extends IEnum> E value(Class<E> interfaceClass, String name) {
		return (E) values(interfaceClass).stream().filter(iEnum -> iEnum.name().equals(name)).findFirst().get();
	}

	@Override
	public <E extends IEnum> E value(String name) {
		for (List<IEnum> list : enumLists.values()) {
			Optional<IEnum> opt = list.stream().filter(iEnum -> iEnum.name().equals(name)).findFirst();
			if (opt.isPresent()) {
				return (E) opt.get();
			}
		}

		throw new IllegalArgumentException("no enum for value #" + name);
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

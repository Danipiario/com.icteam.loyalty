package com.icteam.loyalty.common.service;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

import com.icteam.loyalty.common.interfaces.IEnum;

/**
 *
 */
@ProviderType
public interface EnumService {

	List<? extends IEnum> values(Class<? extends IEnum> clazz);

	<E extends IEnum> E value(Class<E> clazz, String name);

	<E extends IEnum> E value(String name);

	void addEnum(Class<? extends IEnum> interfaceClass, Class<? extends Enum<?>> enumClass);

	void removeEnum(Class<? extends IEnum> interfaceClass, Class<? extends Enum<?>> enumClass);

}

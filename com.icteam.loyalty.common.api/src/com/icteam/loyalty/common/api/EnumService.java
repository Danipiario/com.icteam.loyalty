package com.icteam.loyalty.common;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

import com.icteam.loyalty.common.interfaces.IEnum;

/**
 *
 */
@ProviderType
public interface EnumService {

	List< ? extends IEnum> values(Class< ? extends IEnum> clazz);

	void addEnum(Class< ? extends IEnum> interfaceClass, Class< ? extends Enum< ? >> enumClass);

	void removeEnum(Class< ? extends IEnum> interfaceClass, Class< ? extends Enum< ? >> enumClass);

}

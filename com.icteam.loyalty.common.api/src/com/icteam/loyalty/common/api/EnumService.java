package com.icteam.loyalty.common.api;

import java.util.List;

import com.icteam.loyalty.common.api.interfaces.IEnum;

/**
 *
 */
public interface EnumService {

    List< ? extends IEnum> values(Class< ? extends IEnum> clazz);

    void addEnum(Class< ? extends IEnum> interfaceClass, Class< ? extends Enum< ? >> enumClass);

    void removeEnum(Class< ? extends IEnum> interfaceClass, Class< ? extends Enum< ? >> enumClass);

}

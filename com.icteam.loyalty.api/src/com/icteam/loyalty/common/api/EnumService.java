package com.icteam.loyalty.common.api;

import java.util.List;

import com.icteam.loyalty.common.interfaces.IEnum;

/**
 *
 */
public interface EnumService {

    <I extends IEnum> List<I> values(Class<I> clazz);

    void addEnum(Class< ? extends IEnum> interfaceClass, Class< ? extends Enum< ? >> enumClass);

}

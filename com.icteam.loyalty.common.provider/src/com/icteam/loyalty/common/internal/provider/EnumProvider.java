package com.icteam.loyalty.common.internal.provider;

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

@Component(scope = ServiceScope.SINGLETON)
public class EnumProvider implements EnumService {

    Map<Class< ? extends IEnum>, List<IEnum>> enumLists = new HashMap<>();

    @Override
    public synchronized List< ? extends IEnum> values(Class< ? extends IEnum> interfaceClass) {
        return enumLists.get(interfaceClass);
    }

    @Override
    public synchronized void addEnum(Class< ? extends IEnum> interfaceClass, Class< ? extends Enum< ? >> enumClass) {
        getOrCreateEnumList(interfaceClass).addAll((Collection<IEnum>) Arrays.asList(enumClass.getEnumConstants()));
    }

    private List<IEnum> getOrCreateEnumList(Class< ? extends IEnum> interfaceClass) {
        if (!enumLists.containsKey(interfaceClass)) {
            enumLists.put(interfaceClass, new ArrayList<>());
        }

        return enumLists.get(interfaceClass);
    }

    @Override
    public synchronized void removeEnum(Class< ? extends IEnum> interfaceClass, Class< ? extends Enum< ? >> enumClass) {
        getOrCreateEnumList(interfaceClass).removeAll(Arrays.asList(enumClass.getEnumConstants()));
    }

}

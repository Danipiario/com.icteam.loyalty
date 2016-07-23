package com.icteam.loyalty.model;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import org.kahvi.paketti.dtobuilder.DtoBuilder;
import org.kahvi.paketti.dtobuilder.DtoConfigurationException;

import com.icteam.loyalty.model.interfaces.IDbModel;
import com.icteam.loyalty.model.interfaces.IDtoModel;

public abstract class DbModel<D extends IDtoModel> implements IDbModel<D> {

    private static final long serialVersionUID = -8828495843721969485L;

    private static Map<Class< ? >, DtoBuilder< ? >> dtoBuilders = new HashMap<>();

    private final Class<D> dtoClass;

    public DbModel() {
        dtoClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<D> getDtoClass() {
        return dtoClass;
    }

    @Override
    public final D buildDto() {
        try {
            D dto = getDtoBuilder().build(this);

            dto = customBuildDto(dto);

            dto.setDirty(false);
            dto.enableTrackChanges();

            return dto;
        } catch (DtoConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected D customBuildDto(D dto) {
        return dto;
    }

    @Override
    public DtoBuilder<D> getDtoBuilder() {
        DtoBuilder<D> dtoBuilder = (DtoBuilder<D>) dtoBuilders.get(dtoClass);

        if (dtoBuilder == null) {
            dtoBuilder = new DtoBuilder<>(dtoClass);
            dtoBuilders.put(dtoClass, dtoBuilder);
        }

        return dtoBuilder;
    }
}

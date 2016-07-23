package com.icteam.loyalty.model.builder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.kahvi.paketti.dtobuilder.DtoBuilder;
import org.kahvi.paketti.dtobuilder.DtoConfigurationException;
import org.kahvi.paketti.dtobuilder.annotations.DtoClass;

import com.icteam.loyalty.model.ModelBuilder;
import com.icteam.loyalty.model.interfaces.IDbModel;
import com.icteam.loyalty.model.interfaces.IDtoModel;

public class ModelBuilderImpl<D extends IDtoModel> implements ModelBuilder<D> {

    class DtoTransformer implements Transformer {

        @Override
        public D transform(Object object) {
            return buildDto((IDbModel<D>) object);
        }
    }

    private final Class<D> dtoClass;
    private final Class<IDbModel<D>> dbModelClass;

    private static Map<Class< ? >, DtoBuilder< ? >> dtoBuilders = new HashMap<>();

    public ModelBuilderImpl() {
        dtoClass = (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        DtoClass dtoClassAnn = dtoClass.getAnnotation(DtoClass.class);
        dbModelClass = (Class<IDbModel<D>>) dtoClassAnn.sourceClasses()[0];
    }

    @Override
    public <T extends IDbModel<D>> T build(D dtoModel) {
        T dbModel = null;
        try {
            dbModel = (T) dbModelClass.newInstance();
            PropertyUtils.copyProperties(dbModel, dtoModel);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }

        return dbModel;
    }

    private DtoBuilder<D> getDtoBuilder() {
        DtoBuilder<D> dtoBuilder = (DtoBuilder<D>) dtoBuilders.get(dtoClass);

        if (dtoBuilder == null) {
            dtoBuilder = new DtoBuilder<>(dtoClass);
            dtoBuilders.put(dtoClass, dtoBuilder);
        }

        return dtoBuilder;
    }

    @Override
    public D buildDto(IDbModel<D> dbModel) {
        try {
            D dto = getDtoBuilder().build(dbModel);

            dto = customBuildDto(dbModel, dto);

            dto.setDirty(false);
            dto.enableTrackChanges();

            return dto;
        } catch (DtoConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public D newDto() {
        try {
            return dtoClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            return null;
        }
    }

    @Override
    public D initDto(D dto, Object... params) {
        return dto;
    }

    protected <T extends IDbModel<D>> D customBuildDto(T dbModel, D dto) {
        return dto;
    }

    @Override
    public <T extends IDbModel<D>> List<D> buildDtoList(List<T> dbModelList) {
        return (List<D>) CollectionUtils.collect(dbModelList, new DtoTransformer());
    }

}

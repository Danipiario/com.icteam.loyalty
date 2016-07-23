package com.icteam.loyalty.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import org.apache.commons.collections.Closure;

public abstract class AnnotationClosure<A extends Annotation> implements Closure {

    private final Class<A> annotationClass;

    public AnnotationClosure() {
        annotationClass = (Class<A>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void execute(Object paramObject) {
        Field field = (Field) paramObject;
        A annotation = field.getAnnotation(annotationClass);

        if (annotation != null) {
            field.setAccessible(true);
            execute(field, annotation);
        }
    }

    public abstract void execute(Field field, A annotation);
}

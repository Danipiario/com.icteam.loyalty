package com.icteam.loyalty.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.apache.commons.collections.Predicate;

public abstract class AnnotationPredicate<A extends Annotation> implements Predicate {

    private final String propertyName;
    private final Class<A> annotationClass;

    public AnnotationPredicate(String propertyName, Class<A> annotationClass) {
        this.propertyName = propertyName;
        this.annotationClass = annotationClass;
    }

    @Override
    public boolean evaluate(Object paramObject) {
        Field field = (Field) paramObject;

        return field.getName().equals(propertyName) && field.getAnnotation(annotationClass) != null;
    }
}

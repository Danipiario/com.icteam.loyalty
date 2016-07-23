package com.icteam.loyalty.model;

import org.apache.commons.collections.Closure;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.icteam.loyalty.model.interfaces.EAnnotation;
import com.icteam.loyalty.model.util.ModelUtil;

public abstract class EAnnotationClosure<T> implements Closure {

    protected final EAnnotation annotation;

    public EAnnotationClosure(EAnnotation annotation) {
        this.annotation = annotation;
    }

    @Override
    public void execute(Object paramObject) {
        EStructuralFeature feature = (EStructuralFeature) paramObject;
        T value = (T) ModelUtil.getAnnotation(feature, annotation);

        execute(feature, value);
    }

    public abstract void execute(EStructuralFeature feature, T value);
}

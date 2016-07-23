package com.icteam.loyalty.common.enums;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Where {

    String prefixI18N() default "";

    EWhereClause value() default EWhereClause.EQUAL;

    String fieldName() default "";
}

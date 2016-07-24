package com.icteam.loyalty.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.icteam.loyalty.common.enums.EWhereClause;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface WhereTemplate {

    EWhereClause value() default EWhereClause.EQUAL;
}

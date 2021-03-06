package com.icteam.loyalty.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.icteam.loyalty.common.enums.EDynamicFilterable;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Property {

	boolean show() default false;

	int order() default Integer.MAX_VALUE;

	boolean translatable() default true;

	EDynamicFilterable dynamicFilterable() default EDynamicFilterable.NO;

	boolean translateWithType() default false;

	boolean sortable() default true;
}

package com.icteam.loyalty.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.icteam.loyalty.common.enums.EValidation;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validated {

	String regExpr() default "";

	EValidation validation() default EValidation.REG_EXPR;

	String validatorId() default "";

	String validationMessage() default "value_format_invalid_message";

}

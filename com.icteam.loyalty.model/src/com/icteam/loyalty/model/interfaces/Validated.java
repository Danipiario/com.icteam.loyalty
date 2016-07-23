package com.icteam.loyalty.model.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validated {

    String regExpr() default "";

    EValidation validation() default EValidation.REG_EXPR;

    String validatorId() default "";

    String validationMessage() default "value_format_invalid_message";

}

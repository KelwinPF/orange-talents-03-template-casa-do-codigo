package com.example.demo.configuraton.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = IsCountryStateValidator.class)
@Target({ ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsCountryState {
    String message() default "Esse Estado não pertence a esse Pais";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
	
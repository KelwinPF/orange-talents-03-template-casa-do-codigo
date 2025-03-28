package com.example.demo.configuraton.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = VerifyDocumentValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface VerifyDocument {
    String message() default "Insira documento no formato correto";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

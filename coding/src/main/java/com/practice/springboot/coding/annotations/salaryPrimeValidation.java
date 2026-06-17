package com.practice.springboot.coding.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = salaryPrimeValidator.class)
public @interface salaryPrimeValidation {

    String message() default "Salary must be a prime number greater than or equal to 2";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

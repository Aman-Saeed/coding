package com.practice.springboot.coding.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class salaryPrimeValidator implements ConstraintValidator<salaryPrimeValidation, Double> {

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value < 2) {
            return false;
        }
        if(value % 2 == 0) {
            return true;
        }
        return false;
    }
}

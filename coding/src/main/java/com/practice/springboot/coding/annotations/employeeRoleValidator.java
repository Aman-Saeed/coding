package com.practice.springboot.coding.annotations;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class employeeRoleValidator implements ConstraintValidator<employeeRoleValidation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) {
            return false;
        }
        List<String> validRoles = List.of("ADMIN", "USER");
        return validRoles.contains(value);
    }
}

package com.example.demo.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OtherEnumPatternValidator implements ConstraintValidator<OtherEnumPattern, Enum<?>> {

    UserStatus[] statuses;

    @Override
    public void initialize(OtherEnumPattern constraintAnnotation) {
        statuses = constraintAnnotation.anyOf();
    }

    @Override
    public boolean isValid(Enum<?> anEnum, ConstraintValidatorContext constraintValidatorContext) {
        return anEnum == null || Arrays.asList(statuses).contains(anEnum);
    }
}

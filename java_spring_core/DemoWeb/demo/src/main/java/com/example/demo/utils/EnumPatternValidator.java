package com.example.demo.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class EnumPatternValidator implements ConstraintValidator<EnumPattern, Enum<?>> {

    private Pattern pattern;
    @Override
    public void initialize(EnumPattern constraintAnnotation) {
        try {
            pattern = Pattern.compile(constraintAnnotation.regexp());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Invalid", e);
        }
    }

    @Override
    public boolean isValid(Enum<?> anEnum, ConstraintValidatorContext constraintValidatorContext) {

        if (anEnum == null) {
            return false;
        }

        Matcher m = pattern.matcher(anEnum.name());

        return m.matches();
    }
}

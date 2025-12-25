package com.oriole.wisepen.user.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CampusNoValidator implements ConstraintValidator<CampusNo, String> {

    private static final Pattern CAMPUS_NO_PATTERN = Pattern.compile("^\\d{11}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // 为空时由@NotBlank等注解处理
        }
        return CAMPUS_NO_PATTERN.matcher(value).matches();
    }
}
package com.oriole.wisepen.user.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private static final Pattern PASSWORD_LETTER_PATTERN = Pattern.compile(".*[a-zA-Z].*");
    private static final Pattern PASSWORD_NUMBER_PATTERN = Pattern.compile(".*\\d.*");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // 为空时由@NotBlank等注解处理
        }
        return value.length() > 8 &&
               PASSWORD_LETTER_PATTERN.matcher(value).matches() &&
               PASSWORD_NUMBER_PATTERN.matcher(value).matches();
    }
}
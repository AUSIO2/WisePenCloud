package com.oriole.wisepen.user.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class UsernameValidator implements ConstraintValidator<Username, String> {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[a-zA-Z0-9_]{4,20}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // @NotBlank会处理null和空字符串，这里只处理格式验证
        if (value == null || value.trim().isEmpty()) {
            return true; // 让@NotBlank处理空值
        }
        return USERNAME_PATTERN.matcher(value).matches();
    }
}
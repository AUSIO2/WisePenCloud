package com.oriole.wisepen.user.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CampusNoValidator.class)
public @interface CampusNo {
    String message() default "学工号格式不正确";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
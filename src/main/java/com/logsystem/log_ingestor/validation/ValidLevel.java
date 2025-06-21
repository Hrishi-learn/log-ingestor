package com.logsystem.log_ingestor.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;



    @Documented
    @Constraint(validatedBy = LevelValidator.class)
    @Target({ ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ValidLevel {
        String message() default "Logging Level is incorrect'";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }

package com.logsystem.log_ingestor.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class  LevelValidator implements ConstraintValidator<ValidLevel, String> {

    private static Set<String>validLevels = Set.of("debug","info","warn","error","fatal");

    @Override
    public boolean isValid(String level, ConstraintValidatorContext constraintValidatorContext){
        return level!=null && validLevels.contains(level.toLowerCase());
    }
}

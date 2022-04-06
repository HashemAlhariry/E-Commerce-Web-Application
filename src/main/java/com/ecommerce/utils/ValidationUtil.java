package com.ecommerce.utils;

import jakarta.validation.*;

import java.util.Set;

public class ValidationUtil {

    private static final ValidationUtil INSTANCE = new ValidationUtil();
    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private ValidationUtil() {

    }

    public static ValidationUtil getInstance() {
        return INSTANCE;
    }

    public <T> void validate( T obj ) {
        Set<ConstraintViolation<T>> violations = validator.validate( obj );
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException( violations );
        }
    }
}
package com.mobiquity.exception;

import org.apache.commons.lang3.StringUtils;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class clazz, String searchParams) {
        super(EntityNotFoundException.generateMessage(clazz.getSimpleName(), searchParams));
    }

    private static String generateMessage(String entity, String searchParams) {
        return String.format("%s details was not found for parameter : %s", StringUtils.capitalize(entity), searchParams);
    }
}

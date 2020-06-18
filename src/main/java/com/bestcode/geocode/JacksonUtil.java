package com.bestcode.geocode;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
    private static ObjectMapper objectMapper = null;
    private JacksonUtil() {}

    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            synchronized (JacksonUtil.class) {
                if (objectMapper == null) {
                    objectMapper = new ObjectMapper();
                }
            }
        }
        return objectMapper;
    }
}

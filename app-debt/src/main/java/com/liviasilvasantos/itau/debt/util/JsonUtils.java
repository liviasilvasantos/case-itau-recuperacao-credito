package com.liviasilvasantos.itau.debt.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liviasilvasantos.itau.debt.util.exception.JsonUtilsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JsonUtils {

    private final ObjectMapper objectMapper;

    public String toJson(final Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (final JsonProcessingException exception) {
            throw new JsonUtilsException("Error converting object: " + object, exception);
        }
    }

    public <T> T toObject(final String json, final Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (final JsonProcessingException exception) {
            throw new JsonUtilsException("Error converting json: " + json + " to class " + clazz.getNestHost(), exception);
        }
    }
}

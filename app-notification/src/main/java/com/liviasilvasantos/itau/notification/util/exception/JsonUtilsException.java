package com.liviasilvasantos.itau.notification.util.exception;

public class JsonUtilsException extends RuntimeException {


    public JsonUtilsException(final String message, final Exception exception) {
        super(message, exception);
    }
}

package com.liviasilvasantos.itau.debt.util.exception;

public class JsonUtilsException extends RuntimeException {


    public JsonUtilsException(final String message, final Exception exception) {
        super(message, exception);
    }
}

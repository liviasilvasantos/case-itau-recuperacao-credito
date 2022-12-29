package com.liviasilvasantos.itau.catalog.gateway.exception;

public class CatalogNotFoundException extends RuntimeException {
    public CatalogNotFoundException(final String message) {
        super(message);
    }
}

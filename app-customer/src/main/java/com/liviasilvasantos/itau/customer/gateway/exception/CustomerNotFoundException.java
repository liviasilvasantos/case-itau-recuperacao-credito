package com.liviasilvasantos.itau.customer.gateway.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(final String message) {
        super(message);
    }
}

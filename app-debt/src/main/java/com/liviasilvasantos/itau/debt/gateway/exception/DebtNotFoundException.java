package com.liviasilvasantos.itau.debt.gateway.exception;

public class DebtNotFoundException extends RuntimeException {
    public DebtNotFoundException(final String message) {
        super(message);
    }
}

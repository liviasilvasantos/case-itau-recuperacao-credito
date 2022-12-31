package com.liviasilvasantos.itau.payment.gateway.exception;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(final String message) {
        super(message);
    }
}

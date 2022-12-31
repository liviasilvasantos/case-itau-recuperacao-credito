package com.liviasilvasantos.itau.payment.usecase.strategy;

import com.liviasilvasantos.itau.payment.domain.PaymentContext;

public interface CreatePaymentStrategy {

    boolean canExecute(PaymentContext context);

    void execute(PaymentContext context);
}

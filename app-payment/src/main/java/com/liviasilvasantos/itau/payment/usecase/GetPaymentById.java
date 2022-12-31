package com.liviasilvasantos.itau.payment.usecase;

import com.liviasilvasantos.itau.payment.domain.Payment;
import com.liviasilvasantos.itau.payment.gateway.PaymentGateway;
import com.liviasilvasantos.itau.payment.gateway.exception.PaymentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPaymentById {

    private final PaymentGateway paymentGateway;

    public Payment execute(final String id) throws PaymentNotFoundException {
        return paymentGateway.findById(id)
                .orElseThrow(() -> new PaymentNotFoundException("no payment found for id " + id));
    }
}

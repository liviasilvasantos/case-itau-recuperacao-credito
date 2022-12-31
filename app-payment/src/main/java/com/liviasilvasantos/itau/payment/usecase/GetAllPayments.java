package com.liviasilvasantos.itau.payment.usecase;

import com.liviasilvasantos.itau.payment.domain.Payment;
import com.liviasilvasantos.itau.payment.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllPayments {

    private final PaymentGateway paymentGateway;

    public List<Payment> execute(final Pageable pageable) {
        return paymentGateway.findAll(pageable).getContent();
    }
}

package com.liviasilvasantos.itau.payment.gateway.mongo;

import com.liviasilvasantos.itau.payment.domain.Payment;
import com.liviasilvasantos.itau.payment.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentGatewayImpl implements PaymentGateway {

    private final PaymentRepository paymentRepository;

    @Override
    public Page<Payment> findAll(final Pageable pageable) {
        return paymentRepository.findAll(pageable);
    }

    @Override
    public Optional<Payment> findById(final String id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Payment save(final Payment catalog) {
        return paymentRepository.save(catalog);
    }

    @Override
    public void remove(final Payment catalog) {
        paymentRepository.delete(catalog);
    }
}

package com.liviasilvasantos.itau.payment.gateway;

import com.liviasilvasantos.itau.payment.domain.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PaymentGateway {

    Page<Payment> findAll(Pageable pageable);

    Optional<Payment> findById(String id);

    Payment save(Payment payment);

    void remove(Payment payment);
}

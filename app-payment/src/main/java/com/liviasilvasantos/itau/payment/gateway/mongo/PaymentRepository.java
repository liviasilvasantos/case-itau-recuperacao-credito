package com.liviasilvasantos.itau.payment.gateway.mongo;

import com.liviasilvasantos.itau.payment.domain.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}

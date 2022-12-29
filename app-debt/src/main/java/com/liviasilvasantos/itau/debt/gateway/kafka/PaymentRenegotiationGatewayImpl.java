package com.liviasilvasantos.itau.debt.gateway.kafka;

import com.liviasilvasantos.itau.debt.domain.Debt;
import com.liviasilvasantos.itau.debt.gateway.PaymentRenegotiationGateway;
import com.liviasilvasantos.itau.debt.gateway.kafka.request.CreatePaymentRenegotiationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentRenegotiationGatewayImpl implements PaymentRenegotiationGateway {

    private final PaymentKafkaProducer paymentKafkaProducer;
    @Value("${spring.kafka.topics.payment-renegotiation-request}")
    private String topicRequestPaymentRenegotiation;

    @Override
    public void requestPaymentRenegotiation(Debt debt) {
        paymentKafkaProducer.send(topicRequestPaymentRenegotiation,
                debt.getCustomerId(),
                CreatePaymentRenegotiationRequest.of(debt));
    }
}

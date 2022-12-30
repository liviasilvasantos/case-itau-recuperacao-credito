package com.liviasilvasantos.itau.debt.gateway.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liviasilvasantos.itau.debt.domain.Debt;
import com.liviasilvasantos.itau.debt.gateway.PaymentRenegotiationGateway;
import com.liviasilvasantos.itau.debt.gateway.kafka.request.CreatePaymentRenegotiationRequest;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentRenegotiationGatewayImpl implements PaymentRenegotiationGateway {

    private final KafkaProducer kafkaProducer;
    private final ObjectMapper objectMapper;

    @Value("${spring.kafka.topics.payment-renegotiation-request}")
    private String topicRequestPaymentRenegotiation;

    @Override
    public void requestPaymentRenegotiation(Debt debt) {
        val message = buildMessage(debt);
        kafkaProducer.send(topicRequestPaymentRenegotiation,
                debt.getCustomerId(),
                message);
    }

    private String buildMessage(Debt debt) {
        try {
            return objectMapper.writeValueAsString(CreatePaymentRenegotiationRequest.of(debt));
        } catch (final JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }
}

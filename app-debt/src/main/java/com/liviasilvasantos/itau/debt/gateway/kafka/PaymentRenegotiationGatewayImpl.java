package com.liviasilvasantos.itau.debt.gateway.kafka;

import com.liviasilvasantos.itau.debt.domain.Debt;
import com.liviasilvasantos.itau.debt.gateway.PaymentRenegotiationGateway;
import com.liviasilvasantos.itau.debt.gateway.kafka.request.CreatePaymentRenegotiationRequest;
import com.liviasilvasantos.itau.debt.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentRenegotiationGatewayImpl implements PaymentRenegotiationGateway {

    private final KafkaProducer kafkaProducer;
    private final JsonUtils jsonUtils;

    @Value("${spring.kafka.topics.payment-renegotiation-request}")
    private String topicRequestPaymentRenegotiation;

    @Override
    public void requestPaymentRenegotiation(Debt debt) {
        val message = buildMessage(debt);
        kafkaProducer.send(topicRequestPaymentRenegotiation,
                debt.getCustomerId(),
                message);
    }

    private String buildMessage(final Debt debt) {
        return jsonUtils.toJson(CreatePaymentRenegotiationRequest.of(debt));
    }
}

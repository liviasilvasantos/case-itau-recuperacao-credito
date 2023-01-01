package com.liviasilvasantos.itau.payment.gateway.kafka;

import com.liviasilvasantos.itau.payment.domain.renegotiation.PaymentRenegotiation;
import com.liviasilvasantos.itau.payment.gateway.kafka.request.CreatePaymentRenegotiationRequest;
import com.liviasilvasantos.itau.payment.usecase.CreatePaymentRenegotiation;
import com.liviasilvasantos.itau.payment.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreatePaymentRenegotiationListener {

    private final JsonUtils jsonUtils;
    private final CreatePaymentRenegotiation createPaymentRenegotiation;

    @KafkaListener(topics = "${spring.kafka.topics.payment-renegotiation-request}",
        containerFactory = "kafkaContainerFactory")
    public void onMessage(
            @Header(value = KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
            @Header(KafkaHeaders.OFFSET) String offset,
            @Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY, required = false) String key,
            @Payload String message) {
        log.info("Message received on partition [{}], offset [{}] with key [{}]: [{}]",
                partition,
                offset,
                key,
                message);

        consumeMessage(message);
    }

    private void consumeMessage(final String message) {
        val createPaymentRenegotiationRequest = jsonUtils.toObject(message, CreatePaymentRenegotiationRequest.class);
        val paymentRenegotiation = jsonUtils.fromObject(createPaymentRenegotiationRequest, PaymentRenegotiation.class);

        createPaymentRenegotiation.execute(paymentRenegotiation);
    }
}

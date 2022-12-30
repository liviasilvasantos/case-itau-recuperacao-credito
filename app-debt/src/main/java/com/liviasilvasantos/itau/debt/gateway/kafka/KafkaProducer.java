package com.liviasilvasantos.itau.debt.gateway.kafka;

import com.liviasilvasantos.itau.debt.gateway.kafka.request.CreatePaymentRenegotiationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.SuccessCallback;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(final String topic,
                     final String key,
                     final String message) {
        log.info("sending message to topic {} with key {} - message {}", topic, key, message);
        kafkaTemplate.send(topic, key, message)
                .addCallback(handleSuccess(topic, key, message), handleFailure(topic, key, message));
    }

    private SuccessCallback<? super SendResult<String, String>> handleSuccess(final String topic, final String key, final String message) {
        return result -> log.info("message sent to topic {} with key {} - message {}", topic, key, message);
    }

    private FailureCallback handleFailure(final String topic, final String key, final String message) {
        return exception -> log.error("error sending message to topic {} with key {} - error {} message {}", topic, key, exception, message);
    }
}

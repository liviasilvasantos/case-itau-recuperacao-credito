package com.liviasilvasantos.itau.notification.gateway.kafka;

import com.liviasilvasantos.itau.notification.gateway.kafka.converter.NotificationRequestToDomainConverter;
import com.liviasilvasantos.itau.notification.gateway.kafka.request.NotificationRequest;
import com.liviasilvasantos.itau.notification.usecase.SendNotification;
import com.liviasilvasantos.itau.notification.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationListener {

    private final SendNotification sendNotification;
    private final NotificationRequestToDomainConverter toDomainConverter;
    private final JsonUtils jsonUtils;

    @KafkaListener(topics = "${spring.kafka.topics.notification-request}")
    public void onMessage(@Header(value = KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
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
        val notificationRequest = jsonUtils.toObject(message, NotificationRequest.class);
        val notification = toDomainConverter.convert(notificationRequest);
        sendNotification.execute(notification);
    }

}

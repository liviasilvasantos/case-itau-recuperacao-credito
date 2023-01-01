package com.liviasilvasantos.itau.payment.gateway.kafka;

import com.liviasilvasantos.itau.payment.domain.Payment;
import com.liviasilvasantos.itau.payment.gateway.NotificationGateway;
import com.liviasilvasantos.itau.payment.gateway.kafka.request.CreateNotificationRequest;
import com.liviasilvasantos.itau.payment.gateway.kafka.request.NotificationEvent;
import com.liviasilvasantos.itau.payment.gateway.kafka.request.NotificationType;
import com.liviasilvasantos.itau.payment.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationGatewayImpl implements NotificationGateway {

    private final KafkaProducer kafkaProducer;
    private final JsonUtils jsonUtils;
    @Value("${spring.kafka.topics.notification-request}")
    private String topicNotificationRequest;

    @Override
    public void requestNotification(final Payment payment,
                                    final NotificationType notificationType,
                                    final NotificationEvent notificationEvent) {
        kafkaProducer.send(topicNotificationRequest,
                payment.getCustomerId(),
                buildMessage(payment, notificationType, notificationEvent));
    }

    private String buildMessage(final Payment payment,
                                final NotificationType notificationType,
                                final NotificationEvent notificationEvent) {
        return jsonUtils.toJson(CreateNotificationRequest.of(payment, notificationType, notificationEvent));
    }
}

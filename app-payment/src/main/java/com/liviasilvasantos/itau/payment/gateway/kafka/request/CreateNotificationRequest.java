package com.liviasilvasantos.itau.payment.gateway.kafka.request;

import com.liviasilvasantos.itau.payment.domain.Payment;
import lombok.Builder;
import lombok.Data;
import lombok.val;

@Data
@Builder
public class CreateNotificationRequest {

    private String customerId;
    private String customerEmail;
    private NotificationType type;
    private NotificationEvent event;
    private String message;

    public static CreateNotificationRequest of(final Payment payment,
                                               final NotificationType notificationType,
                                               final NotificationEvent notificationEvent) {
        return CreateNotificationRequest.builder()
                .customerId(payment.getCustomerId())
                .type(notificationType)
                .event(notificationEvent)
                .message(buildMessage(payment, notificationType, notificationEvent))
                .build();
    }

    private static String buildMessage(final Payment payment,
                                       final NotificationType notificationType,
                                       final NotificationEvent notificationEvent) {
        val message = new StringBuilder();
        message.append("%s - Notificação de %s".formatted(notificationType, notificationEvent));
        return message.toString();
    }
}

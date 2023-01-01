package com.liviasilvasantos.itau.notification.gateway.kafka.request;

import com.liviasilvasantos.itau.notification.domain.NotificationEvent;
import com.liviasilvasantos.itau.notification.domain.NotificationType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationRequest {

    private String customerId;
    private String customerEmail;
    private NotificationType type;
    private NotificationEvent event;
    private String message;

}

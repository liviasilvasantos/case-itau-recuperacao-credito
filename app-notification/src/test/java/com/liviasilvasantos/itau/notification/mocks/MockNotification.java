package com.liviasilvasantos.itau.notification.mocks;

import com.liviasilvasantos.itau.notification.domain.Notification;
import com.liviasilvasantos.itau.notification.domain.NotificationEvent;
import com.liviasilvasantos.itau.notification.domain.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;

public class MockNotification {

    public static Notification VALID_PIX() {
        return Notification.builder()
                .customerId(UUID.randomUUID().toString())
                .event(NotificationEvent.PAYMENT_PIX)
                .type(NotificationType.EMAIL)
                .message("sending pix message")
                .sentAt(LocalDateTime.now())
                .build();
    }
}

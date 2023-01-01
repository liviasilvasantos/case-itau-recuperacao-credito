package com.liviasilvasantos.itau.notification.gateway.kafka.converter;

import com.liviasilvasantos.itau.notification.domain.Notification;
import com.liviasilvasantos.itau.notification.gateway.kafka.request.NotificationRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class NotificationRequestToDomainConverter implements Converter<NotificationRequest, Notification> {


    @Override
    public Notification convert(final NotificationRequest notificationRequest) {
        return Notification.builder()
                .customerId(notificationRequest.getCustomerId())
                .customerEmail(notificationRequest.getCustomerEmail())
                .event(notificationRequest.getEvent())
                .type(notificationRequest.getType())
                .message(notificationRequest.getMessage())
                .sentAt(LocalDateTime.now())
                .build();
    }
}

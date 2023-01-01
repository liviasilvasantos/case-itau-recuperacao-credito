package com.liviasilvasantos.itau.payment.gateway;

import com.liviasilvasantos.itau.payment.domain.Payment;
import com.liviasilvasantos.itau.payment.gateway.kafka.request.NotificationEvent;
import com.liviasilvasantos.itau.payment.gateway.kafka.request.NotificationType;

public interface NotificationGateway {

    void requestNotification(Payment payment, NotificationType notificationType, NotificationEvent notificationEvent);
}

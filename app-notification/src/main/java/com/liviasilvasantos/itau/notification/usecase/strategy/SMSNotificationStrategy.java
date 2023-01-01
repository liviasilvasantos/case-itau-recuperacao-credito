package com.liviasilvasantos.itau.notification.usecase.strategy;

import com.liviasilvasantos.itau.notification.domain.NotificationContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SMSNotificationStrategy implements NotificationStrategy {

    @Override
    public boolean canExecute(NotificationContext context) {
        return context.getNotification().isSMS();
    }

    @Override
    public void execute(NotificationContext context) {
        log.info("sending SMS to: {} for: {} with message: {}", context.getNotification().getCustomerEmail(),
                context.getNotification().getEvent(),
                context.getNotification().getMessage());
    }
}

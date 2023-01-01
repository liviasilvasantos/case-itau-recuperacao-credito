package com.liviasilvasantos.itau.notification.usecase.strategy;

import com.liviasilvasantos.itau.notification.domain.NotificationContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailNotificationStrategy implements NotificationStrategy {

    @Override
    public boolean canExecute(NotificationContext context) {
        return context.getNotification().isEmail();
    }

    @Override
    public void execute(NotificationContext context) {
        log.info("sending E-mail to: {} for:{} with message: {}", context.getCustomer().getEmail(),
                context.getNotification().getEvent(),
                context.getNotification().getMessage());
    }
}

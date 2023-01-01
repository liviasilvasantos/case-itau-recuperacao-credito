package com.liviasilvasantos.itau.notification.usecase.strategy;

import com.liviasilvasantos.itau.notification.domain.NotificationContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WhatsappNotificationStrategy implements NotificationStrategy {

    @Override
    public boolean canExecute(final NotificationContext context) {
        return context.getNotification().isWhatsApp();
    }

    @Override
    public void execute(final NotificationContext context) {
        log.info("sending Whatsapp to: {} for: {} with message: {}", context.getCustomer().getMobilePhone(),
                context.getNotification().getEvent(),
                context.getNotification().getMessage());
    }


}

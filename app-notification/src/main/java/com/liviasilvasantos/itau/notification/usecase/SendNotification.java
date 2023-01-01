package com.liviasilvasantos.itau.notification.usecase;

import com.liviasilvasantos.itau.notification.domain.Notification;
import com.liviasilvasantos.itau.notification.domain.NotificationContext;
import com.liviasilvasantos.itau.notification.usecase.strategy.NotificationStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SendNotification {

    private final List<NotificationStrategy> notificationStrategies;

    public void execute(final Notification notification) {
        val context = buildNotificationContext(notification);

        notificationStrategies.stream()
                .filter(notificationStrategy -> notificationStrategy.canExecute(context))
                .findFirst()
                .ifPresentOrElse(notificationStrategy -> notificationStrategy.execute(context),
                        () -> log.error("no strategy found for context: " + context));
    }

    private NotificationContext buildNotificationContext(final Notification notification) {
        return NotificationContext.builder().notification(notification).build();
    }
}

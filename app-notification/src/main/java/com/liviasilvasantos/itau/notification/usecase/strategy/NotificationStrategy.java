package com.liviasilvasantos.itau.notification.usecase.strategy;

import com.liviasilvasantos.itau.notification.domain.NotificationContext;

public interface NotificationStrategy {

    boolean canExecute(NotificationContext context);

    void execute(NotificationContext context);
}

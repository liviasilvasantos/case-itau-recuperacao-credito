package com.liviasilvasantos.itau.notification.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationContext {

    private Notification notification;

}

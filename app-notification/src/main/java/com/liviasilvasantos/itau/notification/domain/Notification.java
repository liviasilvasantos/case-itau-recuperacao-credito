package com.liviasilvasantos.itau.notification.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@With
@Getter
@Document(value = "notifications")
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    private String id;
    private String customerEmail;
    private String customerId;
    private NotificationType type;
    private NotificationEvent event;
    private LocalDateTime sentAt;
    private String message;

    public boolean isCac() {
        return getType() == NotificationType.CAC;
    }

    public boolean isWhatsApp() {
        return getType() == NotificationType.WHATSAPP;
    }

    public boolean isSMS() {
        return getType() == NotificationType.SMS;
    }

    public boolean isEmail() {
        return getType() == NotificationType.EMAIL;
    }
}

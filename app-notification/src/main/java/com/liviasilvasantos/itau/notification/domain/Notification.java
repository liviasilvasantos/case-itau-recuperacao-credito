package com.liviasilvasantos.itau.notification.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private NotificationType type;
}

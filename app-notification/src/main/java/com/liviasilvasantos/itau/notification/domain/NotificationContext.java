package com.liviasilvasantos.itau.notification.domain;

import com.liviasilvasantos.itau.notification.domain.customer.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationContext {

    private Notification notification;
    private Customer customer;
}

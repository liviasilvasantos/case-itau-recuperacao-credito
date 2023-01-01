package com.liviasilvasantos.itau.notification.gateway;

import com.liviasilvasantos.itau.notification.domain.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NotificationGateway {

    Page<Notification> findAll(Pageable pageable);

    Optional<Notification> findById(String id);

    Notification save(Notification customer);

    void remove(Notification customer);
}

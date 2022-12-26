package com.liviasilvasantos.itau.notification.gateway.mongo;

import com.liviasilvasantos.itau.notification.domain.Notification;
import com.liviasilvasantos.itau.notification.gateway.NotificationGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class NotificationGatewayImpl implements NotificationGateway {

    private final NotificationRepository notificationRepository;

    @Override
    public Page<Notification> findAll(final Pageable pageable) {
        return notificationRepository.findAll(pageable);
    }

    @Override
    public Optional<Notification> findById(final String id) {
        return notificationRepository.findById(id);
    }

    @Override
    public Page<Notification> findByCustomerEmail(final String customerEmail, final Pageable pageable) {
        return notificationRepository.findByCustomerEmail(customerEmail, pageable);
    }

    @Override
    public Notification save(final Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void remove(final Notification notification) {
        notificationRepository.delete(notification);
    }
}

package com.liviasilvasantos.itau.notification.gateway.mongo;

import com.liviasilvasantos.itau.notification.domain.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {

    Page<Notification> findByCustomerEmail(String customerEmail, Pageable pageable);
}

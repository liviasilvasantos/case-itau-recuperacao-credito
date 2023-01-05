package com.liviasilvasantos.itau.notification.mocks;

import com.liviasilvasantos.itau.notification.domain.customer.Customer;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class MockCustomer {

    public static Customer VALID() {
        return Customer.builder()
                .id(UUID.randomUUID().toString())
                .email("someone@email.com")
                .name("Some One Smith")
                .createdAt(LocalDateTime.now())
                .addresses(List.of(MockAddress.VALID()))
                .phones(List.of(MockPhone.VALID_MOBILE()))
                .build();
    }
}

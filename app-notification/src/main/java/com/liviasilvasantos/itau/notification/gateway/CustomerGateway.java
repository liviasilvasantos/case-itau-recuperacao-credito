package com.liviasilvasantos.itau.notification.gateway;

import com.liviasilvasantos.itau.notification.domain.customer.Customer;

public interface CustomerGateway {

    Customer findById(String id);
}

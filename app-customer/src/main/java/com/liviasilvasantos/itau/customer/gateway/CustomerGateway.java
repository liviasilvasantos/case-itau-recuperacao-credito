package com.liviasilvasantos.itau.customer.gateway;

import com.liviasilvasantos.itau.customer.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerGateway {

    List<Customer> findAll();
    Optional<Customer> findById(String id);
    Optional<Customer> findByEmail(String email);
    Customer save(Customer customer);
}

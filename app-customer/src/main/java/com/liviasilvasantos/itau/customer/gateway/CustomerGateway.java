package com.liviasilvasantos.itau.customer.gateway;

import com.liviasilvasantos.itau.customer.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerGateway {

    Page<Customer> findAll(Pageable pageable);
    Optional<Customer> findById(String id);
    Optional<Customer> findByEmail(String email);
    Customer save(Customer customer);
    void remove(Customer customer);
}

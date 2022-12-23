package com.liviasilvasantos.itau.customer.gateway.mongo;

import com.liviasilvasantos.itau.customer.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByEmail(String email);
}

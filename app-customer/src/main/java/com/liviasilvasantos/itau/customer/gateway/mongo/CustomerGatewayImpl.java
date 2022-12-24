package com.liviasilvasantos.itau.customer.gateway.mongo;

import com.liviasilvasantos.itau.customer.domain.Customer;
import com.liviasilvasantos.itau.customer.gateway.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomerGatewayImpl implements CustomerGateway {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(final String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> findByEmail(final String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer save(final Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(final Customer customer) {
        customerRepository.delete(customer);
    }
}

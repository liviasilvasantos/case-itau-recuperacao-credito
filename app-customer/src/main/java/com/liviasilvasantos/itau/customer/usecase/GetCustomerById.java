package com.liviasilvasantos.itau.customer.usecase;

import com.liviasilvasantos.itau.customer.domain.Customer;
import com.liviasilvasantos.itau.customer.gateway.CustomerGateway;
import com.liviasilvasantos.itau.customer.gateway.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCustomerById {

    private final CustomerGateway customerGateway;

    public Customer execute(final String id) throws CustomerNotFoundException {
        return customerGateway.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("no customer found for id " + id));
    }
}

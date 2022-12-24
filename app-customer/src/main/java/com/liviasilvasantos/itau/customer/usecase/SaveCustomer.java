package com.liviasilvasantos.itau.customer.usecase;

import com.liviasilvasantos.itau.customer.domain.Customer;
import com.liviasilvasantos.itau.customer.gateway.CustomerGateway;
import com.liviasilvasantos.itau.customer.gateway.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCustomer {

    private final CustomerGateway customerGateway;

    public Customer execute(final Customer customer){
        return customerGateway.save(customer);
    }
}

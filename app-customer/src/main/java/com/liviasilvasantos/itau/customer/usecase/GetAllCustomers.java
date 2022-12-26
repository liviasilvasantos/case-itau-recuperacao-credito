package com.liviasilvasantos.itau.customer.usecase;

import com.liviasilvasantos.itau.customer.domain.Customer;
import com.liviasilvasantos.itau.customer.gateway.CustomerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllCustomers {

    private final CustomerGateway customerGateway;

    public List<Customer> execute(final Pageable pageable) {
        return customerGateway.findAll(pageable).getContent();
    }
}

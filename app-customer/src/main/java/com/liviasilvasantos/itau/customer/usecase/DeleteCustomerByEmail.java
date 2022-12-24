package com.liviasilvasantos.itau.customer.usecase;

import com.liviasilvasantos.itau.customer.gateway.CustomerGateway;
import com.liviasilvasantos.itau.customer.gateway.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCustomerByEmail {

    private final CustomerGateway customerGateway;

    public void execute(final String email) throws CustomerNotFoundException {
        val customer = customerGateway.findByEmail(email)
                .orElseThrow(() -> new CustomerNotFoundException("no customer found for email %s".formatted(email)));
        customerGateway.remove(customer);
    }
}

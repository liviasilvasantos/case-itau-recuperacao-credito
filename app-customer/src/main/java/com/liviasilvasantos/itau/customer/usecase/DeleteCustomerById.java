package com.liviasilvasantos.itau.customer.usecase;

import com.liviasilvasantos.itau.customer.gateway.CustomerGateway;
import com.liviasilvasantos.itau.customer.gateway.exception.CustomerNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCustomerById {

    private final GetCustomerById getCustomerById;
    private final CustomerGateway customerGateway;

    public void execute(final String id) throws CustomerNotFoundException {
        val customer = getCustomerById.execute(id);
        customerGateway.remove(customer);
    }
}

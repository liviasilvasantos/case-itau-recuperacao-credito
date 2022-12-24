package com.liviasilvasantos.itau.customer.gateway.http.converter;

import com.liviasilvasantos.itau.customer.domain.Customer;
import com.liviasilvasantos.itau.customer.gateway.http.json.CustomerJson;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerDomainConverter implements Converter<CustomerJson, Customer> {

    @Override
    public Customer convert(final CustomerJson customerJson) {
        return Customer.builder()
                .name(customerJson.getName())
                .email(customerJson.getEmail())
                .build();
    }
}

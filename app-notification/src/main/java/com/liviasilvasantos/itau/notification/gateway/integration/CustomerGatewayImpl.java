package com.liviasilvasantos.itau.notification.gateway.integration;

import com.liviasilvasantos.itau.notification.domain.customer.Customer;
import com.liviasilvasantos.itau.notification.gateway.CustomerGateway;
import com.liviasilvasantos.itau.notification.gateway.feign.CustomerClient;
import com.liviasilvasantos.itau.notification.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CustomerGatewayImpl implements CustomerGateway {

    private final CustomerClient customerClient;
    private final JsonUtils jsonUtils;

    @Override
    public Customer findById(final String id) {
        log.info("finding customer with id:{}", id);
        val customerResponseJson = customerClient.findById(id);
        return jsonUtils.fromObject(customerResponseJson, Customer.class);
    }
}

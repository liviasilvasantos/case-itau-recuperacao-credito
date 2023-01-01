package com.liviasilvasantos.itau.notification.gateway.feign;

import com.liviasilvasantos.itau.notification.gateway.feign.json.CustomerResponseJson;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.val;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

@FeignClient(name = "customerClient", url = "http://localhost:8081")
public interface CustomerClient {

    @CircuitBreaker(name = "customerClient", fallbackMethod = "fallbackFindById")
    @GetMapping(value = "/customers/{id}")
    CustomerResponseJson findById(@PathVariable("id") final String id);

    default CustomerResponseJson fallbackFindById(final String id, final Exception exception) {
        val logger = LoggerFactory.getLogger(CustomerClient.class);
        logger.error("integration error - customer api", exception);
        return CustomerResponseJson.builder()
                .id(id)
                .createdAt(LocalDateTime.now())
                .failed(true)
                .build();
    }
}

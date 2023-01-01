package com.liviasilvasantos.itau.payment.gateway.feign;

import com.liviasilvasantos.itau.payment.gateway.feign.json.CatalogResponseJson;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.val;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

@FeignClient(name = "catalogClient", url = "http://localhost:8083")
public interface CatalogClient {

    @CircuitBreaker(name = "catalogClient", fallbackMethod = "fallbackFindById")
    @GetMapping(value = "/catalogs/{id}")
    CatalogResponseJson findById(@PathVariable("id") final String id);

    default CatalogResponseJson fallbackFindById(final String id, final Exception exception) {
        val logger = LoggerFactory.getLogger(CatalogClient.class);
        logger.error("integration error - catalog api");
        return CatalogResponseJson.builder()
                .id(id)
                .createdAt(LocalDateTime.now())
                .failed(true)
                .build();
    }
}

package com.liviasilvasantos.itau.payment.gateway.integration;

import com.liviasilvasantos.itau.payment.domain.catalog.Catalog;
import com.liviasilvasantos.itau.payment.gateway.CatalogGateway;
import com.liviasilvasantos.itau.payment.gateway.feign.CatalogClient;
import com.liviasilvasantos.itau.payment.util.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class CatalogGatewayImpl implements CatalogGateway {

    private final CatalogClient catalogClient;
    private final JsonUtils jsonUtils;

    @Override
    public Catalog findById(final String id) {
        log.info("finding catalog with id:{}", id);
        val catalogResponseJson = catalogClient.findById(id);
        return jsonUtils.fromObject(catalogResponseJson, Catalog.class);
    }
}

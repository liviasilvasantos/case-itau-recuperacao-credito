package com.liviasilvasantos.itau.payment.gateway;

import com.liviasilvasantos.itau.payment.domain.catalog.Catalog;

public interface CatalogGateway {

    Catalog findById(String id);
}

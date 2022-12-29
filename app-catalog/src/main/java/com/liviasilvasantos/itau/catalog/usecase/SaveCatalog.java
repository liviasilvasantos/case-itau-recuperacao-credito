package com.liviasilvasantos.itau.catalog.usecase;

import com.liviasilvasantos.itau.catalog.domain.Catalog;
import com.liviasilvasantos.itau.catalog.gateway.CatalogGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCatalog {

    private final CatalogGateway catalogGateway;

    public Catalog execute(final Catalog customer) {
        return catalogGateway.save(customer);
    }
}

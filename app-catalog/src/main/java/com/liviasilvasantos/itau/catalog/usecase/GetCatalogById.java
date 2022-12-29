package com.liviasilvasantos.itau.catalog.usecase;

import com.liviasilvasantos.itau.catalog.domain.Catalog;
import com.liviasilvasantos.itau.catalog.gateway.CatalogGateway;
import com.liviasilvasantos.itau.catalog.gateway.exception.CatalogNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCatalogById {

    private final CatalogGateway catalogGateway;

    public Catalog execute(final String id) throws CatalogNotFoundException {
        return catalogGateway.findById(id)
                .orElseThrow(() -> new CatalogNotFoundException("no catalog found for id " + id));
    }
}

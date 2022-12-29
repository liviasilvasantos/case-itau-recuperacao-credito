package com.liviasilvasantos.itau.catalog.usecase;

import com.liviasilvasantos.itau.catalog.gateway.CatalogGateway;
import com.liviasilvasantos.itau.catalog.gateway.exception.CatalogNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCatalogById {

    private final GetCatalogById getCustomerById;
    private final CatalogGateway catalogGateway;

    public void execute(final String id) throws CatalogNotFoundException {
        val catalog = getCustomerById.execute(id);
        catalogGateway.remove(catalog);
    }
}

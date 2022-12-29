package com.liviasilvasantos.itau.catalog.usecase;

import com.liviasilvasantos.itau.catalog.domain.Catalog;
import com.liviasilvasantos.itau.catalog.gateway.CatalogGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllCatalogs {

    private final CatalogGateway catalogGateway;

    public List<Catalog> execute(final Pageable pageable) {
        return catalogGateway.findAll(pageable).getContent();
    }
}

package com.liviasilvasantos.itau.catalog.gateway.mongo;

import com.liviasilvasantos.itau.catalog.domain.Catalog;
import com.liviasilvasantos.itau.catalog.gateway.CatalogGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CatalogGatewayImpl implements CatalogGateway {

    private final CatalogRepository catalogRepository;

    @Override
    public Page<Catalog> findAll(final Pageable pageable) {
        return catalogRepository.findAll(pageable);
    }

    @Override
    public Optional<Catalog> findById(final String id) {
        return catalogRepository.findById(id);
    }

    @Override
    public Catalog save(final Catalog catalog) {
        return catalogRepository.save(catalog);
    }

    @Override
    public void remove(final Catalog catalog) {
        catalogRepository.delete(catalog);
    }
}

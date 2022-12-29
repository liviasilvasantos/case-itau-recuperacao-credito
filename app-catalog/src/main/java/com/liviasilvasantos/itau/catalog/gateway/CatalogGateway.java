package com.liviasilvasantos.itau.catalog.gateway;

import com.liviasilvasantos.itau.catalog.domain.Catalog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CatalogGateway {

    Page<Catalog> findAll(Pageable pageable);

    Optional<Catalog> findById(String id);

    Catalog save(Catalog catalog);

    void remove(Catalog catalog);
}

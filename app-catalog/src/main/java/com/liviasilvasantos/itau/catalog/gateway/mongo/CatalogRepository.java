package com.liviasilvasantos.itau.catalog.gateway.mongo;

import com.liviasilvasantos.itau.catalog.domain.Catalog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CatalogRepository extends MongoRepository<Catalog, String> {
}

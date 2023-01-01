package com.liviasilvasantos.itau.catalog.gateway.http;

import com.liviasilvasantos.itau.catalog.domain.Catalog;
import com.liviasilvasantos.itau.catalog.gateway.http.converter.CatalogDomainConverter;
import com.liviasilvasantos.itau.catalog.gateway.http.json.CatalogJson;
import com.liviasilvasantos.itau.catalog.gateway.http.json.CatalogResponseJson;
import com.liviasilvasantos.itau.catalog.usecase.DeleteCatalogById;
import com.liviasilvasantos.itau.catalog.usecase.GetAllCatalogs;
import com.liviasilvasantos.itau.catalog.usecase.GetCatalogById;
import com.liviasilvasantos.itau.catalog.usecase.SaveCatalog;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogs")
@RequiredArgsConstructor
@Slf4j
public class CatalogController {

    private final GetAllCatalogs getAllCatalogs;
    private final GetCatalogById getCatalogById;
    private final SaveCatalog saveCatalog;
    private final DeleteCatalogById deleteCatalogById;

    private final CatalogDomainConverter catalogDomainConverter;

    @Operation(summary = "Gets a catalog by its id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CatalogResponseJson> findById(@Parameter(description = "id of a catalog to be searched") @PathVariable("id") final String id) {
        val catalog = getCatalogById.execute(id);
        return ResponseEntity.ok(CatalogResponseJson.of(catalog));
    }

    @Operation(summary = "Gets all catalogs")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CatalogResponseJson>> findAll(@Parameter(description = "number of the page") @RequestParam(value = "page", defaultValue = "0") final int page,
                                                             @Parameter(description = "size of the page") @RequestParam(value = "size", defaultValue = "5") final int size) {
        val catalogs = getAllCatalogs.execute(PageRequest.of(page, size));
        val catalogsJson = catalogs.stream()
                .map(catalog -> CatalogResponseJson.of(catalog))
                .collect(Collectors.toList());
        return ResponseEntity.ok(catalogsJson);
    }

    @Operation(summary = "Creates a pending catalog")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CatalogResponseJson> save(@RequestBody @Valid final CatalogJson catalogJson) {
        val catalog = saveCatalog.execute(catalogDomainConverter.convert(catalogJson));
        return ResponseEntity.created(buildCustomerUri(catalog)).body(CatalogResponseJson.of(catalog));
    }

    @Operation(summary = "Deletes a catalog by its id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable(value = "id") final String id) {
        deleteCatalogById.execute(id);
        return ResponseEntity.noContent().build();
    }

    //TODO implement update status (activate/deactivate) via PATCH

    private static URI buildCustomerUri(final Catalog catalog) {
        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(catalog.getId())
                .toUri();
        return uri;
    }
}

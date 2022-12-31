package com.liviasilvasantos.itau.payment.gateway.http.converter;

import com.liviasilvasantos.itau.catalog.domain.Catalog;
import com.liviasilvasantos.itau.catalog.domain.Status;
import com.liviasilvasantos.itau.catalog.gateway.http.json.CatalogJson;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CatalogDomainConverter implements Converter<CatalogJson, Catalog> {

    @Override
    public Catalog convert(final CatalogJson catalogJson) {
        return Catalog.builder()
                .code(catalogJson.getCode())
                .description(catalogJson.getDescription())
                .deadline(catalogJson.getDeadline())
                .paymentType(catalogJson.getPaymentType())
                .discount(catalogJson.getDiscount())
                .createdAt(LocalDateTime.now())
                .status(Status.PENDING)
                .build();
    }

}

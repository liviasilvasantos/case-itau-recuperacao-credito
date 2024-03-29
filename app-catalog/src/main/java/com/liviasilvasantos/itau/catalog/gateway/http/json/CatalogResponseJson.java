package com.liviasilvasantos.itau.catalog.gateway.http.json;

import com.liviasilvasantos.itau.catalog.domain.Catalog;
import com.liviasilvasantos.itau.catalog.domain.PaymentType;
import com.liviasilvasantos.itau.catalog.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogResponseJson {

    private String id;
    private String code;
    private String description;
    private Integer expirationInMinutes;
    private PaymentType paymentType;
    private double discount;
    private LocalDateTime createdAt;
    private Integer numberOfInstallments;
    private Status status;

    public static CatalogResponseJson of(final Catalog catalog) {
        return CatalogResponseJson.builder()
                .id(catalog.getId())
                .code(catalog.getCode())
                .description(catalog.getDescription())
                .expirationInMinutes(catalog.getExpirationInMinutes())
                .paymentType(catalog.getPaymentType())
                .discount(catalog.getDiscount())
                .createdAt(catalog.getCreatedAt())
                .status(catalog.getStatus())
                .numberOfInstallments(catalog.getNumberOfInstallments())
                .build();
    }
}

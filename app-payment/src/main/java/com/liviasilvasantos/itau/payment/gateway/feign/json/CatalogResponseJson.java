package com.liviasilvasantos.itau.payment.gateway.feign.json;

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
    private String paymentType;
    private double discount;
    private LocalDateTime createdAt;
    private String status;
    private boolean failed;
}

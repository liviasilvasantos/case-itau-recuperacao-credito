package com.liviasilvasantos.itau.payment.domain.catalog;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class Catalog {

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

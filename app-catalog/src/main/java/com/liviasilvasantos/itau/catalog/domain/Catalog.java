package com.liviasilvasantos.itau.catalog.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@With
@Getter
@Document(value = "catalogs")
@NoArgsConstructor
@AllArgsConstructor
public class Catalog {

    @Id
    private String id;
    private String code;
    private String description;
    private Integer expirationInMinutes;
    private PaymentType paymentType;
    private double discount;
    private LocalDateTime createdAt;
    private Integer numberOfInstallments;
    private Status status;

}

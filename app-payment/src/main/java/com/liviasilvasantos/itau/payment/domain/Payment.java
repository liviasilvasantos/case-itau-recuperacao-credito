package com.liviasilvasantos.itau.payment.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@With
@Getter
@Document(value = "payments")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    private String id;
    private String customerId;
    private String debtId;
    private String catalogId;
    private PaymentType type;
    private Long totalValueInCents;
    private Integer numberOfInstallments;
    private Long totalDiscountInCents;
    private Double discountValue;
    private LocalDate expiresAt;
    private LocalDateTime createdAt;
    private Set<Installment> installments;
}

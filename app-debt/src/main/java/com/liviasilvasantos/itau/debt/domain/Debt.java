package com.liviasilvasantos.itau.debt.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@With
@Getter
@Document(value = "debts")
@NoArgsConstructor
@AllArgsConstructor
public class Debt {

    @Id
    private String id;
    private String customerId;
    private Long totalInCents;
    private LocalDateTime createdAt;
    private Status status;
    private Renegotiation renegotiation;
}

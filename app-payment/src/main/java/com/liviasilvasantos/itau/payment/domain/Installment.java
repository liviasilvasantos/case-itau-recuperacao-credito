package com.liviasilvasantos.itau.payment.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Installment {

    private Integer sequence;
    private Long valueInCents;
    private Long paidValueInCents;
    private LocalDate expiresAt;

}

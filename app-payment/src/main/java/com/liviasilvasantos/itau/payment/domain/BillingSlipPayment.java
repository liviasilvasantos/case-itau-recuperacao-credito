package com.liviasilvasantos.itau.payment.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BillingSlipPayment {

    private String barCode;
    private String number;
    private String bankCode;
    private String issuer;
    private LocalDate expiresAt;

}

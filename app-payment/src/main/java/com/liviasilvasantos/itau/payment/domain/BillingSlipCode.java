package com.liviasilvasantos.itau.payment.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BillingSlipCode {

    private String barCode;
    private String number;
    private String bankCode;
    private String issuer;
    private LocalDateTime expiresAt;

}

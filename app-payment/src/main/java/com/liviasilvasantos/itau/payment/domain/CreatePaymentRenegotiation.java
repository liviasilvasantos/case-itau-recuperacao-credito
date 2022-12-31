package com.liviasilvasantos.itau.payment.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePaymentRenegotiation {

    private String catalogId;
    private String customerId;
    private String debtId;

}

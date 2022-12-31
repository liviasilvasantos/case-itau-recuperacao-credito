package com.liviasilvasantos.itau.payment.domain.renegotiation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRenegotiation {

    private String catalogId;
    private String customerId;
    private String debtId;
    private Long totalRenegotiationValueInCents;

}

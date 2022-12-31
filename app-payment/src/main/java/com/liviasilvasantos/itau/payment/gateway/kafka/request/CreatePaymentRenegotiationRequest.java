package com.liviasilvasantos.itau.payment.gateway.kafka.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePaymentRenegotiationRequest {

    private String catalogId;
    private String customerId;
    private String debtId;

}

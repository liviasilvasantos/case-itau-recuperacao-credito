package com.liviasilvasantos.itau.debt.gateway.kafka.request;

import com.liviasilvasantos.itau.debt.domain.Debt;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePaymentRenegotiationRequest {

    private String catalogId;
    private String customerId;
    private String debtId;
    private Long totalRenegotiationInCents;

    public static CreatePaymentRenegotiationRequest of(final Debt debt) {
        return CreatePaymentRenegotiationRequest.builder()
                .catalogId(debt.getRenegotiation().getCatalogId())
                .customerId(debt.getCustomerId())
                .debtId(debt.getId())
                .totalRenegotiationInCents(debt.getRenegotiation().getTotalRenegotiationInCents())
                .build();
    }
}

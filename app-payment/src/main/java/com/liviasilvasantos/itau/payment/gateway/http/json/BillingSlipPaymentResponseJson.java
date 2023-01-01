package com.liviasilvasantos.itau.payment.gateway.http.json;

import com.liviasilvasantos.itau.payment.domain.BillingSlipPayment;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BillingSlipPaymentResponseJson {

    private String barCode;
    private String number;
    private String bankCode;
    private String issuer;
    private LocalDate expiresAt;

    public static BillingSlipPaymentResponseJson of(final BillingSlipPayment billingSlip) {
        return BillingSlipPaymentResponseJson.builder()
                .bankCode(billingSlip.getBankCode())
                .barCode(billingSlip.getBarCode())
                .number(billingSlip.getNumber())
                .issuer(billingSlip.getIssuer())
                .expiresAt(billingSlip.getExpiresAt())
                .build();
    }
}

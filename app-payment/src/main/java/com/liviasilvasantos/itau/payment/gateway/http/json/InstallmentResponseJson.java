package com.liviasilvasantos.itau.payment.gateway.http.json;

import com.liviasilvasantos.itau.payment.domain.Installment;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class InstallmentResponseJson {

    private Integer sequence;
    private Long valueInCents;
    private Long paidValueInCents;
    private LocalDate expiresAt;

    public static InstallmentResponseJson of(final Installment installment) {
        return InstallmentResponseJson.builder()
                .sequence(installment.getSequence())
                .valueInCents(installment.getValueInCents())
                .paidValueInCents(installment.getPaidValueInCents())
                .expiresAt(installment.getExpiresAt())
                .build();
    }
}

package com.liviasilvasantos.itau.debt.gateway.http.json;

import com.liviasilvasantos.itau.debt.domain.Debt;
import com.liviasilvasantos.itau.debt.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DebtResponseJson {

    private String id;
    private String customerId;
    private Long totalInCents;
    private LocalDateTime createdAt;
    private Status status;
    private RenegotiationResponseJson renegotiation;

    public static DebtResponseJson of(final Debt debt) {
        return DebtResponseJson.builder()
                .id(debt.getId())
                .customerId(debt.getCustomerId())
                .totalInCents(debt.getTotalInCents())
                .createdAt(debt.getCreatedAt())
                .status(debt.getStatus())
                .renegotiation(buildRenegotiation(debt))
                .build();
    }

    private static RenegotiationResponseJson buildRenegotiation(Debt debt) {
        return Optional.ofNullable(debt.getRenegotiation())
                .map(renegotiation -> RenegotiationResponseJson.of(renegotiation))
                .orElse(null);
    }
}

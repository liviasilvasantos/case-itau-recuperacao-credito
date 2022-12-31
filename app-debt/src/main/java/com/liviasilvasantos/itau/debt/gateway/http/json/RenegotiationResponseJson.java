package com.liviasilvasantos.itau.debt.gateway.http.json;

import com.liviasilvasantos.itau.debt.domain.Renegotiation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RenegotiationResponseJson {

    private String catalogId;
    private LocalDateTime createdAt;
    private Long totalRenegotiationValueInCents;

    public static RenegotiationResponseJson of(final Renegotiation renegotiation) {
        return RenegotiationResponseJson.builder()
                .catalogId(renegotiation.getCatalogId())
                .createdAt(renegotiation.getCreatedAt())
                .totalRenegotiationValueInCents(renegotiation.getTotalRenegotiationValueInCents())
                .build();
    }
}

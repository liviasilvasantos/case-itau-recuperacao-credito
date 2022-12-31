package com.liviasilvasantos.itau.payment.gateway.http.json;

import com.liviasilvasantos.itau.payment.domain.Payment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseJson {

    private String id;
    private LocalDateTime createdAt;

    public static PaymentResponseJson of(final Payment payment) {
        return PaymentResponseJson.builder()
                .id(payment.getId())
                .createdAt(payment.getCreatedAt())
                .build();
    }
}

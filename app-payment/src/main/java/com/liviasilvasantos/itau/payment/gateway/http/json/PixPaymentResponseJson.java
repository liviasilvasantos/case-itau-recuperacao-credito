package com.liviasilvasantos.itau.payment.gateway.http.json;

import com.liviasilvasantos.itau.payment.domain.PixPayment;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PixPaymentResponseJson {

    private String pixCode;
    private String pixLink;
    private LocalDateTime expiresAt;

    public static PixPaymentResponseJson of(PixPayment pixPayment) {
        return PixPaymentResponseJson.builder()
                .pixCode(pixPayment.getPixCode())
                .pixLink(pixPayment.getPixLink())
                .expiresAt(pixPayment.getExpiresAt())
                .build();
    }
}

package com.liviasilvasantos.itau.payment.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PixCode {

    private String pixCode;
    private String pixLink;
    private LocalDateTime expiresAt;
}

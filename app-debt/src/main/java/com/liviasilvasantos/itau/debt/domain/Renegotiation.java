package com.liviasilvasantos.itau.debt.domain;

import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Builder
@With
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Renegotiation {

    private String catalogId;
    private LocalDateTime createdAt;
    private Long totalRenegotiationInCents;
    
}

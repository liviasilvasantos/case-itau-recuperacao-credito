package com.liviasilvasantos.itau.debt.gateway.http.json;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RenegotiationJson {

    private String catalogId;
    private Long totalRenegotiationInCents;
    
}

package com.liviasilvasantos.itau.payment.usecase;

import com.liviasilvasantos.itau.payment.domain.PixCode;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class GeneratePixCode {

    public PixCode execute(final BigDecimal totalValue) {
        log.info("generating pix code for value: {}", totalValue);
        val pixCode = mockGeneratePixCode();
        return pixCode;
    }

    private PixCode mockGeneratePixCode() {
        return PixCode.builder()
                .pixCode(UUID.randomUUID().toString())
                .pixLink("www.pix.com/")
                .expiresAt(LocalDateTime.now().plusHours(1))
                .build();
    }
}

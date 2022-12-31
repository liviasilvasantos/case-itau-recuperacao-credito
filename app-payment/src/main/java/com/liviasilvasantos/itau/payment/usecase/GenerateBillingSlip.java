package com.liviasilvasantos.itau.payment.usecase;

import com.liviasilvasantos.itau.payment.domain.BillingSlipCode;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Slf4j
public class GenerateBillingSlip {

    public BillingSlipCode execute(final BigDecimal totalValue) {
        log.info("generating billing slip for value: {}", totalValue);
        val billingSlipCode = mockGenerateBillingSlipCode();
        return billingSlipCode;
    }

    private BillingSlipCode mockGenerateBillingSlipCode() {
        return BillingSlipCode.builder()
                .bankCode("AAA")
                .barCode("AAAABBBBCCCCDDDD")
                .issuer("Issuer X")
                .number("AABBCC")
                .expiresAt(LocalDateTime.now().plusHours(5))
                .build();
    }
}

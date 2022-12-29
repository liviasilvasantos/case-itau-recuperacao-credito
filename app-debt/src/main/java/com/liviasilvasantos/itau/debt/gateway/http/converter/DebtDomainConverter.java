package com.liviasilvasantos.itau.debt.gateway.http.converter;

import com.liviasilvasantos.itau.debt.domain.Debt;
import com.liviasilvasantos.itau.debt.domain.Status;
import com.liviasilvasantos.itau.debt.gateway.http.json.DebtJson;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DebtDomainConverter implements Converter<DebtJson, Debt> {

    @Override
    public Debt convert(final DebtJson debtJson) {
        return Debt.builder()
                .status(debtJson.getStatus())
                .customerId(debtJson.getCustomerId())
                .totalInCents(debtJson.getTotalInCents())
                .createdAt(LocalDateTime.now())
                .status(Status.CREATED)
                .build();
    }

}

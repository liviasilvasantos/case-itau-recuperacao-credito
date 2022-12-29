package com.liviasilvasantos.itau.debt.usecase;

import com.liviasilvasantos.itau.debt.domain.Debt;
import com.liviasilvasantos.itau.debt.gateway.DebtGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveDebt {

    private final DebtGateway debtGateway;

    public Debt execute(final Debt debt) {
        return debtGateway.save(debt);
    }
}

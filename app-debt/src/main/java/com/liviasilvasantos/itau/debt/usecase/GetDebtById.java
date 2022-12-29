package com.liviasilvasantos.itau.debt.usecase;

import com.liviasilvasantos.itau.debt.domain.Debt;
import com.liviasilvasantos.itau.debt.gateway.DebtGateway;
import com.liviasilvasantos.itau.debt.gateway.exception.DebtNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetDebtById {

    private final DebtGateway debtGateway;

    public Debt execute(final String id) throws DebtNotFoundException {
        return debtGateway.findById(id)
                .orElseThrow(() -> new DebtNotFoundException("no debt found for id " + id));
    }
}

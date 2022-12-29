package com.liviasilvasantos.itau.debt.usecase;

import com.liviasilvasantos.itau.debt.domain.Debt;
import com.liviasilvasantos.itau.debt.gateway.DebtGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllDebts {

    private final DebtGateway debtGateway;

    public List<Debt> execute(final Pageable pageable) {
        return debtGateway.findAll(pageable).getContent();
    }
}

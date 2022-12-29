package com.liviasilvasantos.itau.debt.usecase;

import com.liviasilvasantos.itau.debt.domain.Debt;
import com.liviasilvasantos.itau.debt.gateway.DebtGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetDebtsByCustomer {

    private final DebtGateway debtGateway;

    public List<Debt> execute(final String customerEmail) {
        //TODO chamar customer client e depois com o id
//        return catalogGateway.findById(id)
//                .orElseThrow(() -> new CatalogNotFoundException("no catalog found for id " + id));
        return null;
    }
}

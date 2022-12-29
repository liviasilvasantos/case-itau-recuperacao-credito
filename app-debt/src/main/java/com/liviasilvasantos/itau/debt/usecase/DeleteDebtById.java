package com.liviasilvasantos.itau.debt.usecase;

import com.liviasilvasantos.itau.debt.gateway.DebtGateway;
import com.liviasilvasantos.itau.debt.gateway.exception.DebtNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteDebtById {

    private final GetDebtById getDebtById;
    private final DebtGateway debtGateway;

    public void execute(final String id) throws DebtNotFoundException {
        val debt = getDebtById.execute(id);
        debtGateway.remove(debt);
    }
}

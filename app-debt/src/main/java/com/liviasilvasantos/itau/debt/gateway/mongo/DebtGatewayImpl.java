package com.liviasilvasantos.itau.debt.gateway.mongo;

import com.liviasilvasantos.itau.debt.domain.Debt;
import com.liviasilvasantos.itau.debt.gateway.DebtGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DebtGatewayImpl implements DebtGateway {

    private final DebtRepository debtRepository;

    @Override
    public Page<Debt> findAll(final Pageable pageable) {
        return debtRepository.findAll(pageable);
    }

    public Page<Debt> findByCustomer(final String customerId, final Pageable pageable) {
        return debtRepository.findByCustomerId(customerId, pageable);
    }

    @Override
    public Optional<Debt> findById(final String id) {
        return debtRepository.findById(id);
    }

    @Override
    public Debt save(final Debt debt) {
        return debtRepository.save(debt);
    }

    @Override
    public void remove(final Debt debt) {
        debtRepository.delete(debt);
    }
}

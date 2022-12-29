package com.liviasilvasantos.itau.debt.gateway;

import com.liviasilvasantos.itau.debt.domain.Debt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DebtGateway {

    Page<Debt> findAll(Pageable pageable);

    Page<Debt> findByCustomer(String customerId, Pageable pageable);

    Optional<Debt> findById(String id);

    Debt save(Debt catalog);

    void remove(Debt catalog);
}

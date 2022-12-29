package com.liviasilvasantos.itau.debt.gateway.mongo;

import com.liviasilvasantos.itau.debt.domain.Debt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DebtRepository extends MongoRepository<Debt, String> {

    Page<Debt> findByCustomerId(String customerId, Pageable pageable);
}

package com.liviasilvasantos.itau.debt.usecase;

import com.liviasilvasantos.itau.debt.domain.Debt;
import com.liviasilvasantos.itau.debt.domain.Renegotiation;
import com.liviasilvasantos.itau.debt.gateway.PaymentRenegotiationGateway;
import com.liviasilvasantos.itau.debt.gateway.kafka.PaymentKafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RenegotiateDebt {

    private final GetDebtById getDebtById;
    private final SaveDebt saveDebt;
    private final PaymentRenegotiationGateway paymentRenegotiationGateway;

    public Debt execute(final String id, final Renegotiation renegotiation) {
        log.info("renegotiating for debt id {}", id);
        val debt = getDebtById.execute(id);

        paymentRenegotiationGateway.requestPaymentRenegotiation(debt);

        val debtWithRenegotiation = saveDebt.execute(debt.withRenegotiation(renegotiation));
        return debtWithRenegotiation;
    }
}

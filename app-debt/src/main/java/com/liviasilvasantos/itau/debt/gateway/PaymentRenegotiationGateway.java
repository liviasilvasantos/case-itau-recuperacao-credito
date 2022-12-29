package com.liviasilvasantos.itau.debt.gateway;

import com.liviasilvasantos.itau.debt.domain.Debt;

public interface PaymentRenegotiationGateway {

    void requestPaymentRenegotiation(Debt debt);
}

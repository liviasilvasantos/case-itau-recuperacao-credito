package com.liviasilvasantos.itau.payment.domain;

import com.liviasilvasantos.itau.payment.usecase.CreatePaymentRenegotiation;
import lombok.Data;

@Data
public class PaymentContext {

    private CreatePaymentRenegotiation createPaymentRenegotiation;
    //catalog
    private String paymentType;
}

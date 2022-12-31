package com.liviasilvasantos.itau.payment.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardPayment {

    private String number;
    private String holder;
    private String brand;
    private String encryptedData;
    private String expirationMonth;
    private String expirationYear;
}

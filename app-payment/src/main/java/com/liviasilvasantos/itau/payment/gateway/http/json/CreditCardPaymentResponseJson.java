package com.liviasilvasantos.itau.payment.gateway.http.json;

import com.liviasilvasantos.itau.payment.domain.CreditCardPayment;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardPaymentResponseJson {

    private String number;
    private String holder;
    private String brand;
    private String encryptedData;
    private String expirationMonth;
    private String expirationYear;

    public static CreditCardPaymentResponseJson of(final CreditCardPayment creditCardPayment) {
        return CreditCardPaymentResponseJson.builder()
                .number(creditCardPayment.getNumber())
                .holder(creditCardPayment.getHolder())
                .brand(creditCardPayment.getBrand())
                .encryptedData(creditCardPayment.getEncryptedData())
                .expirationMonth(creditCardPayment.getExpirationMonth())
                .expirationYear(creditCardPayment.getExpirationYear())
                .build();
    }
}

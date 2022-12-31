package com.liviasilvasantos.itau.payment.domain;

import com.liviasilvasantos.itau.payment.domain.catalog.Catalog;
import com.liviasilvasantos.itau.payment.domain.renegotiation.PaymentRenegotiation;
import com.liviasilvasantos.itau.payment.util.BigDecimalUtils;
import lombok.Builder;
import lombok.Data;
import lombok.val;

import java.math.BigDecimal;

@Data
@Builder
public class PaymentContext {

    private PaymentRenegotiation paymentRenegotiation;
    private Catalog catalog;

    public String getPaymentType(){
        return catalog.getPaymentType();
    }

    public BigDecimal getTotalRenegotiationValue() {
        return BigDecimalUtils.centsToBigDecimal(paymentRenegotiation.getTotalRenegotiationValueInCents());
    }

    public BigDecimal getTotalDiscountValue() {
        return getTotalRenegotiationValue().multiply(BigDecimal.valueOf(catalog.getDiscount()));
    }

    public BigDecimal getCalculatedRenegotiationValue() {
        val totalRenegotiationValue = getTotalRenegotiationValue();
        val totalDiscount = getTotalDiscountValue();
        return totalRenegotiationValue.subtract(totalDiscount);
    }
}

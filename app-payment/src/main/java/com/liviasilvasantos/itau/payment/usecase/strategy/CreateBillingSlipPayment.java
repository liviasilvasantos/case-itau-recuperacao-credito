package com.liviasilvasantos.itau.payment.usecase.strategy;

import com.liviasilvasantos.itau.payment.domain.BillingSlipPayment;
import com.liviasilvasantos.itau.payment.domain.Payment;
import com.liviasilvasantos.itau.payment.domain.PaymentContext;
import com.liviasilvasantos.itau.payment.domain.PaymentType;
import com.liviasilvasantos.itau.payment.gateway.PaymentGateway;
import com.liviasilvasantos.itau.payment.usecase.GenerateBillingSlip;
import com.liviasilvasantos.itau.payment.util.BigDecimalUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreateBillingSlipPayment implements CreatePaymentStrategy {

    private final GenerateBillingSlip generateBillingSlip;
    private final PaymentGateway paymentGateway;
//    private final NotificationGateway notificationGateway;

    @Override
    public boolean canExecute(final PaymentContext context) {
        return context.getPaymentType() == "BILLING_SLIP";
    }

    @Override
    public void execute(final PaymentContext context) {
        //TODO boleto: gerar boleto, atualizar payment, gerar mensagem no topico de notificao
        val payment = paymentGateway.save(buildPayment(context));
//        notificationGateway.send(); //TODO topic ??? payload ???
    }

    private Payment buildPayment(final PaymentContext context) {
        val billingSlipPayment = Payment.builder()
                .createdAt(LocalDateTime.now())
                .type(PaymentType.BILLING_SLIP)
                .expiresAt(LocalDateTime.now().plusMinutes(context.getCatalog().getExpirationInMinutes()))
                .billingSlipInfo(buildBillingSlipPayment(context))
                .totalDiscountInCents(BigDecimalUtils.bigDecimalToCents(context.getTotalDiscountValue()))
                .totalValueInCents(BigDecimalUtils.bigDecimalToCents(context.getCalculatedRenegotiationValue()))
                .build();
        //TODO add more info?
        return billingSlipPayment;
    }

    private BillingSlipPayment buildBillingSlipPayment(final PaymentContext context) {
        val billingSlip = generateBillingSlip.execute(context.getCalculatedRenegotiationValue());
        return BillingSlipPayment.builder()
                .bankCode(billingSlip.getBankCode())
                .barCode(billingSlip.getBarCode())
                .expiresAt(LocalDateTime.now().plusMinutes(context.getCatalog().getExpirationInMinutes()).toLocalDate())
                .issuer(billingSlip.getIssuer())
                .number(billingSlip.getNumber())
                .build();
    }
}

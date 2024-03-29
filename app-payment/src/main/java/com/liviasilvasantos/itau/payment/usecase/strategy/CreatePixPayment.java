package com.liviasilvasantos.itau.payment.usecase.strategy;

import com.liviasilvasantos.itau.payment.domain.Payment;
import com.liviasilvasantos.itau.payment.domain.PaymentContext;
import com.liviasilvasantos.itau.payment.domain.PaymentType;
import com.liviasilvasantos.itau.payment.domain.PixPayment;
import com.liviasilvasantos.itau.payment.gateway.NotificationGateway;
import com.liviasilvasantos.itau.payment.gateway.PaymentGateway;
import com.liviasilvasantos.itau.payment.gateway.kafka.request.NotificationEvent;
import com.liviasilvasantos.itau.payment.gateway.kafka.request.NotificationType;
import com.liviasilvasantos.itau.payment.usecase.GeneratePixCode;
import com.liviasilvasantos.itau.payment.util.BigDecimalUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreatePixPayment implements CreatePaymentStrategy {

    private final Integer PIX_EXPIRATION_HOUR = 2;
    private final GeneratePixCode generatePixCode;
    private final PaymentGateway paymentGateway;
    private final NotificationGateway notificationGateway;

    @Override
    public boolean canExecute(final PaymentContext context) {
        return StringUtils.equals(context.getPaymentType(), "PIX");
    }

    @Override
    public void execute(final PaymentContext context) {
        val payment = paymentGateway.save(buildPayment(context));
        notificationGateway.requestNotification(payment, NotificationType.WHATSAPP, NotificationEvent.PAYMENT_PIX);
    }

    private Payment buildPayment(final PaymentContext context) {
        val pixPayment = Payment.builder()
                .customerId(context.getPaymentRenegotiation().getCustomerId())
                .debtId(context.getPaymentRenegotiation().getDebtId())
                .catalogId(context.getPaymentRenegotiation().getCatalogId())
                .createdAt(LocalDateTime.now())
                .type(PaymentType.PIX)
                .expiresAt(LocalDateTime.now().plusMinutes(context.getCatalog().getExpirationInMinutes()))
                .pixInfo(buildPixPayment(context))
                .totalDiscountInCents(BigDecimalUtils.bigDecimalToCents(context.getTotalDiscountValue()))
                .discountValue(context.getCatalog().getDiscount())
                .totalValueInCents(BigDecimalUtils.bigDecimalToCents(context.getCalculatedRenegotiationValue()))
                .build();
        return pixPayment;
    }

    private PixPayment buildPixPayment(final PaymentContext context) {
        val pixCode = generatePixCode.execute(context.getCalculatedRenegotiationValue());
        return PixPayment.builder()
                .pixCode(pixCode.getPixCode())
                .pixLink(pixCode.getPixLink())
                .expiresAt(pixCode.getExpiresAt())
                .build();
    }
}

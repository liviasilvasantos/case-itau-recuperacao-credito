package com.liviasilvasantos.itau.payment.usecase.strategy;

import com.liviasilvasantos.itau.payment.domain.Payment;
import com.liviasilvasantos.itau.payment.domain.PaymentContext;
import com.liviasilvasantos.itau.payment.domain.PaymentType;
import com.liviasilvasantos.itau.payment.domain.PixPayment;
import com.liviasilvasantos.itau.payment.gateway.PaymentGateway;
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
//    private final NotificationGateway notificationGateway;

    @Override
    public boolean canExecute(final PaymentContext context) {
        return StringUtils.equals(context.getPaymentType(), "PIX");
    }

    @Override
    public void execute(final PaymentContext context) {
        //TODO pix: gerar pix, atualizar payment, gerar mensagem no topico de notificao
        paymentGateway.save(buildPayment(context));
//        notificationGateway.send(); //TODO topic ??? payload ???
    }

    private Payment buildPayment(final PaymentContext context) {
        val pixPayment = Payment.builder()
                .createdAt(LocalDateTime.now())
                .type(PaymentType.PIX)
                .expiresAt(LocalDateTime.now().plusMinutes(context.getCatalog().getExpirationInMinutes()))
                .pixInfo(buildPixPayment(context))
                .totalDiscountInCents(BigDecimalUtils.bigDecimalToCents(context.getTotalDiscountValue()))
                .totalValueInCents(BigDecimalUtils.bigDecimalToCents(context.getCalculatedRenegotiationValue()))
                .build();
        //TODO add more info?
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

package com.liviasilvasantos.itau.payment.usecase.strategy;

import com.liviasilvasantos.itau.payment.domain.Payment;
import com.liviasilvasantos.itau.payment.domain.PaymentContext;
import com.liviasilvasantos.itau.payment.domain.PaymentType;
import com.liviasilvasantos.itau.payment.gateway.PaymentGateway;
import com.liviasilvasantos.itau.payment.usecase.GeneratePixCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Slf4j
@RequiredArgsConstructor
public class CreatePixPayment implements CreatePaymentStrategy {

    private final GeneratePixCode generatePixCode;
    private final PaymentGateway paymentGateway;
//    private final NotificationGateway notificationGateway;

    @Override
    public boolean canExecute(final PaymentContext context) {
        return context.getPaymentType() == "PIX";
    }

    @Override
    public void execute(final PaymentContext context) {
        //TODO gerar pix code, atualizar payment, gerar mensagem no topico de notificao
        generatePixCode.execute();
        paymentGateway.save(buildPayment(context));
//        notificationGateway.send(); //TODO topic ??? payload ???
    }

    private Payment buildPayment(final PaymentContext context) {
        val pixPayment = Payment.builder()
                .createdAt(LocalDateTime.now())
                .type(PaymentType.PIX)
                .expiresAt(LocalDate.now().plusDays(1))
                .build();
        //TODO add pix attributes
        return pixPayment;
    }
}

package com.liviasilvasantos.itau.payment.usecase;

import com.liviasilvasantos.itau.payment.domain.PaymentContext;
import com.liviasilvasantos.itau.payment.domain.renegotiation.PaymentRenegotiation;
import com.liviasilvasantos.itau.payment.gateway.CatalogGateway;
import com.liviasilvasantos.itau.payment.gateway.PaymentGateway;
import com.liviasilvasantos.itau.payment.usecase.strategy.CreatePaymentStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreatePaymentRenegotiation {

    private final PaymentGateway paymentGateway;
    private final CatalogGateway catalogGateway;
    private final List<CreatePaymentStrategy> paymentStrategies;

    public void execute(final PaymentRenegotiation paymentRenegotiation) {
        //TODO salvar Payment
        val context = buildPaymentContext(paymentRenegotiation);

        paymentStrategies.stream()
                .filter(createPaymentStrategy -> createPaymentStrategy.canExecute(context))
                .findFirst()
                .ifPresentOrElse(strategy -> strategy.execute(context),
                        () -> log.error("no strategy found for context: " + context));
        // TODO cartao de credito: mock gateway de pagamento para tokenizacao, atualizar payment
        // TODO cartao de debito: gerar mensagem no topico de debito em conta, gerar mensagem no topico de notificacao
    }

    private PaymentContext buildPaymentContext(final PaymentRenegotiation paymentRenegotiation) {
        val catalog = catalogGateway.findById(paymentRenegotiation.getCatalogId());
        return PaymentContext.builder()
                .paymentRenegotiation(paymentRenegotiation)
                .catalog(catalog)
                .build();
    }
}

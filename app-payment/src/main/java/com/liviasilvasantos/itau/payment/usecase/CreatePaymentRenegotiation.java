package com.liviasilvasantos.itau.payment.usecase;

import com.liviasilvasantos.itau.payment.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CreatePaymentRenegotiation {

    private final PaymentGateway paymentGateway;

    public void execute(CreatePaymentRenegotiation createPaymentRenegotiation) {
        //TODO salvar Payment
        //buscar dados do catalog via feign client
        //criar handler por tipo de pagamento
        //  boleto: gerar boleto, atualizar payment, gerar mensagem no topico de notificao
        //  pix: gerar pix, atualizar payment, gerar mensagem no topico de notificao
        //  cartao de credito: mock gateway de pagamento para tokenizacao, atualizar payment
        //  cartao de debito: gerar mensagem no topico de debito em conta, gerar mensagem no topico de notificacao
    }
}

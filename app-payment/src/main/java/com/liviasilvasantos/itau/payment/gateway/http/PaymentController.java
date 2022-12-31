package com.liviasilvasantos.itau.payment.gateway.http;

import com.liviasilvasantos.itau.payment.gateway.http.json.PaymentResponseJson;
import com.liviasilvasantos.itau.payment.usecase.GetAllPayments;
import com.liviasilvasantos.itau.payment.usecase.GetPaymentById;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final GetAllPayments getAllPayments;
    private final GetPaymentById getPaymentById;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentResponseJson> findById(@PathVariable("id") final String id) {
        val payment = getPaymentById.execute(id);
        return ResponseEntity.ok(PaymentResponseJson.of(payment));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PaymentResponseJson>> findAll(@RequestParam(value = "page", defaultValue = "0") final int page,
                                                             @RequestParam(value = "size", defaultValue = "5") final int size) {
        val payments = getAllPayments.execute(PageRequest.of(page, size));
        val paymentsJson = payments.stream()
                .map(catalog -> PaymentResponseJson.of(catalog))
                .collect(Collectors.toList());
        return ResponseEntity.ok(paymentsJson);
    }

}

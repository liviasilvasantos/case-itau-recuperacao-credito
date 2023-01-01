package com.liviasilvasantos.itau.payment.gateway.http.json;

import com.liviasilvasantos.itau.payment.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseJson {

    private String id;
    private String customerId;
    private String debtId;
    private String catalogId;
    private PaymentType type;
    private Long totalValueInCents;
    private Long totalDiscountInCents;
    private Double discountValue;
    private LocalDateTime expiresAt;
    private LocalDateTime createdAt;
    private Integer numberOfInstallments;
    private Set<InstallmentResponseJson> installments;
    private PixPaymentResponseJson pixInfo;
    private CreditCardPaymentResponseJson creditCardInfo;
    private BillingSlipPaymentResponseJson billingSlipInfo;

    public static PaymentResponseJson of(final Payment payment) {
        return PaymentResponseJson.builder()
                .id(payment.getId())
                .customerId(payment.getCustomerId())
                .debtId(payment.getDebtId())
                .catalogId(payment.getCatalogId())
                .type(payment.getType())
                .totalValueInCents(payment.getTotalValueInCents())
                .totalDiscountInCents(payment.getTotalDiscountInCents())
                .discountValue(payment.getDiscountValue())
                .expiresAt(payment.getExpiresAt())
                .createdAt(payment.getCreatedAt())
                .numberOfInstallments(payment.getNumberOfInstallments())
                .installments(buildInstallments(payment.getInstallments()))
                .pixInfo(buildPixInfo(payment.getPixInfo()))
                .creditCardInfo(buildCreditCardInfo(payment.getCreditCardInfo()))
                .billingSlipInfo(buildBillingSlipInfo(payment.getBillingSlipInfo()))
                .build();
    }

    private static Set<InstallmentResponseJson> buildInstallments(Set<Installment> installments) {
        return CollectionUtils.emptyIfNull(installments)
                .stream()
                .map(installment -> InstallmentResponseJson.of(installment))
                .collect(Collectors.toSet());
    }

    private static CreditCardPaymentResponseJson buildCreditCardInfo(final CreditCardPayment creditCardInfo) {
        return Optional.ofNullable(creditCardInfo)
                .map(creditCard -> CreditCardPaymentResponseJson.of(creditCard))
                .orElse(null);
    }

    private static BillingSlipPaymentResponseJson buildBillingSlipInfo(final BillingSlipPayment billingSlipInfo) {
        return Optional.ofNullable(billingSlipInfo)
                .map(billingSlip -> BillingSlipPaymentResponseJson.of(billingSlip))
                .orElse(null);
    }

    private static PixPaymentResponseJson buildPixInfo(final PixPayment pixInfo) {
        return Optional.ofNullable(pixInfo)
                .map(pix -> PixPaymentResponseJson.of(pix))
                .orElse(null);
    }
}

package com.liviasilvasantos.itau.catalog.gateway.http.json;

import com.liviasilvasantos.itau.catalog.domain.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogJson {

    @NotBlank(message = "Code should not be empty")
    private String code;
    @NotBlank(message = "Description should not be empty")
    private String description;
    @NotNull(message = "Expiration (in minutes) should not be empty")
    private Integer expirationInMinutes;
    @NotNull(message = "Payment Type should not be empty")
    private PaymentType paymentType;
    @NotNull(message = "Discount should not be empty")
    private double discount;
    private Integer numberOfInstallments;

}

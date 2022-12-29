package com.liviasilvasantos.itau.catalog.gateway.http.json;

import com.liviasilvasantos.itau.catalog.domain.PaymentType;
import com.liviasilvasantos.itau.catalog.domain.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogJson {

    @NotBlank(message = "Code should not be empty")
    private String code;
    @NotBlank(message = "Description should not be empty")
    private String description;
    @NotBlank(message = "Deadline should not be empty")
    private String deadline;
    @NotNull(message = "Payment Type should not be empty")
    private PaymentType paymentType;
    @NotNull(message = "Discount should not be empty")
    private double discount;

}

package com.liviasilvasantos.itau.debt.gateway.http.json;

import com.liviasilvasantos.itau.debt.domain.Status;
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
public class DebtJson {

    @NotBlank(message = "Customer id should not be empty")
    private String customerId;
    @NotNull(message = "Total In Cents should not be empty")
    private Long totalInCents;

}

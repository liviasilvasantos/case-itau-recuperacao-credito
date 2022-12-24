package com.liviasilvasantos.itau.customer.gateway.http.json;

import com.liviasilvasantos.itau.customer.domain.Customer;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerJson {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    public static CustomerJson of(final Customer customer){
        return CustomerJson.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }
}

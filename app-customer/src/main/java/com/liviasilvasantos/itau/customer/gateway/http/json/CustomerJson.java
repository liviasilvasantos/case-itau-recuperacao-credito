package com.liviasilvasantos.itau.customer.gateway.http.json;

import com.liviasilvasantos.itau.customer.domain.Customer;
import lombok.*;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerJson {

    private String id;
    private String name;
    private String email;

    public static CustomerJson of(final Customer customer){
        return CustomerJson.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }
}

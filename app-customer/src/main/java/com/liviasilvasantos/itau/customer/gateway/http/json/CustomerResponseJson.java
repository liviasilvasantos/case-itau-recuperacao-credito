package com.liviasilvasantos.itau.customer.gateway.http.json;

import com.liviasilvasantos.itau.customer.domain.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseJson implements Serializable {

    private String id;
    private String name;
    private String email;

    //TODO addresses and phones

    public static CustomerResponseJson of(final Customer customer){
        return CustomerResponseJson.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .build();
    }
}

package com.liviasilvasantos.itau.notification.gateway.feign.json;

import com.liviasilvasantos.itau.notification.domain.customer.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseJson {

    private AddressType type;
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String country;
    private String district;
    private String zipCode;
}

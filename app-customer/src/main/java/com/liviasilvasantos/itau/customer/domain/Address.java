package com.liviasilvasantos.itau.customer.domain;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

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

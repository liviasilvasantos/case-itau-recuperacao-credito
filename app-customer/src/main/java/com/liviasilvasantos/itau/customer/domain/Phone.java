package com.liviasilvasantos.itau.customer.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    private PhoneType type;
    private int countryCode;
    private String code;
    private String number;

}

package com.liviasilvasantos.itau.customer.domain;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    private PhoneType type;
    private int countryCode;
    private String code;
    private String number;

}

package com.liviasilvasantos.itau.notification.domain.customer;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    private PhoneType type;
    private int countryCode;
    private String code;
    private String number;

}

package com.liviasilvasantos.itau.notification.domain.customer;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Phone {

    private PhoneType type;
    private int countryCode;
    private String code;
    private String number;

}

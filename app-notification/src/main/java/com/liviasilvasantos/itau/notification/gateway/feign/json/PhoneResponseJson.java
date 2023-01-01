package com.liviasilvasantos.itau.notification.gateway.feign.json;

import com.liviasilvasantos.itau.notification.domain.customer.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneResponseJson {

    private PhoneType type;
    private int countryCode;
    private String code;
    private String number;

}

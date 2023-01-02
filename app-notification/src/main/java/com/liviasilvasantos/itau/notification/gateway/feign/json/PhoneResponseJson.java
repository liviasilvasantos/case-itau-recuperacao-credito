package com.liviasilvasantos.itau.notification.gateway.feign.json;

import com.liviasilvasantos.itau.notification.domain.customer.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneResponseJson implements Serializable {

    private PhoneType type;
    private int countryCode;
    private String code;
    private String number;

}

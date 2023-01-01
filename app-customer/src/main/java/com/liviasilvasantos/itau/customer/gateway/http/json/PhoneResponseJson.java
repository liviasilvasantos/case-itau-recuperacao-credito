package com.liviasilvasantos.itau.customer.gateway.http.json;

import com.liviasilvasantos.itau.customer.domain.Phone;
import com.liviasilvasantos.itau.customer.domain.PhoneType;
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

    public static PhoneResponseJson of(final Phone phone) {
        return PhoneResponseJson.builder()
                .type(phone.getType())
                .countryCode(phone.getCountryCode())
                .code(phone.getCode())
                .number(phone.getNumber())
                .build();
    }
}

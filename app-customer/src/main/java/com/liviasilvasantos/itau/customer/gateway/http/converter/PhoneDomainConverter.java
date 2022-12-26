package com.liviasilvasantos.itau.customer.gateway.http.converter;

import com.liviasilvasantos.itau.customer.domain.Phone;
import com.liviasilvasantos.itau.customer.gateway.http.json.PhoneJson;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PhoneDomainConverter implements Converter<PhoneJson, Phone> {

    @Override
    public Phone convert(final PhoneJson phoneJson) {
        return Phone.builder()
                .code(phoneJson.getCode())
                .countryCode(phoneJson.getCountryCode())
                .type(phoneJson.getType())
                .number(phoneJson.getNumber())
                .build();
    }
}

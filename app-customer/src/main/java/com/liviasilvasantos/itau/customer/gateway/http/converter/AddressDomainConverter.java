package com.liviasilvasantos.itau.customer.gateway.http.converter;

import com.liviasilvasantos.itau.customer.domain.Address;
import com.liviasilvasantos.itau.customer.gateway.http.json.AddressJson;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AddressDomainConverter implements Converter<AddressJson, Address> {

    @Override
    public Address convert(final AddressJson addressJson) {
        return Address.builder()
                .city(addressJson.getCity())
                .type(addressJson.getType())
                .state(addressJson.getState())
                .complement(addressJson.getComplement())
                .country(addressJson.getCountry())
                .district(addressJson.getDistrict())
                .number(addressJson.getNumber())
                .street(addressJson.getStreet())
                .zipCode(addressJson.getZipCode())
                .build();
    }
}

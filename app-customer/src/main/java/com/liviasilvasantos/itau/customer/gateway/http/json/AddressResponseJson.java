package com.liviasilvasantos.itau.customer.gateway.http.json;

import com.liviasilvasantos.itau.customer.domain.Address;
import com.liviasilvasantos.itau.customer.domain.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseJson implements Serializable {

    private AddressType type;
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String country;
    private String district;
    private String zipCode;

    public static AddressResponseJson of(final Address address) {
        return AddressResponseJson.builder()
                .type(address.getType())
                .street(address.getStreet())
                .number(address.getNumber())
                .complement(address.getComplement())
                .city(address.getCity())
                .state(address.getState())
                .country(address.getCountry())
                .district(address.getDistrict())
                .zipCode(address.getZipCode())
                .build();
    }
}

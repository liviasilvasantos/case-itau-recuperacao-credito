package com.liviasilvasantos.itau.notification.mocks;

import com.liviasilvasantos.itau.notification.domain.customer.Address;
import com.liviasilvasantos.itau.notification.domain.customer.AddressType;

public class MockAddress {

    public static Address VALID() {
        return Address.builder()
                .city("Santos")
                .state("SP")
                .complement("fundos")
                .country("Brasil")
                .district("Marapé")
                .number("123")
                .street("Rua do Pelé")
                .type(AddressType.HOME)
                .zipCode("11000-000")
                .build();
    }
}

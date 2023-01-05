package com.liviasilvasantos.itau.notification.mocks;

import com.liviasilvasantos.itau.notification.domain.customer.Phone;
import com.liviasilvasantos.itau.notification.domain.customer.PhoneType;

public class MockPhone {

    public static Phone VALID_MOBILE() {
        return Phone.builder()
                .code("13")
                .type(PhoneType.MOBILE)
                .countryCode(55)
                .number("1122334455")
                .build();
    }
}

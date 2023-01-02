package com.liviasilvasantos.itau.notification.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String id;

    private String name;

    private String email;

    private LocalDateTime createdAt = LocalDateTime.now();

    private List<Address> addresses;

    private List<Phone> phones;

    public String getMobilePhone() {
        return CollectionUtils.emptyIfNull(getPhones())
                .stream().filter(phone -> phone.getType() == PhoneType.MOBILE)
                .findFirst()
                .map(phone -> "(%d) %s-%s".formatted(phone.getCountryCode(), phone.getCode(), phone.getNumber()))
                .orElse(null);
    }
}

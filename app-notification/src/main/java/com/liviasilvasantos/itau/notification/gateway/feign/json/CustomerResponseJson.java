package com.liviasilvasantos.itau.notification.gateway.feign.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseJson {

    private String id;

    private String name;

    private String email;

    private LocalDateTime createdAt = LocalDateTime.now();

    private List<AddressResponseJson> addresses;

    private List<PhoneResponseJson> phones;
    private boolean failed;
}

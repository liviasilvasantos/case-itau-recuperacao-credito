package com.liviasilvasantos.itau.customer.gateway.http.json;

import com.liviasilvasantos.itau.customer.domain.Address;
import com.liviasilvasantos.itau.customer.domain.Customer;
import com.liviasilvasantos.itau.customer.domain.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseJson implements Serializable {

    private String id;
    private String name;
    private String email;
    private List<AddressResponseJson> addresses;
    private List<PhoneResponseJson> phones;

    public static CustomerResponseJson of(final Customer customer){
        return CustomerResponseJson.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .addresses(buildAddresses(customer.getAddresses()))
                .phones(buildPhones(customer.getPhones()))
                .build();
    }

    private static List<AddressResponseJson> buildAddresses(final List<Address> addresses) {
        return CollectionUtils.emptyIfNull(addresses)
                .stream()
                .map(address -> AddressResponseJson.of(address))
                .collect(Collectors.toList());
    }

    private static List<PhoneResponseJson> buildPhones(final List<Phone> phones) {
        return CollectionUtils.emptyIfNull(phones)
                .stream()
                .map(phone -> PhoneResponseJson.of(phone))
                .collect(Collectors.toList());
    }
}

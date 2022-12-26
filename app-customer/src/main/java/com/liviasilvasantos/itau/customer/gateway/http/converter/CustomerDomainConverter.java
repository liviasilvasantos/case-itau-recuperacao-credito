package com.liviasilvasantos.itau.customer.gateway.http.converter;

import com.liviasilvasantos.itau.customer.domain.Address;
import com.liviasilvasantos.itau.customer.domain.Customer;
import com.liviasilvasantos.itau.customer.domain.Phone;
import com.liviasilvasantos.itau.customer.gateway.http.json.AddressJson;
import com.liviasilvasantos.itau.customer.gateway.http.json.CustomerJson;
import com.liviasilvasantos.itau.customer.gateway.http.json.PhoneJson;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CustomerDomainConverter implements Converter<CustomerJson, Customer> {

    private final AddressDomainConverter addressDomainConverter;
    private final PhoneDomainConverter phoneDomainConverter;

    @Override
    public Customer convert(final CustomerJson customerJson) {
        return Customer.builder()
                .name(customerJson.getName())
                .email(customerJson.getEmail())
                .addresses(convertAddresses(customerJson.getAddresses()))
                .phones(convertPhones(customerJson.getPhones()))
                .build();
    }

    private List<Phone> convertPhones(List<PhoneJson> phones) {
        return CollectionUtils.isEmpty(phones) ? null
                : phones.stream().map(phoneJson -> phoneDomainConverter.convert(phoneJson)).collect(Collectors.toList());
    }

    private List<Address> convertAddresses(List<AddressJson> addresses) {
        return CollectionUtils.isEmpty(addresses) ? null
                : addresses.stream().map(addressJson -> addressDomainConverter.convert(addressJson)).collect(Collectors.toList());
    }
}

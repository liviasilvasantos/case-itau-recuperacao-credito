package com.liviasilvasantos.itau.customer.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@With
@Getter
@Document(value = "customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private String id;
    private String name;
    private String email;
    private List<Address> addresses;
    private List<Phone> phones;
}

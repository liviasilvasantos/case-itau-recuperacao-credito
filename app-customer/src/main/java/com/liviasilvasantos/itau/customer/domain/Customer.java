package com.liviasilvasantos.itau.customer.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @Size(min = 1)
    private List<Address> addresses;

    @Size(min = 1)
    private List<Phone> phones;
}

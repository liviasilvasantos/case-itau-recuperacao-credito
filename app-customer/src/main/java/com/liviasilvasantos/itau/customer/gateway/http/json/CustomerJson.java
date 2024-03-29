package com.liviasilvasantos.itau.customer.gateway.http.json;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerJson implements Serializable {

    @NotBlank(message = "Name should not be empty")
    private String name;

    @NotBlank(message = "E-mail should not be empty")
    @Email
    private String email;

    @Valid
    @NotEmpty(message = "Addresses should not be empty.")
    private List<AddressJson> addresses;

    @Valid
    @NotEmpty(message = "Phones should not be empty.")
    private List<PhoneJson> phones;

}

package com.liviasilvasantos.itau.customer.gateway.http.json;

import com.liviasilvasantos.itau.customer.domain.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressJson implements Serializable {

    @NotBlank(message = "Address Type should not be empty")
    private AddressType type;

    @NotBlank(message = "Street should not be empty")
    private String street;

    @NotBlank(message = "Number should not be empty")
    private String number;

    private String complement;

    @NotBlank(message = "City should not be empty")
    private String city;

    @NotBlank(message = "State should not be empty")
    private String state;

    @NotBlank(message = "Country should not be empty")
    private String country;

    private String district;
    private String zipCode;
}

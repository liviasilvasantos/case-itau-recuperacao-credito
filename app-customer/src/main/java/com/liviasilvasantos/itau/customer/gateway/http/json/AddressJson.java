package com.liviasilvasantos.itau.customer.gateway.http.json;

import com.liviasilvasantos.itau.customer.domain.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressJson implements Serializable {

    @NotEmpty(message = "Address Type should not be empty")
    private AddressType type;

    @NotEmpty(message = "Street should not be empty")
    private String street;

    @NotEmpty(message = "Number should not be empty")
    private String number;

    private String complement;

    @NotEmpty(message = "City should not be empty")
    private String city;

    @NotEmpty(message = "State should not be empty")
    private String state;

    @NotEmpty(message = "Country should not be empty")
    private String country;

    private String district;
    private String zipCode;
}

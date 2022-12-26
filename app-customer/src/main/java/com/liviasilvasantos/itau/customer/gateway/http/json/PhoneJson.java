package com.liviasilvasantos.itau.customer.gateway.http.json;

import com.liviasilvasantos.itau.customer.domain.PhoneType;
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
public class PhoneJson implements Serializable {

    @NotEmpty(message = "Phone Type should not be empty")
    private PhoneType type;

    @NotEmpty(message = "Country code should not be empty")
    private int countryCode;

    @NotEmpty(message = "Code should not be empty")
    private String code;

    @NotEmpty(message = "Number should not be empty")
    private String number;

}

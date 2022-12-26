package com.liviasilvasantos.itau.customer.gateway.http.json;

import com.liviasilvasantos.itau.customer.domain.PhoneType;
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
public class PhoneJson implements Serializable {

    @NotBlank(message = "Phone Type should not be empty")
    private PhoneType type;

    @NotBlank(message = "Country code should not be empty")
    private int countryCode;

    @NotBlank(message = "Code should not be empty")
    private String code;

    @NotBlank(message = "Number should not be empty")
    private String number;

}

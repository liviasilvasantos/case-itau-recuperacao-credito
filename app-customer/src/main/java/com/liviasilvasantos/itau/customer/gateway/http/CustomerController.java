package com.liviasilvasantos.itau.customer.gateway.http;

import com.liviasilvasantos.itau.customer.gateway.exception.CustomerNotFoundException;
import com.liviasilvasantos.itau.customer.gateway.http.json.CustomerJson;
import com.liviasilvasantos.itau.customer.usecase.GetCustomerByEmail;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Customers API", version = "1.0", description = "Customers Information"))
@Slf4j
public class CustomerController {

    private final GetCustomerByEmail getCustomerByEmail;

    @GetMapping
    public ResponseEntity<CustomerJson> findByEmail(@RequestParam("email") final String email) {
        try {
            val customer = getCustomerByEmail.execute(email);
            return ResponseEntity.ok(CustomerJson.of(customer));
        } catch (CustomerNotFoundException e) {
            log.error("error finding customer by email", e);
            //TODO add error handler
            return ResponseEntity.notFound().build();
        }
    }

}

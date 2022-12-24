package com.liviasilvasantos.itau.customer.gateway.http;

import com.liviasilvasantos.itau.customer.gateway.http.converter.CustomerDomainConverter;
import com.liviasilvasantos.itau.customer.gateway.http.json.CustomerJson;
import com.liviasilvasantos.itau.customer.usecase.DeleteCustomerByEmail;
import com.liviasilvasantos.itau.customer.usecase.GetAllCustomers;
import com.liviasilvasantos.itau.customer.usecase.GetCustomerByEmail;
import com.liviasilvasantos.itau.customer.usecase.SaveCustomer;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Customers API", version = "1.0", description = "Customers Information"))
@Slf4j
public class CustomerController {

    private final GetCustomerByEmail getCustomerByEmail;
    private final GetAllCustomers getAllCustomers;
    private final SaveCustomer saveCustomer;
    private final DeleteCustomerByEmail deleteCustomerByEmail;

    private final CustomerDomainConverter customerDomainConverter;

    @GetMapping
    public ResponseEntity<CustomerJson> findByEmail(@RequestParam("email") final String email) {
        val customer = getCustomerByEmail.execute(email);
        return ResponseEntity.ok(CustomerJson.of(customer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerJson>> findAll() {
        val customers = getAllCustomers.execute();
        val customersJson = customers.stream()
                .map(customer -> CustomerJson.of(customer))
                .collect(Collectors.toList());
        return ResponseEntity.ok(customersJson);
    }

    @PostMapping
    public ResponseEntity<CustomerJson> save(@RequestBody @Valid final CustomerJson customerJson) {
        val customer = saveCustomer.execute(customerDomainConverter.convert(customerJson));
        return ResponseEntity.status(HttpStatus.CREATED).body(CustomerJson.of(customer));
    }

    @DeleteMapping(value = "/deleteByEmail/{email}")
    public ResponseEntity<Void> delete(@PathVariable(value = "email") final String email){
        deleteCustomerByEmail.execute(email);
        return ResponseEntity.noContent().build();
    }
}

package com.liviasilvasantos.itau.customer.gateway.http;

import com.liviasilvasantos.itau.customer.domain.Customer;
import com.liviasilvasantos.itau.customer.gateway.http.converter.CustomerDomainConverter;
import com.liviasilvasantos.itau.customer.gateway.http.json.CustomerJson;
import com.liviasilvasantos.itau.customer.gateway.http.json.CustomerResponseJson;
import com.liviasilvasantos.itau.customer.usecase.DeleteCustomerById;
import com.liviasilvasantos.itau.customer.usecase.GetAllCustomers;
import com.liviasilvasantos.itau.customer.usecase.GetCustomerById;
import com.liviasilvasantos.itau.customer.usecase.SaveCustomer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final GetCustomerById getCustomerById;
    private final GetAllCustomers getAllCustomers;
    private final SaveCustomer saveCustomer;
    private final DeleteCustomerById deleteCustomerById;

    private final CustomerDomainConverter customerDomainConverter;

    @Operation(summary = "Get a customer by its id")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponseJson> findById(@Parameter(description = "id of a customer to be searched") @PathVariable("id") final String id) {
        val customer = getCustomerById.execute(id);
        return ResponseEntity.ok(CustomerResponseJson.of(customer));
    }

    @Operation(summary = "Gets all customers")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerResponseJson>> findAll(@Parameter(description = "number of the page") @RequestParam(value = "page", defaultValue = "0") final int page,
                                                              @Parameter(description = "size of the page") @RequestParam(value = "size", defaultValue = "5") final int size) {
        val customers = getAllCustomers.execute(PageRequest.of(page, size));
        val customersJson = customers.stream()
                .map(customer -> CustomerResponseJson.of(customer))
                .collect(Collectors.toList());
        return ResponseEntity.ok(customersJson);
    }

    @Operation(summary = "Creates a customer")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponseJson> save(@RequestBody @Valid final CustomerJson customerJson) {
        val customer = saveCustomer.execute(customerDomainConverter.convert(customerJson));
        return ResponseEntity.created(buildCustomerUri(customer)).body(CustomerResponseJson.of(customer));
    }

    @Operation(summary = "Deletes a customer by its id")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable(value = "id") final String id) {
        deleteCustomerById.execute(id);
        return ResponseEntity.noContent().build();
    }

    //TODO implement update customer via PATCH

    private static URI buildCustomerUri(final Customer customer) {
        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        return uri;
    }
}

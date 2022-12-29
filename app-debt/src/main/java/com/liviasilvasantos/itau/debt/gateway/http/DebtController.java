package com.liviasilvasantos.itau.debt.gateway.http;

import com.liviasilvasantos.itau.debt.domain.Debt;
import com.liviasilvasantos.itau.debt.gateway.http.converter.DebtDomainConverter;
import com.liviasilvasantos.itau.debt.gateway.http.converter.RenegotiationDomainConverter;
import com.liviasilvasantos.itau.debt.gateway.http.json.DebtJson;
import com.liviasilvasantos.itau.debt.gateway.http.json.DebtResponseJson;
import com.liviasilvasantos.itau.debt.gateway.http.json.RenegotiationJson;
import com.liviasilvasantos.itau.debt.usecase.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
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
@RequestMapping("/debts")
@RequiredArgsConstructor
@Slf4j
@OpenAPIDefinition(
        info = @Info(
                title = "Debts API",
                version = "1.0",
                description = "Debts Information",
                contact = @Contact(name = "Lívia Silva Santos")
        )
)
public class DebtController {

    private final GetAllDebts getAllDebts;
    private final GetDebtById getDebtById;
    private final SaveDebt saveDebt;
    private final DeleteDebtById deleteDebtById;
    private final RenegotiateDebt renegotiateDebt;

    private final DebtDomainConverter debtDomainConverter;
    private final RenegotiationDomainConverter renegotiationDomainConverter;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DebtResponseJson> findById(@PathVariable("id") final String id) {
        val debt = getDebtById.execute(id);
        return ResponseEntity.ok(DebtResponseJson.of(debt));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DebtResponseJson>> findAll(@RequestParam(value = "page", defaultValue = "0") final int page,
                                                          @RequestParam(value = "size", defaultValue = "5") final int size) {
        val debts = getAllDebts.execute(PageRequest.of(page, size));
        val debtsJson = debts.stream()
                .map(catalog -> DebtResponseJson.of(catalog))
                .collect(Collectors.toList());
        return ResponseEntity.ok(debtsJson);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DebtResponseJson> save(@RequestBody @Valid final DebtJson debtJson) {
        val debt = saveDebt.execute(debtDomainConverter.convert(debtJson));
        return ResponseEntity.created(buildCustomerUri(debt)).body(DebtResponseJson.of(debt));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable(value = "id") final String id) {
        deleteDebtById.execute(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{id}/renegotiation", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DebtResponseJson> renegotiation(@PathVariable(value = "id") final String id,
            @RequestBody @Valid final RenegotiationJson renegotiationJson) {
        val debt = renegotiateDebt.execute(id, renegotiationDomainConverter.convert(renegotiationJson));
        return ResponseEntity.accepted().body(DebtResponseJson.of(debt));
    }

    private static URI buildCustomerUri(final Debt debt) {
        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(debt.getId())
                .toUri();
        return uri;
    }
}

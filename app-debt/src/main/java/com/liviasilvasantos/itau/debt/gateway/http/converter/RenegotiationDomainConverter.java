package com.liviasilvasantos.itau.debt.gateway.http.converter;

import com.liviasilvasantos.itau.debt.domain.Renegotiation;
import com.liviasilvasantos.itau.debt.gateway.http.json.RenegotiationJson;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class RenegotiationDomainConverter implements Converter<RenegotiationJson, Renegotiation> {

    @Override
    public Renegotiation convert(final RenegotiationJson renegotiationJson) {
        return Renegotiation.builder()
                .totalRenegotiationValueInCents(renegotiationJson.getTotalRenegotiationValueInCents())
                .catalogId(renegotiationJson.getCatalogId())
                .createdAt(LocalDateTime.now())
                .build();
    }

}

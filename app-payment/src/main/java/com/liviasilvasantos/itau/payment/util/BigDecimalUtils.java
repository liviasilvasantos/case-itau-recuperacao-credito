package com.liviasilvasantos.itau.payment.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BigDecimalUtils {

    public static BigDecimal centsToBigDecimal(final Long cents) {
        return Optional.ofNullable(cents)
                .map(c -> BigDecimal.valueOf(c).movePointLeft(2))
                .orElse(null);
    }

    public static Long bigDecimalToCents(final BigDecimal value) {
        return Optional.ofNullable(value)
                .map(v -> v.movePointRight(2).longValue())
                .orElse(null);
    }
}

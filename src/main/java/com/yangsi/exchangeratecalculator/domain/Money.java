package com.yangsi.exchangeratecalculator.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class Money {

    private final BigDecimal value;
    private final CountryEnum country;

    public static Money of(double amount, CountryEnum country) {
        return new Money(BigDecimal.valueOf(amount), country);
    }

    public Money exchange(String exchangeRate, CountryEnum country) {
        BigDecimal big = new BigDecimal(exchangeRate);
        return Money.of(big.multiply(value).doubleValue(), country);
    }
}

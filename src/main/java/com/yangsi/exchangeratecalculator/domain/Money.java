package com.yangsi.exchangeratecalculator.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Money {

    private final BigDecimal value;
    private final CountryEnum country;

    public static Money of(double amount, CountryEnum country) {
        if(amount<=0){
            throw new IllegalArgumentException("유효하지않은 돈입니다.");
        }
        return new Money(BigDecimal.valueOf(amount), country);
    }

    public Money exchange(String exchangeRate, CountryEnum country) {
        BigDecimal big = new BigDecimal(exchangeRate);
        return Money.of(big.multiply(value).doubleValue(), country);
    }
}

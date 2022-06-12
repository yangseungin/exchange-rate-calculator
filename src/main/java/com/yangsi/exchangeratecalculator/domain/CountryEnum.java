package com.yangsi.exchangeratecalculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CountryEnum {
    한국("KRW"),
    일본("JPY"),
    필리핀("PHP"),
    미국("USD");

    private final String code;

    CountryEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static CountryEnum remittanceCountry() {
        return CountryEnum.미국;
    }

    public static List<CountryEnum> recipientCountries() {
        return Arrays.stream(values())
                .filter(countryEnum -> countryEnum != remittanceCountry())
                .collect(Collectors.toList());
    }

    public static CountryEnum getCountry(String code) {
        return Arrays.stream(values())
                .filter(countryEnum -> countryEnum.code.equals(code))
                .findFirst()
                .get();
    }

}

package com.yangsi.exchangeratecalculator.domain;

public enum ExchangeRate {
    USDKRW("USDKRW", "KRW", "KRW/USD"),
    USDJPY("USDJPY", "JPY", "JPY/USD"),
    USDPHP("USDPHP", "PHP", "PHP/USD");

    private final String key;
    private final String country;
    private final String unit;

    ExchangeRate(String key, String country, String unit) {
        this.key = key;
        this.country = country;
        this.unit = unit;
    }

    public String getKey() {
        return key;
    }

    public String getCountry() {
        return country;
    }
}

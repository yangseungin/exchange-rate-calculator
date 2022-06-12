package com.yangsi.exchangeratecalculator.domain;

public enum ExchangeRate {
    USDKRW("USDKRW", "한국(KRW)", "KRW/USD"),
    USDJPY("USDJPY", "일본(JPY)", "JPY/USD"),
    USDPHP("USDPHP", "필리핀(PHP)", "PHP/USD");

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
}

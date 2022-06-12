package com.yangsi.exchangeratecalculator.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExchangeRateDTO {
    @Getter
    @Setter
    public static class Request {
        private String remittance;
        private String recipient;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response {
        private String remittance;
        private String recipient;
        private String exchangeRate;
    }
}

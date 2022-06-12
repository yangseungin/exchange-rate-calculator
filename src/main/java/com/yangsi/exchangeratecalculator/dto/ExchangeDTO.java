package com.yangsi.exchangeratecalculator.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
public class ExchangeDTO {
    @Getter
    @Setter
    public static class Request {
        private String remittance;
        private String recipient;
        private String exchangeRate;
        private int remittanceAmount;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Response {
        private final String resultValue;
        private final String resultCurrency;
    }
}
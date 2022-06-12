package com.yangsi.exchangeratecalculator.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

@Data
@RequiredArgsConstructor
public class ExchangeDTO {
    private static final String INVALID_REMITTANCE_AMOUNT = "송금액이 바르지 않습니다.";

    @Getter
    @Setter
    public static class Request {
        private String remittance;
        private String recipient;
        private String exchangeRate;
        @Max(value = 10000, message = INVALID_REMITTANCE_AMOUNT)
        @Positive(message = INVALID_REMITTANCE_AMOUNT)
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

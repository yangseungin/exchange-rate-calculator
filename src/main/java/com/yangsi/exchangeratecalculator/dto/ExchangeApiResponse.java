package com.yangsi.exchangeratecalculator.dto;

import java.util.Map;

public class ExchangeApiResponse {
    private boolean success;
    private String source;
    private Map<String, Double> quotes;

    public boolean isSuccess() {
        return success;
    }

    public String getSource() {
        return source;
    }

    public Map<String, Double> getQuotes() {
        return quotes;
    }

    @Override
    public String toString() {
        return "ExchangeApiResponse{" +
                "success=" + success +
                ", source='" + source + '\'' +
                ", quotes=" + quotes +
                '}';
    }

}

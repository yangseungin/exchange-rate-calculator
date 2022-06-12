package com.yangsi.exchangeratecalculator.service;

import com.yangsi.exchangeratecalculator.domain.CountryEnum;
import com.yangsi.exchangeratecalculator.domain.Money;
import com.yangsi.exchangeratecalculator.dto.ExchangeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.yangsi.exchangeratecalculator.util.FormatUtils.exchangeRateFormat;
import static com.yangsi.exchangeratecalculator.util.FormatUtils.removeComma;

@Service
@RequiredArgsConstructor
public class ExchangeService {
    public ExchangeDTO.Response exchangeMoney(ExchangeDTO.Request request) {
        Money source = Money.of(request.getRemittanceAmount(), CountryEnum.getCountry(request.getRemittance()));
        Money exchange = source.exchange(removeComma(request.getExchangeRate()),
                CountryEnum.getCountry(request.getRecipient()));

        return new ExchangeDTO.Response(exchangeRateFormat(exchange.getValue()), CountryEnum.getCountry(request.getRecipient()).getCode());
    }

}

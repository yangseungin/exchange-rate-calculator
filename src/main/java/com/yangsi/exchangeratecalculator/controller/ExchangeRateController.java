package com.yangsi.exchangeratecalculator.controller;

import com.yangsi.exchangeratecalculator.domain.ExchangeRate;
import com.yangsi.exchangeratecalculator.dto.ExchangeApiResponse;
import com.yangsi.exchangeratecalculator.dto.ExchangeRateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ExchangeRateController {

    @Value("${api.key}")
    private String apiKey;
    @Value("${api.url}")
    private String apiUrl;
    private final RestTemplate restTemplate;
    private final RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/exchangeRates")
    @ResponseBody
    public ExchangeRateDTO.Response exchangeRates(ExchangeRateDTO.Request request) {
        return Arrays.stream(ExchangeRate.values())
                .filter(exchangeRate -> exchangeRate.getCountry().equals(request.getRecipient()))
                .map(exchangeRate -> new ExchangeRateDTO.Response(request.getRemittance(),
                        request.getRecipient(),
                        exchangeRateFormat(redisTemplate.opsForHash().get("exchange", exchangeRate.getKey()))))
                .collect(Collectors.toList()).get(0);

    }

    @GetMapping("/exchangeCall")
    public String getExchange() {
        ExchangeApiResponse result = apiCall();
        saveRedis(result);
        return result.getQuotes().toString();
    }

    private String exchangeRateFormat(Object val) {
        return new DecimalFormat("#,###.00").format(val);
    }

    private ExchangeApiResponse apiCall() {
        ResponseEntity<ExchangeApiResponse> exchange = restTemplate.exchange(apiUrl + "?source=USD&currencies=KRW,JPY,PHP",
                HttpMethod.GET,
                new HttpEntity<>(getHttpHeaders()),
                ExchangeApiResponse.class);
        return exchange.getBody();
    }

    private void saveRedis(ExchangeApiResponse body) {
        HashOperations<String, String, Double> hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll("exchange", body.getQuotes());
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.add("apiKey", apiKey);
        return requestHeaders;
    }
}

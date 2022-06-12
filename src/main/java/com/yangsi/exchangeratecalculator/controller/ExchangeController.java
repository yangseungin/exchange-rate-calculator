package com.yangsi.exchangeratecalculator.controller;

import com.yangsi.exchangeratecalculator.domain.CountryEnum;
import com.yangsi.exchangeratecalculator.dto.ExchangeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ExchangeController {

    @PostMapping("/exchange")
    public ResponseEntity<ExchangeDTO.Response> receivableAmount(@RequestBody ExchangeDTO.Request request) {
        //TODO 환율계산로직 추가

        return ResponseEntity.ok().body(new ExchangeDTO.Response("143.44", CountryEnum.일본.getCode()));
    }
}

package com.yangsi.exchangeratecalculator.controller;

import com.yangsi.exchangeratecalculator.dto.ExchangeDTO;
import com.yangsi.exchangeratecalculator.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;

    @PostMapping("/exchange")
    public ResponseEntity<ExchangeDTO.Response> exchange(@RequestBody @Valid ExchangeDTO.Request request) {
        return ResponseEntity.ok().body(exchangeService.exchangeMoney(request));
    }
}

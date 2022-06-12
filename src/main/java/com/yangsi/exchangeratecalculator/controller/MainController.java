package com.yangsi.exchangeratecalculator.controller;

import com.yangsi.exchangeratecalculator.domain.CountryEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("remittanceCountry", CountryEnum.remittanceCountry());
        model.addAttribute("recipientCountries", CountryEnum.recipientCountries());
        return "index";
    }
}

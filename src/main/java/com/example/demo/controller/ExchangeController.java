package com.example.demo.controller;

import com.example.demo.common.Currency;
import com.example.demo.service.PayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency")
public class ExchangeController {

    private final PayService payService;

    public ExchangeController(PayService payService) {
        this.payService = payService;
    }

    @PostMapping("/convert")
    public String convertCurrency(
            @RequestParam String currency,
            @RequestParam int amount) {

        double result = payService.exchangeToDollar(Currency.USD, amount);
        return String.format("Received request to convert %d %s", amount, currency + "and result: " + result);

        //POST http://localhost:8080/api/currency/convert?currency=USD&amount=100
    }
}

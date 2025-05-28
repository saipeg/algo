package com.example.demo.service;

import com.example.demo.common.Currency;
import org.springframework.stereotype.Service;

@Service
public class PayService {
    Currency currency;
    public double exchangeToDollar(Currency currency, int amount) {
        int code = currency.getCode();
        double indexForCode = getIndexForCode(code);

        return amount * indexForCode;

    }

    private double getIndexForCode(final int code) {
        return 1.3;
    }
}

package com.example.demo.service;

import com.example.demo.common.Currency;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PayServiceTest {

    PayService payService = new PayService();

    @Test
    void shouldReturnIndexWhenNotNull() {
        double resultOfDollar = payService.exchangeToDollar(Currency.USD, 10);

        assertEquals(13, resultOfDollar);
    }

}
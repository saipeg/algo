package com.example.demo.common;

import java.util.Currency;

public enum Сurrency {
    USD("Доллар", "$", 840),
    EUR("Евро", "€", 840),
    RUB("Рубль", "₽", 840);

    private final String name;
    private final String symbol;
    private final int code;

    Сurrency(String name, String symbol, int code) {
        this.name = name;
        this.symbol = symbol;
        this.code = code;
    }

    public String getDisplayName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getСode() {
        return code;
    }

}

package com.example.demo.common;

public enum Currency {
    USD("Доллар", "$", 840),
    EUR("Евро", "€", 840),
    RUB("Рубль", "₽", 840);

    private final String name;
    private final String symbol;
    private final int code;

    Currency(String name, String symbol, int code) {
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

package com.example.demo.common;

public enum NaminalForRubles {
    Fifty(50),
    Hundred(100),
    Five_hundred(500),
    Thousand(1000),
    Five_thousand(5000);

    private final int digital;

    NaminalForRubles(int digital) {
        this.digital = digital;
    }

    public int getAmountInNumbers() {
        return digital;
    }

}

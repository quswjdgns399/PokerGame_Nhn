package com.nhnacademy.java.poker;

public enum CardShape {

    SPA("Spade"),
    DiA("Dia"),
    HEA("Heart"),
    CLO("Clober");

    public final String cardShape;

    CardShape(String cardShape) {
        this.cardShape = cardShape;
    }

    public String toString() {
        return this.cardShape;
    }

}

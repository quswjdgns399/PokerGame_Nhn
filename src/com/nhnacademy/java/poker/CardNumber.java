package com.nhnacademy.java.poker;

public enum CardNumber {
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(8),
    Ten(10),
    J(11),
    Q(12),
    K(13),
    A(14);

    public final int cardNumber;

    CardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String toString() {
        return String.valueOf(this.cardNumber);
    }
}

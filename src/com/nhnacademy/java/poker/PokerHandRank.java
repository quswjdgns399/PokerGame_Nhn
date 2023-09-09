package com.nhnacademy.java.poker;

public enum PokerHandRank {

    HIGH_CARD("High Card"),
    TWO_PAIR("Two Pair"),
    ONE_PAIR("One Pair");

    private final String displayName;

    PokerHandRank(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

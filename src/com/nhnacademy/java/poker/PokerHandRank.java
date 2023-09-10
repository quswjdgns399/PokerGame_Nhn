package com.nhnacademy.java.poker;

public enum PokerHandRank {


    // Rank가 높을 수록 높은 수
    HIGH_CARD(0),
    ONE_PAIR(1),
    TWO_PAIR(2);


    private final int rank;

    PokerHandRank(int displayName) {
        this.rank = displayName;
    }

    public int getRank() {
        return rank;
    }
}

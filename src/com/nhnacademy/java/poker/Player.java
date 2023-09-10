package com.nhnacademy.java.poker;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> handCard;
    private String name;
    private PokerHandRank handRank;

    public Player(String name) {
        this.name = name;
        handCard = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getHandCard() {
        return handCard;
    }

    public PokerHandRank getHandRank() {
        return handRank;
    }

    public void receiveCard(String card) {
        handCard.add(card);
    }

    public void printCard() {
        for (String card : handCard) {
            System.out.println(card);
        }
    }


    // handcard에서 가장 높은 숫자 반환
    public int getHighestCardValue() {
        int highestValue = -1;
        for (String card : handCard) {
            int cardValue = getCardValue(card);
            if (cardValue > highestValue) {
                highestValue = cardValue;
            }
        }
        return highestValue;
    }


    public void checkRank() {

        // One Pair, Two Pair, High Card Check
        int[] cardCounts = new int[15];
        for (String card : handCard) {
            int cardValue = getCardValue(card);
            cardCounts[cardValue]++;
        }

        boolean hasPair = false;
        boolean hasTwoPair = false;

        for (int i = 2; i <= 14; i++) {
            if (cardCounts[i] == 2) {
                if (hasPair) {
                    hasTwoPair = true;
                } else {
                    hasPair = true;
                }
            }
        }

        if (hasTwoPair) {
            handRank = PokerHandRank.TWO_PAIR;
        } else if (hasPair) {
            handRank = PokerHandRank.ONE_PAIR;
        } else {
            handRank = PokerHandRank.HIGH_CARD;
        }
        System.out.println(handRank);
    }


    private int getCardValue(String card) {
        return Integer.parseInt(card.split(" ")[1]);
    }
}

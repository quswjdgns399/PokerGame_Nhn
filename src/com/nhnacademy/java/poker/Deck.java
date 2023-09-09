package com.nhnacademy.java.poker;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<String> deck;

    public Deck() {
        deck = new ArrayList<>(52);
        resetCard();
    }

    public void resetCard() {
        deck.clear();
        for (CardShape cardShape : CardShape.values()) {
            for (CardNumber cardNumber : CardNumber.values()) {
                String cardString = cardShape + " " + cardNumber;
                deck.add(cardString);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public String dealCard() {
        if (deck.isEmpty()) {
            System.out.println("No cards left in the deck.");
            return null;
        }
        return deck.remove(0);
    }
}

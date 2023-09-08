package com.nhnacademy.java.poker;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {

    private static String cardShape;
    private static int cardNum;
    private static String[] handCard;

    public static void resethandCard() {
        handCard = new String[1];
        handCard[0] = String.valueOf(1);
    }

    public static void receiveCard() {
        handCard = Card.distributionCard();
        printCard();
    }

    public Player() {
    }

    public Player(ArrayList<String> cards) {

        handCard[0] = String.valueOf(cards);
    }

    public static void printCard() {
        System.out.println(Arrays.toString(handCard));
    }


    void Player(String cardShape, int cardNum) {
        this.cardShape = cardShape;
        this.cardNum = cardNum;
    }
}

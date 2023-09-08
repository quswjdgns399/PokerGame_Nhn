package com.nhnacademy.java.poker;

import java.util.ArrayList;
import java.util.Collections;

public class Card {

//    private static String[] cardShape;
//    private static String[] cardNumber;
//
//    private static String[] card;

    private static ArrayList<String> card;
    private static String[] handCard;


    //    public static void resetCard() {
//        cardShape = new String[4];
//        cardNumber = new String[14];
//        card = new String[13];
//
//        for (int i = 0; i < cardShape.length; i++) {
//            cardShape[i] = Arrays.toString(CardShape.values());
//        }
//
//        for (int i = 0; i < cardNumber.length; i++) {
//            cardNumber[i] = Arrays.toString(CardNumber.values());
//        }
//
//        for (int i = 0; i < 13; i++) {
//            card[i] = Arrays.toString(new String[] {cardShape[i], cardNumber[i]});
//        }
//    }

    public static void resetCard() {
        card = new ArrayList<>(52);

        for (CardShape cardShape : CardShape.values()) {
            for (CardNumber cardNumber : CardNumber.values()) {
                String cardString = cardShape + " " + cardNumber;
                card.add(cardString);
            }
        }
    }

    public static void deleteCard(int num) {
        card.remove(num);
    }

    //deleteCard 확인
    public static void beforedistribution() {
        System.out.println(card);
    }

    //deleteCard 확인
    public static void afterdistribution() {
        for (int i = 0; i < card.size(); i++) {
            if (card.contains(handCard[0])) {
                System.out.println("안지워짐");
            }
        }
    }

    public static String[] distributionCard() {

        handCard = new String[1];
        handCard[0] = String.valueOf(1);

        Collections.shuffle(card);

        ArrayList<String> cards = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cards.add(card.get(i));
            deleteCard(i);
        }
        handCard[0] = String.valueOf(cards);
        return handCard;
    }


}

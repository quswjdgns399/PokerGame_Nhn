package com.nhnacademy.java.poker;

import java.util.Scanner;

public class PokerGame {

    //게임시작 - 테이블리셋 - 입력받은 값 만큼 플레이어 생성 - 카드더미에서 램덤으로 카드 배분(배분된 카드는 더미에서 삭제)
    // - 카드더미에서 램덤으로 테이블에 카드 추가(추가된 카드는 더미에서 삭제) 5번 - 플에이어 카드와 테이블 카드를 비교해 Rank측정
    // - 랭크에 따라 우승자 출력

    private static String[] tableCard;

    public static void resetTable() {//tableCard에 임의값을 넣어 초기화
        tableCard = new String[5];
        for (int i = 0; i < tableCard.length; i++) {
            tableCard[i] = String.valueOf(i);
        }
    }


    public static void distrbutionCard() {

    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        resetTable();
        Player.resethandCard();


//        System.out.println(" ( Max = 5 ) : ");
//        int numberOfPlayer = sc.nextInt();
//        Player.setPlayer(numberOfPlayer);
//        distrbutionCard();

        Card.resetCard();
//        Card.distributionCard();
//        Player.printCard();

        Player player1 = new Player();
        Player player2 = new Player();

        player1.receiveCard();
        player2.receiveCard();


    }
}

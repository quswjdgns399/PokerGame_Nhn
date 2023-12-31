package com.nhnacademy.java.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokerGame {

    //게임시작 -
    // 입력받은 값 만큼 플레이어 생성 (생성자 생성 시 각자 다른 card를 가져야 함)
    // - 카드더미에서 램덤으로 카드 배분(배분된 카드는 더미에서 삭제)
    // - 카드더미에서 램덤으로 테이블에 카드 추가(추가된 카드는 더미에서 삭제) 5번 - 플에이어 카드와 테이블 카드를 비교해 Rank측정
    // - 랭크에 따라 우승자 출력
    private List<Player> players;
    private Deck cardDeck; // 52장의 카드 덱


    //table card 없이 구현.
    public PokerGame() { //플레이어 리스트와 덱 초기화
        players = new ArrayList<>();
        cardDeck = new Deck();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        cardDeck.resetDeck();
        cardDeck.shuffle();

        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                String card = cardDeck.dealDeck();
                if (card != null) {
                    player.receiveCard(card);
                }
            }
        }

        for (Player player : players) {
            System.out.println("==========================");
            System.out.println("Player " + player.getName() + "'s Hand:");
            player.printCard();
            System.out.print("Hand Rank : ");
            player.checkRank();
            System.out.println("==========================");
            System.out.println();
        }

        Player winner = checkWinner();

        if (winner != null) {
            System.out.println("<WINNER : " + winner.getName() + ">");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private Player checkWinner() {
        Player winner = null;
        int highestRankValue = -1; // 가장 높은 랭크의 값을 저장할 변수 초기화

        for (Player player : players) {
            player.checkRank();
            PokerHandRank playerRank = player.getHandRank();

            //Rank에 중복이 없을 때
            if (playerRank.getRank() > highestRankValue) {
                highestRankValue = playerRank.getRank();
                winner = player;

                // High_Card player가 2명 이상인 경우
            } else if (playerRank == PokerHandRank.HIGH_CARD
                    && highestRankValue == PokerHandRank.HIGH_CARD.getRank()) {

                int playerHighestCardValue0 = player.getHighestCardValue();
                int winnerHighestCardValue0 = winner.getHighestCardValue();

                if (playerHighestCardValue0 > winnerHighestCardValue0) {
                    winner = player;
                }
                // One_Pair player가 2명 이상인 경우
            } else if (playerRank.getRank() >= PokerHandRank.ONE_PAIR.getRank() &&
                    highestRankValue >= PokerHandRank.ONE_PAIR.getRank()) {

                int playerHighestCardValue1 = player.getHighestCardValue();
                int winnerHighestCardValue1 = winner.getHighestCardValue();

                if (playerHighestCardValue1 > winnerHighestCardValue1) {
                    winner = player;
                }
                // Two_Pair player가 2명 이상인 경우
            } else if (playerRank.getRank() >= PokerHandRank.TWO_PAIR.getRank() &&
                    highestRankValue >= PokerHandRank.TWO_PAIR.getRank()) {

                int playerHighestCardValue2 = player.getHighestCardValue();
                int winnerHighestCardValue2 = winner.getHighestCardValue();

                if (playerHighestCardValue2 > winnerHighestCardValue2) {
                    winner = player;
                }
            }

        }
        return winner;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========================");
        System.out.println("<WELCOME TO POKER GAME>");
        System.out.printf("Enter the number of players : ");

        int numberOfPlayers = sc.nextInt();
        sc.nextLine();

        System.out.println("==========================");

        PokerGame game = new PokerGame();

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter Player " + i + "'s name: ");
            String playerName = sc.nextLine();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }

        game.startGame();

        sc.close();
    }
}

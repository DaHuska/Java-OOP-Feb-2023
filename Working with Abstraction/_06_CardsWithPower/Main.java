package com.company._06_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String cardRank = scan.nextLine();
        String cardSuit = scan.nextLine();

        Card.Ranks rank = Card.Ranks.valueOf(cardRank);
        Card.Suits suit = Card.Suits.valueOf(cardSuit);

        printCardInfo(rank, suit);
    }

    public static void printCardInfo(Card.Ranks rank, Card.Suits suit) {
        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, calculatePower(rank, suit));
    }

    public static int calculatePower(Card.Ranks rank, Card.Suits suit) {
        return rank.getPower() + suit.getPower();
    }
}

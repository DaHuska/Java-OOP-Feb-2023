package com.company._05_Card;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        switch (input[1]) {
            case "Suits":
                System.out.println("Card Suits:");

                Suits[] suits = Suits.values();

                for (Suits suit : suits) {
                    System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit);
                }
                break;
            case "Ranks":
                System.out.println("Card Ranks:");

                Ranks[] ranks = Ranks.values();

                for (Ranks rank : ranks) {
                    System.out.printf("Ordinal value: %d; Name value: %s%n", rank.ordinal(), rank);
                }
                break;
        }
    }
}

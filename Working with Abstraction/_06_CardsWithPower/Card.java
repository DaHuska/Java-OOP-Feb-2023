package com.company._06_CardsWithPower;

public class Card {
    public enum Ranks {
        ACE(14),
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13);

        private int power;

        Ranks(int power) {
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }

    public enum Suits {
        CLUBS(0),
        DIAMONDS(13),
        HEARTS(26),
        SPADES(39);

        private int power;

        Suits(int power) {
            this.power = power;
        }

        public int getPower() {
            return power;
        }
    }
}

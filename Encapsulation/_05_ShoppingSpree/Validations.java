package com.company.Encapsulation._05_ShoppingSpree;

public class Validations {
    public static boolean validateName(String name) {
        return !name.trim().isEmpty();
    }

    public static boolean validateMoney(double money) {
        return money >= 0;
    }
}

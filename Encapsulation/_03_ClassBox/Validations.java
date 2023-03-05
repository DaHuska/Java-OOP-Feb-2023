package com.company.Encapsulation._03_ClassBox;

public class Validations {
    public static boolean validateSide(double side) {
        if (side <= 0) {
            return false;
        }

        return true;
    }
}

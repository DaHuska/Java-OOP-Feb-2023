package com.company.Encapsulation._06_PizzaCalories;

public class Validations {
    public static boolean validateFlour(String flour) {
        return flour.equals("White") || flour.equals("Wholegrain");
    }

    public static boolean validateTechnique(String technique) {
        return technique.equals("Crispy") || technique.equals("Chewy") || technique.equals("Homemade");
    }

    public static boolean validateDoughWeight(double weight) {
        return weight >= 1 && weight <= 200;
    }

    public static boolean validateTopping(String topping) {
        return topping.equals("Meat") || topping.equals("Veggies") || topping.equals("Cheese") || topping.equals("Sauce");
    }

    public static boolean validateToppingWeight(double weight) {
        return weight >= 1 && weight <= 50;
    }

    public static boolean validateToppingsNumber(int count) {
        return count >= 0 && count <= 10;
    }

    public static boolean validatePizzaName(String name) {
        return !name.trim().isEmpty() && name.length() <= 15;
    }
}

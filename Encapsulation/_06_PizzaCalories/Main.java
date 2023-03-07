package com.company.Encapsulation._06_PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] pizzaTokens = scan.nextLine().split("\\s+");
        String pizzaName = pizzaTokens[1];
        int numberOfToppings = Integer.parseInt(pizzaTokens[2]);

        String[] doughTokens = scan.nextLine().split("\\s+");
        String flourType = doughTokens[1];
        String bakingTechnique = doughTokens[2];
        double doughWeight = Double.parseDouble(doughTokens[3]);

        Pizza pizza = null;
        Dough dough = null;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
            dough = new Dough(flourType, bakingTechnique, doughWeight);

            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] toppingTokens = scan.nextLine().split("\\s+");
        while (!toppingTokens[0].equals("END")) {
            String toppingType = toppingTokens[1];
            double toppingWeight = Double.parseDouble(toppingTokens[2]);

            Topping topping = null;
            try {
                topping = new Topping(toppingType, toppingWeight);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            pizza.addTopping(topping);

            toppingTokens = scan.nextLine().split("\\s+");
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }

    // 91/100
}

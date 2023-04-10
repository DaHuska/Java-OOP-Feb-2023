package com.company.Encapsulation._06_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
    }

    private void setToppings(int numberOfToppings) {
        if (!Validations.validateToppingsNumber(numberOfToppings)) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.toppings = new ArrayList<>();
    }

    private void setName(String name) {
        if (!Validations.validatePizzaName(name)) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }

        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        return calculateOverallCalories();
    }

    private double calculateOverallCalories() {
        double overallCalories = 0;

        overallCalories += dough.calculateCalories();

        for (Topping topping : this.toppings) {
            overallCalories += topping.calculateCalories();
        }

        return overallCalories;
    }

    public String getName() {
        return name;
    }
}

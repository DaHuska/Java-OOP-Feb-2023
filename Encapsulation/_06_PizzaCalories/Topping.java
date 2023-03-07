package com.company.Encapsulation._06_PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        if (!Validations.validateTopping(toppingType)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.%n", toppingType));
        }

        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        if (!Validations.validateToppingWeight(weight)) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].%n", this.toppingType));
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        double toppingModifier = 0;

        switch (this.toppingType) {
            case "Meat":
                toppingModifier = 1.2;
                break;
            case "Veggies":
                toppingModifier = 0.8;
                break;
            case "Cheese":
                toppingModifier = 1.1;
                break;
            case "Sauce":
                toppingModifier = 0.9;
                break;
        }

        return (2 * this.weight) * toppingModifier;
    }
}

package com.company.Encapsulation._05_ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    private void setName(String name) {
        if (!Validations.validateName(name)) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setCost(double cost) {
        if (!Validations.validateMoney(cost)) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }
}

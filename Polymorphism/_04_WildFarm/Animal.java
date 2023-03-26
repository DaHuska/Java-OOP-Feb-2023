package com.company.Polymorphism._04_WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private static final DecimalFormat format = new DecimalFormat("#.##");
    private String name;
    private String type;
    private double weight;
    private Integer foodEaten;

    public Animal(String type, String name, double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.foodEaten = 0;
    }

    protected abstract void makeSound();
    protected abstract void eat(Food food);
    public abstract String toString();

    protected void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected Integer getFoodEaten() {
        return foodEaten;
    }

    protected String getAnimalType() {
        return type;
    }

    protected String getName() {
        return name;
    }

    protected String getType() {
        return type;
    }

    protected double getWeight() {
        return weight;
    }

    protected static DecimalFormat getFormat() {
        return format;
    }
}

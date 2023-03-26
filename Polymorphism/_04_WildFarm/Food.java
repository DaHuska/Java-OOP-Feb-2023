package com.company.Polymorphism._04_WildFarm;

public abstract class Food {
    private int quantity;
    private String type;

    protected Food(int quantity) {
        this.quantity = quantity;
    }

    public void setFoodType(String type) {
        this.type = type;
    }

    protected int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }
}

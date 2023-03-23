package com.company.Polymorphism._03_Animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        setName(name);
        setFavouriteFood(favouriteFood);
    }

    public abstract String explainSelf();

    public void setName(String name) {
        this.name = name;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    protected String getName() {
        return name;
    }

    protected String getFavouriteFood() {
        return favouriteFood;
    }
}

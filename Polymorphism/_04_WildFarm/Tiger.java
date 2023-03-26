package com.company.Polymorphism._04_WildFarm;

public class Tiger extends Felime {
    public Tiger(String type, String name, double weight, String livingRegion) {
        super(type, name, weight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    protected void eat(Food food) {
        if (!food.getType().equals("Meat")) {
            throw new IllegalStateException(String.format("%ss are not eating that type of food!", getAnimalType()));
        }

        setFoodEaten(food.getQuantity());
    }
}

package com.company.Polymorphism._04_WildFarm;

public class Cat extends Felime {
    private String breed;

    public Cat(String type, String name, double weight, String livingRegion, String breed) {
        super(type, name, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eat(Food food) {
        setFoodEaten(food.getQuantity());
    }

    private String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]%n", getAnimalType(), getName(), getBreed(), getFormat().format(getWeight()), getLivingRegion(), getFoodEaten());
    }
}

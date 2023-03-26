package com.company.Polymorphism._04_WildFarm;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String type, String name, double weight, String livingRegion) {
        super(type, name, weight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]%n", getAnimalType(), getName(), getFormat().format(getWeight()), getLivingRegion(), getFoodEaten());
    }
}
